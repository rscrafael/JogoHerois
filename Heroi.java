public class Heroi extends Personagem {

    private String nomeReal;

    public String getNomeReal() {
        return nomeReal;
    }

    public void setNomeReal(String nomeReal) {
        this.nomeReal = nomeReal;
    }

    public Heroi(String nome, String editora, int pf, int pe, boolean mimico, boolean drenador, String nomeReal) {
        super(nome, editora, pf, pe, mimico, drenador);
        this.nomeReal = nomeReal;
    } 
}