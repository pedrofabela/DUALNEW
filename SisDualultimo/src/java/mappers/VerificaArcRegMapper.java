package mappers;


import beans.VerificaArchivoBean;
import java.sql.ResultSet;
import java.sql.SQLException;
import utilidades.Constantes;

public class VerificaArcRegMapper implements Mapper {

    public Object mapRow(ResultSet rs) throws SQLException {
        VerificaArchivoBean dat = new VerificaArchivoBean();
        
       
        if (rs.getString("CCT") != null) {
            dat.setCCT(rs.getString("CCT").trim());
        } else {
            dat.setCCT(rs.getString("CCT"));
        }
        if (rs.getString("ARCHIVO_CAR") != null) {
            dat.setARCHIVO_CAR(rs.getString("ARCHIVO_CAR").trim());
        } else {
            dat.setARCHIVO_CAR(rs.getString("ARCHIVO_CAR"));
        }
        if (rs.getString("ARCHIVO_RES") != null) {
            dat.setARCHIVO_RES(rs.getString("ARCHIVO_RES").trim());
        } else {
            dat.setARCHIVO_RES(rs.getString("ARCHIVO_RES"));
        }
        if (rs.getString("ARCHIVO_AI") != null) {
            dat.setARCHIVO_ASE_INT(rs.getString("ARCHIVO_AI").trim());
            
        } else {
            dat.setARCHIVO_ASE_INT(rs.getString("ARCHIVO_AI"));
        }
        if (rs.getString("ARCHIVO_ALU") != null) {
            dat.setARCHIVO_ALU(rs.getString("ARCHIVO_ALU").trim());
        } else {
            dat.setARCHIVO_ALU(rs.getString("ARCHIVO_ALU"));
        }
        
        return dat;
    }

}
