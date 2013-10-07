/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.filemanager.api.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.ConceptComplex;
import org.openmrs.Location;
import org.openmrs.Obs;
import org.openmrs.Patient;
import org.openmrs.Person;
import org.openmrs.Visit;
import org.openmrs.api.context.Context;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.filemanager.api.FileManagerService;
import org.openmrs.module.filemanager.api.db.FileManagerDAO;
import org.openmrs.obs.ComplexData;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * It is a default implementation of {@link FileManagerService}.
 */
public class FileManagerServiceImpl extends BaseOpenmrsService implements FileManagerService {

	protected final Log log = LogFactory.getLog(this.getClass());

	private FileManagerDAO dao;

	/**
	 * @param dao the dao to set
	 */
	public void setDao(FileManagerDAO dao) {
		this.dao = dao;
	}

	/**
	 * @return the dao
	 */
	public FileManagerDAO getDao() {
		return dao;
	}

	public void saveComplexObs(Patient patient, Visit visit, MultipartFile file, String description, String type) throws IOException {

<<<<<<< HEAD
        Encounter encounter=new Encounter();
        encounter.setEncounterDatetime(new Date());

        ConceptComplex conceptComplex = Context.getConceptService().getConceptComplex(246);
        // this is assumed to have happened
        // conceptComplex.setHandler("ImageHandler");
        Patient patient1=Context.getPatientService().getPatientByUuid("cf35bf16-2d28-4433-a0da-fe1fae6d6085");
        // Set the required properties.
        Obs obs = new Obs(patient1, conceptComplex, new Date(), new Location());

        BufferedImage img = ImageIO.read(new File("/home/harsha/Downloads/me.jpg"));

        //BufferedImage img = ImageIO.read(file);
=======
ConceptComplex conceptComplex = Context.getConceptService().getConceptComplex(1867);
		// this is assumed to have happened
		// conceptComplex.setHandler("ImageHandler");

		// Set the required properties.
		Obs obs = new Obs(new Person(48609), conceptComplex, new Date(), new Location());

		BufferedImage img = ImageIO.read(new File("/home/bmckown/Desktop/test/logo.png"));
>>>>>>> 2029ebc5e2e43cc66d998c9119ec71cc5c78caee

		// or:
		// InputStream img = new FileInputStream(new File("folder", "filename"));

<<<<<<< HEAD
        ComplexData complexData = new ComplexData(file.getName(), img);

        obs.setComplexData(complexData);

        Context.getObsService().saveObs(obs, null);

        encounter.addObs(obs);

    }
=======
		ComplexData complexData = new ComplexData("test-image.jpg", img);
		obs.setComplexData(complexData);

		Context.getObsService().saveObs(obs, null);
	}
>>>>>>> 2029ebc5e2e43cc66d998c9119ec71cc5c78caee

}