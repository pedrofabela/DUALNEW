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
public class empAluMapper implements Mapper{
    
    
    public Object mapRow(ResultSet rs) throws SQLException {
        DatosBean dat = new DatosBean();
        
      
        
      
                 if (rs.getString("RFC") != null) {
            dat.setRFC(rs.getString("RFC").trim());
        } else {
            dat.setRFC(rs.getString("RFC"));
        }
                 
                   if (rs.getString("RAZON_SOCIAL") != null) {
            dat.setRAZON_SOCIAL(rs.getString("RAZON_SOCIAL").trim());
        } else {
            dat.setRAZON_SOCIAL(rs.getString("RAZON_SOCIAL"));
        }
                   
         
                   if (rs.getString("NOM_MUN") != null) {
            dat.setNOM_MUN(rs.getString("NOM_MUN").trim());
        } else {
            dat.setNOM_MUN(rs.getString("NOM_MUN"));
        }
                   
                   
                   
       if (rs.getString("TOTAL_ALUMNOS_EMPRESA") != null) {
            dat.setTOTAL_ALUMNOS_EMPRESA(rs.getString("TOTAL_ALUMNOS_EMPRESA").trim());
        } else {
            dat.setTOTAL_ALUMNOS_EMPRESA(rs.getString("TOTAL_ALUMNOS_EMPRESA"));
        }
            
       
       if (rs.getString("GIRO") != null) {
            dat.setGIRO(rs.getString("GIRO").trim());
        } else {
            dat.setGIRO(rs.getString("GIRO"));
        }
       
       
       if (rs.getString("SECTOR") != null) {
            dat.setSECTOR(rs.getString("SECTOR").trim());
        } else {
            dat.setSECTOR(rs.getString("SECTOR"));
        }
        if (rs.getString("CCT") != null) {
            dat.setCCT(rs.getString("CCT").trim());
        } else {
            dat.setCCT(rs.getString("CCT"));
        }
         
        return dat;  
        
    }
    
}
