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
public class aluNuevosMapper implements Mapper{
    
     public Object mapRow(ResultSet rs) throws SQLException {
        DatosBean dat = new DatosBean();
        
      
        
      
                 if (rs.getString("MATRICULA") != null) {
            dat.setMATRICULA(rs.getString("MATRICULA").trim());
        } else {
            dat.setMATRICULA(rs.getString("MATRICULA"));
        }
                 
                   if (rs.getString("CURP") != null) {
            dat.setCURP(rs.getString("CURP").trim());
        } else {
            dat.setCURP(rs.getString("CURP"));
        }
             
                   if (rs.getString("NOMBRE_COMPLETO") != null) {
            dat.setNOMBRE_COMPLETO(rs.getString("NOMBRE_COMPLETO").trim());
        } else {
            dat.setNOMBRE_COMPLETO(rs.getString("NOMBRE_COMPLETO"));
        }  
                   
                     if (rs.getString("CLAVECARRERA") != null) {
            dat.setCLAVECARRERA(rs.getString("CLAVECARRERA").trim());
        } else {
            dat.setCLAVECARRERA(rs.getString("CLAVECARRERA"));
        }      
                         if (rs.getString("SITUACIONACA") != null) {
            dat.setSITUACIONACA(rs.getString("SITUACIONACA").trim());
        } else {
            dat.setSITUACIONACA(rs.getString("SITUACIONACA"));
        }      
            if (rs.getString("MUNICIPIO") != null) {
            dat.setMUNICIPIO(rs.getString("MUNICIPIO").trim());
        } else {
            dat.setMUNICIPIO(rs.getString("MUNICIPIO"));
        }      
            
             if (rs.getString("FECHA_INGRESO_DUAL") != null) {
            dat.setFECHA_INGRESO_DUAL(rs.getString("FECHA_INGRESO_DUAL").trim());
        } else {
            dat.setFECHA_INGRESO_DUAL(rs.getString("FECHA_INGRESO_DUAL"));
        }          
         if (rs.getString("CCT") != null) {
            dat.setCCT(rs.getString("CCT").trim());
        } else {
            dat.setCCT(rs.getString("CCT"));
        }         
        return dat;  
        
    }
    
}
