package micromonopatin.repository;

import micromonopatin.dto.ParadaDTO;
import micromonopatin.entity.Parada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface paradaRepository extends JpaRepository<Parada,Integer> {
    @Query("SELECT new micromonopatin.dto.ParadaDTO(p.id_parada,p.permitida,p.ubicacionX,p.ubicacionY) FROM Parada p WHERE p.id_parada = :id_parada")
    ParadaDTO getParada(@Param("id_parada") int id_parada);

    @Modifying
    @Query("UPDATE Parada p SET p.ubicacionX = :ubicacionX, p.ubicacionY = :ubicacionY, p.permitida = :permitida WHERE p.id_parada = :id_parada")
    void updateParada(@Param("ubicacionX") int ubicacionX,@Param("ubicacionY") int ubicacionY, @Param("permitida") boolean permitida, @Param("id_parada") int id_parada);

    @Modifying
    @Query("DELETE FROM Parada p WHERE p.id_parada = :id_parada")
    void deleteParada(@Param("id_parada") int id_parada);

    @Query("SELECT new micromonopatin.dto.ParadaDTO(p.id_parada,p.permitida,p.ubicacionX,p.ubicacionY) FROM Parada p")
    List<ParadaDTO> getParadas();
}