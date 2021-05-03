package de.tekup.loan.invoke.ui.ctrls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import de.tekup.loan.invoke.ui.services.RestClient;
import de.tekup.loan.invoke.ui.services.RestClientFeign;
import de.tekup.loan.invoke.ui.types.CustomerRequest;
import de.tekup.loan.invoke.ui.types.WsResponse;

@Controller
public class CheckController {
	@Autowired
	private RestClient service;
	// another way 
	@Autowired
	private RestClientFeign feignClient;
	
	@GetMapping("/check/customer")
	public String checkForm(Model model) {
		CustomerRequest customerRequest = new CustomerRequest();
		customerRequest.setCibilScore(500);
		model.addAttribute("request", customerRequest);
		
		return "request";
	}

	@PostMapping("/check/customer")
	public String checkResults(@ModelAttribute("request") CustomerRequest request, Model model) {
		//invoke soap service
		//WsResponse response = service.getLoanStatus(request);
		// another way with feign
		WsResponse response = feignClient.consumeByFeign(request);
		model.addAttribute("response", response);
		return "response";
	}

}
