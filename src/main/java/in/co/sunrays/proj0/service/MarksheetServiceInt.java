package in.co.sunrays.proj0.service;

import java.util.List;

import in.co.sunrays.proj0.dto.MarksheetDTO;
import in.co.sunrays.proj0.exception.DuplicateRecordException;

// TODO: Auto-generated Javadoc
/**
 * This is MarksheetServiceInt.
 */
public interface MarksheetServiceInt {
	
	/**
	 * Adds a Marksheet.
	 * 
	 * param dto
	 * return
	 * throws DuplicateRecordException
	 *
	 * @param dto the dto
	 * @return the long
	 * @throws DuplicateRecordException the duplicate record exception
	 */
	public long add(MarksheetDTO dto) throws DuplicateRecordException;

	/**
	 * Updates a Marksheet.
	 * 
	 * param dto
	 * throws DuplicateRecordException
	 *
	 * @param dto the dto
	 * @throws DuplicateRecordException the duplicate record exception
	 */
	public void update(MarksheetDTO dto) throws DuplicateRecordException;

	/**
	 * Deletes a Marksheet
	 * 
	 * param id.
	 *
	 * @param id the id
	 */
	public void delete(long id);

	/**
	 * Finds a Marksheet by Roll number.
	 * 
	 * param roleNumber
	 * return
	 *
	 * @param roleNumber the role number
	 * @return the marksheet DTO
	 */
	public MarksheetDTO findByRollNumber(String roleNumber);

	/**
	 * Finds a Marksheet by ID
	 * 
	 * param id
	 * return.
	 *
	 * @param id the id
	 * @return the marksheet DTO
	 */
	public MarksheetDTO findById(long id);

	/**
	 * Searches Marksheet with pagination.
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
	public List<MarksheetDTO> search(MarksheetDTO dto, int pageNo, int pageSize);

	/**
	 * Searches Marksheet
	 * 
	 * param dto
	 * return.
	 *
	 * @param dto the dto
	 * @return the list
	 */
	public List<MarksheetDTO> search(MarksheetDTO dto);
	
	/**
	 *  Marksheet Merite list
	 * 
	 * param dto
	 * return.
	 *
	 * @param pageNo the page no
	 * @param pageSize the page size
	 * @return the merit list
	 */
	public List<MarksheetDTO> getMeritList(int pageNo, int pageSize);
}
