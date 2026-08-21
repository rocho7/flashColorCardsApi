package com.flashcolorcard.springboot.app.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CardDto {

    @NotNull
    @Min(value = 0)
    private Long idSet;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 500)
    private String title;

    @NotNull
    @Min(value = 0)
    private Integer review;

    @NotNull
    @Min(value = 0)
    private Integer forgotten;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 500)
    private String answer;

    private Long delay;

    @NotNull
//    @Max(value = 20)
    private  String color;

}
