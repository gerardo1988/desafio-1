/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matriz_final;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author MegaTecnologia
 */
public class Mutante {


    public static void main(String[] args) {

        String[][] matriz;
        int i, j;

        matriz = new String[][]{{"A", "T", "G", "C", "G", "A"}, {"C", "A", "G", "T", "G", "C"}, {"T", "T", "A", "T", "G", "T"}, {"A", "G", "A", "A", "G", "G"}, {"C", "C", "C", "C", "T", "A"}, {"T", "C", "A", "C", "T", "G"}};

        //esto recorre la matriz
        for (i = 0; i < matriz.length; i++) {
            for (j = 0; j < matriz[0].length; j++) {

                System.out.print(matriz[i][j]);
                System.out.print(" ");

            }
            System.out.println(" ");
        }
        System.out.println("");
        
        System.out.println("resultado mutante:");
        //llamo al metodo
        System.out.println(esMutante(matriz));

    }

    public static boolean esMutante(String m[][]) {
        
        boolean cadenaHorizontal, cadenaVertical, cadenaDiagonal;
        int contadorMutante = 0;
        boolean esMutante;

        //busco en el sentido de las filas
        for (int i = 0; i < m.length; i++) {

            cadenaHorizontal = false;

            for (int j = 0; j < m[0].length - 3; j++) {

                if (m[i][j] == "A" || m[i][j] == "G" || m[i][j] == "T" || m[i][j] == "C") {

                    if (m[i][j] == m[i][j + 1] && m[i][j] == m[i][j + 2] && m[i][j] == m[i][j + 3]) {

                        cadenaHorizontal = true;

                        if (cadenaHorizontal) {

                            contadorMutante++;
                        }

                    }
                }
            }

        }

        //busco en el sentido de las columnas
        for (int j = 0; j < m[0].length; j++) {

            cadenaVertical = false;

            for (int i = 0; i < m.length - 3; i++) {

                if (m[i][j] == "A" || m[i][j] == "G" || m[i][j] == "T" || m[i][j] == "C") {

                    if (m[i][j] == m[i + 1][j] && m[i][j] == m[i + 2][j] && m[i][j] == m[i + 3][j]) {

                        cadenaVertical = true;

                        if (cadenaVertical) {

                            contadorMutante++;
                        }

                    }
                }

            }

        }

        //busco en el sentido de las diagonales
        for (int i = 0; i < m.length - 2; i++) {

            cadenaDiagonal = false;

            for (int j = 0; j < m[0].length - 2; j++) {

                if (m[i][j] == "A" || m[i][j] == "G" || m[i][j] == "T" || m[i][j] == "C") {

                    if (m[i][j] == m[i + 1][j + 1] && m[i][j] == m[i + 2][j + 2] && m[i][j] == m[i + 3][j + 3]) {

                        cadenaDiagonal = true;

                        if (cadenaDiagonal) {

                            contadorMutante++;

                        }

                    }
                }

            }
        }

        //si hay mas de una cadena de mutante dara como resultado que hay un mutante
        if (contadorMutante >= 2) {

            esMutante = true;          

        } else {

            esMutante = false;
            
        }

        return esMutante;
    }
}
