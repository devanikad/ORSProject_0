package in.co.sunrays.proj0.Test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import in.co.sunrays.proj0.dto.RoleDTO;
import in.co.sunrays.proj0.dto.UserDTO;
import in.co.sunrays.proj0.exception.DuplicateRecordException;
import in.co.sunrays.proj0.service.RoleServiceInt;
import in.co.sunrays.proj0.service.UserServiceInt;

// TODO: Auto-generated Javadoc
/**
 * The Class UserTest.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/main/webapp/WEB-INF/Dispatcher-servlet.xml")
public class UserTest {
	
	/** The role service. */
	@Autowired
	RoleServiceInt roleService;
	
	/** The user service. */
	@Autowired
	UserServiceInt userService;
	
	/**
	 * Adds the.
	 *
	 * @throws ParseException the parse exception
	 */
	@Test
	public void add() throws ParseException{
		UserDTO dto=new UserDTO();
		dto.setFirstName("Monica");
		dto.setLastName("Soni");
		dto.setEmailId("monica110292@gmail.com");
		dto.setGender("Male");
		dto.setDob(new SimpleDateFormat("dd/MM/yyyy").parse("11/02/1992"));
		dto.setPassword("Pass@1234");
		dto.setConfirmPassword("Pass@1234");
		dto.setRoleId(2l);
		dto.setCreatedBy("root");
		dto.setMobileNo("9907001732");
		dto.setModifiedBy("root");
		dto.setCreatedDateTime(new Timestamp(System.currentTimeMillis()));
		dto.setModifiedDateTime(new Timestamp(System.currentTimeMillis()));
		
		
		RoleDTO rdto=roleService.findById(dto.getRoleId());
		dto.setRoleName(rdto.getName());
		try {
		long pk=userService.add(dto);
		System.out.println("User Add Sucess ID="+pk);
		} catch (DuplicateRecordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Update.
	 *
	 * @throws ParseException the parse exception
	 */
	@Ignore
	public void update() throws ParseException{
		UserDTO dto=new UserDTO();
	dto.setId(1);
		dto.setFirstName("Sourabh");
		dto.setLastName("Gupta");
		dto.setEmailId("sourabh1391@gmail.com");
		dto.setGender("M");
		dto.setDob(new SimpleDateFormat("dd/MM/yyyy").parse("13/11/1991"));
		dto.setPassword("Pass@1234");
		dto.setConfirmPassword("Pass@1234");
		dto.setCreatedBy("root");
		dto.setMobileNo("9926726877");
		dto.setModifiedBy("root");
		dto.setCreatedDateTime(new Timestamp(System.currentTimeMillis()));
		dto.setModifiedDateTime(new Timestamp(System.currentTimeMillis()));
		dto.setRoleId(1);
		
		RoleDTO rdto=roleService.findById(dto.getRoleId());
		dto.setRoleName(rdto.getName());
		try {
			userService.update(dto);
		
			System.out.println("User Update Success");
		} catch (DuplicateRecordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Find by pk.
	 */
	@Ignore
public void findByPk(){
UserDTO dto=userService.findByPK(1);
System.out.println("User FindBy Pk Success="+dto.getFirstName());
}

/**
 * Find by email.
 */
@Ignore
public void findByEmail(){
	UserDTO dto=userService.findByLogin("sourabh1391@gmail.com");
	
	System.out.println("User Find by Login Success="+dto.getFirstName());
}

/**
 * Search.
 */
@Ignore
public void search(){
	UserDTO dto=new UserDTO();
	dto.setId(1);
List l=userService.search(dto);	
/*System.out.println("User Search Success="+l.size()); 
*/
System.out.println("User Search Success="+l.size());

}

/**
 * Search pagination.
 */
@Ignore
public void searchPagination(){
	UserDTO dto=new UserDTO();
	//dto.setId(1);
	//dto.setFirstName("n");
	//dto.setLastName("k");
List l=userService.search(dto,0,0);	
System.out.println("User Search Paginaion Success="+l.size());
}

/**
 * Delete.
 */
@Ignore
public void delete(){
	userService.delete(1);
	System.out.println("User Delete success");
}
}
