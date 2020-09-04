package challenge;

import java.util.ArrayList;
import java.util.List;

public class Estacionamento {
    List<Carro> ListaDeCarros = new ArrayList<>();
    public final int capacidade = 10;

    public void estacionar(Carro carro) {
        if(permissaoParaEstacionar(carro)) {
            if (carrosEstacionados() == capacidade) {
                for (int i = 0; i < ListaDeCarros.size(); i++) {
                    if (ListaDeCarros.get(i).getMotorista().getIdade() <= 55) {
                        ListaDeCarros.remove(ListaDeCarros.get(i));
                        i = capacidade; // Forçar a saida do laço
                    }
                    if (i == ListaDeCarros.size()-1) {
                        throw new EstacionamentoException("Estacionamento cheio");
                    }
                }
            }
            ListaDeCarros.add(carro);
        }
    }
    
    public boolean permissaoParaEstacionar(Carro carro){
        if((carro.getMotorista() == null
                || carro.getMotorista().getIdade() < 18
                || carro.getMotorista().getPontos() > 20)){
            throw new EstacionamentoException("Nao permitido!");
        }
        return true;
    }

    public int carrosEstacionados() {
        if(ListaDeCarros != null){
            return ListaDeCarros.size();
        } else {
            return 0;
        }
    }

    public boolean carroEstacionado(Carro carro) {
        return ListaDeCarros.contains(carro);
    }

}
