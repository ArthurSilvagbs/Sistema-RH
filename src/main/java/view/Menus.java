package view;

import controller.FuncionarioController;
import model.Funcionario;

import java.math.BigDecimal;
import java.util.Scanner;

public class Menus {

    private static final Scanner sc = new Scanner(System.in);
    private static final FuncionarioController fc = new FuncionarioController();

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
                exibirMenuContratacao();
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
                    return;
                default:
                    System.out.println("Opção inválida!");
                    repetirOperacao();
            }
        } while (true);
    }


}
