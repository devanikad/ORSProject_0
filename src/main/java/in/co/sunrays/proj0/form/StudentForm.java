package in.co.sunrays.proj0.form;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.sun.speech.freetts.Gender;

import in.co.sunrays.proj0.dto.BaseDTO;
import in.co.sunrays.proj0.dto.StudentDTO;
import in.co.sunrays.proj0.util.Util;
/*import in.co.sunrays.proj0.validator.Custom;
import in.co.sunrays.proj0.validator.Phone;
*/
// TODO: Auto-generated Javadoc
/**
 * Contains Student form elements and their declarative input validations.
 * 
 * @author Iterator
 * @version 1.0 Copyright (c) Iterator
 */
public class StudentForm extends BaseForm{
	
		/** firstname of StudentForm. */
	    @NotEmpty
	   // @Custom(regex = "^[a-zA-Z]+$",message = "{Custom.form.firstName}")
	    private String firstName;
	    
    	/** lastname of StudentForm. */
	    @NotEmpty
	   // @Custom(regex = "^[a-zA-Z,.'-]+$",message = "{Custom.form.lastName}")
	    private String lastName;
	    
    	/** dob of StudentForm. */
	    @NotEmpty
	    private String dob;
	    
    	/** mobileNo of StudentForm. */
	    @NotEmpty
	    private String gender;
		
		/** The mobile no. */
		@NotEmpty
		//@Phone(message = "{Phone.form.mobileNo}")
	    private String mobileNo;
		
		/** email of StudentForm. */
	    @NotEmpty
	    @Email(message = "{Email.form.email}")
	    private String email;
	    
    	/** collegeName of StudentForm. */
	    private String collegeName;
	    
    	/** collegeId of StudentForm. */
	    @Min(value=1,message="{Min.form.collegeId}")
	    private Long collegeId;

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

	    /**
    	 * Gets the first name.
    	 *
    	 * @return the first name
    	 */
    	public String getFirstName() {
	        return firstName;
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
    	public String getDob() {
	        return dob;
	    }

	    /**
    	 * Sets the dob.
    	 *
    	 * @param dob the new dob
    	 */
    	public void setDob(String dob) {
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
    	 * Gets the email.
    	 *
    	 * @return the email
    	 */
    	public String getEmail() {
	        return email;
	    }

	    /**
    	 * Sets the email.
    	 *
    	 * @param email the new email
    	 */
    	public void setEmail(String email) {
	        this.email = email;
	    }
	     
     	/* (non-Javadoc)
     	 * @see in.co.sunrays.proj0.form.BaseForm#getDto()
     	 */
     	@Override
	    public BaseDTO getDto() {
	        StudentDTO dto = new StudentDTO();
	        dto.setId(id);
	        dto.setFirstName(firstName);
	        dto.setLastName(lastName);
	        if(dob!=""){
	            dto.setDob(Util.getDate(dob));
	            }
	        dto.setMobileNo(mobileNo);
	        dto.setEmail(email);
	        dto.setGender(gender);
	        dto.setCollegeId(collegeId);
	        dto.setFirstName(firstName);
	        dto.setLastName(lastName);
	        dto.setCreatedBy(createdBy);
	        dto.setModifiedBy(modifiedBy);
	        dto.setCreatedDateTime(new Timestamp(new Date().getTime()));
	        dto.setModifiedDateTime(new Timestamp(new Date().getTime()));
	        
	        return dto;
	    }

	    /* (non-Javadoc)
    	 * @see in.co.sunrays.proj0.form.BaseForm#populate(in.co.sunrays.proj0.dto.BaseDTO)
    	 */
    	@Override
	    public void populate(BaseDTO bDto) {
	        StudentDTO dto = (StudentDTO) bDto;
	        System.out.println("------------------------------");
	        id = dto.getId();
	        firstName = dto.getFirstName();
	        lastName = dto.getLastName();
	        dob = Util.getDate(dto.getDob());
	        gender = dto.getGender();
	        mobileNo = dto.getMobileNo();
	        email = dto.getEmail();
	        collegeId = dto.getCollegeId();
	        firstName=dto.getFirstName();
	        lastName=dto.getLastName();
	        createdBy = dto.getCreatedBy();
	        modifiedBy = dto.getModifiedBy();
	        if (dto.getCreatedDateTime() != null) {
	            createdDatetime = dto.getCreatedDateTime().getTime();
	        }
	        if (dto.getModifiedDateTime() != null) {
	            modifiedDatetime = dto.getModifiedDateTime().getTime();
	        }
	        System.out.println("----------------------------e--");
	    }

}

