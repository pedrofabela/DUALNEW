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
public class listaAlumnosBecaMapper implements Mapper {

    public Object mapRow(ResultSet rs) throws SQLException {
        DatosBean dat = new DatosBean();

        if (rs.getString("ID_ALUMNO") != null) {
            dat.setID_ALUMNO(rs.getString("ID_ALUMNO").trim());
        } else {
            dat.setID_ALUMNO(rs.getString("ID_ALUMNO"));
        }
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

        if (rs.getString("NOMBRE") != null) {
            dat.setNOMBRE(rs.getString("NOMBRE").trim());
        } else {
            dat.setNOMBRE(rs.getString("NOMBRE"));
        }

        if (rs.getString("APELLIDOP") != null) {
            dat.setAPELLIDOP(rs.getString("APELLIDOP").trim());
        } else {
            dat.setAPELLIDOP(rs.getString("APELLIDOP"));
        }

        if (rs.getString("APELLIDOM") != null) {
            dat.setAPELLIDOM(rs.getString("APELLIDOM").trim());
        } else {
            dat.setAPELLIDOM(rs.getString("APELLIDOM"));
        }

        if (rs.getString("NOMBRE_COMPLETO") != null) {
            dat.setNOMBRE_COMPLETO(rs.getString("NOMBRE_COMPLETO").trim());
        } else {
            dat.setNOMBRE_COMPLETO(rs.getString("NOMBRE_COMPLETO"));
        }
        
        
        if (rs.getString("CCT") != null) {
            dat.setCCT(rs.getString("CCT").trim());
        } else {
            dat.setCCT(rs.getString("CCT"));
        }
        
         if (rs.getString("CARRERA") != null) {
            dat.setNOMBRE_CARRERA(rs.getString("CARRERA").trim());
        } else {
            dat.setNOMBRE_CARRERA(rs.getString("CARRERA"));
        }
        
        if (rs.getString("BECA") != null) {
            dat.setBECA(rs.getString("BECA").trim());
        } else {
            dat.setBECA(rs.getString("BECA"));
        }   

        return dat;

    }

}
