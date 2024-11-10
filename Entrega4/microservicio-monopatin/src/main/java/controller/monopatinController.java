@RestController
@RequestMapping ("/monopatines")
public class monopatinController{
    @Autowired
    private monopatinService ms;

    @GetMapping("/")
    public ResponseEntity<List<Monopatin>> getMonopatines(){
        
        return ResponseEntity.ok(ms.getMonopatines());
    }

}