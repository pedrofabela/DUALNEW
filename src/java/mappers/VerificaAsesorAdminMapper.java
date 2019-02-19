package mappers;


import beans.AdminCatBean;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VerificaAsesorAdminMapper implements Mapper {

    public Object mapRow(ResultSet rs) throws SQLException {
        AdminCatBean dat = new AdminCatBean();
        
        if (rs.getString("ID_CAT_ASE") != null) {
            dat.setID_CAT_ASE(rs.getString("ID_CAT_ASE").trim());
        } else {
            dat.setID_CAT_ASE(rs.getString("ID_CAT_ASE"));
        }
        
        if (rs.getString("NOMBRE") != null) {
            dat.setNOMBREAI(rs.getString("NOMBRE").trim());
        } else {
            dat.setNOMBREAI(rs.getString("NOMBRE"));
        }
        if (rs.getString("APELLIDOP") != null) {
            dat.setAPELLIDOPAI(rs.getString("APELLIDOP").trim());
        } else {
            dat.setAPELLIDOPAI(rs.getString("APELLIDOP"));
        }
        if (rs.getString("APELLIDOM") != null) {
            dat.setAPELLIDOMAI(rs.getString("APELLIDOM").trim());
        } else {
            dat.setAPELLIDOMAI(rs.getString("APELLIDOM"));
        }
         if (rs.getString("CVE_CAR_RES") != null) {
            dat.setCVE_CAR_ASE(rs.getString("CVE_CAR_RES").trim());
        } else {
            dat.setCVE_CAR_ASE(rs.getString("CVE_CAR_RES"));
        }
         if (rs.getString("CURP") != null) {
            dat.setCURP_ASESORI(rs.getString("CURP").trim());
        } else {
            dat.setCURP_ASESORI(rs.getString("CURP"));
        } 
         
         if (rs.getString("CCT") != null) {
            dat.setCCT_ASE(rs.getString("CCT").trim());
        } else {
            dat.setCCT_ASE(rs.getString("CCT"));
        } 
        
        
        
        
        
       
        
        return dat;
    }

}
