
import java.util.Random;

public class Test {

    public static void main(String[] args){

        Random rand = new Random();

        for(int i=0; i<7;i++){

            System.out.println(rand.nextInt(37)+1);
        }

    }
}

//从37个数中，随机生成7个数

