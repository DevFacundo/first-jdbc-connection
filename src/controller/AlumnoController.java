package controller;

import DAO.AlumnoDAO;
import models.Alumno;
import view.AlumnoVista;

import java.util.List;

public class AlumnoController {
    private final AlumnoDAO alumnoDAO;
    private final AlumnoVista alumnoVista;

    public AlumnoController(AlumnoDAO alumnoDAO, AlumnoVista alumnoVista) {
        this.alumnoDAO = alumnoDAO;
        this.alumnoVista = alumnoVista;
    }

    public void listarAlumnos() {
        List<Alumno> alumnos = alumnoDAO.obtenerAlumnos();
        alumnoVista.mostrarAlumnos(alumnos);
    }

    public void addAlumno(Alumno alumno)
    {
        alumnoDAO.agregarAlumno(alumno);
    }

    /*public void addAlumno(String nombre,String apellido, int edad, String email) {
        alumnoDAO.agregarAlumno(new Alumno(0, nombre,apellido, edad,email));
    }
*/
    public void updateAlumno (Alumno alumno)
    {
        alumnoDAO.actualizarAlumno(alumno);
    }
    /*
    public void updateAlumno(int id, String nombre,String apellido, int edad, String email) {
        alumnoDAO.actualizarAlumno(new Alumno(id, nombre,apellido, edad,email));
    }
*/
    public void deleteAlumno(int id) {
        alumnoDAO.eliminarAlumno(id);
    }


}
