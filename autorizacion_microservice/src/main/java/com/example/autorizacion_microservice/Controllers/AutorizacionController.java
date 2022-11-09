package com.example.autorizacion_microservice.Controllers;

import com.example.autorizacion_microservice.Entities.AutorizacionEntity;
import com.example.autorizacion_microservice.Services.AutorizacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
// Server port: 8082
@RestController
@RequestMapping("/autorizacion")
public class AutorizacionController {
    @Autowired
    AutorizacionService autorizacionService;

    @GetMapping("/listar")
    public ResponseEntity<ArrayList<AutorizacionEntity>> getAll(){
        ArrayList<AutorizacionEntity> autorizaciones = autorizacionService.listAll();
        if(autorizaciones.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(autorizaciones);
    }

    @PostMapping
    public ResponseEntity<AutorizacionEntity> add(@RequestBody AutorizacionEntity autorizacion){
        try {
            autorizacionService.add(autorizacion);  // Lo guarda en la base de datos
            return ResponseEntity.ok(autorizacion);
        } catch (Exception e){
            System.out.println("Error" +e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/get-by-rut-and-fecha/{rut}/{fecha}")
    public ResponseEntity<Boolean> getByRutAndFecha(@PathVariable("rut") String rut, @PathVariable("fecha") String fecha){
        System.out.println("Aqui 2");
        Boolean resp = autorizacionService.existeAutorizacion(autorizacionService.reformatFecha(fecha), rut);
        if(resp){
            return ResponseEntity.ok(resp);    
        }
        return ResponseEntity.ok(resp); // false
        
    }
}
