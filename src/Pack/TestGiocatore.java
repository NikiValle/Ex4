package Pack;
import java.util.Scanner;
public class TestGiocatore {
    public static void main(String[]args){
        Scanner in = new Scanner(System.in);
        int sceltaNumerica;
        String scelta;
        boolean active=true;
        int giocatoreInModifica;
        int nGiocatori =0;
        String modGiocatore;
        String nome;
        String capitano;
        boolean presenzaCapitano = false;
        boolean isCapitano =false;
        boolean error;
        int gol;
        Giocatore[] g = new Giocatore[1000];
        do{
            System.out.println("Scegli una tra queste opzioni:" +
                    "1.Aggunta di un giocatore alla squadra\n" +
                    "2.Visualizza tutti i giocatori della squadra\n" +
                    "3.Modifica i dati di un giocatore a scelta\n" +
                    "4.Cancella un giocatore dalla squadra \n" +
                    "5.Visualizza i giocatori che hanno realizzato più di 5 goal.\n" +
                    "6.Visualizza il nome del capitano\n" +
                    "7.Assegna il ruolo di capitano in modo casuale se non ancora presente");
            sceltaNumerica=in.nextInt();
            switch (sceltaNumerica){
                case 1:
                    System.out.println("Inserisci i dati del nuovo giocatore in quest'ordine: Nome, capitano(si/no), numero di gol");
                    nome=in.next();
                    do {
                        error=false;
                        capitano = in.next();
                        if (capitano.equalsIgnoreCase("no"))
                            isCapitano = false;
                        else if(capitano.equalsIgnoreCase("si")||capitano.equalsIgnoreCase("sì")&&presenzaCapitano==true){
                            System.out.println("É già presente un capitano, scrivi no");
                            error=true;
                        }
                        else
                            isCapitano=true;
                    }while(error);
                    gol=in.nextInt();
                    CreaGiocatore(nome, isCapitano, gol, g, nGiocatori);
                    nGiocatori++;
                    break;
                case 2:
                    for(int i=0;i<nGiocatori+1;i++){
                        System.out.println(VisualizzaGiocatori(g, i));
                    }
                    break;
                case 3:
                    System.out.println("Inserisci nome del giocatore di cui vuoi modificare i dati");
                    modGiocatore=in.next();
                    giocatoreInModifica=TrovaGiocatore(g,nGiocatori, modGiocatore);
                    if(giocatoreInModifica==-1){
                        System.out.println("Nessun giocatore trovato con questo nome");
                        break;
                    }
                    System.out.println("Scegli il dato che vuoi modificare: Nome, capitano, numero gol");
                    scelta=in.next();
                    if(scelta.equalsIgnoreCase("nome")){
                        System.out.println("Inserisci il nuovo nome");
                        g[giocatoreInModifica].setNome(in.next());
                    }
                    else if(scelta.equalsIgnoreCase("capitano")){
                        System.out.println("Valore capitano invertito");
                        if(g[giocatoreInModifica].getCapitano()==false)
                            g[giocatoreInModifica].setCapitano(true);
                        else
                            g[giocatoreInModifica].setCapitano(false);
                    }
                    else{
                        System.out.println("Inserisci il nuovo numero di gol");
                        g[giocatoreInModifica].setGol(in.nextInt());
                    }
                    break;

            }
        }while(active);
    }
    public static void CreaGiocatore(String Nome, boolean Capitano, int Gol, Giocatore[] g, int nGiocatori){
        g[nGiocatori] = new Giocatore(Nome, Capitano, Gol);
    }
    public static String VisualizzaGiocatori(Giocatore[] g, int i){
        String c;
        if(g[i].getCapitano())
            c="è capitano";
        else
            c="non è capitano";
        String output = (g[i].getNome()+", "+c+", "+g[i].getGol());
        return output;
    }
    public static int TrovaGiocatore(Giocatore[]g, int nGiocatori, String nome){
        for(int i=0;i<nGiocatori+1;i++){
            if(g[i].getNome().equalsIgnoreCase(nome))
                return i;
            break;
        }
        return -1;
    }
}
