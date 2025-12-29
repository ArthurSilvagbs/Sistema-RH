package model;

import java.math.BigDecimal;

public class Funcionario {

    private int id;
    private String nome;
    private BigDecimal salario;
    private String cargo;

    public Funcionario(String nome, BigDecimal salario, String cargo) {
        this.nome = nome;
        this.salario = salario;
        this.cargo = cargo;
    }

    public Funcionario(int id, String nome, BigDecimal salario, String cargo) {
        this.id = id;
        this.nome = nome;
        this.salario = salario;
        this.cargo = cargo;
    }

    public Funcionario() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String toString() {
        return String.format("ID: %d | NOME: %s | SALÁRIO: R$ %.2f | CARGO: %s", this.id, this.nome, this.salario, this.cargo);
    }

}
