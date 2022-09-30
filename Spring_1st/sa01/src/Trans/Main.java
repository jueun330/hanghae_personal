package Trans;

public class Main {
    public static void main(String[] args) {
        Bus bus1 = new Bus(int fuel_volume,int take_pass, int current_pass, int speed);
        Bus bus2 = new Bus();
        Taxi taxi1 = new Taxi();
        Taxi taxi2 = new Taxi();


        bus1.take_bus(2);
        bus1.fuel_change(-50);
        bus1.fuel_change(10);
        bus1.status = "운행중";
        bus1.max_pass(45);
        bus1.take_bus(5);
        bus1.fuel_change(-55);
        System.out.println("--------------------");

        taxi1.take_taxi(2, "서울역", 2);
        taxi1.fuel_change(-80);
        taxi1.pay();
        taxi1.max_pass(5);
        taxi1.take_taxi(3,"구로디지털단지역", 12);
        taxi1.fuel_change(-20);
        taxi1.finalPay();

    }
}