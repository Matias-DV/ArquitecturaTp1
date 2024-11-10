package services;

import entities.UsuarioCuenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.UsuarioCuentaRepository;

@Service
public class UsuarioCuentaService {

    @Autowired
    private UsuarioCuentaRepository usuarioCuentaRepository;

    public UsuarioCuenta addUsuarioCuenta(UsuarioCuenta usuarioCuenta) {
        return usuarioCuentaRepository.save(usuarioCuenta);
    }

    public void deleteUsuarioCuenta(UsuarioCuenta usuarioCuenta) {
        usuarioCuentaRepository.delete(usuarioCuenta);
    }
}
