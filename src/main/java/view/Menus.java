package view;

import controller.FuncionarioController;
import model.Funcionario;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menus {

    private static final Scanner sc = new Scanner(System.in);
    private static final FuncionarioController fc = new FuncionarioController();

    public static void exibirMenuPrincipal() {

        while (true) {

            System.out.println("""
                ======================================================
                =============== SISTEMA DE GESTÃO RH =================
                ======================================================
                ***** Selecione uma operação que deseja realizar *****
                ======================================================""");
            System.out.print("""
                |\s\s         [ 1 ] - CONTRATAR FUNCIONÁRIO           \s\s|
                |\s\s         [ 2 ] - VER LISTA DE FUNCIONÁRIOS       \s\s|
                |\s\s         [ 3 ] - REAJUSTAR SALÁRIO               \s\s|
                |\s\s         [ 4 ] - PROMOVER FUNCIONÁRIO            \s\s|
                |\s\s         [ 5 ] - FOLHA DE PAGAMENTO              \s\s|
                |\s\s         [ 6 ] - DEMITIR FUNCIONÁRIO             \s\s|
                |\s\s         [ 7 ] - SAIR DO PROGRAMA                \s\s|
                
                Selecione um opção:\s""");
            int opcao = lerInteiro();

            switch (opcao) {
                case 1 -> exibirMenuContratacao();
                case 2 -> exibirMenuListarFuncionarios();
                case 3 -> exibirMenuAtualizarSalario();
                case 4 -> exibirMenuPromocaoDeCargo();
                case 5 -> exibirMenuFolhaDePagamento();
                case 6 -> exibirMenuDemitirFuncionario();
                case 7 -> {
                    System.out.println("Finalizando o programa. Até logo!");
                    System.exit(0);
                }
                default -> System.out.println("Opção Inválida!");
            }

        }
    }

    private static int repetirOperacao() {
        System.out.println("""
                    REPETIR OPERAÇÃO?
                    
                    [ 1 ] SIM
                    [ 2 ] NÃO
                    
                    Selecione uma opção:\s""");
        return lerInteiro();
    }

    private static int confirmacaoPesquisa() {
        System.out.print("""
                Confirma o resultado da pesquisa?
                
                [ 1 ] SIM
                [ 2 ] NÃO
                
                Selecione uma opção:\s""");

        return lerInteiro();
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
            String nome = lerString();
            System.out.print("Cargo: ");
            String cargo = lerString();
            System.out.print("Salário: ");
            BigDecimal salario = lerBigDecimal();

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
            int id = lerInteiro();
            System.out.println(fc.imprimirFuncionario(id));

            int opcaoConfirmacao = confirmacaoPesquisa();

            switch (opcaoConfirmacao) {
                case 1:

                    System.out.print("Valor do novo salário: ");
                    BigDecimal novoSalario = lerBigDecimal();
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
            int id = lerInteiro();
            System.out.println(fc.imprimirFuncionario(id));

            int opcaoConfirmacao = confirmacaoPesquisa();

            switch (opcaoConfirmacao) {
                case 1:

                    System.out.print("Novo cargo: ");
                    String novoCargo = lerString();

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

        System.out.println("R$ " + fc.getFolhaDePagamento());
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
            int id = lerInteiro();
            System.out.println(fc.imprimirFuncionario(id));

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

    private static int lerInteiro() {

        while(true) {
            try {
                int valor = sc.nextInt();
                sc.nextLine();
                return valor;
            } catch (InputMismatchException e) {
                System.out.print("Erro! Digite um valor número válido: ");
                sc.nextLine();
            }
        }
    }

    private static BigDecimal lerBigDecimal() {
        while(true) {
            try {
                return sc.nextBigDecimal();
            } catch (InputMismatchException e) {
                System.out.print("Erro! Digite um valor numérico (Ex: 1500,50): ");
                sc.nextLine();
            }
        }
    }

    private static String lerString() {
        while (true) {
            String entrada = sc.nextLine();
            if (!entrada.trim().isEmpty()) {
                return entrada;
            }
            System.out.print("Erro! O campo não pode ficar vazio. Digite novamente: ");
        }
    }

}