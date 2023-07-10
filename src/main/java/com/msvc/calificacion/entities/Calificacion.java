package com.msvc.calificacion.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "calificaciones")
public class Calificacion {

    @Id
    private String id;
    private String usuarioId;
    private String hotelId;
    private String calificacion;
    private String observacion;

}
