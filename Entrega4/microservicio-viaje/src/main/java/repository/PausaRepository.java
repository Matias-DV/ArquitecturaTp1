package repository;

import dto.PausaDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PausaRepository extends JpaRepository<PausaDTO, Integer> {

    @Query("SELECT new microviaje.dto.PausaDTO(p.idPausa, p.idViaje, p.tiempo) FROM Pausa p")
    List<PausaDTO> getPausas();
}
