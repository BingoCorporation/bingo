package com.bingo.bingo.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Ebillson GJ on 8/19/2017.
 */

public class Produits {

    public Boolean etat_produit;
    public Categories_produits categorieId;
    public Unite uniteId;
    public String nom_produit;
    public Double prix_prod;
    public Date created;
    public String objectId;


    public Produits(){}

    public Produits(String nom_produit) {
        this.nom_produit = nom_produit;
    }

    public Boolean getEtat_produit() {
        return etat_produit;
    }

    public void setEtat_produit(Boolean etat_produit) {
        this.etat_produit = etat_produit;
    }

    public Categories_produits getCategorieId() {
        return categorieId;
    }

    public void setCategorieId(Categories_produits categorieId) {
        this.categorieId = categorieId;
    }

    public Unite getUniteId() {
        return uniteId;
    }

    public void setUniteId(Unite uniteId) {
        this.uniteId = uniteId;
    }

    public String getNom_produit() {
        return nom_produit;
    }

    public void setNom_produit(String nom_produit) {
        this.nom_produit = nom_produit;
    }

    public Double getPrix_prod() {
        return prix_prod;
    }

    public void setPrix_prod(Double prix_prod) {
        this.prix_prod = prix_prod;
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





    /*public static ArrayList<Produits>getProduits(){

        ArrayList<Produits> Produits = new ArrayList<>();
        Produits.add(new Produits("Pizzas"));
        Produits.add(new Produits("Subs"));
        Produits.add(new Produits("Cremes a la glace"));
        Produits.add(new Produits("Autres"));
        return Produits;

    }*/

    public  static ArrayList<Produits> fromListMap(List<Map> map) {

        ArrayList<Produits> listeProduit = new ArrayList<>();

        for(int i = 0; i<map.size(); i++){

            Produits prod = new Produits();

            prod.setNom_produit((String)map.get(i).get("nom_produit"));
            prod.setPrix_prod((Double) map.get(i).get("prix_prod"));
            prod.setEtat_produit((Boolean) map.get(i).get("etat_produit"));

            listeProduit.add(prod);


        }

        return  listeProduit;

    }
}
