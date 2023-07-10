package com.msvc.calificacion.repositories;

import com.msvc.calificacion.entities.Calificacion;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CalificacionRepository extends MongoRepository<Calificacion, String> {

    List<Calificacion> findCalificacionByHotelId(String hotelId);

    List<Calificacion> findCalificacionByUsuarioId(String usuarioId);
}
