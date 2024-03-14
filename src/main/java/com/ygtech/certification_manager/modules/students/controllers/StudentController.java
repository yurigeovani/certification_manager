package com.ygtech.certification_manager.modules.students.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ygtech.certification_manager.modules.students.dto.StudentCertificationAnswerDTO;
import com.ygtech.certification_manager.modules.students.dto.VerifyHasCertificationDTO;
import com.ygtech.certification_manager.modules.students.useCases.StudentCertificationAnswersUseCase;
import com.ygtech.certification_manager.modules.students.useCases.VerifyIfHasCertificationUseCase;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private VerifyIfHasCertificationUseCase verifyIfHasCertificationUseCase;
	
	@Autowired
	private  StudentCertificationAnswersUseCase studentCertificationAnswersUseCase;

	@PostMapping("/verifyIfHasCertification")
	public String verifyIfHasCertification(@RequestBody VerifyHasCertificationDTO verifyHasCertificationDTO) {
		
		var result = verifyIfHasCertificationUseCase.execute(verifyHasCertificationDTO);
		
		if(result)
			return "The user has already taken the test"; 
		
		return "The user can take the test.";
	}
	
	@PostMapping("/certification/answer")
	public ResponseEntity<Object> certificationAnswer(@RequestBody StudentCertificationAnswerDTO studentCertificationAnswerDTO) {
		
		try {
			var result = this.studentCertificationAnswersUseCase.execute(studentCertificationAnswerDTO);
			return ResponseEntity.ok().body(result);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
