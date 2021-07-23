package in.co.sunrays.proj0.service;

import java.util.Date;
import java.util.List;



import in.co.sunrays.proj0.dto.TimeTableDTO;
import in.co.sunrays.proj0.exception.DuplicateRecordException;

// TODO: Auto-generated Javadoc
/**
 * The Interface TimeTableServiceInt.
 */
public interface TimeTableServiceInt {
	
	/**
	 * Adds a TimeTable.
	 * 
	 * param dto
	 * return
	 * throws DuplicateRecordException
	 *
	 * @param dto the dto
	 * @return the long
	 * @throws DuplicateRecordException the duplicate record exception
	 */
	public long add(TimeTableDTO dto) throws DuplicateRecordException;

	/**
	 * Updates a TimeTable.
	 * 
	 * param dto
	 * throws DuplicateRecordException
	 *
	 * @param dto the dto
	 * @throws DuplicateRecordException the duplicate record exception
	 */
	public void update(TimeTableDTO dto) throws DuplicateRecordException;

	/**
	 * Deletes a TimeTable
	 * 
	 * param id.
	 *
	 * @param id the id
	 */
	public void delete(long id);

	
	/**
	 * Finds a TimeTable by ID
	 * 
	 * param id
	 * return.
	 *
	 * @param id the id
	 * @return the time table DTO
	 */
	public TimeTableDTO findByPk(long id);
	

	/**
	 * Searches TimeTables with pagination.
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
	public List<TimeTableDTO> search(TimeTableDTO dto, int pageNo, int pageSize);

	/**
	 * Searches TimeTables
	 * 
	 * param dto
	 * return.
	 *
	 * @param dto the dto
	 * @return the list
	 */
	public List<TimeTableDTO> search(TimeTableDTO dto);
}
