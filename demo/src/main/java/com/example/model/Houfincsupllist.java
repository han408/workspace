package com.example.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * @author jjhan
 */

@Entity
@IdClass(Houfincsupllist.class)
@Table(name="HOUFINCSUPLLIST")
public class Houfincsupllist implements Serializable {
	
	private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "YEAR")
    private String year;
    
    @Id
    @Column(name = "MONTH")
    private String month;
    
    @Id
    @Column(name = "INSTITUTE_CODE")
    private String instituteCode;

    @Column(name = "INSTITUTE_AMT")
    private int instituteAmt;
    
    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
    
    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }
    
    public String getInstituteCode() {
        return instituteCode;
    }

    public void setInstituteCode(String instituteCode) {
        this.instituteCode = instituteCode;
    }

    public int getInstituteAmt() {
        return instituteAmt;
    }

    public void setInstituteAmt(int instituteAmt) {
        this.instituteAmt = instituteAmt;
    }

}
