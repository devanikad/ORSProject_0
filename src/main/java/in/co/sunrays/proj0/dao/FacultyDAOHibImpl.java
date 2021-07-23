package in.co.sunrays.proj0.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import in.co.sunrays.proj0.dto.CollegeDTO;
import in.co.sunrays.proj0.dto.CourseDTO;
import in.co.sunrays.proj0.dto.FacultyDTO;
import in.co.sunrays.proj0.dto.SubjectDTO;
import in.co.sunrays.proj0.dto.UserDTO;

// TODO: Auto-generated Javadoc
/**
 * Faculty Data Access Object provides Database CRUD operations. It is
 * implemented by plain Hibernate 3 API with Spring ORM.
 * 
 * All methods propagate unchecked DataAccessException. It is a generic
 * exception handling provided by Spring-DAO.
 * 
 * If DataAccessException is propagated from method then declarative transaction
 * is rolled back by Spring AOP.
 * 
 * This is plain Hibernate 3 API implementation of DAO
 * 
 * @author Iterator Copyright (c) Iterator
 */
@Repository
public class FacultyDAOHibImpl implements FacultyDAOInt {
	
	/** The sessionfactory. */
	@Autowired
	private SessionFactory sessionfactory = null;
	
	/** The college. */
	@Autowired
	private CollegeDAOInt college=null;
	
	/** The subject. */
	@Autowired
	private SubjectDAOInt subject=null;
	
	/** The course. */
	@Autowired
	private CourseDAOInt course=null;
	
	/** The log. */
	private static Logger log = Logger.getLogger(FacultyDAOHibImpl.class);

	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.dao.FacultyDAOInt#add(in.co.sunrays.proj0.dto.FacultyDTO)
	 */
	public long add(FacultyDTO dto) throws DataAccessException {
		log.debug("Faculty Dao Add Started");
		
		
		CollegeDTO colname = college.findByPK(dto.getCollegeId());
		System.out.println("college name "+colname.getName());
		dto.setCollegeName(colname.getName());
		
		CourseDTO coursedto = course.findByPK(dto.getCourseId());
		System.out.println("course name---> "+coursedto.getName());
		dto.setCourseName(coursedto.getName());
		
		
		 SubjectDTO subjectdto = subject.findByPK(dto.getSubjectId());
		 System.out.println("subject name---> "+subjectdto.getName());
		 dto.setSubjectName(subjectdto.getName());
		 
		long pk = 0;
		pk = (Long) sessionfactory.getCurrentSession().save(dto);
		log.debug("Faculty Dao Add End");
		return pk;
	}

	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.dao.FacultyDAOInt#update(in.co.sunrays.proj0.dto.FacultyDTO)
	 */
	public void update(FacultyDTO dto) throws DataAccessException {
		log.debug("Faculty Dao Update Started");
		CollegeDTO colname = college.findByPK(dto.getCollegeId());
		System.out.println("college name "+colname.getName());
		dto.setCollegeName(colname.getName());
		
		CourseDTO coursedto = course.findByPK(dto.getCourseId());
		System.out.println("course name---> "+coursedto.getName());
		dto.setCourseName(coursedto.getName());
		
		
		 SubjectDTO subjectdto = subject.findByPK(dto.getSubjectId());
		 System.out.println("subject name---> "+subjectdto.getName());
		 dto.setSubjectName(subjectdto.getName());
		 
		sessionfactory.getCurrentSession().update(dto);
		log.debug("Faculty Dao Update End");

	}

	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.dao.FacultyDAOInt#delete(long)
	 */
	public void delete(long id) throws DataAccessException {
		log.debug("Faculty Dao Delete Started");
		FacultyDTO dto = findByPK(id);
		sessionfactory.getCurrentSession().delete(dto);
		log.debug("Faculty Dao Delete End");
	}

	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.dao.FacultyDAOInt#findByEmail(java.lang.String)
	 */
	public FacultyDTO findByEmail(String login) throws DataAccessException {
		log.debug("User Dao FindByLogin Started");
		FacultyDTO dto = null;
		List list = sessionfactory.getCurrentSession().createCriteria(FacultyDTO.class)
				.add(Restrictions.eq("emailId", login)).list();
		if (list.size() == 1) {
			dto = (FacultyDTO) list.get(0);
		}
		log.debug("User Dao FindByLogin End");
		return dto;
	}

	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.dao.FacultyDAOInt#findByPK(long)
	 */
	public FacultyDTO findByPK(long pk) throws DataAccessException {
		log.debug("Faculty Dao FindByEmail Started");
		FacultyDTO dto = null;
		dto = (FacultyDTO) sessionfactory.getCurrentSession().get(FacultyDTO.class, pk);
		log.debug("Faculty Dao FindByEmail End");
		return dto;
	}

	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.dao.FacultyDAOInt#search(in.co.sunrays.proj0.dto.FacultyDTO, int, int)
	 */
	public List<FacultyDTO> search(FacultyDTO dto, int pageNo, int pageSize) throws DataAccessException {
		log.debug("Faculty Dao Search Started");
		List list = null;
		Criteria criteria = sessionfactory.getCurrentSession().createCriteria(FacultyDTO.class);
		if (dto != null) {
			if (dto.getId() > 0) {
				criteria.add(Restrictions.eq("id", dto.getId()));
			}
			if (dto.getFirstName() != null && dto.getFirstName().length() > 0) {
				criteria.add(Restrictions.like("firstName", dto.getFirstName() + "%"));
			}
			if (dto.getLastName() != null && dto.getLastName().length() > 0) {
				criteria.add(Restrictions.like("lastName", dto.getLastName() + "%"));
			}
			if (dto.getEmailId() != null && dto.getEmailId().length() > 0) {
				criteria.add(Restrictions.like("emailId", dto.getEmailId() + "%"));
			}

			if (dto.getGender() != null && dto.getGender().length() > 0) {
				criteria.add(Restrictions.like("gender", dto.getGender() + "%"));
			}
			if (dto.getDob() != null && dto.getDob().getDate() > 0) {
				criteria.add(Restrictions.eq("dob", dto.getDob()));
			}

		}

		// if page size is greater than zero the apply pagination
		if (pageSize > 0) {
			criteria.setFirstResult((pageNo - 1) * pageSize);
			criteria.setMaxResults(pageSize);
		}

		list = criteria.list();
		log.debug("Faculty Dao Search End");
		return list;

	}

	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.dao.FacultyDAOInt#search(in.co.sunrays.proj0.dto.FacultyDTO)
	 */
	public List<FacultyDTO> search(FacultyDTO dto) throws DataAccessException {
		// TODO Auto-generated method stub
		return search(dto, 0, 0);
	}
}
