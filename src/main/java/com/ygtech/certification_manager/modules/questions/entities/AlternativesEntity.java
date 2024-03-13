package com.ygtech.certification_manager.modules.questions.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="alternatives")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlternativesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	private String description;
	
//	@Id
//	@Column(name="question_id")
//	private UUID questionId;
//	
//	@ManyToOne
//	@JoinColumn(name = "question_id", insertable = false, updatable = false)
//	private QuestionEntity questionEntity;
	
	private boolean isCorrect;
	
	@CreationTimestamp
	private LocalDateTime createdAt;
	
}
