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
@Table(name = "doctor")
public class Doctor extends Auditable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idt_doctor")
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "crm", unique = true, nullable = false)
	private Integer crm;

	@JsonIgnore
	@OneToMany(mappedBy = "doctor")
	private List<DoctorSpecialty> doctorSpecialities;
	
	@OneToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "idt_user")
	private User user;
}
