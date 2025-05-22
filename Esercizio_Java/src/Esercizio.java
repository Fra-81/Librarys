import java.util.Scanner;

public class Esercizio {

	public static void main(String[] args) {
		// cambio di variabili
    int a = 10;
    int b = 20;
    int c ;
    
    c = b;
    b=a;
    a=c;
    
    System.out.println(a );
    System.out.println(b);
    
   int s= Addizione(2,5);
   
   System.out.println(s);
    
   Scanner scanner = new Scanner(System.in);
   System.out.println("scegli un numero");
 
   int a1 = scanner.nextInt();
   {
	   if(a1== 5) {
		   
		   System.out.println("benvenuto");
		   
	   }
	   else {
		   System.out.println("suca");		   
	   }
   }
     
   System.out.println("");		   
	   
   
	
 }


	public static int Addizione(int g, int n) {
	
		
		int risultato = n+ g;
		
		return  risultato ;
	
	}
 
    
   
		   
	
	

}
