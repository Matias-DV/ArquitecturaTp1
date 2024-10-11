package spackage service;

import dto.EstudianteDTO;
import entity.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.EstudianteRepository;

import java.util.List;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    public Estudiante getEstudiante(Estudiante estudiante) {
        return estudianteRepository.getEstudianteByDNI(estudiante.getDni());
    }

    public List<EstudianteDTO> getEstudiantesOrdenadosByApellido(String apellido){
        return estudianteRepository.getEstudiantesOrdenadosByApellido(apellido);
    }

    public Estudiante addEstudiante(Estudiante estudiante){
        return estudianteRepository.save(estudiante);
    }

    public void updateEstudiante(Estudiante estudiante) {
        estudianteRepository.updateEstudiante(estudiante);
    }

    public void deleteEstudiante(int dni) {
        estudianteRepository.deleteEstudiante(dni);
    }

    public EstudianteDTO getEstudianteByLegajo(int legajo) {
        return estudianteRepository.getEstudianteByLegajo(legajo);
    }

    public List<EstudianteDTO> getEstudiantesByGenero(String genero) {
        return estudianteRepository.getEstudiantesByGenero(genero);
    }
}
