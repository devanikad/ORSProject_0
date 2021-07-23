package in.co.sunrays.proj0.form;
import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

import in.co.sunrays.proj0.dto.BaseDTO;
import in.co.sunrays.proj0.dto.CourseDTO;

// TODO: Auto-generated Javadoc
/**
 * Contains Course form elements and their declarative input validations.
 * 
 * @author Facade
 * @version 1.0 Copyright (c) Facade
 */
public class CourseForm extends BaseForm{
	
	/** Name of course. */	
	@NotEmpty
	private String name;
	
	/** Duration of course. */	
	@NotEmpty
    private String duration;
	
	/** description of course. */	
	@NotEmpty
    private String description;

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
	 * @see in.co.sunrays.proj0.form.BaseForm#getDto()
	 */
	@Override
    public BaseDTO getDto() {
    	CourseDTO dto=new CourseDTO();
    	dto.setId(id);
    	dto.setName(name);
    	dto.setDuration(duration);
        dto.setDescription(description);
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
    public void populate(BaseDTO bDto) {
       CourseDTO dto=(CourseDTO) bDto;
    	  id=dto.getId();
    	  name=dto.getName();
    	  duration=dto.getDuration();
    	  description=dto.getDescription();
    	  createdBy = dto.getCreatedBy();
          modifiedBy = dto.getModifiedBy();
          if (dto.getCreatedDateTime() != null) {
              createdDatetime = dto.getCreatedDateTime().getTime();
          }
          if (dto.getModifiedDateTime() != null) {
              modifiedDatetime = dto.getModifiedDateTime().getTime();
          }
    }

}

