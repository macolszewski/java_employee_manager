package jem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {
    public static Scanner input = new Scanner(System.in);

    static void ShowMainMenu() {
        boolean isMenuOn = true;
        while (isMenuOn) {
            System.out.println("| M -- E -- N -- U |");
            System.out.println("\t1. Dodaj pracownika");
            System.out.println("\t2. Usuń pracownika po ID");
            System.out.println("\t3. Wyszukaj pracownika");
            System.out.println("\t4. Wyświetl listę pracowników");
            System.out.println("\t5. Wyświetl listę pracowników na danym stanowisku");
            System.out.println("\t6. Zakończ program");
            int handler;
            handler = input.nextInt();
            switch (handler) {
                case 1:
                    Firma.addEmployee();
                    break;
                case 2:
                    Firma.removeEmployee();
                    break;
                case 3:
                    showSearchMenu();
                    break;
                case 4:
                    showEmployeeList();
                    break;
                case 5:
                    showEmployeeListBy();
                    break;
                case 6:
                    isMenuOn = false;
                    Menu.input.close();
                    System.out.println("\tKoniec programu!");
                    System.gc();
                    break;
            }
        }

    }

    static void showSearchMenu() {
        boolean isSearchMenuOn = true;
        while (isSearchMenuOn) {
            System.out.println("  | WYSZUKAJ PRACOWNIKA |  ");
            System.out.println("1. Po ID");
            System.out.println("2. Po Imieniu");
            System.out.println("3. Po Nazwisku");
            System.out.println("4. Po Stanowisku");
            System.out.println("5. Menu główne");
            int search_handler;
            search_handler = input.nextInt();
            Firma.searchEmployee(search_handler);
            if (search_handler == 5) {
                isSearchMenuOn = false;
            }
        }
    }

    static void showEmployeeList() {
        int i = 1;
        System.out.println("Lista pracowników: ");
        for (Pracownik employee : Firma.employees) {
            System.out.println(String.valueOf(i++) + ". " + employee);
        }
    }


    static void showEmployeeListBy() {
        int i = 1;
        List<Pracownik> temp_employees = new ArrayList<>(Arrays.asList());
        System.out.println("Wybierz stanowisko: ");
        for (Enum stanowisko : Stanowisko.values()) {
            System.out.println("\t"+String.valueOf(i++)+". "+stanowisko);
        }
        int stanowisko_val = Menu.input.nextInt();
        Enum stanowisko = Stanowisko.values()[stanowisko_val-1];
        for (Pracownik employee : Firma.employees) {
            if (employee.getStanowisko()==stanowisko)
                temp_employees.add(employee);
        }
        System.out.println("Lista pracowników: ");
        for (Pracownik employee : temp_employees) {
            System.out.println(String.valueOf(i++) + ". " + employee);
        }
    }
}
