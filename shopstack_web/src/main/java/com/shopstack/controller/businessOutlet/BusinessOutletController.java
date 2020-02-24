package com.shopstack.controller.businessOutlet;

import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.shopstack.entities.business.BusinessOutlet;
import com.shopstack.service.business.BusinessService;

@Controller
@RequestMapping("/outlet")
public class BusinessOutletController {

	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Autowired
	private BusinessService businessOutletServicesImp;
	
	
	@GetMapping("/show")
	public String showBusinessOutletForm(Model model) {
		
		model.addAttribute("outlet", new BusinessOutlet());
		
		return "businessoutlet-page";
	}
	
	@GetMapping("/processForm")
	public ModelAndView processRegistration(WebRequest request, 
			@ModelAttribute("outlet") @Valid  BusinessOutlet businessOutlet, 
			BindingResult resultBinder, Errors errors) {
		
		System.out.println("save Outlet" + businessOutlet);
		
		BusinessOutlet saveBusinessOutlet = new BusinessOutlet();
		
		
		if(resultBinder.hasErrors()) {
			System.out.println("Requst has errors" + saveBusinessOutlet );
			return new ModelAndView("view-page", "outlet", new BusinessOutlet());
		}
			
		 int outletId = saveBusinessOutlet.getOutletId();
		 
//		businessOutletServicesImp.findOutletById(outletId);
		
		saveBusinessOutlet = businessOutletServicesImp.findOutletById(outletId);
		
		if(saveBusinessOutlet == null) {
			
			logger.info("Outlet not exists");
			
			return new ModelAndView("businessoutlet-page", "outlet", new BusinessOutlet());
		}
		 
		return  new ModelAndView("confirmoutlet-page", "outlet", new BusinessOutlet());
	}
}
