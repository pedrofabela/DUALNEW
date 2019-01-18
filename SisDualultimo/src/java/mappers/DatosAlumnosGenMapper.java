package mappers;


import beans.DatosBean;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatosAlumnosGenMapper implements Mapper {

    public Object mapRow(ResultSet rs) throws SQLException {
        DatosBean dat = new DatosBean();
        
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
        if (rs.getString("CURP") != null) {
            dat.setCURPA(rs.getString("CURP").trim());
        } else {
            dat.setCURPA(rs.getString("CURP"));
        }
        
        return dat;
    }

}
