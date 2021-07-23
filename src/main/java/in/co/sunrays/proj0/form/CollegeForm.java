package in.co.sunrays.proj0.form;


import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import in.co.sunrays.proj0.dto.BaseDTO;
import in.co.sunrays.proj0.dto.CollegeDTO;

// TODO: Auto-generated Javadoc
/**
 * Contains College form elements and their declarative input validations.
 * 
 * @author Iterator
 * @version 1.0 Copyright (c) Iterator
 */
public class CollegeForm extends BaseForm{
	
	/** name of college. */	
    @NotEmpty
    private String name;
    
    /** address of college. */	
    @NotEmpty
    private String address;
    
    /** state of college. */	
    @NotEmpty
    private String state;
    
    /** city of college. */	
    @NotEmpty
    private String city;
    
    /** phoneNo of college. */	
    @NotNull
    @Pattern(regexp = "\\d{10}")
    private String phoneNo;
    
    /** message of college. */	
    private String message;

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
     * Gets the address.
     *
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address.
     *
     * @param address the new address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets the state.
     *
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the state.
     *
     * @param state the new state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Gets the city.
     *
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city.
     *
     * @param city the new city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets the phone no.
     *
     * @return the phone no
     */
    public String getPhoneNo() {
        return phoneNo;
    }

    /**
     * Sets the phone no.
     *
     * @param phoneNo the new phone no
     */
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    /**
     * Gets the message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message.
     *
     * @param message the new message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Populate dto from form.
     *
     * @return the dto
     */
    @Override
    public BaseDTO getDto() {
        CollegeDTO dto = new CollegeDTO();
        dto.setId(id);
        dto.setName(name);
        dto.setAddress(address);
        dto.setCity(city);
        dto.setState(state);
        dto.setPhoneNo(phoneNo);
        dto.setCreatedDateTime(new Timestamp(new Date().getTime()));
        dto.setModifiedDateTime(new Timestamp(new Date().getTime()));
        System.out.println("getDto pageNo--->"+getPageNo());
        return dto;
    }

    /**
     * Populate from from dto.
     *
     * @param bDto the b dto
     */
    @Override
    public void populate(BaseDTO bDto) {
        CollegeDTO dto = (CollegeDTO) bDto;
        id = dto.getId();
        name = dto.getName();
        address = dto.getAddress();
        city = dto.getCity();
        state = dto.getState();
        phoneNo = dto.getPhoneNo();
        
        if(dto.getCreatedDateTime()!=null)
        createdDatetime = dto.getCreatedDateTime().getTime();
        
        if(dto.getModifiedDateTime()!=null)
        modifiedDatetime = dto.getModifiedDateTime().getTime();
        
        System.out.println("populate pageNo--->"+getPageNo());
    }

}


