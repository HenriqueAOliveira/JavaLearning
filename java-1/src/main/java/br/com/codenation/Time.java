package br.com.codenation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Time {
    private Long id;
    private String nome;
    private LocalDate dataCriacao;
    private String corUniformePrincipal;
    private String corUniformeSecundario;
    private Long idCapitao;
    private List<Jogador> elenco;

    public Time(Long id, String nome, LocalDate dataCriacao,
                String corUniformePrincipal, String corUniformeSecundario){
        setId(id);
        setNome(nome);
        setDataCriacao(dataCriacao);
        setCorUniformePrincipal(corUniformePrincipal);
        setCorUniformeSecundario(corUniformeSecundario);
        idCapitao = null;
        this.elenco = new ArrayList<>();
    }

    public Jogador jogadorPorId(Long id){
        return elenco.stream()
                .filter(jogador -> jogador.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCapitao() {
        return idCapitao;
    }

    public void setIdCapitao(Long idCapitao) {
        this.idCapitao = idCapitao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getCorUniformePrincipal() {
        return corUniformePrincipal;
    }

    public void setCorUniformePrincipal(String corUniformePrincipal) {
        this.corUniformePrincipal = corUniformePrincipal;
    }

    public String getCorUniformeSecundario() {
        return corUniformeSecundario;
    }

    public void setCorUniformeSecundario(String corUniformeSecundario) {
        this.corUniformeSecundario = corUniformeSecundario;
    }
    public List<Jogador> getElenco(){
        return this.elenco;
    }

    public void setElenco(List<Jogador> elenco) {
        this.elenco = elenco;
    }

    public void novoJogador(Jogador jogador){
        this.elenco.add(jogador);
    }
}
