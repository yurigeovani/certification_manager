package com.ygtech.certification_manager.modules.questions.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ygtech.certification_manager.modules.questions.dto.AlternativesResultDTO;
import com.ygtech.certification_manager.modules.questions.dto.QuestionResultDTO;
import com.ygtech.certification_manager.modules.questions.entities.AlternativesEntity;
import com.ygtech.certification_manager.modules.questions.entities.QuestionEntity;
import com.ygtech.certification_manager.modules.questions.repositories.QuestionRepository;

@RestController
@RequestMapping("/questions")
public class QuestionController {
	
	@Autowired
	private QuestionRepository questionRepository;

	@GetMapping("/technology/{technology}")
	public List<QuestionResultDTO> findByTechnology(@PathVariable String technology){
		var result = this.questionRepository.findByTechnology(technology);
		
		// stream() = função onde consegue ter acesso às funcionalidades: filter, map
		var toMap = result.stream().map(question -> mapQuestionToDTO(question)).collect(Collectors.toList());
		return toMap;
	}
	
	static QuestionResultDTO mapQuestionToDTO(QuestionEntity question) {
		var questionResultDTO = QuestionResultDTO.builder()
				.id(question.getId())
				.technology(question.getTechnology())
				.description(question.getDescription()).build();
		
		List<AlternativesResultDTO> alternativesResultDTOs = question.getAlternatives().stream().map(alternative -> mapAlternativeDTO(alternative)).collect(Collectors.toList());
		
		questionResultDTO.setAlternativesResultDTOs(alternativesResultDTOs);
		
		return questionResultDTO;
	}
	
	static AlternativesResultDTO mapAlternativeDTO(AlternativesEntity alternativesResultDTO) {
		return AlternativesResultDTO.builder()
				.id(alternativesResultDTO.getId())
				.description(alternativesResultDTO.getDescription())
				.build();
	} 
}
