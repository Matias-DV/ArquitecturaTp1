package Arqui3.Entrega3.repository;

import Arqui3.Entrega3.dto.CarreraDTO;
import Arqui3.Entrega3.dto.EstudianteCarreraDTO;
import Arqui3.Entrega3.dto.EstudianteDTO;
import Arqui3.Entrega3.dto.RegistroCarrerasDTO;
import Arqui3.Entrega3.entity.Carrera;
import Arqui3.Entrega3.entity.Estudiante;
import Arqui3.Entrega3.entity.EstudianteCarrera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EstudianteCarreraRepository extends JpaRepository<EstudianteCarrera, Long> {

    @Query("SELECT ec FROM EstudianteCarrera ec WHERE ec.estudiante = :estudiante AND ec.Carrera = :carrera")
    EstudianteCarrera getEstudianteCarrera(@Param("estudiante") Estudiante estudiante, @Param("carrera")Carrera carrera);

    @Query("SELECT new Arqui3.Entrega3.dto.EstudianteCarreraDTO(ec.estudiante, ec.Carrera,ec.antiguedad,ec.esGraduado) FROM EstudianteCarrera ec")
    List<EstudianteCarreraDTO> getEstudiantesCarreras();

    @Modifying
    @Query("UPDATE EstudianteCarrera ec SET ec.estudiante = :estudiante, ec.Carrera = :carrera, ec.antiguedad = :antiguedad, ec.esGraduado = :esGraduado, ec.fechaInscripcion = :fechaInscripcion, ec.fechaEgreso = :fechaEgreso WHERE ec.Carrera.id = :idCarrera AND ec.estudiante.dni = :dniEstudiante")
    void updateEstudianteCarrera(@Param("estudiante") Estudiante estudiante, @Param("carrera") Carrera carrera,
                                 @Param("antiguedad")int antiguedad, @Param("esGraduado")boolean esGraduado,
                                 @Param("fechaInscripcion") int fechaInscripcion, @Param("fechaEgreso")int fechaEgreso,
                                 @Param("dniEstudiante")int dniEstudiante, @Param("idCarrera")Long idCarrera);

    @Query("DELETE FROM EstudianteCarrera ec WHERE ec.estudiante = :estudiante AND ec.Carrera = :carrera")
    void deleteCarrera(@Param("estudiante")Estudiante estudiante, @Param("carrera")Carrera carrera);

    @Query("SELECT new Arqui3.Entrega3.dto.EstudianteDTO(ec.estudiante.dni, ec.estudiante.nombre, ec.estudiante.apellido, ec.estudiante.legajo, ec.estudiante.genero ) " +
            "FROM EstudianteCarrera ec " +
            "WHERE ec.Carrera.id = :id AND ec.estudiante.ciudad = :ciudad")
    List<EstudianteDTO> getEstudiantesByCarreraFiltroCiudad(@Param("id") long id, @Param("ciudad") String ciudad);

    @Query("SELECT new Arqui3.Entrega3.dto.CarreraDTO(c.Nombre, COUNT(ec)) FROM EstudianteCarrera ec JOIN Carrera c GROUP BY (ec.Carrera.Nombre)ORDER BY COUNT(ec) DESC")
    List<CarreraDTO>getCarrerasInscriptosOrdenadas();

  /*  @Query("")
    List<RegistroCarrerasDTO>reporteCarreras();*/
}
