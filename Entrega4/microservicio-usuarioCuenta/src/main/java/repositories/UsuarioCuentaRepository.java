package repositories;

import dto.UsuarioCuentaDTO;
import entities.Cuenta;
import entities.Usuario;
import entities.UsuarioCuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuarioCuentaRepository extends JpaRepository<UsuarioCuenta, Integer> {

    @Query("DELETE FROM UsuarioCuenta uc WHERE uc.id =: id")
    public void deleteUsuarioCuenta(@Param("id") Integer id);

    @Modifying
    @Query("UPDATE UsuarioCuenta uc SET uc.usuario =: usuario, uc.cuenta = :cuenta")
    public void updateUsuarioCuenta(@Param("usuario") Usuario usuario, @Param("cuenta") Cuenta cuenta);

    @Query("SELECT new dto.UsuarioCuentaDTO(uc.id,uc.usuario,uc.cuenta) FROM UsuarioCuenta uc WHERE uc.id =: id")
    public UsuarioCuentaDTO getUsuarioCuentaById(@Param("id")int id);
}