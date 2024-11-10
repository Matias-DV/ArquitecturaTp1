import service.paradaService;

@RestController
@RequestMapping ("api/paradas")
public class paradaController{
    @Autowired
    private paradaService ps;

    @PostMapping
    public ResponseEntity<Parada> addParada(@RequestBody Parada parada) {
        return ResponseEntity.ok(ps.addParada(parada));
    }

    @GetMapping("/{id_parada}")
    public ResponseEntity<Parada> getParada(@PathVariable int id_parada) {
        return ResponseEntity.ok(ps.getParada(id_parada));
    }

    @PutMapping("/update/{id_parada}")
    public ResponseEntity<String> updateParada(@RequestBody String ubicacion, @RequestBody boolean permitida, @PathVariable Integer id_parada) {
        return ResponseEntity.ok(ps.updateParada(ubicacion, permitida, id_parada));
    }

    @DeleteMapping("/delete/{id_parada}")
    public ResponseEntity<String> deleteParada(@PathVariable int id_parada) {
        return ResponseEntity.ok(ps.deleteParada(id_parada));
    }

}