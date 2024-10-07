package Pack;
import java.util.Scanner;
public class TestGiocatore {
    public static void main(String[]args){
        Scanner in = new Scanner(System.in);
        int scelta;
        boolean active=true;
        int nGiocatori =0;
        String nome;
        String capitano;
        boolean isCapitano;
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
            scelta=in.nextInt();
            switch (scelta){
                case 1:
                    System.out.println("Inserisci i dati del nuovo giocatore in quest'ordine: Nome, capitano(si/no), numero di gol");
                    nome=in.next();
                    capitano=in.next();
                    if(capitano.equalsIgnoreCase("no"))
                        isCapitano=false;
                    else
                        isCapitano=true;
                    gol=in.nextInt();
                    CreaGiocatore(nome, isCapitano, gol, g, nGiocatori);
                    nGiocatori++;
                    break;
                case 2:
                    for(int i=0;i<nGiocatori+1;i++){
                        System.out.println(VisualizzaGiocatori(g, i));
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
}
