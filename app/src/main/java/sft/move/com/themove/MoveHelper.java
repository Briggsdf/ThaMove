package sft.move.com.themove;

import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by De'Rio on 9/19/2015.
 */
public  class  MoveHelper {


    public static String getStringFromEditText(EditText et){

        return et.getText().toString();

    }


    public  static Date getDateFromEditText(EditText et){
        try {
           return new SimpleDateFormat("M/dd/yyyy").parse(et.getText().toString());
        }

        catch (ParseException e) {
            Log.d("ParseException because ", e.getMessage());
        }
        return null;
    }

    public static void changeTextViewText(TextView tv, String desiredText){
        tv.setText(desiredText);


    }


    public static String getStringFromTextView(TextView tv){
        return tv.getText().toString();

    }



}
