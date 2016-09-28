package com.organization.applicationname;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.organization.applicationname.entities.SampleEntity;
import com.organization.applicationname.services.SampleService;
import com.organization.applicationname.valueobjects.EntityVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	SampleService sampleService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);
		sampleService.sampleSave();
		return "home";
	}

	@RequestMapping(value = "/getSampleEntity", method = RequestMethod.GET)
	@ResponseBody
	public EntityVO menuItems() {
		EntityVO entityVO = new EntityVO();
		entityVO.setId(1);
		entityVO.setName("Sample Name");
		return entityVO;
	}

	@RequestMapping(value = "/getAllSampleEntities", method = RequestMethod.GET)
	@ResponseBody
	public List<SampleEntity> getAllMenuItems() {
		return sampleService.getAllSampleEntities();
	}
}
