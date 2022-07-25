/*
 *  Created by TVB Ledoux on 25/07/22 18:49
 *  Copyright (c) 2022 . All rights reserved.
 *  Last modified 24/07/22 16:32
 */

package com.sda.HymnesAdventiste.chant.models;

public class Model {

    int id, referenceHymne, LyricFavorite;
    String number, titleSwahili, titleEnglish, lyric, lyricAudio, lyricDoh;

//    public Model(int id, int referenceHymne, int lyricFavorite, String number, String titleSwahili, String titleEnglish, String lyric, String lyricAudio, String lyricDoh) {
//        this.id = id;
//        this.referenceHymne = referenceHymne;
//        this.LyricFavorite = lyricFavorite;
//        this.number = number;
//        this.titleSwahili = titleSwahili;
//        this.titleEnglish = titleEnglish;
//        this.lyric = lyric;
//        this.lyricAudio = lyricAudio;
//        this.lyricDoh = lyricDoh;
//    }

//    public Model(int id, String number, String titleSwahili, String titleEnglish, int LyricFavorite, String lyric) {
//        this.id = id;
//        this.number = number;
//        this.titleSwahili = titleSwahili;
//        this.titleEnglish = titleEnglish;
//        this.LyricFavorite = LyricFavorite;
//        this.lyric = lyric;
//    }
    public Model(int id, String number, String titleSwahili, String titleEnglish, int LyricFavorite, String lyric,String lyricAudio) {
        this.id = id;
        this.number = number;
        this.titleSwahili = titleSwahili;
        this.titleEnglish = titleEnglish;
        this.LyricFavorite = LyricFavorite;
        this.lyric = lyric;
        this.lyricAudio = lyricAudio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getReferenceHymne() {
        return referenceHymne;
    }

    public void setReferenceHymne(int referenceHymne) {
        this.referenceHymne = referenceHymne;
    }

    public int getLyricFavorite() {
        return LyricFavorite;
    }

    public void setLyricFavorite(int lyricFavorite) {
        LyricFavorite = lyricFavorite;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTitleSwahili() {
        return titleSwahili;
    }

    public void setTitleSwahili(String titleSwahili) {
        this.titleSwahili = titleSwahili;
    }

    public String getTitleEnglish() {
        return titleEnglish;
    }

    public void setTitleEnglish(String titleEnglish) {
        this.titleEnglish = titleEnglish;
    }

    public String getLyric() {
        return lyric;
    }

    public void setLyric(String lyric) {
        this.lyric = lyric;
    }

    public String getLyricAudio() {
        return lyricAudio;
    }

    public void setLyricAudio(String lyricAudio) {
        this.lyricAudio = lyricAudio;
    }

    public String getLyricDoh() {
        return lyricDoh;
    }

    public void setLyricDoh(String lyricDoh) {
        this.lyricDoh = lyricDoh;
    }
}
