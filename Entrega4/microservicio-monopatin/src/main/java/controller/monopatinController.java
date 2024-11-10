import entity.Monopatin;
import service.monopatinService;

@RestController
@RequestMapping ("api/monopatines")
public class monopatinController{
    @Autowired
    private monopatinService ms;

    @PostMapping
    public ResponseEntity<Monopatin> addMonopatin(@RequestBody Monopatin monopatin) {
        return ResponseEntity.ok(ms.addMonopatin(monopatin));
    }

    @GetMapping("/{id_monopatin}")
    public ResponseEntity<Monopatin> getMonopatin(@PathVariable int id_monopatin) {
        return ResponseEntity.ok(ms.getMonopatin(id_monopatin));
    }

    @PutMapping("/update/{id_monopatin}")
    public ResponseEntity<String> updateMonopatin(@RequestBody String ubicacionActual, @RequestBody boolean estaActivado, @RequestBody boolean habilitado, @RequestBody double kilometrosTotales, @RequestBody int tiempo_uso_total, @PathVariable Integer id_monopatin) {
        return ResponseEntity.ok(ms.updateMonopatin(ubicacionActual, estaActivado, habilitado, kilometrosTotales, tiempo_uso_total, id_monopatin));
    }

    @DeleteMapping("/delete/{id_monopatin}")
    public ResponseEntity<String> deleteMonopatin(@PathVariable int id_monopatin) {
        return ResponseEntity.ok(ms.deleteMonopatin(id_monopatin));
    }

}