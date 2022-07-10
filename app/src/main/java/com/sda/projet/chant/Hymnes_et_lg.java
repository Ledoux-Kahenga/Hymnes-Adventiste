package com.sda.projet.chant;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.sda.projet.MainModel;
import com.sda.projet.R;
//import com.sda.projet.chant.model.adapteur.recyclerview.HymnesAdapteur;
import com.sda.projet.chant.model.adapteur.recyclerview.RecyclerViewAdapteurHymne;
import com.sda.projet.navigation.HomeFragment;
import com.sda.projet.parametres.SharedPref;

import java.util.ArrayList;

public class Hymnes_et_lg extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerViewAdapteurHymne mainAdapter;

    DatabaseReference databaseReference;
    ArrayList<MainModel> list;

    private SharedPref sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        sharedPref = new SharedPref(this);
        if (sharedPref.loardDarkModeState()) {
            setTheme(R.style.AppThemeDark);
            getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.dark));
        } else {
            setTheme(R.style.AppThemeLight);
//            getWindow().setStatusBarColor(ContextCompat.getColor(this,R.color.primary_fond));
            getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.primary_fond));
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hymnes_et_lg);

        ((ImageView) findViewById(R.id.imageBack)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onBackPressed();
                Animatoo.animateSwipeLeft(Hymnes_et_lg.this);
            }
        });


        recyclerView = findViewById(R.id.recycler_view);
        databaseReference = FirebaseDatabase.getInstance().getReference("chants");
        databaseReference.keepSynced(true);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();

        mainAdapter = new RecyclerViewAdapteurHymne(this, list);
        recyclerView.setAdapter(mainAdapter);

        // RECHERCHE DES CHANTS

        EditText inputSearch = findViewById(R.id.inputSearch);

        inputSearch.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.setFocusable(true);
                v.setFocusableInTouchMode(true);
                return false;
            }
        });

        inputSearch.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mainAdapter.suppTimer();
            }

            public void afterTextChanged(Editable s) {
                if (list.size() != 0) {
                    mainAdapter.rechercheChant(s.toString());
                }
            }
        });

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {

                    MainModel mainModel = dataSnapshot.getValue(MainModel.class);
                    list.add(mainModel);

                }

                mainAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


//        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        databaseReference = FirebaseDatabase.getInstance().getReference().child("chants");
//        databaseReference.keepSynced(true);

//        FirebaseRecyclerOptions<MainModel> options =
//                new FirebaseRecyclerOptions.Builder<MainModel>()
//                        .setQuery(databaseReference, MainModel.class)
//                        .build();
//
//
//        mainAdapter = new HymnesAdapteur(options);
//        recyclerView.setAdapter(mainAdapter);

    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//        mainAdapter.startListening();
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        mainAdapter.stopListening();
//    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Animatoo.animateSlideLeft(this);
    }
}