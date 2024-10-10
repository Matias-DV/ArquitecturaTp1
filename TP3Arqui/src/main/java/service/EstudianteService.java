package service;

import dto.EstudianteDTO;
import entity.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import repository.EstudianteRepository;

import java.util.List;

public class EstudianteService {

    private EstudianteRepository estudianteRepository;

    public Estudiante getEstudiante(Estudiante estudiante) throws Exception {

    }

    public List<EstudianteDTO> getEstudiantesOrdenadosByApellido(String apellido){
        return estudianteRepository.getEstudiantesOrdenadosByApellido("apellido");
    }


    public Estudiante addEstudiante(Estudiante estudiante){
        return estudianteRepository.save(estudiante);
    }



    public void updateEstudiante(Estudiante estudiante) {

    }

    @Override
    public void deleteEstudiante(Estudiante estudiante) {

    }

    @Override
    public EstudianteDTO getEstudianteByLegajo(int legajo) {
        return null;
    }

    @Override
    public List<EstudianteDTO> getEstudiantesByGenero(String genero) {
        return List.of();
    }
}
