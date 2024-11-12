package micromantenimiento.service;
import micromantenimiento.dto.MantenimientoDTO;
import micromantenimiento.entity.Mantenimiento;
import micromantenimiento.feignClients.ClientMonopatin;
import micromantenimiento.models.Monopatin;
import micromantenimiento.repository.MantenimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MantenimientoService {

    @Autowired
    private MantenimientoRepository mantenimientoRepository;

    @Autowired
    private ClientMonopatin clientMonopatin;

    public Mantenimiento addMantenimiento(Mantenimiento m){
        Monopatin monopatin = clientMonopatin.getMonopatin(m.getIdMonopatin());
        if(monopatin == null){
            throw new RuntimeException("Monopatin invalido");
        }
        return mantenimientoRepository.save(m);
    }

    public void deleteMantenimiento(int idMantenimiento){
        mantenimientoRepository.deleteMantenimiento(idMantenimiento);
    }

    public void updateMantenimiento(Mantenimiento m){
        mantenimientoRepository.updateMantenimiento(m.getIdMonopatin(),m.getFechaInicio(),m.getFechaFin(),m.getId());
    }

    public MantenimientoDTO getMantenimientoById(int idMantenimiento){
        return mantenimientoRepository.getMantenimientoById(idMantenimiento);
    }

    public List<MantenimientoDTO> getMantenimientos() {
        return mantenimientoRepository.getMantenimientos();
    }
}
