package in.co.sunrays.proj0.service;

import java.util.List;

import in.co.sunrays.proj0.dto.RoleDTO;
import in.co.sunrays.proj0.dto.UserDTO;
import in.co.sunrays.proj0.exception.ApplicationException;
import in.co.sunrays.proj0.exception.DuplicateRecordException;

// TODO: Auto-generated Javadoc
/**
 * The Interface UserServiceInt.
 */
public interface UserServiceInt {

	/**
	 * Adds a user
	 * 
	 * param dto
	 * throws DuplicateRecordException.
	 *
	 * @param dto the dto
	 * @return the long
	 * @throws DuplicateRecordException the duplicate record exception
	 */
    public long add(UserDTO dto)throws DuplicateRecordException;

    /**
     * Registers a user
     * 
     * param dto
     * throws ApplicationException
     * throws DuplicateRecordException.
     *
     * @param dto the dto
     * @return the long
     * @throws DuplicateRecordException the duplicate record exception
     * @throws ApplicationException the application exception
     */
    public long registerUser(UserDTO dto) throws DuplicateRecordException,ApplicationException;

    /**
     * Updates a User
     * 
     * param dto
     * throws DuplicateRecordException.
     *
     * @param dto the dto
     * @throws DuplicateRecordException the duplicate record exception
     */
    public void update(UserDTO dto)throws DuplicateRecordException;

    /**
     * Deletes a user
     * 
     * param dto.
     *
     * @param id the id
     */
    public void delete(long id);

    /**
     * Finds user by Login
     * 
     * param login
     *            : get parameter
     * return dto.
     *
     * @param login the login
     * @return the user DTO
     */
    public UserDTO findByLogin(String login);

    /**
     * Finds user by PK
     * 
     * param pk
     *            : get parameter
     * return dto.
     *
     * @param pk the pk
     * @return the user DTO
     */
    public UserDTO findByPK(long pk);

    /**
     * Searches Users with pagination
     * 
     * return list : List of Users
     * param dto
     *            : Search Parameters
     * param pageNo
     *            : Current Page No.
     * param pageSize
     *            : Size of Page
     *
     * @param dto the dto
     * @param pageNo the page no
     * @param pageSize the page size
     * @return the list
     */
    public List search(UserDTO dto, int pageNo, int pageSize);

    /**
     * Searches Users
     * 
     * return list : List of Users
     * param dto
     *            : Search Parameters.
     *
     * @param dto the dto
     * @return the list
     */
    public List search(UserDTO dto);

    /**
     * Change Password By pk
     * 
     * param pk
     *            ,oldPassword,newPassword : get parameter
     * return dto.
     *
     * @param id the id
     * @param oldPassword the old password
     * @param newPassword the new password
     * @return true, if successful
     * @throws DuplicateRecordException the duplicate record exception
     */
    public boolean changePassword(Long id, String oldPassword,
            String newPassword) throws DuplicateRecordException;

    /**
     * User Authentication
     * 
     * return dto : Contains User's information
     * param dto.
     *
     * @param dto the dto
     * @return the user DTO
     */
    public UserDTO authenticate(UserDTO dto);


    /**
     * Reset Password of User with auto generated Password
     * 
     * return boolean : true if success otherwise false
     * param login
     *            : User Login
     * throws ApplicationException.
     *
     * @param login the login
     * @return true, if successful
     * @throws ApplicationException the application exception
     */
    public boolean resetPassword(String login) throws ApplicationException;

    /**
     * Send the password of User to his Email
     * 
     * return boolean : true if success otherwise false
     * param login
     *            : User Login
     * throws ApplicationException.
     *
     * @param login the login
     * @return true, if successful
     * @throws ApplicationException the application exception
     */
    public boolean forgetPassword(String login) throws ApplicationException;

    /**
     * Gets the role.
     *
     * @param dto the dto
     * @return the role
     */
    public RoleDTO getRole(UserDTO dto);

	
}
