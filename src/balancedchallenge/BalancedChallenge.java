/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package balancedchallenge;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 *
 * @author Isabela Vilas
 */
public class BalancedChallenge {

    // creating source
    static Map<Character, Character> fonte = new HashMap<Character, Character>();
    static {
        fonte.put('(', ')');
        fonte.put('[', ']');
        fonte.put('{', '}');
        fonte.put('<', '>');
    }
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in); 
        System.out.println("Escreve o comando a ser validado: ");
        String comando = myObj.nextLine();
        if(isValid(comando))
            System.out.println("Válido");
        else
            System.out.println("Inválido");
    }
    
    public static boolean isValid(String s) {
        // creating stack        
        Stack<Character> symbols = new Stack<>();
        for (int i = 0; i < s.length(); i++) 
            if (fonte.containsKey(s.charAt(i))) {
                symbols.push(fonte.get(s.charAt(i)));
            } else if (fonte.containsValue(s.charAt(i))) {
                if (symbols.isEmpty() || symbols.pop() != s.charAt(i)) {
                    return false;
                }
            }
        }
        return symbols.isEmpty();
    }
}
