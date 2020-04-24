package com.example.previsaodotempo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.previsaodotempo.R;
import com.example.previsaodotempo.model.PrevisaoDaSemana;

import java.util.List;

public class AdapterPrevisaoDaSemana extends RecyclerView.Adapter<AdapterPrevisaoDaSemana.MyViewHolder> {

    private List<PrevisaoDaSemana> previsoesDaSemana;
    private Context context;

    public AdapterPrevisaoDaSemana(List<PrevisaoDaSemana> previsoesDaSemana, Context context) {
        this.previsoesDaSemana = previsoesDaSemana;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemRvPrevisaoDoTempo = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_dos_itens_do_rvprevisaodotempo, parent, false);

        return new MyViewHolder(itemRvPrevisaoDoTempo);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tvData.setText(previsoesDaSemana.get(position).getDate());
        holder.tvDiaDaSemana.setText(previsoesDaSemana.get(position).getWeekday());
        holder.tvTempMin.setText(previsoesDaSemana.get(position).getMin().toString());
        holder.tvTempMax.setText(previsoesDaSemana.get(position).getMax().toString());

//        holder.tvData.setText("30/09/1964");
//        holder.tvDiaDaSemana.setText("Sexta");
//        holder.tvTempMin.setText("20");
//        holder.tvTempMax.setText("40");
    }

    @Override
    public int getItemCount() {
        return
                previsoesDaSemana.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tvData, tvTempMin, tvTempMax, tvDiaDaSemana;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            //Itens do layout para cada item do Recyclerview
            tvData = itemView.findViewById(R.id.tvData);
            tvTempMin = itemView.findViewById(R.id.tvtempMin);
            tvTempMax = itemView.findViewById(R.id.tvtempMax);
            tvDiaDaSemana = itemView.findViewById(R.id.tvDiaDaSemana);
        }
    }
}
