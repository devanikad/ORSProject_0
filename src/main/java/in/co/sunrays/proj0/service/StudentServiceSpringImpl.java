package in.co.sunrays.proj0.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.sunrays.proj0.dao.StudentDAOInt;
import in.co.sunrays.proj0.dto.StudentDTO;
import in.co.sunrays.proj0.exception.DuplicateRecordException;
// TODO: Auto-generated Javadoc

/**
 * The Class StudentServiceSpringImpl.
 */
@Service
public class StudentServiceSpringImpl implements StudentServiceInt{

	/** The dao. */
	@Autowired
	StudentDAOInt dao;
	
	/** The log. */
	private static Logger log = Logger.getLogger(StudentServiceSpringImpl.class);

	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.service.StudentServiceInt#add(in.co.sunrays.proj0.dto.StudentDTO)
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
	public long add(StudentDTO dto) throws DuplicateRecordException {
    	
    	log.debug("StudentServiceSpringImpl Add Started");
        StudentDTO dtoExist = dao.findByEmail(dto.getEmail());
        if (dtoExist != null) {
            throw new DuplicateRecordException("Email ID already exists");
        }
        long pk = dao.add(dto);
        log.debug("StudentServiceSpringImpl Add End");
        return pk;
	}
	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.service.StudentServiceInt#update(in.co.sunrays.proj0.dto.StudentDTO)
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void update(StudentDTO dto) throws DuplicateRecordException {
    	log.debug("StudentServiceSpringImpl update Started");
    	dao.update(dto);
    	log.debug("StudentServiceSpringImpl update End");

		
	}
	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.service.StudentServiceInt#delete(long)
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(long id) {
    	log.debug("StudentServiceSpringImpl delete Started");
   	 dao.delete(id);
   	log.debug("StudentServiceSpringImpl delete End");

		
	}

	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.service.StudentServiceInt#findByEmail(java.lang.String)
	 */
	@Transactional(readOnly = false)
	public StudentDTO findByEmail(String email) {
		log.debug("StudentServiceSpringImpl findByEmail Started");
    	StudentDTO dto = dao.findByEmail(email);
    	log.debug("StudentServiceSpringImpl findByEmail End");
    	return dto;
	}
	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.service.StudentServiceInt#findById(long)
	 */
	@Transactional(readOnly = false)
	public StudentDTO findById(long id) {
		log.debug("StudentServiceSpringImpl findById Started");
    	StudentDTO dto = dao.findByPK(id);
    	log.debug("StudentServiceSpringImpl findById End");
    	return dto;
	}
	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.service.StudentServiceInt#search(in.co.sunrays.proj0.dto.StudentDTO, int, int)
	 */
	@Transactional(readOnly = false)
	public List<StudentDTO> search(StudentDTO dto, int pageNo, int pageSize) {
	
		return dao.search(dto, pageNo, pageSize);
	}
	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.service.StudentServiceInt#search(in.co.sunrays.proj0.dto.StudentDTO)
	 */
	@Transactional(readOnly = false)
	public List<StudentDTO> search(StudentDTO dto) {
	
		return dao.search(dto);
	}

}
