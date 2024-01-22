package org.utl.donGalleto.RESTController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.utl.donGalleto.AppService.MateriaPrimaAppService;
import org.utl.donGalleto.Model.MateriaPrima;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/materiaPrima")
@CrossOrigin(origins = "*")
public class RESTMateriaPrima {

    private final MateriaPrimaAppService materiaPrimaAppService;


    public RESTMateriaPrima(MateriaPrimaAppService materiaPrimaAppService) {
        this.materiaPrimaAppService = materiaPrimaAppService;
    }


    @PostMapping("/save")
    public ResponseEntity<?> insertarMateriaPrima(@RequestBody  MateriaPrima mp) {
        try {
            materiaPrimaAppService.insertarMateriaPrima(mp);
            return ResponseEntity.ok(mp);
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
            List<MateriaPrima> materiaPrima = materiaPrimaAppService.getAll();
            return ResponseEntity.ok(materiaPrima);
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", errorMessage);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }

    @GetMapping("/get/{idMateriaPrima}")
    public ResponseEntity<?> buscarMateriaPrima(@PathVariable long idMateriaPrima) {
        try {
            Optional<MateriaPrima> mp = materiaPrimaAppService.buscarMateriaPrima(idMateriaPrima);
            if (mp.isPresent()) {
                MateriaPrima materiaPrima = mp.get();
                return ResponseEntity.ok(materiaPrima);
            } else {
                Map<String, String> errorResponse = new HashMap<>();
                errorResponse.put("error", "No se encontró ninguna materia prima para el ID proporcionado");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
            }
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", errorMessage);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }

    @DeleteMapping("/delete/{idMateriaPrima}")
    public ResponseEntity<?> eliminarMateriaPrima(@PathVariable long idMateriaPrima) {
        try {
            materiaPrimaAppService.eliminarMateriaPrima(idMateriaPrima);
            Map<String, String> response = new HashMap<>();
            response.put("correcto", "materia prima eliminada");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "No se encontro nignuna galleta para el id" + idMateriaPrima);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }
    @PutMapping("/update")
    public ResponseEntity<?> actualizarMateriaPrima(@RequestBody MateriaPrima mp) {
        try {
            materiaPrimaAppService.actualizarMateriaPrima(mp);
            return ResponseEntity.ok(mp);
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", errorMessage);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }

}
