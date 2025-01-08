import java.util.ArrayList;

public class findanagrams {
    public static void main(String[] args) {
        String str="CBAEBABACD",ptr="ABC";
        int n=10,m=3;
        
        ArrayList<Integer> output=new ArrayList<Integer>();
        
        int[] frequencyArray=new int[26];

        for(int i=0;i<m;i++){
            int value=ptr.charAt(i);
            frequencyArray[value-65]+=1;
        }

        for(int i=0;i+m<=n;i++){
            String s=str.substring(i,i+m);
            int[] tempArray=new int[26];
            for(int k=0;k<m;k++){
                int value=s.charAt(k);
                tempArray[value-65]+=1;
            }
            boolean add=true;
           for(int k=0;k<m;k++){
                int value=ptr.charAt(k);
                
                if(tempArray[value-65]!=frequencyArray[value-65]){
                    add=false;
                    break;
                }
           }
           if(add)
            output.add(i);
        }

        

        System.out.println(output);
    }
}
