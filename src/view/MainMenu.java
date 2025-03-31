package view;

import DAO.AlumnoDAO;
import DAO.DireccionDAO;
import config.DBConnection;
import controller.AlumnoController;
import controller.DireccionController;
import models.Alumno;
import models.Direccion;
import services.AlumnoService;
import services.DireccionService;

import java.util.Scanner;

public class MainMenu {

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        // INSTANCIAS PARA ALUMNO
        AlumnoService alumnoService = new AlumnoService();
        AlumnoDAO alumnoDAO = new AlumnoDAO();
        AlumnoVista alumnoVista = new AlumnoVista();
        AlumnoController alumnoController= new AlumnoController(alumnoDAO, alumnoVista);

        // INSTANCIAS PARA DIRECCION
        DireccionService direccionService = new DireccionService();
        DireccionDAO direccionDAO = new DireccionDAO();
        DireccionVista direccionVista = new DireccionVista();
        DireccionController direccionController = new DireccionController(direccionDAO,direccionVista);



        while (true)
        {
           opciones();
           int opcion = scanner.nextInt();
           scanner.nextLine();

           switch (opcion)
           {
            case 1 -> alumnoController.addAlumno(alumnoService.ingresarAlumno(scanner));
            case 2 -> direccionController.addDireccion(direccionService.ingresarDireccion(scanner));
            case 3 -> alumnoController.listarAlumnos();
            case 4 -> direccionController.listarDirecciones();
            case 5 ->
            {
                Integer id = alumnoService.pedirId();
                if (id != null)
                {
                    Alumno alumno = alumnoDAO.obtenerAlumnoPorId(id);
                    if (alumno != null)
                    {
                        Alumno alumnonew = alumnoService.actualizarAlumnito(scanner,alumno);
                        alumnoController.updateAlumno(alumnonew);
                    }else
                    {
                        System.out.println("no se encontro alumno con ese id");
                        break;
                    }
                }
            }
            case 6 -> {
                Integer id = alumnoService.pedirId();

                if (id != null) {
                    Alumno alumno = alumnoDAO.obtenerAlumnoPorId(id);
                    if (alumno != null) {
                        alumnoController.deleteAlumno(id);
                        System.out.println("Alumno eliminado con exito");
                    } else {
                        System.out.println("No hay alumnos con dicho id");
                    }
                } else {
                    System.out.println("operacion cancelada id nulo");
                }
            }
            case 7 ->
            {
                Integer id = direccionService.pedirId();

                if (id != null)
                {
                    Direccion direccion = direccionDAO.obtenerDireccionPorId(id);

                    if ( direccion != null)
                    {
                        direccionController.deleteDireccion(id);
                        System.out.println("Direccion eliminada con exito");
                    }else
                    {
                        System.out.println("No hay direcciones con tal id");
                    }
                } else
                {
                    System.out.println("Operacion cancelada por id nulo");
                }
            }
            case 0 ->
            {
                System.out.println("SALIENDO....");
                DBConnection.getInstance().cerrarConexion();
                scanner.close();
                return;
            }

            default -> System.out.println("Opcion no valida");

           }
        }
    }


    public static void opciones(){
        System.out.println("\nSeleccione una opción:");
        System.out.println("1. Agregar Alumno");
        System.out.println("2. Ingresar Direccion");
        System.out.println("---------------------");
        System.out.println("3. Listar Alumnos");
        System.out.println("4. Listar Direcciones");
        System.out.println("---------------------");
        System.out.println("5. Actualizar Edad Alumno");
        System.out.println("---------------------");
        System.out.println("6. Eliminar Alumno");
        System.out.println("7. Eliminar Direccion");
        System.out.println("0. Salir");
        System.out.println("Seleccione una opcion (1-7) o 0 para salir:");
    }
}
