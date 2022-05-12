package com.telcel.examenws.repository;

import com.telcel.examenws.model.LineaTelefonica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface LineaTelefonicaRepoository extends JpaRepository<LineaTelefonica, Long> {

    @Query(value = "SELECT * FROM LINEA_TELEFONICA T WHERE T.NUMERO_TELEFONICO = :numero", nativeQuery = true)
    LineaTelefonica getByNumeroTelefonico(@Param("numero") String numeroTelefonico);
}
