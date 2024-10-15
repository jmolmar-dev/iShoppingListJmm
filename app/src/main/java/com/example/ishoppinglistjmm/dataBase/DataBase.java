package com.example.ishoppinglistjmm.dataBase;

import android.widget.Toast;

import com.example.ishoppinglistjmm.activities.AddNewProductActivity;
import com.example.ishoppinglistjmm.models.Product;

import java.util.ArrayList;
import java.util.List;

public class DataBase {

    public static List<Product> productsList;

    /*Crearemos un metodo para inicializar a la lista de productos*/
    public static void inicializeList() {
        if (productsList == null) {
            /*Si la lista esta vacia la inicializamos, y le incluiremos 30 productos respectivamente*/
            productsList = new ArrayList<>();

            /*Creamos los 30 productos y los incluimos dentro de la lista: */
            Product p1 = new Product(1, "Pizza", "High-quality pizza", true);
            productsList.add(p1);
            Product p2 = new Product(2, "Chicken Wings", "The authentic flavor", false);
            productsList.add(p2);
            Product p3 = new Product(3, "Spanish Omelette with Onion", "Traditional flavor", true);
            productsList.add(p3);
            Product p4 = new Product(4, "Burger", "Top-quality meat", true);
            productsList.add(p4);
            Product p5 = new Product(5, "Caesar Salad", "Fresh and healthy", false);
            productsList.add(p5);
            Product p6 = new Product(6, "Sushi", "Taste of Japan", true);
            productsList.add(p6);
            Product p7 = new Product(7, "Paella", "Typical Valencian", false);
            productsList.add(p7);
            Product p8 = new Product(8, "Taco", "Authentic Mexican", true);
            productsList.add(p8);
            Product p9 = new Product(9, "Lasagna", "Classic Italian recipe", true);
            productsList.add(p9);
            Product p10 = new Product(10, "Curry", "Spicy and tasty", false);
            productsList.add(p10);
            Product p11 = new Product(11, "Club Sandwich", "Perfect for lunch", true);
            productsList.add(p11);
            Product p12 = new Product(12, "Falafel", "Fried chickpea balls", true);
            productsList.add(p12);
            Product p13 = new Product(13, "Hot Dog", "The American classic", false);
            productsList.add(p13);
            Product p14 = new Product(14, "Quiche", "Tasty and versatile", true);
            productsList.add(p14);
            Product p15 = new Product(15, "Risotto", "Creamy and delicious", true);
            productsList.add(p15);
            Product p16 = new Product(16, "Shawarma", "Spiced meat in pita bread", false);
            productsList.add(p16);
            Product p17 = new Product(17, "Meat Chili", "Spicy and hearty", true);
            productsList.add(p17);
            Product p18 = new Product(18, "Gyozas", "Japanese dumplings", true);
            productsList.add(p18);
            Product p19 = new Product(19, "Bagel", "Filled with cream cheese", false);
            productsList.add(p19);
            Product p20 = new Product(20, "Fideuà", "Seafood and noodles", true);
            productsList.add(p20);
            Product p21 = new Product(21, "Croquettes", "Creamy inside", true);
            productsList.add(p21);
            Product p22 = new Product(22, "Bruschetta", "Italian toasts", false);
            productsList.add(p22);
            Product p23 = new Product(23, "Ramen", "Japanese soup", true);
            productsList.add(p23);
            Product p24 = new Product(24, "Vegetable Pie", "Stuffed and baked", true);
            productsList.add(p24);
            Product p25 = new Product(25, "Moussaka", "Eggplant and meat", false);
            productsList.add(p25);
            Product p26 = new Product(26, "Fish and Chips", "Typical British", true);
            productsList.add(p26);
            Product p27 = new Product(27, "Chicken Curry", "Spiced and creamy", true);
            productsList.add(p27);
            Product p28 = new Product(28, "Burrito", "Mexican wrap", false);
            productsList.add(p28);
            Product p29 = new Product(29, "Noodles", "Asian noodles", true);
            productsList.add(p29);
            Product p30 = new Product(30, "Couscous", "With vegetables and meat", true);
            productsList.add(p30);

        }

    }

    /**
     * Metodo con el que obtenedremos todos aquellos productos que esten pendientes de compra
     * @return - Lista de productos pendientes de la compra
     */
    public static ArrayList<Product> getProductsPending() {
        ArrayList<Product> productsPending = new ArrayList<>();
        for (Product p : productsList) {
            if (p.isState()) {
                productsPending.add(p);
            }
        }
        return productsPending;
    }

    /**
     * Metodo mediante el que obtendremos todos los nos productos que no estan pendientes de compra
     * @return - Lista de productos no pendientes de la compra
     */
    public static ArrayList<Product> getProductsNoPending() {
        ArrayList<Product> productsNoPending = new ArrayList<>();
        for (Product p : productsList) {
            if (!p.isState()) {
                productsNoPending.add(p);
            }
        }
        return productsNoPending;
    }

    /**
     * Metodo con el que obtendremos el ultimo ID disponible incrementado en uno, necesario para incluir nuevos productos
     * dentro del sistema
     * @return - el ultimo Id disponible en el sistema incrementado en uno
     */
    public static int getLastId() {
        int id = 0;
        for (Product p : productsList) {
            if (p.getId() > id) {
                id = p.getId();
            }
        }
        return id + 1;
    }

    /**
     Metodo que nos agregara un producto dentro de la lista en el caso de que no exista un producto con el mismo nombre
     * @param p - producto que desamos incluir dentro la lista
     * @param view - vista desde la que llamaremos al metodo
     */
    public static void addProduct(Product p, AddNewProductActivity view) {
        for (Product product : productsList) {
            if (product.getName().equalsIgnoreCase(p.getName())) {
                Toast toast = new Toast(view);
                toast.setText("We already have a product with this name");
                toast.show();
                return;
            }
        }
        Toast toastNew = new Toast(view);
        toastNew.setText("Product added successfully");
        toastNew.show();
        productsList.add(p);
    }

    /**
     * Metodo que nos devuelve un producto en funcion del id introducido como parametro, en caso de no encontrarlo, devolvera nulo
     * @param id - id que le introducimos al metodo para que nos devuelva el producto especifico que lo tiene
     * @return - el producto especificado mediante el id
     */
    public static Product getProductbyID(int id) {
        for (Product p : productsList) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

}
