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
        System.out.println("Max: " + hola.solution1(new int[]{1,3,-3}));
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
}
