/*
 *  Created by TVB Ledoux on 23/07/22 20:59
 *  Copyright (c) 2022 . All rights reserved.
 *  Last modified 23/07/22 20:58
 */

package com.sda.projet.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DBcantique extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "nyimbodb.db";// database/mydb.db
    private static final int DATABASE_VERSION = 4;
    public static String ID = "_id";
    public static String SONG_NUMBER = "song_Number";
    public static String SONG_TITLE_SWAHILI = "song_TitleSwahili";
    public static String SONG_TITLE_ENGLISH = "song_TitleEnglish";
    private static String TABLE_NAME = "SONG";

    public DBcantique(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    // Read All data
    public Cursor readAllData(){
        String query = " SELECT " +ID +"," + SONG_NUMBER +","  + SONG_TITLE_SWAHILI +"," +  SONG_TITLE_ENGLISH  + " from " +TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null){
           cursor =  db.rawQuery(query,null);
        }
        return cursor;
    }

}
