package com.mmelo.hospitalsecurity.repository.entities;

import com.mmelo.hospitalsecurity.repository.commons.Auditable;
import lombok.*;

import javax.persistence.*;
import java.time.LocalTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "timetable")
public class Timetable extends Auditable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idt_timetable")
	private Long id;
	
	@Column(name = "hours", unique = true, nullable = false)
	private LocalTime hours;
}
