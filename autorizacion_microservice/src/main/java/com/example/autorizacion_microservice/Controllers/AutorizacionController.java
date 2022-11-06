package com.example.autorizacion_microservice.Controllers;

import com.example.autorizacion_microservice.Entities.AutorizacionEntity;
import com.example.autorizacion_microservice.Services.AutorizacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/autorizacion")
public class AutorizacionController {
    @Autowired
    private AutorizacionService autorizacionService;

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
}
