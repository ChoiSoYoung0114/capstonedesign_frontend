package com.example.myapplication2;

import com.google.gson.annotations.SerializedName;

//보낼 데이터
public class User {
    @SerializedName("idText")
    String idText;

    @SerializedName("passwordText")
    String passwordText;

    public User(String idText, String passwordText){
        this.idText = idText;
        this.passwordText = passwordText;
    }

    /*public String getIdText() {
        return idText;
    }

    public void setIdText(String idText) {
        this.idText = idText;
    }

    public String getPasswordText() {
        return passwordText;
    }

    public void setPasswordText(String passwordText) {
        this.passwordText = passwordText;
    }*/

}
