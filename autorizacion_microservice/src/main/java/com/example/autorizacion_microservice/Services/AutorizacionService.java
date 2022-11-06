package com.example.autorizacion_microservice.Services;

import com.example.autorizacion_microservice.Entities.AutorizacionEntity;
import com.example.autorizacion_microservice.Repositories.AutorizacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AutorizacionService {
    @Autowired
    AutorizacionRepository autorizacionRepository;

    public ArrayList<AutorizacionEntity> listAll(){
        return (ArrayList<AutorizacionEntity>) autorizacionRepository.findAll();
    }

    public AutorizacionEntity add(AutorizacionEntity justificativo){
        return autorizacionRepository.save(justificativo);
    }

    public boolean exists(String fecha, String rut){
        ArrayList<AutorizacionEntity> autorizacion = autorizacionRepository.findByFechaAndRut(fecha, rut);
        if(autorizacion.size() == 1){
            return true;
        }else{
            return false;
        }
    }
}
