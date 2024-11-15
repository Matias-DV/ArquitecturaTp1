package microviaje.service;

import jakarta.transaction.Transactional;
import microviaje.dto.ViajeDTO;
import microviaje.entity.Viaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import microviaje.repository.ViajeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
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

    public Long getTiempoPausaMonopatin(int id) {
        return viajeRepository.getTiempoPausaMonopatin(id);
    }

    public List<ViajeDTO> getMonopatinesMasViajesPorAnio(int cant, int anio) {
        return viajeRepository.getMonopatinesMasViajesPorAnio(cant, anio);
    }


    public Integer getFacturadoEntre(int anio, int mes1, int mes2) {
        return viajeRepository.getFacturadoEntre(anio, mes1, mes2);
    }

    public void updateViaje(Viaje viaje, long idViaje) {
        viajeRepository.updateViaje(viaje.getCosto(), viaje.getFechaInicio(), viaje.getFechaFin(), viaje.getIdMonopatin(), viaje.getIdParada(), viaje.getKmRecorridos(), viaje.getIdUsuario(),idViaje);
    }
}
