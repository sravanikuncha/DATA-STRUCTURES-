
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Binarynumbers {
    
    public static void main(String[] args) {
        int n=10;
        System.currentTimeMillis();
       List<String> liS=new ArrayList<String>();
        int i=1;
        while(i<=n){
            StringBuffer s=new StringBuffer();
            int value=1;
            if(i==1)
                liS.add("1");
            else{
                BigDecimal previousNum=new BigDecimal(liS.get(i-2));
                int carry=1;
                while(previousNum.intValue()!=0){
                    BigDecimal bitsFromLeft=previousNum.remainder(BigDecimal.valueOf(10d));
                    if(bitsFromLeft.intValue()==1 && carry==1){
                        value=0;
                        carry=1;
                    }
                    else if((bitsFromLeft.intValue()==0 && carry==1) || (bitsFromLeft.intValue()==1 && carry==0)){
                        value=1;
                        carry=0;
                    }
                    else{
                        value=0;
                        carry=0;
                    } 
                    s.append(value);  
                    previousNum=previousNum.divide(BigDecimal.valueOf(10d));
                     if(carry==0){
                        String s1=previousNum.longValue()+(s.reverse()).toString();
                        s.delete(0, s.length());
                        s.append(s1);
                        s.reverse();
                        break;
                    }
                }
                if(carry==1){
                    value=1;
                    s.append(value);
                }
                liS.add((s.reverse()).toString());
                System.out.println(liS.get(i-1));
            }
            i++;
        }
System.currentTimeMillis();
    }
}
