import dto.CarreraDTO;
import dto.EstudianteDTO;
import dto.RegistroCarrerasDTO;
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

        List<RegistroCarrerasDTO> registroCarrerasDTOS = new ArrayList<>();
        EstudianteCarreraRepositoryImp estudianteCarreraRepositoryImp = new EstudianteCarreraRepositoryImp(em);
        registroCarrerasDTOS = estudianteCarreraRepositoryImp.reporteCarreras();
        for (RegistroCarrerasDTO dto : registroCarrerasDTOS) {
            System.out.println(dto.toString());
        }

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
