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
public class totalEstatusColorMapper implements Mapper{
     public Object mapRow(ResultSet rs) throws SQLException {
        DatosBean dat = new DatosBean();
        
      
        
      
                 if (rs.getString("NOM_ESTATUS") != null) {
            dat.setNOM_ESTATUS(rs.getString("NOM_ESTATUS").trim());
        } else {
            dat.setNOM_ESTATUS(rs.getString("NOM_ESTATUS"));
        }
                 
                   if (rs.getString("TOTAL_ESTATUS") != null) {
            dat.setTOTAL_ESTATUS(rs.getString("TOTAL_ESTATUS").trim());
        } else {
            dat.setTOTAL_ESTATUS(rs.getString("TOTAL_ESTATUS"));
        }
                      
                   
                   if (rs.getString("COLOR") != null) {
            dat.setCOLOR(rs.getString("COLOR").trim());
        } else {
            dat.setCOLOR(rs.getString("COLOR"));
        }
                   
                   
         
        return dat;  
        
    }
}
