package com.example.ishoppinglistjmm.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.ishoppinglistjmm.R;
import com.example.ishoppinglistjmm.models.Product;

import org.w3c.dom.Text;

public class DetailActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        /*Obtenemos los componentes de la vista*/
        TextView tittleDetails = findViewById(R.id.tvTittleDetails);
        TextView idDetails = findViewById(R.id.tvIdDetails);
        TextView nameDetails = findViewById(R.id.tvNameDetails);
        TextView descriptionDetails = findViewById(R.id.tvDescriptionDetails);
        TextView stateDetails = findViewById(R.id.tvStateDetails);
        TextView lactosaDetails = findViewById(R.id.tvLactosaDetails);
        TextView glutenDetails = findViewById(R.id.tvGlutenDetails);
        Button edit = findViewById(R.id.btnEdit);
        Button cancel = findViewById(R.id.btnCancel);

        /*A continuacion, obtenemos el intent que ha iniciado la actividad*/
        Intent intent = getIntent();
        /*Recuperaremos los datos del intent a partir de una instancia del producto*/
        Product product = (Product) intent.getSerializableExtra("product");
        /*En caso de que no sea nulo, asignaremos los valores a los campos respectivamente*/
        if (product != null){
            idDetails.setText(String.valueOf(product.getId()));
            nameDetails.setText(product.getName());
            descriptionDetails.setText(product.getDescription());

            /*Al ser todos los productos pendientes, verdaderamente nunca llegaremos al else*/
            if (product.isState()){
                stateDetails.setText("Pending purchase");
            }else{
                stateDetails.setText("No Pending purchase");
            }

            if (product.isLactosa()){
                lactosaDetails.setText("With Lactosa");
            }else{
                lactosaDetails.setText("Without Lactosa");
            }

            if (product.isGluten()){
                glutenDetails.setText("With Gluten");
            }else{
                glutenDetails.setText("Without Gluten");
            }

        }

        /*Implementamos la funcionalidad de los botones*/
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Creamos el intent al que deseamos navegar al hacer clic al boton*/
                Intent intent = new Intent(DetailActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this,EditProductActivity.class);
                if (product != null){
                    intent.putExtra("productid",product.getId());
                }
                   startActivity(intent);
            }
        });

    }
}
