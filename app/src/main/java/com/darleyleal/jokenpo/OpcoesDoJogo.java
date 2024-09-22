package com.darleyleal.jokenpo;

import java.util.Objects;
import java.util.Random;

public class OpcoesDoJogo {
    public String opcaoAleatoria() {
        String[] opcoes = {"Pedra", "Papel", "Tesoura"};
        Random random = new Random();
        int indice = random.nextInt(3);
        return opcoes[indice];
    }

    public String jogarJokenpo(String escolhaDoAplicativo, String escolhaDoUsuario) {
        String resultado;

        if (escolhaDoAplicativo.equals("Pedra") && escolhaDoUsuario.equals("Tesoura")) {
            resultado = "Você perdeu! Pedra ganha de tesoura!";

        } else if (escolhaDoUsuario.equals("Pedra") && escolhaDoAplicativo.equals("Tesoura")) {
            resultado = "Você ganhou! Pedra ganha de tesoura";

        } else if (escolhaDoAplicativo.equals("Tesoura") && escolhaDoUsuario.equals("Papel")) {
            resultado = "Você perdeu! Tesoura ganha de papel!";

        } else if (escolhaDoUsuario.equals("Tesoura") && escolhaDoAplicativo.equals("Papel")) {
            resultado = "Você ganhou! Tesoura ganha de papel!";

        } else if (escolhaDoAplicativo.equals("Papel") && escolhaDoUsuario.equals("Pedra")) {
            resultado = "Você perdeu! Papel ganha de Pedra!";

        } else if (escolhaDoUsuario.equals("Papel") && escolhaDoAplicativo.equals("Pedra")) {
            resultado = "Você ganhou! Papel ganha de pedra!";

        } else if (escolhaDoUsuario.equals(escolhaDoAplicativo)) {
            resultado = "Vocês escolheram " + escolhaDoAplicativo + ", houve um impate";
        } else {
            resultado = "Ops... Algo de errado aconteceu, tente novamente!";
        }
        return resultado;
    }
}
