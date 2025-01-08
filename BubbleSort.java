public class BubbleSort {
    public static void main(String[] args) {
        int[] arr={41, 467, 334, 500, 169, 724, 478 ,358 ,962 ,464 };
        int n=10;
        for(int i=n-1;i>0;i--){
            for(int j=1;j<=i;j++){
                System.out.println(i+"  "+j+" "+(j-1));
                if(arr[j]<arr[j-1]){
                    int temp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                }
            }
        }

        for(int i:arr){
            System.out.print(i+" ");
        }

        //https://www.codingninjas.com/studio/problems/xor-query_893314?leftPanelTabValue=PROBLEM&count=25&page=1&search=&sort_entity=order&sort_order=ASC&leftPanelTab=0
    }
}
