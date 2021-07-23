package in.co.sunrays.proj0.dao;

import java.util.List;

import in.co.sunrays.proj0.dto.CollegeDTO;
// TODO: Auto-generated Javadoc
/**
 * The Interface CollegeDAOInt.
 */
public interface CollegeDAOInt {
	/**
	 * Adds a College.
	 * 
	 * param dto
	 * return
	 *
	 * @param dto the dto
	 * @return the long
	 */
	public long add(CollegeDTO dto);

	/**
	 * Updates a College.
	 * 
	 * param dto
	 *
	 * @param dto the dto
	 */
	public void update(CollegeDTO dto);

	/**
	 * Deletes a College.
	 * 
	 * param dto
	 *
	 * @param id the id
	 */
	public void delete(long id);

	/**
	 * Finds College by name.
	 * 
	 * param College Name
	 * return
	 *
	 * @param roleName the role name
	 * @return the role DTO
	 */
	public CollegeDTO findByName(String roleName);

	/**
	 * Finds College by Primary Key.
	 * 
	 * param pk
	 * return
	 *
	 * @param pk the pk
	 * @return the College DTO
	 */
	public CollegeDTO findByPK(long pk);

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
	 * Seraches College.
	 * 
	 * param dto
	 * return
	 *
	 * @param dto the dto
	 * @return the list
	 */
	public List search(CollegeDTO dto);

}
