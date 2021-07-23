package in.co.sunrays.proj0.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import in.co.sunrays.proj0.dto.FacultyDTO;
// TODO: Auto-generated Javadoc
/**
 * The Interface FacultyDAOInt.
 */
public interface FacultyDAOInt {

	 /**
	 * Add a Faculty
	 * 
	 * param dto.
	 *
	 * @param dto the dto
	 * @return the long
	 * @throws DataAccessException the data access exception
	 */
   public long add(FacultyDTO dto) throws DataAccessException;

   /**
    * Update a Faculty
    * 
    * param dto
    * return.
    *
    * @param dto the dto
    * @throws DataAccessException the data access exception
    */
   public void update(FacultyDTO dto) throws DataAccessException;

   /**
    * Delete a Faculty
    * 
    * param id
    * return.
    *
    * @param id the id
    * @throws DataAccessException the data access exception
    */
   public void delete(long id) throws DataAccessException;

   /**
    * Find Faculty by Login
    * 
    * param login
    *            : get parameter
    * return dto.
    *
    * @param login the login
    * @return the user DTO
    * @throws DataAccessException the data access exception
    */
   public FacultyDTO findByEmail(String login) throws DataAccessException;

   /**
    * Find Faculty by PK
    * 
    * param pk
    *            : get parameter
    * return dto.
    *
    * @param pk the pk
    * @return the user DTO
    * @throws DataAccessException the data access exception
    */
   public FacultyDTO findByPK(long pk) throws DataAccessException;

   /**
    * Search Faculty with pagination
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
   public List<FacultyDTO> search(FacultyDTO dto, int pageNo, int pageSize)
           throws DataAccessException;

   /**
    * Search Faculty
    * 
    * param dto
    *            : Search Parameters.
    *
    * @param dto the dto
    * @return the list
    * @throws DataAccessException the data access exception
    */
   public List<FacultyDTO> search(FacultyDTO dto) throws DataAccessException;
	
}
