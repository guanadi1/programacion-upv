/**
 * Write a description of class PRGString here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 * 
 * 
 */
import  java.lang.Character;
import java.text.Collator;
import java.util.Locale;

public class PRGString
{
	
    public static void main(String[] args){
    	
    	int []a = {3,4,8,16,32};
        
        if (esPrefijo("queso","quesoss")) System.out.println("es prefijo");
        else System.out.println("no es prefijo");
        
        if (esPalindromo("Eva usaba rimel y le miraba suavÉ")) System.out.println("es Palindromo");
        else System.out.println("no es Palindromo");
        
        if (dobleAnterior(a)) System.out.println("cada elemento es el doble del anterior");
        else System.out.println("cada elemento NO es el doble del anterior");
        
    }
    
    public static boolean esPrefijo(String a, String b){
        if (a.length() > b.length()){
            return false;
        }else if (a.length() == 0) {
          return true;
        } 
        if (a.charAt(0)== b.charAt(0)){ 
        	// llamamos al metodo quitando el primero caracter de los dos String para volver a comprobar si son iguales
            return esPrefijo(a.substring(1, a.length()),b.substring(1, b.length())); 
        }else 
        return false;
    
    }

    
    
    public static boolean esPalindromo(String a){
        a= a.toLowerCase(); // convertimos todo a minusculas

        if ( a.length() <= 1){
        	return true;
        }
        
        else if (Character.isLetter(a.charAt(0))){ // el primer caracter es una letra? 
        	
        	if (Character.isLetter(a.charAt(a.length()-1))){ // el ultimo caracter es una letra? 
        		
        		if(acento(a.charAt(0)) == acento(a.charAt(a.length()-1))){
        			return esPalindromo(a.substring(1, a.length()-1)); // si los dos caracteres son iguales llamamos al metodo con el sub string quitando el ultimo y el primero que son iguales
        		}else{
        			return false; // si no son iguales retorna falso
        		}
        	}return esPalindromo(a.substring(0, a.length()-1)); // si ultimo caracter es una letra llamamos al metodo con el sub String quitanto el ultimo caracter 
        	
        }return esPalindromo(a.substring(1, a.length()));  // si primer caracter es una letra llamamos al metodo con el sub String quitanto el primero caracter    	         	   
    }
    
    public static char acento(char c){
    	
    	switch (c) {
		case 'á':
			c='a';
			break;
		case 'é':
			c='e';
			break;
		case 'í':
			c='i';
			break;
		case 'ó':
			c='o';
			break;
		case 'ú':
			c='u';
			break;
		}
    	return c;
    }
    
    
    private static boolean dobleAnterior (int [] a,int fin) {
    	
        if( fin == 0 )
            return true;
        else 
            return a[fin]/2==a[fin-1] && dobleAnterior(a,fin-1);
    }
    
    private static boolean dobleAnterior(int [] a){
    	return dobleAnterior ( a,a.length-1);
    }
    
    

       
}


