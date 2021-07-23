package in.co.sunrays.proj0.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.co.sunrays.proj0.dto.RoleDTO;
import in.co.sunrays.proj0.dto.SubjectDTO;
// TODO: Auto-generated Javadoc

/**
 * The Class SubjectDAOHibImpl.
 */
@Repository
public class SubjectDAOHibImpl implements SubjectDAOInt {
	/** The sessionfactory. */
	@Autowired
	private	SessionFactory sessionfactory = null;
	
	/** The log. */
	private static Logger log = Logger.getLogger(SubjectDAOHibImpl.class);
	
	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.dao.SubjectDAOInt#add(in.co.sunrays.proj0.dto.SubjectDTO)
	 */
	public long add(SubjectDTO dto) {
		log.debug("SubjectDAOHibImpl Add Started");
		long pk = (Long) sessionfactory.getCurrentSession().save(dto);
		log.debug("SubjectDAOHibImpl Add End");
		return pk;
	}

	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.dao.SubjectDAOInt#update(in.co.sunrays.proj0.dto.SubjectDTO)
	 */
	public void update(SubjectDTO dto) {
		log.debug("SubjectDAOHibImpl Update Started");
		sessionfactory.getCurrentSession().update(dto);
		log.debug("SubjectDAOHibImpl Update End");
		
	}

	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.dao.SubjectDAOInt#delete(long)
	 */
	public void delete(long id) {
		log.debug("SubjectDAOHibImpl Delete Started");
		SubjectDTO dto = findByPK(id);
		sessionfactory.getCurrentSession().delete(dto);
		log.debug("SubjectDAOHibImpl Delete End");

		
	}

	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.dao.SubjectDAOInt#findByName(java.lang.String)
	 */
	public SubjectDTO findByName(String subjectName) {
		log.debug("SubjectDAOHibImpl Find by Name Started");
		SubjectDTO dto = null;
		List list = sessionfactory.getCurrentSession().createCriteria(SubjectDTO.class).add(Restrictions.eq("name", subjectName)).list();
		if (list.size() == 1) {
			dto = (SubjectDTO) list.get(0);
		}
		log.debug("SubjectDAOHibImpl Find by Name Ended");
		return dto;
	}

	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.dao.SubjectDAOInt#findByPK(long)
	 */
	public SubjectDTO findByPK(long pk) {
		log.debug("SubjectDAOHibImpl Find by PK Started");
		SubjectDTO dto = null;
		dto = (SubjectDTO) sessionfactory.getCurrentSession().get(SubjectDTO.class, pk);
		log.debug("SubjectDAOHibImpl Find by PK Ended");
		return dto;
	}

	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.dao.SubjectDAOInt#search(in.co.sunrays.proj0.dto.SubjectDTO, int, int)
	 */
	public List<SubjectDTO> search(SubjectDTO dto, int pageNo, int pageSize) {
		log.debug("SubjectDAOHibImpl search Started");
		Criteria criteria = sessionfactory.getCurrentSession().createCriteria(SubjectDTO.class);
		if(dto!=null)
		{
			
		
		if (dto.getId() > 0) {
            criteria.add(Restrictions.eq("id", dto.getId()));
        }
		if (dto.getCourseId() > 0) {
            criteria.add(Restrictions.eq("courseId", dto.getCourseId()));
        }
        if (dto.getName() != null && dto.getName().length() > 0) {
            criteria.add(Restrictions.like("name", dto.getName() + "%"));
        }
        if (dto.getDescription() != null && dto.getDescription().length() > 0)
        {
            criteria.add(Restrictions.like("description", dto.getDescription() + "%"));
        }
		}
        // if page size is greater than zero the apply pagination
        if (pageSize > 0) {
            criteria.setFirstResult(((pageNo - 1) * pageSize));
            criteria.setMaxResults(pageSize);
        }
		List list = criteria.list();
		log.debug("SubjectDAOHibImpl search End");
		return list;

	}

	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.dao.SubjectDAOInt#search(in.co.sunrays.proj0.dto.SubjectDTO)
	 */
	public List<SubjectDTO> search(SubjectDTO dto) {
		// TODO Auto-generated method stub
		return search(dto,0,0);
	}

}
