/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

        
package Controller;

import beans.beautifulthing;

import database.databaseService2;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;

import javax.faces.context.FacesContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 *
 * @author framawy
 */
@ManagedBean

public class FormController {
    
    
    public String OnSubmit() throws SQLException{   
        //read the "get" value from the form 
        FacesContext context = FacesContext.getCurrentInstance();
        // store the "get" values in an object
        beautifulthing b = context.getApplication().evaluateExpressionGet(context,"#{beautifulthing}", beautifulthing.class);
        //hold the value of the object that was in the web page
        
        System.out.println("The Object you entered is : " + b.getThingTitle());
        //put the get values into a response page
        FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("beautifulthing", b);
        //store the object in the database
        
       ApplicationContext context2 = new FileSystemXmlApplicationContext("C:/Users/framawy/Documents/NetBeansProjects/BeaytifulThing-withSpring/web/WEB-INF/ApplicationContext.xml"); 
        databaseService2 da =(databaseService2)context2.getBean("dbi");
        Boolean B  = da.insertoneitem(b);
         
       //show the response page.
        
       return "ResponsePage.xhtml";
    }
    public String showEntryForm(){
         
         return "EntryForm.xhtml";
     }
     public String showAll(){
         
         return "index.xhtml";
     }
      public  ArrayList<beautifulthing> GetAll() throws SQLException{
        databaseService2 db = new databaseService2();
         
        return db.readAll();
    }
      
     
       public String OnSubmitEdit() throws SQLException{
        // when the users creates a new item
        
        
        //read the "get" value from the form 
        FacesContext context = FacesContext.getCurrentInstance();
       // store the "get" values in an object 
       beautifulthing b = context.getApplication().evaluateExpressionGet(context,"#{beautifulthing}", beautifulthing.class);
       
       ApplicationContext context2 = new FileSystemXmlApplicationContext("C:/Users/framawy/Documents/NetBeansProjects/BeaytifulThing-withSpring/web/WEB-INF/ApplicationContext.xml"); 
        databaseService2 da =(databaseService2)context2.getBean("dbi");
        Boolean B  = da.updateoneitem(b);
       
       //put the get values into a response page 
       FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("beautifulthing", b);
      
       //store the object in the database 
      
       
      
       
       //show the response page.
        
       return "ResponsePage.xhtml";
}
       
       public String deleteOn(beautifulthing b) throws SQLException{
        
        
        System.out.println("The Object you deleted is : " + b.getThingTitle());
       ApplicationContext context2 = new FileSystemXmlApplicationContext("C:/Users/framawy/Documents/NetBeansProjects/BeaytifulThing-withSpring/web/WEB-INF/ApplicationContext.xml"); 
        databaseService2 da =(databaseService2)context2.getBean("dbi");
        Boolean B  = da.deleteoneitem(b);
        
        FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("beautifulthing", b);
       
        
        
        return "ResponsePage.xhtml";
    }
        public String OnShowEdit(beautifulthing b){
        
        System.out.println("The Object you deleted is : " + b.getThingTitle());
        
         FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("beautifulthing", b);
        return "EditForm.xhtml";    
    }     
     
}