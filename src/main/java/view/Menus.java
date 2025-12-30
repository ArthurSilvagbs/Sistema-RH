package view;

import controller.FuncionarioController;
import model.Funcionario;

import java.math.BigDecimal;
import java.util.Scanner;

public class Menus {

    private static final Scanner sc = new Scanner(System.in);
    private static final FuncionarioController fc = new FuncionarioController();

    public static void exibirMenuPrincipal() {
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
                exibirMenuContratacao();
                break;
            case 2:
                exibirMenuListarFuncionarios();
                break;
            case 3:
                exibirMenuAtualizarSalario();
                break;
            case 4:
                exibirMenuPromocaoDeCargo();
                break;
            case 5:
                exibirMenuFolhaDePagamento();
            case 6:
                exibirMenuDemitirFuncionario();
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

    private static int repetirOperacao() {
        System.out.println("""
                    REPETIR OPERAÇÃO?
                    
                    [ 1 ] SIM
                    [ 2 ] NÃO
                    
                    Selecione uma opção:\s""");
        int opcaoConfirmacao = sc.nextInt();
        sc.nextLine();

        return opcaoConfirmacao;
    }

    private static int confirmacaoPesquisa() {
        System.out.print("""
                Confirma o resultado da pesquisa?
                
                [ 1 ] SIM
                [ 2 ] NÃO
                
                Selecione uma opção:\s""");

        int opcaoConfirmacao = sc.nextInt();
        sc.nextLine();

        return opcaoConfirmacao;
    }

    private static void exibirMenuContratacao() {

        do {
            System.out.println("""
                ======================================================
                ============ CONTRATAR NOVO FUNCIONÁRIO ==============
                ======================================================
                *****        Insira os dados necessários         *****
                ======================================================""");

            System.out.print("Nome Comleto: ");
            String nome = sc.nextLine();
            System.out.print("Cargo: ");
            String cargo = sc.nextLine();
            System.out.print("Salário: ");
            BigDecimal salario = sc.nextBigDecimal();

            Funcionario funcionario = new Funcionario(nome, salario, cargo);

            fc.contratarFuncionario(funcionario);

            int repetir = repetirOperacao();

            switch (repetir) {
                case 1:
                    break;
                case 2:
                    System.out.println("Voltando ao menu principal!");
                    exibirMenuPrincipal();
                    return;
                default:
                    System.out.println("Opção inválida!");
                    repetirOperacao();
            }
        } while (true);
    }

    private static void exibirMenuListarFuncionarios() {

        System.out.println("""
                ======================================================
                =============== LISTA DE FUNCIONÁRIOS ================
                ======================================================""");

        fc.verListaFuncionarios();
        exibirMenuPrincipal();
    }

    private static void exibirMenuAtualizarSalario() {

        do {
            System.out.println("""
                ======================================================
                ================= AJUSTE DE SALÁRIO ==================
                ======================================================
                *****  Insira o ID para pesquisar o funcionário  *****
                ======================================================""");

            System.out.print("ID do funcionário: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.println(fc.imprimirFuncionario(id));

            int opcaoConfirmacao = confirmacaoPesquisa();

            switch (opcaoConfirmacao) {
                case 1:

                    System.out.print("Valor do novo salário: ");
                    BigDecimal novoSalario = sc.nextBigDecimal();
                    sc.nextLine();
                    fc.atualizarSalario(id, novoSalario);
                    exibirMenuPrincipal();

                case 2:
                    System.out.println("Operação cancelada! Funcionário incorreto.");
                    exibirMenuAtualizarSalario();
                    return;
                default:
                    System.out.println("Opção inválida");
            }
        } while (true);

    }

    public static void exibirMenuPromocaoDeCargo() {

        do {
            System.out.println("""
                ======================================================
                ================= ALTERAR DE CARGO ===================
                ======================================================
                *****  Insira o ID para pesquisar o funcionário  *****
                ======================================================""");

            System.out.print("ID do funcionário: ");
            int id = sc.nextInt();
            sc.nextLine();
            fc.imprimirFuncionario(id);

            int opcaoConfirmacao = confirmacaoPesquisa();

            switch (opcaoConfirmacao) {
                case 1:

                    System.out.print("Novo cargo: ");
                    String novoCargo = sc.nextLine();

                    fc.alterarCargo(id, novoCargo);

                    exibirMenuPrincipal();

                case 2:
                    System.out.println("Operação cancelada! Funcionário incorreto.");
                    exibirMenuPromocaoDeCargo();
                    return;
                default:
                    System.out.println("Opção inválida");
            }
        } while (true);
    }

    public static void exibirMenuFolhaDePagamento() {

        System.out.println("""
                ======================================================
                ============== FOLHA DE PAGAMENTO TOTAL ==============
                ======================================================""");

        fc.getFolhaDePagamento();
        exibirMenuPrincipal();

    }

    public static void exibirMenuDemitirFuncionario() {

        do {
            System.out.println("""
                ======================================================
                ================ DEMITIR FUNCIONÁRIO =================
                ======================================================
                *****        Insira os dados necessários         *****
                ======================================================""");

            System.out.print("ID Funcionário: ");
            int id = sc.nextInt();
            sc.nextLine();

            fc.imprimirFuncionario(id);

            int opcaoConfirmacao = confirmacaoPesquisa();

            switch (opcaoConfirmacao) {
                case 1:
                    fc.demitirFuncionario(id);
                    exibirMenuPrincipal();
                case 2:
                    System.out.println("Operação cancelada! Funcionário incorreto.");
                    exibirMenuDemitirFuncionario();
                    return;
                default:
                    System.out.println("Opção inválida");
            }
        } while (true);
    }
}