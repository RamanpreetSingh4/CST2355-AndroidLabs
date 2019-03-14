package com.example.androidlabs;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class ProfileActivity extends AppCompatActivity {
    EditText sEmail;
    ImageButton mImageButton;
    Button gotoChat;
    Button gotoToolbar;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    public static final String ACTIVITY_NAME = "PROFILE_ACTIVITY";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_profile);

        sEmail = (EditText) findViewById(R.id.savedEmail);

        SharedPreferences result = getSharedPreferences("com.example.savedata", Context.MODE_PRIVATE);

        String value = result.getString("key","");

        sEmail.setText(value);


        mImageButton = (ImageButton) findViewById(R.id.profileImageButton);

        mImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                }
            }
        });

        gotoChat = (Button) findViewById(R.id.button5);
        gotoToolbar = (Button) findViewById(R.id.button2);

        gotoChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //intent used to transfer from one activity to another
                Intent chatIntent = new Intent(getApplicationContext(),ChatRoomActivity.class);
                startActivity(chatIntent);
            }
        });

        Log.e(ACTIVITY_NAME,"in function: onCreate()");

        gotoToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //intent used to transfer from one activity to another
                Intent toolbar = new Intent(getApplicationContext(),TestToolbar.class);
                startActivity(toolbar);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            mImageButton.setImageBitmap(imageBitmap);
        }


    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.e(ACTIVITY_NAME,"in function: onStart()");

    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.e(ACTIVITY_NAME,"in function: onResume()");


    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.e(ACTIVITY_NAME,"in function: onPause()");

    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.e(ACTIVITY_NAME,"in function: onStop()");

    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.e(ACTIVITY_NAME,"in function: onDestroy()");

    }



}



