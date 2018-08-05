package jem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Firma {
    public static List<Pracownik> employees = new ArrayList<>(Arrays.asList());

    public static void addEmployee() {
        Pracownik pracownik = new Pracownik();
        if (!Firma.employees.contains(pracownik)) {

            Firma.employees.add(0, pracownik);
            System.out.println("Dodano pracownika: " + Firma.employees.get(0).getImie() + " "
                    + Firma.employees.get(0).getNazwisko() + " " + Firma.employees.get(0).getId());
        } else {
            System.out.println(pracownik + " jest już na liście!");
        }

    }

    public static void removeEmployee() {
        System.out.println("Podaj ID pracownika którego mam wywalić: ");
        String id = Menu.input.next();
        Pracownik employee_to_delete = null;
        for (Pracownik employee : Firma.employees) {
            if (employee.getId().equals(id)) {
                employee_to_delete = employee;
            }
        }
        if (employee_to_delete != null) {
            String imie_temp = employee_to_delete.getImie();
            String nazwisko_temp = employee_to_delete.getNazwisko();
            Firma.employees.remove(employee_to_delete);
            System.out.println("Usunięto pracownika: " + imie_temp + " " + nazwisko_temp);
        }
    }

    public static void searchEmployee(int option_code) {
        List<Pracownik> search_list = new ArrayList<>(Arrays.asList());
        switch (option_code) {
            case 1:
                System.out.println("Podaj ID: ");
                String search_id = Menu.input.next();
                for (Pracownik employee : Firma.employees) {
                    if (employee.getId().equals(search_id)) {
                        search_list.add(0, employee);
                    }
                }
                break;
            case 2:
                System.out.println("Podaj Imię: ");
                String search_name = Menu.input.next();
                for (Pracownik employee : Firma.employees) {
                    if (employee.getImie().equals(search_name)) {
                        search_list.add(0, employee);
                    }
                }
                break;
            case 3:
                System.out.println("Podaj Nazwisko: ");
                String search_surname = Menu.input.next();
                for (Pracownik employee : Firma.employees) {
                    if (employee.getNazwisko().equals(search_surname)) {
                        search_list.add(0, employee);
                    }
                }
                break;
            case 4:
                System.out.println("Wybierz stanowisko: ");
                int i = 1;
                for (Enum stanowisko : Stanowisko.values()) {
                    System.out.println(String.valueOf(i++) + ". " + stanowisko);
                }
                int stanowisko_val = Menu.input.nextInt();
                Enum stanowisko = Stanowisko.values()[stanowisko_val - 1];
                for (Pracownik employee : Firma.employees) {
                    if (employee.getStanowisko() == stanowisko) {
                        search_list.add(0, employee);
                    }
                }
                break;


        }
        System.out.println();
        System.out.println("Wynik wyszukiwania: ");
        int i = 1;
        for (Pracownik found_employee : search_list) {
            System.out.println(String.valueOf(i++) + ". " + found_employee.getImie() + " " + found_employee.getNazwisko() +
                    " " + found_employee.getStanowisko() + " | ID: " + found_employee.getId());
        }
        System.out.println();
        search_list.clear();
    }

}
