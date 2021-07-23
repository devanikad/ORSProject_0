package in.co.sunrays.proj0.form;


import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;

import in.co.sunrays.proj0.dto.BaseDTO;
import in.co.sunrays.proj0.dto.TimeTableDTO;
import in.co.sunrays.proj0.util.Util;

// TODO: Auto-generated Javadoc
/**
 * Contains TimeTable form elements and their declarative input validations.
 * 
 * @author Iterator
 * @version 1.0 Copyright (c) Iterator
 * 
 */
public class TimeTableForm extends BaseForm{
	
	/** Subject of Time-Table. */
	@Min(value=1,message="{Min.form.subjectId}")
	private long subjectId;
	
	/** Subject Name of Time-Table. */
	
	private String subjectName;
	
	/** courseId of Time-Table. */
	@Min(value=1)
	private long courseId;
	
	/** Course Name of Time-Table. */
	
	private String courseName;
	
	/** Exam Date of Time-Table. */
	@NotEmpty
	private String examDate;
	
	/** Exam Time of Time-Table. */
	@NotEmpty
	private String examTime;
	
	/** semester of Time-Table. */
	@NotEmpty
	private String semester;
	
	/**
	 * description of Time-Table.
	 *
	 * @return the semester
	 */



	

	public String getSemester() {
		return semester;
	}
	
	/**
	 * Sets the semester.
	 *
	 * @param semester the new semester
	 */
	public void setSemester(String semester) {
		this.semester = semester;
	}
	
	
	/**
	 * Gets the subject id.
	 *
	 * @return the subject id
	 */
	public long getSubjectId() {
		return subjectId;
	}
	
	/**
	 * Sets the subject id.
	 *
	 * @param subjectId the new subject id
	 */
	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}
	
	/**
	 * Gets the subject name.
	 *
	 * @return the subject name
	 */
	public String getSubjectName() {
		return subjectName;
	}
	
	/**
	 * Sets the subject name.
	 *
	 * @param subjectName the new subject name
	 */
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	
	/**
	 * Gets the course id.
	 *
	 * @return the course id
	 */
	public long getCourseId() {
		return courseId;
	}
	
	/**
	 * Sets the course id.
	 *
	 * @param courseId the new course id
	 */
	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}
	
	/**
	 * Gets the course name.
	 *
	 * @return the course name
	 */
	public String getCourseName() {
		return courseName;
	}
	
	/**
	 * Sets the course name.
	 *
	 * @param courseName the new course name
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	/**
	 * Gets the exam date.
	 *
	 * @return the exam date
	 */
	public String getExamDate() {
		return examDate;
	}
	
	/**
	 * Sets the exam date.
	 *
	 * @param examDate the new exam date
	 */
	public void setExamDate(String examDate) {
		this.examDate = examDate;
	}
	
	/**
	 * Gets the exam time.
	 *
	 * @return the exam time
	 */
	public String getExamTime() {
		return examTime;
	}
	
	/**
	 * Sets the exam time.
	 *
	 * @param examTime the new exam time
	 */
	public void setExamTime(String examTime) {
		this.examTime = examTime;
	}
	
/* (non-Javadoc)
 * @see in.co.sunrays.proj0.form.BaseForm#getDto()
 */
@Override
	public BaseDTO getDto() {
		TimeTableDTO dto=new TimeTableDTO();
		dto.setId(id);
		dto.setCourseId(courseId);
        dto.setCourseName(courseName);
        dto.setSubjectId(subjectId);
        dto.setSubjectName(subjectName);
        System.out.println("ExamDate== "+examDate);
		   if(examDate!=""){
			   dto.setExamDate(Util.getDate(examDate));
			   System.out.println("OLLLLLLL"+Util.getDate(examDate));
			   System.out.println("Ezeeee==="+dto.getExamDate());
		      }
		   
		dto.setSemester(semester);
		//dto.setDescription(description);
		dto.setExamTime(examTime);
		dto.setCreatedBy(createdBy);
	    dto.setModifiedBy(modifiedBy);
	   		return dto;
	}



/* (non-Javadoc)
 * @see in.co.sunrays.proj0.form.BaseForm#populate(in.co.sunrays.proj0.dto.BaseDTO)
 */
@Override
public void populate(BaseDTO bDto) {

	TimeTableDTO dto=(TimeTableDTO) bDto;
	id=dto.getId();
	courseId=dto.getCourseId();
	courseName=dto.getCourseName();
	subjectId=dto.getSubjectId();
	subjectName=dto.getSubjectName();
	examTime=dto.getExamTime();
	System.out.println("populate exam time--->"+dto.getExamTime());
	examDate=Util.getDate(dto.getExamDate()); 
	semester=dto.getSemester();
	System.out.println("populate semester--->"+dto.getSemester());
	//description=dto.getDescription();
	//System.out.println("populate description--->"+dto.getDescription());
	createdBy=dto.getCreatedBy();
   	modifiedBy=dto.getModifiedBy();
	  if (dto.getCreatedDateTime() != null) {
          createdDatetime = dto.getCreatedDateTime().getTime();
      }
      if (dto.getModifiedDateTime() != null) {
          modifiedDatetime = dto.getModifiedDateTime().getTime();
      }
	
}

}


