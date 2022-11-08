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

    public boolean existeAutorizacion(String fecha, String rut){
        ArrayList<AutorizacionEntity> autorizacion = autorizacionRepository.findByFechaAndRut(fecha, rut);
        if(autorizacion.size() == 1){
            return true;
        }else{
            return false;
        }
    }

    public String reformatFecha(String fecha){
        String[] divisiones = fecha.split("/");
        if(divisiones.length == 1){  // Tiene formato de guión
            String[] divisiones2 = fecha.split("-");
            return (divisiones2[0] + "/" + divisiones2[1] + "/" + divisiones2[2]);
        }
        return (divisiones[0] + "-" + divisiones[1] + "-" + divisiones[2]);

    }
}
