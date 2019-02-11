package mappers;


import beans.DatosBean;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultaTipoAlumnoMapper implements Mapper {

    public Object mapRow(ResultSet rs) throws SQLException {
        DatosBean dat = new DatosBean();
        
        if (rs.getString("id_tipoalumno") != null) {
            dat.setID_TIPOALUM(rs.getString("id_tipoalumno").trim());
        } else {
            dat.setID_TIPOALUM(rs.getString("id_tipoalumno"));
        }
        if (rs.getString("nom_tipo") != null) {
            dat.setNOM_TIPO(rs.getString("nom_tipo").trim());
        } else {
            dat.setNOM_TIPO(rs.getString("nom_tipo"));
        }
        
        return dat;
    }

}
