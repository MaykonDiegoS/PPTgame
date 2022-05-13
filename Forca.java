import java.text.Normalizer;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Forca {
    //Define cores
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String palavra;

        while (true) {
            System.out.println("Informe uma palavra: ");
            palavra = sc.nextLine();

            boolean valida = true;

            for (int i = 0; i < palavra.length(); i++) {
                if (confere_char(palavra.charAt(i))) {
                    System.out.println("A palavra não deve conter números ou caracteres especiais.\n");
                    valida = false;
                    break;
                }
            }

            if (valida) {
                break;
            }

        }

        palavra = palavra.toUpperCase();
        palavra = remover_acentos(palavra);
        char[] vazia = new char[palavra.length()];
        char[] repetida = new char[36];
        int repetida_cont = 0;


        for (int i = 0; i < palavra.length(); i++) {
            if (palavra.charAt(i) == ' ' || palavra.charAt(i) == '-') {
                vazia[i] = palavra.charAt(i);
                continue;
            }
            vazia[i] = '_';
        }

        int tentativas = 6;

        System.out.println(ANSI_YELLOW + "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nJOGO DA FORCA" + ANSI_RESET);

        mostrar_boneco(tentativas);
        mostra_palavra(vazia);

        while (tentativas > 0) {
            System.out.println("Letra: ");
            String informado = sc.nextLine();
            informado = informado.toUpperCase();
            informado = remover_acentos(informado);
            char letra = informado.charAt(0);

            if (confere_char(letra) || letra == ' ' || letra == '-') {
                System.out.println(ANSI_RED + "Esse caracter é inválido." + ANSI_RESET);
                continue;
            }

            repetida[repetida_cont] = letra;

            if (ver_repetida(letra, repetida, repetida_cont)) {
                continue;
            }

            repetida_cont++;

            boolean aux = checar_letra(letra, palavra, vazia);

            if (fim_de_jogo(vazia)) {
                mostra_palavra(vazia);
                System.out.println(ANSI_GREEN + "Parabéns! Você acertou!" + ANSI_RESET);
                break;
            }

            if (aux) {
                tentativas--;
            }

            mostrar_boneco(tentativas);
            mostra_palavra(vazia);

            System.out.println(tentativas);

            System.out.print("Tentativas incorretas: ");
            for (int i = 0; i < repetida_cont; i++) {
                boolean certa = false;
                for (char letra_vazia : vazia) {
                    if (letra_vazia == repetida[i]) {
                        certa = true;
                        break;
                    }
                }
                if (certa) {
                    continue;
                }
                System.out.print(ANSI_RED + "\t" + repetida[i] + "\t-" + ANSI_RESET);
            }
            System.out.println("\n");
        }

        if (tentativas == 0) {
            System.out.println(ANSI_RED + "Acabaram suas tentativas." + ANSI_RESET);
            System.out.println(ANSI_BLUE + "A resposta correta era: " + palavra + ANSI_RESET);
        }

        System.out.println("Fim de jogo.");
    }

    public static boolean fim_de_jogo(char[] vazia) {
        for (char letra : vazia) {
            if (letra == '_') {
                return false;
            }
        }

        return true;
    }

    public static boolean ver_repetida(char letra, char[] repetida, int repetida_cont) {
        int cont = 0;

        for (int i = 0; i < repetida_cont + 1; i++) {
            if (repetida[i] == letra) {
                cont++;

                if (cont > 1) {
                    System.out.println(ANSI_RED + "Você já utilizou essa letra." + ANSI_RESET);
                    return true;
                }
            }
        }

        return false;
    }

    public static void mostrar_boneco(int tentativas) {
        if (tentativas != 0) {
            System.out.println("_______");
        } else {
            System.out.println(ANSI_RED + "_______" + ANSI_RESET);
        }

        switch (tentativas) {
            case 5:
                System.out.println("|     O\n|\n|");
                break;
            case 4:
                System.out.println("|     O\n|     |\n|");
                break;
            case 3:
                System.out.println("|     O\n|    /|\n|");
                break;
            case 2:
                System.out.println("|     O\n|    /|\\ \n|");
                break;
            case 1:
                System.out.println("|     O\n|    /|\\ \n|    /");
                break;
            case 0:
                System.out.println(ANSI_RED + "|     O\n|    /|\\ \n|    //" + ANSI_RESET);
                break;
            default:
                System.out.println("|\n|\n|");
        }
        System.out.println();
    }

    public static boolean checar_letra(char letra, String palavra, char[] vazia) {
        boolean aux = true;

        for (int i = 0; i < palavra.length(); i++) {
            if (letra == palavra.charAt(i) || palavra.charAt(i) == ' ' || palavra.charAt(i) == '-') {
                vazia[i] = palavra.charAt(i);
                if(letra == palavra.charAt(i))
               {
                    aux = false;
               }
            }
        }

        return aux;
    }

    public static void mostra_palavra(char[] vazia) {
        for (char letra : vazia) {
            if (letra == '_') {
                System.out.print("\t" + letra + "\t");
                continue;
            }
            System.out.print(ANSI_BLUE + "\t" + letra + "\t" + ANSI_RESET);
        }
        System.out.println("\n");
    }

    public static boolean confere_char(char caracter) {
        String invalidos = "0123456789&%!?^><=/*+.,¬¢£@:;[]{}()~#'_";

        for (int i = 0; i < invalidos.length(); i++) {
            if (invalidos.charAt(i) == caracter) {
                return true;
            }
        }

        return false;
    }

    public static String remover_acentos(String value) {
        String normalizer = Normalizer.normalize(value, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(normalizer).replaceAll("");
    }
}
