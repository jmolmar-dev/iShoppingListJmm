package com.example.ishoppinglistjmm.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.example.ishoppinglistjmm.R;
import com.example.ishoppinglistjmm.dataBase.DataBase;
import com.example.ishoppinglistjmm.models.Product;

import java.util.List;

public class ProductAdapter extends ArrayAdapter<Product> {

    private List<Product> products;
    private int color1;
    private int color2;
    private int color3;
    private int colorDefault;

    /*Llamada al constructor del padre --> (contexto, idResource, lista de Objetos que queremos recorrer, en este caso, Producto)*/
    public ProductAdapter(@NonNull Context context, int resource, @NonNull List<Product> products) {
        super(context, resource, products);
        this.products = products;
    }

    /*Metodo que se ejecutara al pulsar sobre cualquier elemento del ListView, al asociaremos una vista creada
    * y mostraremos con la misma el elemento indicado por el usuario. En caso de no encontrar la vista, se debera crear
    * en el momento*/
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Product p = this.products.get(position);

        //Si la vista aun no se ha creado, debemos de hacerlo nosotros
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_product,parent,false);
        }

        /*Si no es nulo, iremos reututilizando ya la vista*/

        /*Obtenedremos los componentes de la vista*/
        TextView tvIDProduct = convertView.findViewById(R.id.tvIdProduct);
        TextView tvNameProduct = convertView.findViewById(R.id.tvNameProduct);

        /*Modificamos los atributos de los componentes*/
        tvIDProduct.setText(String.valueOf(p.getId()));
        tvNameProduct.setText(p.getName());

        if (p.isLactosa() && p.isGluten()){
            color3 = ContextCompat.getColor(getContext(), R.color.color3);
            tvIDProduct.setBackgroundColor(color3);
            tvNameProduct.setBackgroundColor(color3);
        }else if (p.isLactosa()){
            color1 = ContextCompat.getColor(getContext(),R.color.color1);
            tvIDProduct.setBackgroundColor(color1);
            tvNameProduct.setBackgroundColor(color1);
        }else if (p.isGluten()){
            color2 = ContextCompat.getColor(getContext(), R.color.color2);
            tvIDProduct.setBackgroundColor(color2);
            tvNameProduct.setBackgroundColor(color2);
        }else{
            colorDefault = ContextCompat.getColor(getContext(),R.color.floralgreen);
            tvIDProduct.setBackgroundColor(colorDefault);
            tvNameProduct.setBackgroundColor(colorDefault);
        }



        /*Finalmente, se devuelve la vista*/
        return convertView;
    }



    /*Metodo que se ejecutara al pulsar sobre el spinner, se le asociara una vista y al hacer clic
    * en el spinner, se nos mostrara el contenido del mismo. En caso de que la vista no este creada se creara
    * en el momento*/
    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Product p = DataBase.getProductsNoPending().get(position);

        /*Si la vista aun no se ha creado la tendremos que crear nosotros*/
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.product_spinner_view,parent,false);
        }

        /*A continuacion obtenemos los componentes y vamos a modificar sus valores para devolverlos con la vista*/
        TextView tvNoPendingId = convertView.findViewById(R.id.tvNoPendingId);
        TextView tvNoPendingName = convertView.findViewById(R.id.tvNoPendingName);
        TextView tvNoPendingDescription = convertView.findViewById(R.id.tvNoPendingDescription);

        tvNoPendingId.setText(String.valueOf(p.getId()));
        tvNoPendingName.setText(p.getName());
        tvNoPendingDescription.setText(p.getDescription());

        return convertView;
    }
}
