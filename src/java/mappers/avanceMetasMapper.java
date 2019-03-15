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
public class avanceMetasMapper implements Mapper{
    
    public Object mapRow(ResultSet rs) throws SQLException {
        DatosBean dat = new DatosBean();
        
      
        
      
                 if (rs.getString("CVE_INSTITUCIONAL") != null) {
            dat.setCVE_INSTITUCIONAL(rs.getString("CVE_INSTITUCIONAL").trim());
        } else {
            dat.setCVE_INSTITUCIONAL(rs.getString("CVE_INSTITUCIONAL"));
        }
                 
                   if (rs.getString("MATRICULA") != null) {
            dat.setMATRICULA(rs.getString("MATRICULA").trim());
        } else {
            dat.setMATRICULA(rs.getString("MATRICULA"));
        }
             
                   if (rs.getString("META") != null) {
            dat.setMETA(rs.getString("META").trim());
        } else {
            dat.setMETA(rs.getString("META"));
        }  
                     if (rs.getString("PORCENTAJE_META") != null) {
            dat.setPORCENTAJE_META(rs.getString("PORCENTAJE_META").trim());
        } else {
            dat.setPORCENTAJE_META(rs.getString("PORCENTAJE_META"));
        }      
                         if (rs.getString("ABRE_INST") != null) {
            dat.setABRE_INST(rs.getString("ABRE_INST").trim());
        } else {
            dat.setABRE_INST(rs.getString("ABRE_INST"));
        }      
            if (rs.getString("ALU_NUEVOS") != null) {
            dat.setALU_NUEVOS(rs.getString("ALU_NUEVOS").trim());
        } else {
            dat.setALU_NUEVOS(rs.getString("ALU_NUEVOS"));
        }      
             if (rs.getString("AVANCE_META") != null) {
            dat.setAVANCE_META(rs.getString("AVANCE_META").trim());
        } else {
            dat.setAVANCE_META(rs.getString("AVANCE_META"));
        }          
         if (rs.getString("FALTANTES") != null) {
            dat.setFALTANTES(rs.getString("FALTANTES").trim());
        } else {
            dat.setFALTANTES(rs.getString("FALTANTES"));
        }         
        return dat;  
        
    }
    
}
