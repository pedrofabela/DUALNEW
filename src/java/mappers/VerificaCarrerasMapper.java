package mappers;


import beans.DatosBean;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VerificaCarrerasMapper implements Mapper {

    public Object mapRow(ResultSet rs) throws SQLException {
        DatosBean dat = new DatosBean();
        
        if (rs.getString("ID_CAR_CCT") != null) {
            dat.setID_CVE_CAR(rs.getString("ID_CAR_CCT").trim());
        } else {
            dat.setID_CVE_CAR(rs.getString("ID_CAR_CCT"));
        }
        if (rs.getString("CVE_CAR") != null) {
            dat.setCLAVECARRERA(rs.getString("CVE_CAR").trim());
        } else {
            dat.setCLAVECARRERA(rs.getString("CVE_CAR"));
        }
        if (rs.getString("NOM_CAR") != null) {
            dat.setNOMBRE_CARRERA(rs.getString("NOM_CAR").trim());
        } else {
            dat.setNOMBRE_CARRERA(rs.getString("NOM_CAR"));
        }
        
        return dat;
    }

}
