package in.co.sunrays.proj0.controller;
import java.util.List;
import java.util.Locale;

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
import in.co.sunrays.proj0.dto.TimeTableDTO;
import in.co.sunrays.proj0.exception.DuplicateRecordException;
import in.co.sunrays.proj0.form.TimeTableForm;
import in.co.sunrays.proj0.service.CourseServiceInt;
import in.co.sunrays.proj0.service.SubjectServiceInt;
import in.co.sunrays.proj0.service.TimeTableServiceInt;

// TODO: Auto-generated Javadoc
/**
 * The Class TimeTableCtl.
 */
@Controller
@RequestMapping(value="/ctl/TimeTable")
public class TimeTableCtl extends BaseCtl
{
  
	/** The service. */
	@Autowired
	private TimeTableServiceInt service;
	
	/** The couservice. */
	@Autowired
	private CourseServiceInt couservice;
	
	/** The subservice. */
	@Autowired
	private SubjectServiceInt subservice;
	
	/** The messagesource. */
	@Autowired
	private MessageSource messagesource;
	  
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
	 List list1 = couservice.search(null);
	 model.addAttribute("courseList", list1);
	 
	 List list2 = subservice.search(null);
	 model.addAttribute("subjectList", list2);
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
	@RequestMapping(value="/AddTimeTable" ,method=RequestMethod.GET)
	public String display(@RequestParam(required=false) Long id , @ModelAttribute("form") TimeTableForm form , Model model , Locale locale)
	{
		String entername=messagesource.getMessage("label.enterexamdate",null,locale);
		model.addAttribute("enterDate",entername);
		
		String enterdescription=messagesource.getMessage("label.enterdescription",null,locale);
		model.addAttribute("enterdescription",enterdescription);
		
		if(id!=null && id>0)
		{
			TimeTableDTO dto = service.findByPk(id);
			form.populate(dto);
		}
		
		return "TimeTableView";
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
	@RequestMapping(value="/AddTimeTable" , method=RequestMethod.POST)
	public String submit(@ModelAttribute("form") @Valid TimeTableForm form , BindingResult result , Model model , Locale locale)
	{
		String entername=messagesource.getMessage("label.enterexamdate",null,locale);
		model.addAttribute("enterDate",entername);
		
		String enterdescription=messagesource.getMessage("label.enterdescription",null,locale);
		model.addAttribute("enterdescription",enterdescription);
		
		if(OP_SAVE.equalsIgnoreCase(form.getOperation()))
		{
			if(result.hasErrors())
			{
				return "TimeTableView";
			}
			
			TimeTableDTO dto = (TimeTableDTO)form.getDto();
			dto.setCreatedBy("root");
			dto.setModifiedBy("root");
			System.out.println(dto.getExamDate());
			if(dto.getId()>0)
			{
				try {
					service.update(dto);
					String msg = messagesource.getMessage("message.updatesuccess", null, locale);
					model.addAttribute("success", msg);
				} catch (DuplicateRecordException e) {
					String msg = messagesource.getMessage("error.record", null, locale);
					model.addAttribute("error", msg);				
				}
			}else
			{
				try {
					service.add(dto);
					String msg = messagesource.getMessage("message.success", null, locale);
					model.addAttribute("success", msg);
				} catch (DuplicateRecordException e) {
					String msg = messagesource.getMessage("error.record", null, locale);
					model.addAttribute("error", msg);
				}
			}
			
		}
		
		if(OP_RESET.equalsIgnoreCase(form.getOperation()))
		{
			return "redirect:/ctl/TimeTable/AddTimeTable";
		}
		if(OP_CANCEL.equalsIgnoreCase(form.getOperation()))
		{
			return "redirect:/ctl/TimeTable/TimeTableListCtl";
		}
		
		return "TimeTableView";
	}
	
	/**
	 * Displays TimetableList View
	 * 
	 * param form:
	 * 				Object of TimetableForm
	 * param model:
	 * 				Object of Model Interface
	 * return TimetableList:
	 * 						View of TimetableList.
	 *
	 * @param form the form
	 * @param model the model
	 * @param locale the locale
	 * @return the string
	 */
	@RequestMapping(value="/TimeTableListCtl",method=RequestMethod.GET)
	public String display(@ModelAttribute("form") TimeTableForm form, Model model,Locale locale) {
		
		String entername=messagesource.getMessage("label.enterexamdate",null,locale);
		model.addAttribute("enterDate",entername);
		
		model.addAttribute("list",service.search(null, form.getPageNo(),form.getPageSize()));
		
		List next = service.search(null, form.getPageNo()+1, form.getPageSize());
		model.addAttribute("nextlistsize", next.size());
		
		return "TimeTableListView";
	}
	
	/**
	 * Submit TimetableList View
	 * 
	 * param operation:
	 * 					Operation given by User
	 * param form:
	 * 				Object of TimetableForm
	 * param model:
	 * 				Object of Model Interface
	 * param locale:
	 * 				Object of Locale
	 * return Timetable:
	 * 						View of TimetableList.
	 *
	 * @param operation the operation
	 * @param form the form
	 * @param model the model
	 * @param locale the locale
	 * @return the string
	 */
	@RequestMapping(value="/TimeTableListCtl",method=RequestMethod.POST)
	public String submit(@RequestParam(required=false) String operation, @ModelAttribute("form") TimeTableForm form, Model model, Locale locale) {
		
		String entername=messagesource.getMessage("label.enterexamdate",null,locale);
		model.addAttribute("enterDate",entername);
		
		int pageNo = (form.getPageNo()<1)?1:form.getPageNo();
		int pageSize = form.getPageSize();
		
		TimeTableDTO dto=(TimeTableDTO) form.getDto();
		System.out.println("ctl exdate"+dto.getExamDate());
		
		if(OP_SEARCH.equalsIgnoreCase(operation))
		{
			pageNo=1;	
		}
		if(OP_PREVIOUS.equalsIgnoreCase(operation))
		{
			pageNo--;
		} 
		if(OP_NEXT.equalsIgnoreCase(operation)) 
		{
			pageNo++;
		}
		if(OP_DELETE.equalsIgnoreCase(operation)) 
		{
			if(form.getChk_1()!=null) {
				for(long id:form.getChk_1()){
	    			service.delete(id);
	    		}
	    		String msg = messagesource.getMessage("message.deleterecord", null, locale);
				model.addAttribute("success", msg);
			}else {
				String msg = messagesource.getMessage("message.atleastone", null, locale);
				model.addAttribute("error", msg);
			}
		}
		if(OP_RESET.equalsIgnoreCase(operation)){
	    	return "redirect:/ctl/TimeTable/TimeTableListCtl";
	    }
	    if(OP_NEW.equalsIgnoreCase(operation)){
	    	return "redirect:/ctl/TimeTable/AddTimeTable";
	    }
	    
	    if(OP_BACK.equalsIgnoreCase(operation)){
			 return "redirect:/ctl/TimeTable/TimeTableListCtl";
	        }
		
	    form.setPageNo(pageNo);
	    
	    List list=service.search(dto, pageNo, pageSize);
	    model.addAttribute("list", list);
	    
	    if(list.size()==0 && !OP_DELETE.equalsIgnoreCase(operation) )
	    {
	    	model.addAttribute("error", messagesource.getMessage("message.norecord", null, locale));
	  	}
	    
	    List next = service.search(dto, pageNo+1, pageSize);
		model.addAttribute("nextlistsize", next.size());
		
		System.out.println("nextlistsize"+next.size());
	    
		return "TimeTableListView";
	}
}
