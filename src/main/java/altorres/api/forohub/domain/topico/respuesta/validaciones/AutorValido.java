package altorres.api.forohub.domain.topico.respuesta.validaciones;

import altorres.api.forohub.domain.usuario.UsuarioRepository;
import altorres.api.forohub.domain.topico.respuesta.DatosCrearRespuesta;
import altorres.api.forohub.infra.errores.ValidacionDeIntegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AutorValido implements ValidadorRespuesta {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public void validar(DatosCrearRespuesta datos) {
        if (datos.idAutor() == null || !usuarioRepository.existsById(datos.idAutor())) {
            throw new ValidacionDeIntegridad("Autor no encontrado");
        }
    }
}
