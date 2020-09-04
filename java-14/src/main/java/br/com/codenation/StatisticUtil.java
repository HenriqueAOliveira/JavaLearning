package br.com.codenation;

import java.util.Arrays;
import java.util.Collections;

public class StatisticUtil {

	public static int average(int[] elements) {
		int soma = 0;
		for(int i= 0; i < elements.length; i++){
			soma += elements[i];
		}
		return soma / elements.length;
	}

	public static int mode(int[] elements) {
		int mode = elements[0];
		int count = 0;

		for(int i = 0; i < elements.length; i++){
			int modeAux = elements[i];
			int maxCount = 0;
			for(int j = 0; j < elements.length; j++){
				if(elements[j] == modeAux){
					maxCount++;
				}
				if(maxCount > count){
					count = maxCount;
					mode= modeAux;
				}
			}
		}
		return mode;
	}

	public static int median(int[] elements) {
		Arrays.sort(elements);
		int meio = elements.length/2;
		if(elements.length % 2 == 1){
			return elements[meio];
		} else {
			return (elements[meio] + elements[meio-1])/2;
		}
	}
}