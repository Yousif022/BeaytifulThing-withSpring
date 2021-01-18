/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import beans.beautifulthing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;




public class databaseService2 {

    private JdbcTemplate template;

    public JdbcTemplate getTemplate() {
        return template;
    }

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }
    
    public boolean insertoneitem(beautifulthing b) throws SQLException{
      
        
        
        String inserstData = "INSERT INTO `thingstable` (`Id`, `thing-title`, `thing-description`, `thing-value`) "
                    + "VALUES ( NULL , ? , ? , ?)";
        
        
        return template.execute(inserstData , new PreparedStatementCallback<Boolean>(){
            
            @Override
            public  Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                
                 ps.setString(1, b.getThingTitle());
                ps.setString(2, b.getThingDescription());
                ps.setInt(3, b.getRating());
                
                return ps.execute();
            }
            
                }); 
        
           
                }
    
    public ArrayList<beautifulthing> readAll() throws SQLException{
        
        ArrayList<beautifulthing> everyone = new ArrayList<>();
        beautifulthing b;
        
        // i failed to extract the data from database with the use of spring 
        Connection c = null;
            Statement stmt = null;
            ResultSet rs = null;
        
     c = DriverManager.getConnection("jdbc:mysql://localhost:3306/beautifulthings?zeroDateTimeBehavior=convertToNull", "root", "");
        
        stmt = c.createStatement();
            
            //execute the statement
            rs = stmt.executeQuery("SELECT * FROM `thingstable`");
        
          while(rs.next()){
                
                b = new beautifulthing(rs.getInt("Id") , rs.getString("thing-title"), rs.getString("thing-description") , rs.getInt("thing-value"));
                
                everyone.add(b);
            }
         
     return everyone;
    }
    
    
    public boolean updateoneitem(beautifulthing b) throws SQLException{
      
        
        
        String inserstData = "UPDATE `thingstable` SET `thing-title`= ?,`thing-description`= ?,`thing-value`= ?  WHERE Id = ?";
        
        
        return template.execute(inserstData , new PreparedStatementCallback<Boolean>(){
            
            @Override
            public  Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                
                 ps.setString(1, b.getThingTitle());
                ps.setString(2, b.getThingDescription());
                ps.setInt(3, b.getRating());
                ps.setInt(4, b.getId());
                
                return ps.execute();
            }
            
                }); 
        
           
                }
    public boolean deleteoneitem(beautifulthing b) throws SQLException{
      
        
        
        String inserstData = "delete from `thingstable` where Id = ?";
        
        
        return template.execute(inserstData , new PreparedStatementCallback<Boolean>(){
            
            @Override
            public  Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                
               
                ps.setInt(1, b.getId());
                
                return ps.execute();
            }
            
                }); 
        
           
                }
}
