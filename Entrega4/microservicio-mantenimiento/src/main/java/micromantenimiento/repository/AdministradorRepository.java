package micromantenimiento.repository;

import micromantenimiento.dto.AdministradorDTO;
import micromantenimiento.entity.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface AdministradorRepository extends JpaRepository<Administrador, Integer> {

    @Query("DELETE FROM Administrador a WHERE a.id = :id")
    void deleteAdministrador(@Param("id") int id);

    @Modifying
    @Query("UPDATE Administrador a SET a.precioTarifa = :precioTarifa, a.precioTarifaExtra = :precioTarifaExtra")
    public void updateAdministrador(@Param("precioTarifa") double precioTarifa, @Param("precioTarifaExtra") double precioTarifaExtra);

    @Query("SELECT new micromantenimiento.dto.AdministradorDTO(a.id, a.precioTarifa, a.precioTarifaExtra) FROM Administrador a WHERE a.id = :id")
    public AdministradorDTO getAdministradorById(@Param("id") int id, @Param("precioTarifa") double precioTarifa, @Param("precioTarifaExtra") double precioTarifaExtra);

}
