package micromantenimiento.service;

import micromantenimiento.dto.AdministradorDTO;
import micromantenimiento.entity.Administrador;
import micromantenimiento.repository.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AdministradorService {

    @Autowired
    private AdministradorRepository administradorRepository;

    // Método para agregar un nuevo administrador
    public Administrador addAdministrador(Administrador administrador) {
        return administradorRepository.save(administrador);
    }

    // Método para actualizar un administrador
    public Administrador updateAdministrador(Administrador administrador) {
        if (administradorRepository.existsById(administrador.getId())) {
            return administradorRepository.save(administrador);
        } else {
            return null; // Puede lanzar una excepción si prefieres manejarlo de otra manera
        }
    }

    // Método para eliminar un administrador
    public void deleteAdministrador(int id) {
        if (administradorRepository.existsById(id)) {
            administradorRepository.deleteById(id);
        }
    }

    public AdministradorDTO getAdministradorById(int id) {
        return administradorRepository.getAdministradorById(id);
    }

    public List<AdministradorDTO> getAdministradores() {
        return administradorRepository.getAdministradores();
    }
}
