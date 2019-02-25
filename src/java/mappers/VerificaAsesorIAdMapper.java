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
public class VerificaAsesorIAdMapper implements Mapper{
    
    public Object mapRow(ResultSet rs) throws SQLException {
        DatosBean pro = new DatosBean();
        if (rs.getString("ID_CAT_ASE") != null) {
            pro.setID_CAT_ASE(rs.getString("ID_CAT_ASE").trim());
        } else {
            pro.setID_CAT_ASE(rs.getString("ID_CAT_ASE"));
        }   
        if (rs.getString("NOMBRE") != null) {
            pro.setNOMBREAI(rs.getString("NOMBRE").trim());
        } else {
            pro.setNOMBREAI(rs.getString("NOMBRE"));
        }
        if (rs.getString("APELLIDOP") != null) {
            pro.setAPELLIDOPAI(rs.getString("APELLIDOP").trim());
        } else {
            pro.setAPELLIDOPAI(rs.getString("APELLIDOP"));
        }
        if (rs.getString("APELLIDOM") != null) {
            pro.setAPELLIDOMAI(rs.getString("APELLIDOM").trim());
        } else {
            pro.setAPELLIDOMAI(rs.getString("APELLIDOM"));
        }
        if (rs.getString("CVE_CAR_RES") != null) {
            pro.setCVE_CAR_RES(rs.getString("CVE_CAR_RES").trim());
        } else {
            pro.setCVE_CAR_RES(rs.getString("CVE_CAR_RES"));
        }    
        if (rs.getString("CURP") != null) {
            pro.setCURP_ASESORI(rs.getString("CURP").trim());
        } else {
            pro.setCURP_ASESORI(rs.getString("CURP"));
        }
        
        return pro;  
        
    }
    
}
