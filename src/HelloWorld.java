/*
* 枚举的应用
* enum
*
*
* */



public class HelloWorld {
    public static void main(String args[]){
        System.out.println("hello world");
        Dog a =new Dog();
        a.colour= Dog.DogColour.BLACK;
        System.out.println("狗的颜色是："+a.colour);
        // 类型变量名 colour 一定要注意对应

    }
}
 class  Dog{
     /*public boolean color; */

     enum DogColour{BLUE,RED,BLACK}
     DogColour colour;
}