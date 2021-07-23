package in.co.sunrays.proj0.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class RoleDTO.
 */
@Entity
@Table(name="ST_ROLE")
public class RoleDTO extends BaseDTO {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The Constant ADMIN. */
	public static final int ADMIN=1;
	
	/** The Constant STUDENT. */
	public static final int STUDENT=2;
	
	/** The Constant FACULTY. */
	public static final int FACULTY=3;
	
	/** The Constant KIOSK. */
	public static final int KIOSK=4;
	
	/** The Constant COLLEGE. */
	public static final int COLLEGE=5;
	
	/** The name. */
	@Column(name="NAME" ,length=255)
	private String name;
	
	/** The description. */
	@Column(name="DESCRIPTION",length=255)
	private String description;
	
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
