package in.co.sunrays.proj0.dao;

import java.util.List;

import in.co.sunrays.proj0.dto.CourseDTO;

// TODO: Auto-generated Javadoc
/**
 * The Interface of CourseDAOInt.
 */
public interface CourseDAOInt {
	/**
	 * Adds a Course.
	 * 
	 * param dto
	 * return
	 *
	 * @param dto the dto
	 * @return the long
	 */
	public long add(CourseDTO dto);

	/**
	 * Updates a Course.
	 * 
	 * param dto
	 *
	 * @param dto the dto
	 */
	public void update(CourseDTO dto);

	/**
	 * Deletes a Course.
	 * 
	 * param dto
	 *
	 * @param id the id
	 */
	public void delete(long id);

	/**
	 * Finds Course by name.
	 * 
	 * param courseName
	 * return
	 *
	 * @param courseName the Course name
	 * @return the role DTO
	 */
	public CourseDTO findByName(String courseName);

	/**
	 * Finds Course by Primary Key.
	 * 
	 * param pk
	 * return
	 *
	 * @param pk the pk
	 * @return the Course DTO
	 */
	public CourseDTO findByPK(long pk);

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
	 * Seraches Course.
	 * 
	 * param dto
	 * return
	 *
	 * @param dto the dto
	 * @return the list
	 */
	public List<CourseDTO> search(CourseDTO dto);
}
