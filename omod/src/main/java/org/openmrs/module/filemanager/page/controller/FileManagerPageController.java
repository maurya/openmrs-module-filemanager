package org.openmrs.module.filemanager.page.controller;

import org.openmrs.Patient;
import org.openmrs.module.emrapi.patient.PatientDomainWrapper;
import org.openmrs.ui.framework.annotation.InjectBeans;
import org.openmrs.ui.framework.page.PageModel;
import org.springframework.web.bind.annotation.RequestParam;

public class FileManagerPageController {

    public void controller(@RequestParam("patientId") Patient patient,
                           PageModel model,
                           @InjectBeans PatientDomainWrapper patientDomainWrapper) {
        patientDomainWrapper.setPatient(patient);

        model.addAttribute("patient", patientDomainWrapper);
    }
}