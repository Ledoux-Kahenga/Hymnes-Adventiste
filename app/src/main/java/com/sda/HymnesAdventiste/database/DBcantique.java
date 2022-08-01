/*
 *  Created by TVB Ledoux on 01/08/22 18:55
 *  Copyright (c) 2022 . All rights reserved.
 *  Last modified 01/08/22 18:53
 */

package com.sda.HymnesAdventiste.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DBcantique extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "SongDbLyri.db";
    private static final int DATABASE_VERSION = 1;
    public static String ID = "_id";
    public static String SONG_NUMBER = "numberLyric";
    public static String SONG_TITLE = "titleLyric";
    public static String SONG_AUTHOR = "author";
    public static String SONG_LYRIC = "lyric";
    public static String SONG_LYRIC_AUDIO = "LyricMusic";
    public static String SONG_HYMNE_REFERENCE = "LyricReferences";
    public static String SONG_FAVORITE = "LyricFavorites";
    // HYMNES ET LOUANGES
    private static String TABLE_NAME = "SongHymnesTB";
    // NYIMBO ZA KRISTO
    private static String TABLE_NAME1 = "SongNyimboTB";
    public static String ID1 = "_id";
    public static String SONG_NUMBER1 = "numberLyric";
    public static String SONG_TITLE_SWAHILI1 = "titleSwahiliLyric";
    public static String SONG_TITLE_ENGLISH1 = "titleEnglishiLyric";
    public static String SONG_LYRIC1 = "Lyric";
    public static String SONG_FAVORITE1 = "LyricFavorite";
    public static String SONG_LYRIC_AUDIO1 = "LyricMusic";



    public DBcantique(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    // Read All data FROM NYIMBO TABLE
    public Cursor readAllData1(){
        String query = " SELECT " +ID1 +"," + SONG_NUMBER1 +","  + SONG_TITLE_SWAHILI1 +"," +  SONG_TITLE_ENGLISH1  +","+ SONG_FAVORITE1+"," + SONG_LYRIC1+","+SONG_LYRIC_AUDIO1 + " from " +TABLE_NAME1;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null){
           cursor =  db.rawQuery(query,null);
        }
        return cursor;
    }

    // Update favorite to 1
    public void AddToFavorite1(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "UPDATE " + TABLE_NAME1 + " SET  " + SONG_FAVORITE1 +" = 1 WHERE "+ID1+"="+id+"";
        db.execSQL(sql);
    }

    // Update favorite to 0
    public void RemoveToFavorite1(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "UPDATE " + TABLE_NAME1 + " SET  " + SONG_FAVORITE1 +" = 0 WHERE "+ID1+"="+id+"";
        db.execSQL(sql);
    }

    // Select all favorite list
    public Cursor readAllFavoriteData1(){

        String query = "SELECT * FROM "+TABLE_NAME1+" WHERE "+SONG_FAVORITE1+"= 1";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null){
            cursor =  db.rawQuery(query,null);
        }
        return cursor;
    }

    // CATEGORIE
//    public Cursor categorie(int min, int max){
//
//        String query =  "SELECT * FROM "+TABLE_NAME1+" WHERE "+ ID1 +" BETWEEN " + min +" AND "+ max;
//        SQLiteDatabase db = this.getReadableDatabase();
//
//        Cursor cursor = null;
//        if (db != null){
//            cursor =  db.rawQuery(query,null);
//        }
//
//        return cursor;
//
//    }

    // Read All data FROM HYMNES TABLE
    public Cursor readAllData2(){
        String query = " SELECT " +ID +"," + SONG_NUMBER +","  + SONG_TITLE +"," +  SONG_AUTHOR  +","+ SONG_FAVORITE+"," + SONG_LYRIC+","+SONG_LYRIC_AUDIO + " from " +TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null){
            cursor =  db.rawQuery(query,null);
        }
        return cursor;
    }

    // Update favorite to 1
    public void AddToFavorite2(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "UPDATE " + TABLE_NAME + " SET  " + SONG_FAVORITE +" = 1 WHERE "+ID+"="+id+"";
        db.execSQL(sql);
    }

    // Update favorite to 0
    public void RemoveToFavorite2(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "UPDATE " + TABLE_NAME + " SET  " + SONG_FAVORITE +" = 0 WHERE "+ID+"="+id+"";
        db.execSQL(sql);
    }

    // Select all favorite list
    public Cursor readAllFavoriteData2(){

        String query = "SELECT * FROM "+TABLE_NAME+" WHERE "+SONG_FAVORITE+"= 1";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null){
            cursor =  db.rawQuery(query,null);
        }
        return cursor;
    }

}
