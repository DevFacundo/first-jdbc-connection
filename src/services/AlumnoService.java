package services;

import models.Alumno;

import java.util.Scanner;

public class AlumnoService {
        Scanner scanner = new Scanner(System.in);

        public Alumno ingresarAlumno(Scanner scanner){
            System.out.println("Ingrese Nombre Alumno: ");
            String name = scanner.nextLine();
            System.out.println("Ingrese Apellido Alumno: ");
            String surName = scanner.nextLine();

            int age = 0;
            while (true) {
                try {
                    System.out.println("Ingrese Edad Alumno: ");
                    age = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Error: Ingrese un número válido para la edad.");
                }
            }

            System.out.println("Ingrese email Alumno: ");
            String email = scanner.nextLine();

            System.out.println("alumno agregado con exito");
            return new Alumno(0,name,surName,age,email);

        }
        public Integer pedirId ()
        {
            while (true) {
                System.out.print("Ingrese el ID del alumno (o 0 para cancelar): ");
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

        public Alumno actualizarAlumnito(Scanner scanner, Alumno alumno)
        {
            while (true) {
                System.out.println("Que dato del alumno deseas cambiar?");
                System.out.println("[1] NOMBRE");
                System.out.println("[2] APELLIDO");
                System.out.println("[3] EDAD");
                System.out.println("[4] EMAIL");
                System.out.println("-------------");
                System.out.println("[0] SALIR");
                System.out.println("Seleccione un numero[1-4] o 0 para SALIR");

                int opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1 -> {
                        System.out.println("Ingrese nuevo nombre: ");
                        String name = scanner.nextLine();
                        alumno.setNombre(name);
                    }
                    case 2 -> {
                        System.out.println("Ingrese nuevo apellido: ");
                        String surname = scanner.nextLine();
                        alumno.setApellido(surname);
                    }
                    case 3 -> {
                        int age = 0;
                        while (true) {
                            try {
                                System.out.println("Ingrese nueva Edad Alumno: ");
                                age = Integer.parseInt(scanner.nextLine());
                                alumno.setEdad(age);
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("Error: Ingrese un número válido para la edad.");
                            }
                        }
                    }
                    case 4 -> {
                        System.out.println("Ingrese nuevo EMAIL: ");
                        String email = scanner.nextLine();
                        alumno.setEmail(email);

                    }
                    case 0 -> {
                        System.out.println("Saliendo...");
                        return alumno;
                    }
                    default -> System.out.println("OPCION INVALIDA");
                }
            }
        }
}
