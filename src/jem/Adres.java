package jem;

public class Adres {
    private String ulica;
    private String nr_domu;
    private String kod_pocztowy;
    private String miasto;

    public Adres() {
        System.out.println("Podaj "+this.toString().split("\\{")[0]+" : ");
        System.out.print("\tUlica: ");
        this.ulica = Menu.input.next();
        System.out.print("\tNr domu: ");
        this.nr_domu = Menu.input.next();
        System.out.print("\tKod pocztowy: ");
        this.kod_pocztowy = Menu.input.next();
        System.out.print("\tMiasto: ");
        this.miasto = Menu.input.next();
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getNr_domu() {
        return nr_domu;
    }

    public void setNr_domu(String nr_domu) {
        this.nr_domu = nr_domu;
    }

    public String getKod_pocztowy() {
        return kod_pocztowy;
    }

    public void setKod_pocztowy(String kod_pocztowy) {
        this.kod_pocztowy = kod_pocztowy;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    @Override
    public String toString() {
        return "Adres{" + ulica  +
                " " + nr_domu +
                ", " + kod_pocztowy +
                " " + miasto +
                '}';
    }
}
