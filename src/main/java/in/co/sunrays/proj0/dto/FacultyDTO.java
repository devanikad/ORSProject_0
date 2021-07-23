package in.co.sunrays.proj0.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
// TODO: Auto-generated Javadoc

/**
 * The Class FacultyDTO.
 */
@Entity
@Table(name="ST_FACULTY")
public class FacultyDTO extends BaseDTO {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** college id. */
	
	@Column(name="COLLEGE_ID")
	private long collegeId;
	
	/** college name. */
	@Column(name="COLLEGE_NAME")
	private String collegeName;
	
	/** course id. */
	@Column(name="COURSE_ID")
	private long courseId;
	
	/** course name. */
	@Column(name="COURSE_NAME")
	private String courseName;
	
	/** subject id. */
	@Column(name="SUBJECT_ID")
	private long subjectId;
	
	/** subject name. */
	@Column(name="SUBJECT_NAME")
	private String subjectName;
	
	/** faculty first name. */
	@Column(name="FIRST_NAME",length=255)
	private String firstName;
	
	/** faculty last name. */
	@Column(name="LAST_NAME")
	private String lastName;
	
	/** gender. */
	@Column(name="GENDER")
	private String Gender;	
	
	/** date of birth. */
	@Column(name="DOB")
	private Date dob;
	
	/** mobile number. */
	@Column(name="MOBILE_NUMBER")
	private String mobileNo;

	/** faulty email id. */
	@Column(name="EMAIL_ID",length=255)
	private String emailId;

	

	
	

	/**
	 * accessors.
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
	 * Gets the dob.
	 *
	 * @return the dob
	 */
	public Date getDob() {
		return dob;
	}

	/**
	 * Sets the dob.
	 *
	 * @param dob the new dob
	 */
	public void setDob(Date dob) {
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
	 * Gets the gender.
	 *
	 * @return the gender
	 */
	public String getGender() {
		return Gender;
	}

	/**
	 * Sets the gender.
	 *
	 * @param gender the new gender
	 */
	public void setGender(String gender) {
		Gender = gender;
	}
	
	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.dto.DropDownList#getKey()
	 */
	public String getKey() {
		return id + "";
	}

	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.dto.DropDownList#getValue()
	 */
	public String getValue() {
		return firstName + " " + lastName;
	}

}
