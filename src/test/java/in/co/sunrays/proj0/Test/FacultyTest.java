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

import in.co.sunrays.proj0.dto.FacultyDTO;
import in.co.sunrays.proj0.dto.SubjectDTO;
import in.co.sunrays.proj0.exception.DuplicateRecordException;
import in.co.sunrays.proj0.service.FacultyServiceInt;

// TODO: Auto-generated Javadoc
/**
 * The Class FacultyTest.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/main/webapp/WEB-INF/Dispatcher-servlet.xml")
public class FacultyTest {
	
	/** The service. */
	@Autowired
	FacultyServiceInt service;
	
	/**
	 * Adds the.
	 *
	 * @throws ParseException the parse exception
	 */
	@Ignore
public void add() throws ParseException{
	FacultyDTO dto=new FacultyDTO();
		
		 dto.setCollegeId(2l);
		 dto.setSubjectId(2l);
		 dto.setCourseId(2l);
		  dto.setFirstName("shanu");
		  dto.setLastName("Singh");
		  dto.setEmailId("shanu321@gmail.com");
		  dto.setGender("M"); 
		  dto.setDob(new
		  SimpleDateFormat("dd/MM/yyyy").parse("11/09/1990"));
		  dto.setMobileNo("8968986934");
		  dto.setCreatedBy("root"); dto.setModifiedBy("root");
		  dto.setCreatedDateTime(new Timestamp(System.currentTimeMillis()));
		  dto.setModifiedDateTime(new Timestamp(System.currentTimeMillis()));
		  try {
			  service.add(dto);
			  }
		  catch (DuplicateRecordException e)
		  {
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
		FacultyDTO dto=new FacultyDTO();
		dto.setId(2);
		dto.setCollegeId(2l);
		dto.setSubjectId(2l);
		dto.setCourseId(2l);
		dto.setFirstName("Manish");
		dto.setLastName("Singh");
		dto.setEmailId("manish30002@gmail.com");
		dto.setGender("M");
		dto.setDob(new SimpleDateFormat("dd/MM/yyyy").parse("09/08/1999"));
		
		  dto.setMobileNo("8968986336"); 
		 dto.setCreatedBy("root");
		dto.setModifiedBy("root");
		dto.setCreatedDateTime(new Timestamp(System.currentTimeMillis()));
		dto.setModifiedDateTime(new Timestamp(System.currentTimeMillis()));
try {
	service.update(dto);
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
	FacultyDTO dto= service.findByPK(1);
System.out.println("find By Pk==="+dto.getCollegeName());
}	
	
	/**
	 * Find by email.
	 */
	@Ignore
public void findByEmail(){
	FacultyDTO dto= service.findByEmail("sonishri@gmail.com");
			System.out.println("find By email==="+dto.getFirstName());
}

/**
 * Delete.
 */
@Ignore
public void delete(){
	service.delete(1l);
	System.out.println("delete success");
}

/**
 * Search.
 */
@Ignore
public void search(){
	FacultyDTO dto=new FacultyDTO();
	List<FacultyDTO> l=service.search(dto);
	System.out.println("==========Subject search success====="+l.size());
}

/**
 * Search page.
 */
@Test
public void searchPage(){
	FacultyDTO dto=new FacultyDTO();
	//dto.setId(1);
dto.setCourseId(1);
	//dto.setName("cse");
	List<FacultyDTO> l=service.search(dto,1,10);
	
System.out.println("==========Subject searchPagination success====="+l.size());
}



}
