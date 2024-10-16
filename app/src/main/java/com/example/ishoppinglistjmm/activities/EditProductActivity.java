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


import java.util.List;

public class EditProductActivity extends AppCompatActivity {


    int idProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_edit_product);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        /*Componentes Vista XML*/
        TextView titleEdit = findViewById(R.id.tvTittleEdit);
        EditText nameEdit = findViewById(R.id.etNameEdit);
        EditText detailsEdit = findViewById(R.id.etDescriptionEdit);
        @SuppressLint("UseSwitchCompatOrMaterialCode")
        Switch sw2 = findViewById(R.id.swChangueStatus);
        @SuppressLint("UseSwitchCompatOrMaterialCode")
        Switch swLactosa = findViewById(R.id.swChangueLactosa);
        @SuppressLint("UseSwitchCompatOrMaterialCode")
        Switch swGluten = findViewById(R.id.swChangueGluten);
        Button btnCancel = findViewById(R.id.btnCancel4);
        Button btnSave = findViewById(R.id.btnSave3);

        /*Obtenemos lo que necesitamos de la Activity anterior, en este caso, el ID*/
        Intent intentDetails = getIntent();

        /*Posteriormente, obtendremos el producto que tiene asociado dicho ID*/
        idProduct = (int) intentDetails.getSerializableExtra("productid");
        Product edit = DataBase.getProductbyID(idProduct);

        nameEdit.setText(edit.getName());
        detailsEdit.setText(edit.getDescription());

        /*Implementamos la funcionalidad de los botones*/
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EditProductActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Comprobacion de que ninguno de los campos puede quedarse vacio*/
                if (nameEdit.getText().toString().isEmpty()) {
                    Toast toastName = new Toast(EditProductActivity.this);
                    toastName.setText("Name can´t be empty");
                    toastName.show();
                    return;
                }else if (detailsEdit.getText().toString().isEmpty()){
                    Toast toastDescription = new Toast(EditProductActivity.this);
                    toastDescription.setText("Description can´t be empty");
                }

                edit.setName(nameEdit.getText().toString());
                edit.setDescription(detailsEdit.getText().toString());
                edit.setState(!sw2.isChecked());

                if (swLactosa.isChecked()){
                    edit.setLactosa(true);
                }else{
                    edit.setLactosa(false);
                }

                if (swGluten.isChecked()){
                    edit.setGluten(true);
                } else{
                    edit.setGluten(false);
                }




                Toast toast = new Toast(EditProductActivity.this);
                /*Se informa al usuario que ha editado el producto con exito*/
                toast.setText("Product Updated Successfully");
                toast.show();
                Intent main = new Intent(EditProductActivity.this,MainActivity.class);
                startActivity(main);

            }
        });



    }
}
