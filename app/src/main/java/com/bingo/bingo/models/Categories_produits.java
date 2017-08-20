package com.bingo.bingo.models;

import java.util.Date;

/**
 * Created by Ebillson GJ on 8/19/2017.
 */

public class Categories_produits {

    public Users id_entreprise;
    public String nom_categorie;
    public Date created;
    public String objectId;

    public Categories_produits(){}



    public Users getId_entreprise() {
        return id_entreprise;
    }

    public void setId_entreprise(Users id_entreprise) {
        this.id_entreprise = id_entreprise;
    }

    public String getNom_categorie() {
        return nom_categorie;
    }

    public void setNom_categorie(String nom_categorie) {
        this.nom_categorie = nom_categorie;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }
}
