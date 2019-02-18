package mappers;


import beans.DatosBean;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VerificaModalidadMapper implements Mapper {

    public Object mapRow(ResultSet rs) throws SQLException {
        DatosBean dat = new DatosBean();
        
        if (rs.getString("MODALIDAD") != null) {
            dat.setMODALIDAD(rs.getString("MODALIDAD").trim());
        } else {
            dat.setMODALIDAD(rs.getString("MODALIDAD"));
        }
        
        
        return dat;
    }

}
