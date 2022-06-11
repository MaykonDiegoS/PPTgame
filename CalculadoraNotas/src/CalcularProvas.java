import java.util.Scanner;

public class CalcularProvas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //informar quantidade de alunos e questoes
        System.out.println("Informe a quantidade de alunos: ");
        int numAlunos = sc.nextInt();
        sc.nextLine();
        System.out.println("Informe a quantidade de quesões da prova: ");
        int numQuestoes = sc.nextInt();
        sc.nextLine();

        //ler gabarito da prova
        System.out.println("Gabarito da prova: ");
        String[] gabarito = new String[numQuestoes];
        for (int i = 0; i < numQuestoes; i++) {
            System.out.println("Informe resposta da questão nº" + (i+1));
            gabarito[i] = sc.nextLine();
        }

        //mostrar



        for (int i = 0; i < gabarito.length; i++) {
            System.out.print(gabarito[i]);
        }
    }
}
