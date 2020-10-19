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
@Table(name = "users")
public class User extends Auditable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idt_user")
	private Long id;
	
	@Column(name = "email", unique = true, nullable = false)
	private String email;
	
	@JsonIgnore
	@Column(name = "password", nullable = false)
	private String password;

	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private List<UserProfile> userProfiles;

	@Builder.Default
	@Column(name = "flg_enabled", nullable = false)
	private boolean enabled = true;
	
	@Column(name = "checker_code", length = 6)
	private String checkerCode;
}
