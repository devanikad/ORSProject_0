package in.co.sunrays.proj0.dao;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.co.sunrays.proj0.dto.CourseDTO;
import in.co.sunrays.proj0.dto.SubjectDTO;
import in.co.sunrays.proj0.dto.TimeTableDTO;
// TODO: Auto-generated Javadoc
/**
 * TimeTable Data Access Object provides Database CRUD operations. It is implemented
 * by plain Hibernate 3 API with Spring ORM.
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
public class TimeTableDAOHibImpl implements TimeTableDAOInt{
	
	/** The sessionfactory. */
	@Autowired
	private SessionFactory sessionfactory = null;
    
    /** The c dao. */
    @Autowired
	CourseDAOInt cDao;
	
	/** The s dao. */
	@Autowired
	SubjectDAOInt sDao;
	
	/** The log. */
	private static Logger log = Logger.getLogger(TimeTableDAOHibImpl.class);

	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.dao.TimeTableDAOInt#add(in.co.sunrays.proj0.dto.TimeTableDTO)
	 */
	public long add(TimeTableDTO dto) {
		log.debug("TimeTable Dao Add Started");
		long pk = 0;
		CourseDTO cdto= cDao.findByPK(dto.getCourseId());
		 SubjectDTO sdto= sDao.findByPK(dto.getSubjectId());
		 dto.setCourseName(cdto.getName());
		 dto.setSubjectName(sdto.getName());
		pk = (Long) sessionfactory.getCurrentSession().save(dto);
		log.debug("TimeTable Dao Add End");
		return pk;
	}

	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.dao.TimeTableDAOInt#update(in.co.sunrays.proj0.dto.TimeTableDTO)
	 */
	public void update(TimeTableDTO dto) {
		log.debug("TimeTable Dao Update Started");
		CourseDTO cdto= cDao.findByPK(dto.getCourseId());
		 SubjectDTO sdto= sDao.findByPK(dto.getSubjectId());
		 dto.setCourseName(cdto.getName());
		 dto.setSubjectName(sdto.getName());
		sessionfactory.getCurrentSession().merge(dto);
		log.debug("TimeTable Dao Update End");
		
	}

	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.dao.TimeTableDAOInt#delete(long)
	 */
	public void delete(long id) {
		log.debug("TimeTable Dao Delete Started");
		TimeTableDTO dto = findByPK(id);
		sessionfactory.getCurrentSession().delete(dto);
		log.debug("TimeTable Dao Delete End");
		
	}

	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.dao.TimeTableDAOInt#findTimeTableDuplicacy(java.lang.Long, java.lang.String, java.util.Date)
	 */
	public TimeTableDTO findTimeTableDuplicacy(Long courseId, String Semester, Date examdate) {
		log.debug("TimeTable Dao FindTimeTableDuplicacy Started");
		TimeTableDTO dto = null;
		List list = sessionfactory.getCurrentSession().createCriteria(TimeTableDTO.class)
				.add(Restrictions.eq("courseId", courseId))
		        .add(Restrictions.eq("semester", Semester))
		.add(Restrictions.eq("examDate", examdate)).list();
		if (list.size() == 1) {
			dto = (TimeTableDTO) list.get(0);
		}
		log.debug("TimeTable Dao FindTimeTableDuplicacy End");
		return dto;
	}

	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.dao.TimeTableDAOInt#findTimeTableDuplicacy(java.lang.Long, java.lang.Long, java.util.Date)
	 */
	public TimeTableDTO findTimeTableDuplicacy(Long courseId, Long subjectId, Date examDate) {
		log.debug("TimeTable Dao FindTimeTableDuplicacy Started");
		TimeTableDTO dto = null;
		List list = sessionfactory.getCurrentSession().createCriteria(TimeTableDTO.class)
				.add(Restrictions.eq("courseId", courseId))
		        .add(Restrictions.eq("subjectId", subjectId))
		.add(Restrictions.eq("examDate", examDate)).list();
		if (list.size() == 1) {
			dto = (TimeTableDTO) list.get(0);
		}
		log.debug("TimeTable Dao FindTimeTableDuplicacy End");
		return dto;
	}

	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.dao.TimeTableDAOInt#findTimeTableDuplicacy(java.lang.Long, java.lang.String, java.lang.Long)
	 */
	public TimeTableDTO findTimeTableDuplicacy(Long courseId, String Semester, Long subjectId) {
		log.debug("TimeTable Dao FindTimeTableDuplicacy Started");
		TimeTableDTO dto = null;
		List list = sessionfactory.getCurrentSession().createCriteria(TimeTableDTO.class)
				.add(Restrictions.eq("courseId", courseId))
		        .add(Restrictions.eq("semester", Semester))
		.add(Restrictions.eq("subjectId", subjectId)).list();
		if (list.size() == 1) {
			dto = (TimeTableDTO) list.get(0);
		}
		log.debug("TimeTable Dao FindTimeTableDuplicacy End");
		return dto;
	}

	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.dao.TimeTableDAOInt#findByPK(long)
	 */
	public TimeTableDTO findByPK(long pk) {
		log.debug("TimeTable Dao FindByPK Started");
		TimeTableDTO dto = null;
		dto = (TimeTableDTO) sessionfactory.getCurrentSession().get(TimeTableDTO.class, pk);
		log.debug("TimeTable Dao FindByPK End");
		return dto;
	}

	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.dao.TimeTableDAOInt#search(in.co.sunrays.proj0.dto.TimeTableDTO, int, int)
	 */
	public List<TimeTableDTO> search(TimeTableDTO dto, int pageNo, int pageSize) {
		log.debug("TimeTableDAOHibImpl search Started");
		Criteria criteria = sessionfactory.getCurrentSession().createCriteria(TimeTableDTO.class);
		
		if(dto!=null)
		{
		if (dto.getId() > 0) {
            criteria.add(Restrictions.eq("id", dto.getId()));
        }if (dto.getCourseId() > 0) {
            criteria.add(Restrictions.eq("courseId", dto.getCourseId()));
        }if (dto.getSubjectId() > 0) {
            criteria.add(Restrictions.eq("subjectId", dto.getSubjectId()));
        }
        if (dto.getExamDate() != null ) {
            criteria.add(Restrictions.eq("examDate", dto.getExamDate() ));
        }
        
		}
        // if page size is greater than zero the apply pagination
        if (pageSize > 0) {
            criteria.setFirstResult(((pageNo - 1) * pageSize));
            criteria.setMaxResults(pageSize);
        }
		List list = criteria.list();
		log.debug("TimeTableDAOHibImpl search End");
		return list;

	}

	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.dao.TimeTableDAOInt#search(in.co.sunrays.proj0.dto.TimeTableDTO)
	 */
	public List<TimeTableDTO> search(TimeTableDTO dto) {
		// TODO Auto-generated method stub
		return search(dto, 0, 0);
	}

}
