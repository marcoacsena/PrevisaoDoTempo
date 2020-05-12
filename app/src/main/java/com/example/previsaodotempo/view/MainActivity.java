package com.example.previsaodotempo.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.previsaodotempo.R;
import com.example.previsaodotempo.adapter.AdapterPrevisaoDaSemana;
import com.example.previsaodotempo.model.PrevisaoDaSemana;
import com.example.previsaodotempo.model.PrevisaoDoTempo;
import com.example.previsaodotempo.retrofit.PrevisaoDoTempoApi;
import com.example.previsaodotempo.retrofit.PrevisaoDoTempoApiImplementacao;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText tieNomeDaCidade;
    private Button btnBuscar;
    private RecyclerView rvPrevisaoDoTempo;
    private AdapterPrevisaoDaSemana adapterPrevisaoDaSemana;
    private List<PrevisaoDaSemana> listaPrevisoesDaApi = new ArrayList<>();
    private List<PrevisaoDaSemana> ListaPrevisoesDaSemana = new ArrayList<>();
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


                String cidade = tieNomeDaCidade.getText().toString();
                gerarListaDePrevisao(cidade);


//                PrevisaoDaSemana previsaoSeg = new PrevisaoDaSemana("2020-05-01T14:13:52","Seg",
//                        35, 20);
//                previsoesApi.add(previsaoSeg);
//                PrevisaoDaSemana previsaoTer = new PrevisaoDaSemana("2020-05-01T14:20:52","Ter",
//                        31, 21);
//                PrevisaoDaSemana previsaoDomingo = new PrevisaoDaSemana("2020-04-30T14:13:52","Dom",
//                        30, 15);
//                previsoesApi.add(previsaoDomingo);
//                previsoesApi.add(previsaoTer);
//                PrevisaoDaSemana previsaoQui = new PrevisaoDaSemana("2020-05-10T14:13:52","Qui",
//                        28, 11);
//                previsoesApi.add(previsaoQui);
//                PrevisaoDaSemana previsaoQua = new PrevisaoDaSemana("2020-05-02T14:13:52","Qua",
//                        29, 14);
//                previsoesApi.add(previsaoQua);
//
//                Collections.sort(previsoesApi, new PrevisaoDaSemana.DateComparator());
//
//                PrevisaoDaSemana previsaoDaSemana;
//
//                for(int i = 0; i < previsoesApi.size(); i++){
//
//                    previsaoDaSemana = previsoesApi.get(i);
//                    previsoesDaSemana.add(previsaoDaSemana);
//                }
//                adapterPrevisaoDaSemana = new AdapterPrevisaoDaSemana (previsoesDaSemana, MainActivity.this);
//                rvPrevisaoDoTempo.setAdapter(adapterPrevisaoDaSemana);
//                adapterPrevisaoDaSemana.notifyDataSetChanged();

                tieNomeDaCidade.setText("");

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

    private void gerarListaDePrevisao(String cidade) {

        PrevisaoDoTempoApi previsaoDoTempoApi = PrevisaoDoTempoApiImplementacao.getRetrofitInstance()
                .create(PrevisaoDoTempoApi.class);
        Call<PrevisaoDoTempo> call = previsaoDoTempoApi.getPrevisaoDoTempo(cidade);

       call.enqueue(new Callback<PrevisaoDoTempo>() {
           @Override
           public void onResponse(Call<PrevisaoDoTempo> call, Response<PrevisaoDoTempo> response) {

               if(response.isSuccessful()) {

                   listaPrevisoesDaApi = response.body().getPrevisaoDoDia().getPrevisaoDaSemana();
                   Collections.sort(listaPrevisoesDaApi, new PrevisaoDaSemana.DateComparator());

                   //String nomeDaCidade = response.body().getPrevisaoDoDia().getCityName();

               }else {
                   listaPrevisoesDaApi = new ArrayList<>();
                   if(response.code() == 400){
                   Toast.makeText(MainActivity.this, "Não foi possível obter a previsão do tempo!",
                           Toast.LENGTH_SHORT).show();
                   }else{

                       Toast.makeText(MainActivity.this, "Ocorreu o erro " +response.code(), Toast.LENGTH_SHORT).show();
                   }
               }


               PrevisaoDaSemana previsaoDaSemana;

               for(int i = 0; i < listaPrevisoesDaApi.size(); i++){

                   previsaoDaSemana = listaPrevisoesDaApi.get(i);
                   ListaPrevisoesDaSemana.add(previsaoDaSemana);
               }
               adapterPrevisaoDaSemana = new AdapterPrevisaoDaSemana (ListaPrevisoesDaSemana,
                       MainActivity.this);
               rvPrevisaoDoTempo.setAdapter(adapterPrevisaoDaSemana);
               adapterPrevisaoDaSemana.notifyDataSetChanged();
           }

           @Override
           public void onFailure(Call<PrevisaoDoTempo> call, Throwable t) {

           }
       });

    }
}
