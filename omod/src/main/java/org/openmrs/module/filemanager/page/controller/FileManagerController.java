package org.openmrs.module.filemanager.page.controller;

import org.openmrs.web.WebConstants;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * User: harsha
 * Date: 10/7/13
 * Time: 12:39 AM
 * To change this template use File | Settings | File Templates.
 */
public class FileManagerController {

    public String post(HttpServletRequest request) {
        String description=request.getParameter("description");
        String fileType=request.getParameter("type");

        if (request instanceof MultipartHttpServletRequest) {
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            MultipartFile file             = (MultipartFile) multipartRequest.getFile("file");

            if (!file.isEmpty()) {
                if (file.getSize() <= 5242880) {
                    if (file.getOriginalFilename().endsWith(".jpeg") || file.getOriginalFilename().endsWith(".jpg")
                            || file.getOriginalFilename().endsWith(".gif")
                            || file.getOriginalFilename().endsWith(".png")) {
                    } else {

                    }
                }
            }
        }
        return "redirect:helloworldapp/helloworld.page";
    }
}
