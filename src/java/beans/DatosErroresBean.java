/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author Giovani
 */
public class DatosErroresBean {

    private String CCT;
    private String NOMESC;
    private String DIRECCION;
    private String SUBSISTEMA;
    private String NIVEL;
    private String CCTA;
    private String MUNICIPIOCCT;

    private String CURP;
    private String NOMBRE;
    private String APELLIDOP;
    private String APELLIDOM;
    private String FECNAC;
    private String CURPA;
    private String SEXO;
    private String CORREO;
    private String TIPO_CUENTA;
    private String STATUS;
    private String DESERROR;
    private String ID_CUENTA;
    private String FECHA_CONSTRUCCION;
    private String INDICE;
    private String MATRICULA;
    private String GRADO;
    private String DOMICILIOA;
    private String COLONIAA;
    private String TELEFONO;
    private String PROMEDIOGRAL;
    private String SITUACIONACA;

    private String CLAVECARRERA;
    private String NOMBRE_CARRERA;
    private String MODALIDAD;

    private String CVE_SER_PUB;
    private String CURP_RESPONSABLE;
    private String NOMBRER;
    private String APELLIDOPR;
    private String APELLIDOMR;
    private String CVE_CAR_RES;
    private String CARGO_RESPONSABLE;
    private String TELEFONO_RESPONSABLE;
    private String EMAIL_RESPONSABLE;
    
    
    private String CURP_ASESORI;
    private String NOMBREAI;
    private String APELLIDOPAI;
    private String APELLIDOMAI;

    // ********************************************* CONSTRUCTOR PARA CARRERAS*******************************************************************************
    public DatosErroresBean(String CLAVECARRERA, String NOMBRE_CARRERA, String STATUS) {
        this.CLAVECARRERA = CLAVECARRERA;
        this.NOMBRE_CARRERA = NOMBRE_CARRERA;
        this.STATUS = STATUS;

    }

    // ********************************************* CONSTRUCTOR PARA RESPONSABLES*******************************************************************************

    public DatosErroresBean(String CURP_RESPONSABLE, String NOMBRER, String APELLIDOPR, String APELLIDOMR, String CARGO_RESPONSABLE,String STATUS, String DESERROR) {
        
        this.CURP_RESPONSABLE = CURP_RESPONSABLE;
        this.NOMBRER = NOMBRER;
        this.APELLIDOPR = APELLIDOPR;
        this.APELLIDOMR = APELLIDOMR;
        this.CARGO_RESPONSABLE = CARGO_RESPONSABLE;
        this.STATUS = STATUS;
        this.DESERROR = DESERROR;
    }
    
    

    
    

    // ********************************************* CONSTRUCTOR PARA ALUMNOS*******************************************************************************
    public DatosErroresBean(String MATRICULA, String CURP, String NOMBRE, String APELLIDOP, String APELLIDOM, String CVE_CAR_RES, String TELEFONO, String CORREO, String STATUS, String DESERROR) {
        this.CURP = CURP;
        this.NOMBRE = NOMBRE;
        this.APELLIDOP = APELLIDOP;
        this.APELLIDOM = APELLIDOM;
        this.CORREO = CORREO;
        this.STATUS = STATUS;
        this.DESERROR = DESERROR;
        this.MATRICULA = MATRICULA;
        this.TELEFONO = TELEFONO;
        this.CVE_CAR_RES = CVE_CAR_RES;
    }
    
    // ********************************************* CONSTRUCTOR PARA VALIDAR CURP CON RENAPO*******************************************************************************
    public DatosErroresBean(String CURP, String NOMBRE, String APELLIDOP, String APELLIDOM, String STATUS, String DESERROR) {
        this.CURP = CURP;
        this.NOMBRE = NOMBRE;
        this.APELLIDOP = APELLIDOP;
        this.APELLIDOM = APELLIDOM;
        this.STATUS = STATUS;
        this.DESERROR = DESERROR;
    }

    public String getCCT() {
        return CCT;
    }

    public void setCCT(String CCT) {
        this.CCT = CCT;
    }

    public String getNOMESC() {
        return NOMESC;
    }

