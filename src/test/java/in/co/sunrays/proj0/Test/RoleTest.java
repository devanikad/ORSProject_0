package in.co.sunrays.proj0.Test;

import java.sql.Timestamp;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import in.co.sunrays.proj0.dto.RoleDTO;
import in.co.sunrays.proj0.exception.DuplicateRecordException;
import in.co.sunrays.proj0.service.RoleServiceInt;

// TODO: Auto-generated Javadoc
/**
 * The Class RoleTest.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/main/webapp/WEB-INF/Dispatcher-servlet.xml")
public class RoleTest {

	/** The role service impl. */
	@Autowired
	RoleServiceInt roleServiceImpl;
	
	/**
	 * Adds the.
	 */
	@Ignore
	public void add() {
		RoleDTO dto = new RoleDTO();
		dto.setName("KiosK");
		dto.setDescription("Kiosk");
		dto.setCreatedBy("root");
		dto.setModifiedBy("root");
		dto.setCreatedDateTime(new Timestamp(System.currentTimeMillis()));
		dto.setModifiedDateTime(new Timestamp(System.currentTimeMillis()));

		try {
			long pk = roleServiceImpl.add(dto);
			System.out.println(pk);
		} catch (DuplicateRecordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	/**
	 * Update.
	 */
	@Ignore
	public void update() {
		RoleDTO dto = new RoleDTO();
		dto.setId(5);
		dto.setName("KiosK");
		dto.setDescription("KiosK");
		dto.setCreatedBy("root");
		dto.setModifiedBy("root");
		dto.setCreatedDateTime(new Timestamp(System.currentTimeMillis()));
		dto.setModifiedDateTime(new Timestamp(System.currentTimeMillis()));
		System.out.println("Role Update Success");
		try {
			roleServiceImpl.update(dto);
		} catch (DuplicateRecordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Find by pk.
	 */
	@Ignore
	public void findByPk() {
		RoleDTO dto = roleServiceImpl.findById(1);
		System.out.println("Role find By Id Success" + dto.getName());
	}

	/**
	 * Find by name.
	 */
	@Ignore
	public void findByName() {
		RoleDTO dto = roleServiceImpl.findByName("Admin");
		System.out.println("Role Find by name success" + dto.getId());
	}

	/**
	 * Search.
	 */
	@Ignore
	public void search() {
		RoleDTO dto = new RoleDTO();
		List list = roleServiceImpl.search(dto);
		System.out.println("Role Search(RoleDTO) =" + list.size());
	}

	/**
	 * Search pagination.
	 */
	@Ignore
	public void searchPagination() {
		RoleDTO dto = new RoleDTO();
		// dto.setId(1);
		//dto.setName("Admin");
		List list = roleServiceImpl.search(dto, 0, 0);
		System.out.println("Role Search(RoleDTO,pageNo,pageSize) =" + list.size());
	}

	/**
	 * Delete.
	 */
	@Test
	public void delete() {
		roleServiceImpl.delete(5);
		System.out.println("Role Delete Success");
	}


		
		
		
		
		
	}
	
	
	

