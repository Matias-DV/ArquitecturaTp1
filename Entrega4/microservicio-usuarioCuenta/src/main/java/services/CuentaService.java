package services;

import entities.Cuenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.CuentaRepository;

@Service
public class CuentaService {

    @Autowired
    private CuentaRepository cuentaRepository;

    public Cuenta addCuenta(Cuenta cuenta){
        return cuentaRepository.save(cuenta);
    }

    public void deleteCuenta(Cuenta cuenta){
        cuentaRepository.delete(cuenta);
    }
}