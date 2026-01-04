package view;

import controller.FuncionarioController;

import java.math.BigDecimal;
import java.util.Scanner;

public class MainTeste {

    public static void main(String[] args) {

        FuncionarioController funcionarioController = new FuncionarioController();

        Scanner sc = new Scanner(System.in);

        System.out.println("ID: ");
        int id = sc.nextInt();

        System.out.println("Novo Salario: ");
        BigDecimal novoSalario = sc.nextBigDecimal();

        funcionarioController.atualizarSalario(id, novoSalario);

        sc.close();
    }
}
