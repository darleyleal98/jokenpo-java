package com.darleyleal.jokenpo;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.darleyleal.jokenpo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private OpcoesDoJogo opcoesDoJogo = new OpcoesDoJogo();
    private String resultadoDaPartida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        EdgeToEdge.enable(this);
        View view = binding.getRoot();
        setContentView(view);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        binding.imageIconePedra.setOnClickListener(this::jokenpo);
        binding.imageIconePapel.setOnClickListener(this::jokenpo);
        binding.imageIconeTesoura.setOnClickListener(this::jokenpo);
    }

    private void jokenpo(View view) {
        int id = view.getId();
        String escolhaDoApp = opcoesDoJogo.opcaoAleatoria();
        binding.textEscolhaDoApp.setText(escolhaDoApp);
        alterIconeDoApp(escolhaDoApp);

        if (id == R.id.image_icone_pedra) {
            resultadoDaPartida = opcoesDoJogo.jogarJokenpo(escolhaDoApp, "Pedra");
            binding.textResultado.setText(resultadoDaPartida);

        } else if (id == R.id.image_icone_papel) {
            resultadoDaPartida = opcoesDoJogo.jogarJokenpo(escolhaDoApp, "Papel");
            binding.textResultado.setText(resultadoDaPartida);

        } else {
            resultadoDaPartida = opcoesDoJogo.jogarJokenpo(escolhaDoApp, "Tesoura");
            binding.textResultado.setText(resultadoDaPartida);
        }
    }

    private void alterIconeDoApp(String escolhaDoApp) {
        switch (escolhaDoApp) {
            case "Pedra":
                binding.imageEscolhaDoApp.setImageResource(R.drawable.pedra);
                break;
            case "Papel":
                binding.imageEscolhaDoApp.setImageResource(R.drawable.papel);
                break;
            case "Tesoura":
                binding.imageEscolhaDoApp.setImageResource(R.drawable.tesoura);
                break;
        }
    }
}