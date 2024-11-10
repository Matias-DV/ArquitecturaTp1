package repositories;

import entities.Cuenta;
import entities.Usuario;
import jakarta.persistence.Column;
import lombok.Getter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query("DELETE FROM Usuario u WHERE u.id =: id")
    public void deleteUsuario(@Param("id") Integer id);

    @Modifying
    @Query("UPDATE Usuario u SET u.nombre =: nombre, u.nombreUsuario = :nombreUsuario, u.apellido =: apellido, u.email =: email, u.telefono =: telefono WHERE u.id = :id")
    public void updateUsuario(@Param("nombre") String nombre, @Param("nombreUsuario") String nombreUsuario, @Param("apellido") String apellido, @Param("email") String email, @Param("telefono") String telefono);

}  