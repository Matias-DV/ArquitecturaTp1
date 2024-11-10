
import entity.Monopatin;
import repository.monopatinRepository;

@Service
public class monopatinService{

    @Autowired
    private monopatinRepository mr;

    public Monopatin getMonopatin(int id_monopatin) {
        return mr.getMonopatin(id_monopatin);
    }

    public Monopatin addMonopatin(Monopatin monopatin){
        return mr.save(monopatin);
    }

    public void updateMonopatin(String ubicacionActual, Boolean estaActivado, Boolean habilitado, Double kilometrosTotales, int tiempo_uso_total, int id_monopatin) {
        mr.updateMonopatin(ubicacionActual, estaActivado, habilitado, kilometrosTotales, tiempo_uso_total, id_monopatin);
    }

    public void deleteMonopatin(int id_monopatin) {
        mr.deleteMonopatin(id_monopatin);
    }
}