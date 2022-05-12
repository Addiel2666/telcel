package com.telcel.examenws.dto.request;

import com.telcel.examenws.model.Persona;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LineaRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    private String numeroTelefonico;
    private Integer sms;
    private Integer llamadas;
    private Integer facebook;
    private Integer whatsapp;
    private Long persona;



}
