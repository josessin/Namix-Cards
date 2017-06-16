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
public class Hechizo extends Carta{
    
    private Integer efecto;
    
    public Hechizo(){
        super.tipo = Tipo.hechizo;
    }

    public Hechizo(String nombre, Integer coste, Integer efecto) {
        super.tipo = Tipo.hechizo;
        super.nombre = nombre;
        super.coste = coste;
        this.efecto = efecto;
    }
    
    
    
}
