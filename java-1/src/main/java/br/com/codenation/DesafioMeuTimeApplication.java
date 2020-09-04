package br.com.codenation;

import br.com.codenation.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.exceptions.TimeNaoEncontradoException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;


public class DesafioMeuTimeApplication implements MeuTimeInterface {
	List<Time> listaTimes = new ArrayList<>();

	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
		if(timePorId(id) != null){
			throw new IdentificadorUtilizadoException();
		} else {
			listaTimes.add(new Time(id,nome,dataCriacao,corUniformePrincipal,corUniformeSecundario));
		}
	}

	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
		Time timeAnalisado = timePorId(idTime);
        if(timeAnalisado == null){
            throw new TimeNaoEncontradoException();
        }
		if(timeAnalisado.jogadorPorId(id) != null){
			throw new IdentificadorUtilizadoException();
		}
		timeAnalisado.novoJogador(new Jogador(id,idTime,nome,
					dataNascimento,nivelHabilidade,salario));

	}

	public void definirCapitao(Long idJogador) {
		if(jogadorPorId(idJogador) == null){
			throw new JogadorNaoEncontradoException();
		}
		Long IdentTime = timeDoJogador(idJogador).getId();
		CapitaoDoTime(IdentTime,idJogador);
	}


	public void CapitaoDoTime(Long idTime, Long idJogador){
		for(Time time : listaTimes){
			if(time.getId() == idTime){
				time.setIdCapitao(idJogador);
			}
		}
	}


	public Long buscarCapitaoDoTime(Long idTime) {
        Time time = timePorId(idTime);
	    if (time == null) {
            throw new TimeNaoEncontradoException();
        }
	    if(time.getIdCapitao() == null){
            throw new CapitaoNaoInformadoException();
        }
	    return time.getIdCapitao();
    }

	public String buscarNomeJogador(Long idJogador) {
		Jogador jogador = jogadorPorId(idJogador);
		if(jogador == null){
			throw new JogadorNaoEncontradoException();
		}
		return jogador.getNome();
		}


	public String buscarNomeTime(Long idTime) {
		Time time = timePorId(idTime);
		if(time == null){
			throw new TimeNaoEncontradoException();
		}
		return time.getNome();
	}

	public List<Long> buscarJogadoresDoTime(Long idTime) {
		Time time = timePorId(idTime);
		if(time == null){
			throw new TimeNaoEncontradoException();
		}
		List<Long> jogadores = new ArrayList<>();
		for(Jogador jogador : time.getElenco()){
			jogadores.add(jogador.getId());
		}
		return jogadores;
	}

	public Long buscarMelhorJogadorDoTime(Long idTime) {
		Time time = timePorId(idTime);
		if(time == null){
			throw new TimeNaoEncontradoException();
		}
		Jogador melhorJogador = Collections.max(time.getElenco(),Comparator.comparingInt(Jogador::getNivelHabilidade));
		return melhorJogador.getId();
	}

	public Long buscarJogadorMaisVelho(Long idTime) {
		Time time = timePorId(idTime);
		if(time == null){
			throw new TimeNaoEncontradoException();
		}
		Jogador jogadorExperiente = null;
		LocalDate data = LocalDate.now();
		for(Jogador jogador : time.getElenco()){
			if(jogador.getDataNascimento().isBefore(data)){
				data = jogador.getDataNascimento();
				jogadorExperiente = jogador;
			}
		}
		return jogadorExperiente.getId();
	}

	public List<Long> buscarTimes() {
		List<Long> timesCadastrados = new ArrayList<>();
		for (Time time : listaTimes){
		    timesCadastrados.add(time.getId());
        }
		return timesCadastrados;
	}

	public Long buscarJogadorMaiorSalario(Long idTime) {
        Time time = timePorId(idTime);
        if(time == null){
            throw new TimeNaoEncontradoException();
        }
	    Jogador jogadorMaiorSalario = null;
        BigDecimal maiorSalario = new BigDecimal(0);
        for(Jogador jogador : time.getElenco()){
            if(jogador.getSalario().compareTo(maiorSalario) == 1){
                jogadorMaiorSalario = jogador;
                maiorSalario = jogador.getSalario();
            }
        }
        return jogadorMaiorSalario.getId();
	}

	public BigDecimal buscarSalarioDoJogador(Long idJogador) {
        Jogador jogador = jogadorPorId(idJogador);
        if(jogador == null){
            throw new JogadorNaoEncontradoException();
        }
        Jogador jogadorEspecificado = null;
        for(Time time : listaTimes){
            if(time.getId() == jogador.getIdTime()){
                jogadorEspecificado = jogador;
            }
        }
        return jogadorEspecificado.getSalario();
	}

	public List<Long> buscarTopJogadores(Integer top) {
		List<Jogador> topJogadores = new ArrayList<>();
	    listaTimes.forEach(time -> topJogadores.addAll(time.getElenco()));
	    return topJogadores.stream()
							.sorted(Comparator.comparing(Jogador::getNivelHabilidade).reversed())
							.map(Jogador::getId)
							.limit(top)
							.collect(Collectors.toList());

	}

	public Time timePorId(Long idTime){
		Time time = listaTimes.stream()
				.filter(team -> team.getId().equals(idTime))
				.findAny()
				.orElse(null);
		return time;
	}

	public Time timeDoJogador(Long idJogador){
		for(Time time : listaTimes){
			Jogador jogador = jogadorPorId(idJogador);
			if(time.getId() == jogador.getIdTime()){
				return time;
			}
		}
		return null;
	}
	public Jogador jogadorPorId(Long idJogador){
		for (Time time: listaTimes){
			Jogador jogador = time.jogadorPorId(idJogador);
			if(jogador != null){
				return jogador;
			}
		}
		return null;
	}
}
