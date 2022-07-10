/*
 *  Created by TVB Ledoux on 10/07/22 22:19
 *  Copyright (c) 2022 . All rights reserved.
 *  Last modified 10/07/22 22:15
 */

package com.sda.projet;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.sda.projet.navigation.HomeFragment;
import com.sda.projet.navigation.MenuFragment;
import com.sda.projet.navigation.SupporterFragment;
import com.sda.projet.parametres.SharedPref;

import java.util.Locale;


public class MainActivity extends AppCompatActivity {

    private long backPressedTime;
    private Toast backToast;

    private SharedPref sharedPref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        sharedPref = new SharedPref(this);
        if (sharedPref.loardDarkModeState()){
            setTheme(R.style.AppThemeDark);
            getWindow().setNavigationBarColor(ContextCompat.getColor(this,R.color.black));
        }else {
            setTheme(R.style.AppThemeLight);
            getWindow().setNavigationBarColor(ContextCompat.getColor(this,R.color.primary_fond_secondaire));
        }

        super.onCreate(savedInstanceState);
        loadLocale();
        setContentView(R.layout.activity_main);


        MeowBottomNavigation meowBottomNavigation;

        meowBottomNavigation = findViewById(R.id.bottom_navigation);

        // Ajout des items
        meowBottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.ic_menu));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.ic_home));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.ic_money));

        meowBottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {

                Fragment fragment = null;

                switch (item.getId()) {

                    case 1:
                        fragment = new MenuFragment();
                        break;
                    case 2:
                        fragment = new HomeFragment();
                        break;
                    case 3:
                        fragment = new SupporterFragment();
                        break;
                }

                chargeFragment(fragment);
            }
        });

        meowBottomNavigation.show(2, true);

        meowBottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {

                switch (item.getId()) {
                    case 1:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.frame_layout, new MenuFragment())
                                .commit();
                        break;

                    case 2:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.frame_layout, new HomeFragment())
                                .commit();
                        break;

                    case 3:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.frame_layout, new SupporterFragment())
                                .commit();

                        break;
                }
            }
        });

        meowBottomNavigation.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
            @Override
            public void onReselectItem(MeowBottomNavigation.Model item) {

                switch (item.getId()) {
                    case 1:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.frame_layout, new MenuFragment())
                                .commit();
                        break;

                    case 2:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.frame_layout, new HomeFragment())
                                .commit();
                        break;

                    case 3:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.frame_layout, new SupporterFragment())
                                .commit();
                        break;
                }
            }
        });



    }


    private void chargeFragment(Fragment fragment) {

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_layout, fragment)
                .commit();
    }


    public void setLocale(String lang) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());

        SharedPreferences.Editor editor = getSharedPreferences("settings", MODE_PRIVATE).edit();
        editor.putString("My_Lang",lang);
        editor.apply();
    }

    public void  loadLocale(){
        SharedPreferences prefs = getSharedPreferences("settings", Activity.MODE_PRIVATE);
        String language = prefs.getString("My_Lang"," ");
        setLocale(language);
    }

    @Override
    public void onBackPressed() {

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.exit_dialogue, (ViewGroup) findViewById(R.id.exit_toast));

        if(backPressedTime + 2000 > System.currentTimeMillis()){
            backToast.cancel();
            super.onBackPressed();
            return;
        }else {
            backToast = new Toast(getApplicationContext());
            backToast.setView(layout);
            backToast.setDuration(Toast.LENGTH_SHORT);
            backToast.show();
        }

        backPressedTime = System.currentTimeMillis();
    }
}
