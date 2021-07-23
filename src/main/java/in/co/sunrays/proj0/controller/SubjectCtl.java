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

import in.co.sunrays.proj0.dto.SubjectDTO;
import in.co.sunrays.proj0.exception.DuplicateRecordException;
import in.co.sunrays.proj0.form.SubjectForm;
import in.co.sunrays.proj0.service.CourseServiceInt;
import in.co.sunrays.proj0.service.SubjectServiceInt;

// TODO: Auto-generated Javadoc
/**
 * The Class SubjectCtl.
 */
@Controller
@RequestMapping(value="/ctl/Subject")
public class SubjectCtl extends BaseCtl
{
   
   /** The service. */
   @Autowired
	private SubjectServiceInt service;
   
   /** The cservice. */
   @Autowired
   private CourseServiceInt cservice;
   
   /** The message source. */
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
   
   /* (non-Javadoc)
    * @see in.co.sunrays.proj0.controller.BaseCtl#preload(org.springframework.ui.Model)
    */
   @Override
	public void preload(Model model) 
    {
	 List list = cservice.search(null);
	 model.addAttribute("courseList",list);
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
   @RequestMapping(value="/AddSubject" , method=RequestMethod.GET)
   public String display(@RequestParam(required=false) Long id , @ModelAttribute("form") SubjectForm form , Model model,Locale locale)
   {
	   String entername=messageSource.getMessage("label.entersubjectname",null,locale);
		model.addAttribute("enterName",entername);
		String enterdescription=messageSource.getMessage("label.enterdescription",null,locale);
		model.addAttribute("enterdescription",enterdescription);
	   
	   if(id!=null && id>0)
	   {
		 SubjectDTO dto = service.findById(id);
		 form.populate(dto);
	   }
	   
	return "SubjectView";
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
   @RequestMapping(value="/AddSubject" , method=RequestMethod.POST)
   public String submit(@ModelAttribute("form") @Valid SubjectForm form , BindingResult result , Model model , Locale locale) throws DuplicateRecordException
   {
	   String entername=messageSource.getMessage("label.entersubjectname",null,locale);
		model.addAttribute("enterName",entername);
		String enterdescription=messageSource.getMessage("label.enterdescription",null,locale);
		model.addAttribute("enterdescription",enterdescription);
	   
	   if(OP_SAVE.equalsIgnoreCase(form.getOperation()))
	   {
		   if(result.hasErrors())
		   {
			   return "SubjectView";
		   }
		   
		   SubjectDTO dto = (SubjectDTO)form.getDto();
		   dto.setCreatedBy("root");
		   dto.setModifiedBy("root");
		   
		   if(dto.getId()>0)
		   {
			   service.update(dto);
			   String msg = messageSource.getMessage("message.updatesuccess", null,locale);
		       model.addAttribute("success", msg);
		   }else
		   {
				try {
					service.add(dto);
					String msg = messageSource.getMessage("message.success", null,locale);
				    model.addAttribute("success", msg);
				} catch (DuplicateRecordException e) {
					String msg = messageSource.getMessage("error.subjectname", null,locale);
				    model.addAttribute("error", msg);
				} 
		   }
	   }
	   if(OP_CANCEL.equalsIgnoreCase(form.getOperation()))
	   {
		   return "redirect:/ctl/Subject/SubjectListCtl";
	   }
	   if(OP_RESET.equalsIgnoreCase(form.getOperation()))
	   {
		   return "redirect:/ctl/Subject/AddSubject";
	   }
	  return "SubjectView";   
   }
   
   /**
    * Display.
    *
    * @param form the form
    * @param model the model
    * @param locale the locale
    * @return the string
    */
   @RequestMapping(value="/SubjectListCtl" , method=RequestMethod.GET)
   public String display(@ModelAttribute("form") SubjectForm form , Model model , Locale locale)
   {
	   String enterName = messageSource.getMessage("label.entercoursename", null, locale);
	   model.addAttribute("enterName",enterName);
	   
	   int pageNo=1;
	   
	   List list = service.search(new SubjectDTO(), pageNo, form.getPageSize());
	   model.addAttribute("list",list);
	   
	   List next = service.search(new SubjectDTO(), pageNo+1, form.getPageSize());
	   model.addAttribute("nextlistsize",next.size());
	   
	return "SubjectListView";
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
   @RequestMapping(value="/SubjectListCtl" , method=RequestMethod.POST)
   public String submit(@RequestParam(required=false) String operation,@ModelAttribute("form") SubjectForm form,Model model,Locale locale)
   {
	   String enterName = messageSource.getMessage("label.entercoursename", null, locale);
	   model.addAttribute("enterName",enterName);
	   
	   int pageNo = (form.getPageNo()==0)?1:form.getPageNo();
	   int pageSize = form.getPageSize();
	   
	   form.setPageNo(pageNo);
	   
	   List list = null;
	   List next = null;
	   
	   SubjectDTO dto = (SubjectDTO) form.getDto();
	   
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
		   if(form.getChk_1() != null)
		   {
			   for(Long id : form.getChk_1())
			   {
				   service.delete(id);
			   }
			   String msg = messageSource.getMessage("message.deleterecord", null, locale);
				model.addAttribute("success", msg);
			} else {
				String msg = messageSource.getMessage("message.atleastone", null, locale);
				model.addAttribute("error", msg);
			}
	   }
	   if(OP_NEW.equalsIgnoreCase(operation))
	   {
		   return "redirect:/ctl/Subject/AddSubject";
	   }
	   if(OP_RESET.equalsIgnoreCase(operation))
	   {
		   return "redirect:/ctl/Subject/SubjectListCtl";
	   }
	   if(OP_BACK.equalsIgnoreCase(operation)){
			 return "redirect:/ctl/Subject/SubjectListCtl";
	        }
		
	   
	   form.setPageNo(pageNo);
	    list = service.search(dto, pageNo, form.getPageSize());
		model.addAttribute("list", list);
		
		 next = service.search(dto, pageNo + 1, form.getPageSize());
		model.addAttribute("nextlistsize", next.size());
		
		if (list.size() == 0 && !OP_DELETE.equalsIgnoreCase(operation))
		{
			model.addAttribute("error", messageSource.getMessage("message.norecord", null, locale));
		}
	   
	return "SubjectListView";
   }
   
   
}

