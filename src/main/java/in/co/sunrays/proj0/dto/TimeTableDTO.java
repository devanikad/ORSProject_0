package in.co.sunrays.proj0.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
// TODO: Auto-generated Javadoc

/**
 * The Class TimeTableDTO.
 */
@Entity
@Table(name="ST_TIMETABLE")
public class TimeTableDTO extends BaseDTO{


	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** Course Id. */
	@Column(name="COURSE_ID")
	private long courseId;
	
	/** Course Name. */
	@Column(name="COURSE_NAME")
	private String courseName;
	
	/** Subject Id. */
	@Column(name="SUBJECT_ID")
	private long subjectId;
	
	/** Subject Name. */
	@Column(name="SUBJECT_NAME")
	private String subjectName;
	
	/** Semester. */
	@Column(name="SEMESTER")
	private String semester;
	
	/** Exam Date. */
	@Column(name="EXAM_DATE")
	private Date examDate;
	
	/** Exam Time. */
	@Column(name="Exam_TIME")
	private String examTime;

	/**
	 * Accessors.
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
	 * Gets the semester.
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
	 * Gets the exam date.
	 *
	 * @return the exam date
	 */
	public Date getExamDate() {
		return examDate;
	}

	/**
	 * Sets the exam date.
	 *
	 * @param examDate the new exam date
	 */
	public void setExamDate(Date examDate) {
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
	 * @see in.co.sunrays.proj0.dto.DropDownList#getKey()
	 */
	public String getKey() {
		// TODO Auto-generated method stub
		return id + "";
	}

	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.dto.DropDownList#getValue()
	 */
	public String getValue() {
		// TODO Auto-generated method stub
		return examDate + "";
	}
}
