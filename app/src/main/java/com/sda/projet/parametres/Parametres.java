package com.sda.projet.parametres;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.location.Location;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.sda.projet.MainActivity;
import com.sda.projet.MainActivity3;
import com.sda.projet.PagerNyimbo;
import com.sda.projet.R;
import com.sda.projet.SplashScreen;
import com.sda.projet.navigation.HomeFragment;
import com.sda.projet.navigation.MenuFragment;

import java.util.ArrayList;
import java.util.Locale;

public class Parametres extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private static final String SHARED_PREF_NAME = "Mypref";
    private static final String KEY_lANGUAGE = "Language";
    SharedPref sharedPref;
    SharedPreferences preferences;
    SharedPreferences.Editor edictr;

    ConstraintLayout constraintLayout;
    Spinner spinner;
    int withid = 150;
    ArrayList<CustomItem> customList;
    MainActivity3 activity3;
    private Switch aSwitch;
    private AlertDialog mAlertDialog;
    private AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        sharedPref = new SharedPref(this);
        if (sharedPref.loardDarkModeState()) {
            setTheme(R.style.SettingsDark);
            getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.black));
        } else {
            setTheme(R.style.SettingsLight);
            getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.primary_fond_secondaire));
        }

        super.onCreate(savedInstanceState);
        loadLocale();
        setContentView(R.layout.activity_parametres);


        constraintLayout = findViewById(R.id.swictCard);
        aSwitch = findViewById(R.id.swich_dark);

        if (sharedPref.loardDarkModeState()) {
            aSwitch.setChecked(true);
        }

        aSwitch.setClickable(false);

        constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!aSwitch.isChecked()) {
                    aSwitch.setChecked(true);
                    sharedPref.setDarkModeState(true);
                    restartApp();
                    Toast.makeText(Parametres.this, getResources().getString(R.string.activer) , Toast.LENGTH_SHORT).show();
                } else {
                    aSwitch.setChecked(false);
                    sharedPref.setDarkModeState(false);
                    restartApp();
                    Toast.makeText(Parametres.this, getResources().getString(R.string.desactiver), Toast.LENGTH_SHORT).show();
                }
            }
        });

        preferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        edictr = preferences.edit();

        spinner = findViewById(R.id.spinner);
        customList = getCustomList();
        CustomAdapteur adapteur = new CustomAdapteur(this, customList);
        if (spinner != null) {
            spinner.setAdapter(adapteur);
            spinner.setOnItemSelectedListener(this);
        }


//        changeFontFamily();

    }

    private ArrayList<CustomItem> getCustomList() {
        customList = new ArrayList<>();
        customList.add(new CustomItem(getResources().getString(R.string.clicker_langue), R.drawable.ic_language_2));
        customList.add(new CustomItem("Francais", R.drawable.france));
        customList.add(new CustomItem("Swahili", R.drawable.tanzanie));
        customList.add(new CustomItem("English", R.drawable.united_kingdom));
        return customList;
    }


    public void setLocale(String lang) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());

        SharedPreferences.Editor editor = getSharedPreferences("settings", MODE_PRIVATE).edit();
        editor.putString("My_Lang", lang);
        editor.apply();
    }

    public void loadLocale() {
        SharedPreferences prefs = getSharedPreferences("settings", Activity.MODE_PRIVATE);
        String language = prefs.getString("My_Lang", " ");
        setLocale(language);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(Parametres.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }

    private void restartApp() {
        Intent intent = new Intent(getApplicationContext(), Parametres.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


        LinearLayout linearLayout = findViewById(R.id.customSpinnerItem);
        withid=linearLayout.getWidth();
        spinner.setDropDownWidth(withid);
        
        if (position != 0) {

            edictr.putInt(KEY_lANGUAGE, position);
            edictr.apply();

        }

        int intLanguage = preferences.getInt(KEY_lANGUAGE, 0);
        spinner.setSelection(intLanguage);

        if (intLanguage == 1) {

            setLocale("fr");
//                    onBackPressed();
        } else if (intLanguage == 2) {
            setLocale("sw");
//                    onBackPressed();

        } else if (intLanguage == 3) {
            setLocale("en");
//                    onBackPressed();

        }

    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}