/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ausflugsplanner;

import java.io.Serializable;
import java.util.ArrayList;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author Jasha
 */
@Named(value = "ausflugBean")
@ApplicationScoped
public class AusflugBean implements Serializable{
private String tag;
private String wetter;
private String schule;
private String zeit;
private String kinder;
//private String result = "";
ArrayList<String>trips = new ArrayList<String>();
    /**
     * Creates a new instance of AusflugBean
     */

     

    public ArrayList<String> getTrips() {
        return trips;
    }

    public void setTrips(ArrayList<String> trips) {
        this.trips = trips;
    }
    
    

    public AusflugBean() {
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setWetter(String wetter) {
        this.wetter = wetter;
    }

    public void setSchule(String schule) {
        this.schule = schule;
    }

    public void setZeit(String zeit) {
        this.zeit = zeit;
    }

    public void setKinder(String kinder) {
        this.kinder = kinder;
    }

    public String getTag() {
        return tag;
    }

    public String getWetter() {
        return wetter;
    }

    public String getSchule() {
        return schule;
    }

    public String getZeit() {
        return zeit;
    }

    public String getKinder() {
        return kinder;
    }

   /* public void setResult(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }*/
    
    
    //_______________________________________________________________________________________________________________________________________
        boolean kegeln, freibad, hallenbad, dunkelwald, musik, brotbackkurs, schieferbergwerk, gokurs, billard, rennauto, openair, korbflechten, wasserfall, zoobesuch;

        boolean wochentag, wetterschoen, ferien, tagsueber, mitKindern;
    
    public void chooseTrip(){
        /*//Kegeln/Musikkurs
        if(tag == "Wochentag" && zeit == "Abend"){
            result += "Kegeln / ";
            if(schule == "Schule"){
                result += "Musikkurs";
            }
        }
        if(tag == "Wochenende" && zeit == "Tagsüber"){
            result += "Kegeln / ";
        }
        
        //Freibad und Wandern im Dunkewald
        if(zeit == "Tagsüber" && wetter == "Schönes Wetter"){
            result += "Freibad / Wandern im Dunkelwald / ";
        }
        
        //Hallenbad
        if (!(tag == "Wochenende" && !(schule == "Schulferien"))){
            result += "Hallenbad / ";
        }*/
        
        
        wochentag    = (tag == "Wochentag");
        wetterschoen = (wetter == "schönes Wetter");
        ferien       = (schule == "Schulferien");
        tagsueber    = (zeit == "Tagsüber");
        mitKindern   = (kinder == "Ausflug mit Kindern");
        calc();
        vorschlaegeAusgeben();
        
    }
    
    private void calc(){
        boolean wochenEnde     = !wochentag   ;
        boolean schlechtWetter = !wetterschoen;
        boolean schulzeit      = !ferien      ;
        boolean abends         = !tagsueber   ;
        boolean nurErwachsene  = !mitKindern  ;
 
        kegeln            = abends || wochenEnde;
        freibad           = wetterschoen && tagsueber;
        hallenbad         = !(ferien && wochenEnde);
        dunkelwald        = freibad;
        musik             = abends && schulzeit;
        brotbackkurs      = wochenEnde && schlechtWetter;
        schieferbergwerk  = tagsueber || (wochenEnde && ferien);
        gokurs          = (wochenEnde && schlechtWetter) || (wochentag && abends && wetterschoen);
        billard           = nurErwachsene && (abends || wochenEnde);
        rennauto          = nurErwachsene && tagsueber && ferien && wochenEnde;
        openair     =       wetterschoen && (abends || wochenEnde);
        korbflechten      = ferien && schlechtWetter && wochentag;
        wasserfall        = tagsueber;
        zoobesuch         = true;
    }
    
    private void vorschlaegeAusgeben(){
        if(kegeln           ) {trips.add("Kegeln");}
        if(freibad          ) {trips.add("Freibad");}
        if(hallenbad        ) {trips.add("Hallenbad");}
        if(dunkelwald       ) {trips.add("Dunkelwald");}
        if(musik            ) {trips.add("Musikkurs");}
        if(brotbackkurs     ) {trips.add("Brotbackkurs");}
        if(schieferbergwerk ) {trips.add("Schieferbergwerk");}
        if(gokurs         ) {trips.add("Go Kurs");}
        if(billard          ) {trips.add("Billard");}
        if(rennauto         ) {trips.add("Rennauto");}
        if(openair    ) {trips.add("Open Air Kino");}
        if(korbflechten     ) {trips.add("Korbflechten");}
        if(wasserfall       ) {trips.add("Wasserfall");}
        if(zoobesuch        ) {trips.add("Zoobesuch");}
    }

    public String nextPage(){
        return "/result";
    }
}
