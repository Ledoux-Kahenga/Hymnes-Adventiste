/*
 *  Created by TVB Ledoux on 01/08/22 18:55
 *  Copyright (c) 2022 . All rights reserved.
 *  Last modified 01/08/22 15:18
 */

package com.sda.HymnesAdventiste.chant.favoris;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.sda.HymnesAdventiste.R;
import com.sda.HymnesAdventiste.chant.models.Model;
import com.sda.HymnesAdventiste.database.DBcantique;

import java.util.ArrayList;
import java.util.List;

public class HymneFav extends AppCompatActivity {

    List<Model> model = new ArrayList<>();

    RecyclerView recyclerView;
    FavHymnesAdapteur favAdapteur;
    DBcantique dBcantique;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hymne_fav);

        recyclerView = findViewById(R.id.recyclerHymnesFav);

        dBcantique = new DBcantique(HymneFav.this);

        storeDataInArray();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Animatoo.animateSlideLeft(this);
    }

    private void storeDataInArray() {

        SQLiteDatabase database = dBcantique.getReadableDatabase();
        Cursor cursor = dBcantique.readAllFavoriteData2();
        try {
            while (cursor.moveToNext()){
                int id = Integer.parseInt(cursor.getString(cursor.getColumnIndex(dBcantique.ID)));
                int LyricFavorite = Integer.parseInt(cursor.getString(cursor.getColumnIndex(dBcantique.SONG_FAVORITE)));
                String number = cursor.getString(cursor.getColumnIndex(dBcantique.SONG_NUMBER));
                String titreShahili = cursor.getString(cursor.getColumnIndex(dBcantique.SONG_TITLE));
                String titreEnglish = cursor.getString(cursor.getColumnIndex(dBcantique.SONG_AUTHOR));
                String lyric = cursor.getString(cursor.getColumnIndex(dBcantique.SONG_LYRIC));
//                String lyricAudio = cursor.getString(cursor.getColumnIndex(dBcantique.SONG_LYRIC_AUDIO));
//                String lyricDoh = cursor.getString(cursor.getColumnIndex(dBcantique.SONG_LYRIC_DOH));
//                Model mainModel = new Model(id,referenceHymne,LyricFavorite,number,titreShahili,titreEnglish,lyric,lyricAudio,lyricDoh);
                String lyricAudio= cursor.getString(cursor.getColumnIndex(dBcantique.SONG_LYRIC_AUDIO));
                Model mainModel = new Model(id, number, titreShahili, titreEnglish, LyricFavorite, lyric,lyricAudio);
                model.add(mainModel);

            }

        }finally {
            if (cursor != null && cursor.isClosed()){
                cursor.close();
                database.close();
            }
            favAdapteur = new FavHymnesAdapteur(HymneFav.this, model);
            recyclerView.setAdapter(favAdapteur);
            recyclerView.setLayoutManager(new LinearLayoutManager(HymneFav.this));
        }
    }


}