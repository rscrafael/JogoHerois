/*software de confronto entre heróis e vilões e, por que não, heróis contra heróis e vilões contra vilões

Lista de abreviações:
PF - pontos de força
PE - pontos de energia
*/

//importar as bibliotecas
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws Exception {

       ArrayList<Personagem> personagem = new ArrayList<>();

        Random random = new Random();
      
//Criar os heróis
        Heroi superman = new Heroi("Superman","DC Comics",100,70,false,true,"Clark Kent");
        Heroi aranha = new Heroi("Homem-Aranha","Marvel Comics",80,50,false,false,"Peter Parker");
        Heroi fenix = new Heroi("Fenix","Marvel comics",150,100,false,false,"Jean Grey");
        Heroi mimico = new Heroi("Mímico","Marvel Comics",70,50,true,false," Calvin Montgomery Rankin");
      
//Criar os vilões
        Vilao bizarro = new Vilao("Superbizarro","DC Comics",95,65,false,false,50);
        Vilao duende = new Vilao("Duende verde","Marvel Comics",80,60,false,false,70);
        Vilao octopus = new Vilao("Doutor Octopus","Marvel Comics",70,40,false,false,40);
        Vilao skrull = new Vilao("Super Skrull","Marvel Comics",90,60,true,false,100);
        Vilao parasita = new Vilao("Parasita","DC Comics",90,70,false,true,70);
        
//Poderes superman
        Poder fSMan = new Poder("Força", 10, 8);
        Poder vSMan = new Poder("Visão de Raios",5,5);
        Poder sSMan = new Poder("Super Sopro",4,4);
//poderes homem-aranha
        Poder fAranha = new Poder("Força",7,5);
        Poder vaiTeia= new Poder("Soltar teia",5,5);
//poderes Fenix        
        Poder fFenix = new Poder("Força",12,10);
//poderes Duende verde        
        Poder fDuende = new Poder("Força",7,5);
        Poder granada = new Poder("Granada de Abóbora",5,5);
//poderes Octopus
        Poder tentaculo = new Poder("Tentáculos",6,4);
//poderes parasita        
        Poder fParasita = new Poder("Força",7,8);
        Poder rParasita = new Poder ("Rajada Energética",6,8);
      
//adicionar poder superman
        superman.AdicionarPoder(fSMan);
        superman.AdicionarPoder(vSMan);
        superman.AdicionarPoder(sSMan);
//adicionar poder homen aranha
        aranha.AdicionarPoder(fAranha);
        aranha.AdicionarPoder(vaiTeia);
//adicionar poder fenix
        fenix.AdicionarPoder(fFenix);
//adicionar poder bizarro igual ao superman
        bizarro.AdicionarPoder(fSMan);
        bizarro.AdicionarPoder(vSMan);
        bizarro.AdicionarPoder(sSMan);
//adicionar poder duende verde
        duende.AdicionarPoder(fDuende);
        duende.AdicionarPoder(granada);
//adicionar poder dr. Octopus
        octopus.AdicionarPoder(tentaculo);
//adicionar poder Parasita
        parasita.AdicionarPoder(fParasita);
        parasita.AdicionarPoder(rParasita);
//adicionar personagens 
        personagem.add(superman);
        personagem.add(aranha);
        personagem.add(fenix);
        personagem.add(bizarro);
        personagem.add(duende);
        personagem.add(octopus);
        personagem.add(skrull);
        personagem.add(mimico);
        personagem.add(parasita);
      
//incluir o scanner        
        Scanner sc = new Scanner(System.in);

        short opcao = 100;
           
        do {
            
            menu();

            opcao = sc.nextShort();

                switch(opcao){
                    
//Usuário escolhe quem irá lutar                
                   case 1:
                    

menu1();
       System.out.printf("\nDigite o número correspondente ao Heroí ou Vilão escolhido\n"); 
        int n1 = sc.nextInt(personagem.size());
menu1();
      System.out.printf("\nEscolha número correspondente ao oponente\n");
          int n2 = sc.nextInt(personagem.size()); 
           
                        while(n1 == n2){
                            n1 = sc.nextInt(personagem.size());
                            n2 = sc.nextInt(personagem.size());
                        }
    
                        Confronto(personagem.get(n1),personagem.get(n2));
                        
                        break;
    
 //O sistema escolhe aleatóriamente quem irá lutar
                    
                  case 2:
                        
                        int jogador1 = random.nextInt(personagem.size());
                        int jogador2 = random.nextInt(personagem.size());
    
                        while(jogador1 == jogador2){
                            jogador1 = random.nextInt(personagem.size());
                            jogador2 = random.nextInt(personagem.size());
                        }
         Confronto(personagem.get(jogador1),personagem.get(jogador2));
                        break;
//opção de erro quando digitar número errado                   
                    case 3:
                    break;
    
                    default:
                    System.out.println("Opção inválida! Digite 3 para sair.\n");
                    break;
    
                }
                
       } while (opcao != 3);
        
        sc.close();
    }
