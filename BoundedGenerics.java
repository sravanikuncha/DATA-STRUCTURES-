public class BoundedGenerics {

    // void printArray(T []arr){
    //     for(int i=0;i<arr.length;i++){
    //         System.out.println(arr[i]);
    //     }
    // }

    static<T extends Vehicle> void printArray(T[] arr){
        for(int i=0;i<arr.length;i++){
            // ((Vehicle) arr[i]).print();
            arr[i].print();
            System.out.println(arr[i]);
        }
    }
    public static void main(String[] args) {
        Integer a[]=new Integer[6];
        a[0]=1;
        // BoundedGenerics<Integer> bg=new BoundedGenerics<>();
        // bg.printArray(a);
        BoundedGenerics.printArray(a);

        Vehicle v[]=new Vehicle[5];
        v[0]=new Vehicle(10, 20);
        BoundedGenerics.printArray(v);
    }
}


class x{
    int a;
}

class Y{
    public static void main(String[] args) {
        x objx1=new x();
        System.out.println(objx1.a);

        int y=10;
        System.out.println(y);
//         Instance Variables (Class Fields):

// Instance variables of a class are automatically initialized to default values if not explicitly initialized by the programmer.
// For instance variables of type int, the default value is 0.


// Local Variables:

// Local variables (variables declared inside a method or a block) are not automatically initialized.
// If you try to use a local variable without initializing it, the Java compiler will generate an error.
    }
}