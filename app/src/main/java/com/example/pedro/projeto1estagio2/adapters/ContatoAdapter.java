package com.example.pedro.projeto1estagio2.adapters;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.Image;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.pedro.projeto1estagio2.models.Contato;
import com.example.pedro.projeto1estagio2.R;

import java.util.ArrayList;

public class ContatoAdapter extends RecyclerView.Adapter<ContatoAdapter.ViewHolder> {
    private ArrayList<Contato> contatos;
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case

        public TextView tvCardUsername;
        public CardView cardView;
        public ImageView imgCall;

        public ViewHolder(View v) {
            super(v);
            tvCardUsername = (TextView) v.findViewById(R.id.tvCardUsername);

            cardView = (CardView) v.findViewById(R.id.cardView);

            imgCall = (ImageView) v.findViewById(R.id.ivCall);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public ContatoAdapter(Context context, ArrayList<Contato> contatos) {
        this.contatos = contatos;
        this.context = context;

    }

    // Create new views (invoked by the layout manager)
    @Override
    public ContatoAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                        int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlist_contato, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.tvCardUsername.setText(contatos.get(position).getNome());

        final int pos = position;
        holder.imgCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n = contatos.get(pos).getTelefone();
                String uri = "tel:" + Integer.toString(n);
                Intent call = new Intent(Intent.ACTION_CALL);
                call.setData(Uri.parse(uri));
                final int REQUEST_CODE_ASK_PERMISSIONS = 123;

                try{
                   context.startActivity(call);
                } catch (Exception e){
                    ActivityCompat.requestPermissions((Activity) context,new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CODE_ASK_PERMISSIONS);
                }
                //Toast.makeText(context, Integer.toString(10000 * contatos.get(pos).getTelefone() + 348574), Toast.LENGTH_LONG).show();
            }
        });

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return contatos.size();
    }
}