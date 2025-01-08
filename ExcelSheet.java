public class ExcelSheet {
    public static void main(String[] args) {
        String str="AAA";
        int nr=64,sum=0,powercount=0;
        for(int i=str.length()-1;i>=0;i--){
            char ch=str.charAt(i);
            sum+=Math.pow(26, powercount++)*(ch-nr);
            System.out.println(ch-nr);
        }
        System.out.println(sum);
    }
}
