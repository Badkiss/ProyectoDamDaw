package com.dam.proyectodamdaw.activities.Model;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.dam.proyectodamdaw.Parameters;
import com.dam.proyectodamdaw.R;
import com.dam.proyectodamdaw.base.ImageDownloader;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    private final Root root;
    private final LayoutInflater inflater;
    private View.OnClickListener onClickListener;

    public MyRecyclerViewAdapter(Context context, Root root){
        this.root = root;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.activity_main,parent,false);
        view.setOnClickListener(onClickListener);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Date date= new Date((long) root.list.get(position).dt*1000);
        holder.Hora.setText(""+new SimpleDateFormat("HH:mm").format(date));
        holder.lluvia.setText(""+root.list.get(position).weather.get(0).description);
        holder.dia.setText(""+new SimpleDateFormat("EEEE",new Locale("es","ES")).format(date));
        holder.temp.setText(""+root.list.get(position).main.temp);
        holder.tempMax.setText(""+(int)(root.list.get(position).main.temp_max));
        holder.tempMin.setText(""+(int)(root.list.get(position).main.temp_min));
        holder.Fecha.setText(""+new SimpleDateFormat("dd:MM:yyyy").format(date));
        ImageDownloader.DownloadImage(Parameters.URL_PRE+""+ root.list.get(position).weather.get(0).icon+Parameters.URL_POST, holder.img);

    }

    @Override
    public int getItemCount() {
        return root.list.size();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView dia;
        TextView lluvia;
        TextView temp;
        TextView tempMax;
        TextView tempMin;
        TextView Fecha;
        TextView Hora;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
             img=itemView.findViewById(R.id.imageView);
             dia=itemView.findViewById(R.id.Dia);
             lluvia=itemView.findViewById(R.id.Lluvia);
             temp=itemView.findViewById(R.id.Temp);
             tempMax=itemView.findViewById(R.id.Temp_max);
             tempMin=itemView.findViewById(R.id.Temp_min);
             Fecha=itemView.findViewById(R.id.Fecha);
             Hora=itemView.findViewById(R.id.Hora);
        }

    }
}
