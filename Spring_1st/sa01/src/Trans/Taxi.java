package Trans;

class Taxi extends Transport {
    String status;
    int dist;
    String dest;
    int base;
    int rate;
    int total;
    int acc;
    Taxi(int num,int take_pass, int current_pass, int speed){
        super(num, take_pass, current_pass, speed);
        this.status = "일반";
        this.dist = dist;
        this.dest = dest;
        this.base = 3000;
        this.rate = 1000;
        this.total = total;
        this.mx_pass = 4;
        this.acc = 0;
    }

    void take_taxi(int i, String s, int n) {
        if(status.equals("일반")){
            take_pass = i;
            current_pass += take_pass;
            mx_pass = mx_pass - current_pass;
            dist = n;
            dest = s;
            total = (dist - 1) * rate + base;
            status = "운행중";
            System.out.println("탑승 승객 수 = " + take_pass);
            System.out.println("잔여 승객 수 = " + mx_pass);
            System.out.println("기본 요금 확인 = "+ base);
            System.out.println("목적지 = " + dest);
            System.out.println("목적지까지 거리 = " + dist + "km");
            System.out.println("지불할 요금 = " + total);
            System.out.println("상태 = " + status);
        }
    }
    void fuel_change(int s) {
        fuel_ch = s;
        if (fuel_ch != 0){
            fuel_volume = fuel_volume + fuel_ch;
            //System.out.println("주유량 = " + fuel_volume);
        }
        else if (fuel_volume < 10) {
            status = "운행 불가";
        }
    }
    void pay() {
        acc += total;
        System.out.println("주유량 = " + fuel_volume);
        System.out.println("누적 요금 = " + acc);
    }

    void finalPay() {
        acc += total;
        System.out.println("주유량 = " + fuel_volume);
        System.out.println("상태 = " + "운행불가");
        System.out.println("누적 요금 = " + acc);
    }
    void max_pass(int i) {
        current_pass += i;
        if (current_pass > 4){
            System.out.println("최대 승객 수 초과");
            current_pass = 0;
        }
    }
}