package com.example.previsaodotempo.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.icu.lang.UCharacter;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.Toast;

import com.example.previsaodotempo.R;
import com.example.previsaodotempo.adapter.AdapterPrevisaoDaSemana;
import com.example.previsaodotempo.model.PrevisaoDaSemana;
import com.example.previsaodotempo.model.PrevisaoDoDia;
import com.example.previsaodotempo.model.PrevisaoDoTempo;
import com.example.previsaodotempo.retrofit.PrevisaoDoTempoApi;
import com.example.previsaodotempo.retrofit.PrevisaoDoTempoApiImplementacao;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText tieNomeDaCidade;
    private Button btnBuscar;
    private RecyclerView rvPrevisaoDoTempo;
    private AdapterPrevisaoDaSemana adapterPrevisaoDaSemana;
    private List<PrevisaoDaSemana> previsoesApi = new ArrayList<>();
    private List<PrevisaoDaSemana> previsoesDaSemana = new ArrayList<>();
    private String cidade = null;
    //ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciarComponentes();

        //Configura RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        rvPrevisaoDoTempo.setLayoutManager(layoutManager);
        rvPrevisaoDoTempo.hasFixedSize();
        rvPrevisaoDoTempo.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Cidade = tieNomeDaCidade.getText().toString();
                gerarListaDePrevisao();

            }
        });
    }

    private void iniciarComponentes() {
        tieNomeDaCidade = findViewById(R.id.tieNomeDaCidade);
        btnBuscar = findViewById(R.id.btnBuscar);
        rvPrevisaoDoTempo = findViewById(R.id.rvPrevisaoDoTempo);
        //progressBar = findViewById(R.id.progressBar);

        //progressBar.setVisibility(View.GONE);

    }

    private void gerarListaDePrevisao() {

        PrevisaoDoTempoApi previsaoDoTempoApi = PrevisaoDoTempoApiImplementacao.getRetrofitInstance()
                .create(PrevisaoDoTempoApi.class);
        Call<PrevisaoDoTempo> call = previsaoDoTempoApi.getPrevisaoDoTempo();

       call.enqueue(new Callback<PrevisaoDoTempo>() {
           @Override
           public void onResponse(Call<PrevisaoDoTempo> call, Response<PrevisaoDoTempo> response) {

               if(response.isSuccessful()) {

//                   PrevisaoDoDia previsaoDoDia = new PrevisaoDoDia();
//                   previsaoDoDia = response.body().getPrevisaoDoDia();
//                   String cidade = previsaoDoDia.getCity_name();

                   previsoesApi = response.body().getPrevisaoDoDia().getPrevisaoDaSemana();

                   //previsoes = previsaoDoDia.getPrevisaoDaSemana();

               }else {
                   previsoesApi = new ArrayList<>();
                   if(response.code() == 400){
                   Toast.makeText(MainActivity.this, "Não foi possível obter a previsão do tempo!",
                           Toast.LENGTH_SHORT).show();
                   }else{

                       Toast.makeText(MainActivity.this, "Ocorreu o erro " +response.code(), Toast.LENGTH_SHORT).show();
                   }
               }

               PrevisaoDaSemana previsaoDaSemana;

               for(int i = 0; i < previsoesApi.size(); i++){

                   previsaoDaSemana = previsoesApi.get(i);
                   previsoesDaSemana.add(previsaoDaSemana);

               }

               adapterPrevisaoDaSemana = new AdapterPrevisaoDaSemana (previsoesDaSemana, MainActivity.this);
               rvPrevisaoDoTempo.setAdapter(adapterPrevisaoDaSemana);

               //adapterPrevisaoDaSemana.notifyDataSetChanged();


           }

           @Override
           public void onFailure(Call<PrevisaoDoTempo> call, Throwable t) {

           }
       });

    }
}
