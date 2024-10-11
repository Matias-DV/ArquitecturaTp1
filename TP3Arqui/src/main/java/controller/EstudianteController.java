{

@Autowired
private EstudianteService estudianteService;

@PostMapping
public ResponseEntity<Estudiante> addEstudiante(@RequestBody Estudiante estudiante) {
    Estudiante nuevoEstudiante = estudianteService.addEstudiante(estudiante);
    return new ResponseEntity<>(nuevoEstudiante, HttpStatus.CREATED);
}

@GetMapping("/legajo/{legajo}")
public ResponseEntity<EstudianteDTO> getEstudianteByLegajo(@PathVariable int legajo) {
    EstudianteDTO estudiante = estudianteService.getEstudianteByLegajo(legajo);
    return new ResponseEntity<>(estudiante, HttpStatus.OK);
}

@GetMapping("/genero/{genero}")
public List<EstudianteDTO> getEstudiantesByGenero(@PathVariable String genero) {
    return estudianteService.getEstudiantesByGenero(genero);
}

@DeleteMapping("/delete/{dni}")
public ResponseEntity<String> deleteEstudiante(@PathVariable int dni) {
    estudianteService.deleteEstudiante(dni);
    return ResponseEntity.ok("Estudiante eliminado con éxito");
}

@PutMapping("/update/{estudiante}")
public ResponseEntity<String> updateEstudiante(@PathVariable Estudiante estudiante) {
    estudianteService.updateEstudiante(estudiante);
    return ResponseEntity.ok("Estudiante actualizado con éxito");
}
}