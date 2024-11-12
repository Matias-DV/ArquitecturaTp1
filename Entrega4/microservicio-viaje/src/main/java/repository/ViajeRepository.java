package repository;

import dto.ViajeDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ViajeRepository extends JpaRepository<ViajeDTO, Long> {

    ViajeDTO getByIdViaje(Integer idViaje);
}
