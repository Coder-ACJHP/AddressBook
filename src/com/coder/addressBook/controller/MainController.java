package com.coder.addressBook.controller;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.coder.addressBook.Service.ServiceDao;
import com.coder.addressBook.entity.Address;

@Controller
public class MainController {

	@Autowired
	private ServiceDao serviceDao;
	
	@Value("#{countriesOption}")
	private Map<String, String> countriesOption;

	@GetMapping("/")
	public String welcomeToHome() {
		return "home";
	}

	@GetMapping("/allAddressess")
	public String goToListPage(Model model) {

		List<Address> addressesList = serviceDao.findAllAddresses();
		model.addAttribute("addressList", addressesList);

		return "table";
	}

	@GetMapping("addAddress")
	public String addAddress(Model model) {

		if(!model.containsAttribute("address")) {
			final Map<String, String> treemap = new TreeMap<String, String>(countriesOption);
			model.addAttribute("address", new Address());
			model.addAttribute("theCountryOptions", treemap);
		}
		return "address-form";
	}

	@PostMapping("/addProcess")
	public String saveAddress(@Valid @ModelAttribute("address") final Address address, final BindingResult bindingResult,
			final RedirectAttributes redirectAttributes) {
		
		if (bindingResult.hasErrors()) {
			
			redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.address", bindingResult);
			redirectAttributes.addFlashAttribute("address", new Address());
			final Map<String, String> treemap = new TreeMap<String, String>(countriesOption);
			redirectAttributes.addFlashAttribute("theCountryOptions", treemap);
			
			return "redirect:/addAddress";
		}
		
		serviceDao.save(address);
		return "redirect:allAddressess";
	}
	
	@GetMapping("/editAddress")
	public String editAddress(@RequestParam("addressId") int Id, Model model) {

		if (Id > 0) {
			Address theAddress = serviceDao.findAddressById(Id);
			model.addAttribute("address", theAddress);
			
			final Map<String, String> treemap = new TreeMap<String, String>(countriesOption);
			model.addAttribute("theCountryOptions", treemap);
		}
		return "update-form";
	}
	
	@PostMapping("/editProcess")
	public String saveAddress(@ModelAttribute("address") final Address address, RedirectAttributes redirectAttributes) {

		serviceDao.save(address);
		redirectAttributes.addFlashAttribute("message", "Your changes saved successfully.");
		return "redirect:allAddressess";
	}

	@GetMapping("deleteAddress")
	public String deleteAddress(@RequestParam("addressId") int Id, RedirectAttributes redirectAttrs) {
		if (Id > 0) {
			serviceDao.deleteAddressById(Id);
			redirectAttrs.addFlashAttribute("message", "Address deleted successfully.");
		}

		return "redirect:allAddressess";
	}

	@PostMapping("search")
	public String search(@RequestParam("word") String wordText, Model model) {

		List<Address> theAddresses = serviceDao.searchAddress(wordText);
		model.addAttribute("addressList", theAddresses);
		return "table";
	}
}
