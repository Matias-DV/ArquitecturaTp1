package controllers;

import dto.UsuarioCuentaDTO;
import entities.UsuarioCuenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.UsuarioCuentaService;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("api/usuarioCuentas")
public class UsuarioCuentaController {

    @Autowired
    private UsuarioCuentaService usuarioCuentaService;

    @PostMapping
    public ResponseEntity<UsuarioCuenta> addUsuario(@RequestBody UsuarioCuenta usuarioCuenta) {
        try {
            usuarioCuentaService.addUsuarioCuenta(usuarioCuenta);
            return new ResponseEntity<>(usuarioCuenta, HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteUsuarioCuenta(@RequestBody int idUsuarioCuenta){
        try{
            usuarioCuentaService.deleteUsuarioCuenta(idUsuarioCuenta);
            return ResponseEntity.ok("UsuarioCuenta eliminado correctamente");
        }
        catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("UsuarioCuenta no encontrado.");
        }
        catch(Exception e){
            return ResponseEntity.badRequest().body("Error al eliminar el usuarioCuenta");
        }
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<UsuarioCuenta> updateUsuarioCuenta(@PathVariable int id, @RequestBody UsuarioCuenta usuarioCuenta){
        try{
            if(usuarioCuentaService.getUsuarioCuentaById(id) != null){
                usuarioCuentaService.updateUsuarioCuenta(usuarioCuenta);
                return new ResponseEntity<>(usuarioCuenta, HttpStatus.OK);
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/id/{id}")
    public ResponseEntity<UsuarioCuentaDTO> getUsuarioCuentaById(@PathVariable int id) {
        try {
            if (usuarioCuentaService.getUsuarioCuentaById(id) != null) {
                return new ResponseEntity<>(usuarioCuentaService.getUsuarioCuentaById(id), HttpStatus.OK);
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
