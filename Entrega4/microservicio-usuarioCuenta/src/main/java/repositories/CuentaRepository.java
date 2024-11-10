package repositories;

import entities.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CuentaRepository extends JpaRepository<Cuenta, Integer> {

    @Query("DELETE FROM Cuenta c WHERE c.id = :id")
    void deleteCuenta(@Param("id")int id);
}
