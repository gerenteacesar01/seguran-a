package modelo;

public class ValoresPadroes {
    private double valorLimiteMin;
    private double valorLimiteMax;
    private String unidade;
    private String valorReferencia;

    public ValoresPadroes(double valorLimiteMin, double valorLimiteMax, String unidade, String valorReferencia) {
        this.valorLimiteMin = valorLimiteMin;
        this.valorLimiteMax = valorLimiteMax;
        this.unidade = unidade;
        this.valorReferencia = valorReferencia;
    }

    public double getValorLimiteMin() {
        return valorLimiteMin;
    }

    public void setValorLimiteMin(double valorLimiteMin) {
        this.valorLimiteMin = valorLimiteMin;
    }

    public double getValorLimiteMax() {
        return valorLimiteMax;
    }

    public void setValorLimiteMax(double valorLimiteMax) {
        this.valorLimiteMax = valorLimiteMax;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getValorReferencia() {
        return valorReferencia;
    }

    public void setValorReferencia(String valorReferencia) {
        this.valorReferencia = valorReferencia;
    }
}
