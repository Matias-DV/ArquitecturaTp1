package micromonopatin.service;

import micromonopatin.dto.ParadaDTO;
import micromonopatin.entity.Parada;
import micromonopatin.repository.paradaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class paradaService{
    @Autowired
    private paradaRepository pr;

    public ParadaDTO getParada(int id_parada) {
        return pr.getParada(id_parada);
    }

    public Parada addParada(Parada parada){
        return pr.save(parada);
    }

    public void updateParada(Parada parada) {
        pr.updateParada(parada.getUbicacion(), parada.getPermitida(),parada.getId_parada());
    }

    public void deleteParada(int id_parada) {
        pr.deleteParada(id_parada);
    }
}