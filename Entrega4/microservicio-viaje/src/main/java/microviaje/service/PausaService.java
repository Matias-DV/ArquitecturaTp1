package microviaje.service;

import microviaje.dto.PausaDTO;
import microviaje.entity.Pausa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import microviaje.repository.PausaRepository;

import java.util.List;

@Service
public class PausaService {

    @Autowired
    private PausaRepository PausaRepository;

    public List<PausaDTO> getPausas(){
        return PausaRepository.getPausas();
    }

    public Pausa addPausa(Pausa pausa) {
        return PausaRepository.save(pausa);
    }
}
