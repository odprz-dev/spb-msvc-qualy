package com.msvc.calificacion.services;

import com.msvc.calificacion.entities.Calificacion;
import com.msvc.calificacion.repositories.CalificacionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class CalificacionServiceImp implements CalificacionService {

    private static Logger logger = Logger.getLogger(CalificacionServiceImp.class.getName());
    private final CalificacionRepository calificacionRepository;

    public CalificacionServiceImp(CalificacionRepository calificacionRepository) {
        this.calificacionRepository = calificacionRepository;
    }

    @Override
    public List<Calificacion> findAll() {
        return calificacionRepository.findAll();
    }

    @Override
    public Calificacion findById(String id) {
        return calificacionRepository.findById(id).orElse(null);
    }


    @Override
    public Calificacion save(Calificacion calificacion) {
        return calificacionRepository.save(calificacion);
    }

    @Override
    public List<Calificacion> findByHotelId(String hotelId) {
        return calificacionRepository.findCalificacionByHotelId(hotelId);
    }

    @Override
    public List<Calificacion> findByUsuarioId(String usuarioId) {
        return calificacionRepository.findCalificacionByUsuarioId(usuarioId);
    }

    @Override
    public Calificacion update(String id, Calificacion calificacion) {
        Calificacion calificacionUpdate = calificacionRepository.findById(id).orElse(null);

        if (calificacionUpdate != null) {
            calificacionUpdate.setHotelId(calificacion.getHotelId());
            calificacionUpdate.setUsuarioId(calificacion.getUsuarioId());
            calificacionUpdate.setCalificacion(calificacion.getCalificacion());

            return calificacionRepository.save(calificacionUpdate);
        }

        //TODO: @odprz implementar excepcion no existe elemento
        return calificacionRepository.save(calificacion);
    }

    @Override
    public void delete(String id) {
        calificacionRepository.findById(id).ifPresent(calificacionRepository::delete);
        //TODO: @odprz implementar excepcion no existe elemento
    }
}
