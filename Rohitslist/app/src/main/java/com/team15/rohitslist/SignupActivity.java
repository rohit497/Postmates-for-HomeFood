package com.team15.rohitslist;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import android.widget.EditText;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.RadioButton;


/**
 * Created by RohitRamesh on 2/5/2016.
 */
public class SignupActivity extends Activity {

    DatabaseHelper db = new DatabaseHelper(this);
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }

    public void onButtonClick (View v) {
        EditText name = (EditText) findViewById(R.id.NameText);
        EditText email = (EditText) findViewById(R.id.EmailText);
        EditText password = (EditText) findViewById(R.id.passwordText);
        EditText confirmpassword = (EditText) findViewById(R.id.confirmPasswordText);
        RadioGroup rg = (RadioGroup) findViewById(R.id.radioButtonGroup);

        String namestr = name.getText().toString();
        String emailstr = email.getText().toString();
        String passstr = password.getText().toString();
        String confirmpassstr = confirmpassword.getText().toString();
        String type = "";
        int id = rg.getCheckedRadioButtonId();
        if (id == -1){
            Toast popup = Toast.makeText(SignupActivity.this, "Pick a category", Toast.LENGTH_SHORT);
            popup.show();
        }
        else{
            View radioButton = rg.findViewById(id);
            int idx = rg.indexOfChild(radioButton);
            RadioButton r = (RadioButton) rg.getChildAt(idx);
            type = r.getText().toString();
        }

        if(!passstr.equals(confirmpassstr)) {
            Toast popup = Toast.makeText(SignupActivity.this, "Passwords must match", Toast.LENGTH_SHORT);
            popup.show();
        }
        else {
            Person p = new Person();
            p.setName(namestr);
            p.setEmail(emailstr);
            p.setPass(passstr);
            p.setType(type);

            db.insertPerson(p);
        }
    }
}
