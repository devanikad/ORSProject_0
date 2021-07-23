package in.co.sunrays.proj0.dao;

import java.util.List;

import in.co.sunrays.proj0.dto.StudentDTO;

// TODO: Auto-generated Javadoc
/**
 * The Interface StudentDAOInt.
 */
public interface StudentDAOInt {
	/**
	 * Adds a Student.
	 * 
	 * param dto
	 * return
	 *
	 * @param dto the dto
	 * @return the long
	 */
	public long add(StudentDTO dto);

	/**
	 * Updates a Student.
	 * 
	 * param dto
	 *
	 * @param dto the dto
	 */
	public void update(StudentDTO dto);

	/**
	 * Deletes a Student.
	 * 
	 * param dto
	 *
	 * @param id the id
	 */
	public void delete(long id);


	/**
	 * Finds Student by Primary Key.
	 * 
	 * param pk
	 * return
	 *
	 * @param pk the pk
	 * @return the Student DTO
	 */
	public StudentDTO findByPK(long pk);


	/**
	 * Finds Student by Email ID.
	 * 
	 * param email
	 * return
	 *
	 * @param email the email
	 * @return the Student DTO
	 */
	public StudentDTO findByEmail(String email);

	/**
	 * Searches Student with pagination.
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
	public List<StudentDTO> search(StudentDTO dto, int pageNo, int pageSize);

	/**
	 * Searches Student.
	 * 
	 * param dto
	 * return
	 *
	 * @param dto the dto
	 * @return the list
	 */
	public List<StudentDTO> search(StudentDTO dto);

}
