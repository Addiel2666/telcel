package com.telcel.examenws.repository;

import com.telcel.examenws.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface TelecelRepository extends JpaRepository<Persona,Long> {
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE PERSONA SET NOMBRE = :nombre, APELLIDO_PATERNO=:apPaterno, APELLIDO_MATERNO=:apMaterno WHERE ID = :id", nativeQuery = true)
    void actualizaDatos(@Param("id") long id, @Param("nombre") String nombre, @Param("apPaterno")String apellidoPaterno, @Param("apMaterno")String apellidoMaterno);
}
