package in.co.sunrays.proj0.form;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import in.co.sunrays.proj0.dto.BaseDTO;
import in.co.sunrays.proj0.dto.UserDTO;
import in.co.sunrays.proj0.util.Util;

// TODO: Auto-generated Javadoc
/**
 * The Class UserRegistrationForm.
 */
public class UserRegistrationForm extends BaseForm 
{
	
	/** First Name of User. */
	@NotEmpty
	//@Custom(message = "{Custom.form.firstName}",regex = "[A-Za-z]+\\.?")
	private String firstName;
	
	/** Last Name of User. */
	@NotEmpty
	//@Custom(message = "{Custom.form.lastName}",regex = "^[a-zA-Z,.'-]+$")
	private String lastName;
	
	/** Login id of User. */
	@NotEmpty
	@Email
	private String login;
	
	/** Password of User. */
	@NotEmpty
	//@Custom(message = "{Custom.form.password}",regex = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$")
	private String password;

	/** Date of Birth of User. */
	@NotEmpty
	private String dob;

	/** MobielNo of User. */
 
	
	@NotEmpty
	//@Phone(message = "{Phone.form.mobileNo}")
	private String mobileNo;

	/** Gender of User. */
	@NotEmpty
	private String gender;

	/** The confirm password. */
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
	public BaseDTO getDto() 
	{
	   UserDTO dto = new UserDTO();
	   
	   dto.setId(id);
	   dto.setFirstName(firstName);
	   dto.setLastName(lastName);
	   dto.setGender(gender);
	   dto.setMobileNo(mobileNo);
	   dto.setPassword(password);
	   dto.setDob(Util.getDate(dob));
	   dto.setEmailId(login);
	   dto.setConfirmPassword(confirmPassword);
	   
		return dto;
	}
	
	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.form.BaseForm#populate(in.co.sunrays.proj0.dto.BaseDTO)
	 */
	@Override
	public void populate(BaseDTO bDto) 
	{
		UserDTO dto = (UserDTO)bDto;
		
		id = dto.getId();
		firstName = dto.getFirstName();
		lastName = dto.getLastName();
		login = dto.getEmailId();
		password = dto.getPassword();
		if (dob != null) {
			dob = Util.getDate(dto.getDob());
		}
		mobileNo = dto.getMobileNo();
		gender = dto.getGender();
		confirmPassword = dto.getConfirmPassword();
	}

	
}
