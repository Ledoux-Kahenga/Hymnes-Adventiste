/*
 *  Created by TVB Ledoux on 25/07/22 18:49
 *  Copyright (c) 2022 . All rights reserved.
 *  Last modified 25/07/22 18:38
 */

package com.sda.HymnesAdventiste.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DBcantique extends SQLiteAssetHelper {

//    private static final String DATABASE_NAME = "cantiques.db";
    private static final String DATABASE_NAME = "SongDB.db";
//    private static String TABLE_NAME = "nyimbo";
//    private static final int DATABASE_VERSION = 1;

//    public static String ID = "_id";
//    public static String SONG_NUMBER = "numero_Chant";
//    public static String SONG_TITLE_SWAHILI = "titreSwahili_Chant";
//    public static String SONG_TITLE_ENGLISH = "titreEnglais_Chant";
//    public static String SONG_LYRIC = "contenu_Chant";
//    public static String SONG_LYRIC_DOH = "doh_Chant";
//    public static String SONG_LYRIC_AUDIO = "audio_Chant";
//    public static String SONG_HYMNE_REFERENCE = "hymneReference_Chant";
//    public static String SONG_FAVORITE = "favoris_Chant";
    private static final int DATABASE_VERSION1 = 1;
    public static String ID1 = "_id";
    public static String SONG_NUMBER1 = "numberLyric";
    public static String SONG_TITLE_SWAHILI1 = "titleSwahiliLyric";
    public static String SONG_TITLE_ENGLISH1 = "titleEnglishiLyric";
    public static String SONG_LYRIC1 = "Lyric";
    public static String SONG_FAVORITE1 = "LyricFavorite";
    public static String SONG_LYRIC_AUDIO1 = "LyricMusic";
    private static String TABLE_NAME1 = "SongNyimboTB";


    public DBcantique(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION1);
    }


    // Read All data
    public Cursor readAllData(){
        String query = " SELECT " +ID1 +"," + SONG_NUMBER1 +","  + SONG_TITLE_SWAHILI1 +"," +  SONG_TITLE_ENGLISH1  +","+ SONG_FAVORITE1+"," + SONG_LYRIC1+","+SONG_LYRIC_AUDIO1 + " from " +TABLE_NAME1;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null){
           cursor =  db.rawQuery(query,null);
        }
        return cursor;
    }

    // Update favorite to 1
    public void AddToFavorite(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "UPDATE " + TABLE_NAME1 + " SET  " + SONG_FAVORITE1 +" = 1 WHERE "+ID1+"="+id+"";
        db.execSQL(sql);
    }

    // Update favorite to 0
    public void RemoveToFavorite(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "UPDATE " + TABLE_NAME1 + " SET  " + SONG_FAVORITE1 +" = 0 WHERE "+ID1+"="+id+"";
        db.execSQL(sql);
    }

    // Select all favorite list
    public Cursor readAllFavoriteData(){

        String query = "SELECT * FROM "+TABLE_NAME1+" WHERE "+SONG_FAVORITE1+"= 1";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null){
            cursor =  db.rawQuery(query,null);
        }
        return cursor;
    }

}
