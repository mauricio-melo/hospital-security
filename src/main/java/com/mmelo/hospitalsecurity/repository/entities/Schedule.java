package com.mmelo.hospitalsecurity.repository.entities;

import com.mmelo.hospitalsecurity.repository.commons.Auditable;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "schedule", uniqueConstraints = {@UniqueConstraint(columnNames = {"idt_patient", "idt_time", "date_appointment"})})
public class Schedule extends Auditable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idt_schedule")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="idt_specialty")
	private Specialty specialty;
	
	@ManyToOne
	@JoinColumn(name="idt_doctor")
	private Doctor doctor;
	
	@ManyToOne
	@JoinColumn(name="idt_patient")
	private Patient patient;
	
	@ManyToOne
	@JoinColumn(name="idt_time")
	private Timetable timetable;

	@Column(name="date_appointment", nullable = false)
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dateAppointment;
}
