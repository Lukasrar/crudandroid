package com.example.crudusuarios2.helpers;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.crudusuarios2.R;
import com.example.crudusuarios2.dto.DtoUser;

import java.util.List;

public class UsuarioAdapter extends RecyclerView.Adapter<UsuarioAdapter.UsuarioHolder> {

    private LayoutInflater mInflater;
    private Context context;
    private List<DtoUser> lista;

    public  UsuarioAdapter(Context context, List<DtoUser> lista){
        this.context = context;
        this.lista = lista;
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public UsuarioHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.recycler_item, parent)
    }
}
