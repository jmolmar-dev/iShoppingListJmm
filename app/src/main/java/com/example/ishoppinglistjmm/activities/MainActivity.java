package com.example.ishoppinglistjmm.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.ishoppinglistjmm.R;
import com.example.ishoppinglistjmm.adapters.ProductAdapter;
import com.example.ishoppinglistjmm.dataBase.DataBase;
import com.example.ishoppinglistjmm.models.Product;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        List <Product> productsPending = new ArrayList<>();

        /*Obtenemos los elementos de la Vista XML*/
        TextView tvTittle = findViewById(R.id.TittleApp);
        ListView lvProducts = findViewById(R.id.LvProducts);
        Button btnAddNew = findViewById(R.id.btnnew);
        Button btnAddPending = findViewById(R.id.btnPending);

        /*Aqui inicializamos la lista de todos los productos*/
        DataBase.inicializeList();

        /*Crearemos el adaptador y se lo asignaremos al ListView respectivamente*/
        ProductAdapter adapter = new ProductAdapter(MainActivity.this,0,DataBase.getProductsPending());
        lvProducts.setAdapter(adapter);

        /*A continuacion, vamos a poder acceder a los productos de la Lista*/
        lvProducts.setOnItemClickListener((parent, view, i, id) ->  {
            Product p = DataBase.getProductsPending().get(i);

            Intent intentDetail = new Intent(MainActivity.this, DetailActivity.class);
            intentDetail.putExtra("product", p);
            startActivity(intentDetail);

        });



        /*Implementamos la funcionalidad de los botones*/
        btnAddPending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentNoPending = new Intent(MainActivity.this,ProductsNoPendingActivity.class);
                startActivity(intentNoPending);
            }
        });

        btnAddNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentNew = new Intent(MainActivity.this, AddNewProductActivity.class);
                startActivity(intentNew);
            }
        });

    }
}


