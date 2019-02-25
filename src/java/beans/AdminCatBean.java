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
public class AdminCatBean {
    //cct
    private String CCT;
    private String NOMESC;
    private String CALLE;
    private String NUM_ESC;
    private String COLONIA;
    private String LOCALIDAD;
    private String CP;
    private String MUNICIPIOCCT;
    //carreras      
    private String ID_CVE_CAR;
    private String CLAVECARRERA;
    private String NOMBRE_CARRERA;
    private String MODALIDAD;
    //responsables
    private String ID_CAT_RESP;
    private String CVE_SER_PUB;
    private String CURP_RESPONSABLE;
    private String CURP_RESPONSABLEAUX;
    private String NOMBRER;
    private String APELLIDOPR;
    private String APELLIDOMR;
    private String CVE_CAR_RES;
    private String CARGO_RESPONSABLE;
    private String TELEFONO_RESPONSABLE;
    private String EMAIL_RESPONSABLE;
    private String CCT_RESP;
    
    private String ID_CAT_RESPA;
    private String CURP_RESPONSABLEA;
    private String NOMBRERA;
    private String APELLIDOPRA;
    private String APELLIDOMRA;
    private String CARGO_RESPONSABLEA;
    private String TELEFONO_RESPONSABLEA;
    private String EMAIL_RESPONSABLEA;
    private String CCT_RESPA;
    
    //asesores
    private String ID_CAT_ASE;
    private String CURP_ASESORI;
    private String CURP_ASESORIAUX;
    private String NOMBREAI;
    private String APELLIDOPAI;
    private String APELLIDOMAI;
    private String CVE_CAR_ASE;
    private String CCT_ASE;
    
    private String ID_CAT_ASEA;
    private String CURP_ASESORIA;
    private String NOMBREAIA;
    private String APELLIDOPAIA;
    private String APELLIDOMAIA;
    private String CVE_CAR_ASEA;
    private String CCT_ASEA;

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

    public String getCALLE() {
        return CALLE;
    }

    public void setCALLE(String CALLE) {
        this.CALLE = CALLE;
    }

    public String getNUM_ESC() {
        return NUM_ESC;
    }

    public void setNUM_ESC(String NUM_ESC) {
        this.NUM_ESC = NUM_ESC;
    }

    public String getCOLONIA() {
        return COLONIA;
    }

    public void setCOLONIA(String COLONIA) {
        this.COLONIA = COLONIA;
    }

    public String getLOCALIDAD() {
        return LOCALIDAD;
    }

    public void setLOCALIDAD(String LOCALIDAD) {
        this.LOCALIDAD = LOCALIDAD;
    }

    public String getCP() {
        return CP;
    }

    public void setCP(String CP) {
        this.CP = CP;
    }

    public String getMUNICIPIOCCT() {
        return MUNICIPIOCCT;
    }

    public void setMUNICIPIOCCT(String MUNICIPIOCCT) {
        this.MUNICIPIOCCT = MUNICIPIOCCT;
    }

    public String getID_CVE_CAR() {
        return ID_CVE_CAR;
    }

