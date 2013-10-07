package org.openmrs.module.filemanager.page.controller;


import org.openmrs.Location;
import org.openmrs.Patient;
import org.openmrs.api.LocationService;
import org.openmrs.ui.framework.UiUtils;
import org.openmrs.ui.framework.annotation.InjectBeans;
import org.openmrs.ui.framework.annotation.SpringBean;
import org.openmrs.ui.framework.page.PageModel;
import org.openmrs.ui.framework.page.Redirect;
import org.openmrs.web.WebConstants;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.FileOutputStream;

/**
 * Created with IntelliJ IDEA.
 * User: gitahi
 * Date: 10/7/13
 * Time: 1:22 AM
 * To change this template use File | Settings | File Templates.
 */
public class UploadPageController {

	public String post(@RequestParam(value = "patientId", required = false) Patient patient,
					   @RequestParam(value = "returnUrl", required = false) String returnUrl,
					   UiUtils ui,
					   HttpServletRequest request, PageModel model) {
		if (request instanceof MultipartHttpServletRequest) {
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			MultipartFile file = multipartRequest.getFile("file");
			if (!file.isEmpty()) {
				if (file.getSize() <= 5242880) {
					try {
						FileOutputStream fos = new FileOutputStream("/home/gitahi/aaaaa2.jpg");
						fos.write(file.getBytes());
						fos.close();
					} catch (Exception ex) {

					}
				} else {
					request.getSession().setAttribute(WebConstants.OPENMRS_ERROR_ATTR,
							"feedback.notification.feedback.error");
					return null;
				}
			}
		}
		return null;
	}
}
