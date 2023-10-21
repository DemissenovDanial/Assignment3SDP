interface Charger {
    void connect();
}

interface Socket {
    void plugIn(Charger Charger);
}

class SocketTypeA implements Socket {
    public void plugIn(Charger charger) {
        System.out.println("Подключение к розетке типа A");
        charger.connect();
    }
}

class ChargerTypeA implements Charger {
    public void connect() {
        System.out.println("Подключена зарядка типа A");
    }
}

class SocketTypeB implements Socket {
    public void plugIn(Charger charger) {
        System.out.println("Подключение к розетке типа B");
        charger.connect();
    }
}

class ChargerTypeB implements Charger {
    public void connect() {
        System.out.println("Подключена зарядка типа B");
    }
}

class AdapterAToB implements Charger {
    private ChargerTypeA chargerTypeA;

    public AdapterAToB(ChargerTypeA chargerTypeA) {
        this.chargerTypeA = chargerTypeA;
    }

    public void connect() {
        System.out.println("Используется адаптер для подключения к розетке типа B");
        chargerTypeA.connect();
    }
}

class AdapterBToA implements Charger {
    private ChargerTypeB chargerTypeB;

    public AdapterBToA(ChargerTypeB chargerTypeB) {
        this.chargerTypeB = chargerTypeB;
    }

    public void connect() {
        System.out.println("Используется адаптер для подключения к розетке типа A");
        chargerTypeB.connect();
    }
}

public class Assignment3 {
    public static void main(String[] args) {
        ChargerTypeA chargerTypeA = new ChargerTypeA();
        ChargerTypeB chargerTypeB = new ChargerTypeB();

        SocketTypeA socketTypeA = new SocketTypeA();
        SocketTypeB socketTypeB = new SocketTypeB();

        AdapterAToB adapterAToB = new AdapterAToB(chargerTypeA);
        AdapterBToA adapterBToA = new AdapterBToA(chargerTypeB);

        socketTypeA.plugIn(chargerTypeA);
        socketTypeB.plugIn(chargerTypeB);
        socketTypeB.plugIn(adapterAToB);
        socketTypeA.plugIn(adapterBToA);
    }
}
