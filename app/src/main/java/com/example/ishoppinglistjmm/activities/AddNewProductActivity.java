package com.example.ishoppinglistjmm.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.ishoppinglistjmm.R;
import com.example.ishoppinglistjmm.dataBase.DataBase;
import com.example.ishoppinglistjmm.models.Product;

import org.w3c.dom.Text;

public class AddNewProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_new_product);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        /*Recuperamos los componentes de la vista*/
        TextView idNewProduct = findViewById(R.id.tvIdNewProduct);
        EditText newName = findViewById(R.id.etNewName);
        EditText newDescription = findViewById(R.id.etNewDescription);
        @SuppressLint("UseSwitchCompatOrMaterialCode")
        Switch swState = findViewById(R.id.sw1);
        TextView infoNew = findViewById(R.id.tvInfo);
        Button btnSave2 = findViewById(R.id.btnSave2);
        Button brnCancel3 = findViewById(R.id.btnCancel3);


        /*Obtenedremos el primer ID dispinible para poder incluirlo en un producto nuevo y se lo asociamos el TextView*/
        idNewProduct.setText(String.valueOf(DataBase.getLastId()));

        /*Ahora implementamos la funcionalidad de los botones nuevamente*/
        brnCancel3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(AddNewProductActivity.this, MainActivity.class);
                startActivity(back);
            }
        });

        btnSave2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Creamos una nueva instancia de producto y le asociamos los datos que haya introducido el usuario*/
                Product p = new Product();
                p.setId(Integer.parseInt(idNewProduct.getText().toString()));
                p.setName(newName.getText().toString());
                p.setDescription(newDescription.getText().toString());
                p.setState(swState.isChecked());

                /*Comprobamos que los campos no se queden vacios a la hora de insertar un nuevo producto*/
                if (p.getName().isEmpty()){
                    Toast t1 = new Toast(AddNewProductActivity.this);
                    t1.setText("Name can´t be empty");
                    t1.show();
                }else if (p.getDescription().isEmpty()){
                    Toast t2 = new Toast(AddNewProductActivity.this);
                    t2.setText("Description can´t be empty");
                    t2.show();
                }else{
                    DataBase.addProduct(p,AddNewProductActivity.this);
                    idNewProduct.setText(String.valueOf(DataBase.getLastId()));
                    newName.setText("");
                    newDescription.setText("");
                    swState.setChecked(false);
                    Intent comeBack = new Intent(AddNewProductActivity.this,MainActivity.class);
                    startActivity(comeBack);
                }

            }
        });


    }
}