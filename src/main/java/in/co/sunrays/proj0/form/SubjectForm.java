package in.co.sunrays.proj0.form;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;

import in.co.sunrays.proj0.dto.BaseDTO;
import in.co.sunrays.proj0.dto.SubjectDTO;

// TODO: Auto-generated Javadoc
/**
 * Contains Subject form elements and their declarative input validations.
 * 
 * @author Iterator
 * @version 1.0 Copyright (c) Iterator
 */
public class SubjectForm extends BaseForm{
	
	/** name of SubjectForm. */
		@NotEmpty
		private String name;
		
	/** courseId of SubjectForm. */		
		@Min(value=1,message="{Min.form.courseId}")
		private long courseId;
		
	/** courseName of SubjectForm. */
	
		private String courseName;
		
	/** description of SubjectForm. */
		@NotEmpty
		private String description;

		

		/**
		 * Gets the subject name.
		 *
		 * @return the subject name
		 */
		public String getSubjectName() {
			return name;
		}

		/**
		 * Sets the subject name.
		 *
		 * @param name the new subject name
		 */
		public void setSubjectName(String name) {
			this.name = name;
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
		 * Gets the description.
		 *
		 * @return the description
		 */
		public String getDescription() {
			return description;
		}

		/**
		 * Sets the description.
		 *
		 * @param description the new description
		 */
		public void setDescription(String description) {
			this.description = description;
		}

		/* (non-Javadoc)
		 * @see in.co.sunrays.proj0.form.BaseForm#getDto()
		 */
		@Override
		public BaseDTO getDto() {
		SubjectDTO dto=new SubjectDTO();
		dto.setId(id);
		dto.setName(name);
        dto.setCourseId(courseId);
        /*dto.setCourseName(courseName);*/
        dto.setDescription(description);
        dto.setCreatedDateTime(new Timestamp(new Date().getTime()));
        dto.setModifiedDateTime(new Timestamp(new Date().getTime()));
		
		return dto;
		}
		
		/* (non-Javadoc)
		 * @see in.co.sunrays.proj0.form.BaseForm#populate(in.co.sunrays.proj0.dto.BaseDTO)
		 */
		@Override
		public void populate(BaseDTO bDto) {
		SubjectDTO dto=(SubjectDTO) bDto;
		id=dto.getId();
		name=dto.getName();
		courseId=dto.getCourseId();
		description=dto.getDescription();
		createdBy = dto.getCreatedBy();
	    modifiedBy = dto.getModifiedBy();
	    if(dto.getCreatedDateTime()!=null)
	    createdDatetime = dto.getCreatedDateTime().getTime();
	    if(dto.getModifiedDateTime()!=null)
	    modifiedDatetime = dto.getModifiedDateTime().getTime();
		}

}

