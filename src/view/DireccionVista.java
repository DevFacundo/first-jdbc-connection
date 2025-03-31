package view;

import models.Direccion;

import java.util.ArrayList;
import java.util.List;

public class DireccionVista {
    private List<Direccion> direcciones = new ArrayList<>();

    public void mostrarDirecciones(List<Direccion> direc)
    {
        direc.forEach(System.out::println);
    }
}
