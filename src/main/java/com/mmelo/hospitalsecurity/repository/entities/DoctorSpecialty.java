package com.mmelo.hospitalsecurity.repository.entities;

import com.mmelo.hospitalsecurity.repository.commons.Auditable;
import lombok.*;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "doctor_specialty", uniqueConstraints = {@UniqueConstraint(columnNames = {"idt_doctor", "idt_speciality"})})

public class DoctorSpecialty extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idt_doctor_specialty")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idt_doctor")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "idt_speciality")
    private Specialty specialty;
}
