import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quiz {
    private List<Questao> questoes;
    private int acertos;
    private int erros;

    public Quiz() {
        questoes = new ArrayList<>();
        acertos = 0;
        erros = 0;
    }

    public void inicializaQuiz() {
        // Cabeçalho
        System.out.println("Faculdade XYZ");
        System.out.println("Nome do Aluno: Seu Nome Completo");
        System.out.println("Professor: Nome do Professor");
        System.out.println("Bem-vindo ao Quiz de Ciência! Você irá responder 15 perguntas.");
        System.out.println("");

        // Adicionando questões
        adicionarQuestoes();

        // Executando o quiz
        executarQuiz();
    }

    private void adicionarQuestoes() {
        questoes.add(criarQuestao("Qual é a fórmula da água?", "A) H2O", "B) CO2", "C) O2", "D) H2", "E) N2", "A"));
        questoes.add(criarQuestao("Qual é o planeta mais próximo do sol?", "A) Terra", "B) Marte", "C) Mercúrio", "D) Vênus", "E) Júpiter", "C"));
        // Adicione mais 13 questões
    }

    private Questao criarQuestao(String pergunta, String a, String b, String c, String d, String e, String correta) {
        Questao questao = new Questao();
        questao.pergunta = pergunta;
        questao.opcaoA = a;
        questao.opcaoB = b;
        questao.opcaoC = c;
        questao.opcaoD = d;
        questao.opcaoE = e;
        questao.correta = correta;
        return questao;
    }

    private void executarQuiz() {
        Scanner scanner = new Scanner(System.in);

        for (Questao questao : questoes) {
            questao.escrevaQuestao();
            String resposta = questao.leiaResposta();
            if (questao.isCorreta(resposta)) {
                acertos++;
            } else {
                erros++;
            }
        }

        exibirResultados();
    }

    private void exibirResultados() {
        System.out.println("Você acertou " + acertos + " perguntas.");
        System.out.println("Você errou " + erros + " perguntas.");
        double percentualAcertos = (double) acertos / questoes.size() * 100;
        System.out.printf("Sua porcentagem de acertos é: %.2f%%\n", percentualAcertos);
    }

    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        quiz.inicializaQuiz();
    }
}