 /*
 *  Created by TVB Ledoux on 25/07/22 18:49
 *  Copyright (c) 2022 . All rights reserved.
 *  Last modified 24/07/22 16:32
 */

 package com.sda.HymnesAdventiste.chant.chantActivity;

 import android.database.Cursor;
 import android.database.sqlite.SQLiteDatabase;
 import android.os.Bundle;

 import androidx.appcompat.app.AppCompatActivity;
 import androidx.core.content.ContextCompat;
 import androidx.viewpager.widget.ViewPager;

 import com.blogspot.atifsoftwares.animatoolib.Animatoo;
 // import com.sda.HymnesAdventiste.chant.categorie.Categorie;
// import com.sda.HymnesAdventiste.chant.categorie.PagerCategorie;
 import com.sda.HymnesAdventiste.chant.models.Model;
 import com.sda.HymnesAdventiste.chant.adapters.viewpager.PagerNyimbo;
 import com.sda.HymnesAdventiste.R;
 import com.sda.HymnesAdventiste.chant.adapters.viewpager.transform.AccordionTransformer;
 import com.sda.HymnesAdventiste.database.DBcantique;
 import com.sda.HymnesAdventiste.parametres.SharedPref;

 import java.util.ArrayList;
 import java.util.List;

 public class NyimboActivity extends AppCompatActivity {

     DBcantique dBcantique;
     List<Model> model = new ArrayList<>();
     ViewPager viewPager;
     PagerNyimbo pagerNyimbo;

     private SharedPref sharedPref;
     private int position;

     @Override
     protected void onCreate(Bundle savedInstanceState) {


         sharedPref = new SharedPref(this);
         if (sharedPref.loardDarkModeState()) {
             setTheme(R.style.AppThemeDark);
//             getWindow().setStatusBarColor(ContextCompat.getColor(this,R.color.dark));
             getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.black));

         } else {
             setTheme(R.style.AppThemeLight);
//             getWindow().setStatusBarColor(ContextCompat.getColor(this,R.color.primary_fond));
             getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.primary_fond));
         }


         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main3);


         viewPager = (ViewPager) findViewById(R.id.view_pager3);
         viewPager.setPageTransformer(true, new AccordionTransformer());

         dBcantique = new DBcantique(NyimboActivity.this);

         storeDataInArray();


     }



     @Override
     public void onBackPressed() {
         super.onBackPressed();
         Animatoo.animateSlideRight(this);
     }

     private void storeDataInArray() {

         SQLiteDatabase database = dBcantique.getReadableDatabase();
         Cursor cursor = dBcantique.readAllData();
         position = getIntent().getIntExtra("pose", 0);
         try {
             while (cursor.moveToNext()) {
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

         } finally {
             if (cursor != null && cursor.isClosed()) {
                 cursor.close();
                 database.close();
             }
             pagerNyimbo = new PagerNyimbo(NyimboActivity.this, model);
             viewPager.setAdapter(pagerNyimbo);
             viewPager.setCurrentItem(position);
         }
     }

 }