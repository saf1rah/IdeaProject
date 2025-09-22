package modul4.codelab.main.kendaraan.khusus;

import modul4.codelab.main.kendaraan.Kendaraan;
import modul4.codelab.main.kendaraan.util.Flyable;

public class Pesawat extends Kendaraan implements Flyable {
    @Override
    public void Start() {
        System.out.println("Mennyalakan pesawat " + this.getName());
    }

    @Override
    public void Stop() {
        System.out.println("Mematikan mesin pesawat " + this.getName());
    }

    @Override
    public void Brake() {System.out.println("Pesawat tidak lepas landas ");}

    @Override
    public void fly() {
        System.out.println("Pesawat " + this.getName() + " lepas landas");
    }
}
