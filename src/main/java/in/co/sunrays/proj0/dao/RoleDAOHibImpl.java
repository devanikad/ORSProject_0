package in.co.sunrays.proj0.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.co.sunrays.proj0.dto.RoleDTO;
// TODO: Auto-generated Javadoc
/**
 * The Class RoleDAOHibImpl.
 */
@Repository(value="roleDao")
public class RoleDAOHibImpl implements RoleDAOInt{

	/** The sessionfactory. */
	@Autowired
	private	SessionFactory sessionfactory = null;
	
	/** The log. */
	private static Logger log = Logger.getLogger(RoleDAOHibImpl.class);
	
	/* (non-Javadoc)
	 * @see in.co.sunrays.project0.dao.RoleDAOInt#add(in.co.sunrays.project0.dto.RoleDTO)
	 */
	public long add(RoleDTO dto) {
		log.debug("RoleDAOHibImpl Add Started");
		System.out.println(">>>>>>>>>>>>>>>>>>>in role dao");
		long pk = (Long) sessionfactory.getCurrentSession().save(dto);
		log.debug("RoleDAOHibImpl Add End");
		System.out.println(">>>>>>>>>>>>>>>>>>>in role dao");
		return pk;
	}

	/* (non-Javadoc)
	 * @see in.co.sunrays.project0.dao.RoleDAOInt#update(in.co.sunrays.project0.dto.RoleDTO)
	 */
	public void update(RoleDTO dto) {
		log.debug("RoleDAOHibImpl Update Started");
		sessionfactory.getCurrentSession().update(dto);
		log.debug("RoleDAOHibImpl Update End");


	}

	/* (non-Javadoc)
	 * @see in.co.sunrays.project0.dao.RoleDAOInt#delete(long)
	 */
	public void delete(long id) {
		log.debug("RoleDAOHibImpl Delete Started");
		RoleDTO dto = findByPK(id);
		sessionfactory.getCurrentSession().delete(dto);
		log.debug("RoleDAOHibImpl Delete End");

	}

	/* (non-Javadoc)
	 * @see in.co.sunrays.project0.dao.RoleDAOInt#findByName(java.lang.String)
	 */
	public RoleDTO findByName(String roleName) {
		log.debug("RoleDAOHibImpl Find by Name Started");
		RoleDTO dto = null;
		List list = sessionfactory.getCurrentSession().createCriteria(RoleDTO.class).add(Restrictions.eq("name", roleName)).list();
		if (list.size() == 1) {
			dto = (RoleDTO) list.get(0);
		}
		log.debug("RoleDAOHibImpl Find by Name Ended");
		return dto;

	}

	/* (non-Javadoc)
	 * @see in.co.sunrays.project0.dao.RoleDAOInt#findByPK(long)
	 */
	public RoleDTO findByPK(long pk) {
		log.debug("RoleDAOHibImpl Find by PK Started");
		RoleDTO dto = null;
		dto = (RoleDTO) sessionfactory.getCurrentSession().get(RoleDTO.class, pk);
		log.debug("RoleDAOHibImpl Find by PK Ended");
		return dto;

	}

	/* (non-Javadoc)
	 * @see in.co.sunrays.project0.dao.RoleDAOInt#search(in.co.sunrays.project0.dto.RoleDTO, int, int)
	 */
	public List<RoleDTO> search(RoleDTO dto, int pageNo, int pageSize) {
		log.debug("RoleDAOHibImpl search Started");
		Criteria criteria = sessionfactory.getCurrentSession().createCriteria(RoleDTO.class);
		if(dto!=null)
		{
			
		
		if (dto.getId() > 0) {
            criteria.add(Restrictions.eq("id", dto.getId()));
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
		log.debug("RoleDAOHibImpl search End");
		return list;


	}

	/* (non-Javadoc)
	 * @see in.co.sunrays.project0.dao.RoleDAOInt#search(in.co.sunrays.project0.dto.RoleDTO)
	 */
	public List<RoleDTO> search(RoleDTO dto) {
		return search(dto, 0, 0);
	}
}
