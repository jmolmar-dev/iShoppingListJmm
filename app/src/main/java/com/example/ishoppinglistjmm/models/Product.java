package com.example.ishoppinglistjmm.models;

import java.io.Serializable;

/*En Android, todas las clases */
public class Product implements Serializable {

    /*Definimos los atributos de la clase Producto*/
    private int id;
    private String name;
    private String description;
    private boolean state;

    /*Definimos el constructor de la clase por defecto*/
    public Product (){
        super();
    }

    /*Contructor de la clase con todos los parametros*/
    public Product (int id, String name, String description, boolean state){
        this.id = id;
        this.name = name;
        this.description = description;
        this.state = state;
    }

    /*Getters y Setters de la clase */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {

        this.state = state;
    }

    /*Funcion toString()*/

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", state=" + state +
                '}';
    }
}
