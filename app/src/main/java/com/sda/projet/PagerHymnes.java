package com.sda.projet;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Parcelable;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;


import com.blogspot.atifsoftwares.animatoolib.Animatoo;

import java.util.ArrayList;
import java.util.List;

public class PagerHymnes extends PagerAdapter {

    Context context;
    List<MainModel> mainModelList;
    LayoutInflater inflater;
    private  boolean flags = true;
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

//        Audio audioC = new Audio(position);
        View view = inflater.inflate(R.layout.chant,container,false);


        String refer;

        //view
        TextView num = (TextView) view.findViewById(R.id.movie_texte);
        TextView titre = (TextView) view.findViewById(R.id.movie_title);
        TextView contenu = (TextView) view.findViewById(R.id.movie_texte_description);
        TextView auteur = (TextView) view.findViewById(R.id.movie_auteur);
        ImageView audio = (ImageView) view.findViewById(R.id.audio);
        ImageView ref = (ImageView) view.findViewById(R.id.ref);


        //set data
        num.setText(Html.fromHtml(mainModelList.get(position).num));
        titre.setText(Html.fromHtml(mainModelList.get(position).titre));
        contenu.setText(Html.fromHtml(mainModelList.get(position).contenu));
        auteur.setText(Html.fromHtml(mainModelList.get(position).auteur));
        refer =  mainModelList.get(position).ref;
         int varRef = Integer.parseInt(refer);

        final String[] cheminAudio = new String[1];

         cheminAudio[0] = mainModelList.get(position).chemin;


        ref.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, MainActivity3.class);
                intent.putExtra("pose", varRef-1);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                context.startActivity(intent);
                Animatoo.animateSpin(context);
            }
        });


//        mediaPlayer = MediaPlayer.create(context,R.raw.a001);
//        MediaPlayer.create(this, Integer.valueOf(resources.getIdentifier(stringBuilder2, "raw", context.getPackageName())).intValue());


                audio.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

//                        int i=NumberFormat.getInstance().parse(s).intValue();


//                        try{
//                            cheminAudio[0] = String.valueOf(Integer.parseInt(cheminAudio[0]));
//
//
//                        }catch (NumberFormatException e){
//                            e.printStackTrace();
//                        }


//                        mediaPlayer = MediaPlayer.create(context, cheminAudio[0]);
//                        mediaPlayer.start();


                    }

                });



        container.addView(view);
        return view;
    }



}
