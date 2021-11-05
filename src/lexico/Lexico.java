/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexico;

/**
 *
 * @author axell
 */
public class Scanner {
    private String entrada;
    private int j;
    
    public Scanner(){
        entrada = "";
        j = 0;
    }
    
    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }
    
    public String obtenerToken(){
        
        StringBuffer token = new StringBuffer();
        char actual;
        
        while(entrada.charAt(j) == ' '){
            j++;
        }
        
        if(j > entrada.length()){
            token.append("$");
        }
        actual = entrada.charAt(j);
        //para identificadores
        if(actual >= 'a' && actual <= 'z' || (actual >= 'A' && actual <= 'Z')){
            while((actual >= 'a' && actual <= 'z') || (actual >= 'A' && actual <= 'Z') || actual >= '0' && actual <= '9'){
                token.append(actual);
                j++;
                actual = entrada.charAt(j);
            }
        }
        
        //para numeros
        else if(actual >= '0' && actual <= '9'){
            while(actual >= '0' && actual <= '9'){
                token.append(actual);
                j++;
                actual = entrada.charAt(j);
            }
            //Para todo simbolo extraño
        }else{
            //System.out.println(actual);
            token.append(actual);
            j++;
            actual = entrada.charAt(j);
        }
        
        return token.toString();
        
    }
    
    public static void main(String[]args){
        Scanner sc = new Scanner();
        sc.setEntrada("xxxx = suma * a21 + 35;");
        System.out.println(sc.obtenerToken());
        System.out.println(sc.obtenerToken());
        System.out.println(sc.obtenerToken());
        System.out.println(sc.obtenerToken());
        System.out.println(sc.obtenerToken());
        System.out.println(sc.obtenerToken());
        System.out.println(sc.obtenerToken());
    }
}

