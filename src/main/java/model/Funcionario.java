package model;

public class Funcionario {

    private final int id;
    private String nome;
    private double salario;
    private String cargo;

    public Funcionario(int id, String nome, double salario, String cargo) {
        this.id = id;
        this.nome = nome;
        this.salario = salario;
        this.cargo = cargo;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
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
