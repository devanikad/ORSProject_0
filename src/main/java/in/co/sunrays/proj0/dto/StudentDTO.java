package in.co.sunrays.proj0.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

// TODO: Auto-generated Javadoc
/**
 * Student DTO classes.
 *
 * @author SUNRAYS Technologies
 * @version 1.0
 * @Copyright (c) SUNRAYS Technologies
 */
@Entity
@Table(name="ST_STUDENT")
public class StudentDTO extends BaseDTO {
    
    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** CollegeId of Student. */
	@Column(name="COLLEGE_ID")
    private long collegeId;
    
    /** College name of Student. */
	@Transient
	private String collegeName;

     /** First Name of Student. */
	@Column(name="FIRST_NAME")
    private String firstName;
    
    /** Last Name of Student. */
	@Column(name="LAST_NAME")
    private String lastName;
    
	/** Gender of Student. */
	@Column(name="GENDER")
    private String gender;
	
	/** Date of Birth of Student. */
	@Column(name="DOB")
    private Date dob;
	
	/** Email of Student. */
	@Column(name="EMAIL_ID")
    private String emailId;
    
	/** Mobileno of Student. */
	@Column(name="MOBILE_NO")
    private String mobileNo;
   
    /**
     * accessor.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }
    
    /**
     * Sets the first name.
     *
     * @param firstName the new first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    /**
     * Gets the last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }
    
    /**
     * Sets the last name.
     *
     * @param lastName the new last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    /**
     * Gets the dob.
     *
     * @return the dob
     */
    public Date getDob() {
        return dob;
    }
    
    /**
     * Sets the dob.
     *
     * @param dob the new dob
     */
    public void setDob(Date dob) {
        this.dob = dob;
    }
    
    /**
     * Gets the mobile no.
     *
     * @return the mobile no
     */
    public String getMobileNo() {
        return mobileNo;
    }
    
    /**
     * Sets the mobile no.
     *
     * @param mobileNo the new mobile no
     */
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }
    
    /**
     * Gets the gender.
     *
     * @return the gender
     */
    public String getGender() {
		return gender;
	}
	
	/**
	 * Sets the gender.
	 *
	 * @param gender the new gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
    
    /**
     * Gets the email.
     *
     * @return the email
     */
    public String getEmail() {
        return emailId;
    }
    
    /**
     * Sets the email.
     *
     * @param emailId the new email
     */
    public void setEmail(String emailId) {
        this.emailId = emailId;
    }
    
    /**
     * Gets the college id.
     *
     * @return the college id
     */
    public Long getCollegeId() {
        return collegeId;
    }
    
    /**
     * Sets the college id.
     *
     * @param collegeId the new college id
     */
    public void setCollegeId(Long collegeId) {
        this.collegeId = collegeId;
    }

    /**
     * Gets the college name.
     *
     * @return the college name
     */
    public String getCollegeName() {
        return collegeName;
    }
    
    /**
     * Sets the college name.
     *
     * @param collegeName the new college name
     */
    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }
	
	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.dto.DropDownList#getKey()
	 */
	public String getKey() {
		// TODO Auto-generated method stub
		return id+"";
	}
	
	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.dto.DropDownList#getValue()
	 */
	public String getValue() {
		// TODO Auto-generated method stub
		return firstName+" "+lastName;
	}
  
}

