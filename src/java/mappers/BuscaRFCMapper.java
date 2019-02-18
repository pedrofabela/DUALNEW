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
public class BuscaRFCMapper implements Mapper{
    
    public Object mapRow(ResultSet rs) throws SQLException {
        ProyectoBean pro = new ProyectoBean();
        
      
        
         
        if (rs.getString("RFC") != null) {
            pro.setRFC(rs.getString("RFC").trim());
        } else {
            pro.setRFC(rs.getString("RFC"));
        }        
         if (rs.getString("RAZON_SOCIAL") != null) {
            pro.setRAZON_SOCIAL(rs.getString("RAZON_SOCIAL").trim());
        } else {
            pro.setRAZON_SOCIAL(rs.getString("RAZON_SOCIAL"));
        }
          if (rs.getString("GIRO") != null) {
            pro.setGIRO(rs.getString("GIRO").trim());
        } else {
            pro.setGIRO(rs.getString("GIRO"));
        }
        if (rs.getString("SECTOR") != null) {
            pro.setSECTOR(rs.getString("SECTOR").trim());
        } else {
            pro.setSECTOR(rs.getString("SECTOR"));
        }
        if (rs.getString("DOMICILIO") != null) {
            pro.setDOMICILIOE(rs.getString("DOMICILIO").trim());
        } else {
            pro.setDOMICILIOE(rs.getString("DOMICILIO"));
        }
        if (rs.getString("COLONIA") != null) {
            pro.setCOLONIAE(rs.getString("COLONIA").trim());
        } else {
            pro.setCOLONIAE(rs.getString("COLONIA"));
        }
        if (rs.getString("LOCALIDAD") != null) {
            pro.setLOCALIDADE(rs.getString("LOCALIDAD").trim());
        } else {
            pro.setLOCALIDADE(rs.getString("LOCALIDAD"));
        }
        if (rs.getString("CP") != null) {
            pro.setCPE(rs.getString("CP").trim());
        } else {
            pro.setCPE(rs.getString("CP"));
        }
        if (rs.getString("MUNICIPIO") != null) {
            pro.setMUNICIPIOE(rs.getString("MUNICIPIO").trim());
        } else {
            pro.setMUNICIPIOE(rs.getString("MUNICIPIO"));
        }
        if (rs.getString("REP_LEGAL") != null) {
            pro.setREP_LEGAL(rs.getString("REP_LEGAL").trim());
        } else {
            pro.setREP_LEGAL(rs.getString("REP_LEGAL"));
        }
        if (rs.getString("TELEFONO") != null) {
            pro.setTELEFONOE(rs.getString("TELEFONO").trim());
        } else {
            pro.setTELEFONOE(rs.getString("TELEFONO"));
        }
        if (rs.getString("CORREO_ELECTRONICO") != null) {
            pro.setCORREO_ELECTRONICOE(rs.getString("CORREO_ELECTRONICO").trim());
        } else {
            pro.setCORREO_ELECTRONICOE(rs.getString("CORREO_ELECTRONICO"));
        }
        
        return pro;  
        
    }
    
}
