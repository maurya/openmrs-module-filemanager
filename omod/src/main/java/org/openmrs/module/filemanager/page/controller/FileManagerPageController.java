package org.openmrs.module.filemanager.page.controller;

import org.openmrs.Person;
import org.openmrs.ui.framework.page.PageModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FileManagerPageController {

	public void controller(PageModel model) {

		List<Person> personList = new ArrayList<Person>();
		for (int i = 1; i <= 10; i++) {
			Person p = new Person();
			p.setPersonId(i);
			p.setBirthdate(new Date());
			p.setGender("Type " + i);
			p.setPersonVoidReason("Link " + i);
			personList.add(p);
		}

//		model.addAttribute("user", sessionContext.getCurrentUser());
		model.addAttribute("files", personList);
//		model.addAttribute("user", "Gitahi wa Ng'ang'a");
	}
}
