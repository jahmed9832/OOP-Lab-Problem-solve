import java.util.*;
public class parallelogram {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int b = scn.nextInt();
        int h = scn.nextInt();

        if( b <= 0 || h <= 0){
            System.out.println("java.lang.Exception: Breadth and height must be positive");
            return;
        }
        System.out.println(b*h);
    }
}
