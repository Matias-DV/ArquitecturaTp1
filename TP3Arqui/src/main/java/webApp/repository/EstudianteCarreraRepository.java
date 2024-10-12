package webApp.repository;

import webApp.dto.CarreraDTO;
import webApp.dto.EstudianteCarreraDTO;
import webApp.dto.EstudianteDTO;
import webApp.dto.RegistroCarrerasDTO;
import webApp.entity.Carrera;
import webApp.entity.Estudiante;
import webApp.entity.EstudianteCarrera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EstudianteCarreraRepository extends JpaRepository<EstudianteCarrera, Long> {

    @Query("SELECT ec FROM EstudianteCarrera ec WHERE ec.estudiante = :estudiante AND ec.Carrera = :carrera")
    EstudianteCarrera getEstudianteCarrera(@Param("estudiante") Estudiante estudiante, @Param("carrera")Carrera carrera);

    @Query("SELECT new webApp.dto.EstudianteCarreraDTO(ec.estudiante, ec.Carrera,ec.antiguedad,ec.esGraduado) FROM EstudianteCarrera ec")
    List<EstudianteCarreraDTO> getEstudiantesCarreras();

    @Modifying
    @Query("UPDATE EstudianteCarrera ec SET ec.estudiante = :estudiante, ec.Carrera = :carrera, ec.antiguedad = :antiguedad, ec.esGraduado = :esGraduado, ec.fechaInscripcion = :fechaInscripcion, ec.fechaEgreso = :fechaEgreso WHERE ec.Carrera.id = :idCarrera AND ec.estudiante.dni = :dniEstudiante")
    void updateEstudianteCarrera(@Param("estudiante") Estudiante estudiante, @Param("carrera") Carrera carrera,
                                 @Param("antiguedad")int antiguedad, @Param("esGraduado")boolean esGraduado,
                                 @Param("fechaInscripcion") int fechaInscripcion, @Param("fechaEgreso")int fechaEgreso,
                                 @Param("dniEstudiante")int dniEstudiante, @Param("idCarrera")Long idCarrera);

    @Query("DELETE FROM EstudianteCarrera ec WHERE ec.estudiante = :estudiante AND ec.Carrera = :carrera")
    void deleteCarrera(@Param("estudiante")Estudiante estudiante, @Param("carrera")Carrera carrera);

    @Query("SELECT new webApp.dto.EstudianteCarreraDTO(ec.estudiante, ec.Carrera,ec.antiguedad,ec.esGraduado) FROM EstudianteCarrera ec WHERE ec.Carrera = :carrera AND ec.estudiante.ciudad = :ciudad")
    List<EstudianteDTO>getEstudiantesByCarreraFiltroCiudad(@Param("carrera") Carrera carrera, @Param("ciudad") String ciudad);

    @Query("SELECT new webApp.dto.CarreraDTO(c.Nombre, COUNT(ec)) FROM EstudianteCarrera ec JOIN Carrera c ORDER BY COUNT(ec) DESC")
    List<CarreraDTO>getCarrerasInscriptosOrdenadas();

    @Query("")
    List<RegistroCarrerasDTO>reporteCarreras();
}
