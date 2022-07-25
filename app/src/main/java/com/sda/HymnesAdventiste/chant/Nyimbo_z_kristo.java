/*
 *  Created by TVB Ledoux on 25/07/22 18:49
 *  Copyright (c) 2022 . All rights reserved.
 *  Last modified 24/07/22 16:32
 */

package com.sda.HymnesAdventiste.chant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.sda.HymnesAdventiste.chant.chantActivity.NyimboActivity;
import com.sda.HymnesAdventiste.chant.models.Model;
import com.sda.HymnesAdventiste.R;
//import com.sda.HymnesAdventiste.chant.favoris.NyimboFav;
import com.sda.HymnesAdventiste.chant.adapters.recyclerview.RecyclerViewAdapteurNym;
import com.sda.HymnesAdventiste.database.DBcantique;
import com.sda.HymnesAdventiste.parametres.SharedPref;

import java.util.ArrayList;
import java.util.List;

public class Nyimbo_z_kristo extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerViewAdapteurNym mainAdapter;

//    DatabaseReference databaseReference;
//    ArrayList<MainModel2> list;

    List<Model> model = new ArrayList<>();

    DBcantique dBcantique;

    //    bottom sheet
    FloatingActionButton bottomsheet;
    Context context;
    //BOUTON CLAVIER
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0;
    ImageView btn_Sup, btn_Go;
    TextView affichage;

    Dialog dialog;

    private SharedPref sharedPref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        sharedPref = new SharedPref(this);
        if (sharedPref.loardDarkModeState()) {
            setTheme(R.style.AppThemeDark);
            getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.black));
        } else {
            setTheme(R.style.AppThemeLight);
            getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.primary_fond));
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nyimbo_z_kristo);

        dialog = new Dialog(Nyimbo_z_kristo.this);

        //    bottom sheet
        bottomsheet = findViewById(R.id.btn_sheet);
        bottomsheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showDialog();
            }
        });



        ((ImageView) findViewById(R.id.imageBack)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Nyimbo_z_kristo.this.onBackPressed();
                Animatoo.animateSwipeRight(Nyimbo_z_kristo.this);
            }
        });
        recyclerView = findViewById(R.id.recycler_view);

        dBcantique = new DBcantique(Nyimbo_z_kristo.this);

        storeDataInArray();


        model = new ArrayList<>();


        // RECHERCHE DES CHANTS

        EditText inputSearch = findViewById(R.id.inputSearch);

        inputSearch.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.setFocusable(true);
                v.setFocusableInTouchMode(true);
                return false;
            }
        });

        inputSearch.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mainAdapter.suppTimer();
            }

            public void afterTextChanged(Editable s) {
                if (model.size() != 0) {
                    mainAdapter.rechercheChant(s.toString());
                }
            }
        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Animatoo.animateSlideRight(this);
    }


    // ------ CLAVIER DIALOG -----------//
    private void showDialog() {


        dialog.setContentView(R.layout.clavier_numero);

        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);

        btn0 = dialog.findViewById(R.id.btn0);
        btn1 = dialog.findViewById(R.id.btn1);
        btn2 = dialog.findViewById(R.id.btn2);
        btn3 = dialog.findViewById(R.id.btn3);
        btn4 = dialog.findViewById(R.id.btn4);
        btn5 = dialog.findViewById(R.id.btn5);
        btn6 = dialog.findViewById(R.id.btn6);
        btn7 = dialog.findViewById(R.id.btn7);
        btn8 = dialog.findViewById(R.id.btn8);
        btn9 = dialog.findViewById(R.id.btn9);
        btn_Sup = dialog.findViewById(R.id.btn_sup);
        btn_Go = dialog.findViewById(R.id.btn_ok);
        affichage = dialog.findViewById(R.id.txvDisplay);



        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(affichage.length() <= 2){
                    affichage.setText(affichage.getText() + "0");
                }else {
                    affichage.setText(affichage.getText());
                }

            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(affichage.length() <= 2){
                    affichage.setText(affichage.getText() + "1");
                }else {
                    affichage.setText(affichage.getText());
                }

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(affichage.length() <= 2){
                    affichage.setText(affichage.getText() + "2");
                }else {
                    affichage.setText(affichage.getText());
                }

            }

        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(affichage.length() <= 2){
                    affichage.setText(affichage.getText() + "3");
                }else {
                    affichage.setText(affichage.getText());
                }

            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(affichage.length() <= 2){
                    affichage.setText(affichage.getText() + "4");
                }else {
                    affichage.setText(affichage.getText());
                }

            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(affichage.length() <= 2){
                    affichage.setText(affichage.getText() + "5");
                }else {
                    affichage.setText(affichage.getText());
                }

            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(affichage.length() <= 2){
                    affichage.setText(affichage.getText() + "6");
                }else {
                    affichage.setText(affichage.getText());
                }

            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(affichage.length() <= 2){
                    affichage.setText(affichage.getText() + "7");
                }else {
                    affichage.setText(affichage.getText());
                }

            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(affichage.length() <= 2){
                    affichage.setText(affichage.getText() + "8");
                }else {
                    affichage.setText(affichage.getText());
                }

            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(affichage.length() <= 2){
                    affichage.setText(affichage.getText() + "9");
                }else {
                    affichage.setText(affichage.getText());
                }

            }
        });

        btn_Sup.setOnClickListener(new View.OnClickListener() {
            String val;

            @Override
            public void onClick(View v) {

                try {
                    val = affichage.getText().toString();
                    val = val.substring(0, val.length() - 1);

                }catch (StringIndexOutOfBoundsException e){
                    e.printStackTrace();
                }

                affichage.setText(val);

            }
        });

        btn_Go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int go = 0;

                try {
                    go = Integer.parseInt(affichage.getText().toString());

                    if (go == 0 || go > 220) {
                        LayoutInflater inflater = getLayoutInflater();
                        View layout = inflater.inflate(R.layout.chant_introuvable, (ViewGroup) findViewById(R.id.exit_toast));
                        Toast toast = new Toast(getApplicationContext());
                        toast.setView(layout);
                        toast.setDuration(Toast.LENGTH_SHORT);
                        toast.show();
                        toast.setGravity(Gravity.CENTER,0 ,0);
                    }  else {
                        Intent intent = new Intent(Nyimbo_z_kristo.this, NyimboActivity.class);
                        intent.putExtra("pose", go - 1);
                        startActivity(intent);
                        Animatoo.animateSplit(Nyimbo_z_kristo.this);

                            dialog.dismiss();

                    }

                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }

            }
        });

    }

    private void storeDataInArray() {

        SQLiteDatabase database = dBcantique.getReadableDatabase();
        Cursor cursor = dBcantique.readAllData();
        try {
            while (cursor.moveToNext()){
                int id = Integer.parseInt(cursor.getString(cursor.getColumnIndex(dBcantique.ID1)));
                int LyricFavorite = Integer.parseInt(cursor.getString(cursor.getColumnIndex(dBcantique.SONG_FAVORITE1)));
                String number = cursor.getString(cursor.getColumnIndex(dBcantique.SONG_NUMBER1));
                String titreShahili = cursor.getString(cursor.getColumnIndex(dBcantique.SONG_TITLE_SWAHILI1));
                String titreEnglish = cursor.getString(cursor.getColumnIndex(dBcantique.SONG_TITLE_ENGLISH1));
                String lyric = cursor.getString(cursor.getColumnIndex(dBcantique.SONG_LYRIC1));
//                String lyricAudio = cursor.getString(cursor.getColumnIndex(dBcantique.SONG_LYRIC_AUDIO));
//                String lyricDoh = cursor.getString(cursor.getColumnIndex(dBcantique.SONG_LYRIC_DOH));
//                Model mainModel = new Model(id, referenceHymne, LyricFavorite, number,titreShahili,titreEnglish,lyric,lyricAudio,lyricDoh);
                String lyricAudio= cursor.getString(cursor.getColumnIndex(dBcantique.SONG_LYRIC_AUDIO1));
                Model mainModel = new Model(id, number, titreShahili, titreEnglish, LyricFavorite, lyric,lyricAudio);
                model.add(mainModel);

            }

        }finally {
            if (cursor != null && cursor.isClosed()){
                cursor.close();
                database.close();
            }
            mainAdapter = new RecyclerViewAdapteurNym(Nyimbo_z_kristo.this, model);
            recyclerView.setAdapter(mainAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(Nyimbo_z_kristo.this));
        }
    }

}