package com.telcel.examenws.service;

import com.telcel.examenws.dto.request.LineaRequest;
import com.telcel.examenws.dto.request.PersonaRequest;
import com.telcel.examenws.dto.request.UpdatePersona;
import org.springframework.http.ResponseEntity;

public interface ITelcelService {

    public ResponseEntity<?> altaPersosna(PersonaRequest request);

    ResponseEntity<?> altaLinea(LineaRequest request);

    ResponseEntity<?> actualizaApellidos(UpdatePersona request);

    ResponseEntity<?> eliminaLinea(LineaRequest request);
}
