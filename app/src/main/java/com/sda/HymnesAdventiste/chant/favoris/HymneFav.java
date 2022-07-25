/*
 *  Created by TVB Ledoux on 25/07/22 18:49
 *  Copyright (c) 2022 . All rights reserved.
 *  Last modified 24/07/22 16:32
 */

package com.sda.HymnesAdventiste.chant.favoris;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.sda.HymnesAdventiste.R;

public class HymneFav extends AppCompatActivity {

//    List<Model> model = new ArrayList<>();
//
//    RecyclerView recyclerView;
//    FavAdapteur favAdapteur;
//    DBcantique dBcantique;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hymne_fav);

//        recyclerView = findViewById(R.id.recyclerHymnesFav);
//
//        dBcantique = new DBcantique(HymneFav.this);

//        storeDataInArray();
    }

//    private void storeDataInArray() {
//
//        SQLiteDatabase database = dBcantique.getReadableDatabase();
//        Cursor cursor = dBcantique.readAllFavoriteData();
//        try {
//            while (cursor.moveToNext()){
//                int id = Integer.parseInt(cursor.getString(cursor.getColumnIndex(dBcantique.ID1)));
//                int LyricFavorite = Integer.parseInt(cursor.getString(cursor.getColumnIndex(dBcantique.SONG_FAVORITE1)));
//                String number = cursor.getString(cursor.getColumnIndex(dBcantique.SONG_NUMBER1));
//                String titreShahili = cursor.getString(cursor.getColumnIndex(dBcantique.SONG_TITLE_SWAHILI1));
//                String titreEnglish = cursor.getString(cursor.getColumnIndex(dBcantique.SONG_TITLE_ENGLISH1));
//                String lyric = cursor.getString(cursor.getColumnIndex(dBcantique.SONG_LYRIC1));
////                String lyricAudio = cursor.getString(cursor.getColumnIndex(dBcantique.SONG_LYRIC_AUDIO));
////                String lyricDoh = cursor.getString(cursor.getColumnIndex(dBcantique.SONG_LYRIC_DOH));
////                Model mainModel = new Model(id,referenceHymne,LyricFavorite,number,titreShahili,titreEnglish,lyric,lyricAudio,lyricDoh);
//                String lyricAudio= cursor.getString(cursor.getColumnIndex(dBcantique.SONG_LYRIC_AUDIO1));
//                Model mainModel = new Model(id, number, titreShahili, titreEnglish, LyricFavorite, lyric,lyricAudio);
//                model.add(mainModel);
//
//            }
//
//        }finally {
//            if (cursor != null && cursor.isClosed()){
//                cursor.close();
//                database.close();
//            }
//            favAdapteur = new FavAdapteur(HymneFav.this, model);
//            recyclerView.setAdapter(favAdapteur);
//            recyclerView.setLayoutManager(new LinearLayoutManager(HymneFav.this));
//        }
//    }
}