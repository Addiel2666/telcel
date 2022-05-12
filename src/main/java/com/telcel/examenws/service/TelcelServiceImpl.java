package com.telcel.examenws.service;

import com.telcel.examenws.dto.request.LineaRequest;
import com.telcel.examenws.dto.request.PersonaRequest;
import com.telcel.examenws.dto.request.UpdatePersona;
import com.telcel.examenws.dto.response.ResponseGeneric;
import com.telcel.examenws.model.LineaTelefonica;
import com.telcel.examenws.model.Persona;
import com.telcel.examenws.repository.LineaTelefonicaRepoository;
import com.telcel.examenws.repository.TelecelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class TelcelServiceImpl implements ITelcelService{

    @Autowired
    TelecelRepository repository;

    @Autowired
    LineaTelefonicaRepoository repoositoryL;

    public ResponseEntity<?> altaPersosna(PersonaRequest request) {
        Persona persona = new Persona();
        ResponseGeneric generic;
        try {
            persona.setId(new Date().getTime());
            persona.setNombre(request.getNombre());
            persona.setApellidoMaterno(request.getApeMaterno());
            persona.setApellidoPaterno(request.getApePaterno());
            repository.save(persona);
            generic = new ResponseGeneric(200,"Exito");
            return new ResponseEntity<>(generic, HttpStatus.OK);
        }catch (Exception e){
            generic = new ResponseGeneric(500,"Error "+e.getMessage());
            return new ResponseEntity<>(generic, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> altaLinea(LineaRequest request) {
        LineaTelefonica lineaTelefonica ;
        ResponseGeneric generic;
        try {
            Optional<Persona> persona = repository.findById(request.getPersona());
            lineaTelefonica = new LineaTelefonica();
            lineaTelefonica.setId(new Date().getTime());
            lineaTelefonica.setFacebook(request.getFacebook());
            lineaTelefonica.setLlamadas(request.getLlamadas());
            lineaTelefonica.setSms(request.getSms());
            lineaTelefonica.setWhatsapp(request.getWhatsapp());
            lineaTelefonica.setNumeroTelefonico(request.getNumeroTelefonico());
            lineaTelefonica.setPersona(persona.get());
            repoositoryL.save(lineaTelefonica);
            generic = new ResponseGeneric(200,"Exito");
            return new ResponseEntity<>(generic, HttpStatus.OK);
        }catch (Exception e){
            generic = new ResponseGeneric(500,"Error "+e.getMessage());
            return new ResponseEntity<>(generic, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> actualizaApellidos(UpdatePersona request) {
        ResponseGeneric generic;
        try {
            LineaTelefonica lineaTelefonica = repoositoryL.getByNumeroTelefonico(request.getNumero());
            Persona persona = repository.getById(lineaTelefonica.getPersona().getId());
            persona.setNombre(request.getNombre());
            persona.setApellidoPaterno(request.getApellidoPaterno());
            persona.setApellidoMaterno(request.getApellidoMaterno());
            repository.actualizaDatos(persona.getId(),persona.getNombre(), persona.getApellidoPaterno(), persona.getApellidoMaterno());
            generic = new ResponseGeneric(200,"Exito");
            return new ResponseEntity<>(generic, HttpStatus.OK);
        }catch(Exception e){
            generic = new ResponseGeneric(500,"Error "+e.getMessage());
            return new ResponseEntity<>(generic, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    public ResponseEntity<?> eliminaLinea(LineaRequest request) {
        ResponseGeneric generic;
        try {
            LineaTelefonica lineaTelefonica = repoositoryL.getByNumeroTelefonico(request.getNumeroTelefonico());
        repoositoryL.delete(lineaTelefonica);
            generic = new ResponseGeneric(200,"Exito");
            return new ResponseEntity<>(generic, HttpStatus.OK);
        }catch (Exception e){
            generic = new ResponseGeneric(500,"Error "+e.getMessage());
            return new ResponseEntity<>(generic, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
