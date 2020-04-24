package com.example.previsaodotempo.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.previsaodotempo.R;
import com.example.previsaodotempo.adapter.AdapterPrevisaoDaSemana;
import com.example.previsaodotempo.model.PrevisaoDaSemana;
import com.example.previsaodotempo.model.PrevisaoDoDia;
import com.example.previsaodotempo.model.PrevisaoDoTempo;
import com.example.previsaodotempo.retrofit.PrevisaoDoDiaApi;
import com.example.previsaodotempo.retrofit.PrevisaoDoDiaApiImplementacao;
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
    private List<PrevisaoDaSemana> previsoes = new ArrayList<>();
    private List<PrevisaoDaSemana> previsoesDaSemana = new ArrayList<>();

    ProgressBar progressBar;
    private String nomeDaCidade = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciarComponentes();

        //Configura RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        rvPrevisaoDoTempo.setLayoutManager(layoutManager);
        rvPrevisaoDoTempo.hasFixedSize();

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //nomeDaCidade = tieNomeDaCidade.getText().toString();
                gerarListaDePrevisao();

            }
        });
    }

    private void iniciarComponentes() {
        tieNomeDaCidade = findViewById(R.id.tieNomeDaCidade);
        btnBuscar = findViewById(R.id.btnBuscar);
        rvPrevisaoDoTempo = findViewById(R.id.rvPrevisaoDoTempo);
        progressBar = findViewById(R.id.progressBar);

        progressBar.setVisibility(View.GONE);

    }

    private void gerarListaDePrevisao() {

        PrevisaoDoDiaApi previsaoDoDiaApi = PrevisaoDoDiaApiImplementacao.getRetrofitInstance()
                .create(PrevisaoDoDiaApi.class);
        Call<PrevisaoDoDia> call = previsaoDoDiaApi.getPrevisaoDoDia();

       call.enqueue(new Callback<PrevisaoDoDia>() {
           @Override
           public void onResponse(Call<PrevisaoDoDia> call, Response<PrevisaoDoDia> response) {

               if(response.isSuccessful()) {

//                   PrevisaoDoDia previsaoDoDia = new PrevisaoDoDia();
//
//                   previsaoDoDia = response.body();

                   previsoes = response.body().getPrevisaoDaSemana();

                   //previsoes = previsaoDoDia.getPrevisaoDaSemana();

                   for(int i = 0; i < previsoes.size(); i++){

                       PrevisaoDaSemana previsaoDaSemana = new PrevisaoDaSemana();
                       previsaoDaSemana = previsoes.get(i);
                       previsoesDaSemana.add(previsaoDaSemana);

                   }

                   //List<PrevisaoDaSemana> lista = previsoesDaSemana;
                   adapterPrevisaoDaSemana = new AdapterPrevisaoDaSemana(previsoesDaSemana, getApplicationContext());
                   rvPrevisaoDoTempo.setAdapter(adapterPrevisaoDaSemana);

                   //adapterPrevisaoDaSemana.notifyDataSetChanged();


               }else {

                   Toast.makeText(MainActivity.this, "Ocorreu algum problema!!!",
                           Toast.LENGTH_SHORT).show();
               }
           }

           @Override
           public void onFailure(Call<PrevisaoDoDia> call, Throwable t) {

           }
       });

    }
}
