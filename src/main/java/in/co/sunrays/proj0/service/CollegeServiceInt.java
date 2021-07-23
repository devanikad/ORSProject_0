package in.co.sunrays.proj0.service;

import java.util.List;

import in.co.sunrays.proj0.dto.CollegeDTO;
import in.co.sunrays.proj0.exception.DuplicateRecordException;

// TODO: Auto-generated Javadoc
/**
 * The Interface CollegeServiceInt.
 */
public interface CollegeServiceInt {
	
	/**
	 * Adds a College.
	 * 
	 * param dto
	 * return
	 * throws DuplicateRecordException
	 *
	 * @param dto the dto
	 * @return the long
	 * @throws DuplicateRecordException the duplicate record exception
	 */
	public long add(CollegeDTO dto) throws DuplicateRecordException;

	/**
	 * Updates a College.
	 * 
	 * param dto
	 * throws DuplicateRecordException
	 *
	 * @param dto the dto
	 * @throws DuplicateRecordException the duplicate record exception
	 */
	public void update(CollegeDTO dto) throws DuplicateRecordException;

	/**
	 * Deletes a College
	 * 
	 * param id.
	 *
	 * @param id the id
	 */
	public void delete(long id);

	/**
	 * Finds a College by name.
	 * 
	 * param name
	 * return
	 *
	 * @param name the name
	 * @return the college DTO
	 */
	public CollegeDTO findByName(String name);

	/**
	 * Finds a College by ID
	 * 
	 * param id
	 * return.
	 *
	 * @param id the id
	 * @return the college DTO
	 */
	public CollegeDTO findById(long id);

	/**
	 * Searches College with pagination.
	 * 
	 * param dto
	 * param pageNo
	 * param pageSize
	 * return
	 *
	 * @param dto the dto
	 * @param pageNo the page no
	 * @param pageSize the page size
	 * @return the list
	 */
	public List search(CollegeDTO dto, int pageNo, int pageSize);

	/**
	 * Searches College
	 * 
	 * param dto
	 * return.
	 *
	 * @param dto the dto
	 * @return the list
	 */
	public List search(CollegeDTO dto);

}
