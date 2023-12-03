package org.utl.donGalleto.AppService;

import org.springframework.stereotype.Service;
import org.utl.donGalleto.CQRS.MateriaPrimaCQRS;
import org.utl.donGalleto.DAO.MateriaPrimaDAO;
import org.utl.donGalleto.Model.MateriaPrima;

import java.util.List;
import java.util.Optional;

@Service
public class MateriaPrimaAppService {
    private final MateriaPrimaDAO materiaPrimaDAO;
    private final MateriaPrimaCQRS materiaPrimaCQRS;


    public MateriaPrimaAppService(MateriaPrimaDAO materiaPrimaDAO, MateriaPrimaCQRS materiaPrimaCQRS) {
        this.materiaPrimaDAO = materiaPrimaDAO;
        this.materiaPrimaCQRS = materiaPrimaCQRS;
    }

    public void insertarMateriaPrima (MateriaPrima mp) throws Exception {
        materiaPrimaCQRS.insertarMateriaPrima(mp);

    }

    public void actualizarMateriaPrima(MateriaPrima mp) throws Exception {
        materiaPrimaCQRS.actualizarMateriaPrima(mp);
    }

    public List<MateriaPrima> getAll()throws Exception{
        return materiaPrimaDAO.getAllMateriaPrima();
    }

    public Optional<MateriaPrima> buscarMateriaPrima(long idMateriaPrima){
        return materiaPrimaDAO.buscarMateriaPrima(idMateriaPrima);
    }

    public void eliminarMateriaPrima(long idMateriaPrima) throws Exception{
        try {
            materiaPrimaDAO.eliminarMateriaPrima(idMateriaPrima);
        } catch (Exception e) {
            throw new Exception("No se encontro la materia prima con el id " + idMateriaPrima);
        }
    }


}
