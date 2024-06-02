package com.Usuario.main.controllers;

import com.Usuario.main.entities.Usuario;
import com.Usuario.main.services.Usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
public class usuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/validate")
    public ResponseEntity<Map<String, String>> validateUser(@RequestBody Usuario usuario) {
        String email = usuario.getEmail();
        String contrasenia = usuario.getContrasenia();

        Optional<Usuario> existingUsuario = usuarioService.findByEmail(email);

        Map<String, String> response = new HashMap<>();

        if (existingUsuario.isPresent()) {
            String contraseniaEnBD = existingUsuario.get().getContrasenia();
            if (passwordEncoder.matches(contrasenia, contraseniaEnBD)) {
                response.put("message", "Usuario validado con éxito.");
                response.put("email", existingUsuario.get().getEmail());
                return ResponseEntity.ok(response);
            } else {
                response.put("message", "Correo o contraseña incorrectos.");
                return ResponseEntity.badRequest().body(response);
            }
        } else {
            response.put("message", "Usuario no encontrado.");
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<Map<String, String>> saveUser(@RequestBody Usuario usuario) {
        Usuario savedUsuario = usuarioService.save(usuario);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Usuario guardado con éxito.");
        response.put("userId", String.valueOf(savedUsuario.getId()));
        return ResponseEntity.ok(response);
    }
}
