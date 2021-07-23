package in.co.sunrays.proj0.form;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import in.co.sunrays.proj0.dto.BaseDTO;
import in.co.sunrays.proj0.dto.UserDTO;

// TODO: Auto-generated Javadoc
/**
 * Contains Forget Password form elements and their declarative input validations.
 * 
 * @author Iterator
 * @version 1.0 Copyright (c) Iterator
 */
public class ForgetPasswordForm extends BaseForm{
	
	/** email of FrogetPassword. */   
	@NotEmpty
    @Email
    private String login;

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

/* (non-Javadoc)
 * @see in.co.sunrays.proj0.form.BaseForm#getDto()
 */
@Override
public BaseDTO getDto() {
	UserDTO dto=new UserDTO();
	 dto.setEmailId(login);
	return dto;
}

/* (non-Javadoc)
 * @see in.co.sunrays.proj0.form.BaseForm#populate(in.co.sunrays.proj0.dto.BaseDTO)
 */
@Override
public void populate(BaseDTO bDto) {
	UserDTO dto = (UserDTO) bDto;
	 login = dto.getEmailId();

}
}


