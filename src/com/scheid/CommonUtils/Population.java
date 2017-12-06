package com.scheid.CommonUtils;

import java.util.ArrayList;
import java.util.Random;

public class Population {
	
	private ArrayList<Candidate> population;
	
	public Population () {
		population = new ArrayList<>();
		for(int i = 0 ; i< 30;i++)
			population.add(new Candidate());
	}

	public ArrayList<Candidate> getPopulation() {
		return population;
	}

	public void setPopulation(ArrayList<Candidate> population) {
		this.population = population;
	}
	
	public Candidate reprodution() {
		float totalFitness = 0;
		float[] share = new float[30];
		for(int i = 0 ; i < 30; i++) {
			share[i] = 1 / population.get(i).getFit();
		}
		Random r = new Random();
		int select = r.nextInt(100);
		float totalShare = 0;
		for(int i = 0; i<30;i++)
			totalShare = totalShare + share[i];
		
		for(int i = 0; i<30;i++)
			share[i] = share[i] / totalShare;
		
		int selectionOne = 0;
		int selectionTwo = 0;
		
		totalFitness = 0;
		select = select /100;
		
		for(int i = 0; i < 30; i++) {
			totalFitness = totalFitness + share[i];
			if(select <= totalFitness) {
				selectionOne = i;
			}
		}
		
		totalFitness = 0;
		select = r.nextInt(99) + 1;
		select = select /100;
		for(int i = 0; i < 30; i++) {
			totalFitness = totalFitness + share[i];
			if(select <= totalFitness) {
				selectionTwo = i;
			}
		}
		
		Candidate newOne = new Candidate(population.get(selectionOne), population.get(selectionTwo));
		int replace = 0;
		select = r.nextInt(99);
		select = select /100;
		totalFitness = 0;
		for(int i = 0; i < 30; i++) {
			totalFitness = totalFitness + share[i];
			if(select <= totalFitness) {
				replace = i;
			}
		}
		population.remove(replace);
		population.add(newOne);
		return newOne;
	}
	
}
