package in.co.sunrays.proj0.service;

import java.util.List;

import in.co.sunrays.proj0.dto.RoleDTO;
import in.co.sunrays.proj0.exception.DuplicateRecordException;

// TODO: Auto-generated Javadoc
/**
 * The Interface RoleServiceInt.
 */
public interface RoleServiceInt {
	
	/**
	 * Adds a Role.
	 * 
	 * param dto
	 * return
	 * throws DuplicateRecordException
	 *
	 * @param dto the dto
	 * @return the long
	 * @throws DuplicateRecordException the duplicate record exception
	 */
	public long add(RoleDTO dto) throws DuplicateRecordException;

	/**
	 * Updates a Role.
	 * 
	 * param dto
	 * throws DuplicateRecordException
	 *
	 * @param dto the dto
	 * @throws DuplicateRecordException the duplicate record exception
	 */
	public void update(RoleDTO dto) throws DuplicateRecordException;

	/**
	 * Deletes a Role
	 * 
	 * param id.
	 *
	 * @param id the id
	 */
	public void delete(long id);

	/**
	 * Finds a Role by name.
	 * 
	 * param roleName
	 * return
	 *
	 * @param roleName the role name
	 * @return the role DTO
	 */
	public RoleDTO findByName(String roleName);

	/**
	 * Finds a Role by ID
	 * 
	 * param id
	 * return.
	 *
	 * @param id the id
	 * @return the role DTO
	 */
	public RoleDTO findById(long id);

	/**
	 * Searches Roles with pagination.
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
	 * Searches Roles
	 * 
	 * param dto
	 * return.
	 *
	 * @param dto the dto
	 * @return the list
	 */
	public List<RoleDTO> search(RoleDTO dto);
}
