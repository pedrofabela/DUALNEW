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
public class munEscMapper implements Mapper{
    public Object mapRow(ResultSet rs) throws SQLException {
        DatosBean dat = new DatosBean();
        
      
        
      
                 if (rs.getString("NOMESC") != null) {
            dat.setNOMESC(rs.getString("NOMESC").trim());
        } else {
            dat.setNOMESC(rs.getString("NOMESC"));
        }
                 
                   if (rs.getString("MUNICIPIO_ACTIVOS") != null) {
            dat.setMUNICIPIO_ACTIVOS(rs.getString("MUNICIPIO_ACTIVOS").trim());
        } else {
            dat.setMUNICIPIO_ACTIVOS(rs.getString("MUNICIPIO_ACTIVOS"));
        }
                   
            
                   if (rs.getString("MUNICIPIO_INACTIVOS") != null) {
            dat.setMUNICIPIO_INACTIVOS(rs.getString("MUNICIPIO_INACTIVOS").trim());
        } else {
            dat.setMUNICIPIO_INACTIVOS(rs.getString("MUNICIPIO_INACTIVOS"));
        }    
                   
                     if (rs.getString("MUNICIPIO_EGRESADOS") != null) {
            dat.setMUNICIPIO_EGRESADOS(rs.getString("MUNICIPIO_EGRESADOS").trim());
        } else {
            dat.setMUNICIPIO_EGRESADOS(rs.getString("MUNICIPIO_EGRESADOS"));
        }         
         
        return dat;  
        
    }
}
