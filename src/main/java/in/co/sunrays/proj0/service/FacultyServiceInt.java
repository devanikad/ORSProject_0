package in.co.sunrays.proj0.service;

import java.util.List;

import in.co.sunrays.proj0.dto.FacultyDTO;
import in.co.sunrays.proj0.exception.DuplicateRecordException;

// TODO: Auto-generated Javadoc
/**
 * The Interface FacultyServiceInt.
 */
public interface FacultyServiceInt {

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
    public long add(FacultyDTO dto)throws DuplicateRecordException;

    /**
     * Updates a User
     * 
     * param dto
     * throws DuplicateRecordException.
     *
     * @param dto the dto
     * @throws DuplicateRecordException the duplicate record exception
     */
    public void update(FacultyDTO dto)throws DuplicateRecordException;

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
     * @return the faculty DTO
     */
    public FacultyDTO findByEmail(String login);

    /**
     * Finds user by PK
     * 
     * param pk
     *            : get parameter
     * return dto.
     *
     * @param pk the pk
     * @return the faculty DTO
     */
    public FacultyDTO findByPK(long pk);

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
    public List<FacultyDTO> search(FacultyDTO dto, int pageNo, int pageSize);

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
    public List<FacultyDTO> search(FacultyDTO dto);
}
