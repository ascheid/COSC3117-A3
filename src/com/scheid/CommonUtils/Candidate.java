package com.scheid.CommonUtils;

import java.util.Random;

public class Candidate {

	public static int mut = 0;
	private StringBuilder candidate;
	private int fit;
	private Map map;

	public Candidate(Candidate c1, Candidate c2) {
		map = new Map();
		crossover(c1, c2);
		mut++;
		fitFunction();
	}

	public Candidate() {
		map = new Map();
		generateCandidate();
		fitFunction();
		mut++;
	}

	public void crossover(Candidate c1, Candidate c2) {
		Random r = new Random();
		candidate = new StringBuilder();
		int crossoverPoint = r.nextInt(298) + 1;
		candidate.append(c1.getCandidate().substring(0, crossoverPoint));
		candidate.append(c2.getCandidate().substring(crossoverPoint));
		if (mut % 100 == 0)
			mutation();
		fitFunction();
	}

	public void mutation() {
		Random r = new Random();
		char swap;
		int mut1 = r.nextInt(300);
		int mut2 = r.nextInt(300);
		swap = candidate.charAt(mut1);
		candidate.insert(mut1, candidate.charAt(mut2));
		candidate.insert(mut2, swap);
	}

	public StringBuilder getCandidate() {
		return candidate;
	}

	public void setCandidate(StringBuilder candidate) {
		this.candidate = candidate;
	}

	public int getFit() {
		return fit;
	}

	public void generateCandidate() {
		Random r = new Random();
		candidate = new StringBuilder();
		for (int i = 0; i < 150; i++) {
			candidate.append(intToStringBin(r.nextInt(5)));
		}
	}

	public String intToStringBin(int a) {
		if (a == 0)
			return "00"; // right
		else if (a == 1)
			return "01"; // top
		else if (a == 2)
			return "10"; // left
		else
			return "11"; // bottom
	}

	public Integer[][] candidateMap() {
		Integer[][] map = this.map.getMap();
		int posX = 0;
		int posY = 0;
		// Find start
		for (int j = 0; j < 10; j++) {
			for (int k = 0; k < 15; k++) {
				if (map[j][k] == 8) {
					posX = j;
					posY = k;
				}
			}
		}
		for (int i = 0; i < candidate.length(); i = i + 2) {
			if (candidate.substring(i, i + 2).equals("10") && posX == 0) {
				continue;
			} else if (candidate.substring(i, i + 2).equals("01") && posY == 0) {
				continue;
			} else if (candidate.substring(i, i + 2).equals("00") && map[posY][posX + 1] == 0) {
				map[posY][posX + 1] = 4;
				posX = posX + 1;
			} else if (candidate.substring(i, i + 2).equals("01") && map[posY - 1][posX] == 0) {
				map[posY - 1][posX] = 4;
				posY = posY - 1;
			} else if (candidate.substring(i, i + 2).equals("10") && map[posY][posX - 1] == 0) {
				map[posY][posX - 1] = 4;
				posX = posX - 1;
			} else if (candidate.substring(i, i + 2).equals("11") && map[posY + 1][posX] == 0) {
				map[posY + 1][posX] = 4;
				posY = posY + 1;
			}
		}
		return map;
	}

	public void printSolution() {
		int posX = 0;
		int posY = 0;
		Integer[][] map = this.map.getMap();
		int distance = 0;

		// Find start
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 15; j++) {
				if (map[i][j] == 8) {
					posX = j;
					posY = i;
				}

			}
		}

		for (int i = 0; i < candidate.length(); i = i + 2) {
			if (candidate.substring(i, i + 2).equals("10") && posX == 0) {
				continue;
			} else if (candidate.substring(i, i + 2).equals("01") && posY == 0) {
				continue;
			} else if (candidate.substring(i, i + 2).equals("00") && map[posY][posX + 1] == 5) {
				System.out.println(" => EAST => REACH THE SOLUTION");
				System.exit(0);
			} else if (candidate.substring(i, i + 2).equals("01") && map[posY - 1][posX] == 5) {
				System.out.println(" => NORTH => REACH THE SOLUTION");
				System.exit(0);
			}else if (candidate.substring(i, i + 2).equals("10") && map[posY][posX - 1] == 5) {
				System.out.println(" => WEST => REACH THE SOLUTION");
				System.exit(0);
			}else if (candidate.substring(i, i + 2).equals("11") && map[posY + 1][posX] == 5) {
				System.out.println(" => SOUTH => REACH THE SOLUTION");
				System.exit(0);
			}else if (candidate.substring(i, i + 2).equals("00") && map[posY][posX + 1] == 0) {
				System.out.print(" => EAST");
				posX = posX + 1;
			} else if (candidate.substring(i, i + 2).equals("01") && map[posY - 1][posX] == 0) {
				System.out.print(" => NORTH");
				posY = posY - 1;
			} else if (candidate.substring(i, i + 2).equals("10") && map[posY][posX - 1] == 0) {
				System.out.print(" => WEST");
				posX = posX - 1;
			} else if (candidate.substring(i, i + 2).equals("11") && map[posY + 1][posX] == 0) {
				System.out.print(" => SOUTH");
				posY = posY + 1;
			}

		}
	}

	public void fitFunction() {
		int posX = 0;
		int posY = 0;
		Integer[][] map = this.map.getMap();
		int distance = 0;

		// Find start
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 15; j++) {
				if (map[i][j] == 8) {
					posX = j;
					posY = i;
				}

			}
		}

		for (int i = 0; i < candidate.length(); i = i + 2) {
			if (candidate.substring(i, i + 2).equals("10") && posX == 0) {
				continue;
			} else if (candidate.substring(i, i + 2).equals("01") && posY == 0) {
				continue;
			} else if (candidate.substring(i, i + 2).equals("00") && map[posY][posX + 1] == 5) {
				
				printSolution();
				System.exit(0);
			} else if (candidate.substring(i, i + 2).equals("01") && map[posY - 1][posX] == 5) {
				
				printSolution();
				System.exit(0);
			}else if (candidate.substring(i, i + 2).equals("10") && map[posY][posX - 1] == 5) {
				
				printSolution();
				System.exit(0);
			}else if (candidate.substring(i, i + 2).equals("11") && map[posY + 1][posX] == 5) {
				
				printSolution();
				System.exit(0);
			}else if (candidate.substring(i, i + 2).equals("00") && map[posY][posX + 1] == 0) {
				posX = posX + 1;
			} else if (candidate.substring(i, i + 2).equals("01") && map[posY - 1][posX] == 0) {
				posY = posY - 1;
			} else if (candidate.substring(i, i + 2).equals("10") && map[posY][posX - 1] == 0) {
				posX = posX - 1;
			} else if (candidate.substring(i, i + 2).equals("11") && map[posY + 1][posX] == 0) {
				posY = posY + 1;
			}

		}

		// Find end
		for (int j = 0; j < 10; j++) {
			for (int k = 0; k < 15; k++) {
				if (map[j][k] == 5) {
					distance = Math.abs(k - posX) + Math.abs(j - posY);
				}
			}
		}
		this.fit = distance;
		System.out.println(mut + ": " + fit);
	}
}
