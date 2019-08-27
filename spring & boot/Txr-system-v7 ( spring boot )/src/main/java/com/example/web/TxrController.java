package com.example.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.service.TxrService;

@Controller
public class TxrController {

	@Autowired
	private TxrService txrService;

	@GetMapping("/txr")
	public String txrForm() {
		return "txr-form";
	}

	@PostMapping("/txr")
	public String txrForm(@ModelAttribute TxrRequest request, Model model) {
		txrService.txr(request.getAmount(), request.getFromAccNum(), request.getToAccNum());
		TxrResponse response = new TxrResponse();
		response.setStatus("Txr success");
		model.addAttribute("response", response);
		return "txr-status";
	}

}
