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
public class listaMunicipiosMapper implements Mapper{
    
    public Object mapRow(ResultSet rs) throws SQLException {
        DatosBean dat = new DatosBean();
        
      
        
         if (rs.getString("ID") != null) {
            dat.setID(rs.getString("ID").trim());
        } else {
            dat.setID(rs.getString("ID"));
        }
        
      
            
         if (rs.getString("MUNICIPIO") != null) {
            dat.setMUNICIPIO(rs.getString("MUNICIPIO").trim());
        } else {
            dat.setMUNICIPIO(rs.getString("MUNICIPIO"));
        }
         
         
         
        return dat;  
        
    }
    
}
