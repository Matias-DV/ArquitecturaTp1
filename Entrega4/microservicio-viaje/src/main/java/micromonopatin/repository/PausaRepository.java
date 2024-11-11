package micromonopatin.repository;

import dto.PausaDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PausaRepository extends JpaRepository<PausaDTO, Integer> {

    @Query("SELECT p FROM Pausa p")
    List<PausaDTO> getPausas();
}

