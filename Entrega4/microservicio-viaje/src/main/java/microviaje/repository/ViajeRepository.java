package microviaje.repository;

import microviaje.dto.ViajeDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ViajeRepository extends JpaRepository<ViajeDTO, Long> {

    ViajeDTO getByIdViaje(Integer idViaje);
}
