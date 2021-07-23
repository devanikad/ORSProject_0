package in.co.sunrays.proj0.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

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

import in.co.sunrays.proj0.dto.StudentDTO;
import in.co.sunrays.proj0.exception.ApplicationException;
import in.co.sunrays.proj0.exception.DuplicateRecordException;
import in.co.sunrays.proj0.form.StudentForm;
import in.co.sunrays.proj0.service.CollegeServiceInt;
import in.co.sunrays.proj0.service.StudentServiceInt;

// TODO: Auto-generated Javadoc
/**
 * The Class StudentCtl.
 */
@Controller
@RequestMapping(value="/ctl/Student")
public class StudentCtl extends BaseCtl 
{
   
	/** The service. */
	@Autowired
	private StudentServiceInt service;
	
	/** The message source. */
	@Autowired
	private MessageSource messageSource;
	
	/** The cservice. */
	@Autowired
	private CollegeServiceInt cservice;
	  
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
		public Map<String, String> getGenderList()
		{
			Map<String,String> genderList = new HashMap<String, String>();
			genderList.put("M", "Male");
			genderList.put("F", "FeMale");
			
			return genderList;
		}
		
	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.controller.BaseCtl#preload(org.springframework.ui.Model)
	 */
	@Override
	public void preload(Model model) 
	{
	 List list = cservice.search(null);
	 model.addAttribute("collegeList", list);
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
	@RequestMapping(value="/AddStudent" , method=RequestMethod.GET)
	public String display(@RequestParam(required=false) Long id , @ModelAttribute("form") StudentForm form , Model model,Locale locale)
	{
		String enteremail=messageSource.getMessage("label.enteremail",null,locale);
		model.addAttribute("enteremail",enteremail);
		 
		String enterdob=messageSource.getMessage("label.enterdob",null,locale);
		model.addAttribute("enterdob",enterdob);
		 
		String enterfirstName=messageSource.getMessage("label.enterfname",null,locale);
		model.addAttribute("enterfirstName",enterfirstName);
		 
		String enterLastName=messageSource.getMessage("label.enterlname",null,locale);
		model.addAttribute("enterLastName",enterLastName);

		 
		String enterMobile=messageSource.getMessage("label.entermob",null,locale);
		model.addAttribute("enterMobile",enterMobile);  
		
		if(id!=null && id>0)
		{
			StudentDTO dto = service.findById(id);
			form.populate(dto);
		}
		
		return "StudentView";
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
	 * @throws ApplicationException the application exception
	 */
	@RequestMapping(value="/AddStudent" , method=RequestMethod.POST)
	public String submit(@ModelAttribute("form") @Valid StudentForm form,BindingResult result,Model model , Locale locale) throws DuplicateRecordException, ApplicationException
	{
		String enteremail=messageSource.getMessage("label.enteremail",null,locale);
		model.addAttribute("enteremail",enteremail);
		 
		String enterdob=messageSource.getMessage("label.enterdob",null,locale);
		model.addAttribute("enterdob",enterdob);
		 
		String enterfirstName=messageSource.getMessage("label.enterfname",null,locale);
		model.addAttribute("enterfirstName",enterfirstName);
		 
		String enterLastName=messageSource.getMessage("label.enterlname",null,locale);
		model.addAttribute("enterLastName",enterLastName);

		 
		String enterMobile=messageSource.getMessage("label.entermob",null,locale);
		model.addAttribute("enterMobile",enterMobile);  
		
		if(OP_SAVE.equalsIgnoreCase(form.getOperation()))
		{
			if(result.hasErrors())
			{
				return "StudentView";
			}
			
			StudentDTO dto = (StudentDTO) form.getDto();
			
			if(dto.getId()>0)
			{
				service.update(dto);
				String msg = messageSource.getMessage("message.updatesuccess", null, locale);
				model.addAttribute("success", msg);
			}else
			{
				try 
				{
					dto.setCreatedBy("root");
					dto.setModifiedBy("root");
					service.add(dto);
					String msg = messageSource.getMessage("message.success", null, locale);
					model.addAttribute("success", msg);
				} catch (DuplicateRecordException e) 
				{
					String msg = messageSource.getMessage("message.email", null, locale);
					model.addAttribute("error", msg);
				}	
			}
		}
		
		if(OP_RESET.equalsIgnoreCase(form.getOperation()))
		{
			return "redirect:/ctl/Student/AddStudent";
		}
		if(OP_CANCEL.equalsIgnoreCase(form.getOperation()))
		{
			return "redirect:/ctl/Student/StudentListCtl";
		}
		
		return "StudentView";
	}
	
	
	/**
	 * Display StudentList View
	 * 
	 * param form:
	 * 				Object of StudentForm
	 * param model:
	 * 				Object of Model Interface
	 * return StudentList:
	 * 						View of StudentList.
	 *
	 * @param form the form
	 * @param model the model
	 * @param locale the locale
	 * @return the string
	 */
	@RequestMapping(value="/StudentListCtl", method=RequestMethod.GET)
	public String display(@ModelAttribute("form") StudentForm form, Model model,Locale locale) 
	{
		String enterfirstName=messageSource.getMessage("label.enterfname",null,locale);
		model.addAttribute("enterfirstName",enterfirstName);
		
		model.addAttribute("list",service.search(new StudentDTO(), form.getPageNo(),form.getPageSize()));
		int pageNo = 1;
		
		List next = service.search(new StudentDTO(), pageNo+1, form.getPageSize());
		model.addAttribute("nextlistsize",next.size());
/*        model.addAttribute("findList",service.search(null));*/
		
		return "StudentListView";
	}
	
	
	/**
	 * Submit StudentList 
	 * 
	 * param operation:
	 * 					Operation given by User
	 * param form:
	 * 				Object of StudentForm
	 * param model:
	 * 				Object of Model Interface
	 * param locale:
	 * 				Object of Locale
	 * return StudentList:
	 * 						View of Student List.
	 *
	 * @param operation the operation
	 * @param form the form
	 * @param model the model
	 * @param locale the locale
	 * @return the string
	 */
	@RequestMapping(value="/StudentListCtl",method=RequestMethod.POST)
	public String submit(@RequestParam(required=false) String operation, @ModelAttribute("form") StudentForm form, Model model, Locale locale) 
	{
		
		String enterfirstName=messageSource.getMessage("label.enterfname",null,locale);
		model.addAttribute("enterfirstName",enterfirstName);
		
		//model.addAttribute("findList",service.search(null));
		
		int pageNo=form.getPageNo();
		
		if(OP_PREVIOUS.equalsIgnoreCase(operation)) 
		{
			pageNo--;
		}else if(OP_NEXT.equalsIgnoreCase(operation)) 
		{
			pageNo++;
		}
		if(OP_DELETE.equalsIgnoreCase(operation))
		{
			System.out.println("inside delete student");
			if(form.getChk_1()!=null)
			   {
				   for(long id:form.getChk_1()){
		    			service.delete(id);
		    		}
				   String msg = messageSource.getMessage("message.deleterecord", null, locale);
					model.addAttribute("success", msg);
		    	}
			
			
			else {
		    		String msg = messageSource.getMessage("message.atleastone", null, locale);
					model.addAttribute("error", msg);
		    	}		
		}
		if(OP_RESET.equalsIgnoreCase(operation))
	    {
	    	return "redirect:/ctl/Student/StudentListCtl";
	    }
		if(OP_NEW.equalsIgnoreCase(operation))
	    {
	    	return "redirect:/ctl/Student/AddStudent";
	    }
		 if(OP_BACK.equalsIgnoreCase(operation)){
        	return "redirect:/ctl/Student/StudentListCtl";
        }
		
		
		pageNo=(pageNo<1)?1:pageNo;
	    form.setPageNo(pageNo);
	    
	    StudentDTO dto=(StudentDTO) form.getDto();
	    
	    List list=service.search(dto, pageNo, form.getPageSize());
	 	model.addAttribute("list",list);
	 	
	 	if(list.size()==0 && !OP_DELETE.equalsIgnoreCase(operation)){
	 		model.addAttribute("error", messageSource.getMessage("message.norecord", null, locale));
	 	}
	 	
		List next = service.search(dto, pageNo+1, form.getPageSize());
		model.addAttribute("nextlistsize",next.size());
	 	
		return "StudentListView"; 
	}
	
}

