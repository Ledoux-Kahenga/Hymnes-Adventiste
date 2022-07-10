package com.sda.projet.navigation;


import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.sda.projet.R;
import com.sda.projet.chant.Hymnes_et_lg;
import com.sda.projet.chant.Nyimbo_z_kristo;

import org.joda.time.DateTimeConstants;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class HomeFragment extends Fragment {
    Context context;
    private HomeViewModel homeViewModel;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.homeViewModel = (HomeViewModel) new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

//        DateTimeFormatter dateTimeFormatter = null;
//
//
        TextView textView = root.findViewById(R.id.titreacceuil1);
//
//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
//            LocalDate date = LocalDate.now();
//            dateTimeFormatter.ofPattern("EEE, MMM d, ''yy");
//            String dater = dateTimeFormatter.format(date);
////                    Toast.makeText(HomeFragment.this.getContext(), "nous sommes " +dater, Toast.LENGTH_SHORT).show();

//        }


//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            LocalDate today = LocalDate.now().plusDays(1);
//
//            LocalDate sabbat = LocalDate.now().with(DayOfWeek.SATURDAY).plusDays(1);
//            LocalDate vendredi = LocalDate.now().with(DayOfWeek.FRIDAY);
//            LocalDate resut = LocalDate.now().;
//
//            textView.setText(""+vendredi);
//        }


        ((ImageView) root.findViewById(R.id.img_livre2)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                HomeFragment.this.startActivity(new Intent(HomeFragment.this.getActivity(), Nyimbo_z_kristo.class));
                Animatoo.animateSlideLeft(HomeFragment.this.getContext());
            }
        });

        ((ImageView) root.findViewById(R.id.img_livre1)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                HomeFragment.this.startActivity(new Intent(HomeFragment.this.getActivity(), Hymnes_et_lg.class));
                Animatoo.animateSlideRight(HomeFragment.this.getContext());
            }
        });



        return root;
    }

//    public void getDate(View view){
//        DateTimeFormatter dateTimeFormatter = null;
//
//
//
//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
//            LocalDate date = LocalDate.now();
//            dateTimeFormatter.ofPattern("E");
//            Toast.makeText(HomeFragment.this.getContext(), "nous sommes " +dateTimeFormatter, Toast.LENGTH_SHORT).show();
//        }
//    }
}
