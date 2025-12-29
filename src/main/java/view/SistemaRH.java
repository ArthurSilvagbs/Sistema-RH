package view;

public class SistemaRH {

    public static void main(String[] args) {
        try {
            Menus menu = new Menus();
            menu.exibirMenuPrincipal();
        } catch (Exception e) {
            System.err.println("Ocorreu um erro crítico no sistema: " + e.getMessage());
        }
    }
}
