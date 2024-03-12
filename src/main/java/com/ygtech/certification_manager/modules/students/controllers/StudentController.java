package com.ygtech.certification_manager.modules.students.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ygtech.certification_manager.modules.students.dto.VerifyHasCertificationDTO;

@RestController
@RequestMapping("/students")
public class StudentController {

	@PostMapping("/verifyIfHasCertification")
	public String verifyIfHasCertification(@RequestBody VerifyHasCertificationDTO verifyHasCertificationDTO) {
		return verifyHasCertificationDTO.toString();
	}
}
