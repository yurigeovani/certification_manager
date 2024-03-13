package com.ygtech.certification_manager.modules.students.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionAnswerDTO {

	private UUID questionId;
	private UUID alternativeId;
	private boolean isCorrect;
}
