package service;

import dto.CarreraDTO;
import dto.EstudianteCarreraDTO;
import dto.EstudianteDTO;
import dto.RegistroCarrerasDTO;
import entity.Carrera;
import entity.Estudiante;
import entity.EstudianteCarrera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.EstudianteCarreraRepository;
import java.util.List;

@Service
public class EstudianteCarreraService {

    @Autowired
    private EstudianteCarreraRepository estudianteCarreraRepository;

    EstudianteCarrera getEstudianteCarrera(Estudiante estudiante, Carrera carrera){
        return estudianteCarreraRepository.getEstudianteCarrera(estudiante, carrera);
    }

    List<EstudianteCarreraDTO> getEstudiantesCarreras(){
        return estudianteCarreraRepository.getEstudiantesCarreras();
    }

    EstudianteCarrera addEstudianteCarrera(EstudianteCarrera estudianteCarrera){
        return estudianteCarreraRepository.save(estudianteCarrera);
    }

    void updateCarrera(Estudiante estudiante, Carrera carrera, int antiguedad, boolean esGraduado, int fechaInscripcion, int fechaEgreso, int idEstudiante, Long idCarrera){
        estudianteCarreraRepository.updateEstudianteCarrera(estudiante, carrera, antiguedad, esGraduado, fechaInscripcion, fechaEgreso, idEstudiante, idCarrera);
    }

    void deleteCarrera(Estudiante estudiante, Carrera carrera){
        estudianteCarreraRepository.deleteCarrera(estudiante, carrera);
    }

    List<EstudianteDTO>getEstudiantesByCarreraFiltroCiudad(Carrera carrera, String ciudad){
        return estudianteCarreraRepository.getEstudiantesByCarreraFiltroCiudad(carrera, ciudad);
    }

    List<CarreraDTO>getCarrerasInscriptosOrdenadas(){
        return estudianteCarreraRepository.getCarrerasInscriptosOrdenadas();
    }

    //List<RegistroCarrerasDTO>reporteCarreras();
}
