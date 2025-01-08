public class Studentuse extends Student{
    static int numStudent=0;
    String name="abc";

    static void getNumStudent(){
        // System.out.println(name);   here this is allowed logically butjava kept a strong restriction

        System.out.println(numStudent);
    }

    public static void main(String[] args) {
        Student s=new Student();

        Student s1=new Studentuse();

        
        Studentuse s2=new Studentuse();
        s2.Hello();
        System.out.println(s2);

       System.out.println(s.a);`

    }

    public void Hello(){
        // abstract Integer i;
        // System.out.println(i);
        System.out.println("simple heelo funnc");
    }
}
