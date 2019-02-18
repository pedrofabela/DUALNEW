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
public class ProyectoMapper implements Mapper{
    
    public Object mapRow(ResultSet rs) throws SQLException {
        ProyectoBean pro = new ProyectoBean();
        
      
        if (rs.getString("id_proyecto") != null) {
            pro.setID_PROYECTO(rs.getString("id_proyecto").trim());
        } else {
            pro.setID_PROYECTO(rs.getString("id_proyecto"));
        }
        if (rs.getString("cct") != null) {
            pro.setCCT(rs.getString("cct").trim());
        } else {
            pro.setCCT(rs.getString("cct"));
        }
        if (rs.getString("curp_a") != null) {
            pro.setCURP_A(rs.getString("curp_a").trim());
        } else {
            pro.setCURP_A(rs.getString("curp_a"));
        }
        if (rs.getString("nombre_p") != null) {
            pro.setNOM_PRO(rs.getString("nombre_p").trim());
        } else {
            pro.setNOM_PRO(rs.getString("nombre_p"));
        }
        if (rs.getString("etapa") != null) {
            pro.setETAPA(rs.getString("etapa").trim());
        } else {
            pro.setETAPA(rs.getString("etapa"));
        }
        if (rs.getString("fecha_inicio") != null) {
            pro.setFECHA_INICIO(rs.getString("fecha_inicio").trim());
        } else {
            pro.setFECHA_INICIO(rs.getString("fecha_inicio"));
        }
        if (rs.getString("fecha_termino") != null) {
            pro.setFECHA_TERMINO(rs.getString("fecha_termino").trim());
        } else {
            pro.setFECHA_TERMINO(rs.getString("fecha_termino"));
        }
        if (rs.getString("area_conocimiento") != null) {
            pro.setAREA_CONOCIMIENTO(rs.getString("area_conocimiento").trim());
        } else {
            pro.setAREA_CONOCIMIENTO(rs.getString("area_conocimiento"));
        }
        if (rs.getString("num_hora") != null) {
            pro.setNUM_HORAS(rs.getString("num_hora").trim());
        } else {
            pro.setNUM_HORAS(rs.getString("num_hora"));
        }
        if (rs.getString("asesor_int") != null) {
            pro.setASE_INS(rs.getString("asesor_int").trim());
        } else {
            pro.setASE_INS(rs.getString("asesor_int"));
        }
        if (rs.getString("responsable_ins") != null) {
            pro.setRESP_INS(rs.getString("responsable_ins").trim());
        } else {
            pro.setRESP_INS(rs.getString("responsable_ins"));
        }
        if (rs.getString("status") != null) {
            pro.setSTATUS_P(rs.getString("status").trim());
        } else {
            pro.setSTATUS_P(rs.getString("status"));
        }
        if (rs.getString("convenio") != null) {
            pro.setCONVENIOR(rs.getString("convenio").trim());
        } else {
            pro.setCONVENIOR(rs.getString("convenio"));
        }
        if (rs.getString("rfc") != null) {
            pro.setRFC(rs.getString("rfc").trim());
        } else {
            pro.setRFC(rs.getString("rfc"));
        }
        if (rs.getString("razon_social") != null) {
            pro.setRAZON_SOCIAL(rs.getString("razon_social").trim());
        } else {
            pro.setRAZON_SOCIAL(rs.getString("razon_social"));
        }
        if (rs.getString("giro") != null) {
            pro.setGIRO(rs.getString("giro").trim());
        } else {
            pro.setGIRO(rs.getString("giro"));
        }
        if (rs.getString("sector") != null) {
            pro.setSECTOR(rs.getString("sector").trim());
        } else {
            pro.setSECTOR(rs.getString("sector"));
        }
        if (rs.getString("domicilio") != null) {
            pro.setDOMICILIOE(rs.getString("domicilio").trim());
        } else {
            pro.setDOMICILIOE(rs.getString("domicilio"));
        }
        if (rs.getString("colonia") != null) {
            pro.setCOLONIAE(rs.getString("colonia").trim());
        } else {
            pro.setCOLONIAE(rs.getString("colonia"));
        }
        if (rs.getString("localidad") != null) {
            pro.setLOCALIDADE(rs.getString("localidad").trim());
        } else {
            pro.setLOCALIDADE(rs.getString("localidad"));
        }
        if (rs.getString("cp") != null) {
            pro.setCPE(rs.getString("cp").trim());
        } else {
            pro.setCPE(rs.getString("cp"));
        }
        if (rs.getString("municipio") != null) {
            pro.setMUNICIPIOE(rs.getString("municipio").trim());
        } else {
            pro.setMUNICIPIOE(rs.getString("municipio"));
        }
        if (rs.getString("rep_legal") != null) {
            pro.setREP_LEGAL(rs.getString("rep_legal").trim());
        } else {
            pro.setREP_LEGAL(rs.getString("rep_legal"));
        }
        if (rs.getString("telefono") != null) {
            pro.setTELEFONOE(rs.getString("telefono").trim());
        } else {
            pro.setTELEFONOE(rs.getString("telefono"));
        }
        if (rs.getString("correo_electronico") != null) {
            pro.setCORREO_ELECTRONICOE(rs.getString("correo_electronico").trim());
        } else {
            pro.setCORREO_ELECTRONICOE(rs.getString("correo_electronico"));
        }
        if (rs.getString("nombre") != null) {
            pro.setNOMBRE_A(rs.getString("nombre").trim());
        } else {
            pro.setNOMBRE_A(rs.getString("nombre"));
        }
        if (rs.getString("apellidop") != null) {
            pro.setAPELLIDO_PA(rs.getString("apellidop").trim());
        } else {
            pro.setAPELLIDO_PA(rs.getString("apellidop"));
        }
        if (rs.getString("apellidom") != null) {
            pro.setAPELLIDO_MA(rs.getString("apellidom").trim());
        } else {
            pro.setAPELLIDO_MA(rs.getString("apellidom"));
        }
        if (rs.getString("cargo") != null) {
            pro.setCARGO_A(rs.getString("cargo").trim());
        } else {
            pro.setCARGO_A(rs.getString("cargo"));
        }
        if (rs.getString("tel_resp") != null) {
            pro.setTELEFONO_A(rs.getString("tel_resp").trim());
        } else {
            pro.setTELEFONO_A(rs.getString("tel_resp"));
        }
        if (rs.getString("correo") != null) {
            pro.setCORREO_A(rs.getString("correo").trim());
        } else {
            pro.setCORREO_A(rs.getString("correo"));
        }
        
        
        
        
        return pro;  
        
    }
    
}
