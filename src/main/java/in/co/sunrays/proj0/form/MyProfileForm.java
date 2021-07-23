package in.co.sunrays.proj0.form;


import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import in.co.sunrays.proj0.dto.BaseDTO;
import in.co.sunrays.proj0.dto.UserDTO;
import in.co.sunrays.proj0.util.Util;

// TODO: Auto-generated Javadoc
/**
 * Contains MyProfile form elements and their declarative input validations.
 * 
 * @author Facade
 * @version 1.0 Copyright (c) Facade 
 */
public class MyProfileForm extends BaseForm{
	
	/** firstName of MyProfileForm. */
	    @NotEmpty
	    private String firstName;
	    
    	/** lastName of MyProfileForm. */
	    @NotEmpty
	    private String lastName;
	    
    	/** login of MyProfileForm. */
	    @NotEmpty
	    @Pattern(regexp = "^[_A-Za-z0-9-]+(.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message = "{Email.form.emailId}")
	    private String login;
	    
    	/** gender of MyProfileForm. */
	    @NotEmpty
	    private String gender;
	    
    	/** mobileNo of MyProfileForm. */
	    @NotEmpty
	    @Pattern(regexp = "^[6-9][0-9]{9}$", message = "{Pattern.password}")
	    private String mobileNo;
	    
    	/** dob of MyProfileForm. */
	    @NotEmpty
	    private String dob;
		
	    /**
    	 * Gets the first name.
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
		 * Gets the login.
		 *
		 * @return the login
		 */
		public String getLogin() {
			return login;
		}
		
		/**
		 * Sets the login.
		 *
		 * @param login the new login
		 */
		public void setLogin(String login) {
			this.login = login;
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

	    /* (non-Javadoc)
    	 * @see in.co.sunrays.proj0.form.BaseForm#getDto()
    	 */
    	@Override
	    public BaseDTO getDto() {
	        UserDTO dto = new UserDTO();
	        dto.setId(id);
	        dto.setFirstName(firstName);
	        dto.setLastName(lastName);
	        dto.setEmailId(login);
	        dto.setDob(Util.getDate(dob));
	        dto.setMobileNo(mobileNo);
	        dto.setGender(gender);
	      
	        return dto;
	    }

	    /* (non-Javadoc)
    	 * @see in.co.sunrays.proj0.form.BaseForm#populate(in.co.sunrays.proj0.dto.BaseDTO)
    	 */
    	@Override
	    public void populate(BaseDTO bDto) {
	        UserDTO dto = (UserDTO) bDto;
	        id = dto.getId();
	        firstName = dto.getFirstName();
	        lastName = dto.getLastName();
	        login = dto.getEmailId();
	        dob = Util.getDate(dto.getDob());
	        mobileNo = dto.getMobileNo();
	        gender = dto.getGender();
	        
	        super.populate(bDto);
	    }

}
