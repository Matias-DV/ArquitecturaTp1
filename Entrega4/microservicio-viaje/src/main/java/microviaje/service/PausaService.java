package microviaje.service;

import microviaje.dto.PausaDTO;
import org.springframework.beans.factory.annotation.Autowired;
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

}
