public class Vehicle extends ParentClass{

    int a;
    int b;

    Vehicle(){

    }

    Vehicle(int a, int b){
        this.a=a;
        this.b=b;
    }
    public void print(){
        System.out.print(a+" "+b);
    }
}
