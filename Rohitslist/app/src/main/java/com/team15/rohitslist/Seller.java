package com.team15.rohitslist;

/**
 * Created by RohitRamesh on 2/6/2016.
 */
public class Seller {
    String Semail, location, typeCuisine, item1, item2, item3, item4;
    int price1, price2, price3, price4;

    public void setEmail(String email) {
        this.Semail = email;
    }
    public String getEmail() {
        return this.Semail;
    }
    public void setLocation(String loc) {
        this.location = loc;
    }
    public String getLocation() {
        return this.location;
    }
    public void setCuisine(String cuisine) {
        this.typeCuisine = cuisine;
    }
    public String getCuisine() {
        return this.typeCuisine;
    }
    public void setItem1(String item1) {
        this.item1 = item1;
    }
    public String getItem1() {
        return this.item1;
    }
    public void setItem2(String item2) {
        this.item2 = item2;
    }
    public String getItem2() {
        return this.item2;
    }
    public void setItem3(String item3) {
        this.item3 = item3;
    }
    public String getItem3() {
        return this.item3;
    }
    public void setItem4(String item4) {
        this.item1 = item4;
    }
    public String getItem4() {
        return this.item4;
    }
}
