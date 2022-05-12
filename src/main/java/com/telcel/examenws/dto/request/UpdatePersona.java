package com.telcel.examenws.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePersona implements Serializable {

    private String numero;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;

}
