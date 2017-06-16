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
    
    private Integer poder;

    public Criatura(){
        super.tipo = Tipo.criatura;   
    }
    
    public Criatura(String nombre, Integer coste, Integer poder){
        super.tipo = Tipo.criatura;
        super.nombre = nombre;
        super.coste = coste;
        this.poder = poder;
    }

    public Integer getPoder() {
        return poder;
    }

    public void setPoder(Integer poder) {
        this.poder = poder;
    }

    public String getNombre() {
        return nombre;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public Integer getCoste() {
        return coste;
    }
    
    
}
