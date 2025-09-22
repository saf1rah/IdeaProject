package modul4.codelab.main.kendaraan.pribadi;

import modul4.codelab.main.kendaraan.Kendaraan;

public class Motor extends Kendaraan {
    @Override
    public void Start(){
        System.out.println("Motor " + this.getName() + " berjalan");
    }

    @Override
    public void Stop() {
        System.out.println("Motor " + this.getName() + " dimatikan");
    }

    @Override
    public void Brake() {
        System.out.println("Motor berhenti ");
    }
}