package com.example.grouppermission;

import android.content.Context;
import android.content.SharedPreferences;

public class permissionUtil {


    private Context context;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    permissionUtil(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(context.getString(R.string.PREFERENCES_PERMISSION), Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void updatePermission(String permission) {
        switch (permission) {
            case "camera":
                editor.putBoolean(context.getString(R.string.PERMISSION_CAMERA), true);
                editor.commit();
                break;
            case "storage":
                editor.putBoolean(context.getString(R.string.PERMISSION_STORAGE), true);
                editor.commit();
                break;
            case "contacts":
                editor.putBoolean(context.getString(R.string.PERMISSION_CONTACTS), true);
                editor.commit();
                break;
        }

    }

    public boolean checkPermission(String permission) {
        boolean isShown = false;
        switch (permission) {
            case "camera":
                isShown = sharedPreferences.getBoolean(context.getString(R.string.PERMISSION_CAMERA), false);
                break;
            case "storage":
                isShown = sharedPreferences.getBoolean(context.getString(R.string.PERMISSION_STORAGE), false);
                break;
            case "contacts":
                isShown = sharedPreferences.getBoolean(context.getString(R.string.PERMISSION_CONTACTS), false);
                break;
        }
        return isShown;
    }
}

