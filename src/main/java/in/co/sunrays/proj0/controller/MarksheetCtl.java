package in.co.sunrays.proj0.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import in.co.sunrays.proj0.dto.MarksheetDTO;
import in.co.sunrays.proj0.dto.StudentDTO;
import in.co.sunrays.proj0.exception.DuplicateRecordException;
import in.co.sunrays.proj0.form.MarksheetForm;
import in.co.sunrays.proj0.service.MarksheetServiceInt;
import in.co.sunrays.proj0.service.StudentServiceInt;

// TODO: Auto-generated Javadoc
/**
 * The Class MarksheetCtl.
 */
@Controller
@RequestMapping("/ctl/Marksheet")
public class MarksheetCtl extends BaseCtl {

	/** The service. */
	@Autowired
	private StudentServiceInt service;

	/** The message source. */
	@Autowired
	private MessageSource messageSource;
	
	

	/** The mservice. */
	@Autowired
	private MarksheetServiceInt mservice;

	/* (non-Javadoc)
	 * @see in.co.sunrays.proj0.controller.BaseCtl#preload(org.springframework.ui.Model)
	 */
	@Override
	public void preload(Model model) {
		List list = service.search(null);
		model.addAttribute("studentList", list);
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
	/**
	 * @param id
	 * @param form
	 * @param model
	 * @param locale
	 * @return
	 */
	@RequestMapping(value = "/AddMarksheet", method = RequestMethod.GET)
	public String Display(@RequestParam(required = false) Long id, @ModelAttribute("form") MarksheetForm form,
			Model model, Locale locale) {
		String enterrollno = messageSource.getMessage("label.enterrollno", null, locale);
		model.addAttribute("enterRollNo", enterrollno);

		String enterphysics = messageSource.getMessage("label.enterphysics", null, locale);
		model.addAttribute("enterPhysics", enterphysics);

		String enterchemistry = messageSource.getMessage("label.enterchemistry", null, locale);
		model.addAttribute("enterChemistry", enterchemistry);

		String entermaths = messageSource.getMessage("label.entermaths", null, locale);
		model.addAttribute("enterMaths", entermaths);
		if (id != null && id > 0) {
			
			MarksheetDTO dto = mservice.findById(id);
			
			form.populate(dto);
			
		}
		return "MarksheetView";
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
  	@RequestMapping(value = "/AddMarksheet", method = RequestMethod.POST) public
	  String submit(@RequestParam String operation, @ModelAttribute("form") @Valid
	  MarksheetForm form,BindingResult result, Model model, Locale locale) {
	  
	  System.out.println("------------------------------>hghg"); 
	  String enterrollno= messageSource.getMessage("label.enterrollno", null, locale);
	  model.addAttribute("enterRollNo", enterrollno);
	  
	  String enterphysics = messageSource.getMessage("label.enterphysics", null,
	  locale); model.addAttribute("enterPhysics", enterphysics);
	  
	  String enterchemistry = messageSource.getMessage("label.enterchemistry",
	  null, locale); model.addAttribute("enterChemistry", enterchemistry);
	  
	  String entermaths = messageSource.getMessage("label.entermaths", null,
	  locale); model.addAttribute("enterMaths", entermaths);
	  
	  System.out.println("inside submit-------------->");
	  
	  if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {
	  
	  System.out.println("inside save-------------->");
	  
	  if (result.hasErrors()) {
	  
	  System.out.println("errors can be "+result.getAllErrors()); return
	  "MarksheetView"; }
	  
	  MarksheetDTO dto = (MarksheetDTO) form.getDto();
	  
	  StudentDTO sdto=service.findById(dto.getStudentId());
	  dto.setName(sdto.getFirstName()); dto.setCreatedBy("root");
	  dto.setModifiedBy("root");
	  
	  if (dto.getId() > 0) {
	  
	  try { mservice.update(dto); String msg =
	  messageSource.getMessage("message.updatesuccess", null, locale);
	  model.addAttribute("success", msg); model.addAttribute("id", dto.getId()); }
	  catch (DuplicateRecordException e) { e.printStackTrace(); } } else {
	  
	  try { System.out.println("save marKsheet"); mservice.add(dto);
	  System.out.println("inserted-------------->"); String msg =
	  messageSource.getMessage("message.success", null, locale);
	  model.addAttribute("success", msg); } catch (DuplicateRecordException e) {
	  String msg = messageSource.getMessage("message.rollno", null, locale);
	  model.addAttribute("error", msg); } } }
	  
	  if(OP_RESET.equalsIgnoreCase(form.getOperation())) {
	  
	  return "redirect:/ctl/Marksheet/AddMarksheet"; }
	  
	  if(OP_CANCEL.equalsIgnoreCase(form.getOperation())) { return
	  "redirect:/ctl/Marksheet/MarksheetListCtl"; }
	  
	  return "MarksheetView"; 
	  
	  }
	 
	
	/**
	 * Display.
	 *
	 * @param form the form
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value="/MeritList" , method=RequestMethod.GET)
	public String display(@ModelAttribute("form") MarksheetForm form , Model model)
	{
		List list = mservice.getMeritList(form.getPageNo(), form.getPageSize());
		
		Iterator it = list.iterator();
		while(it.hasNext())
		{
			MarksheetDTO dto = (MarksheetDTO)it.next();
			
		}
		
		model.addAttribute("list",list);
		
		return "MarksheetMeritList";
	}
	
	/**
	 * Display.
	 *
	 * @param form the form
	 * @param model the model
	 * @param locale the locale
	 * @return the string
	 */
	@RequestMapping(value="/GetMarksheet" , method=RequestMethod.GET)
	public String display(@ModelAttribute("form") MarksheetForm form , Model model , Locale locale)
	{
		return "GetMarksheet";		
	}
	
	/**
	 * Submit.
	 *
	 * @param form the form
	 * @param result the result
	 * @param operation the operation
	 * @param model the model
	 * @param locale the locale
	 * @return the string
	 */
	@RequestMapping(value="/GetMarksheet" , method=RequestMethod.POST)
	public String submit(@ModelAttribute("form") @Valid MarksheetForm form,BindingResult result ,@RequestParam(required=false) String operation, Model model , Locale locale)
	{
		if(OP_SEARCH.equalsIgnoreCase(operation))
		{
			if(form.getRollNo()!="") {
				MarksheetDTO dto=mservice.findByRollNumber(form.getRollNo());
				if(dto!=null){	
					System.out.println(dto.getId());
					form.populate(dto);
				}else{
					String msg1=messageSource.getMessage("error.roll",null,locale);
					model.addAttribute("error", msg1);
				}
			}else {
				String msg1=messageSource.getMessage("NotEmpty",null,locale);
				model.addAttribute("error", msg1);
			}
		}
		
		if(OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/Marksheet/GetMarksheet";
		}
		return "GetMarksheet";
	}
	
	/**
	 * Display.
	 *
	 * @param form the form
	 * @param locale the locale
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value="/MarksheetListCtl" , method=RequestMethod.GET)
	public String display(@ModelAttribute("form") MarksheetForm form,Locale locale,Model model)
	{
		String enterrollno=messageSource.getMessage("label.enterrollno",null,locale);
		model.addAttribute("enterRollNo",enterrollno);
		String entername=messageSource.getMessage("label.studentName",null,locale);
		model.addAttribute("enterName",entername);
		
		int pageNo=1;
		
		List list = mservice.search(new MarksheetDTO(), pageNo, form.getPageSize());
		model.addAttribute("list",list);
		
		List next = mservice.search(new MarksheetDTO(), pageNo+1,form.getPageSize());
		model.addAttribute("nextlistsize", next.size());
		
		return "MarksheetListView";	
	}
	
	/**
	 * Submit.
	 *
	 * @param operation the operation
	 * @param form the form
	 * @param model the model
	 * @param locale the locale
	 * @return the string
	 */
	@RequestMapping(value="/MarksheetListCtl" , method=RequestMethod.POST)
	public String submit(@RequestParam(required=false) String operation,@ModelAttribute("form") MarksheetForm form,Model model , Locale locale)
	{
		
		String enterrollno=messageSource.getMessage("label.enterrollno",null,locale);
		model.addAttribute("enterRollNo",enterrollno);
		String entername=messageSource.getMessage("label.studentName",null,locale);
		model.addAttribute("enterName",entername);
		
		int pageNo = (form.getPageNo()==0) ? 1: form.getPageNo();
		
		int pageSize = form.getPageSize();
		
		List list = null;
		List next = null;
		
		MarksheetDTO dto = (MarksheetDTO) form.getDto();
		
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
		   if(form.getChk_1()!=null)
		   {
			   for(long id:form.getChk_1()){
	    			mservice.delete(id);
	    		}
			   String msg = messageSource.getMessage("message.deleterecord", null, locale);
				model.addAttribute("success", msg);
	    	}else {
	    		String msg = messageSource.getMessage("message.atleastone", null, locale);
				model.addAttribute("error", msg);
	    	}
		}
		if(OP_RESET.equalsIgnoreCase(operation))
		{
			return "redirect:/ctl/Marksheet/MarksheetListCtl";
		}
		if(OP_NEW.equalsIgnoreCase(operation))
		{
			return "redirect:/ctl/Marksheet/AddMarksheet";
		}
		
		 if(OP_BACK.equalsIgnoreCase(operation)){
			 return "redirect:/ctl/Marksheet/MarksheetListCtl";
	        }
		
		form.setPageNo(pageNo);
		list = mservice.search(dto, pageNo, pageSize);
		
		if(list.size()==0 && !OP_DELETE.equalsIgnoreCase(operation))
		{
		  model.addAttribute("error",messageSource.getMessage("message.norecord", null, locale));	
		}
		
		next = mservice.search(dto, pageNo+1, pageSize);
		
		model.addAttribute("list",list);
		model.addAttribute("nextlistsize", next.size());
		
		return "MarksheetListView";
	}
	
}

