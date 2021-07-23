package in.co.sunrays.proj0.dao;

import java.util.List;

import in.co.sunrays.proj0.dto.MarksheetDTO;

// TODO: Auto-generated Javadoc
/**
 * The Interface MarksheetDAOInt.
 */
public interface MarksheetDAOInt {

	/**
	 * Adds a Marksheet.
	 * 
	 * param dto
	 * return
	 *
	 * @param dto the dto
	 * @return the long
	 */
	public long add(MarksheetDTO dto);

	/**
	 * Updates a Marksheet.
	 * 
	 * param dto
	 *
	 * @param dto the dto
	 */
	public void update(MarksheetDTO dto);

	/**
	 * Deletes a Marksheet.
	 * 
	 * param dto
	 *
	 * @param id the id
	 */
	public void delete(long id);

	/**
	 * Finds Marksheet by Roll Number.
	 * 
	 * param roleNumber
	 * return
	 *
	 * @param roleNumber the Marksheet 
	 * @return the role DTO
	 */
	public MarksheetDTO findByRollNumber(String roleNumber);

	/**
	 * Finds Marksheet by Primary Key.
	 * 
	 * param pk
	 * return
	 *
	 * @param pk the pk
	 * @return the role DTO
	 */
	public MarksheetDTO findByPK(long pk);

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
	 * Seraches Marksheet.
	 * 
	 * param dto
	 * return
	 *
	 * @param dto the dto
	 * @return the list
	 */
	public List<MarksheetDTO> search(MarksheetDTO dto);
}
