package in.co.sunrays.proj0.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.sunrays.proj0.dao.FacultyDAOInt;
import in.co.sunrays.proj0.dto.FacultyDTO;
import in.co.sunrays.proj0.exception.DuplicateRecordException;
// TODO: Auto-generated Javadoc

/**
 * The Class FacultyServiceSpringImpl.
 */
@Service
public class FacultyServiceSpringImpl implements FacultyServiceInt {
   
   /** The dao. */
   @Autowired
	FacultyDAOInt dao;
   
   /** The log. */
   private static Logger log = Logger.getLogger(FacultyServiceSpringImpl.class);
	
	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.service.FacultyServiceInt#add(in.co.sunrays.proj0.dto.FacultyDTO)
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
	public long add(FacultyDTO dto) throws DuplicateRecordException {
		log.debug("FacultyServiceSpringImpl Add Started");
		FacultyDTO dtoExist = dao.findByEmail(dto.getEmailId());
        if (dtoExist != null) {
            throw new DuplicateRecordException("Email ID already exists");
        }
        long pk = dao.add(dto);
        log.debug("FacultyServiceSpringImpl Add End");
        return pk;
	}
	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.service.FacultyServiceInt#update(in.co.sunrays.proj0.dto.FacultyDTO)
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
	public void update(FacultyDTO dto) throws DuplicateRecordException {
		log.debug("FacultyServiceSpringImpl update Started");
    	dao.update(dto);
    	log.debug("FacultyServiceSpringImpl update End");
		
	}
	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.service.FacultyServiceInt#delete(long)
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
	public void delete(long id) {
		log.debug("FacultyServiceSpringImpl delete Started");
	   	 dao.delete(id);
	   	log.debug("FacultyServiceSpringImpl delete End");		
	}
	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.service.FacultyServiceInt#findByEmail(java.lang.String)
	 */
	@Transactional( readOnly = false)
	public FacultyDTO findByEmail(String login) {
		log.debug("FacultyServiceSpringImpl findByEmail Started");
		FacultyDTO dto = dao.findByEmail(login);
    	log.debug("FacultyServiceSpringImpl findByEmail End");
    	return dto;
	}
	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.service.FacultyServiceInt#findByPK(long)
	 */
	@Transactional( readOnly = false)
	public FacultyDTO findByPK(long pk) {
		log.debug("FacultyServiceSpringImpl findByPK Started");
		FacultyDTO dto = dao.findByPK(pk);
    	log.debug("FacultyServiceSpringImpl findByPK End");
    	return dto;
	}
	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.service.FacultyServiceInt#search(in.co.sunrays.proj0.dto.FacultyDTO, int, int)
	 */
	@Transactional( readOnly = false)
	public List<FacultyDTO> search(FacultyDTO dto, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		log.debug("FacultyServiceSpringImpl search Started");
		return dao.search(dto, pageNo, pageSize);
	}
	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.service.FacultyServiceInt#search(in.co.sunrays.proj0.dto.FacultyDTO)
	 */
	@Transactional( readOnly = false)
	public List<FacultyDTO> search(FacultyDTO dto) {
		// TODO Auto-generated method stub
		log.debug("FacultyServiceSpringImpl search tarted");
		return dao.search(dto);
	}

}
