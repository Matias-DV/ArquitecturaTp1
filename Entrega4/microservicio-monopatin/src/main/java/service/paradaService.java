@Service
public class paradaService{
    @Autowired
    private paradaRepository pr;

    public Parada getParada(int id_parada) {
        return pr.getParada(id_parada);
    }

    public Parada addParada(Parada parada){
        return pr.save(parada);
    }

    public void updateParada(String ubicacion, boolean permitida, int id_parada) {
        pr.updateParada(ubicacion, permitida, id_parada);
    }

    public void deleteParada(int id_parada) {
        pr.deleteParada(id_parada);
    }
}