package service;

import dto.ViajeDTO;
import entity.Viaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ViajeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ViajeService {

    @Autowired
    private ViajeRepository viajeRepository;

    public ViajeDTO saveViaje(ViajeDTO viaje) {
        return viajeRepository.save(viaje);
    }

    public Optional<ViajeDTO> getViajeById(Long idViaje) {
        return viajeRepository.findById(idViaje);
    }

    public List<ViajeDTO> getAllViajes() {
        return viajeRepository.findAll();
    }

    public void deleteViaje(Long idViaje) {
        viajeRepository.deleteById(idViaje);
    }
}
