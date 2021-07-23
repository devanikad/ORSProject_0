package in.co.sunrays.proj0.controller;


import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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

import in.co.sunrays.proj0.dto.RoleDTO;
import in.co.sunrays.proj0.dto.UserDTO;
import in.co.sunrays.proj0.exception.DuplicateRecordException;
import in.co.sunrays.proj0.form.ChangePasswordForm;
import in.co.sunrays.proj0.form.MyProfileForm;
import in.co.sunrays.proj0.form.UserForm;
import in.co.sunrays.proj0.service.RoleServiceInt;
import in.co.sunrays.proj0.service.UserServiceInt;
import in.co.sunrays.proj0.util.Util;

// TODO: Auto-generated Javadoc
/**
 * The Class UserCtl.
 */
@Controller
@RequestMapping(value="/ctl/User")
public class UserCtl extends BaseCtl
{

	/** The rservice. */
	@Autowired
	private RoleServiceInt rservice;
	
	/** The service. */
	@Autowired
	private UserServiceInt service;
	
	/** The messagesource. */
	@Autowired
	private MessageSource messagesource;
	
	/**
	 * Gets the gender list.
	 *
	 * @return the gender list
	 */
	@ModelAttribute("genderList")
	public Map<String, String> getGenderList()
	{
		Map<String,String> genderList = new HashMap<String, String>();
		genderList.put("M", "Male");
		genderList.put("F", "FeMale");
		return genderList;
		
		
	}
	
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
	
	 /* (non-Javadoc)
 	 * @see in.co.sunrays.proj0.controller.BaseCtl#preload(org.springframework.ui.Model)
 	 */
 	@Override
	public void preload(Model model) 
	{
		 
	  List list = rservice.search(null);
	  model.addAttribute("roleList",list);
	}
	
	/**
	 * Display.
	 *
	 * @param id the id
	 * @param form the form
	 * @param model the model
	 * @param locale the locale
	 * @return the string
	 */
	@RequestMapping(value="/AddUser" ,method=RequestMethod.GET)
	public String display(@RequestParam(required=false) Long id,@ModelAttribute("form") UserForm form , Model model , Locale locale)
	{
		System.out.println("UserCTL");
		String enteremail=messagesource.getMessage("label.enteremail",null,locale);
		model.addAttribute("enteremail",enteremail);
		 
		String enterpassword=messagesource.getMessage("label.enterpassword",null,locale);
		model.addAttribute("enterpassword",enterpassword);
		 
		String enterdob=messagesource.getMessage("label.enterdob",null,locale);
		model.addAttribute("enterdob",enterdob);
		 
		String enterfirstName=messagesource.getMessage("label.enterfname",null,locale);
		model.addAttribute("enterfirstName",enterfirstName);
		 
		String enterLastName=messagesource.getMessage("label.enterlname",null,locale);
		model.addAttribute("enterLastName",enterLastName);
		 
		String enterconPassword=messagesource.getMessage("label.entercpassword",null,locale);
		model.addAttribute("enterconPassword",enterconPassword);
		 
		String enterMobile=messagesource.getMessage("label.entermob",null,locale);
		model.addAttribute("enterMobile",enterMobile);
		
		if(id!=null && id>0)
		{
			UserDTO dto = (UserDTO) service.findByPK(id);
			dto.setConfirmPassword(dto.getPassword());
            form.populate(dto);
		}
		System.out.println("UserCTL");
		return "UserView";
	}
	
