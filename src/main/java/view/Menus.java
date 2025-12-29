package view;

import java.util.Scanner;

public class Menus {

    private static Scanner sc = new Scanner(System.in);

    public void exibirMenuPrincipal() {
        System.out.println("""
                ======================================================
                =============== SISTEMA DE GESTÃO RH =================
                ======================================================
                ***** Selecione uma operação que deseja realizar *****
                ======================================================""");
        System.out.print("""
                |\s\s         [ 1 ] - CONTRATAR FUNCIONÁRIO           \s\s|
                |\s\s         [ 2 ] - VER LISTA DE FUNCIONÁRIOS       \s\s|
                |\s\s         [ 3 ] - PROMOVER FUNCIONÁRIO            \s\s|
                |\s\s         [ 4 ] - REAJUSTAR SALÁRIO               \s\s|
                |\s\s         [ 5 ] - FOLHA DE PAGAMENTO              \s\s|
                |\s\s         [ 6 ] - DEMITIR FUNCIONÁRIO             \s\s|
                |\s\s         [ 7 ] - SAIR DO PROGRAMA                \s\s|
                
                Selecione um opção:\s""");
        int opcao = sc.nextInt();
        sc.nextLine();

        switch (opcao) {
            case 1:
                //exibirMenuContratacao();
                break;
            case 2:
                //exibirMenuListarFuncionarios();
                break;
            case 3:
                //exibirMenuAtualizarSalario();
                break;
            case 4:
                //exibirMenuPromocaoDeCargo();
                break;
            case 5:
                //exibirMenuFolhaDePagamento();
            case 6:
                //exibirMenuDemitirFuncionario();
                break;
            case 7:
                System.out.println("Finalizando o programa. Até logo!");
                System.exit(0);
                break;
            default:
                System.out.println("Opção Inválida!");
                exibirMenuPrincipal();
        }

    }


}
