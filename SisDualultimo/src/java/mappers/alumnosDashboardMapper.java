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

        if (rs.getString("SEXO") != null) {
            dat.setSEXO(rs.getString("SEXO").trim());
        } else {
            dat.setSEXO(rs.getString("SEXO"));
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

        if (rs.getString("FECHA_REG") != null) {
            dat.setFECHA_REG(rs.getString("FECHA_REG").trim());
        } else {
            dat.setFECHA_REG(rs.getString("FECHA_REG"));
        }

        if (rs.getString("ID_ESTATUS") != null) {
            dat.setID_ESTATUS(rs.getString("ID_ESTATUS").trim());
        } else {
            dat.setID_ESTATUS(rs.getString("ID_ESTATUS"));
        }

        if (rs.getString("NOM_ESTATUS") != null) {
            dat.setNOM_ESTATUS(rs.getString("NOM_ESTATUS").trim());
        } else {
            dat.setNOM_ESTATUS(rs.getString("NOM_ESTATUS"));
        }

        if (rs.getString("ESTATUS_GENERAL") != null) {
            dat.setESTATUS_GENERAL(rs.getString("ESTATUS_GENERAL").trim());
        } else {
            dat.setESTATUS_GENERAL(rs.getString("ESTATUS_GENERAL"));
        }

        if (rs.getString("CVE_CARRERA") != null) {
            dat.setCLAVECARRERA(rs.getString("CVE_CARRERA").trim());
        } else {
            dat.setCLAVECARRERA(rs.getString("CVE_CARRERA"));
        }

        return dat;

    }
}
