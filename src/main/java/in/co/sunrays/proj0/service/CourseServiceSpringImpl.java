package in.co.sunrays.proj0.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.sunrays.proj0.dao.CourseDAOInt;
import in.co.sunrays.proj0.dto.CourseDTO;
import in.co.sunrays.proj0.exception.DuplicateRecordException;
// TODO: Auto-generated Javadoc

/**
 * The Class CourseServiceSpringImpl.
 */
@Service
public class CourseServiceSpringImpl implements CourseServiceInt {
	
	/** The dao. */
	@Autowired
	CourseDAOInt dao;
	
	/** The log. */
	private static Logger log = Logger.getLogger(CourseServiceSpringImpl.class);
	
	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.service.CourseServiceInt#add(in.co.sunrays.proj0.dto.CourseDTO)
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
	public long add(CourseDTO dto) throws DuplicateRecordException {

    	log.debug("CourseServiceSpringImpl Add Started");
    	CourseDTO dtoExist = dao.findByName(dto.getName());
        if (dtoExist != null) {
            throw new DuplicateRecordException("Course Name already exists");
        }
        long pk = dao.add(dto);
        log.debug("CourseServiceSpringImpl Add End");
        return pk;
	}
	
	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.service.CourseServiceInt#update(in.co.sunrays.proj0.dto.CourseDTO)
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void update(CourseDTO dto) throws DuplicateRecordException {
		log.debug("CourseServiceSpringImpl update Started");
    	dao.update(dto);
    	log.debug("CourseServiceSpringImpl update End");
	}
	
	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.service.CourseServiceInt#delete(long)
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
	public void delete(long id) {
		log.debug("CourseServiceSpringImpl delete Started");
   	 dao.delete(id);
   	log.debug("CourseServiceSpringImpl delete End");
		
	}
	
	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.service.CourseServiceInt#findByName(java.lang.String)
	 */
	@Transactional(readOnly = false)
	public CourseDTO findByName(String courseName) {
		log.debug("CourseServiceSpringImpl findByName Started");
		CourseDTO dto = dao.findByName(courseName);
    	log.debug("CourseServiceSpringImpl findByName End");
    	return dto;
	}
	
	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.service.CourseServiceInt#findById(long)
	 */
	@Transactional(readOnly = false)
	public CourseDTO findById(long id) {
		log.debug("CourseServiceSpringImpl findById Started");
		CourseDTO dto = dao.findByPK(id);
    	log.debug("CourseServiceSpringImpl findById End");
    	return dto;
	}
	
	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.service.CourseServiceInt#search(in.co.sunrays.proj0.dto.CourseDTO, int, int)
	 */
	@Transactional( readOnly = false)
	public List<CourseDTO> search(CourseDTO dto, int pageNo, int pageSize) {
		return dao.search(dto, pageNo, pageSize);
	}
	
	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.service.CourseServiceInt#search(in.co.sunrays.proj0.dto.CourseDTO)
	 */
	@Transactional(readOnly = false)
	public List<CourseDTO> search(CourseDTO dto) {
		return dao.search(dto);
	}

}
