/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author Usuario
 */
public class Criatura extends Carta{
    
    private Integer poderInicial;
    private Integer poderActual;
    
    public Criatura(){
        tipo = Carta.Tipo.criatura;
        
    }
    
}
