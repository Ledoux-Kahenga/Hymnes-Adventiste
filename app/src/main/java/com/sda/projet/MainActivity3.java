 /*
 *  Created by TVB Ledoux on 19/07/22 11:16
 *  Copyright (c) 2022 . All rights reserved.
 *  Last modified 17/07/22 15:06
 */

package com.sda.projet;

 import android.annotation.SuppressLint;
 import android.media.MediaPlayer;
 import android.os.Bundle;
 import android.text.Layout;
 import android.view.View;
 import android.widget.ImageView;
 import android.widget.TextView;
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
 import com.sda.projet.chant.Hymnes_et_lg;
 import com.sda.projet.chant.model.adapteur.viewpager.transform.AccordionTransformer;
 import com.sda.projet.parametres.SharedPref;

 import java.util.ArrayList;
 import java.util.List;

 public class MainActivity3 extends AppCompatActivity implements IFirebaseLoadDone1 {

     ViewPager viewPager;
     PagerNyimbo pagerNyimbo;

     MediaPlayer mediaPlayer;



     DatabaseReference movies;

     IFirebaseLoadDone1 iFirebaseLoadDone;

     private SharedPref sharedPref;
     private int position;

     @Override
     protected void onCreate(Bundle savedInstanceState) {

         mediaPlayer = null;

         sharedPref = new SharedPref(this);
         if (sharedPref.loardDarkModeState()){
             setTheme(R.style.AppThemeDark);
//             getWindow().setStatusBarColor(ContextCompat.getColor(this,R.color.dark));
             getWindow().setNavigationBarColor(ContextCompat.getColor(this,R.color.black));

         }else {
             setTheme(R.style.AppThemeLight);
//             getWindow().setStatusBarColor(ContextCompat.getColor(this,R.color.primary_fond));
             getWindow().setNavigationBarColor(ContextCompat.getColor(this,R.color.primary_fond));
         }


         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main3);

         movies = FirebaseDatabase.getInstance().getReference("nyimbo");

         //Init Event
         iFirebaseLoadDone = this;

         loadMovie();


         viewPager = (ViewPager)findViewById(R.id.view_pager3);
         viewPager.setPageTransformer(true,new AccordionTransformer());
         getIntentInfo();

//         mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.a001);

     }

     private void loadMovie() {
         movies.addListenerForSingleValueEvent(new ValueEventListener() {
             List<MainModel2> mainModelList2 = new ArrayList<>();
             @Override
             public void onDataChange(@NonNull DataSnapshot snapshot) {

                 for (DataSnapshot movieSnapShot:snapshot.getChildren())
                     mainModelList2.add(movieSnapShot.getValue(MainModel2.class));
                     iFirebaseLoadDone.onFirebaseLoadSuccess(mainModelList2);
             }

             @Override
             public void onCancelled(@NonNull DatabaseError error) {

                 iFirebaseLoadDone.onFirebaseFailed(error.getMessage());
             }
         });
     }

     @Override
     public void onFirebaseLoadSuccess(List<MainModel2> mainModelList) {

         pagerNyimbo = new PagerNyimbo(this,mainModelList);
         viewPager.setAdapter(pagerNyimbo);
         viewPager.setCurrentItem(position);
//         viewPager.setCurrentItem(posee);
     }

     @Override
     public void onFirebaseFailed(String message) {

         Toast.makeText(this, ""+message, Toast.LENGTH_SHORT).show();
     }

     private void getIntentInfo(){
         position = getIntent().getIntExtra("pose",0);
     }
//     private void getIntentPos(){
//         position = getIntent().getIntExtra("posee",0);
//     }

     @Override
     public void onBackPressed() {
         super.onBackPressed();
//         try {
//
//             if (mediaPlayer.isPlaying()) {
//                 mediaPlayer.release();
//                 mediaPlayer = null;
////                    audio.setImageResource(R.drawable.ic_play_btn);
//             } else  {
//                 mediaPlayer = null;
//             }
//
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
         Animatoo.animateSlideRight(this);
     }

 }