package Trans;

class Transport {
    private int num;
    int fuel_volume;
    int speed;
    int mx_pass;
    int take_pass;
    int fuel_ch;
    int current_pass;
    int speed_ch;


    public Transport(int num, int mx_pass, int fuel_ch, int speed_ch) {
        this.num = num;
        this.fuel_volume = 100;
        this.speed = 0;
        this.mx_pass = mx_pass;
        this.take_pass = 0;
        this.fuel_ch = fuel_ch;
        this.current_pass = 0;
        this.speed_ch = speed_ch;
    }

    int get_number() {
        return num;
    }

    void drive() {
        if(fuel_volume < 10){
            System.out.println("주유 필요");
        }
    }
    void speed_ch() {
        if(speed_ch != 0){
            speed = speed + speed_ch;
        }
    }
}
