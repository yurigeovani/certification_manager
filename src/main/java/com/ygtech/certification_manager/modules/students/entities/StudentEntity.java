package com.ygtech.certification_manager.modules.students.entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //Cria getters e setters de todos os atributos
@AllArgsConstructor //Cria um construtor com todos os atributos
@NoArgsConstructor //Cria um construtor vazio
@Entity(name="students") //Converte a classe tem tabela
@Builder
public class StudentEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.UUID)
	private UUID id;
	
	@Column(unique = true, nullable = false)
	private String email;
	
	@OneToMany(mappedBy = "studentEntity")
	@JsonBackReference
	private List<CertificationStudentEntity> certificationStudentEntity;
	
	@CreationTimestamp
	private LocalDateTime createdAt;	
}
