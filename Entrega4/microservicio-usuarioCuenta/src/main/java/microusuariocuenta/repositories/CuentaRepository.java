package microusuariocuenta.repositories;

import microusuariocuenta.dto.CuentaDTO;
import microusuariocuenta.entity.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface CuentaRepository extends JpaRepository<Cuenta, Integer> {

    @Query("DELETE FROM Cuenta c WHERE c.id = :id")
    void deleteCuenta(@Param("id") int id);

    @Modifying
    @Query("UPDATE Cuenta c SET c.saldo = :saldo, c.fechaAlta = :fechaAlta, c.idMercadoPago =:idMercadoPago")
    public void updateCuenta(@Param("saldo") double saldo, @Param("fechaAlta") Date fechaAlta, @Param("idMercadoPago") int idMercadoPago);

    @Query("SELECT new microusuariocuenta.dto.CuentaDTO(c.id, c.saldo, c.fechaAlta, c.idMercadoPago) FROM Cuenta c WHERE c.id = :id")
    public CuentaDTO getCuentaById(@Param("id") int id);


}