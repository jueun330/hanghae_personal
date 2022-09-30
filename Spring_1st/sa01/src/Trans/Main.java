package Trans;

public class Main {

    public static void main(String[] args) {
        Bus bus1 = new Bus(1, 10, 10, 10);
        Bus bus2 = new Bus(2, 20, 20, 20);
        Taxi taxi1 = new Taxi(3, 1, 1, 10);
        Taxi taxi2 = new Taxi(4, 2, 2, 20);

        System.out.println("bus 1 " + bus1.get_number());
        System.out.println("bus 2 " + bus2.get_number());

        bus1.take_bus(2);
        bus1.fuel_change(-50);
        bus1.fuel_change(10);
        bus1.status = "운행중";
        bus1.max_pass(45);
        bus1.take_bus(5);
        bus1.fuel_change(-55);

        System.out.println("--------------------");

        System.out.println("taxi 1 " + taxi1.get_number());
        System.out.println("taxi 2 " + taxi2.get_number());
        taxi1.take_taxi(2, "서울역", 2);
        taxi1.fuel_change(-80);
        taxi1.pay();
        taxi1.max_pass(5);
        taxi1.take_taxi(3,"구로디지털단지역", 12);
        taxi1.fuel_change(-20);
        taxi1.finalPay();
    }

}