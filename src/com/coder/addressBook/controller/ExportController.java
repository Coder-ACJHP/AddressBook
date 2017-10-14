package com.coder.addressBook.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.coder.addressBook.Service.ServiceDao;
import com.coder.addressBook.entity.Address;
import com.google.gson.Gson;

@Controller
public class ExportController {

	
	@Autowired
	private ServiceDao serviceDao;
	
	@GetMapping("saveAsJson")
	public void saveAsJson(final HttpServletResponse response, final RedirectAttributes redirectAttributes) {
		
		cookFileToDownload("json", response, redirectAttributes);
	}
	
	private void cookFileToDownload(String FILE_TYPE, HttpServletResponse response,
												RedirectAttributes redirectAttributes) {
		
		final List<Address> addressList = serviceDao.findAllAddresses();
		final Gson gson = new Gson();
		
		InputStream inputStream = null;
		OutputStream outputStream = null;
		
		try {
			
			String lastJson = gson.toJson(addressList);
			response.setContentType("application/octet-stream");
			response.setHeader("Content-Disposition", String.format("inline; filename=\"AddressBook."+FILE_TYPE+"\""));
			response.setContentLength(lastJson.length());
			
			inputStream = new ByteArrayInputStream(lastJson.getBytes());
			outputStream = response.getOutputStream();
			IOUtils.copy(inputStream, outputStream);
			IOUtils.closeQuietly(inputStream);	
			
		} catch (IOException e) {
			redirectAttributes.addFlashAttribute("error", e.getMessage());
			
		} finally {
			try {
				
				response.getOutputStream().flush();
				response.getOutputStream().close();
				outputStream.close();
				
			} catch (IOException e) {
				redirectAttributes.addFlashAttribute("error", e.getMessage());
			}
		}
	}
}
