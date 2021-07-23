package in.co.sunrays.proj0.dao;

import java.util.List;

import in.co.sunrays.proj0.dto.RoleDTO;

// TODO: Auto-generated Javadoc
/**
 * The Interface RoleDAOInt.
 */
public interface RoleDAOInt {
	/**
	 * Adds a Role.
	 * 
	 * param dto
	 * return
	 *
	 * @param dto the dto
	 * @return the long
	 */
	public long add(RoleDTO dto);

	/**
	 * Updates a Role.
	 * 
	 * param dto
	 *
	 * @param dto the dto
	 */
	public void update(RoleDTO dto);

	/**
	 * Deletes a Role.
	 * 
	 * param dto
	 *
	 * @param id the id
	 */
	public void delete(long id);

	/**
	 * Finds Role by name.
	 * 
	 * param roleName
	 * return
	 *
	 * @param roleName the role name
	 * @return the role DTO
	 */
	public RoleDTO findByName(String roleName);

	/**
	 * Finds Role by Primary Key.
	 * 
	 * param pk
	 * return
	 *
	 * @param pk the pk
	 * @return the role DTO
	 */
	public RoleDTO findByPK(long pk);

	/**
	 * Searches Role with pagination.
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
	public List<RoleDTO> search(RoleDTO dto, int pageNo, int pageSize);

	/**
	 * Seraches Role.
	 * 
	 * param dto
	 * return
	 *
	 * @param dto the dto
	 * @return the list
	 */
	public List<RoleDTO> search(RoleDTO dto);
}
