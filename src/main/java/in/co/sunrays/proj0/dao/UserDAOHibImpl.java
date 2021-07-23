package in.co.sunrays.proj0.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import in.co.sunrays.proj0.dto.UserDTO;

// TODO: Auto-generated Javadoc
/**
 * User Data Access Object provides Database CRUD operations. It is implemented
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

@Repository(value = "userDao")
public class UserDAOHibImpl implements UserDAOInt{
	
	/** The sessionfactory. */
	@Autowired
	private SessionFactory sessionfactory = null;
	
	/** The log. */
	private static Logger log = Logger.getLogger(UserDAOHibImpl.class);

	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.dao.UserDAOInt#add(in.co.sunrays.proj0.dto.UserDTO)
	 */
	public long add(UserDTO dto) throws DataAccessException {
		log.debug("User Dao Add Started");
		long pk = 0;
		pk = (Long) sessionfactory.getCurrentSession().save(dto);
		log.debug("User Dao Add End");
		return pk;
	}

	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.dao.UserDAOInt#update(in.co.sunrays.proj0.dto.UserDTO)
	 */
	public void update(UserDTO dto) throws DataAccessException {
		log.debug("User Dao Update Started");
		sessionfactory.getCurrentSession().update(dto);
		log.debug("User Dao Update End");
		
	}

	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.dao.UserDAOInt#delete(long)
	 */
	public void delete(long id) throws DataAccessException {
		log.debug("User Dao Delete Started");
		UserDTO dto = findByPK(id);
		sessionfactory.getCurrentSession().delete(dto);
		log.debug("User Dao Delete End");
		
	}

	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.dao.UserDAOInt#findByLogin(java.lang.String)
	 */
	public UserDTO findByLogin(String login) throws DataAccessException {
		log.debug("User Dao FindByLogin Started");
		UserDTO dto = null;
		List list = sessionfactory.getCurrentSession().createCriteria(UserDTO.class)
				.add(Restrictions.eq("emailId", login)).list();
		if (list.size() == 1) {
			dto = (UserDTO) list.get(0);
		}
		log.debug("User Dao FindByLogin End");
		return dto;
	}

	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.dao.UserDAOInt#findByPK(long)
	 */
	public UserDTO findByPK(long pk) throws DataAccessException {
		log.debug("User Dao FindById Started");
		UserDTO dto = null;
		dto = (UserDTO) sessionfactory.getCurrentSession().get(UserDTO.class, pk);
		log.debug("User Dao FindById End");
		return dto;
	}

	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.dao.UserDAOInt#search(in.co.sunrays.proj0.dto.UserDTO, int, int)
	 */
	public List search(UserDTO dto, int pageNo, int pageSize) throws DataAccessException {
		log.debug("User Dao Search Started");
		List list = null;
		Criteria criteria = sessionfactory.getCurrentSession().createCriteria(UserDTO.class);
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
			if (dto.getPassword() != null && dto.getPassword().length() > 0) {
				criteria.add(Restrictions.like("password", dto.getPassword() + "%"));
			}
			if (dto.getGender() != null && dto.getGender().length() > 0) {
				criteria.add(Restrictions.like("gender", dto.getGender() + "%"));
			}
			if (dto.getDob() != null && dto.getDob().getDate() > 0) {
				criteria.add(Restrictions.eq("dob", dto.getDob()));
			}

			if (dto.getRoleId() > 0) {
				criteria.add(Restrictions.eq("roleId", dto.getRoleId()));
			}
			if (dto.getRoleName() != null && dto.getRoleName().length() > 0) {
				criteria.add(Restrictions.like("roleName", dto.getRoleName() + "%"));
			}

			if (dto.getMobileNo() != null && dto.getMobileNo().length() > 0) {
  			criteria.add(Restrictions.eq("mobileNo", dto.getMobileNo()));
			}

		}

		// if page size is greater than zero the apply pagination
		if (pageSize > 0) {
			criteria.setFirstResult((pageNo - 1) * pageSize);
			criteria.setMaxResults(pageSize);
		}

		list = criteria.list();
		log.debug("User Dao Search End");
		return list;

	}

	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.dao.UserDAOInt#search(in.co.sunrays.proj0.dto.UserDTO)
	 */
	public List search(UserDTO dto) throws DataAccessException {
		// TODO Auto-generated method stub
		return search(dto,0,0);
	}

}
