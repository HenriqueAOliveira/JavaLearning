package challenge;


import java.util.Objects;

public class Motorista {

    private final String nome;

    private final int idade;

    private final int pontos;

    private final String habilitacao;

    private Motorista(String nome, int idade, int pontos, String habilitacao) {
        if(validarNome(nome) && validarIdade(idade) && validarPontos(pontos)
            && validarHabilitacao(habilitacao)) {
            this.nome = nome;
            this.idade = idade;
            this.pontos = pontos;
            this.habilitacao = habilitacao;
        } else{
            throw new NullPointerException();
        }
    }
    public boolean validarPontos(int pontos){
        return pontos >= 0;
    }
    public boolean validarIdade(int idade){
        return idade >= 0;
    }
    public boolean validarNome(String nome){
        return !nome.isEmpty();
    }

    public boolean validarHabilitacao(String habilitacao){
        return !habilitacao.isEmpty();
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public int getPontos() {
        return pontos;
    }

    public String getHabilitacao() {
        return habilitacao;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Motorista motorista = (Motorista) o;
        return Objects.equals(habilitacao, motorista.habilitacao);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(habilitacao);
    }

    @Override
    public String toString() {
        return "Motorista{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", pontos=" + pontos +
                ", habilitacao='" + habilitacao + '\'' +
                '}';
    }

    public static MotoristaBuilder builder() {
        return new MotoristaBuilder();
    }


    public static class MotoristaBuilder {

        private String nome;

        private int idade;

        private int pontos;

        private String habilitacao;

        private MotoristaBuilder() {
        }

        public MotoristaBuilder withNome(String nome) {
            this.nome = nome;
            return this;
        }

        public MotoristaBuilder withIdade(int idade) {
            if(idade >= 0) {
                this.idade = idade;
                return this;
            } else {
                throw new IllegalArgumentException();
            }
        }

        public MotoristaBuilder withPontos(int pontos) {
            if(pontos >= 0) {
                this.pontos = pontos;
                return this;
            } else {
                throw new IllegalArgumentException();
            }
        }

        public MotoristaBuilder withHabilitacao(String habilitacao) {
            this.habilitacao = habilitacao;
            return this;
        }


        public Motorista build() {
            return new Motorista(nome, idade, pontos, habilitacao);
        }
    }
}
