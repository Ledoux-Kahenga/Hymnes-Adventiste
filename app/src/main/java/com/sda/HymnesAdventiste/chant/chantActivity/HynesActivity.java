

/*
 *  Created by TVB Ledoux on 01/08/22 18:55
 *  Copyright (c) 2022 . All rights reserved.
 *  Last modified 01/08/22 14:12
 */

package com.sda.HymnesAdventiste.chant.chantActivity;

 import android.database.Cursor;
 import android.database.sqlite.SQLiteDatabase;
 import android.os.Bundle;
 import android.widget.Toast;

 import androidx.annotation.NonNull;
 import androidx.appcompat.app.AppCompatActivity;
 import androidx.core.content.ContextCompat;
 import androidx.viewpager.widget.ViewPager;

 import com.blogspot.atifsoftwares.animatoolib.Animatoo;
 import com.google.firebase.database.DataSnapshot;
 import com.google.firebase.database.DatabaseError;
 import com.google.firebase.database.DatabaseReference;
 import com.google.firebase.database.FirebaseDatabase;
 import com.google.firebase.database.ValueEventListener;
 import com.sda.HymnesAdventiste.IFirebaseLoadDone;
 import com.sda.HymnesAdventiste.chant.Hymnes_et_lg;
 import com.sda.HymnesAdventiste.chant.adapters.viewpager.PagerNyimbo;
 import com.sda.HymnesAdventiste.chant.models.MainModel;
 import com.sda.HymnesAdventiste.chant.adapters.viewpager.PagerHymnes;
 import com.sda.HymnesAdventiste.R;
 import com.sda.HymnesAdventiste.chant.adapters.viewpager.transform.AccordionTransformer;
 import com.sda.HymnesAdventiste.chant.models.Model;
 import com.sda.HymnesAdventiste.database.DBcantique;
 import com.sda.HymnesAdventiste.parametres.SharedPref;

 import java.util.ArrayList;
 import java.util.List;

public class HynesActivity extends AppCompatActivity  {
    DBcantique dBcantique;
    List<Model> model = new ArrayList<>();
    ViewPager viewPager;
    PagerHymnes pagerhymes;

    private SharedPref sharedPref;
    private int position;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        sharedPref = new SharedPref(this);
        if (sharedPref.loardDarkModeState()){
            setTheme(R.style.AppThemeDark);
//            getWindow().setStatusBarColor(ContextCompat.getColor(this,R.color.dark));
            getWindow().setNavigationBarColor(ContextCompat.getColor(this,R.color.black));
        }else {
            setTheme(R.style.AppThemeLight);
//            getWindow().setStatusBarColor(ContextCompat.getColor(this,R.color.primary_fond));
            getWindow().setNavigationBarColor(ContextCompat.getColor(this,R.color.primary_fond));
        }



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        viewPager.setPageTransformer(true, new AccordionTransformer());

        dBcantique = new DBcantique(HynesActivity.this);

        storeDataInArray();


    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Animatoo.animateSlideRight(this);
    }

    private void storeDataInArray() {

        SQLiteDatabase database = dBcantique.getReadableDatabase();
        Cursor cursor = dBcantique.readAllData2();
        position = getIntent().getIntExtra("pos", 0);
        try {
            while (cursor.moveToNext()) {
                int id = Integer.parseInt(cursor.getString(cursor.getColumnIndex(dBcantique.ID)));
                int LyricFavorite = Integer.parseInt(cursor.getString(cursor.getColumnIndex(dBcantique.SONG_FAVORITE)));
                String number = cursor.getString(cursor.getColumnIndex(dBcantique.SONG_NUMBER));
                String titreShahili = cursor.getString(cursor.getColumnIndex(dBcantique.SONG_TITLE));
                String titreEnglish = cursor.getString(cursor.getColumnIndex(dBcantique.SONG_AUTHOR));
                String lyric = cursor.getString(cursor.getColumnIndex(dBcantique.SONG_LYRIC));
                String lyricAudio= cursor.getString(cursor.getColumnIndex(dBcantique.SONG_LYRIC_AUDIO));
                Model mainModel = new Model(id, number, titreShahili, titreEnglish, LyricFavorite, lyric,lyricAudio);
                model.add(mainModel);

            }

        } finally {
            if (cursor != null && cursor.isClosed()) {
                cursor.close();
                database.close();
            }
            pagerhymes= new PagerHymnes(HynesActivity.this, model);
            viewPager.setAdapter(pagerhymes);
            viewPager.setCurrentItem(position);
        }
    }

}