package com.flashcolorcard.springboot.app.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "set")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Sets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(name = "total")
    private Integer total;

    private Integer remain;

//    @Column(name = "id_user")
//    @NotNull
//    private Long idUser;

    @Column(name = "color")
    private String color;

    @ManyToOne
    @JoinColumn(name = "id_user")
    @JsonBackReference
    private User user;

    @OneToMany(mappedBy = "set", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Card> cards = new ArrayList<>();


}
