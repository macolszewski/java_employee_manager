package jem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Pracownik {
    String imie;
    String nazwisko;
    Enum stanowisko;
    String id = "";
    Adres adres;
    AdresFirmowy adresFirmowy;

    public static List<String> IDs = new ArrayList<>(Arrays.asList(String.valueOf(0)));

    Pracownik() {
        System.out.print("Podaj imię: ");
        this.imie = Menu.input.next();
        System.out.print("Podaj nazwisko: ");
        this.nazwisko = Menu.input.next();
        System.out.println("Wybierz stanowisko: ");
        int i = 1;
        for (Enum stanowisko : Stanowisko.values()) {
            System.out.println("\t"+String.valueOf(i++) + ". " + stanowisko);
        }
        int stanowisko_val = Menu.input.nextInt();
        Enum stanowisko = Stanowisko.values()[stanowisko_val - 1];
        this.stanowisko = stanowisko;
        this.adres = new Adres();
        this.adresFirmowy = new AdresFirmowy();
        this.setId();


    }


    public String getImie() {
        return imie;
    }


    public String getNazwisko() {
        return nazwisko;
    }

    @Override
    public String toString() {
        return "Pracownik{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", stanowisko=" + stanowisko +
                ", id='" + id + '\'' +
                ", adres=" + adres +
                ", adresFirmowy=" + adresFirmowy +
                '}';
    }

    public Enum getStanowisko() {
        return stanowisko;
    }


    public String getId() {
        return id;
    }

    public void setId() {
        if (this.id.equals("")) {

            Random losuj = new Random();
            int temp_id = 0;
            while (true) {
                temp_id = 10000 + losuj.nextInt(89999);
                if (!this.IDs.contains(String.valueOf(temp_id))) {
                    this.IDs.add(0, String.valueOf(temp_id));
                    this.id = String.valueOf(temp_id);
                    break;
                } else {
                    continue;
                }
            }
        }
    }


}
