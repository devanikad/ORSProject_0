package in.co.sunrays.proj0.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.co.sunrays.proj0.dto.RoleDTO;
import in.co.sunrays.proj0.dto.StudentDTO;
// TODO: Auto-generated Javadoc

/**
 * The Class StudentDAOHibImpl.
 */
@Repository
public class StudentDAOHibImpl implements StudentDAOInt {

	/** The sessionfactory. */
	@Autowired
	private	SessionFactory sessionfactory = null;
	/** The log. */
	private static Logger log = Logger.getLogger(StudentDAOHibImpl.class);
	
	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.dao.StudentDAOInt#add(in.co.sunrays.proj0.dto.StudentDTO)
	 */
	public long add(StudentDTO dto) {
		log.debug("Student Dao Add Started");
		long pk = (Long) sessionfactory.getCurrentSession().save(dto);
		log.debug("Student Dao Add End");
		return pk;
	}

	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.dao.StudentDAOInt#update(in.co.sunrays.proj0.dto.StudentDTO)
	 */
	public void update(StudentDTO dto) {
		log.debug("Student Dao Update Started");
		sessionfactory.getCurrentSession().update(dto);
		log.debug("Student Dao Update End");
		
	}

	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.dao.StudentDAOInt#delete(long)
	 */
	public void delete(long id) {
		log.debug("Student Dao Delete Started");
		StudentDTO dto = findByPK(id);
		sessionfactory.getCurrentSession().delete(dto);
		log.debug("Student Dao Delete End");
		
	}

	

	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.dao.StudentDAOInt#findByPK(long)
	 */
	public StudentDTO findByPK(long pk) {
		log.debug("Student Find by PK Started");
		StudentDTO dto = null;
		dto = (StudentDTO) sessionfactory.getCurrentSession().get(StudentDTO.class, pk);
		log.debug("Student Find by PK Ended");
		return dto;

	}

	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.dao.StudentDAOInt#findByEmail(java.lang.String)
	 */
	public StudentDTO findByEmail(String email) {
		log.debug("Student DAO Find by Email Started");
		StudentDTO dto = null;
		List list = sessionfactory.getCurrentSession().createCriteria(StudentDTO.class).add(Restrictions.eq("emailId", email)).list();
		if (list.size() == 1) {
			dto = (StudentDTO) list.get(0);
		}
		log.debug("Student DAO Find by Email Ended");
		return dto;
	}

	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.dao.StudentDAOInt#search(in.co.sunrays.proj0.dto.StudentDTO, int, int)
	 */
	public List<StudentDTO> search(StudentDTO dto, int pageNo, int pageSize) {
		log.debug("Student DAO search Started");
		Criteria criteria = sessionfactory.getCurrentSession().createCriteria(StudentDTO.class);
		if(dto!=null)
		{
			
		
		if (dto.getId() > 0) {
            criteria.add(Restrictions.eq("id", dto.getId()));
        }
		if (dto.getCollegeId() > 0) {
            criteria.add(Restrictions.eq("collegeId", dto.getCollegeId()));
        }
        if (dto.getFirstName() != null && dto.getFirstName().length() > 0) {
            criteria.add(Restrictions.like("firstName", dto.getFirstName() + "%"));
        }
        if (dto.getLastName() != null && dto.getLastName().length() > 0) {
            criteria.add(Restrictions.like("lastName", dto.getLastName() + "%"));
        }
        
		}
        // if page size is greater than zero the apply pagination
        if (pageSize > 0) {
            criteria.setFirstResult(((pageNo - 1) * pageSize));
            criteria.setMaxResults(pageSize);
        }
		List<StudentDTO> list = criteria.list();
		log.debug("Student DAO search End");
		return list;


	}

	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.dao.StudentDAOInt#search(in.co.sunrays.proj0.dto.StudentDTO)
	 */
	public List<StudentDTO> search(StudentDTO dto) {
		return search(dto, 0, 0);
	}

}
