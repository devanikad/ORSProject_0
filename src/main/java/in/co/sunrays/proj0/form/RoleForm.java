package in.co.sunrays.proj0.form;

import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

import in.co.sunrays.proj0.dto.BaseDTO;
import in.co.sunrays.proj0.dto.RoleDTO;

// TODO: Auto-generated Javadoc
/**
 * Contains Role form elements and their declarative input validations.
 * 
 * @author Iterator
 * @version 1.0 Copyright (c) Iterator
 * 
 */
public class RoleForm extends BaseForm {
	
	/** rolename of RoleForm. */
    @NotEmpty
    private String name;
    
    /** roledescription of RoleForm. */
    @NotEmpty
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
     * @see in.co.sunrays.proj0.form.BaseForm#getDto()
     */
    @Override
    public BaseDTO getDto() {

        RoleDTO dto = new RoleDTO();
        dto.setId(id);
        dto.setName(name);
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

        if (bDto == null) {
            return;
        }

        RoleDTO dto = (RoleDTO) bDto;

        id = dto.getId();
        name = dto.getName();
        description = dto.getDescription();
        createdBy = dto.getCreatedBy();
        modifiedBy = dto.getModifiedBy();
        if(dto.getCreatedDateTime()!=null)
        createdDatetime = dto.getCreatedDateTime().getTime();
        if(dto.getModifiedDateTime()!=null)
        modifiedDatetime = dto.getModifiedDateTime().getTime();
    }

}
