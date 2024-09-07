/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanjeevaniapp.pojo;

/**
 *
 * @author TANMAY KUMAR
 */
public class ReceptionistPojo {

    public ReceptionistPojo() {}

    public ReceptionistPojo(String receptionistId, String receptionistName, String receptionistGender) {
        this.receptionistId = receptionistId;
        this.receptionistName = receptionistName;
        this.receptionistGender = receptionistGender;
    }

    public String getReceptionistId() {
        return receptionistId;
    }

    public void setReceptionistId(String receptionistId) {
        this.receptionistId = receptionistId;
    }

    public String getReceptionistName() {
        return receptionistName;
    }

    public void setReceptionistName(String receptionistName) {
        this.receptionistName = receptionistName;
    }

    public String getReceptionistGender() {
        return receptionistGender;
    }

    public void setReceptionistGender(String receptionistGender) {
        this.receptionistGender = receptionistGender;
    }
    private String receptionistId;
    private String receptionistName;
    private String receptionistGender;
}
