package Trans;

class Bus extends Transport {
    String status;
    int pay;
    Bus(int num, int take_pass, int current_pass, int speed){
        super(num, take_pass, current_pass, speed);
        this.status = "운행중";
        this.pay = 1000;
        this.mx_pass = 30;
    }

    void take_bus(int i){
        take_pass = i;
        if (take_pass > 0){
            current_pass += take_pass;
            mx_pass = mx_pass - current_pass;
            pay = pay * take_pass;
            System.out.println("탑승 승객 수 =" + current_pass);
            System.out.println("잔여 승객 수 =" + mx_pass);
            System.out.println("요금 확인 =" + pay);
        }else if(!status.equals("운행중") || take_pass > mx_pass){
            System.out.println("탑승 가능한 버스가 아닙니다.");
        }
    }
    void fuel_change(int n) {
        fuel_ch = n;
        if (fuel_ch != 0){
            fuel_volume = fuel_volume + (fuel_ch);
            System.out.println("주유량 = " + fuel_volume);
        }else if(fuel_volume < 0){
            status = "차고지행";
            System.out.println("상태 = " + status);
        }
    }

    void max_pass(int i) {
        current_pass += i;
        if (current_pass>30){
            System.out.println("최대 승객 수 초과");
            current_pass = 0;
        }
    }

}
