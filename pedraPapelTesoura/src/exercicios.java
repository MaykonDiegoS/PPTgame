import java.util.Arrays;
import java.util.Scanner;

public class exercicios {
    public static void main(String[] args) {
        exercicio14();
    }

    static Scanner sc = new Scanner(System.in);

    static void exercicio1() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(" *  ");
            }
            System.out.println("");
        }
    }

    static void exercicio2() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (j <= i) {
                    System.out.print(" * ");
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println("");
        }
    }

    static void exercicio3() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i + j >= 4) {
                    System.out.print(" * ");
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println("");
        }
    }

    static void exercicio4() {
        System.out.println("Escreva algo: ");
        String algo = sc.nextLine();
        System.out.println("Escreva mais algo: ");
        String maisAlgo = sc.nextLine();

        if (algo.equals(maisAlgo)) {
            System.out.println("As palavras são exatamente iguais");
        } else if (algo.equalsIgnoreCase(maisAlgo)) {
            System.out.println("As palavras são iguais se não considerar letras maiúsculas ou minúsculas");
        } else {
            System.out.println("As palavras não são iguais");
        }
    }

    static void exercicio5() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                if (i + j < 4 || j >= (5 + i)) {
                    System.out.print("  ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println("");
        }
    }

    static void exercicio6() {
        System.out.println("Escreva algo: ");
        String algo = sc.nextLine();
        System.out.println("Escreva mais algo: ");
        String maisAlgo = sc.nextLine();

        if (algo.contains(maisAlgo)) {
            System.out.println(maisAlgo + "faz parte de" + algo);
        } else {
            System.out.println(maisAlgo + "não faz parte de" + algo);
        }
    }

    static void exercicio7() {
        System.out.println("Escreva algo: ");
        String algo = sc.nextLine();
        System.out.println("Escreva mais algo: ");
        String maisAlgo = sc.nextLine();

        if (algo.startsWith(maisAlgo)) {
            System.out.println(algo + "começa com" + maisAlgo);
        } else if (maisAlgo.startsWith(algo)) {
            System.out.println(maisAlgo + "começa com" + algo);
        } else {
            System.out.println(algo + "e" + maisAlgo + "não pertencem um ao outro");
        }
    }

    static void exercicio8() {
        System.out.println("Escreva algo: ");
        String algo = sc.nextLine();
        System.out.println("Escreva mais algo: ");
        String maisAlgo = sc.nextLine();

        if (algo.endsWith(maisAlgo)) {
            System.out.println(algo + " termina com " + maisAlgo);
        } else if (maisAlgo.endsWith(algo)) {
            System.out.println(maisAlgo + "termina com " + algo);
        } else {
            System.out.println("Nenhum termina com o outro");
        }
    }

    static void exercicio9() {
        System.out.println("Escreva algo: ");
        String algo = sc.nextLine();
        System.out.println("Escreva mais algo: ");
        String maisAlgo = sc.nextLine();
        int pos = algo.indexOf(maisAlgo);
        System.out.println(pos);
    }

    static void exercicio10() {
        String codigo = "lala#lwve#-rwgra22lalang!#<3";
        String mensagem = codigo
                .replace("w", "o")
                .replace("#", " ")
                .replace("2", "m")
                .replace("lala", "i")
                .replace("-", "p");
        System.out.println(mensagem);
    }

    static void exercicio11() {
        System.out.println("Quantos números deseja informar?");
        int quant = sc.nextInt();
        int[] nums = new int[quant];
        for (int i = 0; i < quant; i++) {
            System.out.println("Informe um número: ");
            nums[i] = sc.nextInt();
        }
        int somaPar = 0, somaImpar = 0;
        for (int valor : nums) {
            if (valor % 2 == 0) {
                somaPar += valor;
            } else {
                somaImpar += valor;
            }
        }
        System.out.println("Soma valores impares = " + somaImpar);
        System.out.println("Soma valores pares = " + somaPar);
    }

    static void exercicio12() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                if (i + j < 4 || j >= (5 + i)) {
                    System.out.print("  ");
                } else {
                    System.out.print(i + 1 + " ");
                }
            }
            System.out.println("");
        }
    }

    static void exercicio13() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                if (i + j < 4 || j >= (5 + i)) {
                    System.out.print("  ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println("");
        }
    }

    //1 - informe x quantidade de palavras
    //2 - leia as x palavras
    //3 - informe um número y maior que zero
    //4 - imprima as palavras com o tamanho igual ou maior que y
    static void exercicio14() {
        System.out.println("QUANTAS PALAVRAS DESEJA INFORMAR? ");
        int quant = sc.nextInt();
        String[] palavras = new String[quant];

        for (int i = 0; i < quant; i++) {
            System.out.println("INFORME UMA PALAVRA: ");
            palavras[i] = sc.nextLine();
    }
    }

    static void exercicio15 () {
        System.out.println("INFORME O TAMANHO DA PRIMEIRA LISTA: ");
        int tamListaUm = sc.nextInt();
        int[] listaUm = new int[tamListaUm];

        for (int i = 0; i < tamListaUm; i++) {
            System.out.println("INFORME O VALOR Nº" + (i + 1) + "DA LISTA: ");
            listaUm[i] = sc.nextLine();
        }

        System.out.println("INFORME O TAMANHO DA SEGUNDA LISTA: ");
        int tamListaDois = sc.nextInt();
        int[] listaDois = new int[tamListaDois];

        for (int i = 0; i < tamListaDois; i++) {
            System.out.println("INFORME O VALOR Nº" + (i + 1) + "DA LISTA: ");
            listaDois[i] = sc.nextInt();
        }

        for (int valor1 : listaUm) {
            boolean achou = false;
            for (int valor2 : listaDois) {
                if (valor1 == valor2) {
                    achou = true; break;
                }
            }
            if(!achou) {
                System.out.println(valor1);
            }
        }


    }



}