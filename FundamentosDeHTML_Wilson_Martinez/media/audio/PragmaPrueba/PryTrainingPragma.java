/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prytrainingpragma;

/**
 *
 * @author wilson
 */
public class PryTrainingPragma {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PryTrainingPragma hola = new PryTrainingPragma();
        //System.out.println("Times bulbs on: " + pruebas.solution(new int[]{6,1,5,2,4,3}));
        //System.out.println("Max: " + pruebas.solution1(new int[]{-8,4,0,5,-3,6}));
        //System.out.println("Resp: " + pruebas.solution2(20));
        //System.out.println("Min time: " + pruebas.solution3(new int[]{1,3,1,2,2,2}, 7, 3));
        //System.out.println("MCD: " + pruebas.solution4(2366, 273));
		System.out.println(pruebas.solution5(new int[][]{{3,3,2},{3,1,2},{4,4,2},{6,5,6}}));
    }
    
    public int solution(int[] a){
        int times = 1;
        int anterior;
        for(int num = 0; num < a.length ; num++){
            anterior = (a[num] - 1);
            while(anterior >= 1){
                boolean isEncendido = false;
                for(int x = 0 ; x < num ; x++){
                    if(a[x] == anterior){
                        isEncendido = true;
                        break;
                    }
                }
                if(isEncendido && anterior == 1){
                    times++;
                    anterior--;
                }else if(isEncendido){
                    anterior--;
                }else{
                    break;
                }
            }
        }
        return times;
    }
    
    public int solution1(int[] a){
        int maxVal = 0, tamanioaArray = a.length-1, idxP = 0, idxQ = 0;
        while(idxP <= tamanioaArray){
            int sumDistance = a[idxP] + a[idxQ] + (idxQ - idxP);
            maxVal = (sumDistance > maxVal) ? sumDistance : maxVal;
            if(idxQ < tamanioaArray){
                idxQ++;
            }else{
                idxP++;
                idxQ = idxP;
            }
        }
        return maxVal;
    }
    
     public int solution2(int a){
    	int maxVal = 2, pivote = 1, currSum = 0, nivelInicial = 0;
    	if(a <= 1){
    		nivelInicial = a;
    	}else{
    		while(currSum <= a){
    			currSum = maxVal + pivote;
    			maxVal++;
    			pivote = currSum;
    			nivelInicial++;
    		}
    	}
    	return nivelInicial;
    }
    
    public int solution3(int[] a, int X, int D){
    	int minTime = 0;
    	if(D < X){
    		minTime = -1;
    		for(int second = 0 ; second < a.length; second++){
    			if((D + a[second]) >= X){
    				minTime = second;
    				break;
    			}
    		}
    	}
    	return minTime;
    }
    
    public int solution4(int N, int M){
    	int mcd = 0, divisor = 0, dividendo = 0, residuo = 0;
    	divisor = N >= M ? N : M;
    	dividendo = N <= M ? N : M;
    	do{
    		residuo = divisor % dividendo;
    		mcd = dividendo;
    		divisor = dividendo;
    		dividendo = residuo;
    	}while(residuo != 0);
    	return mcd;
    }
    
    public int solution5(int[][] A){
    	int paises = 0;
    	int[][][] mapaAux = new int[A.length][A[0].length][2];
    	for(int x = 0; x < mapaAux.length ; x++){
    		for(int y = 0; y < mapaAux[x].length ; y++){
    			mapaAux[x][y][0] = A[x][y];
    			mapaAux[x][y][1] = 0;
    		}
    	}
    	for(int x = 0; x < mapaAux.length ; x++){
    		for(int y = 0; y < mapaAux[x].length ; y++){
    			if(x-1 >= 0){
    				if(mapaAux[x-1][y][0] == mapaAux[x][y][0]){
    					if(mapaAux[x-1][y][1] != 0){
    						mapaAux[x][y][1] = mapaAux[x-1][y][1];
    					}else if(mapaAux[x][y][1] != 0){
    						mapaAux[x-1][y][1] = mapaAux[x][y][1];
    					}else{
    						paises++;
    						mapaAux[x-1][y][1] = paises;
    						mapaAux[x][y][1] = paises;
    					}
    				}
    			}
    			if(x+1 < mapaAux.length){
    				if(mapaAux[x+1][y][0] == mapaAux[x][y][0]){
    					if(mapaAux[x+1][y][1] != 0){
    						mapaAux[x][y][1] = mapaAux[x+1][y][1];
    					}else if(mapaAux[x][y][1] != 0){
    						mapaAux[x+1][y][1] = mapaAux[x][y][1];
    					}else{
    						paises++;
    						mapaAux[x+1][y][1] = paises;
    						mapaAux[x][y][1] = paises;
    					}
    				}
				}
    			if(y-1 >= 0){
    				if(mapaAux[x][y-1][0] == mapaAux[x][y][0]){
    					if(mapaAux[x][y-1][1] != 0){
    						mapaAux[x][y][1] = mapaAux[x][y-1][1];
    					}else if(mapaAux[x][y][1] != 0){
    						mapaAux[x][y-1][1] = mapaAux[x][y][1];
    					}else{
    						paises++;
    						mapaAux[x][y-1][1] = paises;
    						mapaAux[x][y][1] = paises;
    					}
    				}
    			}
    			if(y+1 < mapaAux[x].length){
    				if(mapaAux[x][y+1][0] == mapaAux[x][y][0]){
    					if(mapaAux[x][y+1][1] != 0){
    						mapaAux[x][y][1] = mapaAux[x][y+1][1];
    					}else if(mapaAux[x][y][1] != 0){
    						mapaAux[x][y+1][1] = mapaAux[x][y][1];
    					}else{
    						paises++;
    						mapaAux[x][y+1][1] = paises;
    						mapaAux[x][y][1] = paises;
    					}
    				}
    			}
    			if(mapaAux[x][y][1] == 0){
    				paises++;
					mapaAux[x][y][1] = paises;
    			}
    		}
    	}
    	return paises;
    }
}
