

/*
 *  Created by TVB Ledoux on 19/07/22 15:58
 *  Copyright (c) 2022 . All rights reserved.
 *  Last modified 19/07/22 13:31
 */

package com.sda.projet;

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
 import com.sda.projet.chant.model.adapteur.viewpager.DepthSpinnerAnimation;
 import com.sda.projet.chant.model.adapteur.viewpager.transform.AccordionTransformer;
 import com.sda.projet.parametres.SharedPref;

 import java.util.ArrayList;
 import java.util.List;

public class MainActivity2 extends AppCompatActivity implements IFirebaseLoadDone {

    ViewPager viewPager;
    PagerHymnes pagerHymnes;



    DatabaseReference movies;

    IFirebaseLoadDone iFirebaseLoadDone;

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

        movies = FirebaseDatabase.getInstance().getReference("chants");

        //Init Event
        iFirebaseLoadDone = this;

        loadMovie();

        //AudioPlay


        viewPager = (ViewPager)findViewById(R.id.view_pager);
        viewPager.setPageTransformer(true,new AccordionTransformer());
        getIntentInfo();

    }

    private void loadMovie() {
        movies.addListenerForSingleValueEvent(new ValueEventListener() {
            List<MainModel> mainModelList = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot movieSnapShot:snapshot.getChildren())
                    mainModelList.add(movieSnapShot.getValue(MainModel.class));
                iFirebaseLoadDone.onFirebaseLoadSuccess(mainModelList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                iFirebaseLoadDone.onFirebaseFailed(error.getMessage());
            }
        });
    }

    @Override
    public void onFirebaseLoadSuccess(List<MainModel> mainModelList) {

        pagerHymnes = new PagerHymnes(this,mainModelList);
        viewPager.setAdapter(pagerHymnes);
        viewPager.setCurrentItem(position);
    }

    @Override
    public void onFirebaseFailed(String message) {

        Toast.makeText(this, ""+message, Toast.LENGTH_SHORT).show();
    }

    private void getIntentInfo(){
        position = getIntent().getIntExtra("pos",0);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Animatoo.animateSlideLeft(this);
    }

}