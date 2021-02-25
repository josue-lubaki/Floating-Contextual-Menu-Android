package com.example.lab3_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.lab3_2.model.Produit;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private ProduitAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView =  findViewById(R.id.recyclerview);
        adapter = new ProduitAdapter(getApplication());

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(adapter);
        adapter.ajouterProduit(getAllProduits());

        registerForContextMenu(recyclerView);
    }


    public List<Produit> getAllProduits(){
        List<Produit> listeProduit = new ArrayList<>();
        listeProduit.add(new Produit("Josu","boss 1.0", 100));
        listeProduit.add(new Produit("pcjo","lool", 20));
        listeProduit.add(new Produit("ismo","oo", 4));
        listeProduit.add(new Produit("kany","boss 1.0", 10));
        listeProduit.add(new Produit("Baki","asdf", 30));
        listeProduit.add(new Produit("mmm","boss 1.0", 300));
        listeProduit.add(new Produit("wwqe"," 1.0", 12));
        listeProduit.add(new Produit("qq","bete0", 99));
        listeProduit.add(new Produit("fd","bo", 21));
        listeProduit.add(new Produit("Jcu","bos", 45));

        return listeProduit;

    }

   /* @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.contextual_menu, menu);
        menu.setHeaderTitle("Select action");
    }
   */
    /*
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.edit:
                Toast.makeText(this,"share",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.share:
                Toast.makeText(this,"share",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.delete:
                Toast.makeText(this,"share",Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }

    }

    private void share(long id) {
        Toast.makeText(this, "share", Toast.LENGTH_SHORT).show();
    }

    private void edit(long id) {
        Toast.makeText(this, "edit", Toast.LENGTH_SHORT).show();

    }

    private void delete(long id) {
        Toast.makeText(this, "delete", Toast.LENGTH_SHORT).show();

    }
*/


}