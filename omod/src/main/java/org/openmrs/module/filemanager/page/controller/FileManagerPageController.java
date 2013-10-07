package org.openmrs.module.filemanager.page.controller;

import org.openmrs.Person;
import org.openmrs.Patient;
import org.openmrs.module.emrapi.patient.PatientDomainWrapper;
import org.openmrs.ui.framework.page.PageModel;
import org.openmrs.ui.framework.annotation.InjectBeans;
import org.openmrs.ui.framework.page.PageModel;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FileManagerPageController {

	public void controller(@RequestParam("patientId") Patient patient,
                           PageModel model,
                           @InjectBeans PatientDomainWrapper patientDomainWrapper) {

		List<Person> personList = new ArrayList<Person>();
		for (int i = 1; i <= 10; i++) {
			Person p = new Person();
			p.setPersonId(i);
			p.setBirthdate(new Date());
			p.setGender("Type " + i);
			p.setPersonVoidReason("Link " + i);
			personList.add(p);
		}

        patientDomainWrapper.setPatient(patient);

        model.addAttribute("patient", patientDomainWrapper);
//		model.addAttribute("user", sessionContext.getCurrentUser());
		model.addAttribute("files", personList);
	}
}