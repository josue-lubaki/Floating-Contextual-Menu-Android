package com.example.lab3_2;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab3_2.model.Produit;

import java.util.List;

public class ProduitAdapter extends RecyclerView.Adapter<ProduitAdapter.ProduitViewHolder> {

    //data
    private List<Produit> produits;
    Context context;

    public ProduitAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ProduitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_item,parent,false);
        return new ProduitViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProduitViewHolder holder, int position) {
        Produit produit = produits.get(position);
        holder.tv_titre.setText(produit.getNom());
        holder.tv_desc.setText(produit.getDescription());
        holder.tv_prix.setText(String.valueOf(produit.getPrix()));


    }

    @Override
    public int getItemCount() {
        return this.produits.size();
    }

    public void ajouterProduit(List<Produit> newProduits){
        produits = newProduits;
        notifyDataSetChanged();
    }



    static class ProduitViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {
        private TextView tv_titre;
        private TextView tv_desc;
        private TextView tv_prix;

        public ProduitViewHolder(@NonNull View itemView)  {
            super(itemView);
            tv_titre = itemView.findViewById(R.id.produit_titre);
            tv_desc = itemView.findViewById(R.id.produit_desc);
            tv_prix = itemView.findViewById(R.id.produit_prix);
            itemView.setOnCreateContextMenuListener(this);

        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            menu.setHeaderTitle("Select The Action");
            menu.add(0, v.getId(), 0, "Edit");//groupId, itemId, order, title
            menu.add(0, v.getId(), 0, "Share");
            menu.add(0, v.getId(), 0, "Delete");

        }
    }
}
