package in.co.sunrays.proj0.service;

import java.util.List;

import in.co.sunrays.proj0.dto.CourseDTO;
import in.co.sunrays.proj0.exception.DuplicateRecordException;

// TODO: Auto-generated Javadoc
/**
 * The Interface of CourseServiceInt.
 */
public interface CourseServiceInt {
	
	/**
	 * Adds a Course.
	 * 
	 * param dto
	 * return
	 * throws DuplicateRecordException
	 *
	 * @param dto the dto
	 * @return the long
	 * @throws DuplicateRecordException the duplicate record exception
	 */
	public long add(CourseDTO dto) throws DuplicateRecordException;

	/**
	 * Updates a Course.
	 * 
	 * param dto
	 * throws DuplicateRecordException
	 *
	 * @param dto the dto
	 * @throws DuplicateRecordException the duplicate record exception
	 */
	public void update(CourseDTO dto) throws DuplicateRecordException;

	/**
	 * Deletes a CourseDTO
	 * 
	 * param id.
	 *
	 * @param id the id
	 */
	public void delete(long id);

	/**
	 * Finds a Course by name.
	 * 
	 * param roleName
	 * return
	 *
	 * @param courseName the course name
	 * @return the course DTO
	 */
	public CourseDTO findByName(String courseName);

	/**
	 * Finds a Course by ID
	 * 
	 * param id
	 * return.
	 *
	 * @param id the id
	 * @return the course DTO
	 */
	public CourseDTO findById(long id);

	/**
	 * Searches Course with pagination.
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
	public List<CourseDTO> search(CourseDTO dto, int pageNo, int pageSize);

	/**
	 * Searches Course
	 * 
	 * param dto
	 * return.
	 *
	 * @param dto the dto
	 * @return the list
	 */
	public List<CourseDTO> search(CourseDTO dto);
}
