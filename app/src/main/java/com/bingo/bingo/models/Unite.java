package com.bingo.bingo.models;

import java.util.Date;

/**
 * Created by Ebillson GJ on 8/19/2017.
 */

public class Unite {

    public Users id_entreprise;
    public String nom_unite;
    public Date created;

    public Unite() {
    }

    public Users getId_entreprise() {
        return id_entreprise;
    }

    public void setId_entreprise(Users id_entreprise) {
        this.id_entreprise = id_entreprise;
    }

    public String getNom_unite() {
        return nom_unite;
    }

    public void setNom_unite(String nom_unite) {
        this.nom_unite = nom_unite;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
