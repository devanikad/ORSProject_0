package in.co.sunrays.proj0.controller;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import in.co.sunrays.proj0.dto.RoleDTO;
import in.co.sunrays.proj0.dto.UserDTO;
import in.co.sunrays.proj0.exception.ApplicationException;
import in.co.sunrays.proj0.exception.DuplicateRecordException;
import in.co.sunrays.proj0.form.ForgetPasswordForm;
import in.co.sunrays.proj0.form.LoginForm;
import in.co.sunrays.proj0.form.UserRegistrationForm;
import in.co.sunrays.proj0.service.UserServiceInt;

// TODO: Auto-generated Javadoc
/**
 * The Class LoginCtl.
 */
@Controller
@SessionAttributes("user")
public class LoginCtl extends BaseCtl
{
	
	/** The log. */
	private static Logger log = Logger.getLogger(LoginCtl.class);
	
	/** Operations. */
	protected static final String OP_SIGNIN = "SignIn";
    
    /** The Constant OP_SIGNUP. */
    protected static final String OP_SIGNUP = "SignUp";
    
    /** The service. */
    @Autowired
    private UserServiceInt service;
    
    /** i18n Message source. */
    @Autowired
    private MessageSource messageSource;
    
    /**
     * Inits the binder.
     *
     * @param binder the binder
     */
    @InitBinder
    public void initBinder ( WebDataBinder binder )
    {
        StringTrimmerEditor stringtrimmer = new StringTrimmerEditor(true);
        binder.registerCustomEditor(String.class, stringtrimmer);
    }
    
    /**
     * Gets the gender list.
     *
     * @return the gender list
     */
    @ModelAttribute("genderList")
    public Map<String, String> getgenderList() {
       Map<String, String> genderList = new HashMap<String, String>();
       genderList.put("M", "Male");
       genderList.put("F", "Female");
       return genderList;
    }
    
    /**
     * Display.
     *
     * @param signout the signout
     * @param form the form
     * @param model the model
     * @param session the session
     * @param locale the locale
     * @return the string
     */
    @RequestMapping(value="/Login" , method=RequestMethod.GET)
    public String Display(@RequestParam(required=false,defaultValue ="null") String signout ,@ModelAttribute("form") LoginForm form ,Model model,HttpSession session,Locale locale)
    {
    	
    	String enterEmail = messageSource.getMessage("label.enteremail",null,locale);
    	model.addAttribute("enteremail", enterEmail);
    	
    	String enterPassword = messageSource.getMessage("label.enterpassword", null,locale);
    	model.addAttribute("enterpassword", enterPassword);
    	
    	
    	
    	
    	if(session.getAttribute("user") !=null && signout.equalsIgnoreCase("logout"))
    	{
    		session.invalidate();
    		model.asMap().remove("user");//remove session object
    		String msg = messageSource.getMessage("label.logout", null, locale);
    		model.addAttribute("success", msg);
    	}
    	
 
    	
		return "LoginView";
    }

    /**
     * Submit.
     *
     * @param form the form
     * @param result the result
     * @param model the model
     * @param locale the locale
     * @return the string
     * @throws DuplicateRecordException the duplicate record exception
     */
    @RequestMapping(value="/Login" , method=RequestMethod.POST)
    public String Submit(@ModelAttribute("form") @Valid LoginForm form ,BindingResult result,Model model,Locale locale) throws DuplicateRecordException
    {
    	log.debug("LoginCtl method submit to submit login form started");
    	
    	if(OP_SIGNUP.equalsIgnoreCase(form.getOperation()))
    	{
    		return "redirect:/Registration";
    	}   	
    	if(OP_SIGNIN.equalsIgnoreCase(form.getOperation()))
    		
    	{
    		if(result.hasErrors())
    		{
    		  return "LoginView";
            }
    		UserDTO dto = new UserDTO();
    		dto.setEmailId(form.getEmailId());
    		dto.setPassword(form.getPassword());
    		dto = service.authenticate(dto);
    		
    		if(dto!=null)
    		{
				UserDTO edto = service.findByPK(dto.getId());
                RoleDTO roledto = service.getRole(dto);
				dto.setRoleName(roledto.getName());
				
				model.addAttribute("user", dto);
				
              if(form.getUri()==null || form.getUri().toString().trim()=="") {
					  return "redirect:/Welcome"; 
					  }else {
						return "redirect:"+form.getUri().replace("/ORSProject_0", "".toString().trim()); }
				 
    		}else
    		{
    			String msg = messageSource.getMessage("login.error", null, locale);
    			model.addAttribute("error", msg);
    			
    			return "LoginView";
    		}
    	}

		return "redirect:/Welcome";
    }
    
