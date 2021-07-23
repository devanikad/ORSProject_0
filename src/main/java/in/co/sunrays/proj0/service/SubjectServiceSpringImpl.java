package in.co.sunrays.proj0.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.sunrays.proj0.dao.SubjectDAOInt;
import in.co.sunrays.proj0.dto.SubjectDTO;
import in.co.sunrays.proj0.exception.DuplicateRecordException;

// TODO: Auto-generated Javadoc
/**
 * The Class SubjectServiceSpringImpl.
 */
@Service
public class SubjectServiceSpringImpl implements SubjectServiceInt {

	/** The dao. */
	@Autowired
	SubjectDAOInt dao;
	
	/** The log. */
	private static Logger log = Logger.getLogger(SubjectServiceSpringImpl.class);

    /* (non-Javadoc)
     * @see in.co.sunrays.proj0.service.SubjectServiceInt#add(in.co.sunrays.proj0.dto.SubjectDTO)
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
	public long add(SubjectDTO dto) throws DuplicateRecordException {
    	log.debug("SubjectServiceSpringImpl Add Started");
        SubjectDTO dtoExist = dao.findByName(dto.getName());
        if (dtoExist != null) {
            throw new DuplicateRecordException("Subject Name is already exists");
        }
        long pk = dao.add(dto);
        log.debug("SubjectServiceSpringImpl Add End");
        return pk;
	}
    
    /* (non-Javadoc)
     * @see in.co.sunrays.proj0.service.SubjectServiceInt#update(in.co.sunrays.proj0.dto.SubjectDTO)
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void update(SubjectDTO dto) throws DuplicateRecordException {
    	log.debug("SubjectServiceSpringImpl update Started");
    	dao.update(dto);
    	log.debug("SubjectServiceSpringImpl update End");
	}
    
    /* (non-Javadoc)
     * @see in.co.sunrays.proj0.service.SubjectServiceInt#delete(long)
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(long id) {
		log.debug("SubjectServiceSpringImpl delete Started");
   	 dao.delete(id);
   	log.debug("SubjectServiceSpringImpl delete End");
		
	}
    
    /* (non-Javadoc)
     * @see in.co.sunrays.proj0.service.SubjectServiceInt#findByName(java.lang.String)
     */
    @Transactional( readOnly = false)
	public SubjectDTO findByName(String subjectName) {
		log.debug("SubjectServiceSpringImpl findByName Started");
    	SubjectDTO dto = dao.findByName(subjectName);
    	log.debug("SubjectServiceSpringImpl findByName End");
    	return dto;
	}
    
    /* (non-Javadoc)
     * @see in.co.sunrays.proj0.service.SubjectServiceInt#findById(long)
     */
    @Transactional( readOnly = false)
	public SubjectDTO findById(long id) {
		log.debug("SubjectServiceSpringImpl findById Started");
    	SubjectDTO dto = dao.findByPK(id);
    	log.debug("SubjectServiceSpringImpl findById End");
    	return dto;
	}
    
    /* (non-Javadoc)
     * @see in.co.sunrays.proj0.service.SubjectServiceInt#search(in.co.sunrays.proj0.dto.SubjectDTO, int, int)
     */
    @Transactional( readOnly = false)
	public List<SubjectDTO> search(SubjectDTO dto, int pageNo, int pageSize) {
		
		return dao.search(dto, pageNo, pageSize);
	}
    
    /* (non-Javadoc)
     * @see in.co.sunrays.proj0.service.SubjectServiceInt#search(in.co.sunrays.proj0.dto.SubjectDTO)
     */
    @Transactional( readOnly = false)
	public List<SubjectDTO> search(SubjectDTO dto) {
		// TODO Auto-generated method stub
		 return dao.search(dto);
	}

}
