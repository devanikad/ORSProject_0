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

import in.co.sunrays.proj0.dto.MarksheetDTO;
import in.co.sunrays.proj0.dto.StudentDTO;
import in.co.sunrays.proj0.exception.DuplicateRecordException;
import in.co.sunrays.proj0.service.MarksheetServiceInt;

// TODO: Auto-generated Javadoc
/**
 * The Class MarksheetTest.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/main/webapp/WEB-INF/Dispatcher-servlet.xml")
public class MarksheetTest {
	
	/** The service. */
	@Autowired
MarksheetServiceInt service;
	
	/**
	 * Adds the.
	 */
	@Ignore
public void add(){
	MarksheetDTO dto=new MarksheetDTO();
	dto.setRollNo("0701EE091002");
	dto.setStudentId(2l);
	dto.setPhysics("88");
	dto.setChemistry("89");
	dto.setMaths("86");
	dto.setCreatedBy("root");
	dto.setModifiedBy(dto.getCreatedBy());
	dto.setCreatedDateTime(new Timestamp(System.currentTimeMillis()));
	dto.setModifiedDateTime(new Timestamp(System.currentTimeMillis()));
	
	try {
		long pk=service.add(dto);
		System.out.println("Add======"+pk);
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
	@Test
	public void  update() throws ParseException{
		
		MarksheetDTO dto=new MarksheetDTO();
		dto.setRollNo("0701EE091002");
		dto.setId(2);
		dto.setStudentId(2l);
		dto.setPhysics("70");
		dto.setChemistry("90");
		dto.setMaths("60");
		dto.setCreatedBy("root");
		dto.setModifiedBy(dto.getCreatedBy());
		dto.setModifiedDateTime(new Timestamp(System.currentTimeMillis()));
		dto.setModifiedDateTime(new Timestamp(System.currentTimeMillis()));
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
		service.delete(2l);
		System.out.println("Delete Success");
	}
	
	/**
	 * Find by pk.
	 */
	@Ignore
	public void  findByPk(){
		MarksheetDTO dto=	service.findById(1l);
	System.out.println("find by pk Success "+dto.getRollNo());
	}
	
	/**
	 * Find by roll no.
	 */
	@Ignore
	public void  findByRollNo(){
		
		MarksheetDTO dto=service.findByRollNumber("0701EE091001");
	System.out.println("Find by Email Success "+dto.getName());
	}
	

/**
 * Search pagination.
 */
@Ignore
public void  searchPagination(){
	MarksheetDTO dto=new MarksheetDTO();
	//dto.setId(1);
	
	//dto.setFirstName("raj");
	//dto.setLastName("Kumar");
	
List<MarksheetDTO> list=	service.search(dto, 1, 5);
System.out.println("Search pagination success "+list.size());
	
}
	
/**
 * Search.
 */
@Ignore
public void  search(){
	MarksheetDTO dto=new MarksheetDTO();
	
List<MarksheetDTO> list=	service.search(dto);
System.out.println("Search  success "+list.size());
}
	
	
}
