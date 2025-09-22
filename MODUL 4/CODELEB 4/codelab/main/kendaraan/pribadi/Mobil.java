package modul4.codelab.main.kendaraan.pribadi;

import modul4.codelab.main.kendaraan.Kendaraan;

public class Mobil extends Kendaraan {
    @Override
    public void Start() {
        System.out.println("Mobil " + this.getName() + " dinyalakan");
    }

    @Override
    public void Stop() {
        System.out.println("Mobil " + this.getName() + " dimatikan");
    }

    @Override
    public void Brake() {
        System.out.println("Mobil berhenti ");
    }
}