package org.utl.donGalleto.RESTController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.utl.donGalleto.AppService.DashboardAppService;
import org.utl.donGalleto.Model.Dashboard;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/dashboard")
@CrossOrigin(origins = "*")
public class RESTDasboard {

    private final DashboardAppService dashboardAppService;

    public RESTDasboard(DashboardAppService dashboardAppService) {
        this.dashboardAppService = dashboardAppService;
    }


    @GetMapping("/getAll")
    public ResponseEntity<?> obtenerNombreYCantidad() {
        try {
            List<Dashboard> dashboard = dashboardAppService.getAllDashboard();
            return ResponseEntity.ok(dashboard);
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", errorMessage);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }

    @GetMapping("/ventasFecha")
    public ResponseEntity<?> ventasFecha(String filtro) {
        try {
            List<Dashboard> dashboard = dashboardAppService.ventasFecha(filtro);
            return ResponseEntity.ok(dashboard);
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", errorMessage);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }
}
