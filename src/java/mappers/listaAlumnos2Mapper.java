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
public class listaAlumnos2Mapper implements Mapper {

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
       
       
        if (rs.getString("NOM_CAR") != null) {
            dat.setNOMBRE_CARRERA(rs.getString("NOM_CAR").trim());
        } else {
            dat.setNOMBRE_CARRERA(rs.getString("NOM_CAR"));
        }
        
        if (rs.getString("CVE_CARRERA") != null) {
            dat.setCVE_CAR_RES(rs.getString("CVE_CARRERA").trim());
        } else {
            dat.setCVE_CAR_RES(rs.getString("CVE_CARRERA"));
        }
        
         if (rs.getString("CCT") != null) {
            dat.setCCT(rs.getString("CCT").trim());
        } else {
            dat.setCCT(rs.getString("CCT"));
        }
        
        

        return dat;

    }

}
