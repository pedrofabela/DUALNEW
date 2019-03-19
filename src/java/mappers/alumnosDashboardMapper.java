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
public class alumnosDashboardMapper implements Mapper {

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
        
        
         if (rs.getString("CVE_CARRERA") != null) {
            dat.setCLAVECARRERA(rs.getString("CVE_CARRERA").trim());
        } else {
            dat.setCLAVECARRERA(rs.getString("CVE_CARRERA"));
        }
        
         if (rs.getString("NOMBRE_CARRERA") != null) {
            dat.setNOMBRE_CARRERA(rs.getString("NOMBRE_CARRERA").trim());
        } else {
            dat.setCLAVECARRERA(rs.getString("NOMBRE_CARRERA"));
        }
        
        

        if (rs.getString("SEXO") != null) {
            dat.setSEXO(rs.getString("SEXO").trim());
        } else {
            dat.setSEXO(rs.getString("SEXO"));
        }
        
         if (rs.getString("FECNAC") != null) {
            dat.setFECNAC(rs.getString("FECNAC").trim());
        } else {
            dat.setFECNAC(rs.getString("FECNAC"));
        }
         
          if (rs.getString("DOMICILIOA") != null) {
            dat.setDOMICILIOA(rs.getString("DOMICILIOA").trim());
        } else {
            dat.setDOMICILIOA(rs.getString("DOMICILIOA"));
        }
        

        if (rs.getString("COLONIA") != null) {
            dat.setCOLONIA(rs.getString("COLONIA").trim());
        } else {
            dat.setCOLONIA(rs.getString("COLONIA"));
            
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
         
         if (rs.getString("GRADO") != null) {
            dat.setGRADO(rs.getString("GRADO").trim());
        } else {
            dat.setGRADO(rs.getString("GRADO"));
            
        }
         
           if (rs.getString("PROMEDIOGRAL") != null) {
            dat.setPROMEDIOGRAL(rs.getString("PROMEDIOGRAL").trim());
        } else {
            dat.setPROMEDIOGRAL(rs.getString("PROMEDIOGRAL"));
            
        }
         
        
          if (rs.getString("SITUACIONACA") != null) {
            dat.setSITUACIONACA(rs.getString("SITUACIONACA").trim());
        } else {
            dat.setSITUACIONACA(rs.getString("SITUACIONACA"));
            
        }   
           
           if (rs.getString("TIPO_ALUMNO") != null) {
            dat.setTIPO_ALUMNO(rs.getString("TIPO_ALUMNO").trim());
        } else {
            dat.setTIPO_ALUMNO(rs.getString("TIPO_ALUMNO"));
            
        }    
         
            if (rs.getString("STATUS") != null) {
            dat.setSTATUS(rs.getString("STATUS").trim());
        } else {
            dat.setSTATUS(rs.getString("STATUS"));
            
        }    
           
           

        if (rs.getString("CCT") != null) {
            dat.setCCT(rs.getString("CCT").trim());
        } else {
            dat.setCCT(rs.getString("CCT"));
        }
        
        
        

        if (rs.getString("NOMESC") != null) {
            dat.setNOMESC(rs.getString("NOMESC").trim());
        } else {
            dat.setNOMESC(rs.getString("NOMESC"));
        }
        
        
       if (rs.getString("MUNICIPIO") != null) {
            dat.setMUNICIPIO(rs.getString("MUNICIPIO").trim());
        } else {
            dat.setMUNICIPIO(rs.getString("MUNICIPIO"));
        } 
        
         if (rs.getString("CP") != null) {
            dat.setCP(rs.getString("CP").trim());
        } else {
            dat.setCP(rs.getString("CP"));
        }
       
         if (rs.getString("FECHA_REG") != null) {
            dat.setFECHA_REG(rs.getString("FECHA_REG").trim());
        } else {
            dat.setFECHA_REG(rs.getString("FECHA_REG"));
        }
       
       
         if (rs.getString("BECA") != null) {
            dat.setBECA(rs.getString("BECA").trim());
        } else {
            dat.setBECA(rs.getString("BECA"));
        }
         
         
          if (rs.getString("FECHA_INGRESO_DUAL") != null) {
            dat.setFECHA_INGRESO_DUAL(rs.getString("FECHA_INGRESO_DUAL").trim());
        } else {
            dat.setFECHA_INGRESO_DUAL(rs.getString("FECHA_INGRESO_DUAL"));
        }
       
          
          
           if (rs.getString("FECHA_REINGRESO") != null) {
            dat.setFECHA_REINGRESO(rs.getString("FECHA_REINGRESO").trim());
        } else {
            dat.setFECHA_REINGRESO(rs.getString("FECHA_REINGRESO"));
        } 
          
          
          if (rs.getString("FECHA_EGRESO") != null) {
            dat.setFECHA_EGRESO(rs.getString("FECHA_EGRESO").trim());
        } else {
            dat.setFECHA_EGRESO(rs.getString("FECHA_EGRESO"));
        }  
          
         if (rs.getString("FECHA_EGRESO") != null) {
            dat.setFECHA_EGRESO(rs.getString("FECHA_EGRESO").trim());
        } else {
            dat.setFECHA_EGRESO(rs.getString("FECHA_EGRESO"));
        }    
         
          

        if (rs.getString("FECHA_CAMBIO_ESTATUS") != null) {
            dat.setFECHA_CAMBIO_ESTATUS(rs.getString("FECHA_CAMBIO_ESTATUS").trim());
        } else {
            dat.setFECHA_CAMBIO_ESTATUS(rs.getString("FECHA_CAMBIO_ESTATUS"));
        }

        if (rs.getString("ESTATUS_GENERAL") != null) {
            dat.setESTATUS_GENERAL(rs.getString("ESTATUS_GENERAL").trim());
        } else {
            dat.setESTATUS_GENERAL(rs.getString("ESTATUS_GENERAL"));
        }

        return dat;

    }
}
