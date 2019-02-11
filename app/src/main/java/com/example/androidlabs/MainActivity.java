package com.example.androidlabs;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    //variables
    private SharedPreferences mPreferences;
    private SharedPreferences.Editor editor;
    private EditText memail;
    private Button loginButton;
    private String savedEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_layoutlab3);

        //shared preference object

        mPreferences = getSharedPreferences("com.example.savedata", Context.MODE_PRIVATE);
        editor = mPreferences.edit();

        //edittext view for the email
        memail = (EditText)findViewById(R.id.email);

        //restoring the value of the email from the sharedpreference
        savedEmail = mPreferences.getString("key", "");
        memail.setText(savedEmail);

        //object for the login buttom
        loginButton = (Button)findViewById(R.id.loginButton);

        //Action on the click on login button

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    //intent used to transfer the data from one activity to another
                    Intent intent = new Intent(getApplicationContext(),ProfileActivity.class);
                    startActivity(intent);
            }
        });

    }
    protected void onPause(){
        super.onPause();
        //Storing the data in shared preference
        editor.putString("key",memail.getText().toString());
        editor.commit();

    }

}