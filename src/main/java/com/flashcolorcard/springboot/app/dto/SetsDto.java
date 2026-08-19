package com.flashcolorcard.springboot.app.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SetsDto {

    @NotNull
    @NotBlank
    @Size(min = 1, max= 500)
    private String title;

    @Min(value = 0)
    private Integer total;

    @Min(value = 0)
    private Integer remain;

    @NotNull
    private Long idUser;

    @NotNull
    @Size(min = 1, max= 10)
    private String color;
}
