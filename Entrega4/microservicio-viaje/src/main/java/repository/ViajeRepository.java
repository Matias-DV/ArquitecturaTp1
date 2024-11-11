package repository;

import dto.ViajeDTO;
import entity.Viaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ViajeRepository extends JpaRepository<ViajeDTO, Long> {

    ViajeDTO getByIdViaje(Integer idViaje);
}
