package com.ygtech.certification_manager.modules.students.entities;

import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //Cria getters e setters de todos os atributos
@AllArgsConstructor //Cria um construtor com todos os atributos
@NoArgsConstructor //Cria um construtor vazio
public class StudentEntity {

	private UUID id;
	private String email;
	private List<CertificationStudentEntity> certificationStudentEntity;
	
}
