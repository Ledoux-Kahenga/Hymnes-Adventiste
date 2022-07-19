/*
 *  Created by TVB Ledoux on 19/07/22 15:58
 *  Copyright (c) 2022 . All rights reserved.
 *  Last modified 19/07/22 14:39
 */

package com.sda.projet.chant.audio;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;

import com.sda.projet.R;

public class AudioPlay {

    public static MediaPlayer mediaPlayer;

    public static void playAudio(Context context, int id){
        mediaPlayer = MediaPlayer.create(context, id);

        if (!mediaPlayer.isPlaying()){

            mediaPlayer.start();
        }
    }

    public static void stopAudio(){
        mediaPlayer.release();
        mediaPlayer = null;
    }


}
