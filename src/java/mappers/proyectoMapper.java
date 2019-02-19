/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mappers;

import beans.DatosBean;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author pedro
 */
public class proyectoMapper implements Mapper{
      public Object mapRow(ResultSet rs) throws SQLException {
        DatosBean dat = new DatosBean();
        
      
        
      
                 if (rs.getString("TOTAL_PROYECTOS") != null) {
            dat.setTOTAL_PROYECTOS(rs.getString("TOTAL_PROYECTOS").trim());
        } else {
            dat.setTOTAL_PROYECTOS(rs.getString("TOTAL_PROYECTOS"));
        }
                 
             
                   
                   
         
        return dat;  
        
    }
    
}
