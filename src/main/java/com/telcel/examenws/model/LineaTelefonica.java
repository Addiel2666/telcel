package com.telcel.examenws.model;

import javax.persistence.*;

@Entity
@Table(name = "LINEA_TELEFONICA")
public class LineaTelefonica {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NUMERO_TELEFONICO")
    private String numeroTelefonico;

    @Column(name = "SMS")
    private Integer sms;

    @Column(name = "LLAMADAS")
    private Integer llamadas;

    @Column(name = "FACEBOOK")
    private Integer facebook;

    @Column(name = "WHATSAPP")
    private Integer whatsapp;

    @ManyToOne
    @JoinColumn(name="PERSONA_ID")
    private Persona persona;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumeroTelefonico() {
        return numeroTelefonico;
    }

    public void setNumeroTelefonico(String numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }

    public Integer getSms() {
        return sms;
    }

    public void setSms(Integer sms) {
        this.sms = sms;
    }

    public Integer getLlamadas() {
        return llamadas;
    }

    public void setLlamadas(Integer llamadas) {
        this.llamadas = llamadas;
    }

    public Integer getFacebook() {
        return facebook;
    }

    public void setFacebook(Integer facebook) {
        this.facebook = facebook;
    }

    public Integer getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(Integer whatsapp) {
        this.whatsapp = whatsapp;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}
