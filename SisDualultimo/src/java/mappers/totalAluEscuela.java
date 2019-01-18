/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mappers;

import beans.DatosBean;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author pedro
 */
public class totalAluEscuela implements Mapper{
     public Object mapRow(ResultSet rs) throws SQLException {
        DatosBean dat = new DatosBean();
        
      
        
      
                 if (rs.getString("CCT") != null) {
            dat.setCCT(rs.getString("CCT").trim());
        } else {
            dat.setCCT(rs.getString("CCT"));
        }
                 
                   if (rs.getString("TOTAL_CCT") != null) {
            dat.setTOTAL_CCT(rs.getString("TOTAL_CCT").trim());
        } else {
            dat.setTOTAL_CCT(rs.getString("TOTAL_CCT"));
        }
                   
                   
         
        return dat;  
        
    }
}
