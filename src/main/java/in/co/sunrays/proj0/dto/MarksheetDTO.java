package in.co.sunrays.proj0.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class MarksheetDTO.
 */
@Entity
@Table(name="ST_MARKSHEET")
public class MarksheetDTO extends BaseDTO{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** ID of Student. */
	@Column(name="STUDENT_ID",length=255)
    private long studentId;
     
     /** Rollno of Student. */
	@Column(name="ROLL_NUMBER")
    private String rollNo;
    
    /** Name of Student. */
	@Column(name="STUDENT_NAME")
    private String name;
    
    /** Physics marks of Student. */
	@Column(name="PHYSICS")
    private String physics;
    
    /** Chemistry marks of Student. */
	@Column(name="CHEMISTRY")
    private String chemistry;
    
    /** Mathematics marks of Student. */
	@Column(name="MATHS")
    private String maths;
	
	
	/**
	 * Accessors.
	 *
	 * @return the student id
	 */
	public long getStudentId() {
		return studentId;
	}
	
	/**
	 * Sets the student id.
	 *
	 * @param studentId the new student id
	 */
	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}
	
	/**
	 * Gets the roll no.
	 *
	 * @return the roll no
	 */
	public String getRollNo() {
		return rollNo;
	}
	
	/**
	 * Sets the roll no.
	 *
	 * @param rollNo the new roll no
	 */
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the physics.
	 *
	 * @return the physics
	 */
	public String getPhysics() {
		return physics;
	}
	
	/**
	 * Sets the physics.
	 *
	 * @param physics the new physics
	 */
	public void setPhysics(String physics) {
		this.physics = physics;
	}
	
	/**
	 * Gets the chemistry.
	 *
	 * @return the chemistry
	 */
	public String getChemistry() {
		return chemistry;
	}
	
	/**
	 * Sets the chemistry.
	 *
	 * @param chemistry the new chemistry
	 */
	public void setChemistry(String chemistry) {
		this.chemistry = chemistry;
	}
	
	/**
	 * Gets the maths.
	 *
	 * @return the maths
	 */
	public String getMaths() {
		return maths;
	}
	
	/**
	 * Sets the maths.
	 *
	 * @param maths the new maths
	 */
	public void setMaths(String maths) {
		this.maths = maths;
	}
	
	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.dto.DropDownList#getKey()
	 */
	public String getKey() {
		// TODO Auto-generated method stub
		return id+"";
	}
	
	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.dto.DropDownList#getValue()
	 */
	public String getValue() {
		// TODO Auto-generated method stub
		return rollNo;
	}

	
	
}
