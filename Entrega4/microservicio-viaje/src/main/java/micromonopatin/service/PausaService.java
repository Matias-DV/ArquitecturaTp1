package micromonopatin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.PausaRepository;

@Service
public class PausaService {

    @Autowired
    private PausaRepository pausaRepository;

}
