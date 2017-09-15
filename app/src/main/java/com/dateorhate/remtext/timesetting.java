package com.dateorhate.remtext;

import android.app.TimePickerDialog;
import android.content.Context;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by Lenovo-PC on 2/6/2016.
 */
public class timesetting implements TimePickerDialog.OnTimeSetListener  {
    Context context;
    public timesetting(Context context)
    {
        this.context=context;
    }
    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        Toast.makeText(context, "Time is:" + hourOfDay + ":" + minute, Toast.LENGTH_LONG).show();

    }

}