	/**
	 * Submit.
	 *
	 * @param id the id
	 * @param form the form
	 * @param result the result
	 * @param model the model
	 * @param locale the locale
	 * @return the string
	 * @throws DuplicateRecordException the duplicate record exception
	 */
	@RequestMapping(value="/AddUser" ,method=RequestMethod.POST)
	public String submit(@RequestParam(required=false) Long id,@ModelAttribute("form") @Valid UserForm form , BindingResult result , Model model,Locale locale) throws DuplicateRecordException
	{   
		String enteremail=messagesource.getMessage("label.enteremail",null,locale);
		model.addAttribute("enteremail",enteremail);
		 
		String enterpassword=messagesource.getMessage("label.enterpassword",null,locale);
		model.addAttribute("enterpassword",enterpassword);
		 
		String enterdob=messagesource.getMessage("label.enterdob",null,locale);
		model.addAttribute("enterdob",enterdob);
		 
		String enterfirstName=messagesource.getMessage("label.enterfname",null,locale);
		model.addAttribute("enterfirstName",enterfirstName);
		 
		String enterLastName=messagesource.getMessage("label.enterlname",null,locale);
		model.addAttribute("enterLastName",enterLastName);
		 
		String enterconPassword=messagesource.getMessage("label.entercpassword",null,locale);
		model.addAttribute("enterconPassword",enterconPassword);
		 
		String enterMobile=messagesource.getMessage("label.entermob",null,locale);
		model.addAttribute("enterMobile",enterMobile);

		if(OP_SAVE.equalsIgnoreCase(form.getOperation()))
		{
			if(result.hasErrors())
			{
				
				System.out.println(result.getAllErrors()+"errror");
				return "UserView";
			}
			
			UserDTO dto = (UserDTO)form.getDto();
			RoleDTO rdto=rservice.findById(form.getRoleId());
			
			dto.setRoleName(rdto.getName());
			
			//System.out.println("ctl user"+ dto.getPassword());
			dto.setCreatedBy("root");
			dto.setModifiedBy("root");
			
			System.out.println(dto.getPassword()+"+password"+dto.getConfirmPassword());
			/*if(!dto.getPassword().equals(dto.getConfirmPassword())) {
				String msg=messagesource.getMessage("pattern.matchpass",null,locale);
			     	model.addAttribute("error",msg);
			     	return "AddUser";
			}
			
		*/	if(id>0)
			{
			  service.update(dto);
			  String msg = messagesource.getMessage("message.updatesuccess", null, locale);
				model.addAttribute("success",msg);
			}else
			{
				try 
				{
					service.add(dto);
					String msg = messagesource.getMessage("message.success", null, locale);
					model.addAttribute("success",msg);
				} catch (DuplicateRecordException e) {
					String msg = messagesource.getMessage("message.email", null, locale);
					model.addAttribute("error",msg);
				}
			}
		}
		
		if(OP_RESET.equalsIgnoreCase(form.getOperation()))
		{
			return "redirect:/ctl/User/AddUser";
		}
		if(OP_CANCEL.equalsIgnoreCase(form.getOperation()))
			
		{
				return "redirect:/ctl/User/UserListCtl";
		}
		
		return "UserView";
	}
	
	
	/**
	 * Display.
	 *
	 * @param form the form
	 * @param session the session
	 * @param model the model
	 * @param locale the locale
	 * @return the string
	 */
	@RequestMapping(value="/MyProfileCtl" , method=RequestMethod.GET)
	public String display(@ModelAttribute("form") MyProfileForm form , HttpSession session,Model model,Locale locale)
	{
	  UserDTO dto =(UserDTO)session.getAttribute("user");
	  
	  dto = service.findByPK(dto.getId());
	  
	  form.populate(dto);
		
		return "MyProfileView";
		
	}
	
	/**
	 * Submit.
	 *
	 * @param form the form
	 * @param result the result
	 * @param model the model
	 * @param locale the locale
	 * @param session the session
	 * @return the string
	 * @throws DuplicateRecordException the duplicate record exception
	 */
	@RequestMapping(value="/MyProfileCtl" , method=RequestMethod.POST)
	public String submit(@ModelAttribute("form") @Valid MyProfileForm form , BindingResult result , Model model , Locale locale,HttpSession session) throws DuplicateRecordException
	{
		if(OP_SAVE.equalsIgnoreCase(form.getOperation()))
		{
			if(result.hasErrors())
			{
				return "MyProfileView";
			}
			System.out.println("name--->"+form.getFirstName());
			UserDTO dto = service.findByPK(form.getId());
			dto.setFirstName(form.getFirstName());
			dto.setLastName(form.getLastName());
			dto.setDob(Util.getDate(form.getDob()));
			dto.setMobileNo(form.getMobileNo());
			dto.setGender(form.getGender());
			dto.setModifiedBy(form.getLogin());
			dto.setModifiedDateTime(new Timestamp(new Date().getTime()));
			
			session.setAttribute("user", dto);
		
				service.update(dto);
				String msg=messagesource.getMessage("message.success",null,locale);
 				model.addAttribute("success",msg);
			
			
		}

		if(OP_CHANGEPASSWORD.equalsIgnoreCase(form.getOperation()))
		{
			return "redirect:/ctl/User/ChangePasswordCtl";
		}
		
		return "MyProfileView";
	}
	
	/**
	 * Display.
	 *
	 * @param form the form
	 * @param model the model
	 * @param locale the locale
	 * @return the string
	 */
	@RequestMapping(value="/ChangePasswordCtl" , method=RequestMethod.GET)
	public String display(@ModelAttribute("form") ChangePasswordForm form , Model model , Locale locale)
	{	
		
		String enteroldpassword=messagesource.getMessage("label.enteroldpassword",null,locale);
		model.addAttribute("enteroldpassword",enteroldpassword);
		
		String enternewpassword=messagesource.getMessage("label.enternewpassword",null,locale);
		model.addAttribute("enternewpassword",enternewpassword);
		
		String enterconPassword=messagesource.getMessage("label.enterconfirmpassword",null,locale);
		model.addAttribute("enterconPassword",enterconPassword);
		
		
		return "ChangePasswordView";	
	}
	
