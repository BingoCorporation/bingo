package com.bingo.bingo.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Ebillson GJ on 8/19/2017.
 */

public class CategorieProduit implements Serializable {

    public Entreprise entrepriseId;
    public String nomCategorieProduit;
    public String imageCategorieProduit;
    public Date created;
    public String objectId;

    public CategorieProduit(){}


    public Entreprise getEntrepriseId() {
        return entrepriseId;
    }


    public void setEntrepriseId(Entreprise entrepriseId) {
        this.entrepriseId = entrepriseId;
    }

    public String getNomCategorieProduit() {
        return nomCategorieProduit;
    }

    public void setNomCategorieProduit(String nomCategorieProduit) {
        this.nomCategorieProduit = nomCategorieProduit;
    }

    public String getImageCategorieProduit() {
        return imageCategorieProduit;
    }

    public void setImageCategorieProduit(String imageCategorieProduit) {
        this.imageCategorieProduit = imageCategorieProduit;
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


    public  static ArrayList<CategorieProduit> fromListMap(List<Map> map) {

        ArrayList<CategorieProduit> listeCategorieProduit = new ArrayList<>();

        for(int i = 0; i<map.size(); i++){

            CategorieProduit categorieProd = new CategorieProduit();

            categorieProd.setImageCategorieProduit((String)map.get(i).get("imageCategorieProduit"));
            categorieProd.setNomCategorieProduit((String)map.get(i).get("nomCategorieProduit"));


            // prod.setEtat_produit((Boolean) map.get(i).get("etat_produit"));

            listeCategorieProduit.add(categorieProd);


        }

        return  listeCategorieProduit;

    }






}
