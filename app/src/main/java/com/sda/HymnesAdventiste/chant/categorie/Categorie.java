/*
 *  Created by TVB Ledoux on 25/07/22 18:49
 *  Copyright (c) 2022 . All rights reserved.
 *  Last modified 24/07/22 16:32
 */

package com.sda.HymnesAdventiste.chant.categorie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.sda.HymnesAdventiste.chant.models.Model;
import com.sda.HymnesAdventiste.R;
import com.sda.HymnesAdventiste.chant.adapters.viewpager.transform.AccordionTransformer;
import com.sda.HymnesAdventiste.database.DBcantique;

import java.util.ArrayList;
import java.util.List;

public class Categorie extends AppCompatActivity {

    DBcantique dBcantique;
    List<Model> model = new ArrayList<>();
    ViewPager viewPager;
//    PagerCategorie pagerCategorie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorie);
        viewPager = (ViewPager)findViewById(R.id.view_pager4);
        viewPager.setPageTransformer(true,new AccordionTransformer());

        dBcantique = new DBcantique(Categorie.this);

        storeDataInArray();


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
                String lyricAudio= cursor.getString(cursor.getColumnIndex(dBcantique.SONG_LYRIC_AUDIO1));
                Model mainModel = new Model(id, number, titreShahili, titreEnglish, LyricFavorite, lyric,lyricAudio);
                model.add(mainModel);

            }

        }finally {
            if (cursor != null && cursor.isClosed()){
                cursor.close();
                database.close();
            }
//            pagerCategorie = new PagerCategorie(Categorie.this ,model);
//            viewPager.setAdapter(pagerCategorie);
        }
    }
}