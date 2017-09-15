package com.dateorhate.remtext;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.text.format.DateFormat;

import java.util.Calendar;

/**
 * Created by Lenovo-PC on 2/6/2016.
 */
public class time extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar calendar=Calendar.getInstance();
        int Hour=calendar.get(Calendar.HOUR_OF_DAY);
        int Minute=calendar.get(Calendar.MINUTE);
        TimePickerDialog dialog;
        timesetting timesettings =new timesetting(getActivity());
        dialog=new TimePickerDialog(getActivity(),timesettings,Hour,Minute, DateFormat.is24HourFormat(getActivity()));
        return dialog;

        // return super.onCreateDialog(savedInstanceState);
    }
}
