package microviaje.service;

import microviaje.dto.ViajeDTO;
import microviaje.entity.Viaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import microviaje.repository.ViajeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ViajeService {

    @Autowired
    private ViajeRepository viajeRepository;

    public Viaje saveViaje(Viaje viaje) {
        return viajeRepository.save(viaje);
    }

    public ViajeDTO getViajeById(Long idViaje) {
        return viajeRepository.getViajeById(idViaje);
    }

    public List<ViajeDTO> getAllViajes() {
        return viajeRepository.getViajes();
    }

    public void deleteViaje(Long idViaje) {
        viajeRepository.deleteById(idViaje);
    }

    public long getTiempoPausaMonopatin(int id) {
        return viajeRepository.getTiempoPausaMonopatin(id);
    }
}
