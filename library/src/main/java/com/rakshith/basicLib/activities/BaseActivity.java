package com.rakshith.basicLib.activities;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;

import com.rakshith.basicLib.interfaces.ConformationDialogInterface;

import static java.security.AccessController.getContext;

/**
 * Created by rakshith on 3/7/17.
 */
public class BaseActivity extends AppCompatActivity {
    AlertDialog alertDialog;

    public void showAlertDialog(String title, String message, String positiveBtn, String negativeBtn, final ConformationDialogInterface conformationDialogInterface) {
        alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setCancelable(false);
        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, positiveBtn, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                conformationDialogInterface.positiveBtnClick();
            }
        });
        try {
            alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, negativeBtn, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    conformationDialogInterface.negativeBtnClick();
                    dialog.cancel();
                }
            });
        } catch (NullPointerException e) {
        }

        alertDialog.show();
    }

    public boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context
                .CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null;
    }

    public void setSharedPrefrence(Context context, String key, String value) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public String getSharedPrefrence(Context context, String key) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String value = sharedPreferences.getString(key, "");
        return value;
    }

    public String getDeviceId() {
        return Settings.Secure.getString(getApplicationContext().getContentResolver(),
                Settings.Secure.ANDROID_ID);
    }

    public String emailPattern = "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
            "\\@" +
            "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
            "(" +
            "\\." +
            "[a-zA-Z0-9][a-zA-Z0-9\\-]{1,25}" +
            ")+";

}
