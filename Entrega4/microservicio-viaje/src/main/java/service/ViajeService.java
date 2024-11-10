package service;

import dto.ViajeDTO;
import entity.Viaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ViajeRepository;

import java.util.List;

@Service
public class ViajeService {

    @Autowired
    private ViajeRepository viajeRepository;

    public List<ViajeDTO> getViajes() {return viajeRepository.findAll();}
}
