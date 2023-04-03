public class Vilao extends Personagem {
    private int nivelDeMaldade;

    public int getNivelDeMaldade() {
        return nivelDeMaldade;
    }

    public void setNivelDeMaldade(int nivelDeMaldade) {
        this.nivelDeMaldade = nivelDeMaldade;
    }

    public Vilao(String nome, String editora, int pf, int pe, boolean mimico, boolean drenador, int nivelDeMaldade) {
        super(nome, editora, pf, pe, mimico, drenador);
        this.nivelDeMaldade = nivelDeMaldade;
    }  
}