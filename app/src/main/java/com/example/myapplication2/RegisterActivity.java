package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        AppCompatButton registerButton = (AppCompatButton) findViewById(R.id.registerButton);
        EditText idText = (EditText) findViewById(R.id.idText);
        EditText passwordText = (EditText) findViewById(R.id.passwordText);
        EditText emailText = (EditText) findViewById(R.id.emailText);
        RadioButton Payer = (RadioButton) findViewById(R.id.Payer);
        RadioButton User = (RadioButton) findViewById(R.id.User);
        RadioButton Woman = (RadioButton) findViewById(R.id.genderWoman);
        RadioButton Man = (RadioButton) findViewById(R.id.genderMan);
        RadioGroup UserPayerGroup = (RadioGroup) findViewById(R.id.UserPayerGroup);
        EditText addressText = (EditText) findViewById(R.id.addressText);
        String payer = Payer.getText().toString();
        String user = User.getText().toString();
        String woman = Woman.getText().toString();
        String man = Man.getText().toString();

        UserPayerGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId){
                switch(checkedId){
                    case R.id.Payer:
                        addressText.setHint("    Address");
                        addressText.setBackgroundColor(Color.parseColor("#46A0CD"));
                        if(addressText.getText().toString().length()==0){
                            Toast.makeText(RegisterActivity.this, "주소를 입력하세요", Toast.LENGTH_SHORT).show();
                            addressText.requestFocus();
                            return;
                        }
                        break;
                    case R.id.User:
                        addressText.setBackgroundColor(Color.WHITE);
                        break;
                }
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(idText.getText().toString().length()==0){
                    Toast.makeText(RegisterActivity.this, "id를 입력하세요", Toast.LENGTH_SHORT).show();
                    idText.requestFocus();
                    return;
                }
                if(passwordText.getText().toString().length()==0){
                    Toast.makeText(RegisterActivity.this, "password를 입력하세요", Toast.LENGTH_SHORT).show();
                    passwordText.requestFocus();
                    return;
                }
                if(emailText.getText().toString().length()==0){
                    Toast.makeText(RegisterActivity.this, "e-mail를 입력하세요", Toast.LENGTH_SHORT).show();
                    emailText.requestFocus();
                    return;
                }
            }
        });
    }
}