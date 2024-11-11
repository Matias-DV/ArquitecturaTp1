package micromonopatin.service;

import micromonopatin.dto.MonopatinDTO;
import micromonopatin.entity.Monopatin;
import micromonopatin.repository.monopatinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class monopatinService{

    @Autowired
    private monopatinRepository mr;

    public MonopatinDTO getMonopatin(int id_monopatin) {
        return mr.getMonopatin(id_monopatin);
    }

    public MonopatinDTO getMonopatinById(int idMonopatin){
        return mr.getMonopatinById(idMonopatin);
    }

    public Monopatin addMonopatin(Monopatin monopatin){
        return mr.save(monopatin);
    }

    public void updateMonopatin(Monopatin m){
        mr.updateMonopatin(m.getUbicacionActual(), m.getEstaActivo(), m.getHabilitado(), m.getKilometrosTotales(), m.getTiempo_uso_total(), m.getId_monopatin());
    }

    public void deleteMonopatin(int id_monopatin) {
        mr.deleteMonopatin(id_monopatin);
    }
}