package micromantenimiento.repository;

import micromantenimiento.entity.Reporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ReporteRepository extends JpaRepository<Reporte, Integer> {
}
