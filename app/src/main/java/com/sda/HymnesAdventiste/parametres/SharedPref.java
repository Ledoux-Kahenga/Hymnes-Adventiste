/*
 *  Created by TVB Ledoux on 25/07/22 18:49
 *  Copyright (c) 2022 . All rights reserved.
 *  Last modified 24/07/22 06:00
 */

package com.sda.HymnesAdventiste.parametres;

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
