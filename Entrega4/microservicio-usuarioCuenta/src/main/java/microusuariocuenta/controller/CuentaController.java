package microusuariocuenta.controller;

import microusuariocuenta.services.CuentaService;
import microusuariocuenta.dto.CuentaDTO;
import microusuariocuenta.entity.Cuenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/cuentas")
public class CuentaController {

    @Autowired
    private CuentaService cuentaService;

    @PostMapping
    public ResponseEntity<Cuenta> addCuenta(@RequestBody Cuenta cuenta) {
        try{
            cuentaService.addCuenta(cuenta);
            return new ResponseEntity<>(cuenta, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<Cuenta> updateCuenta(@PathVariable int id, @RequestBody Cuenta cuenta) {
        try {
            if (cuentaService.getCuentaById(id) != null) {
                cuentaService.updateCuenta(cuenta);
                return new ResponseEntity<>(cuenta, HttpStatus.OK);
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/id/{id}")
    public ResponseEntity<String> deleteCuenta(@PathVariable int idCuenta){
        try {
            if (cuentaService.getCuentaById(idCuenta) != null) {
                cuentaService.deleteCuenta(idCuenta);
                return ResponseEntity.ok("Cuenta eliminada con éxito");
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cuenta no encontrada.");
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar la cuenta.");
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<CuentaDTO> getCuentaById(@PathVariable int id){
        try {
            if (cuentaService.getCuentaById(id) != null) {
                CuentaDTO c = cuentaService.getCuentaById(id);
                return new ResponseEntity<>(c, HttpStatus.OK);
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
            catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
    }

}