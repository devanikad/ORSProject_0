package in.co.sunrays.proj0.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

// TODO: Auto-generated Javadoc
/**
 * Base Controller class of project. It contain (1) Generic operations (2)
 * Generic constants (3) Generic work flow.
 * 
 * @author Prototype
 * @version 1.0
 * Copyright (c) Prototype
 */
public class BaseCtl {


	/** Operation constants. */
	protected static final String OP_SAVE = "Save";
    
    /** The Constant OP_CHANGEPASSWORD. */
    protected static final String OP_CHANGEPASSWORD = "ChangePassword";
    
    /** The Constant OP_SEARCH. */
    protected static final String OP_SEARCH = "Search";
    
    /** The Constant OP_NEW. */
    protected static final String OP_NEW = "New";
    
    /** The Constant OP_BACK. */
    protected static final String OP_BACK = "Back";
    
    /** The Constant OP_DELETE. */
    protected static final String OP_DELETE = "Delete";
    
    /** The Constant OP_CANCEL. */
    protected static final String OP_CANCEL = "Cancel";
    
    /** The Constant OP_RESET. */
    protected static final String OP_RESET = "Reset";  
    
    /** The Constant OP_ERROR. */
    protected static final String OP_ERROR = "Error";
    
    /** The Constant OP_NEXT. */
    protected static final String OP_NEXT = "Next";
    
    /** The Constant OP_PREVIOUS. */
    protected static final String OP_PREVIOUS = "Previous";
    
    /** The Constant OP_LOGOUT. */
    protected static final String OP_LOGOUT = "Logout";
    
    /** The Constant OP_GO. */
    protected static final String OP_GO = "Go";
    
    /** The Constant OP_GET. */
    protected static final String OP_GET = "Get";
    
    /** The Constant Physics. */
    public static final String Physics = "Physics";
	
	/** The Constant Chemistry. */
	public static final String Chemistry = "Chemistry";
	
	/** The Constant MATHS. */
	public static final String MATHS = "Maths";
	
	/** The Constant MAX_MARKS. */
	public static final int MAX_MARKS = 100;
	
	/** The Constant MIN_MARKS. */
	public static final int MIN_MARKS = 35;
	
	/** The Constant TOTAL_MARKS. */
	public static final int TOTAL_MARKS = MAX_MARKS * 3;

    
    /**
     * Loads preloaded data and stores in Model object.
     * param model
     *
     * @param model the model
     */
	@ModelAttribute
	public void preload(Model model) {
        
    }
}
