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

import in.co.sunrays.proj0.dto.StudentDTO;
import in.co.sunrays.proj0.exception.DuplicateRecordException;
import in.co.sunrays.proj0.service.StudentServiceInt;

// TODO: Auto-generated Javadoc
/**
 * The Class StudentTest.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/main/webapp/WEB-INF/Dispatcher-servlet.xml")
public class StudentTest {

/** The service. */
@Autowired
	StudentServiceInt service;

/**
 * Adds the.
 *
 * @throws ParseException the parse exception
 */
@Test
public void  add() throws ParseException{
	StudentDTO dto=new StudentDTO();
	dto.setFirstName("Sunil");
	dto.setLastName("Sahu");
	dto.setCollegeId(2l);
	dto.setGender("M");
	dto.setMobileNo("8635986567");
	dto.setDob(new SimpleDateFormat("dd/MM/yyyy").parse("03/01/1990"));
	dto.setEmail("sunil007@gmail.com");
	dto.setCreatedBy("root");
	dto.setModifiedBy("root");
	dto.setCreatedDateTime(new Timestamp(System.currentTimeMillis()));
	dto.setModifiedDateTime(dto.getCreatedDateTime());
	try {
		long pk=service.add(dto);
		System.out.println("Add Success="+pk);
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
public void  update() throws ParseException{
	
	StudentDTO dto=new StudentDTO();
	dto.setFirstName("Ram");
	dto.setId(2);
	dto.setLastName("Kapoor");
	dto.setCollegeId(1l);
	dto.setGender("M");
	dto.setMobileNo("8635986535");
	dto.setDob(new SimpleDateFormat("dd/MM/yyyy").parse("06/06/1995"));
	dto.setEmail("raj123@gmail.com");
	dto.setCreatedBy("root");
	dto.setModifiedBy("root");
	dto.setCreatedDateTime(new Timestamp(System.currentTimeMillis()));
	dto.setModifiedDateTime(dto.getCreatedDateTime());
try {
	service.update(dto);
	System.out.println("Update Success");
} catch (DuplicateRecordException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

}

/**
 * Delete.
 */
@Ignore
public void  delete(){
	service.delete(1);
	System.out.println("Delete Success");
}

/**
 * Find by pk.
 */
@Ignore
public void  findByPk(){
	StudentDTO dto=	service.findById(1);
System.out.println("find by pk Success "+dto.getFirstName());
}

/**
 * Find by email.
 */
@Ignore
public void  findByEmail(){
	
	StudentDTO dto=service.findByEmail("raj@gmail.com");
System.out.println("Find by Email Success "+dto.getFirstName());
}

/**
 * Search pagination.
 */
@Ignore
public void  searchPagination(){
	StudentDTO dto=new StudentDTO();
	//dto.setId(1);
	dto.setCollegeId(1l);
	//dto.setFirstName("raj");
	//dto.setLastName("Kumar");
	
List<StudentDTO> list=	service.search(dto, 1, 10);
System.out.println("Search pagination success "+list.size());
	
}

/**
 * Search.
 */
@Ignore
public void  search(){
	StudentDTO dto=new StudentDTO();
	
List<StudentDTO> list=	service.search(dto);
System.out.println("Search  success "+list.size());
}

}
