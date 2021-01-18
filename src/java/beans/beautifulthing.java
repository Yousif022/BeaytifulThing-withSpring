/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.faces.bean.ManagedBean;

/**
 *
 * @author framawy
 */
@ManagedBean

public class beautifulthing {
    int id;
    String thingTitle;
    String thingDescription;
    int rating;

    public beautifulthing(int id, String thingTitle, String thingDescription, int rating) {
        this.id = id;
        this.thingTitle = thingTitle;
        this.thingDescription = thingDescription;
        this.rating = rating;
    }
    public beautifulthing(){
        
        
    }

    

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getThingTitle() {
        return thingTitle;
    }

    public void setThingTitle(String thingTitle) {
        this.thingTitle = thingTitle;
    }

    public String getThingDescription() {
        return thingDescription;
    }

    public void setThingDescription(String thingDescription) {
        this.thingDescription = thingDescription;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
    
    
}
