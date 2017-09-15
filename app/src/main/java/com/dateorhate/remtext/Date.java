package com.dateorhate.remtext;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

import java.util.Calendar;

/**
 * Created by Lenovo-PC on 2/6/2016.
 */
public class Date extends DialogFragment {
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar calendar = Calendar.getInstance();
        int Year = calendar.get(Calendar.YEAR);
        int Month = calendar.get(Calendar.MONTH);
        int Day = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog dial;
        Datesetting datesetting = new Datesetting(getActivity());

        dial = new DatePickerDialog(getActivity(), datesetting, Year, Month, Day);
        return dial;
    }
}

