@RestController
@RequestMapping ("/paradas")
public class paradaController{
    @Autowired
    private paradaService ps;

    @GetMapping("/")
    public ResponseEntity<List<Parada>> getParadas(){
        
        return ResponseEntity.ok(ms.getParadas());
    }

}