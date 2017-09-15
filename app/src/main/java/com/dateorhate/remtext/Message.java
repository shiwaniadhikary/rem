package com.dateorhate.remtext;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import java.security.PrivateKey;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class Message extends AppCompatActivity {
    ImageButton buttonReadContact;
    EditText txt;
    Button sendSmS;
    EditText msee;
    EditText number;
    private final int PICK_CONTACT = 1;
    public final static String Message_key = "dateorhate.com.remtext.message_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        buttonReadContact = (ImageButton) findViewById(R.id.contact);
        txt = (EditText) findViewById(R.id.number);

        buttonReadContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
                startActivityForResult(intent, PICK_CONTACT);

            }
        });
        sendSmS=(Button)findViewById(R.id.done);
        msee=(EditText)findViewById(R.id.message);
        number=(EditText)findViewById(R.id.number);
        sendSmS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String myMsg = msee.getText().toString();
                String numb = number.getText().toString();
                sendMsg(numb,myMsg);
            }

            protected void sendMsg(String numb, String myMsg) {
                SmsManager sms=SmsManager.getDefault();
                sms.sendTextMessage(numb, null, myMsg, null, null);
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_CONTACT) {
            if (resultCode == RESULT_OK) {
                Uri contactData = data.getData();
                ContentResolver cr = getContentResolver();
                Cursor c = cr.query(contactData, null, null, null, null);
                if (c.moveToFirst()) {
                    String number = c.getString(c.getColumnIndex(ContactsContract.Contacts._ID));
                    Cursor phones = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID + "=" + number, null, null);
                    while (phones.moveToNext()) {
                        String num = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                        int type = phones.getInt(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.TYPE));
                        switch (type) {
                            case ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE:
                                txt.setText(num);
                        }
                    }
                }
            }
        }
    }


    public void showDialog(View view) {
        time times = new time();
        times.show(getSupportFragmentManager(), "time_picker");
    }

    public void showDial(View view) {
        Date date = new Date();
        date.show(getSupportFragmentManager(), "Date_picker");
    }

    public void sendData(View views) {
        txt = (EditText) findViewById(R.id.number);
        String message = txt.getText().toString();
        Intent intent = new Intent(this, Inbox.class);
        intent.putExtra(Message_key, message);
        startActivity(intent);

    }


}
