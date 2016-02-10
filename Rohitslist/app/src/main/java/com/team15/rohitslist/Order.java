package com.team15.rohitslist;

/**
 * Created by RohitRamesh on 2/6/2016.
 */
public class Order {
    String buyerEmail, sellerEmail;
    int q1, q2, q3, q4, totalPrice, done;
    public void setBuyerEmail(String email) {
        this.buyerEmail = email;
    }
    public String getBuyerEmail() {
        return this.buyerEmail;
    }
    public void setSellerEmail(String email) {
        this.sellerEmail = email;
    }
    public String getSellerEmail() {
        return this.sellerEmail;
    }
    public void setQ1(int q1) {
        this.q1 = q1;
    }
    public int getQ1() {
        return this.q1;
    }
    public void setQ2(int q2) {
        this.q2 = q2;
    }
    public int getQ2() {
        return this.q2;
    }
    public void setQ3(int q3) {
        this.q3 = q3;
    }
    public int getQ3() {
        return this.q3;
    }
    public void setQ4(int q4) {
        this.q4 = q4;
    }
    public int getQ4() {
        return this.q4;
    }
    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
    public int getTotalPrice() {
        return this.totalPrice;
    }
    public void setDone(int done) {
        this.done = done;
    }
    public int getDone() {
        return this.done;
    }
}