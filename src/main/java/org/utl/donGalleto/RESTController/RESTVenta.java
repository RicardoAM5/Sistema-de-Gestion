package org.utl.donGalleto.RESTController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.utl.donGalleto.AppService.VentaAppService;
import org.utl.donGalleto.Model.Venta;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/venta")
public class RESTVenta {

    private final VentaAppService ventaAppService;

    public RESTVenta(VentaAppService ventaAppService) {
        this.ventaAppService = ventaAppService;
    }


    @PostMapping("/save")
    public ResponseEntity<?> insertarVenta( @RequestBody  Venta v) {
        try {
            ventaAppService.insertarVenta(v);
            return ResponseEntity.ok(v);
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
            List<Venta> venta = ventaAppService.getAllVenta();
            return ResponseEntity.ok(venta);
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", errorMessage);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }

    @GetMapping("/get")
    public ResponseEntity<?> buscarVenta(long idVenta) {
        try {
            Optional<Venta> v = ventaAppService.buscarVenta(idVenta);
            if (v.isPresent()) {
                Venta vnta = v.get();
                return ResponseEntity.ok(vnta);
            } else {
                Map<String, String> errorResponse = new HashMap<>();
                errorResponse.put("error", "La venta no existe ");
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
    public ResponseEntity<?> eliminarVenta(long idVenta) {
        try {
            ventaAppService.eliminarVenta(idVenta);
            Map<String, String> response = new HashMap<>();
            response.put("correcto", "venta eliminada");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "No se encontro ninguna venta para el id" + idVenta);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }
    @PutMapping("/update")
    public ResponseEntity<?> actualizarVenta(Venta v) {
        try {
            ventaAppService.actualizarVenta(v);
            return ResponseEntity.ok(v);
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", errorMessage);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }
}
