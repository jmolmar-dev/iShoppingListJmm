package com.example.ishoppinglistjmm.models;

import java.io.Serializable;

/*En Android, todas las clases */
public class Product implements Serializable {

    /*Definimos los atributos de la clase Producto*/
    private int id;
    private String name;
    private String description;
    private boolean state;
    private boolean lactosa;
    private boolean gluten;

    /*Definimos el constructor de la clase por defecto*/
    public Product (){
        super();
    }

    /*Contructor de la clase con todos los parametros*/
    public Product (int id, String name, String description, boolean state, boolean lactosa, boolean gluten){
        this.id = id;
        this.name = name;
        this.description = description;
        this.state = state;
        this.lactosa = lactosa;
        this.gluten = gluten;
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

    public boolean isLactosa() {
        return lactosa;
    }

    public void setLactosa(boolean lactosa) {
        this.lactosa = lactosa;
    }

    public boolean isGluten() {
        return gluten;
    }

    public void setGluten(boolean gluten) {
        this.gluten = gluten;
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
