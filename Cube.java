public class Cube {
    public static void main(String[] args) {
        System.out.println("시작!");
        int i = 5;
        int a = 0;
        int b = 0;

        while (a + b != i ) {
            a = (int)(Math.random()* 6) + 1 ;
            b = (int)(Math.random()* 6) + 1 ;

            if (a + b != i) {
                System.out.printf("(%d, %d)%n", a, b);
            }
            else if (a + b == i){
                System.out.printf("(%d, %d)%n", a, b);
                System.out.println("끝!");
                break;
            }
        }
    }
}
