package com.telcel.examenws.controller;

import com.telcel.examenws.dto.request.LineaRequest;
import com.telcel.examenws.dto.request.PersonaRequest;
import com.telcel.examenws.dto.request.UpdatePersona;
import com.telcel.examenws.service.ITelcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/linea")
public class TelcelController{

    @Autowired
    ITelcelService service;

    @PostMapping("/persona")
    public ResponseEntity<?> altaPersona(@RequestBody PersonaRequest request){
        return service.altaPersosna(request);
    }

    @PostMapping("/telcel")
    public ResponseEntity<?> linea(@RequestBody LineaRequest request){
        return service.altaLinea(request);
    }

    @PutMapping("/persona")
    public ResponseEntity<?> actualiza(@RequestBody UpdatePersona request){
        return service.actualizaApellidos(request);
    }

    @DeleteMapping("/telcel")
    public ResponseEntity<?> elimina(@RequestBody LineaRequest request){
        return service.eliminaLinea(request);
    }
}
