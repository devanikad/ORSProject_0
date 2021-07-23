package in.co.sunrays.proj0.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class CourseDTO.
 */
@Entity
@Table(name="ST_COURSE")
public class CourseDTO extends BaseDTO {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** Course Name. */
	@Column(name="NAME")
	private String name;
	
	/** Description of course. */
	@Column(name="DESCRIPTION")
	private String description;
	
	/** duration of course. */
	@Column(name="DURATION")
	private String duration;
	
	/**
	 * accessors.
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
	
	/**
	 * Gets the duration.
	 *
	 * @return the duration
	 */
	public String getDuration() {
		return duration;
	}
	
	/**
	 * Sets the duration.
	 *
	 * @param duration the new duration
	 */
	public void setDuration(String duration) {
		this.duration = duration;
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
		return name;
	}

	
	
}
