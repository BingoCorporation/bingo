package com.bingo.bingo.models;

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

public class Entreprise {

    public Categories_produits categorieId;
    public Users userId;
    public String imageEntreprise;
    public String nomEntreprise;
    public String adresseEntreprise;
    public String emailEntreprise;
    public String phoneEntreprise;
    public Date created;



    public Entreprise() {
    }

    public Entreprise(String nomEntreprise, String adresseEntreprise, String imageEntreprise) {
        this.nomEntreprise = nomEntreprise;
        this.adresseEntreprise = adresseEntreprise;
        this.imageEntreprise = imageEntreprise;
    }

    public Categories_produits getCategorieId() {
        return categorieId;
    }

    public void setCategorieId(Categories_produits categorieId) {
        this.categorieId = categorieId;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
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

    public String getNomEntreprise() {
        return nomEntreprise;
    }

    public void setNomEntreprise(String nomEntreprise) {
        this.nomEntreprise = nomEntreprise;
    }

    public String getPhoneEntreprise() {
        return phoneEntreprise;
    }

    public void setPhoneEntreprise(String phoneEntreprise) {
        this.phoneEntreprise = phoneEntreprise;
    }

    public String getImageEntreprise() {
        return imageEntreprise;
    }

    public void setImageEntreprise(String imageEntreprise) {
        this.imageEntreprise = imageEntreprise;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }






   /* public static ArrayList<Entreprise> getEntreprise(){

        ArrayList<Entreprise> Entreprise = new ArrayList<>();
        Entreprise.add(new Entreprise("Oli's Turgeau","Turgeau","https://develop.backendless.com/6489B38C-DCC1-9240-FF77-984DC15FAB00/console/gkblvphjyhannobwqgljgbqofmhjdozwzfrc/files/view/businessImages/download.png"));
        Entreprise.add(new Entreprise("Oli's PV","Petion-Ville","https://develop.backendless.com/6489B38C-DCC1-9240-FF77-984DC15FAB00/console/gkblvphjyhannobwqgljgbqofmhjdozwzfrc/files/view/businessImages/download.png"));
        Entreprise.add(new Entreprise("Dominoes","Turgeau","https://develop.backendless.com/6489B38C-DCC1-9240-FF77-984DC15FAB00/console/gkblvphjyhannobwqgljgbqofmhjdozwzfrc/files/view/businessImages/download.png"));
        Entreprise.add(new Entreprise("Kokoye Delmas","Delmas","https://develop.backendless.com/6489B38C-DCC1-9240-FF77-984DC15FAB00/console/gkblvphjyhannobwqgljgbqofmhjdozwzfrc/files/view/businessImages/download.png"));

        Entreprise.add(new Entreprise("Kokoye PV","Petion-Ville","https://develop.backendless.com/6489B38C-DCC1-9240-FF77-984DC15FAB00/console/gkblvphjyhannobwqgljgbqofmhjdozwzfrc/files/view/businessImages/download.png"));
        Entreprise.add(new Entreprise("Rekreation","Turgeau","https://develop.backendless.com/6489B38C-DCC1-9240-FF77-984DC15FAB00/console/gkblvphjyhannobwqgljgbqofmhjdozwzfrc/files/view/businessImages/download.png"));
        Entreprise.add(new Entreprise("Prestige","Turgeau","https://develop.backendless.com/6489B38C-DCC1-9240-FF77-984DC15FAB00/console/gkblvphjyhannobwqgljgbqofmhjdozwzfrc/files/view/businessImages/download.png"));
        Entreprise.add(new Entreprise("Muncheez Bois Verna","Bois Verna","https://develop.backendless.com/6489B38C-DCC1-9240-FF77-984DC15FAB00/console/gkblvphjyhannobwqgljgbqofmhjdozwzfrc/files/view/businessImages/download.png"));
        Entreprise.add(new Entreprise("Muncheez PV","Petion-Ville","https://develop.backendless.com/6489B38C-DCC1-9240-FF77-984DC15FAB00/console/gkblvphjyhannobwqgljgbqofmhjdozwzfrc/files/view/businessImages/download.png"));

        Entreprise.add(new Entreprise("Delice ","Petion-Ville","https://develop.backendless.com/6489B38C-DCC1-9240-FF77-984DC15FAB00/console/gkblvphjyhannobwqgljgbqofmhjdozwzfrc/files/view/businessImages/download.png"));


        return Entreprise;

    }*/

    public static ArrayList<Entreprise> fromListMap(List<Map> map){

        ArrayList<Entreprise> listeEntreprise = new ArrayList<>();

        for(int i = 0; i<map.size(); i++){

            Entreprise ent = new Entreprise();

            ent.setNomEntreprise((String)map.get(i).get("nomEntreprise"));
            ent.setAdresseEntreprise((String) map.get(i).get("adresseEntreprise"));
            ent.setImageEntreprise((String) map.get(i).get("imageEntreprise"));

            listeEntreprise.add(ent);


        }

        return  listeEntreprise;

    }
}




