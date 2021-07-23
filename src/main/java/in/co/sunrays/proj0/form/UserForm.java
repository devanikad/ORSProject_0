package in.co.sunrays.proj0.form;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import in.co.sunrays.proj0.dto.BaseDTO;
import in.co.sunrays.proj0.dto.UserDTO;
import in.co.sunrays.proj0.util.Util;
//import in.co.sunrays.proj0.validator.Custom;

// TODO: Auto-generated Javadoc
/**
 * Contains User form elements and their declarative input validations.
 * 
 * @author Iterator
 * @version 1.0 Copyright (c) Iterator 
 */
public class UserForm extends BaseForm{
	
	/** The first name. */
	@NotEmpty
	/* @Pattern(regexp = "^[a-zA-Z_-]+$") */
	// @Custom(regex = "^[a-zA-Z_-]+$",message = "{error.firstName.invalid}")  
    private String firstName;
    
    /** Last Name of User. */
    @NotEmpty
   // @Custom(regex = "^[a-zA-Z_-]+$",message = "{Custom.form.lastName}")
    private String lastName;
    
    /** The login. */
    @NotEmpty
    @Email
    private String login;
    
    /** Password of User. */
    @NotEmpty(message =
	  "{Custom.form.password}")
	 //@Custom(regex="^[_A-Za-z0-9-]+(\\\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,})$")
    private String password;
    
    

    /** Date of Birth of User. */
    @NotEmpty
    private String dob;

    /** MobielNo of User. */
    @NotEmpty
	//@Phone(message = "{Phone.form.mobileNo}")
    private String mobileNo;

    /** Role of User. */
    @Min(value=1,message="{Min.form.roleId}")
    private long roleId;
    
    /** The role name. */
    private String roleName;
    
    /** Number of unsuccessful login attempt. */
    private int unSuccessfulLogin;
    
    /** Gender of User. */
    @NotEmpty
    private String gender;
    
    /** Last login long. */
    private long lastLogin;
    
    /** User Lock. */
    private String lock;

    /**
     * IP Address of User from where User was registred.
     */

    private String registeredIP;
    
    /** IP Address of User of his last login. */

    private String lastLoginIP;

    /** The confirm password. */
    /*
     * Accesor Methods
     */
    @NotEmpty
    private String confirmPassword;
    
    
  
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
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
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
	 * Gets the role id.
	 *
	 * @return the role id
	 */
	public long getRoleId() {
		return roleId;
	}

	/**
	 * Sets the role id.
	 *
	 * @param roleId the new role id
	 */
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	/**
	 * Gets the role name.
	 *
	 * @return the role name
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * Sets the role name.
	 *
	 * @param roleName the new role name
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * Gets the un successful login.
	 *
	 * @return the un successful login
	 */
	public int getUnSuccessfulLogin() {
		return unSuccessfulLogin;
	}

	/**
	 * Sets the un successful login.
	 *
	 * @param unSuccessfulLogin the new un successful login
	 */
	public void setUnSuccessfulLogin(int unSuccessfulLogin) {
		this.unSuccessfulLogin = unSuccessfulLogin;
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
	 * Gets the last login.
	 *
	 * @return the last login
	 */
	public long getLastLogin() {
		return lastLogin;
	}

	/**
	 * Sets the last login.
	 *
	 * @param lastLogin the new last login
	 */
	public void setLastLogin(long lastLogin) {
		this.lastLogin = lastLogin;
	}

	/**
	 * Gets the lock.
	 *
	 * @return the lock
	 */
	public String getLock() {
		return lock;
	}

	/**
	 * Sets the lock.
	 *
	 * @param lock the new lock
	 */
	public void setLock(String lock) {
		this.lock = lock;
	}

	/**
	 * Gets the registered IP.
	 *
	 * @return the registered IP
	 */
	public String getRegisteredIP() {
		return registeredIP;
	}

	/**
	 * Sets the registered IP.
	 *
	 * @param registeredIP the new registered IP
	 */
	public void setRegisteredIP(String registeredIP) {
		this.registeredIP = registeredIP;
	}

	/**
	 * Gets the last login IP.
	 *
	 * @return the last login IP
	 */
	public String getLastLoginIP() {
		return lastLoginIP;
	}

	/**
	 * Sets the last login IP.
	 *
	 * @param lastLoginIP the new last login IP
	 */
	public void setLastLoginIP(String lastLoginIP) {
		this.lastLoginIP = lastLoginIP;
	}

	/**
	 * Gets the confirm password.
	 *
	 * @return the confirm password
	 */
	public String getConfirmPassword() {
		return confirmPassword;
	}

	/**
	 * Sets the confirm password.
	 *
	 * @param confirmPassword the new confirm password
	 */
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
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
        
      /*  if(!password.matches(confirmPassword))
        {
        	dto.setPassword(password);
        	 dto.setConfirmPassword(confirmPassword);  	
        }
      */ 
        if(dob!=""){
        dto.setDob(Util.getDate(dob));
        }
        dto.setPassword(password);
        dto.setMobileNo(mobileNo);
        dto.setRoleId(roleId);
        dto.setRoleName(roleName);
        //dto.setLastLogin(new Timestamp(lastLogin));
        dto.setGender(gender);
       // dto.setRegisteredIP(registeredIP);
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

        UserDTO dto = (UserDTO) bDto;

        id = dto.getId();
        firstName = dto.getFirstName();
        lastName = dto.getLastName();
        login = dto.getEmailId();
        password = dto.getPassword();
        confirmPassword=dto.getConfirmPassword();
        gender=dto.getGender();
        dob = Util.getDate(dto.getDob());
        
        mobileNo = dto.getMobileNo();
        roleId = dto.getRoleId();
        
       /* if (dto.getLastLogin() != null) {
            lastLogin = dto.getLastLogin().getTime();
        }
        gender = dto.getGender();
        registeredIP = dto.getRegisteredIP();
        createdBy = dto.getCreatedBy();
        modifiedBy = dto.getModifiedBy();
        if (dto.getCreatedDatetime() != null) {
            createdDatetime = dto.getCreatedDatetime().getTime();
        }
        if (dto.getModifiedDatetime() != null) {
            modifiedDatetime = dto.getModifiedDatetime().getTime();
        }*/

    }

}

