package service;

import dto.CarreraDTO;
import entity.Carrera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CarreraRepository;

import java.util.List;

@Service
public class CarreraService {

    @Autowired
    private CarreraRepository carreraRepository;

    public Carrera getCarrera(Long id) {
        return carreraRepository.getCarrera(id);
    }

    public List<CarreraDTO> getCarreras() {
        return carreraRepository.getCarreras();
    }

    public Carrera addCarrera(Carrera carrera) {
        return carreraRepository.save(carrera);
    }

    public void updateCarrera(String nombre, Long id) {
        carreraRepository.updateCarrera(nombre, id);
    }

    public void deleteCarrera(Long carrera) {
        carreraRepository.deleteCarrera(carrera);
    }
}
