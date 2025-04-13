package com.example.neerja_modi_school;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.neerja_modi_school.databinding.ActivityContactPageBinding;

public class Contact_page_java extends BaseActivity {
    EditText reg_name, reg_email, reg_mobile, reg_msg;
    Button btnShowData, next_page;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityContactPageBinding activityContactPageBinding = ActivityContactPageBinding.inflate(getLayoutInflater());
        setContentView(activityContactPageBinding.getRoot());
        reg_name = (EditText) findViewById(R.id.reg_name);
        reg_email = (EditText) findViewById(R.id.reg_email);
        reg_mobile = (EditText) findViewById(R.id.reg_mobile);
        reg_msg = (EditText) findViewById(R.id.reg_message);
        btnShowData = findViewById(R.id.btn_show_data);
        databaseHelper = new DatabaseHelper(getApplicationContext());
        btnShowData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser(view);
            }
        });
        next_page=findViewById(R.id.show_data_next_page);
        next_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Contact_page_java.this,Cont_DB.class);
                startActivity(intent);
            }
        });
    }

    public void registerUser(View view) {
        String name = reg_name.getText().toString();
        String email = reg_email.getText().toString();
        String mobile = reg_mobile.getText().toString();
        String msg = reg_msg.getText().toString();
        boolean b= databaseHelper.registerUserHelper(name,mobile,email,msg);
        if(b==true){
            Toast.makeText(this, "User registered successfully...!!", Toast.LENGTH_SHORT).show();
            reg_name.setText("");
            reg_email.setText("");
            reg_mobile.setText("");
            reg_msg.setText("");
        }else{
            Toast.makeText(this, "Error...!!", Toast.LENGTH_SHORT).show();

        }
    }
}