	/**
	 * Submit.
	 *
	 * @param id the id
	 * @param form the form
	 * @param result the result
	 * @param model the model
	 * @param session the session
	 * @param locale the locale
	 * @return the string
	 */
	@RequestMapping(value="/ChangePasswordCtl" , method=RequestMethod.POST)
	public String submit(@RequestParam(required=false) Long id,@ModelAttribute("form") @Valid ChangePasswordForm form,BindingResult result,Model model,HttpSession session,Locale locale)
	{
	 if(OP_CANCEL.equalsIgnoreCase(form.getOperation())) {
			
			return "redirect:/ctl/User/MyProfileCtl";
		}
		if(OP_SAVE.equalsIgnoreCase(form.getOperation())) {
			if(result.hasErrors()) {
				return "ChangePasswordView";
			}
			
			boolean flag = false;
			UserDTO dto = (UserDTO) session.getAttribute("user");
			
			if(!form.getOldPassword().equals(form.getNewPassword())) {
				if(form.getConfirmPassword().equals(form.getNewPassword())) {
					try {
						flag=service.changePassword(dto.getId(), form.getOldPassword(), form.getNewPassword());
						if(flag) {
							String msg=messagesource.getMessage("message.success",null,locale);
							model.addAttribute("success",msg);
						}else {
							String msg=messagesource.getMessage("error.oldrightpassword",null,locale);
							model.addAttribute("error",msg);
						}
					}catch(DuplicateRecordException e) {
						
					}
				}else {
					String msg=messagesource.getMessage("error.newconpassword",null,locale);
					model.addAttribute("error",msg);
				}
			}else {
				String msg=messagesource.getMessage("error.oldnewpassword",null,locale);
				model.addAttribute("error",msg);
			}
		}
		
		return "ChangePasswordView";
	}	
	
	/**
	 * Display.
	 *
	 * @param operation the operation
	 * @param form the form
	 * @param model the model
	 * @param locale the locale
	 * @return the string
	 */
	@RequestMapping(value="/UserListCtl" , method=RequestMethod.GET)
	public String display(@RequestParam(required=false) String operation,@ModelAttribute("form") UserForm form,Model model , Locale locale)
	{
		String enterfirstName=messagesource.getMessage("label.enterfname",null,locale);
		model.addAttribute("enterfFirstName",enterfirstName);
		String enterLastName=messagesource.getMessage("label.enterlname",null,locale);
		model.addAttribute("enterLastName",enterLastName);
		
		int pageNo=1;
		
		List list = service.search(null, pageNo, form.getPageSize());
		model.addAttribute("list", list);
		
		List next = service.search(null, pageNo+1,form.getPageSize());
		model.addAttribute("nextlistsize", next.size());
		
		return "UserListView";
	}
	
	
	/**
	 * Submit.
	 *
	 * @param operation the operation
	 * @param form the form
	 * @param result the result
	 * @param model the model
	 * @param locale the locale
	 * @return the string
	 */
	@RequestMapping(value="/UserListCtl" , method= RequestMethod.POST)
	public String submit(@RequestParam(required=false) String operation , @ModelAttribute("form") UserForm form , BindingResult result , Model model , Locale locale)
	{
		
		String enterfirstName=messagesource.getMessage("label.enterfname",null,locale);
		model.addAttribute("enterfFirstName",enterfirstName);
		String enterLastName=messagesource.getMessage("label.enterlname",null,locale);
		model.addAttribute("enterLastName",enterLastName);
		
		if(result.hasErrors())
		{
		  return "UserListView";
		}
		
		int pageNo = (form.getPageNo()==0)?1:form.getPageNo();
		int pageSize = form.getPageSize();
		
		List list = null;
		List next = null;
		
		
		if(OP_SEARCH.equalsIgnoreCase(operation))
		{
			pageNo=1;
		}
		if(OP_NEXT.equalsIgnoreCase(operation))
		{
			pageNo++;
		}
		if(OP_PREVIOUS.equalsIgnoreCase(operation))
		{
			pageNo--;
		}
		if(OP_DELETE.equalsIgnoreCase(operation))
		{
			if(form.getChk_1() != null)
			{
				for(long id:form.getChk_1())
				{
					service.delete(id);
				}
				String msg = messagesource.getMessage("message.deleterecord", null, locale);
				model.addAttribute("success", msg);
	    	}else {
	    		String msg = messagesource.getMessage("message.atleastone", null, locale);
				model.addAttribute("error", msg);
	    	}
		}
		if(OP_NEW.equalsIgnoreCase(operation))
		{
			return "redirect:/ctl/User/AddUser";
		}
		if(OP_RESET.equalsIgnoreCase(operation))
		{
			return "redirect:/ctl/User/UserListCtl";
		}
		if(OP_BACK.equalsIgnoreCase(operation)){
			 return "redirect:/ctl/User/UserListCtl";
	        }
		
		
		
		form.setPageNo(pageNo);
		
		UserDTO dto = (UserDTO)form.getDto();
		
		list = service.search(dto, pageNo, pageSize);
		model.addAttribute("list", list);
		if(list.size()==0 && !OP_DELETE.equalsIgnoreCase(operation))
		{
			model.addAttribute("error",messagesource.getMessage("message.norecord", null, locale));
		}
		
		next = service.search(dto, pageNo+1, pageSize);
		model.addAttribute("nextlistsize",next.size());
		
		
		return "UserListView";
		
	}
	
}

