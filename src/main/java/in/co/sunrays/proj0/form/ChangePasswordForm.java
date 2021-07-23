package in.co.sunrays.proj0.form;


import org.hibernate.validator.constraints.NotEmpty;

// TODO: Auto-generated Javadoc
/**
 * Contains Change Password form elements and their declarative input validations.
 * 
 * @author Facade
 * @version 1.0 Copyright (c) Facade
 */
public class ChangePasswordForm extends BaseForm{
	
	/** oldPassword of ChangePassword. */
    @NotEmpty
    private String oldPassword;
    
    /** newPassword of ChangePassword. */
    @NotEmpty
    private String newPassword;
    
    /** confirmPassword of ChangePassword. */
    @NotEmpty
    private String confirmPassword;

    /**
     * Gets the old password.
     *
     * @return the old password
     */
    public String getOldPassword() {
        return oldPassword;
    }

    /**
     * Sets the old password.
     *
     * @param oldPassword the new old password
     */
    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    /**
     * Gets the new password.
     *
     * @return the new password
     */
    public String getNewPassword() {
        return newPassword;
    }

    /**
     * Sets the new password.
     *
     * @param newPassword the new new password
     */
    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
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

}

