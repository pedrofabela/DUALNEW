/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mappers;

import beans.ProyectoBean;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author pedro
 */
public class VerificaAsesorMapper implements Mapper{
    
    public Object mapRow(ResultSet rs) throws SQLException {
        ProyectoBean pro = new ProyectoBean();
        
      
        
        
        if (rs.getString("CURP") != null) {
            pro.setCURP_A(rs.getString("CURP").trim());
        } else {
            pro.setCURP_A(rs.getString("CURP"));
        }
        
        
           
         
        
        return pro;  
        
    }
    
}
