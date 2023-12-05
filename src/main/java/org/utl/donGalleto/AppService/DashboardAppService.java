package org.utl.donGalleto.AppService;

import org.springframework.stereotype.Service;
import org.utl.donGalleto.DAO.DashboardDAO;
import org.utl.donGalleto.Model.Dashboard;

import java.util.List;

@Service
public class DashboardAppService {

    private final DashboardDAO dashboardDAO;

    public DashboardAppService(DashboardDAO dashboardDAO) {
        this.dashboardDAO = dashboardDAO;
    }

    public List<Dashboard> getAllDashboard() throws Exception{
        return dashboardDAO.getAll();
    }
    public List<Dashboard> ventasFecha(String filtro) throws Exception{
        return dashboardDAO.ventasFecha(filtro);
    }
}
