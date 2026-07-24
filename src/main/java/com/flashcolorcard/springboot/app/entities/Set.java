package com.flashcolorcard.springboot.app.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "set")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Set {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(name = "total")
    private Integer total;

    private Integer remain;

    @Column(name = "id_user")
    private Long idUser;

    @Column(name = "color")
    private String color;
}
