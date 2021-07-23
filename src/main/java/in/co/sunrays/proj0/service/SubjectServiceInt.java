package in.co.sunrays.proj0.service;

import java.util.List;

import org.springframework.stereotype.Service;

import in.co.sunrays.proj0.dto.SubjectDTO;
import in.co.sunrays.proj0.exception.DuplicateRecordException;

// TODO: Auto-generated Javadoc
/**
 * The Interface of SubjectServiceInt.
 */

public interface SubjectServiceInt {

	/**
	 * Adds a Subject.
	 * 
	 * param dto
	 * return
	 * throws DuplicateRecordException
	 *
	 * @param dto the dto
	 * @return the long
	 * @throws DuplicateRecordException the duplicate record exception
	 */
	public long add(SubjectDTO dto) throws DuplicateRecordException;

	/**
	 * Updates a Subject.
	 * 
	 * param dto
	 * throws DuplicateRecordException
	 *
	 * @param dto the dto
	 * @throws DuplicateRecordException the duplicate record exception
	 */
	public void update(SubjectDTO dto) throws DuplicateRecordException;

	/**
	 * Deletes a Subject
	 * 
	 * param id.
	 *
	 * @param id the id
	 */
	public void delete(long id);

	/**
	 * Finds a Subject by name.
	 * 
	 * param subjectName
	 * return
	 *
	 * @param subjectName the subject name
	 * @return the subject DTO
	 */
	public SubjectDTO findByName(String subjectName);

	/**
	 * Finds a Subject by ID
	 * 
	 * param id
	 * return.
	 *
	 * @param id the id
	 * @return the subject DTO
	 */
	public SubjectDTO findById(long id);

	/**
	 * Searches Subject with pagination.
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
	public List<SubjectDTO> search(SubjectDTO dto, int pageNo, int pageSize);

	/**
	 * Searches Subject
	 * 
	 * param dto
	 * return.
	 *
	 * @param dto the dto
	 * @return the list
	 */
	public List<SubjectDTO> search(SubjectDTO dto);
}
