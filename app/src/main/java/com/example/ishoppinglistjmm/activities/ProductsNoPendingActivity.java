package com.example.ishoppinglistjmm.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.ishoppinglistjmm.R;
import com.example.ishoppinglistjmm.adapters.ProductAdapter;
import com.example.ishoppinglistjmm.dataBase.DataBase;
import com.example.ishoppinglistjmm.models.Product;

public class ProductsNoPendingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_products_no_pending);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        /*Recuperamos los componentes de la vista*/
        TextView tittleNoPending = findViewById(R.id.tvProductsPending);
        Spinner sp = findViewById(R.id.spProductsnoPending);
        Button cancel = findViewById(R.id.btnCancel2);
        Button save = findViewById(R.id.btnSave1);

        /*Llamamos al adaptador y lo asociamos con el spinner*/
        ProductAdapter adapter = new ProductAdapter(ProductsNoPendingActivity.this,0, DataBase.getProductsNoPending());
        sp.setAdapter(adapter);

        /*Funcionalidad de los botones*/
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentBack = new Intent(ProductsNoPendingActivity.this, MainActivity.class);
                startActivity(intentBack);
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Product p = (Product) sp.getSelectedItem();
                p.setState(true);
                Intent in = new Intent(ProductsNoPendingActivity.this,MainActivity.class);
                Toast message = new Toast(ProductsNoPendingActivity.this);
                message.setText("This product will be pending. Thanks for your change");
                message.show();
                startActivity(in);
            }
        });

    }
}