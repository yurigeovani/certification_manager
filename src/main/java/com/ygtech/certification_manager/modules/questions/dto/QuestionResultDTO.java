package com.ygtech.certification_manager.modules.questions.dto;

import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder //facilita na criação dos objetos, não é necessário dizer o tipo, exemplo: QuestionResultDTO question = new QuestionResultDTO . Basta pôr QuestionResultDTO.builder() que já tem acesso às informações 
public class QuestionResultDTO {

	private UUID id;
	private String technology;
	private String description;
	List<AlternativesResultDTO> alternativesResultDTOs;
}
