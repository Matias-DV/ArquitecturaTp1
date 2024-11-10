package repositories;

import entities.Cuenta;
import entities.UsuarioCuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuarioCuentaRepository extends JpaRepository<UsuarioCuenta, Integer> {

    @Query("DELETE FROM UsuarioCuenta uc WHERE uc.id =: id")
    public void deleteUsuarioCuenta(@Param("id") Integer id);
}
