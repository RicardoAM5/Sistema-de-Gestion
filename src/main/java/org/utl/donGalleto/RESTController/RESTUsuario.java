package org.utl.donGalleto.RESTController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.utl.donGalleto.AppService.UsuarioAppService;
import org.utl.donGalleto.Model.Usuario;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuario")
@CrossOrigin(origins = "*")
public class RESTUsuario {

    private final UsuarioAppService usuarioAppService;

    public RESTUsuario(UsuarioAppService usuarioAppService) {
        this.usuarioAppService = usuarioAppService;
    }


    @PostMapping("/save")
    public ResponseEntity<?> insertarUsuario(@RequestBody Usuario u) {
        try {
            usuarioAppService.insertarUsuario(u);
            return ResponseEntity.ok(u);
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", errorMessage);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        try {
            List<Usuario> usuario = usuarioAppService.getAllUsuario();
            return ResponseEntity.ok(usuario);
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", errorMessage);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }

    @GetMapping("/login")
    public ResponseEntity<?> buscarUsuario(@RequestParam String usuario,@RequestParam String contrasenia) throws Exception {
        try {
           Usuario usr = usuarioAppService.buscarUsuario(usuario, contrasenia);
            return ResponseEntity.ok(usr) ;
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", errorMessage);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }




    @DeleteMapping("/delete/{idUsuario}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable long idUsuario) {
        try {
            usuarioAppService.eliminarUsuario(idUsuario);
            Map<String, String> response = new HashMap<>();
            response.put("correcto", "usuario eliminado");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "No se encontro nignuna usuario para el id" + idUsuario);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> actualizarUsuario( @RequestBody Usuario u) {
        try {
            usuarioAppService.actualizarUsuario(u);
            return ResponseEntity.ok(u);
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", errorMessage);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }
}
