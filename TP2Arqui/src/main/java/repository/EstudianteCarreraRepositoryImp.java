package repository;

import dto.CarreraDTO;
import dto.EstudianteDTO;
import entity.Carrera;
import entity.Estudiante;
import entity.EstudianteCarrera;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;

public class EstudianteCarreraRepositoryImp implements EstudianteCarreraRepository {
    private EntityManager em;

    public EstudianteCarreraRepositoryImp(EntityManager em) {
        this.em = em;
    }

    @Override
    public EstudianteCarrera getEstudianteCarrera(Estudiante estudiante, Carrera carrera) {
        TypedQuery<EstudianteCarrera> query = em.createQuery("SELECT ec FROM EstudianteCarrera ec WHERE ec.estudiante = :dni AND ec.Carrera = :ID_Carrera", EstudianteCarrera.class);
        query.setParameter("dni", estudiante.getDni());
        query.setParameter("ID_Carrera", carrera.getId());
        return query.getSingleResult();
    }

    @Override
    public List<EstudianteCarrera> getEstudiantesCarreras() {
        List<EstudianteCarrera> estudiantes;
        TypedQuery<EstudianteCarrera> query = em.createQuery("SELECT ec FROM EstudianteCarrera ec ",   EstudianteCarrera.class);
        estudiantes = query.getResultList();
        return estudiantes;
    }

    @Override
    public void addEstudianteCarrera(EstudianteCarrera estudianteCarrera) {
        //matricular un estudiante en una carrera (crear relación)
        em.persist(estudianteCarrera);
    }

    @Override
    public void updateCarrera(EstudianteCarrera estudianteCarrera) {
        em.merge(estudianteCarrera);
    }

    @Override
    public void deleteCarrera(Estudiante estudiante, Carrera carrera) {
        Query query = em.createQuery("DELETE FROM EstudianteCarrera ec WHERE ec.estudiante = :estudiante AND ec.Carrera = :carrera");
        query.setParameter("estudiante", estudiante);
        query.setParameter("carrera", carrera);
        query.executeUpdate();
    }

    @Override
    public List<EstudianteDTO> getEstudiantesByCarreraFiltroCiudad(String carrera, String ciudad) {
        List<EstudianteDTO> estudiantes;
        String jpql = "SELECT new dto.EstudianteDTO(ec.estudiante.dni, ec.estudiante.nombre, ec.estudiante.apellido, ec.estudiante.legajo, ec.estudiante.ciudad, ec.Carrera.Nombre, ec.estudiante.genero) from EstudianteCarrera ec where ec.estudiante.ciudad=:ciudad and ec.Carrera.Nombre=:carrera";
        Query query = em.createQuery(jpql, EstudianteDTO.class);
        query.setParameter("carrera", carrera);
        query.setParameter("ciudad", ciudad);
        estudiantes = query.getResultList();
        return estudiantes;
    }

    @Override
    public List<CarreraDTO> getCarrerasInscriptosOrdenadas() {
        String jpql = "SELECT new dto.CarreraDTO(c.Nombre, COUNT(ec.Carrera.id)) " +
                "FROM EstudianteCarrera ec " +
                "JOIN Carrera c ON ec.Carrera.id = c.id " +
                "GROUP BY c.id, c.Nombre " +
                "ORDER BY COUNT(ec.Carrera.id) DESC";

        Query query = em.createQuery(jpql, CarreraDTO.class);
        List<CarreraDTO> resultados = query.getResultList();
        System.out.println(resultados);
        return resultados;
    }
    @Override
    public List<Carrera> reporteCarreras() {
        List<Carrera> reporte;
        TypedQuery<Carrera> query = em.createQuery("SELECT c.Nombre AS carrera, DATE_SUB(CURDATE(), INTERVAL ec.antiguedad YEAR) AS fecha_calculada COUNT(CASE WHEN ec.esGraduado = false THEN 1 END) AS inscriptos COUNT(CASE WHEN ec.esGraduado = true THEN 1 END) AS egresados FROM EstudianteCarrera ec " +
                " JOIN " +
                "    Carrera c ON ec.Carrera.id = c.id " +
                " GROUP BY " +
                "    c.nombre, ec.antiguedad " +
                " ORDER BY " +
                "    c.nombre ASC, ec.antiguedad ASC", Carrera.class);

        reporte = query.getResultList();
        return reporte;
    }

}