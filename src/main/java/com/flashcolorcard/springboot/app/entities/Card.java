package com.flashcolorcard.springboot.app.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "card")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(name = "id_set")
//    private Long idSet;

    private String title;

    private Integer review;

    private Integer forgotten;

    private LocalDate date;

    private String answer;

    private Long delay;

    private  String color;

    @ManyToOne
    @JoinColumn(name = "id_set")
    @JsonBackReference
    private Sets set;

}
