package in.co.sunrays.proj0.dao;

import java.util.List;

import in.co.sunrays.proj0.dto.SubjectDTO;

// TODO: Auto-generated Javadoc
/**
 * The Interface of SubjectDAOInt.
 */
public interface SubjectDAOInt {
	/**
	 * Adds a Subject.
	 * 
	 * param dto
	 * return
	 *
	 * @param dto the dto
	 * @return the long
	 */
	public long add(SubjectDTO dto);

	/**
	 * Updates a Subject.
	 * 
	 * param dto
	 *
	 * @param dto the dto
	 */
	public void update(SubjectDTO dto);

	/**
	 * Deletes a Subject.
	 * 
	 * param dto
	 *
	 * @param id the id
	 */
	public void delete(long id);

	/**
	 * Finds Subject by name.
	 * 
	 * param subjectName
	 * return
	 *
	 * @param subjectName the Subject name
	 * @return the role DTO
	 */
	public SubjectDTO findByName(String subjectName);

	/**
	 * Finds Subject by Primary Key.
	 * 
	 * param pk
	 * return
	 *
	 * @param pk the pk
	 * @return the role DTO
	 */
	public SubjectDTO findByPK(long pk);

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
	 * Seraches Subject.
	 * 
	 * param dto
	 * return
	 *
	 * @param dto the dto
	 * @return the list
	 */
	public List<SubjectDTO> search(SubjectDTO dto);
}
