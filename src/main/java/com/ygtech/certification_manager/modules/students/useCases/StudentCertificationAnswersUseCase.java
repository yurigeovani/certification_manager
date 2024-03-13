package com.ygtech.certification_manager.modules.students.useCases;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ygtech.certification_manager.modules.questions.entities.QuestionEntity;
import com.ygtech.certification_manager.modules.questions.repositories.QuestionRepository;
import com.ygtech.certification_manager.modules.students.dto.StudentCertificationAnswerDTO;
import com.ygtech.certification_manager.modules.students.entities.CertificationStudentEntity;
import com.ygtech.certification_manager.modules.students.entities.StudentEntity;
import com.ygtech.certification_manager.modules.students.repositories.StudentRepository;

@Service
public class StudentCertificationAnswersUseCase {

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private QuestionRepository questionRepository;

	public StudentCertificationAnswerDTO execute(StudentCertificationAnswerDTO dto) {

		// Buscar as alternativas das perguntas: Correta ou incorreta
		List<QuestionEntity> questionsEntity =  questionRepository.findByTechnology(dto.getTechnology());
		
		dto.getQuestionsAnswers().stream().forEach(questionAnswer -> {
			var question = questionsEntity.stream()
					.filter(q -> q.getId().equals(questionAnswer.getQuestionId()))
					.findFirst().get();
			
			var findCorrectAlternative = question.getAlternatives().stream()
					.filter(alternative -> alternative.isCorrect())
					.findFirst().get();
			
			if(findCorrectAlternative.getId().equals(questionAnswer.getAlternativeId())) {
				questionAnswer.setCorrect(true);
			} else {
				questionAnswer.setCorrect(false);
			}
		});
		
		// Verificar se existe student pelo mail
		var student = studentRepository.findByEmail(dto.getEmail());
		UUID studentID;
		
		if(student.isEmpty()) {
			var studentCreated = StudentEntity.builder().email(dto.getEmail()).build();
			studentCreated = studentRepository.save(studentCreated);
			studentID = studentCreated.getId();
		}else {
			studentID = student.get().getId();
		}
		
		CertificationStudentEntity certificationStudentEntity = CertificationStudentEntity.builder()
				.technology(dto.getTechnology())
				.studentID(studentID)
				.build();
		
		return dto;
		// Salvar as informações da certificação
		
	}
}
