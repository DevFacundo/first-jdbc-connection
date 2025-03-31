package services;



import models.Direccion;

import java.util.Scanner;

public class DireccionService {
    Scanner scanner = new Scanner(System.in);

    public Direccion ingresarDireccion(Scanner scanner){
        System.out.println("Ingrese Direccion del Alumno(sin numeros): ");
        String adress = scanner.nextLine();

        int number = 0;
        while (true) {
            try {
                System.out.println("Ingrese la Altura de la direccion: ");
                number = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número válido para la altura.");
            }
        }
        int id_alumno = 0;
        while (true) {
            try {
                System.out.println("Ingrese id de alumno valido: ");
                id_alumno = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número válido para el id del alumno.");
            }
        }

        return new Direccion(0,adress,number,id_alumno);
    }

    public Integer pedirId ()
    {
        while (true) {
            System.out.print("Ingrese el ID de la direccion (o 0 para cancelar): ");
            String input = scanner.nextLine();

            try {
                int id = Integer.parseInt(input);
                if (id == 0) {
                    System.out.println("Operación cancelada.");
                    return null;
                }
                return id;
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Ingrese un número válido.");
            }
        }

    }
}
