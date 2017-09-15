package com.dateorhate.remtext;

import android.app.DatePickerDialog;
import android.content.Context;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by Lenovo-PC on 2/6/2016.
 */
public class Datesetting implements DatePickerDialog.OnDateSetListener {
    Context cont;

    public Datesetting(Context cont) {
        this.cont = cont;
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayofMonth) {
        Toast.makeText(cont, "Time is:" + year + "/" + month + "/" + dayofMonth, Toast.LENGTH_LONG).show();
    }
}
