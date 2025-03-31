package view;

import models.Alumno;

import java.util.ArrayList;
import java.util.List;

public class AlumnoVista {
    private List<Alumno> alumnos = new ArrayList<>();

    public void mostrarAlumnos(List<Alumno> alu)
    {
        alu.forEach(System.out::println);
    }
}
