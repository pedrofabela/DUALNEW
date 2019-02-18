package mappers;


import beans.DatosBean;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VerificaCorreoMapper implements Mapper {

    public Object mapRow(ResultSet rs) throws SQLException {
        DatosBean dat = new DatosBean();
        
        if (rs.getString("CORREO") != null) {
            dat.setCORREO(rs.getString("CORREO").trim());
        } else {
            dat.setCORREO(rs.getString("CORREO"));
        }
        if (rs.getString("CURP") != null) {
            dat.setCURPA(rs.getString("CURP").trim());
        } else {
            dat.setCURPA(rs.getString("CURP"));
        }
        
        return dat;
    }

}
