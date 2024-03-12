package com.ygtech.certification_manager.modules.students.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ygtech.certification_manager.modules.students.dto.VerifyHasCertificationDTO;
import com.ygtech.certification_manager.modules.students.useCases.VerifyIfHasCertificationUseCase;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private VerifyIfHasCertificationUseCase verifyIfHasCertificationUseCase;

	@PostMapping("/verifyIfHasCertification")
	public String verifyIfHasCertification(@RequestBody VerifyHasCertificationDTO verifyHasCertificationDTO) {
		
		var result = verifyIfHasCertificationUseCase.execute(verifyHasCertificationDTO);
		
		if(result)
			return "The user has already taken the test"; 
		
		return "The user can take the test.";
	}
}
