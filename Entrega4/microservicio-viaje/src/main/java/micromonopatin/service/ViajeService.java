package micromonopatin.service;

import dto.ViajeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import micromonopatin.repository.ViajeRepository;

import java.util.List;

@Service
public class ViajeService {

    @Autowired
    private ViajeRepository viajeRepository;

    public List<ViajeDTO> getViajes() {return viajeRepository.findAll();}
}
