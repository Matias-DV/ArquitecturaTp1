package repository;

import dto.EstudianteDTO;
import entity.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {

    @Query("SELECT e FROM Estudiante e WHERE e.dni = :dni")
    public List<Estudiante> getEstudianteByDNI(int dni);


    @Query("SELECT new dto.EstudianteDTO(e.dni, e.nombre, e.apellido, e.legajo) FROM Estudiante e WHERE e.apellido = :apellido ORDER BY e.apellido")
    List<EstudianteDTO> getEstudiantesOrdenadosByApellido(@Param("apellido") String apellido);

    @Modifying
    @Query("UPDATE Estudiante e SET e.nombre = :nombre, e.apellido = :apellido, e.legajo = :legajo WHERE e.dni = :dni")
    void updateEstudiante(@Param("estudiante") Estudiante estudiante);

    @Query
    void deleteEstudiante(Estudiante estudiante);

    EstudianteDTO getEstudianteByLegajo(int legajo);

    List<EstudianteDTO>getEstudiantesByGenero(String genero);



}
