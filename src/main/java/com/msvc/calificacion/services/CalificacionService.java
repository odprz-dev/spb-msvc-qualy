package com.msvc.calificacion.services;

import com.msvc.calificacion.entities.Calificacion;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CalificacionService {

    List<Calificacion> findAll();

    Calificacion findById(String id);

    Calificacion save(Calificacion calificacion);

    List<Calificacion> findByHotelId(String hotelId);

    List<Calificacion> findByUsuarioId(String usuarioId);

    Calificacion update(String id, Calificacion calificacion);

    void delete(String id);


}
