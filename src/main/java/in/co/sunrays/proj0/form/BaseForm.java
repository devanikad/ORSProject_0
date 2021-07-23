package in.co.sunrays.proj0.form;

import in.co.sunrays.proj0.dto.BaseDTO;

// TODO: Auto-generated Javadoc
/**
 * The Class BaseForm.
 */
public class BaseForm {
	
	/** Contains non-business primary key. */
	protected long id = 0;
	
	/** Current page number. */
	private int pageNo=1;
	
	/** The chk 1. */
	private Long[] chk_1;
	
	/**
	 * Gets the chk 1.
	 *
	 * @return the chk 1
	 */
	public Long[] getChk_1() {
		return chk_1;
	}

    /**
     * Sets the chk 1.
     *
     * @param chk_1 the new chk 1
     */
    public void setChk_1(Long[] chk_1) {
		this.chk_1 = chk_1;
	}
	
	/** Number of records displayed on list page. */
    private int pageSize = 5;
	
    /** Value of button clicked. */
    private String operation;
    
    /** Created by User ID. */
    protected String createdBy;

    /** Modified by User ID. */
    protected String modifiedBy;

    /** Record created datetime. */
    protected long createdDatetime;

    /** Record last modified datetime. */
    protected long modifiedDatetime;
    
    /**
     * Gets the id.
     *
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Gets the page no.
     *
     * @return the page no
     */
    public int getPageNo() {
        return pageNo;
    }

    /**
     * Sets the page no.
     *
     * @param pageNo the new page no
     */
    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    /**
     * Gets the page size.
     *
     * @return the page size
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * Sets the page size.
     *
     * @param pageSize the new page size
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * Gets the operation.
     *
     * @return the operation
     */
    public String getOperation() {
        return operation;
    }

    /**
     * Sets the operation.
     *
     * @param operation the new operation
     */
    public void setOperation(String operation) {
        this.operation = operation;
    }

    /**
     * Gets the created by.
     *
     * @return the created by
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * Sets the created by.
     *
     * @param createdBy the new created by
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * Gets the modified by.
     *
     * @return the modified by
     */
    public String getModifiedBy() {
        return modifiedBy;
    }

    /**
     * Sets the modified by.
     *
     * @param modifiedBy the new modified by
     */
    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    /**
     * Gets the created datetime.
     *
     * @return the created datetime
     */
    public long getCreatedDatetime() {
        return createdDatetime;
    }

    /**
     * Sets the created datetime.
     *
     * @param createdDatetime the new created datetime
     */
    public void setCreatedDatetime(long createdDatetime) {
        this.createdDatetime = createdDatetime;
    }

    /**
     * Gets the modified datetime.
     *
     * @return the modified datetime
     */
    public long getModifiedDatetime() {
        return modifiedDatetime;
    }

    /**
     * Sets the modified datetime.
     *
     * @param modifiedDatetime the new modified datetime
     */
    public void setModifiedDatetime(long modifiedDatetime) {
        this.modifiedDatetime = modifiedDatetime;
    }
    
    /**
     * Converts form into dto.
     * 
     * return dto:
     * 				Object of BaseDTO
     *
     * @return the dto
     */
    public BaseDTO getDto() {
        return null;
    }

    /**
     * Converts dto into form.
     * 
     * param bDto:
     * 				Object of BaseDTO
     *
     * @param bDto the b dto
     */
    public void populate(BaseDTO bDto) {

    }
    
}
