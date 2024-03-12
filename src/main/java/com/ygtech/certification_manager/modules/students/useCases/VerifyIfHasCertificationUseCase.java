package com.ygtech.certification_manager.modules.students.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ygtech.certification_manager.modules.students.dto.VerifyHasCertificationDTO;
import com.ygtech.certification_manager.modules.students.repositories.CertificationStudentRepository;

@Service
public class VerifyIfHasCertificationUseCase {
	
	@Autowired //necessário quando usa um componente gerenciado pelo Spring
	private CertificationStudentRepository certificationStudentRepository;

	public boolean execute(VerifyHasCertificationDTO dto) {
		var result = this.certificationStudentRepository.findByStudentEmailAndTechnology(dto.getEmail(),dto.getTechnology());
		if(!result.isEmpty()) {
			return true;
		}
		return false;
	}
}
