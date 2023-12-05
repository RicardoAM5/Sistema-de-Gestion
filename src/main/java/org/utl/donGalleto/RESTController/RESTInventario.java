package org.utl.donGalleto.RESTController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.utl.donGalleto.AppService.InventarioAppService;
import org.utl.donGalleto.Model.Inventario;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/inventario")
@CrossOrigin(origins = "*")

public class RESTInventario {
    private final InventarioAppService inventarioAppService;

    public RESTInventario(InventarioAppService inventarioAppService) {
        this.inventarioAppService = inventarioAppService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> obtenerNombreYCantidad() {
        try {
            List<Inventario> inventario = inventarioAppService.getAllInventario();
            return ResponseEntity.ok(inventario);
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", errorMessage);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }


    @PutMapping("/updateInventario")
    public ResponseEntity<?> actualizarCantidadGalleta(String nombre, String cantidad) {
        try {
            Map<String, String> response = new HashMap<>();
            response.put("correcto", "datos actualizados");
            inventarioAppService.actualizarInventario(nombre,cantidad);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", errorMessage);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }
}
