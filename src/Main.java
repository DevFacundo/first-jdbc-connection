import DAO.AlumnoDAO;
import DAO.DireccionDAO;
import controller.AlumnoController;
import controller.DireccionController;
import models.Alumno;
import models.Direccion;
import view.AlumnoVista;
import view.DireccionVista;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        AlumnoDAO alumnoDAO = new AlumnoDAO();
        AlumnoVista alumnoVista = new AlumnoVista();
        AlumnoController alumnoController = new AlumnoController(alumnoDAO,alumnoVista);


        DireccionDAO direccionDAO = new DireccionDAO();
        DireccionVista direccionVista = new DireccionVista();
        DireccionController direccionController = new DireccionController(direccionDAO,direccionVista);


        //alumnoController.addAlumno(new Alumno(0,"Facundo","Aguilera", 31, "facuaguilera@blabla.com"));
       // alumnoController.listarAlumnos();
        //direccionController.addDireccion("Mascias",2069,6);
        //direccionController.listarDirecciones();

    }
}