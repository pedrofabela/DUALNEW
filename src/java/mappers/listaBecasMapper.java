/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mappers;

import beans.BecaBean;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author pedro
 */
public class listaBecasMapper implements Mapper {

    public Object mapRow(ResultSet rs) throws SQLException {
        BecaBean dat = new BecaBean();

        if (rs.getString("id_beca") != null) {
            dat.setID_BECA(rs.getString("id_beca").trim());
        } else {
            dat.setID_BECA(rs.getString("id_beca"));
        }
        if (rs.getString("cct") != null) {
            dat.setCCT_B(rs.getString("cct").trim());
        } else {
            dat.setCCT_B(rs.getString("cct"));
        }
        if (rs.getString("curp") != null) {
            dat.setCURP_AB(rs.getString("curp").trim());
        } else {
            dat.setCURP_AB(rs.getString("curp"));
        }

        if (rs.getString("fuente") != null) {
            dat.setFUENTE(rs.getString("fuente").trim());
        } else {
            dat.setFUENTE(rs.getString("fuente"));
        }

        if (rs.getString("monto") != null) {
            dat.setMONTO(rs.getString("monto").trim());
        } else {
            dat.setMONTO(rs.getString("monto"));
        }

        if (rs.getString("periodicidad") != null) {
            dat.setPERIODICIDAD(rs.getString("periodicidad").trim());
        } else {
            dat.setPERIODICIDAD(rs.getString("periodicidad"));
        }
        if (rs.getString("duracion") != null) {
            dat.setDURACION(rs.getString("duracion").trim());
        } else {
            dat.setDURACION(rs.getString("duracion"));
        }
        if (rs.getString("nom_beca") != null) {
            dat.setNOM_BECA(rs.getString("nom_beca").trim());
        } else {
            dat.setNOM_BECA(rs.getString("nom_beca"));
        }
         if (rs.getString("tipo_beca") != null) {
            dat.setTIPO_BECA(rs.getString("tipo_beca").trim());
        } else {
            dat.setTIPO_BECA(rs.getString("tipo_beca"));
        }
        if (rs.getString("status") != null) {
            dat.setSTATUS_B(rs.getString("status").trim());
        } else {
            dat.setSTATUS_B(rs.getString("status"));
        } 
         if (rs.getString("des_beca") != null) {
            dat.setDES_BECA(rs.getString("des_beca").trim());
        } else {
            dat.setDES_BECA(rs.getString("des_beca"));
        }
        

        return dat;

    }

}
