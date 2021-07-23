package in.co.sunrays.proj0.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import in.co.sunrays.proj0.dto.UserDTO;

// TODO: Auto-generated Javadoc
/**
 * The Interface UserDAOInt.
 */
public interface UserDAOInt {

	
	 /**
 	 * Add a User
 	 * 
 	 * param dto.
 	 *
 	 * @param dto the dto
 	 * @return the long
 	 * @throws DataAccessException the data access exception
 	 */
    public long add(UserDTO dto) throws DataAccessException;

    /**
     * Update a User
     * 
     * param dto
     * return.
     *
     * @param dto the dto
     * @throws DataAccessException the data access exception
     */
    public void update(UserDTO dto) throws DataAccessException;

    /**
     * Delete a User
     * 
     * param id
     * return.
     *
     * @param id the id
     * @throws DataAccessException the data access exception
     */
    public void delete(long id) throws DataAccessException;

    /**
     * Find User by Login
     * 
     * param login
     *            : get parameter
     * return dto.
     *
     * @param login the login
     * @return the user DTO
     * @throws DataAccessException the data access exception
     */
    public UserDTO findByLogin(String login) throws DataAccessException;

    /**
     * Find User by PK
     * 
     * param pk
     *            : get parameter
     * return dto.
     *
     * @param pk the pk
     * @return the user DTO
     * @throws DataAccessException the data access exception
     */
    public UserDTO findByPK(long pk) throws DataAccessException;

    /**
     * Search Users with pagination
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
     * @throws DataAccessException the data access exception
     */
    public List search(UserDTO dto, int pageNo, int pageSize)
            throws DataAccessException;

    /**
     * Search Users
     * 
     * param dto
     *            : Search Parameters.
     *
     * @param dto the dto
     * @return the list
     * @throws DataAccessException the data access exception
     */
    public List search(UserDTO dto) throws DataAccessException;
	
}
