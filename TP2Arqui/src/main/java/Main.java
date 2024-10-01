import dto.CarreraDTO;
import dto.EstudianteDTO;
import entity.Carrera;
import entity.Estudiante;
import entity.EstudianteCarrera;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import repository.CarreraRepository;
import repository.CarreraRepositoryImp;
import repository.EstudianteCarreraRepositoryImp;
import repository.EstudianteRepositoryImp;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Integrador2");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        em.getTransaction().begin();

        CarreraRepository carreraRepository = new CarreraRepositoryImp(em);

        Carrera c10 = new Carrera("Fisica",10L);
        Carrera c = carreraRepository.getCarrera(c10);


        EstudianteRepositoryImp estudianteRepository = new EstudianteRepositoryImp(em);

        Estudiante e1 = new Estudiante(88775566);
        Estudiante e = estudianteRepository.getEstudiante(e1);

        int inicio = 2015;
        int fin = 2024;

        EstudianteCarrera estudianteCarrera = new EstudianteCarrera(2,false,inicio,fin,c,e);
        EstudianteCarreraRepositoryImp estudianteCarreraRepositoryImp = new EstudianteCarreraRepositoryImp(em);
        estudianteCarreraRepositoryImp.addEstudianteCarrera(estudianteCarrera);

      //System.out.println("   ----------------------------------------   ");

 /*       List<EstudianteDTO> estudiantes1;
        String genero = "Masculino";
        estudiantes1 = estudianteRepository.getEstudiantesByGenero(genero);

        for (EstudianteDTO estudiante : estudiantes1) {
            System.out.println(estudiante.imprimirConGenero());
        }

        System.out.println("   ----------------------------------------   ");
/*
        EstudianteDTO estudiantes2 = estudianteRepository.getEstudianteByLegajo(1001);
        System.out.println(estudiantes2.toString());


        System.out.println("   ----------------------------------------   ");

        Chequear porque solo muestra la consulta sql
        List<EstudianteDTO> estudiantes = new ArrayList<>();
        estudiantes = estudiantecarreraRepository.getEstudiantesByCarreraFiltroCiudad("Química","Tucumán");

        for (EstudianteDTO est : estudiantes) {
            System.out.println(est.imprimirConCiudadCarrera());
        }

        System.out.println("   ----------------------------------------   ");

        //Chequear este metodo porque no anda
       List<CarreraDTO> carreras;
        carreras = estudiantecarreraRepository.getCarrerasInscriptosOrdenadas();

*/
    /*    System.out.println("   ----------------------------------------   ");

        //Chequear este metodo porque no anda
        List<Carrera> carreras1 = new ArrayList<>();
        carreras1 = estudiantecarreraRepository.reporteCarreras();

        for (Carrera c : carreras1) {
            System.out.println(c);
        }*/

        /*List<EstudianteDTO>estudiantes = estudianteRepository.getEstudiantesOrdenadosByApellido();
        for(EstudianteDTO estudiante : estudiantes){
            System.out.println(estudiante.toString());
        }*/

        transaction.commit();
        em.close();
        emf.close();
    }
}
