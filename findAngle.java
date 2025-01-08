public class findAngle {
    public static void main(String[] args) {
        int pointer1=0,pointer2=0;
        int hour=7,minute=21;
        for(int i=0;i<hour;i=i+1){
            pointer1+=30;
        }
        pointer1=pointer1==360?0:pointer1;

        for(int i=0;i<minute;i=i+1){
            pointer2+=6;
        }
        System.out.println(pointer1);
        
        pointer1+=(int) Math.ceil((pointer2*30)/360.0);
        
        System.out.println(pointer2);
                System.out.println(pointer1);

        int result=pointer1-pointer2;
        result=result<0?result*-1:result;
        result=result>=180?360-result:result;


        System.out.println(result);
    }
}
