package com.mmelo.hospitalsecurity.repository.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mmelo.hospitalsecurity.repository.commons.Auditable;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "patient")
public class Patient extends Auditable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idt_patient")
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "document", unique = true, nullable = false)
	private String document;

	@Column(name = "birth_date", nullable = false)
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate birthDate;

	@JsonIgnore
	@OneToMany(mappedBy = "patient")
	private List<Schedule> schedules;
	
	@OneToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "idt_user")
	private User user;
}
