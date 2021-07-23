package in.co.sunrays.proj0.dto;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import java.util.Date;

import javax.persistence.Column;

// TODO: Auto-generated Javadoc
/**
 * The Class UserDTO.
 */
@Entity
@Table(name= "ST_USER")
public class UserDTO extends BaseDTO{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The first name. */
	@Column(name = "FIRST_NAME",length = 255)
    private String firstName;
	
	/** The last name. */
	@Column(name = "LAST_NAME" , length = 255 )
	private String lastName;
	
	/** The gender. */
	@Column(name = "GENDER", length = 255)
	private String gender;

	/** The email id. */
	@Column(name = "EMAIL_ID", length = 255)
	private String emailId;

	/** The password. */
	@Column(name = "PASSWORD", length = 255)
	private String password;

	/** The confirm password. */
	@Transient
	private String confirmPassword;

	/** The role id. */
	@Column(name = "ROLE_ID")
	private long roleId;

	/** The role name. */
	@Column(name = "ROLE_NAME", length = 255)
	private String roleName;

	/** The dob. */
	@Column(name = "DOB")
	private Date dob;
	
	/** The mobile no. */
	private String mobileNo;

	/**
	 * Gets the mobile no.
	 *
	 * @return the mobile no
	 */
	@Column(name="MOBILE_NO")
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
	 * Gets the email id.
	 *
	 * @return the email id
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * Sets the email id.
	 *
	 * @param emailId the new email id
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
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

	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.dto.DropDownList#getKey()
	 */
	public String getKey() {
		
		return id+"";
	}

	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.dto.DropDownList#getValue()
	 */
	public String getValue() {
		
		return firstName+" "+lastName;
	}

	


}
