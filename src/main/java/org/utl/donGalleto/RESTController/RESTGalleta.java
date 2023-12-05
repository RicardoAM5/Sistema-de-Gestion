package org.utl.donGalleto.RESTController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.utl.donGalleto.AppService.GalletaAppService;
import org.utl.donGalleto.Model.Galleta;
import org.utl.donGalleto.Model.Inventario;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/galleta")
@CrossOrigin(origins = "*")
public class RESTGalleta {

    private final GalletaAppService galletaAppService;

    public RESTGalleta(GalletaAppService galletaAppService) {
        this.galletaAppService = galletaAppService;
    }

    @PostMapping("/save")
    public ResponseEntity<?> insertarGalleta(Galleta g) {
        try {
            galletaAppService.insertarGalleta(g);
            return ResponseEntity.ok(g);
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
            List<Galleta> galletas = galletaAppService.getAll();
            return ResponseEntity.ok(galletas);
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", errorMessage);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }

    @GetMapping("/get")
    public ResponseEntity<?> getGalleta(long idGalleta) {
        try {
            Optional<Galleta> g = galletaAppService.buscarGalleta(idGalleta);
            if (g.isPresent()) {
                Galleta galleta = g.get();
                return ResponseEntity.ok(galleta);
            } else {
                Map<String, String> errorResponse = new HashMap<>();
                errorResponse.put("error", "No se encontró ninguna galleta para el ID proporcionado");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
            }
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", errorMessage);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> eliminarGalleta(long idGalleta) {
        try {
            galletaAppService.eliminarGalleta(idGalleta);
            Map<String, String> response = new HashMap<>();
            response.put("correcto", "galleta eliminada");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "No se encontro nignuna galleta para el id" + idGalleta);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }
    @PutMapping("/update")
    public ResponseEntity<?> actualizarGalleta(Galleta g) {
        try {
            galletaAppService.actualizarGalleta(g);
            return ResponseEntity.ok(g);
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", errorMessage);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }



}
