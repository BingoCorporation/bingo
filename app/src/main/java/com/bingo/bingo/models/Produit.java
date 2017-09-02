package com.bingo.bingo.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Ebillson GJ on 8/19/2017.
 */

public class Produit {

    public Boolean etatProduit;
    public CategorieProduit categorieProduitId;
    public Unite uniteId;
    public String nomProduit;
    public Double prixProduit;
    public Date created;
    public String objectId;


    public Produit(){}

    public Boolean getEtatProduit() {
        return etatProduit;
    }

    public void setEtatProduit(Boolean etatProduit) {
        this.etatProduit = etatProduit;
    }

    public CategorieProduit getCategorieProduitId() {
        return categorieProduitId;
    }

    public void setCategorieProduitId(CategorieProduit categorieProduitId) {
        this.categorieProduitId = categorieProduitId;
    }

    public Unite getUniteId() {
        return uniteId;
    }

    public void setUniteId(Unite uniteId) {
        this.uniteId = uniteId;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public Double getPrixProduit() {
        return prixProduit;
    }

    public void setPrixProduit(Double prixProduit) {
        this.prixProduit = prixProduit;
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


    public  static ArrayList<Produit> fromListMap(List<Map> map) {

        ArrayList<Produit> listeProduit = new ArrayList<>();

        for(int i = 0; i<map.size(); i++){

            Produit prod = new Produit();

            prod.setNomProduit((String)map.get(i).get("nomProduit"));
            prod.setPrixProduit(Double.parseDouble(map.get(i).get("prixProduit").toString()));

           // prod.setEtat_produit((Boolean) map.get(i).get("etat_produit"));

            listeProduit.add(prod);


        }

        return  listeProduit;

    }
}
