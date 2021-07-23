package in.co.sunrays.proj0.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.sunrays.proj0.dao.CollegeDAOInt;
import in.co.sunrays.proj0.dto.CollegeDTO;
import in.co.sunrays.proj0.exception.DuplicateRecordException;
// TODO: Auto-generated Javadoc

/**
 * The Class CollegeServiceSpringImpl.
 */
@Service
public class CollegeServiceSpringImpl implements CollegeServiceInt {

	/** The dao. */
	@Autowired
	CollegeDAOInt dao;
	
	/** The log. */
	private static Logger log = Logger.getLogger(RoleServiceSpringImpl.class);
	 /* (non-Javadoc)
	 * @see in.co.sunrays.proj0.service.CollegeServiceInt#add(in.co.sunrays.proj0.dto.CollegeDTO)
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
	public long add(CollegeDTO dto) throws DuplicateRecordException {
		 log.debug("CollegeServiceSpringImpl Add Started");
	        CollegeDTO dtoExist = dao.findByName(dto.getName());
	        if (dtoExist != null) {
	            throw new DuplicateRecordException("College already exists");
	        }
	        long pk = dao.add(dto);
	        log.debug("CollegeServiceSpringImpl Add End");
	        return pk;
	}
	 /* (non-Javadoc)
	 * @see in.co.sunrays.proj0.service.CollegeServiceInt#update(in.co.sunrays.proj0.dto.CollegeDTO)
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
	public void update(CollegeDTO dto) throws DuplicateRecordException {
		 log.debug("CollegeServiceSpringImpl update Started");
	    	
		 CollegeDTO dtoExist = dao.findByName(dto.getName());
	        if (dtoExist != null&&dtoExist.getId()!=dto.getId()) {
	            throw new DuplicateRecordException("College already exists");
	        }
		 dao.update(dto);
	    	log.debug("CollegeServiceSpringImpl update End");
		
	}
	 /* (non-Javadoc)
	 * @see in.co.sunrays.proj0.service.CollegeServiceInt#delete(long)
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(long id) {
	 	log.debug("CollegeServiceSpringImpl delete Started");
	 	System.out.println("in College delete 1-->>>>>>>>>>>>>>>");
   	 dao.delete(id);
   	System.out.println("in College delete 2-->>>>>>>>>>>>>>>");
  	 
   	log.debug("CollegeServiceSpringImpl delete End");
		
	}
	 /* (non-Javadoc)
	 * @see in.co.sunrays.proj0.service.CollegeServiceInt#findByName(java.lang.String)
	 */
	@Transactional(readOnly = true)
	public CollegeDTO findByName(String name) {
		log.debug("CollegeServiceSpringImpl findByName Started");
    	CollegeDTO dto = dao.findByName(name);
    	log.debug("CollegeServiceSpringImpl findByName End");
    	return dto;
	}
	 /* (non-Javadoc)
	 * @see in.co.sunrays.proj0.service.CollegeServiceInt#findById(long)
	 */
	@Transactional(readOnly = true)
	public CollegeDTO findById(long id) {
		log.debug("CollegeServiceSpringImpl findById Started");
    	CollegeDTO dto = dao.findByPK(id);
    	log.debug("CollegeServiceSpringImpl findById End");
    	return dto;
	}
	 /* (non-Javadoc)
	 * @see in.co.sunrays.proj0.service.CollegeServiceInt#search(in.co.sunrays.proj0.dto.CollegeDTO, int, int)
	 */
	@Transactional(readOnly = true)
	public List<CollegeDTO> search(CollegeDTO dto, int pageNo, int pageSize) {
		log.debug("CollegeServiceSpringImpl search start");
		return dao.search(dto, pageNo, pageSize);
	}
	 /* (non-Javadoc)
	 * @see in.co.sunrays.proj0.service.CollegeServiceInt#search(in.co.sunrays.proj0.dto.CollegeDTO)
	 */
	@Transactional(readOnly = true)
	public List search(CollegeDTO dto) {
		log.debug("CollegeServiceSpringImpl search start");
		return dao.search(dto);
	}

}
