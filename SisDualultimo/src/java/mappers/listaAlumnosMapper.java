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
public class listaAlumnosMapper implements Mapper {

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
        if (rs.getString("GENERO") != null) {
            dat.setSEXO(rs.getString("GENERO").trim());
        } else {
            dat.setSEXO(rs.getString("GENERO"));
        }
        
        if (rs.getString("FECHA_NAC") != null) {
            dat.setFECNAC(rs.getString("FECHA_NAC").trim());
        } else {
            dat.setFECNAC(rs.getString("FECHA_NAC"));
        }
        
        if (rs.getString("DOMICILIO") != null) {
            dat.setDOMICILIOA(rs.getString("DOMICILIO").trim());
        } else {
            dat.setDOMICILIOA(rs.getString("DOMICILIO"));
        }

        if (rs.getString("COLONIA") != null) {
            dat.setCOLONIAA(rs.getString("COLONIA").trim());
        } else {
            dat.setCOLONIAA(rs.getString("COLONIA"));
        }
        
         if (rs.getString("CP") != null) {
            dat.setCP(rs.getString("CP").trim());
        } else {
            dat.setCP(rs.getString("CP"));
        }
        
        if (rs.getString("TELEFONO") != null) {
            dat.setTELEFONO(rs.getString("TELEFONO").trim());
        } else {
            dat.setTELEFONO(rs.getString("TELEFONO"));
        }

        if (rs.getString("CORREO") != null) {
            dat.setCORREO(rs.getString("CORREO").trim());
        } else {
            dat.setCORREO(rs.getString("CORREO"));
        }
       
        if (rs.getString("CARRERA") != null) {
            dat.setNOMBRE_CARRERA(rs.getString("CARRERA").trim());
        } else {
            dat.setNOMBRE_CARRERA(rs.getString("CARRERA"));
        }
        
        if (rs.getString("GRADO") != null) {
            dat.setGRADO(rs.getString("GRADO").trim());
        } else {
            dat.setGRADO(rs.getString("GRADO"));
        }
        
        if (rs.getString("PROMEDIO") != null) {
            dat.setPROMEDIOGRAL(rs.getString("PROMEDIO").trim());
        } else {
            dat.setPROMEDIOGRAL(rs.getString("PROMEDIO"));
        }
        
        if (rs.getString("SITUACION_ACA") != null) {
            dat.setSITUACIONACA(rs.getString("SITUACION_ACA").trim());
        } else {
            dat.setSITUACIONACA(rs.getString("SITUACION_ACA"));
        }
        
        if (rs.getString("TIPO_ALUMNO") != null) {
            dat.setTIPO_ALUM(rs.getString("TIPO_ALUMNO").trim());
        } else {
            dat.setTIPO_ALUM(rs.getString("TIPO_ALUMNO"));
        } 
        
        if (rs.getString("MUNICIPIO") != null) {
            dat.setCVE_MUNA(rs.getString("MUNICIPIO").trim());
        } else {
            dat.setCVE_MUNA(rs.getString("MUNICIPIO"));
        }
        
        if (rs.getString("NOMMUNICIPIO") != null) {
            dat.setMUNICIPIO(rs.getString("NOMMUNICIPIO").trim());
        } else {
            dat.setMUNICIPIO(rs.getString("NOMMUNICIPIO"));
        }
        
        if (rs.getString("CCT") != null) {
            dat.setCCT(rs.getString("CCT").trim());
        } else {
            dat.setCCT(rs.getString("CCT"));
        }
        
        if (rs.getString("AVANCE") != null) {
            dat.setAVANCE(rs.getString("AVANCE").trim());
        } else {
            dat.setAVANCE(rs.getString("AVANCE"));
        } 
        if (rs.getString("FECHA_INGRESO_DUAL") != null) {
            dat.setFECHA_INGRESO_DUAL(rs.getString("FECHA_INGRESO_DUAL").trim());
        } else {
            dat.setFECHA_INGRESO_DUAL(rs.getString("FECHA_INGRESO_DUAL"));
        }

        return dat;

    }

}
