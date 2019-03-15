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
public class carreraAluMapper implements Mapper{
    public Object mapRow(ResultSet rs) throws SQLException {
        DatosBean dat = new DatosBean();
        
      
        
      
                 if (rs.getString("CLAVECARRERA") != null) {
            dat.setCLAVECARRERA(rs.getString("CLAVECARRERA").trim());
        } else {
            dat.setCLAVECARRERA(rs.getString("CLAVECARRERA"));
        }
                 
                   if (rs.getString("NOMBRE_CARRERA") != null) {
            dat.setNOMBRE_CARRERA(rs.getString("NOMBRE_CARRERA").trim());
        } else {
            dat.setNOMBRE_CARRERA(rs.getString("NOMBRE_CARRERA"));
        }
             
                   if (rs.getString("ALUMNOS_ACTIVOS_GENERAL") != null) {
            dat.setALUMNOS_ACTIVOS_GENERAL(rs.getString("ALUMNOS_ACTIVOS_GENERAL").trim());
        } else {
            dat.setALUMNOS_ACTIVOS_GENERAL(rs.getString("ALUMNOS_ACTIVOS_GENERAL"));
        }  
                     if (rs.getString("ALUMNOS_INACTIVOS_GENERAL") != null) {
            dat.setALUMNOS_INACTIVOS_GENERAL(rs.getString("ALUMNOS_INACTIVOS_GENERAL").trim());
        } else {
            dat.setALUMNOS_INACTIVOS_GENERAL(rs.getString("ALUMNOS_INACTIVOS_GENERAL"));
        }      
                         if (rs.getString("ALUMNOS_EGRESADOS_GENERAL") != null) {
            dat.setALUMNOS_EGRESADOS_GENERAL(rs.getString("ALUMNOS_EGRESADOS_GENERAL").trim());
        } else {
            dat.setALUMNOS_EGRESADOS_GENERAL(rs.getString("ALUMNOS_EGRESADOS_GENERAL"));
        }      
                   
         
        return dat;  
        
    }
}
