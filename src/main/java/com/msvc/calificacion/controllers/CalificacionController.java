package com.msvc.calificacion.controllers;

import com.msvc.calificacion.entities.Calificacion;
import com.msvc.calificacion.services.CalificacionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/v1/calificacion")
public class CalificacionController {

    private final CalificacionService calificacionService;

    CalificacionController(CalificacionService calificacionService) {
        this.calificacionService = calificacionService;
    }


    @GetMapping("")
    public List<Calificacion> getCalificaciones() {
        return calificacionService.findAll();
    }


    @GetMapping("/hotel/{hotelId}")
    public List<Calificacion> getCalificacionesByHotelId(@PathVariable String hotelId) {
        return calificacionService.findByHotelId(hotelId);
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Calificacion> getCalificacionesByUsuarioId(@PathVariable String usuarioId) {
        return calificacionService.findByUsuarioId(usuarioId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCalificacionById(@PathVariable String id) {
        return ResponseEntity.ok(calificacionService.findById(id));
    }

//    @GetMapping("/hotel/{hotelId}/usuario/{usuarioId}")
//    public List<Calificacion> getCalificacionesByHotelIdAndUsuarioId(String hotelId, String usuarioId) {
//        return calificacionService.findByHotelIdAndUsuarioId(hotelId, usuarioId);
//    }
//
//    @GetMapping("/hotel/{hotelId}/promedio")
//    public Double getPromedioCalificacionesByHotelId(String hotelId) {
//        return calificacionService.getPromedioCalificacionesByHotelId(hotelId);
//    }

    @PostMapping("")
    public ResponseEntity<?> saveCalificacion(@RequestBody Calificacion calificacion) {
        Calificacion result = calificacionService.save(calificacion);
        return ResponseEntity.created(URI.create("api/v1/calificacion/" + result.getId())).body(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCalificacion(@PathVariable String id, @RequestBody Calificacion calificacion) {

        return ResponseEntity.ok(calificacionService.update(id, calificacion));
    }

    @DeleteMapping("/{id}")
    public void deleteCalificacion(@PathVariable String id) {
        calificacionService.delete(id);
    }



}
