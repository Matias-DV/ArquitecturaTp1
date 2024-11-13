package micromantenimiento.service;

import jakarta.transaction.Transactional;
import micromantenimiento.feignClients.ClientMonopatin;
import micromantenimiento.models.Monopatin;
import micromantenimiento.repository.ReporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@Transactional
public class ReporteService {

    @Autowired
    private ReporteRepository reporteRepository;

    @Autowired
    private ClientMonopatin clientMonopatin;

    public List<Monopatin> getReporteMonopatinesPorKilometro() {
        return clientMonopatin.getReporteMonopatinesPorKilometro();
    }

    public List<Monopatin> getReporteMonopatinesPorTiempoPausa(){
       // List<Monopatin> rta = reporteRepository.getReporteMonopatinesPorTiempoPausa();
       // if(rta.isEmpty()){
            return null;
       // }
        // throw new RuntimeException("No existen monopatines");
    }

    public List<Monopatin> getReporteMonopatinesPorTiempoSinPausa(){
        //List<Monopatin> rta = reporteRepository.getReporteMonopatinesPorTiempoSinPausa();
        // if(rta.isEmpty()){
            return null;
        //}
       // throw new RuntimeException("No existen monopatines");
    }
}
