package in.co.sunrays.proj0.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.sunrays.proj0.dao.MarksheetDAOInt;
import in.co.sunrays.proj0.dto.MarksheetDTO;
import in.co.sunrays.proj0.dto.RoleDTO;
import in.co.sunrays.proj0.exception.DuplicateRecordException;
// TODO: Auto-generated Javadoc

/**
 * The Class MarksheetServiceSpringImpl.
 */
@Service
public class MarksheetServiceSpringImpl implements MarksheetServiceInt{

	/** The dao. */
	@Autowired
	MarksheetDAOInt dao;
	
	/** The log. */
	private static Logger log = Logger.getLogger(MarksheetServiceSpringImpl.class);
	
	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.service.MarksheetServiceInt#add(in.co.sunrays.proj0.dto.MarksheetDTO)
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
	public long add(MarksheetDTO dto) throws DuplicateRecordException {
		log.debug("MarksheetServiceSpringImpl Add Started");
		
		System.out.println("inside service--------------->");
		MarksheetDTO dtoExist = dao.findByRollNumber(dto.getRollNo());
        if (dtoExist != null) {
            throw new DuplicateRecordException("Role Number already exists");
        }
        long pk = dao.add(dto);
        log.debug("MarksheetServiceSpringImpl Add End");
        return pk;
	}
	
	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.service.MarksheetServiceInt#update(in.co.sunrays.proj0.dto.MarksheetDTO)
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void update(MarksheetDTO dto) throws DuplicateRecordException {
		log.debug("MarksheetServiceSpringImpl update Started");
		System.out.println("inside Upadate 1--------------->");
    	
		dao.update(dto);
    	
		System.out.println("inside Update 2--------------->");
		log.debug("MarksheetServiceSpringImpl update End");
		
	}
	
	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.service.MarksheetServiceInt#delete(long)
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(long id) {
		log.debug("MarksheetServiceSpringImpl delete Start");
   	 dao.delete(id);
   	log.debug("MarksheetServiceSpringImpl delete End");
		
	}
	
	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.service.MarksheetServiceInt#findByRollNumber(java.lang.String)
	 */
	@Transactional(readOnly = false)
	public MarksheetDTO findByRollNumber(String roleNumber) {
		log.debug("MarksheetServiceSpringImpl findByRollNumber Started");
		MarksheetDTO dto = dao.findByRollNumber(roleNumber);
    	log.debug("MarksheetServiceSpringImpl findByRollNumber End");
    	return dto;
	}
	
	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.service.MarksheetServiceInt#findById(long)
	 */
	@Transactional(readOnly = false)
	public MarksheetDTO findById(long id) {
		log.debug("MarksheetServiceSpringImpl findById Started");
		MarksheetDTO dto = dao.findByPK(id);
    	log.debug("MarksheetServiceSpringImpl findById End");
    	return dto;
	}
	
	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.service.MarksheetServiceInt#search(in.co.sunrays.proj0.dto.MarksheetDTO, int, int)
	 */
	@Transactional(readOnly = false)
	public List<MarksheetDTO> search(MarksheetDTO dto, int pageNo, int pageSize) {
		
		return dao.search(dto, pageNo, pageSize);
	}
	
	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.service.MarksheetServiceInt#search(in.co.sunrays.proj0.dto.MarksheetDTO)
	 */
	@Transactional(readOnly = false)
	public List<MarksheetDTO> search(MarksheetDTO dto) {
		
		return dao.search(dto);
	}
	
	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.service.MarksheetServiceInt#getMeritList(int, int)
	 */
	@Transactional(readOnly = false)
	public List<MarksheetDTO> getMeritList( int pageNo, int pageSize) {
		
		return dao.search(new MarksheetDTO(), pageNo, pageSize);
	}

}
