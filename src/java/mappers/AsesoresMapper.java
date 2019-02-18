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
public class AsesoresMapper implements Mapper{
    
    public Object mapRow(ResultSet rs) throws SQLException {
        ProyectoBean pro = new ProyectoBean();
        
      
        if (rs.getString("ID_CAT_RES_EMP") != null) {
            pro.setID_ASESOR_A(rs.getString("ID_CAT_RES_EMP").trim());
        } else {
            pro.setID_ASESOR_A(rs.getString("ID_CAT_RES_EMP"));
        }
        if (rs.getString("RFC") != null) {
            pro.setRFC(rs.getString("RFC").trim());
        } else {
            pro.setRFC(rs.getString("RFC"));
        }
        if (rs.getString("CURP") != null) {
            pro.setCURP_A(rs.getString("CURP").trim());
        } else {
            pro.setCURP_A(rs.getString("CURP"));
        }
        if (rs.getString("NOMBRE_COMPLETO") != null) {
            pro.setNOMBRE_COMPLETO_A(rs.getString("NOMBRE_COMPLETO").trim());
        } else {
            pro.setNOMBRE_COMPLETO_A(rs.getString("NOMBRE_COMPLETO"));
        }
        if (rs.getString("CARGO") != null) {
            pro.setCARGO_A(rs.getString("CARGO").trim());
        } else {
            pro.setCARGO_A(rs.getString("CARGO"));
        }
        
        if (rs.getString("TELEFONO") != null) {
            pro.setTELEFONO_A(rs.getString("TELEFONO").trim());
        } else {
            pro.setTELEFONO_A(rs.getString("TELEFONO"));
        }
        
        if (rs.getString("CORREO") != null) {
            pro.setCORREO_A(rs.getString("CORREO").trim());
        } else {
            pro.setCORREO_A(rs.getString("CORREO"));
        }
        
           
         
        
        return pro;  
        
    }
    
}
