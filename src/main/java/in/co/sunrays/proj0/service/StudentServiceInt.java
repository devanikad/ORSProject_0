package in.co.sunrays.proj0.service;

import java.util.List;

import in.co.sunrays.proj0.dto.StudentDTO;
import in.co.sunrays.proj0.exception.DuplicateRecordException;

// TODO: Auto-generated Javadoc
/**
 * The Interface StudentServiceInt.
 */
public interface StudentServiceInt {
	
	/**
	 * Adds a Student.
	 * 
	 * param dto
	 * return
	 * throws DuplicateRecordException
	 *
	 * @param dto the dto
	 * @return the long
	 * @throws DuplicateRecordException the duplicate record exception
	 */
	public long add(StudentDTO dto) throws DuplicateRecordException;

	/**
	 * Updates a Student.
	 * 
	 * param dto
	 * throws DuplicateRecordException
	 *
	 * @param dto the dto
	 * @throws DuplicateRecordException the duplicate record exception
	 */
	public void update(StudentDTO dto) throws DuplicateRecordException;

	/**
	 * Deletes a Student
	 * 
	 * param id.
	 *
	 * @param id the id
	 */
	public void delete(long id);

	/**
	 * Finds a Student by Email ID.
	 * 
	 * param email
	 * return
	 *
	 * @param email the email
	 * @return the student DTO
	 */
	public StudentDTO findByEmail(String email);

	/**
	 * Finds a Student by ID
	 * 
	 * param id
	 * return.
	 *
	 * @param id the id
	 * @return the student DTO
	 */
	public StudentDTO findById(long id);

	/**
	 * Searches Students with pagination.
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
	 * Searches Students
	 * 
	 * param dto
	 * return.
	 *
	 * @param dto the dto
	 * @return the list
	 */
	public List<StudentDTO> search(StudentDTO dto);
}
