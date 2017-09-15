package com.dateorhate.remtext;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Inbox extends AppCompatActivity {


    public final static String Message_key="dateorhate.com.remtext.message_key";
    FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_inbox);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       setSupportActionBar(toolbar);
        Intent intent =getIntent();
        String message = intent.getStringExtra(Message_key);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Inbox.this, Message.class);

                startActivity(intent);
                finish();
            }
        });
        /*TextView textView=new TextView(this);
        textView.setTextSize(30);
        textView.setText(message);
        setContentView(textView);*/
        dispinfo(message);


       getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_inbox, menu);
        return true;
    }
    public void dispinfo(String message){
        TextView mess = (TextView) findViewById(R.id.test);
        mess.setText(message);

    }
}
