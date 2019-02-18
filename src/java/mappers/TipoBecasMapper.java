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
public class TipoBecasMapper implements Mapper {

    public Object mapRow(ResultSet rs) throws SQLException {
        BecaBean dat = new BecaBean();

        if (rs.getString("id_beca") != null) {
            dat.setID_TIPO_BECA(rs.getString("id_beca").trim());
        } else {
            dat.setID_TIPO_BECA(rs.getString("id_beca"));
        }
        if (rs.getString("nom_beca") != null) {
            dat.setNOM_BECA(rs.getString("nom_beca").trim());
        } else {
            dat.setNOM_BECA(rs.getString("nom_beca"));
        }
        

        return dat;

    }

}
