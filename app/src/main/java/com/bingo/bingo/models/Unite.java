package com.bingo.bingo.models;

import java.util.Date;

/**
 * Created by Ebillson GJ on 8/19/2017.
 */

public class Unite {


    public Entreprise entrepriseId;
    public String nom_unite;
    public Date created;



    public Unite() {
    }

    public Entreprise getEntrepriseId() {
        return entrepriseId;
    }

    public void setEntrepriseId(Entreprise entrepriseId) {
        this.entrepriseId = entrepriseId;
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
