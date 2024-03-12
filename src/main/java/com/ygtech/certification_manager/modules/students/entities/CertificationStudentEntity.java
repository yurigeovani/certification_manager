package com.ygtech.certification_manager.modules.students.entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //Cria getters e setters de todos os atributos
@AllArgsConstructor //Cria um construtor com todos os atributos
@NoArgsConstructor //Cria um construtor vazio
@Entity(name="certifications")
public class CertificationStudentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@Column(length = 100)
	private String technology;

	@Column(length = 10)
	private Double grade;

	@JoinColumn(name="student_id")
	private UUID studentID;
	
	@ManyToOne
	@JoinColumn(name="student_id", insertable = false, updatable = false)
	private StudentEntity studentEntity;
	
	//@OneToMany(mappedBy = "certificationStudentEntity") - minha resolução
	@OneToMany
	@JoinColumn(name="answer_certification_id", insertable = false, updatable = false)
	List<AnswerCertificationsEntity> answerCertificationsEntity;
	
	@CreationTimestamp
	private LocalDateTime createdAt;
}
