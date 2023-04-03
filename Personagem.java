import java.util.ArrayList;
import java.util.Iterator;

public abstract class Personagem {

    private String nome;
    private String editora;
    private int pfInicial;
    private int peInicial;
    private int pf;
    private int pe;
    private boolean mimico;
    private boolean drenador;
    private ArrayList<Poder> poderes = new ArrayList<Poder>();

  //getters and setters
  
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEditora() {
        return editora;
    }
    public void setEditora(String editora) {
        this.editora = editora;
    }
    public int getPfInicial() {
        return pfInicial;
    }
    public void setPfInicial(int pfInicial) {
        this.pfInicial = pfInicial;
    }
    public int getPeInicial() {
        return peInicial;
    }
    public void setPeInicial(int peInicial) {
        this.peInicial = peInicial;
    }
    public int getPf() {
        return pf;
    }
    public void setPf(int pf) {
        this.pf = pf;
    }
    public int getPe() {
        return pe;
    }
    public void setPe(int pe) {
        this.pe = pe;
    }
    public boolean isMimico() {
        return mimico;
    }
    public void setMimico(boolean mimico) {
        this.mimico = mimico;
    }
    public boolean isDrenador() {
        return drenador;
    }
    public void setDrenador(boolean drenador) {
        this.drenador = drenador;
    }

    public String Classe(){
        Class c = getClass();
        return c.getSimpleName();

    }

//constructor
  
    public Personagem(String nome, String editora, int pf, int pe, boolean mimico,
            boolean drenador) {
        this.nome = nome;
        this.editora = editora;
        this.pf = pf;
        this.pfInicial = pf;
        this.peInicial = pe;
        this.pe = pe;
        this.mimico = mimico;
        this.drenador = drenador;
    }

    public void Drenar(Personagem i,Personagem j){
        i.setPe(j.getPeInicial()+i.getPe());
    }
    
    public void Clonar(Personagem i, Personagem j){
        i.poderes.clear();
        i.setPoderes(j.getPoderes());

    } 

    public void AdicionarPoder(Poder p){
        this.poderes.add(p);
    }
    
    public void RemoverPoder(Poder p){
        this.poderes.remove(p);
    }
    
    public ArrayList<Poder> getPoderes() {
        return poderes;
    }
    public void setPoderes(ArrayList<Poder> poderes) {
        this.poderes = poderes;
    }

    public void listarPoderes(){
        Iterator<Poder> it = this.poderes.iterator();
        System.out.printf("Os poderes do :  "+this.nome+" são esses.\n");
        while(it.hasNext()){
            Poder p = (Poder)it.next();
            System.out.println(p.getNome());
        }
    }
}