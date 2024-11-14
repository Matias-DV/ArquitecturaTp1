package microviaje.repository;

import microviaje.dto.ViajeDTO;
import microviaje.entity.Viaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ViajeRepository extends JpaRepository<Viaje, Long> {

    @Query("SELECT new microviaje.dto.ViajeDTO(v.idViaje,v.idUsuario, v.idMonopatin, v.idParada, v.fechaInicio, v.fechaFin, v.kmRecorridos, v.costo) FROM Viaje v WHERE v.idViaje = :idViaje")
    ViajeDTO getViajeById(@Param("idViaje") Long idViaje);

    @Query("SELECT new microviaje.dto.ViajeDTO(v.idViaje,v.idUsuario, v.idMonopatin, v.idParada, v.fechaInicio, v.fechaFin, v.kmRecorridos, v.costo) FROM Viaje v")
    List<ViajeDTO> getViajes();

    @Query("SELECT sum(p.tiempo) FROM Viaje v JOIN Pausa p on (v.idViaje = p.idViaje) WHERE v.idMonopatin = :id")
    Long getTiempoPausaMonopatin(int id);

    @Query("SELECT new microviaje.dto.ViajeDTO(v.idViaje, v.idUsuario, v.idMonopatin, v.idParada, v.fechaInicio, v.fechaFin, v.kmRecorridos, v.costo) " +
            "FROM Viaje v " +
            "WHERE FUNCTION('YEAR', v.fechaInicio) = :anio " +
            "GROUP BY v.idMonopatin " +
            "HAVING COUNT(v.idViaje) > :cant")
    List<ViajeDTO> getMonopatinesMasViajesPorAnio(int cant, int anio);

    @Query("SELECT SUM(v.costo) " +
            "FROM Viaje v " +
            "WHERE FUNCTION('YEAR', v.fechaInicio) = :anio " +
            "AND FUNCTION('MONTH', v.fechaInicio) BETWEEN :mes1 AND :mes2")
    void getFacturadoEntre(int anio, int mes1, int mes2);
}
