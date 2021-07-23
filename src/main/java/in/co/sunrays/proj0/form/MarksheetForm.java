package in.co.sunrays.proj0.form;

import java.sql.Timestamp;
import java.util.Date;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import in.co.sunrays.proj0.dto.BaseDTO;
import in.co.sunrays.proj0.dto.MarksheetDTO;

// TODO: Auto-generated Javadoc
/**
 * Contains Marksheet form elements and their declarative input validations.
 * 
 * @author Facade
 * @version 1.0
 */ 
public class MarksheetForm extends BaseForm
{
	
	/** ROLLNO of Marksheet. */
	@NotEmpty
	private String rollNo;
	
	/** studentId of Marksheet. */
	@Min(value=1 , message=("Min.form.studentId"))
	private long studentId;
	
	/** studentName of Marksheet. */
	private String name;
	
	/** mathsMarks of Marksheet. */
	@NotNull
	@Min(0)
	@Max(100)
    private String maths;
	
	/** physicsMarks of Marksheet. */
	@NotNull
	@Min(0)
	@Max(100)
	private String physics;
	
	/** chemistryMarks of Marksheet. */
	@NotNull
	@Min(0)
	@Max(100)
	private String chemistry;
	
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
	 * Gets the student id.
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
	
/*	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}*/
	

	/* (non-Javadoc)
 * @see in.co.sunrays.proj0.form.BaseForm#getDto()
 */
@Override
	public BaseDTO getDto() 
	{
		
		MarksheetDTO dto=new MarksheetDTO();
		
		
		dto.setId(id);
		dto.setRollNo(rollNo);
		dto.setStudentId(studentId);
		dto.setName(name);
		dto.setMaths(maths);
		dto.setChemistry(chemistry);
		dto.setPhysics(physics);
		dto.setCreatedBy(createdBy);
	    dto.setModifiedBy(modifiedBy);
	    dto.setCreatedDateTime(new Timestamp(new Date().getTime()));
	    dto.setModifiedDateTime(new Timestamp(new Date().getTime()));
		return dto;
	}
	
	
	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.form.BaseForm#populate(in.co.sunrays.proj0.dto.BaseDTO)
	 */
	@Override
	public void populate(BaseDTO bDto) 
	{
		
		MarksheetDTO dto=(MarksheetDTO) bDto;
		
		
		id=dto.getId();
		rollNo=dto.getRollNo();
		studentId=dto.getStudentId();
		name=dto.getName();
		maths=dto.getMaths();
		chemistry=dto.getChemistry();
		System.out.println("chemistry===="+dto.getChemistry());
     	physics=dto.getPhysics();
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

