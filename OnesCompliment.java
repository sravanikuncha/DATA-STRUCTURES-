import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

public class OnesCompliment {
    public static void main(String[] args) {
        BigDecimal previousNum=new BigDecimal("100000000000");
        int carry=1;
        int value=0;
        StringBuffer s=new StringBuffer();
        BigDecimal zero=BigDecimal.ZERO;
        while(previousNum.intValue()!=0){
            BigDecimal bitsFromLeft=previousNum.remainder(BigDecimal.valueOf(10d));
            if(bitsFromLeft.intValue()==1 && carry==1){
                value=0;
                carry=1;
            }
            else if((bitsFromLeft.intValue()==1 && carry==0) || (bitsFromLeft.intValue()==0 && carry==1)){
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
                String s1=(previousNum.longValue())+(s.reverse()).toString();
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
        System.out.println(s.reverse().toString());

        

      
    }
}


