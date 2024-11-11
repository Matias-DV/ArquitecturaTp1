package micromonopatin.repository;

import micromonopatin.dto.MonopatinDTO;
import micromonopatin.entity.Monopatin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface monopatinRepository  extends JpaRepository<Monopatin,Integer> {

    @Query("SELECT new micromonopatin.dto.MonopatinDTO(m.id_monopatin, m.ubicacionActual, m.estaActivo, m.habilitado, m.kilometrosTotales, m.tiempo_uso_total) FROM Monopatin m WHERE m.id = :id")
    MonopatinDTO getMonopatinById(@Param("id") int id);

    @Query("SELECT new micromonopatin.dto.MonopatinDTO(m.id_monopatin, m.ubicacionActual, m.estaActivo, m.habilitado, m.kilometrosTotales, m.tiempo_uso_total) FROM Monopatin m WHERE m.id_monopatin = :id_monopatin")
    MonopatinDTO getMonopatin(@Param("id_monopatin") int id_monopatin);

    @Modifying
    @Query("UPDATE Monopatin m SET m.ubicacionActual = :ubicacionActual, m.estaActivo = :estaActivado, m.habilitado = :habilitado, m.kilometrosTotales = :kilometrosTotales, m.tiempo_uso_total = :tiempo_uso_total WHERE m.id_monopatin = :id_monopatin")
    void updateMonopatin(@Param("ubicacionActual") String ubicacionActual, @Param("estaActivado") boolean estaActivado, @Param("habilitado") boolean habilitado, @Param("kilometrosTotales") double kilometrosTotales, @Param("tiempo_uso_total") int tiempo_uso_total, @Param("id_monopatin") int id_monopatin);

    @Query("DELETE FROM Monopatin m WHERE m.id_monopatin = :id_monopatin")
    void deleteMonopatin(@Param("id_monopatin") int id_monopatin);
}