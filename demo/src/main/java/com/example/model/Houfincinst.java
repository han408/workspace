package com.example.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * @author jjhan
 */

@Entity
@Table(name="HOUFINCINST")
public class Houfincinst implements Serializable {

	@Id
    @Column(name = "INSTITUTE_CODE")
    private String instituteCode;

    @Column(name = "INSTITUTE_MAME")
    private String instituteName;
    
    public String getInstituteCode() {
        return instituteCode;
    }

    public void setInstituteCode(String instituteCode) {
        this.instituteCode = instituteCode;
    }

    public String getInstituteName() {
        return instituteName;
    }

    public void setInstituteName(String instituteName) {
        this.instituteName = instituteName;
    }

}
