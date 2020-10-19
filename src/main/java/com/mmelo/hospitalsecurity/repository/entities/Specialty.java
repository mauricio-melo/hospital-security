package com.mmelo.hospitalsecurity.repository.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mmelo.hospitalsecurity.repository.commons.Auditable;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "specialty")
public class Specialty extends Auditable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idt_specialty")
	private Long id;

	@Column(name = "title", unique = true, nullable = false)
	private String title;
	
	@Column(name = "description", nullable = false)
	private String description;

	@JsonIgnore
	@OneToMany(mappedBy = "specialty")
	private List<DoctorSpecialty> doctorSpecialities;
}
