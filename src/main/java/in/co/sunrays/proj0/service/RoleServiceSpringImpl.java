package in.co.sunrays.proj0.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.sunrays.proj0.dao.RoleDAOInt;
import in.co.sunrays.proj0.dto.RoleDTO;
import in.co.sunrays.proj0.exception.DuplicateRecordException;

// TODO: Auto-generated Javadoc
/**
 * The Class RoleServiceSpringImpl.
 */
@Service
public class RoleServiceSpringImpl implements RoleServiceInt{

	/** The dao. */
	@Autowired
    private RoleDAOInt dao;

    /** The log. */
    private static Logger log = Logger.getLogger(RoleServiceSpringImpl.class);

    /* (non-Javadoc)
     * @see in.co.sunrays.proj0.service.RoleServiceInt#add(in.co.sunrays.proj0.dto.RoleDTO)
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
	public long add(RoleDTO dto) throws DuplicateRecordException {
    	
    	log.debug("RoleServiceSpringImpl Add Started");
        RoleDTO dtoExist = dao.findByName(dto.getName());
        System.out.println(dto.getName());
        if (dtoExist != null) {
            throw new DuplicateRecordException("Role Name already exists");
        }
        long pk = dao.add(dto);
        log.debug("RoleServiceSpringImpl Add End");
        System.out.println(dto.getName());
        return pk;
	}

    /* (non-Javadoc)
     * @see in.co.sunrays.proj0.service.RoleServiceInt#update(in.co.sunrays.proj0.dto.RoleDTO)
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void update(RoleDTO dto) throws DuplicateRecordException {
    	log.debug("RoleServiceSpringImpl update Started");
    	dao.update(dto);
    	log.debug("RoleServiceSpringImpl update End");
	}

    /* (non-Javadoc)
     * @see in.co.sunrays.proj0.service.RoleServiceInt#delete(long)
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(long id) {
    	log.debug("RoleServiceSpringImpl delete Started");
    	 dao.delete(id);
    	log.debug("RoleServiceSpringImpl delete End");
        
	}

    /* (non-Javadoc)
     * @see in.co.sunrays.proj0.service.RoleServiceInt#findByName(java.lang.String)
     */
    @Transactional(readOnly = true)
	public RoleDTO findByName(String roleName) {
    	log.debug("RoleServiceSpringImpl findByName Started");
    	RoleDTO dto = dao.findByName(roleName);
    	log.debug("RoleServiceSpringImpl findByName End");
    	return dto;
	}

    /* (non-Javadoc)
     * @see in.co.sunrays.proj0.service.RoleServiceInt#findById(long)
     */
    @Transactional(readOnly = true)
	public RoleDTO findById(long id) {
		log.debug("RoleServiceSpringImpl findById Started");
    	RoleDTO dto = dao.findByPK(id);
    	log.debug("RoleServiceSpringImpl findById End");
    	return dto;
	}

    /* (non-Javadoc)
     * @see in.co.sunrays.proj0.service.RoleServiceInt#search(in.co.sunrays.proj0.dto.RoleDTO, int, int)
     */
    @Transactional(readOnly = true)
	public List<RoleDTO> search(RoleDTO dto, int pageNo, int pageSize) {
    	return dao.search(dto, pageNo, pageSize);

	}

    /* (non-Javadoc)
     * @see in.co.sunrays.proj0.service.RoleServiceInt#search(in.co.sunrays.proj0.dto.RoleDTO)
     */
    @Transactional(readOnly = true)
	public List<RoleDTO> search(RoleDTO dto) {
    	return dao.search(dto);
	}
}
