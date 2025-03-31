package controller;

import DAO.DireccionDAO;
import models.Direccion;
import view.DireccionVista;
import java.util.List;

public class DireccionController {
    private final DireccionDAO direccionDAO;
    private final DireccionVista direccionVista;

    public DireccionController(DireccionDAO direccionDAO,DireccionVista direccionVista) {
        this.direccionDAO = direccionDAO;
        this.direccionVista = direccionVista;
    }

    public void listarDirecciones() {
        List<Direccion> direcciones = direccionDAO.obtenerDirecciones();
        direccionVista.mostrarDirecciones(direcciones);
    }
    public void addDireccion(Direccion direccion)
    {
        direccionDAO.agregarDireccion(direccion);
    }
/*
    public void addDireccion(String calle,int altura, int id_alumno) {
        direccionDAO.agregarDireccion(new Direccion(0, calle,altura,id_alumno));
    }
*/
    public void updateDireccion(int id, String calle,int altura, int id_alumno) {
        direccionDAO.actualizarDireccion(new Direccion(id, calle,altura,id_alumno));
    }

    public void deleteDireccion(int id) {
        direccionDAO.eliminarDireccion(id);
    }
}