    /**
     * Display.
     *
     * @param model the model
     * @param form the form
     * @param locale the locale
     * @return the string
     */
    @RequestMapping(value="/Registration" , method=RequestMethod.GET)
    public String display(Model model ,@ModelAttribute("form") UserRegistrationForm form,Locale locale)
    {
    	
    	log.debug("LoginCtl method display to display UserRegistration form started");
   	 
    	String enteremail=messageSource.getMessage("label.enteremail",null,locale);
		model.addAttribute("enteremail",enteremail);
		 
		String enterpassword=messageSource.getMessage("label.enterpassword",null,locale);
		model.addAttribute("enterpassword",enterpassword);
		 
		String enterdob=messageSource.getMessage("label.enterdob",null,locale);
		model.addAttribute("enterdob",enterdob);
		 
		String enterfirstName=messageSource.getMessage("label.enterfname",null,locale);
		model.addAttribute("enterfirstName",enterfirstName);
		 
		String enterLastName=messageSource.getMessage("label.enterlname",null,locale);
		model.addAttribute("enterLastName",enterLastName);
		 
		String enterconPassword=messageSource.getMessage("label.entercpassword",null,locale);
		model.addAttribute("enterconPassword",enterconPassword);
		 
		String enterMobile=messageSource.getMessage("label.entermob",null,locale);
		model.addAttribute("enterMobile",enterMobile);	
    	
		log.debug("LoginCtl method display to display UserRegistration form ended");
		
		return "UserRegistration";
    }
    
    /**
     * Submit.
     *
     * @param locale the locale
     * @param form the form
     * @param bindingResult the binding result
     * @param model the model
     * @return the string
     */
    @RequestMapping(value="/Registration" , method=RequestMethod.POST)
    public String submit(Locale locale, @ModelAttribute("form") @Valid UserRegistrationForm form, BindingResult bindingResult, Model model)
    {
    	
	
		if (OP_SIGNUP.equalsIgnoreCase(form.getOperation())) {

			if (bindingResult.hasErrors()) {
				return "UserRegistration";
			}
			UserDTO dto = (UserDTO) form.getDto();
					try {
				if (!dto.getPassword().equals(dto.getConfirmPassword())) {
					String msg = messageSource.getMessage("pattern.matchpass", null, locale);
					model.addAttribute("error1", msg);
					return "UserRegistration";
				}
				
				System.out.println("UserRegistration Ctl DOB---"+dto.getDob());
				
				dto.setRoleId(RoleDTO.STUDENT);
				dto.setCreatedBy("root");
				dto.setModifiedBy("root");
				dto.setCreatedDateTime(new Timestamp(new Date().getTime()));
				dto.setModifiedDateTime(new Timestamp(new Date().getTime()));
				
				service.registerUser(dto);
				
				String msg = messageSource.getMessage("message.success", null, locale);
				model.addAttribute("success", msg);
				form.populate(new UserDTO());
				return "UserRegistration";
			} catch (DuplicateRecordException e) {
				String msg = messageSource.getMessage("error.loginid", null, locale);
				model.addAttribute("error", msg);
			} catch (ApplicationException e) {
				String msg = messageSource.getMessage("error.loginid", null, locale);
				model.addAttribute("error", msg);
			}
			return "redirect:/UserRegistration";
		}
		if (OP_RESET.equalsIgnoreCase(form.getOperation()))
		{
			System.out.println("UserRegistration Ctl Reset---");
			return "redirect:/Registration";
		}

		log.debug("LoginCtl method submit to submit UserRegistration form ended");

		return "UserRegistration";
    }
    
    /**
     * Display.
     *
     * @param form the form
     * @param model the model
     * @param locale the locale
     * @return the string
     */
    @RequestMapping(value="/ForgotPassword" , method=RequestMethod.GET)
    public String display(@ModelAttribute("form") ForgetPasswordForm form , Model model , Locale locale)
    {System.out.println("ForgetPassword get");
    	 String enteremail=messageSource.getMessage("label.enteremail", null, locale);
		 model.addAttribute("enteremail",enteremail);
		return "ForgetPasswordView";
    }
    
    /**
     * Submit.
     *
     * @param form the form
     * @param result the result
     * @param model the model
     * @param locale the locale
     * @return the string
     */
    @RequestMapping(value="/ForgotPassword" , method=RequestMethod.POST)
    public String submit(@ModelAttribute("form") @Valid ForgetPasswordForm form ,BindingResult result,Model model, Locale locale)
    {
    	
    	
    	
    	if(OP_CANCEL.equalsIgnoreCase(form.getOperation()))
    	{
    	  return "redirect:/Login";
    	}
    	
    	if(OP_GO.equalsIgnoreCase(form.getOperation()))
    	{	System.out.println("dopost forget");
    		if(result.hasErrors())
    		{System.out.println("Error");
    			System.out.println(result.getErrorCount());
    		  return "ForgetPasswordView";
    		}
    		
    		try 
    		{
    			boolean flag = false;
				flag = service.forgetPassword(form.getLogin());
				
				if(flag)
				{
					model.addAttribute("success","Password has been sent to your registered Email ID!!");
				}else
				{
					String msg = messageSource.getMessage("forgetpass.error", null, locale);
					model.addAttribute("error", msg);
				}
				
			} catch (ApplicationException e) {
				e.printStackTrace();
			}
    	}
    	
		return "ForgetPasswordView";
    }
    
}