    public void setNOMESC(String NOMESC) {
        this.NOMESC = NOMESC;
    }

    public String getDIRECCION() {
        return DIRECCION;
    }

    public void setDIRECCION(String DIRECCION) {
        this.DIRECCION = DIRECCION;
    }

    public String getSUBSISTEMA() {
        return SUBSISTEMA;
    }

    public void setSUBSISTEMA(String SUBSISTEMA) {
        this.SUBSISTEMA = SUBSISTEMA;
    }

    public String getNIVEL() {
        return NIVEL;
    }

    public void setNIVEL(String NIVEL) {
        this.NIVEL = NIVEL;
    }

    public String getCCTA() {
        return CCTA;
    }

    public void setCCTA(String CCTA) {
        this.CCTA = CCTA;
    }

    public String getMUNICIPIOCCT() {
        return MUNICIPIOCCT;
    }

    public void setMUNICIPIOCCT(String MUNICIPIOCCT) {
        this.MUNICIPIOCCT = MUNICIPIOCCT;
    }

    public String getCURP() {
        return CURP;
    }

    public void setCURP(String CURP) {
        this.CURP = CURP;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public String getAPELLIDOP() {
        return APELLIDOP;
    }

    public void setAPELLIDOP(String APELLIDOP) {
        this.APELLIDOP = APELLIDOP;
    }

    public String getAPELLIDOM() {
        return APELLIDOM;
    }

    public void setAPELLIDOM(String APELLIDOM) {
        this.APELLIDOM = APELLIDOM;
    }

    public String getFECNAC() {
        return FECNAC;
    }

    public void setFECNAC(String FECNAC) {
        this.FECNAC = FECNAC;
    }

    public String getCURPA() {
        return CURPA;
    }

    public void setCURPA(String CURPA) {
        this.CURPA = CURPA;
    }

    public String getSEXO() {
        return SEXO;
    }

    public void setSEXO(String SEXO) {
        this.SEXO = SEXO;
    }

    public String getCORREO() {
        return CORREO;
    }

    public void setCORREO(String CORREO) {
        this.CORREO = CORREO;
    }

    public String getTIPO_CUENTA() {
        return TIPO_CUENTA;
    }

    public void setTIPO_CUENTA(String TIPO_CUENTA) {
        this.TIPO_CUENTA = TIPO_CUENTA;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }

    public String getDESERROR() {
        return DESERROR;
    }

    public void setDESERROR(String DESERROR) {
        this.DESERROR = DESERROR;
    }

    public String getID_CUENTA() {
        return ID_CUENTA;
    }

    public void setID_CUENTA(String ID_CUENTA) {
        this.ID_CUENTA = ID_CUENTA;
    }

    public String getFECHA_CONSTRUCCION() {
        return FECHA_CONSTRUCCION;
    }

    public void setFECHA_CONSTRUCCION(String FECHA_CONSTRUCCION) {
        this.FECHA_CONSTRUCCION = FECHA_CONSTRUCCION;
    }

    public String getINDICE() {
        return INDICE;
    }

    public void setINDICE(String INDICE) {
        this.INDICE = INDICE;
    }

    public String getMATRICULA() {
        return MATRICULA;
    }

    public void setMATRICULA(String MATRICULA) {
        this.MATRICULA = MATRICULA;
    }

    public String getGRADO() {
        return GRADO;
    }

    public void setGRADO(String GRADO) {
        this.GRADO = GRADO;
    }

    public String getDOMICILIOA() {
        return DOMICILIOA;
    }

    public void setDOMICILIOA(String DOMICILIOA) {
        this.DOMICILIOA = DOMICILIOA;
    }

    public String getCOLONIAA() {
        return COLONIAA;
    }

    public void setCOLONIAA(String COLONIAA) {
        this.COLONIAA = COLONIAA;
    }

    public String getTELEFONO() {
        return TELEFONO;
    }

    public void setTELEFONO(String TELEFONO) {
        this.TELEFONO = TELEFONO;
    }

    public String getPROMEDIOGRAL() {
        return PROMEDIOGRAL;
    }

    public void setPROMEDIOGRAL(String PROMEDIOGRAL) {
        this.PROMEDIOGRAL = PROMEDIOGRAL;
    }

    public String getSITUACIONACA() {
        return SITUACIONACA;
    }

    public void setSITUACIONACA(String SITUACIONACA) {
        this.SITUACIONACA = SITUACIONACA;
    }

    public String getCLAVECARRERA() {
        return CLAVECARRERA;
    }

    public void setCLAVECARRERA(String CLAVECARRERA) {
        this.CLAVECARRERA = CLAVECARRERA;
    }

    public String getNOMBRE_CARRERA() {
        return NOMBRE_CARRERA;
    }

    public void setNOMBRE_CARRERA(String NOMBRE_CARRERA) {
        this.NOMBRE_CARRERA = NOMBRE_CARRERA;
    }

    public String getMODALIDAD() {
        return MODALIDAD;
    }

    public void setMODALIDAD(String MODALIDAD) {
        this.MODALIDAD = MODALIDAD;
    }

    public String getCVE_SER_PUB() {
        return CVE_SER_PUB;
    }

    public void setCVE_SER_PUB(String CVE_SER_PUB) {
        this.CVE_SER_PUB = CVE_SER_PUB;
    }

    public String getCURP_RESPONSABLE() {
        return CURP_RESPONSABLE;
    }

    public void setCURP_RESPONSABLE(String CURP_RESPONSABLE) {
        this.CURP_RESPONSABLE = CURP_RESPONSABLE;
    }
    
    

    public String getNOMBRER() {
        return NOMBRER;
    }

    public void setNOMBRER(String NOMBRER) {
        this.NOMBRER = NOMBRER;
    }

    public String getAPELLIDOPR() {
        return APELLIDOPR;
    }

    public void setAPELLIDOPR(String APELLIDOPR) {
        this.APELLIDOPR = APELLIDOPR;
    }

    public String getAPELLIDOMR() {
        return APELLIDOMR;
    }

    public void setAPELLIDOMR(String APELLIDOMR) {
        this.APELLIDOMR = APELLIDOMR;
    }

    public String getCVE_CAR_RES() {
        return CVE_CAR_RES;
    }

    public void setCVE_CAR_RES(String CVE_CAR_RES) {
        this.CVE_CAR_RES = CVE_CAR_RES;
    }

    public String getCARGO_RESPONSABLE() {
        return CARGO_RESPONSABLE;
    }

    public void setCARGO_RESPONSABLE(String CARGO_RESPONSABLE) {
        this.CARGO_RESPONSABLE = CARGO_RESPONSABLE;
    }

    public String getTELEFONO_RESPONSABLE() {
        return TELEFONO_RESPONSABLE;
    }

    public void setTELEFONO_RESPONSABLE(String TELEFONO_RESPONSABLE) {
        this.TELEFONO_RESPONSABLE = TELEFONO_RESPONSABLE;
    }

    public String getEMAIL_RESPONSABLE() {
        return EMAIL_RESPONSABLE;
    }

    public void setEMAIL_RESPONSABLE(String EMAIL_RESPONSABLE) {
        this.EMAIL_RESPONSABLE = EMAIL_RESPONSABLE;
    }

    public String getCURP_ASESORI() {
        return CURP_ASESORI;
    }

    public void setCURP_ASESORI(String CURP_ASESORI) {
        this.CURP_ASESORI = CURP_ASESORI;
    }

    public String getNOMBREAI() {
        return NOMBREAI;
    }

    public void setNOMBREAI(String NOMBREAI) {
        this.NOMBREAI = NOMBREAI;
    }

    public String getAPELLIDOPAI() {
        return APELLIDOPAI;
    }

    public void setAPELLIDOPAI(String APELLIDOPAI) {
        this.APELLIDOPAI = APELLIDOPAI;
    }

    public String getAPELLIDOMAI() {
        return APELLIDOMAI;
    }

    public void setAPELLIDOMAI(String APELLIDOMAI) {
        this.APELLIDOMAI = APELLIDOMAI;
    }
    
    
    
    

}