//Modo randomico
    public static Poder Atacar(Personagem atc){
        Random i = new Random();
        int random = i.nextInt(atc.getPoderes().size());
        Poder j = atc.getPoderes().get(random); 
        return j;
    }

    public static void Recuperar(Personagem a){
      
//Recuperar recupera 30% do PE com base no PEInicial
        double r = a.getPeInicial() * 0.3;
        a.setPe(a.getPe()+(int)r);
        }

    public static void RecuperarTudo(Personagem a){
        a.setPe(a.getPeInicial());
        a.setPf(a.getPfInicial());
        }

//Confronto
    public static Personagem Confronto(Personagem a, Personagem b){

        Personagem perdedor = null;

        System.out.printf("%s e %s se encontram para uma batalha! Quem sairá vencedor?\n",a.getNome(),b.getNome());
        
        if(a.Classe() == "Heroi" && b.Classe() == "Heroi"){
            System.out.println("Confronto Herói contra Herói, quem sairá vencedor?\n");
        }
        if(a.Classe() == "Vilao" && b.Classe() == "Vilao"){
            System.out.println("Em uma batalha entre a maldade, quem será o pior?\n");
        }
        if(a.Classe() != b.Classe()){
            System.out.println("Confronto Clássico: Bem versus o Mal!\n");
        }

        System.out.println("Que os Jogos começem\n");

        if(a.getEditora() == b.getEditora()){
            System.out.println("Confronto: "+a.getEditora());
        }else{
            System.out.println("Confronto CrossOver\n");
        }

        RecuperarTudo(a);
        RecuperarTudo(b);

        System.out.printf("A força do(a) %s é de %d e sua energia é de %d.\n",a.getNome(),a.getPf(),a.getPe());
        System.out.printf("A força do(a) %s é de %d e sua energia é de %d.\n",b.getNome(),b.getPf(),b.getPe());
        System.out.println("\n");
        
        if(a.isMimico() == true){
            a.Clonar(a, b);
        }
        if(b.isMimico() == true){
            b.Clonar(b, a);
        }

        while(a.getPf()>0 && b.getPf()>0){
            Random jogador = new Random();

            ArrayList<Personagem> ordem = new ArrayList<>();
            ordem.add(a);
            ordem.add(b);

            int go = jogador.nextInt(ordem.size());

            Personagem jogador1 = ordem.get(go);
            Personagem jogador2; 
            
            if(jogador1 == a){
                jogador2 = b;
            } 
            else{
                jogador2 = a;
            }

            System.out.printf("O primeiro a atacar nesta rodada é o(a), %s.\n",jogador1.getNome());

            Poder ataque1 = Atacar(jogador1);

            if (jogador1.getPe() >= ataque1.getPe()) {

                System.out.printf("%s usou %s.\n",jogador1.getNome(),ataque1.getNome());

                System.out.printf("%s do(a) %s possui %d de dano e gasta %d de PE.\n",ataque1.getNome(),jogador1.getNome(),ataque1.getDano(),ataque1.getPe());
                
                jogador2.setPf(jogador2.getPf()-ataque1.getDano());
                jogador1.setPe(jogador1.getPe()-ataque1.getPe());

                System.out.printf("Neste ataque, o PF do %s caiu para %d.\n",jogador2.getNome(),jogador2.getPf());
                System.out.printf("%s possui %d de energia.\n",jogador1.getNome(),jogador1.getPe());
                }

            else
            {
                System.out.printf("%s tentou usar %s mas está sem PE. Nesta rodada irá descansar, para se recuperar.\n",jogador1.getNome(),ataque1.getNome());
              
//Recuperar recupera 30% do PE jogador1
                Recuperar(jogador1);
                double i = jogador1.getPeInicial()*0.3;
                int recup = (int)i;
                System.out.printf("%s conseguiu %d PE descansando.\n",jogador1.getNome(),recup);
            }
          
           if(jogador2.getPf()>0){

                Poder ataque2 = Atacar(jogador2);

                if(jogador2.getPe()>= ataque2.getPe()){

                    System.out.printf("%s usou %s.\n",jogador2.getNome(),ataque2.getNome());

                    System.out.printf("%s de %s possuí %d de dano e gasta %d de PE.\n",ataque2.getNome(),jogador2.getNome(),ataque2.getDano(),ataque2.getPe());
                    
                    jogador1.setPf(jogador1.getPf()-ataque2.getDano());
                    jogador2.setPe(jogador1.getPe()-ataque2.getDano());

                    System.out.printf("Neste ataque, o PF do %s diminuiu para %d.\n",jogador1.getNome(),jogador1.getPf());
                    System.out.printf("%s está com %d de energia.\n",jogador2.getNome(),jogador2.getPe());
                    }

                else 
                {
                    System.out.printf("%s tentou usar %s mas está sem PE.  Nesta rodada irá descansar, para se recuperar.\n",jogador2.getNome(),ataque2.getNome());
                  
//Recuperar recupera 30% do PE jogador2
                    Recuperar(jogador2);
                    double i = jogador2.getPeInicial()*0.3;
                    int recup = (int)i;
                    System.out.printf("%s conseguiu %d PE descansando.\n",jogador2.getNome(),recup);  
                }


                               }           

            System.out.println("\n");
           
            if(jogador1.getPf() <= 0 && jogador2.getPf()> 0){
                System.out.printf("Final do combate o vencedor(a) foi o(a): %s.\n",jogador2.getNome());
                perdedor = jogador1;
                if(jogador1.isMimico()== true){
                    jogador1.Drenar(jogador1, jogador2);
                }

            }
            if(jogador2.getPf()<= 0 && jogador1.getPf()>0){
                System.out.printf("Final do combate o vencedor(a) foi o(a): %s.\n",jogador1.getNome());
                perdedor = jogador2;
                if(jogador2.isMimico()== true){
                    jogador2.Drenar(jogador1, jogador2);
            }

            }

        }
        return perdedor;
    }

    public static void listarPersonagem(ArrayList<Personagem> a){
        Iterator<Personagem> it = a.iterator();
        System.out.printf("\nQuem poderá lutar:\n");
        while(it.hasNext()){
            Personagem p = (Personagem)it.next();
            System.out.println(p.getNome());
        }
    }
  
//Menu    
    public static void menu(){
        System.out.printf("\n-------------- Batalha entre Herói vs Vilão | Herói vs Herói | Vilão vs Vilão --------------\nDigite 1 - Para escolher os personagem.\nDigite 2 - Batalha aleatória.\nDigite 3 - Caso queira parar.\n");
    }
public static void menu1(){
        System.out.printf("\n-------------- Escolha seu Herói ou Vilão --------------\nDigite 0 - Super-Homem.\nDigite 1 - Homem-Aranha.\nDigite 2 - Fênix.\nDigite 3 - Superbizarro.\nDigite 4 - Duende Verde.\nDigite 5 - Doutor Octopus.\nDigite 6 - Super Skrull.\nDigite 7 - Mímico.\nDigite 8 - Parasita.");
    }
  
}  