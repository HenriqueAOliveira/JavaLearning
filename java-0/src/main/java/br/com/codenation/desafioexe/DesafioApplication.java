package br.com.codenation.desafioexe;

import java.util.ArrayList;
import java.util.List;

public class DesafioApplication {
	public static List<Integer> fibonacci() {
		ArrayList<Integer> Sequence = new ArrayList<>();
		int NextNumber = 1;
		int Number = 0;

		Sequence.add(Number);
		Sequence.add(NextNumber);

		while(Number < 350){
			Number = Sequence.get(NextNumber) + Sequence.get(NextNumber-1);
			Sequence.add(Number);
			NextNumber++;
		}
		return Sequence;
	}

	public static Boolean isFibonacci(Integer a) {
		return fibonacci().contains(a);
	}

}