package com.bingo.bingo.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
<<<<<<< HEAD
 * Created by PJS on 8/25/2017.
=======
 * Created by Ebillson GJ on 8/24/2017.
>>>>>>> afd237bea4bd670bb91b1a1957cd2dda8fc15a49
 */

public class Entreprise implements Serializable {

    public CategorieProduit categorieProduitId;
    public Users userId;
    public String imageEntreprise;
    public String nomEntreprise;
    public String descriptionEntreprise;
    public String adresseEntreprise;
    public String emailEntreprise;
    public String phoneEntreprise;
    public Date created;



    public Entreprise() {
    }

    public CategorieProduit getCategorieProduitId() {
        return categorieProduitId;
    }

    public void setCategorieProduitId(CategorieProduit categorieProduitId) {
        this.categorieProduitId = categorieProduitId;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
    }

    public String getImageEntreprise() {
        return imageEntreprise;
    }

    public void setImageEntreprise(String imageEntreprise) {
        this.imageEntreprise = imageEntreprise;
    }

    public String getNomEntreprise() {
        return nomEntreprise;
    }

    public void setNomEntreprise(String nomEntreprise) {
        this.nomEntreprise = nomEntreprise;
    }

    public String getDescriptionEntreprise() {
        return descriptionEntreprise;
    }

    public void setDescriptionEntreprise(String descriptionEntreprise) {
        this.descriptionEntreprise = descriptionEntreprise;
    }

    public String getAdresseEntreprise() {
        return adresseEntreprise;
    }

    public void setAdresseEntreprise(String adresseEntreprise) {
        this.adresseEntreprise = adresseEntreprise;
    }

    public String getEmailEntreprise() {
        return emailEntreprise;
    }

    public void setEmailEntreprise(String emailEntreprise) {
        this.emailEntreprise = emailEntreprise;
    }

    public String getPhoneEntreprise() {
        return phoneEntreprise;
    }

    public void setPhoneEntreprise(String phoneEntreprise) {
        this.phoneEntreprise = phoneEntreprise;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }


    public static ArrayList<Entreprise> fromListMap(List<Map> map){

        ArrayList<Entreprise> listeEntreprise = new ArrayList<>();

        for(int i = 0; i<map.size(); i++){

            Entreprise ent = new Entreprise();

            ent.setNomEntreprise((String)map.get(i).get("nomEntreprise"));
            ent.setDescriptionEntreprise((String)map.get(i).get("descriptionEntreprise"));
            ent.setAdresseEntreprise((String) map.get(i).get("adresseEntreprise"));
            ent.setPhoneEntreprise((String) map.get(i).get("phoneEntreprise"));
            ent.setImageEntreprise((String) map.get(i).get("imageEntreprise"));


            listeEntreprise.add(ent);


        }

        return  listeEntreprise;

    }
}




