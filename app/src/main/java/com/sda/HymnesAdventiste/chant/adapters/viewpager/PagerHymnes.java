/*
 *  Created by TVB Ledoux on 25/07/22 18:49
 *  Copyright (c) 2022 . All rights reserved.
 *  Last modified 24/07/22 16:32
 */

package com.sda.HymnesAdventiste.chant.adapters.viewpager;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;


import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.sda.HymnesAdventiste.chant.models.MainModel;
import com.sda.HymnesAdventiste.R;
import com.sda.HymnesAdventiste.chant.audio.AudioPlay;
import com.sda.HymnesAdventiste.chant.chantActivity.NyimboActivity;

import java.util.ArrayList;
import java.util.List;

public class PagerHymnes extends PagerAdapter {

    Context context;
    List<MainModel> mainModelList;
    LayoutInflater inflater;
//    private  boolean flags = true;
    private  MediaPlayer mediaPlayer;
//    private static MediaPlayer mp2 = null;
//    private static boolean myIsPlaying = false;
//    private static int nowPlaying;
//    private int DisplayedSongNo;
//
    private List<String> allmp3 = new ArrayList();

//    ArrayList<String> StrigList;
//    MediaPlayer mediaPlayer;


    public PagerHymnes(Context context, List<MainModel> mainModelList) {
        this.context = context;
        this.mainModelList = mainModelList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mainModelList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
             container.removeView((ViewGroup)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        // inflate View

//        AudioPlay audioC = new AudioPlay(position);
        View view = inflater.inflate(R.layout.chant,container,false);


        String refer;

        //view
        TextView num = (TextView) view.findViewById(R.id.movie_texte);
        TextView titre = (TextView) view.findViewById(R.id.movie_title);
        TextView contenu = (TextView) view.findViewById(R.id.movie_texte_description);
        TextView auteur = (TextView) view.findViewById(R.id.movie_auteur);
        ImageView audio = (ImageView) view.findViewById(R.id.audio);
        ImageView ref = (ImageView) view.findViewById(R.id.ref);
        String midi;


        //set data
        num.setText(Html.fromHtml(mainModelList.get(position).num));
        titre.setText(Html.fromHtml(mainModelList.get(position).titre));
        contenu.setText(Html.fromHtml(mainModelList.get(position).contenu));
        auteur.setText(Html.fromHtml(mainModelList.get(position).auteur));
        refer =  mainModelList.get(position).ref;
        midi = mainModelList.get(position).chemin;
         int varRef = Integer.parseInt(refer);


        ref.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, NyimboActivity.class);
                intent.putExtra("pose", varRef-1);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                context.startActivity(intent);
                Animatoo.animateSpin(context);
            }
        });



                audio.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        int resID = context.getResources().getIdentifier(midi,"raw",context.getPackageName());


                        if (AudioPlay.mediaPlayer == null) {

                            AudioPlay.playAudio(context,resID);
                            audio.setImageResource(R.drawable.ic_stop);

                        } else if (AudioPlay.mediaPlayer != null) {

                            AudioPlay.stopAudio();
                            audio.setImageResource(R.drawable.ic_play_btn);
                        }

                    }

                });



        container.addView(view);
        return view;
    }



}
