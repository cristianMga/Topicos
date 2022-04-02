import java.util.Scanner;
public class pruebaOperaciones{
   public static void main(String [] args){
   
   float num = 200.0f;
   String n =String.valueOf(num);
   String punto = ".";
   float n1;
   int decimales=0;
   int deci =0;
   int pos = n.length();
   int n2=0;
   
   for(int x =0; x<pos; x++)
      if(punto.equals(String.valueOf(n.charAt(x)))== true)
         decimales = x;
      
      deci =Integer.parseInt(n.substring(decimales+1,pos));
      
      n1= Float.valueOf(num);
      n2= (int)n1;
      
      if((pos-1) - (decimales+1)==0 && Integer.parseInt(n.substring(decimales+1,pos))==0)
          System.out.print(n2);
      else
         System.out.println(n1);
         
   
   }
}