    public void setID_CVE_CAR(String ID_CVE_CAR) {
        this.ID_CVE_CAR = ID_CVE_CAR;
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

    public String getID_CAT_RESP() {
        return ID_CAT_RESP;
    }

    public void setID_CAT_RESP(String ID_CAT_RESP) {
        this.ID_CAT_RESP = ID_CAT_RESP;
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

    public String getCURP_RESPONSABLEAUX() {
        return CURP_RESPONSABLEAUX;
    }

    public void setCURP_RESPONSABLEAUX(String CURP_RESPONSABLEAUX) {
        this.CURP_RESPONSABLEAUX = CURP_RESPONSABLEAUX;
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

    public String getCCT_RESP() {
        return CCT_RESP;
    }

    public void setCCT_RESP(String CCT_RESP) {
        this.CCT_RESP = CCT_RESP;
    }

    public String getID_CAT_RESPA() {
        return ID_CAT_RESPA;
    }

    public void setID_CAT_RESPA(String ID_CAT_RESPA) {
        this.ID_CAT_RESPA = ID_CAT_RESPA;
    }

    public String getCURP_RESPONSABLEA() {
        return CURP_RESPONSABLEA;
    }

    public void setCURP_RESPONSABLEA(String CURP_RESPONSABLEA) {
        this.CURP_RESPONSABLEA = CURP_RESPONSABLEA;
    }

    public String getNOMBRERA() {
        return NOMBRERA;
    }

    public void setNOMBRERA(String NOMBRERA) {
        this.NOMBRERA = NOMBRERA;
    }

    public String getAPELLIDOPRA() {
        return APELLIDOPRA;
    }

    public void setAPELLIDOPRA(String APELLIDOPRA) {
        this.APELLIDOPRA = APELLIDOPRA;
    }

    public String getAPELLIDOMRA() {
        return APELLIDOMRA;
    }

    public void setAPELLIDOMRA(String APELLIDOMRA) {
        this.APELLIDOMRA = APELLIDOMRA;
    }

    public String getCARGO_RESPONSABLEA() {
        return CARGO_RESPONSABLEA;
    }

    public void setCARGO_RESPONSABLEA(String CARGO_RESPONSABLEA) {
        this.CARGO_RESPONSABLEA = CARGO_RESPONSABLEA;
    }

    public String getTELEFONO_RESPONSABLEA() {
        return TELEFONO_RESPONSABLEA;
    }

    public void setTELEFONO_RESPONSABLEA(String TELEFONO_RESPONSABLEA) {
        this.TELEFONO_RESPONSABLEA = TELEFONO_RESPONSABLEA;
    }

    public String getEMAIL_RESPONSABLEA() {
        return EMAIL_RESPONSABLEA;
    }

    public void setEMAIL_RESPONSABLEA(String EMAIL_RESPONSABLEA) {
        this.EMAIL_RESPONSABLEA = EMAIL_RESPONSABLEA;
    }

    public String getCCT_RESPA() {
        return CCT_RESPA;
    }

    public void setCCT_RESPA(String CCT_RESPA) {
        this.CCT_RESPA = CCT_RESPA;
    }
       
    public String getCURP_ASESORI() {
        return CURP_ASESORI;
    }

    public void setCURP_ASESORI(String CURP_ASESORI) {
        this.CURP_ASESORI = CURP_ASESORI;
    }

    public String getCURP_ASESORIAUX() {
        return CURP_ASESORIAUX;
    }

    public void setCURP_ASESORIAUX(String CURP_ASESORIAUX) {
        this.CURP_ASESORIAUX = CURP_ASESORIAUX;
    }
    
    

    public String getID_CAT_ASE() {
        return ID_CAT_ASE;
    }

    public void setID_CAT_ASE(String ID_CAT_ASE) {
        this.ID_CAT_ASE = ID_CAT_ASE;
    }

    public String getCVE_CAR_ASE() {
        return CVE_CAR_ASE;
    }

    public void setCVE_CAR_ASE(String CVE_CAR_ASE) {
        this.CVE_CAR_ASE = CVE_CAR_ASE;
    }

    public String getCCT_ASE() {
        return CCT_ASE;
    }

    public void setCCT_ASE(String CCT_ASE) {
        this.CCT_ASE = CCT_ASE;
    }

    public String getID_CAT_ASEA() {
        return ID_CAT_ASEA;
    }

    public void setID_CAT_ASEA(String ID_CAT_ASEA) {
        this.ID_CAT_ASEA = ID_CAT_ASEA;
    }

    public String getCURP_ASESORIA() {
        return CURP_ASESORIA;
    }

    public void setCURP_ASESORIA(String CURP_ASESORIA) {
        this.CURP_ASESORIA = CURP_ASESORIA;
    }

    public String getNOMBREAIA() {
        return NOMBREAIA;
    }

    public void setNOMBREAIA(String NOMBREAIA) {
        this.NOMBREAIA = NOMBREAIA;
    }

    public String getAPELLIDOPAIA() {
        return APELLIDOPAIA;
    }

    public void setAPELLIDOPAIA(String APELLIDOPAIA) {
        this.APELLIDOPAIA = APELLIDOPAIA;
    }

    public String getAPELLIDOMAIA() {
        return APELLIDOMAIA;
    }

    public void setAPELLIDOMAIA(String APELLIDOMAIA) {
        this.APELLIDOMAIA = APELLIDOMAIA;
    }

    public String getCVE_CAR_ASEA() {
        return CVE_CAR_ASEA;
    }

    public void setCVE_CAR_ASEA(String CVE_CAR_ASEA) {
        this.CVE_CAR_ASEA = CVE_CAR_ASEA;
    }

    public String getCCT_ASEA() {
        return CCT_ASEA;
    }

    public void setCCT_ASEA(String CCT_ASEA) {
        this.CCT_ASEA = CCT_ASEA;
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
