package com.coder.addressBook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

		Address theAddress = new Address();
		model.addAttribute("address", theAddress);

		return "edit";
	}

	@GetMapping("editAddress")
	public String editAddress(@RequestParam("addressId") int Id, Model model) {

		if (Id > 0) {
			Address theAddress = serviceDao.findAddressById(Id);
			model.addAttribute("address", theAddress);
		}
		return "edit";
	}

	@PostMapping("editProcess")
	public String saveEdit(@ModelAttribute("address") Address address, RedirectAttributes redirectAttrs) {
		if (address != null) {
			serviceDao.save(address);
			redirectAttrs.addFlashAttribute("message", "Address updated or saved successfully.");
		}

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
