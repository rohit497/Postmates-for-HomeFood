package com.team15.rohitslist;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.util.Log;

/**
 * Created by RohitRamesh on 2/6/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    SQLiteDatabase db;
    private static final String LOG = "DatabaseHelper";

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "Rohitslist.db";

    // Table Names
    private static final String TABLE_PERSON = "Person";
    private static final String TABLE_ORDERS = "Orders";
    private static final String TABLE_SELLER = "Seller";

    // Common column names
    private static final String name = "name";
    private static final String email = "email";
    private static final String pass = "pass";
    private static final String type = "type";

    // NOTES Table - column nmaes
    private static final String Semail = "Semail";
    private static final String location = "location";
    private static final String typeCuisine = "typeCuisine";
    private static final String item1 = "item1";
    private static final String item2 = "item2";
    private static final String item3 = "item3";
    private static final String item4 = "item4";
    private static final String price1 = "price1";
    private static final String price2 = "price2";
    private static final String price3 = "price3";
    private static final String price4 = "price4";

    // TAGS Table - column names
    private static final String KEY_ID = "_id";
    private static final String buyerEmail = "buyerEmail";
    private static final String sellerEmail = "sellerEmail";
    private static final String q1 = "q1";
    private static final String q2 = "q2";
    private static final String q3 = "q3";
    private static final String q4 = "q4";
    private static final String totalPrice = "totalPrice";
    private static final String done = "done";

    // Table Create Statements
    // Todo table create statement
    private static final String CREATE_TABLE_PERSON = "CREATE TABLE "
            + TABLE_PERSON + "(" + email + " TEXT PRIMARY KEY," + name
            + " TEXT," + pass + " TEXT," + type
            + " TEXT" + ")";

    // Tag table create statement
    private static final String CREATE_TABLE_SELLER = "CREATE TABLE " + TABLE_SELLER
            + "(" + Semail + " TEXT PRIMARY KEY," + location + " TEXT,"
            + typeCuisine + " TEXT," + item1 + " INTEGER," + item2 + " INTEGER,"
            + item3 + " INTEGER," + item4 + " INTEGER," + price1 + " INTEGER," + price2 + " INTEGER,"
            + price3 + " INTEGER," + price4 + " INTEGER" +")";

    // todo_tag table create statement
    private static final String CREATE_TABLE_ORDERS = "CREATE TABLE "
            + TABLE_ORDERS + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + sellerEmail + " TEXT," + buyerEmail + " TEXT,"
            + q1 + " INTEGER," + q2+ " INTEGER," + q3 + " INTEGER,"
            + q4 + " INTEGER," + totalPrice + " INTEGER," + done + " INTEGER" + ")";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // creating required tables
        db.execSQL(CREATE_TABLE_PERSON);
        db.execSQL(CREATE_TABLE_SELLER);
        db.execSQL(CREATE_TABLE_ORDERS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PERSON);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SELLER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ORDERS);

        // create new tables
        onCreate(db);
    }

    public String getPassword(String uname) {
        db = this.getReadableDatabase();
        String query = "SELECT pass FROM " + TABLE_PERSON + " WHERE email = " + "'"+uname+"'";
        Cursor c = db.rawQuery(query, null);
        Log.d("lol", c.toString());
        if (c.getCount() == 0) {
            //db.close();
            return "No such user";
        }
        //db.close();
        c.moveToFirst();
        return c.getString(0);
    }

    public void insertPerson(Person p) {
        db = this.getWritableDatabase();
        ContentValues val = new ContentValues();
        val.put(name, p.getName());
        val.put(email, p.getEmail());
        val.put(pass, p.getPass());
        val.put(type, p.getType());
        db.insert(TABLE_PERSON, null, val);
        db.close();
    }
}
