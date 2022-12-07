package com.example.myapplication2;

import com.google.gson.annotations.SerializedName;

//받을 데이터
public class UserResponse {
    @SerializedName("idText")
    private String idText;

    @SerializedName("passwordText")
    private String passwordText;

    public String getIdText() {
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
    }
}
