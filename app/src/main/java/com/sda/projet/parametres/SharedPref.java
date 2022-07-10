package com.sda.projet.parametres;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPref {

    private SharedPreferences mySharedPref;

    public SharedPref(Context context){
        mySharedPref = context.getSharedPreferences("filename", context.MODE_PRIVATE);
    }


    public void setDarkModeState(Boolean state){
        SharedPreferences.Editor editor = mySharedPref.edit();
        editor.putBoolean("darkTheme",state);
        editor.apply();
    }

    public boolean loardDarkModeState(){
        return mySharedPref.getBoolean("darkTheme",false);
    }
}
