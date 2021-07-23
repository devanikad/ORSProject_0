

package in.co.sunrays.proj0.Test;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import java.util.List;

import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import in.co.sunrays.proj0.dto.SubjectDTO;
import in.co.sunrays.proj0.dto.TimeTableDTO;
import in.co.sunrays.proj0.exception.DuplicateRecordException;
import in.co.sunrays.proj0.service.TimeTableServiceInt;

// TODO: Auto-generated Javadoc
/**
 * The Class TimeTableTest.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/main/webapp/WEB-INF/Dispatcher-servlet.xml")
public class TimeTableTest {
	
	/** The service. */
	@Autowired
TimeTableServiceInt service;
	
	/**
	 * Adds the.
	 *
	 * @throws ParseException the parse exception
	 */
	@Ignore
	public void add() throws ParseException{
		TimeTableDTO dto=new TimeTableDTO();
		dto.setCourseId(2l);
		dto.setSubjectId(2l);
		dto.setSemester("II");
		dto.setExamTime("10am to 1pm");
		dto.setExamDate(new  SimpleDateFormat("dd/MM/yyyy").parse("01/08/2020"));
		dto.setCreatedBy("root");
		dto.setModifiedBy("root");
		dto.setCreatedDateTime(new Timestamp(System.currentTimeMillis()));
		dto.setModifiedDateTime(new Timestamp(System.currentTimeMillis()));
		try {
			service.add(dto);
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
		TimeTableDTO dto=new TimeTableDTO();
		dto.setId(1);
		dto.setCourseId(1l);
		dto.setSubjectId(1l);
		dto.setSemester("III");
		dto.setExamTime("12pm to 3pm");
		dto.setExamDate(new SimpleDateFormat("dd/MM/yyyy").parse("05/08/2020"));
		dto.setCreatedBy("root");
		dto.setModifiedBy("root");
		dto.setCreatedDateTime(new Timestamp(System.currentTimeMillis()));
		dto.setModifiedDateTime(new Timestamp(System.currentTimeMillis()));
		
			try {
				service.update(dto);
				System.out.println("Update successs===========");
			} catch (DuplicateRecordException e) {
				System.out.println("Update "+e.getMessage());
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}
	
	/**
	 * Delete.
	 */
	@Ignore
	public void delete(){
		service.delete(2l);
		System.out.println("=========Timetable Delete Success======");

		
	}

/**
 * Find by pk.
 */
@Ignore
	public void findByPk(){
		TimeTableDTO dto=service.findByPk(1l);
		System.out.println("=======Subject findByPk success===="+dto.getExamTime() );
	}
	
/**
 * Search.
 */
@Ignore
	public void search(){
		TimeTableDTO dto=new TimeTableDTO();
		List<TimeTableDTO> l=service.search(dto);
		System.out.println("==========Subject search success====="+l.size());
	}
	
	/**
	 * Search page.
	 */
	@Test
	public void searchPage(){
		TimeTableDTO dto=new TimeTableDTO();
		//dto.setId(1);
	//dto.setCourseId(1);
		//dto.setName("cse");
		List<TimeTableDTO> l=service.search(dto,0,0);
		
	System.out.println("==========Subject searchPagination success====="+l.size());
	}

	
	
	
	
}
