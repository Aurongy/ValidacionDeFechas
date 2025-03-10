//Realizar en java un programa que solicite una fecha con el formato dd/mm/yyyy y 
// //muestre en consola si la fecha ingresada es la correcta. Debe validar años bisiestos. 

import java.util.Scanner;

public class ValidacionDeFechas {
    public static void main(String[] args) {
        Scanner fecha = new Scanner(System.in);

        System.out.print("Ingrese una fecha en este formato (dd/mm/yyyy): ");
        String fecha1 = fecha.nextLine();

        String[] partesFecha = fecha1.split("/");
        int dia = Integer.parseInt(partesFecha[0]);
        int mes = Integer.parseInt(partesFecha[1]);
        int año = Integer.parseInt(partesFecha[2]);

        if (esFechaValida(dia, mes, año)) {
            System.out.println("La fecha es correcta.");
        } else {
            System.out.println("La fecha es incorrecta.");
        }
    }

    public static boolean esFechaValida(int dia, int mes, int año) {

        if (mes < 1 || mes > 12) {
            return false;
        }


        int maximoDias = getMaximoDias(mes, año);
        if (dia < 1 || dia > maximoDias) {
            return false;
        }

        // Verificamos si el año es bisiesto
        if (esAñoBisiesto(año)) {
            if (mes == 2 && dia > 29) {
                return false;
            }
        } else {
            if (mes == 2 && dia > 28) {
                return false;
            }
        }

        return true;
    }

    public static int getMaximoDias(int mes, int año) {
        switch (mes) {
            case 1, 3, 5, 7, 8, 10, 12 -> {
                return 31;
            }
            
            case 4, 6, 9, 11 -> {
                return 30;
            }
            case 2 -> {
                if (esAñoBisiesto(año)) {
                    return 29;
                } else {
                    return 28;
                }
            }
        }
        return 0;
    }

    public static boolean esAñoBisiesto(int año) {
        if (año % 4 != 0) {
            return false;
        } else if (año % 100 != 0) {
            return true;
        } else return año % 400 == 0;
    }
}
