package com.sda.projet;

public class MainModel {

    String auteur, num, titre, contenu, ref, chemin;

    MainModel()
    {

    }

    public MainModel(String auteur, String num, String titre, String contenu, String ref, String chemin) {
        this.auteur = auteur;
        this.num = num;
        this.titre = titre;
        this.contenu = contenu;
        this.ref = ref;
        this.chemin = chemin;
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

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getChemin() {
        return chemin;
    }

    public void setChemin(String chemin) {
        this.chemin = chemin;
    }
}
