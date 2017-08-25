package com.bingo.bingo.models;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Ebillson GJ on 8/19/2017.
 */

public class produits {

    public Boolean etat_produit;
    public Categories_produits id_categorie;
    public Unite id_unite;
    public String nom_produit;
    public Double prix_prod;
    public Date created;
    public String objectId;


    public produits(){}

    public produits(String nom_produit) {
        this.nom_produit = nom_produit;
    }

    public Boolean getEtat_produit() {
        return etat_produit;
    }

    public void setEtat_produit(Boolean etat_produit) {
        this.etat_produit = etat_produit;
    }

    public Categories_produits getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(Categories_produits id_categorie) {
        this.id_categorie = id_categorie;
    }

    public Unite getId_unite() {
        return id_unite;
    }

    public void setId_unite(Unite id_unite) {
        this.id_unite = id_unite;
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





    public static ArrayList<produits>getProduits(){

        ArrayList<produits> produits = new ArrayList<>();
        produits.add(new produits("Pizzas"));
        produits.add(new produits("Subs"));
        produits.add(new produits("Cremes a la glace"));
        produits.add(new produits("Autres"));
        return produits;

    }
}
