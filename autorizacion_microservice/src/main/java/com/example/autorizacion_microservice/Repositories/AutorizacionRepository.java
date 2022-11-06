package com.example.autorizacion_microservice.Repositories;

import com.example.autorizacion_microservice.Entities.AutorizacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface AutorizacionRepository extends JpaRepository<AutorizacionEntity, Integer> {
    ArrayList<AutorizacionEntity> findByFechaAndRut(String fecha, String rut);
}
