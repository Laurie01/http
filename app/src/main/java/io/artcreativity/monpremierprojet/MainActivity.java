package io.artcreativity.monpremierprojet;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import io.artcreativity.monpremierprojet.dao.DataBaseRoom;
import io.artcreativity.monpremierprojet.dao.ProductDao;
import io.artcreativity.monpremierprojet.dao.ProductRoomDao;
import io.artcreativity.monpremierprojet.entities.Product;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final String TAG = MainActivity.class.getCanonicalName();

    private TextInputEditText designationEditText;
    private TextInputEditText descriptionEditText;
    private TextInputEditText priceEditText;
    private TextInputEditText quantityInStockEditText;
    private TextInputEditText alertQuantityEditText;
    private ProductDao productDao;
    private ProductRoomDao productRoomDao;
    private boolean create = true;
    private Product prod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        productDao = new ProductDao(this);
        productRoomDao = DataBaseRoom.getInstance(getApplicationContext()).productRoomDao();

        prod = (Product) getIntent().getSerializableExtra("MAIN_PROD");

        designationEditText = findViewById(R.id.name);
        descriptionEditText = findViewById(R.id.description);
        priceEditText = findViewById(R.id.price);
        quantityInStockEditText = findViewById(R.id.quantity_in_stock);
        alertQuantityEditText = findViewById(R.id.alert_quantity);

        if(prod != null){
            create = false;
            designationEditText.setText(prod.name);
            descriptionEditText.setText(prod.description);
            priceEditText.setText((int) prod.price);
            quantityInStockEditText.setText((int) prod.quantityInStock);
            alertQuantityEditText.setText((int) prod.alertQuantity);
        }

        findViewById(R.id.my_btn).setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = new MenuInflater(this);
        menuInflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void saveProduct(View view) {
        Product product = new Product();
        product.name = designationEditText.getText().toString();
        product.description = descriptionEditText.getText().toString();
        product.price = Double.parseDouble(priceEditText.getText().toString());
        product.quantityInStock = Double.parseDouble(quantityInStockEditText.getText().toString());
        product.alertQuantity = Double.parseDouble(alertQuantityEditText.getText().toString());

        if(create){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    ProductWebService pms = new ProductWebService();
                    Product prod = pms.createProduct(product);
                    runOnUiThread(()->{
                        productRoomDao.insert(product);
                    });
                }
            });
            thread.start();
            Log.e(TAG, "saveProduct: " + product);
            Toast.makeText(getApplicationContext(), "Produit créé", Toast.LENGTH_SHORT).show();
        }
        else{
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    ProductWebService pms = new ProductWebService();
                    Product prod = pms.updateProduct(product);
                    runOnUiThread(()->{
                        productRoomDao.update(prod.id, product);
                    });
                }
            });
            thread.start();

            Log.e(TAG, "updateProduct: " + product);
            Toast.makeText(getApplicationContext(), "Produit à jour", Toast.LENGTH_SHORT).show();
        }

        Intent intent = getIntent();
        intent.putExtra("MY_PROD", product);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }

    @Override
    public void onClick(View view) {
        saveProduct(view);
    }
}