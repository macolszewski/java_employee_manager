package jem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Pracownik {
    String imie;
    String nazwisko;
    String stanowisko;
    int id;
    public static List<Integer> IDs = new ArrayList<>(Arrays.asList(new Integer(0)));

    Pracownik(String imie, String nazwisko, String stanowisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.stanowisko = stanowisko;
        this.setId();

    }


    public String getImie() {
        return imie;
    }


    public String getNazwisko() {
        return nazwisko;
    }


    public String getStanowisko() {
        return stanowisko;
    }

    public void setStanowisko(String stanowisko) {
        this.stanowisko = stanowisko;
    }

    public int getId() {
        return id;
    }

    public void setId() {
        if (this.id == 0) {

            Random losuj = new Random();
            int temp_id = 0;
            while (true) {
                temp_id = 10000 + losuj.nextInt(89999);
                if (!this.IDs.contains(Integer.getInteger(String.valueOf(temp_id)))) {
                    this.IDs.add(0,Integer.valueOf(temp_id));
                    this.id = temp_id;
                    break;
                } else {
                    continue;
                }
            }
        }
    }
}
