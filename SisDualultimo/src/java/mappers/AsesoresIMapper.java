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
public class AsesoresIMapper implements Mapper{
    
    public Object mapRow(ResultSet rs) throws SQLException {
        ProyectoBean pro = new ProyectoBean();
        
      
        if (rs.getString("ID_CAT_ASE") != null) {
            pro.setID_ASESOR_I(rs.getString("ID_CAT_ASE").trim());
        } else {
            pro.setID_ASESOR_I(rs.getString("ID_CAT_ASE"));
        }
        if (rs.getString("NOMBRE_COMPLETO") != null) {
            pro.setNOMBRE_COMPLETO_AI(rs.getString("NOMBRE_COMPLETO").trim());
        } else {
            pro.setNOMBRE_COMPLETO_AI(rs.getString("NOMBRE_COMPLETO"));
        }
        
        
           
         
        
        return pro;  
        
    }
    
}
