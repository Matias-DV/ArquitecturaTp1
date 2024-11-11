package services;

import dto.CuentaDTO;
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

    public void deleteCuenta(int idCuenta){
        cuentaRepository.deleteCuenta(idCuenta);
    }

    public void updateCuenta(Cuenta c){
        cuentaRepository.updateCuenta(c.getSaldo(), c.getFechaAlta(), c.getIdMercadoPago());
    }

    public CuentaDTO getCuentaById(int idCuenta){
        return cuentaRepository.getCuentaById(idCuenta);
    }
}