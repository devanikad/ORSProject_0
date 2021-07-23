package in.co.sunrays.proj0.form;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import in.co.sunrays.proj0.dto.BaseDTO;
import in.co.sunrays.proj0.dto.FacultyDTO;
import in.co.sunrays.proj0.util.Util;

// TODO: Auto-generated Javadoc
/**
 * Contains Faculty form elements and their declarative input validations.
 * 
 * @author Iterator
 * @version 1.0 Copyright (c) Iterator
 */
public class FacultyForm extends BaseForm{
	
	/** Id OF Subject. */
	@Min(value=1,message="{Min.form.subjectId}")
	private long subjectId;
	

	/** Id OF FacultyCourse. */
	@Min(value=1,message="{Min.form.courseId}")
	private long courseId;
	
	/** Id OF College. */
	@Min(value=1,message="{Min.form.collegeId}")
	private long collegeId;
	
	/** SubjectName OF Faculty. */
	private String subjectName;
	
	/** CourseName Of Faculty. */
	
	private String courseName;
	
	/** Name Of College. */
	
	private String collegeName;
	
	/** Name Of Faculty First Name. */
	@NotEmpty
	private String firstName;
	
	/** Name Of Faculty Last Name. */
	@NotEmpty
	private String lastName;
	
	/** DOB Of Faculty. */
	@NotEmpty
	private String dob;
	
	/** MobileNo Of Faculty. */
	 @NotEmpty
	 @Pattern(regexp = "\\d{10}", message = "{Pattern.form.phoneNo}")   
	private String mobileNo;
	
	/** EmailId Of Faculty. */
	 @Email
	 @NotEmpty
	private String emailId;
	
	/** Gender Of Faculty. */
	@NotEmpty
	private String gender;
	
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
	 * Gets the college id.
	 *
	 * @return the college id
	 */
	public long getCollegeId() {
		return collegeId;
	}
	
	/**
	 * Sets the college id.
	 *
	 * @param collegeId the new college id
	 */
	public void setCollegeId(long collegeId) {
		this.collegeId = collegeId;
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
	 * Gets the college name.
	 *
	 * @return the college name
	 */
	public String getCollegeName() {
		return collegeName;
	}
	
	/**
	 * Sets the college name.
	 *
	 * @param collegeName the new college name
	 */
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	
	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * Gets the dob.
	 *
	 * @return the dob
	 */
	public String getDob() {
		return dob;
	}
	
	/**
	 * Sets the dob.
	 *
	 * @param dob the new dob
	 */
	public void setDob(String dob) {
		this.dob = dob;
	}
	
	/**
	 * Gets the mobile no.
	 *
	 * @return the mobile no
	 */
	public String getMobileNo() {
		return mobileNo;
	}
	
	/**
	 * Sets the mobile no.
	 *
	 * @param mobileNo the new mobile no
	 */
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	/**
	 * Gets the email id.
	 *
	 * @return the email id
	 */
	public String getEmailId() {
		return emailId;
	}
	
	/**
	 * Sets the email id.
	 *
	 * @param emailId the new email id
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	/**
	 * Gets the gender.
	 *
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	
	/**
	 * Sets the gender.
	 *
	 * @param gender the new gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.form.BaseForm#populate(in.co.sunrays.proj0.dto.BaseDTO)
	 */
	@Override
	public void populate(BaseDTO bDto) {
		FacultyDTO dto=(FacultyDTO) bDto;
		id=dto.getId();
		collegeId=dto.getCollegeId();
		collegeName=dto.getCollegeName();
		System.out.println("inside populate ------> "+collegeName);
		courseId=dto.getCourseId();
		courseName=dto.getCourseName();
		System.out.println("inside populate ------> "+courseName);
		subjectId=dto.getSubjectId();
		subjectName=dto.getSubjectName();
		emailId=dto.getEmailId();
		firstName=dto.getFirstName();
		lastName=dto.getLastName();
		gender=dto.getGender();
		mobileNo=dto.getMobileNo();
		dob=Util.getDate(dto.getDob());
	    createdBy = dto.getCreatedBy();
	    modifiedBy = dto.getModifiedBy();
	        if (dto.getCreatedDateTime() != null) {
	            createdDatetime = dto.getCreatedDateTime().getTime();
	        }
	        if (dto.getModifiedDateTime() != null) {
	            modifiedDatetime = dto.getModifiedDateTime().getTime();
	        }
		
		
	}

	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.form.BaseForm#getDto()
	 */
	@Override
	public BaseDTO getDto() {
	FacultyDTO dto=new FacultyDTO();
	dto.setId(id);
	dto.setCollegeId(collegeId);
	dto.setCollegeName(collegeName);
	dto.setCourseId(courseId);
	dto.setCourseName(courseName);
	dto.setSubjectId(subjectId);
	dto.setSubjectName(subjectName);
	
	   if(dob!=""){
	        dto.setDob(Util.getDate(dob));
	        }
	dto.setEmailId(emailId);
	
	dto.setFirstName(firstName);
	dto.setLastName(lastName);
	dto.setGender(gender);
	dto.setMobileNo(mobileNo);
	   dto.setCreatedBy(createdBy);
       dto.setModifiedBy(modifiedBy);
       dto.setCreatedDateTime(new Timestamp(new Date().getTime()));
       dto.setModifiedDateTime(new Timestamp(new Date().getTime()));
	
		return dto;
	}

}
