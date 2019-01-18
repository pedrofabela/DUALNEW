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
public class EstatusMapper implements Mapper{
    
    public Object mapRow(ResultSet rs) throws SQLException {
        ProyectoBean pro = new ProyectoBean();
        
      
        if (rs.getString("ID_ESTATUS") != null) {
            pro.setID_ESTATUS(rs.getString("ID_ESTATUS").trim());
        } else {
            pro.setID_ESTATUS(rs.getString("ID_ESTATUS"));
        }
        if (rs.getString("NOM_ESTATUS") != null) {
            pro.setNOM_ESTATUS(rs.getString("NOM_ESTATUS").trim());
        } else {
            pro.setNOM_ESTATUS(rs.getString("NOM_ESTATUS"));
        }
       
        
        return pro;  
        
    }
    
}
