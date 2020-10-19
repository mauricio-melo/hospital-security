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
@Table(name = "profile")
public class Profile extends Auditable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idt_profile")
	private Long id;
	
	@Column(name = "description", nullable = false, unique = true)
	private String description;

	@JsonIgnore
	@OneToMany(mappedBy = "profile")
	private List<UserProfile> userProfiles;
}
