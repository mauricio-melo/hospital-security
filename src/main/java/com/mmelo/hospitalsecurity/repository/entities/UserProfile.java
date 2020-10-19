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
@Table(name = "user_profile", uniqueConstraints = {@UniqueConstraint(columnNames = {"idt_user", "idt_profile"})})
public class UserProfile extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idt_user_profile")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idt_user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "idt_profile")
    private Profile profile;
}
