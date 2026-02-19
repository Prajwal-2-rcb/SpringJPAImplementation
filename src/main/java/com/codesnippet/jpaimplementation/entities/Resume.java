package com.codesnippet.jpaimplementation.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="applicant_id" , nullable = false ,referencedColumnName = "id")
    private Applicant applicant;
}
