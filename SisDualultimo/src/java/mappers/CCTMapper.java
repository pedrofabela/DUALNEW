package mappers;


import beans.DatosBean;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CCTMapper implements Mapper {

    public Object mapRow(ResultSet rs) throws SQLException {
        DatosBean dat = new DatosBean();
        
        if (rs.getString("CCT") != null) {
            dat.setCCT(rs.getString("CCT").trim());
        } else {
            dat.setCCT(rs.getString("CCT"));
        }
        if (rs.getString("NOM_ESC") != null) {
            dat.setNOMESC(rs.getString("NOM_ESC").trim());
        } else {
            dat.setNOMESC(rs.getString("NOM_ESC"));
        }
        if (rs.getString("CALLE") != null) {
            dat.setCALLE(rs.getString("CALLE").trim());
        } else {
            dat.setCALLE(rs.getString("CALLE"));
        }
        if (rs.getString("NUMERO") != null) {
            dat.setNUM_ESC(rs.getString("NUMERO").trim());
        } else {
            dat.setNUM_ESC(rs.getString("NUMERO"));
        }
        if (rs.getString("COLONIA") != null) {
            dat.setCOLONIA(rs.getString("COLONIA").trim());
        } else {
            dat.setCOLONIA(rs.getString("COLONIA"));
        }
        if (rs.getString("LOCALIDAD") != null) {
            dat.setLOCALIDAD(rs.getString("LOCALIDAD").trim());
        } else {
            dat.setLOCALIDAD(rs.getString("LOCALIDAD"));
        }
         if (rs.getString("CP") != null) {
            dat.setCP(rs.getString("CP").trim());
        } else {
            dat.setCP(rs.getString("CP"));
        }
         if (rs.getString("MUNICIPIO") != null) {
            dat.setMUNICIPIOCCT(rs.getString("MUNICIPIO").trim());
        } else {
            dat.setMUNICIPIOCCT(rs.getString("MUNICIPIO"));
        }
        
       
        
        return dat;
    }

}
