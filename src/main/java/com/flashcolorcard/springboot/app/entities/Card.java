package com.flashcolorcard.springboot.app.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "card")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_set")
    private Long idSet;

    private String title;

    private Integer review;

    private Integer forgotten;

    private LocalDate date;

    private String answer;

    private Long delay;

    private  String color;

}
