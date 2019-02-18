package mappers;


import beans.DatosBean;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VerificaResponsableMapper implements Mapper {

    public Object mapRow(ResultSet rs) throws SQLException {
        DatosBean dat = new DatosBean();
        
        if (rs.getString("CVE_SER_PUB") != null) {
            dat.setCURP_RESPONSABLE(rs.getString("CVE_SER_PUB").trim());
        } else {
            dat.setCURP_RESPONSABLE(rs.getString("CVE_SER_PUB"));
        }
        if (rs.getString("NOMBRE") != null) {
            dat.setNOMBRER(rs.getString("NOMBRE").trim());
        } else {
            dat.setNOMBRER(rs.getString("NOMBRE"));
        }
        if (rs.getString("APELLIDOP") != null) {
            dat.setAPELLIDOPR(rs.getString("APELLIDOP").trim());
        } else {
            dat.setAPELLIDOPR(rs.getString("APELLIDOP"));
        }
        if (rs.getString("APELLIDOM") != null) {
            dat.setAPELLIDOMR(rs.getString("APELLIDOM").trim());
        } else {
            dat.setAPELLIDOMR(rs.getString("APELLIDOM"));
        }
        
        if (rs.getString("CARGO") != null) {
            dat.setCARGO_RESPONSABLE(rs.getString("CARGO").trim());
        } else {
            dat.setCARGO_RESPONSABLE(rs.getString("CARGO"));
        }
        
        if (rs.getString("TELEFONO") != null) {
            dat.setTELEFONO_RESPONSABLE(rs.getString("TELEFONO").trim());
        } else {
            dat.setTELEFONO_RESPONSABLE(rs.getString("TELEFONO"));
        }
        
        if (rs.getString("EMAIL") != null) {
            dat.setEMAIL_RESPONSABLE(rs.getString("EMAIL").trim());
        } else {
            dat.setEMAIL_RESPONSABLE(rs.getString("EMAIL"));
        }
        
        return dat;
    }

}
