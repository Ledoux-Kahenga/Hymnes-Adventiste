package com.sda.projet;

public class MainModel2 {

    String auteur, num, titre, contenu, doh;
    int ref;

    MainModel2()
    {

    }
    public MainModel2(String auteur, String num, String titre, String contenu, int ref, String doh) {
        this.auteur = auteur;
        this.num = num;
        this.titre = titre;
        this.contenu = contenu;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public int getRef() {
        return ref;
    }

    public void setRef(int ref) {
        this.ref = ref;
    }
}
