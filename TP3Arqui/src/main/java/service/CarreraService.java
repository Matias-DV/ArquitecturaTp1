package service;

import entity.Carrera;
import repository.CarreraRepository;

import java.util.List;

public class CarreraService implements CarreraRepository {
    private CarreraRepository carreraRepository;
    @Override
    public Carrera getCarrera(Carrera carrera) {
        return null;
    }

    @Override
    public List<Carrera> getCarreras() {
        return List.of();
    }

    @Override
    public Carrera addCarrera(Carrera carrera) {
        return carreraRepository.addCarrera( carrera );
    }

    @Override
    public void updateCarrera(Carrera carrera) {

    }

    @Override
    public void deleteCarrera(Long carrera) {

    }
}
