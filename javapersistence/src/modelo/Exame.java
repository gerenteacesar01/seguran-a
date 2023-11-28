package modelo;

public class Exame {
    
    private String dados;

    public Exame( String nome) {
       
        this.dados = nome;
    }


    
    

    public String getNome() {
        return dados;
    }

    public void setNome(String nome) {
        this.dados = nome;
    }
}
