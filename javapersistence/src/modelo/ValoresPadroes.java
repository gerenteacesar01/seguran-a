package modelo;
public class ValoresPadroes {
    private int id;
    private double valor1;
    private double valor2;
    // Adicione mais atributos conforme necessário

    public ValoresPadroes(int id, double valor1, double valor2 /* adicione mais parâmetros, se necessário */) {
        this.id = id;
        this.valor1 = valor1;
        this.valor2 = valor2;
        // Inicialize os demais atributos, se houver
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValor1() {
        return valor1;
    }

    public void setValor1(double valor1) {
        this.valor1 = valor1;
    }

    public double getValor2() {
        return valor2;
    }

    public void setValor2(double valor2) {
        this.valor2 = valor2;
    }
    // Adicione getters e setters para outros atributos, se necessário
}
