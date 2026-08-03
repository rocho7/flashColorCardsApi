package com.flashcolorcard.springboot.app.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CardDto {

    @NotNull
    @Min(value = 0)
    private Long idSet;

    @NotNull
    @Size(min = 1, max = 500)
    private String title;

    @NotNull
    @Min(value = 0)
    private Integer review;

    @NotNull
    @Min(value = 0)
    private Integer forgotten;

    @NotNull
    @Size(min = 1, max = 500)
    private String answer;

    private Long delay;

    @NotNull
    @Size(min = 1, max = 20)
    private  String color;

}
