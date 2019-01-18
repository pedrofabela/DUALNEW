package mappers;


import beans.GeneraArchivoBean;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatosCuentaMapper implements Mapper {

    public Object mapRow(ResultSet rs) throws SQLException {
        GeneraArchivoBean dat = new GeneraArchivoBean();
        
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
        if (rs.getString("CUENTA_CONSTRUIDA") != null) {
            dat.setCORREO(rs.getString("CUENTA_CONSTRUIDA").trim());
        } else {
            dat.setCORREO(rs.getString("CUENTA_CONSTRUIDA"));
        }
        if (rs.getString("TIPO_CUENTA") != null) {
            dat.setTIPO_CUENTA(rs.getString("TIPO_CUENTA").trim());
        } else {
            dat.setTIPO_CUENTA(rs.getString("TIPO_CUENTA"));
        }
        if (rs.getString("NOMESC") != null) {
            dat.setNOMESC(rs.getString("NOMESC").trim());
        } else {
            dat.setNOMESC(rs.getString("NOMESC"));
        }
        if (rs.getString("CCT") != null) {
            dat.setCCT(rs.getString("CCT").trim());
        } else {
            dat.setCCT(rs.getString("CCT"));
        }
        if (rs.getString("DIRESC") != null) {
            dat.setDIRECCION(rs.getString("DIRESC").trim());
        } else {
            dat.setDIRECCION(rs.getString("DIRESC"));
        }
        if (rs.getString("MUNICIPIO") != null) {
            dat.setMUNICIPIOCCT(rs.getString("MUNICIPIO").trim());
        } else {
            dat.setMUNICIPIOCCT(rs.getString("MUNICIPIO"));
        }
        return dat;
    }

}
