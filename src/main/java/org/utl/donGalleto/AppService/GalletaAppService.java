package org.utl.donGalleto.AppService;

import org.springframework.stereotype.Service;
import org.utl.donGalleto.CQRS.GalletaCQRS;
import org.utl.donGalleto.DAO.GalletaDAO;
import org.utl.donGalleto.Model.Galleta;
import org.utl.donGalleto.Model.Inventario;

import java.util.List;
import java.util.Optional;

@Service
public class GalletaAppService {

    private final GalletaDAO galletaDAO;
    private final GalletaCQRS galletaCQRS;

    public GalletaAppService(GalletaDAO galletaDAO, GalletaCQRS galletaCQRS) {
        this.galletaDAO = galletaDAO;
        this.galletaCQRS = galletaCQRS;
    }

    public void insertarGalleta(Galleta g) throws Exception {
        galletaDAO.insertarGalleta(g);
    }

    public void actualizarGalleta(Galleta g) throws Exception {
        galletaCQRS.actualizarGalleta(g);
    }

    public List<Galleta> getAll() throws Exception {
        return galletaDAO.getAllGalleta();
    }

    public Optional<Galleta> buscarGalleta(long idGalleta) {
        return galletaDAO.buscarGalleta(idGalleta);
    }

    public void eliminarGalleta(long idGalleta) throws Exception {
        try {
            galletaDAO.eliminarGalleta(idGalleta);
        } catch (Exception e) {
            throw new Exception("No se encontro galleta con el id " + idGalleta);
        }
    }





}
