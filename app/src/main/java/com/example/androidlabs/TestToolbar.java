package com.example.androidlabs;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.support.design.widget.Snackbar;



public class TestToolbar extends AppCompatActivity {

    String overflowToast = "You clicked on the Overflow Menu";
    String delete = "Initial Message";
    String snackbar = "This is the Snackbar";
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);//disappear the title


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.MenuItems_overflow:
                Toast.makeText(this, overflowToast, Toast.LENGTH_LONG).show();
                break;
            case R.id.MenuItems_inital:
                Toast.makeText(this, delete , Toast.LENGTH_LONG).show();
                break;
            case R.id.MenuItems_alert:
                alertExample();
                break;
            case R.id.MenuItems_snack:
                Snackbar sb = Snackbar.make(toolbar, snackbar, Snackbar.LENGTH_LONG)
                        .setAction("Close", e -> finish());
                sb.show();
                break;


        }
        return true;
    }

    public void alertExample()
    {
        View middle = getLayoutInflater().inflate(R.layout.dialog, null);
        EditText et = (EditText)middle.findViewById(R.id.view_edit_text);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Alert")
                .setPositiveButton("Positive", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        delete = et.getText().toString();
                    }
                })
                .setNegativeButton("Negative", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                }).setView(middle);

        builder.create().show();
    }

}
