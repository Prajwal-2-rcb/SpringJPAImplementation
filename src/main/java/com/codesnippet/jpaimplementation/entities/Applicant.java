package com.codesnippet.jpaimplementation.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Applicant {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    private String name;

    private String email;

    private String phone;

    private String status;

    @OneToOne(mappedBy = "applicant", cascade = CascadeType.ALL)
    //here first resume get added then applicant added for that we need to use cascade
    private Resume resume;
    //Adding a resume while adding Applicant itself
    //If we not used this we need to add a résumé separately
}
