package services;

import dto.UsuarioCuentaDTO;
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

    public void deleteUsuarioCuenta(int idUsuarioCuenta) {
        usuarioCuentaRepository.deleteUsuarioCuenta(idUsuarioCuenta);
    }

    public void updateUsuarioCuenta(UsuarioCuenta uc) {
        usuarioCuentaRepository.updateUsuarioCuenta(uc.getUsuario(), uc.getCuenta());
    }

    public UsuarioCuentaDTO getUsuarioCuentaById(int idUsuarioCuenta) {
        return usuarioCuentaRepository.getUsuarioCuentaById(idUsuarioCuenta);
    }
}
