package Pack;
import java.util.Scanner;
public class TestGiocatore {
    public static void main(String[]args){
        Scanner in = new Scanner(System.in);
        String nome;
        String capitano;
        boolean isCapitano;
        int gol;
        String gMaggiore;
        System.out.println("Inserisci i dati del primo giocatore in quest'ordine: Nome, capitano(si/no), gol segnati");
        nome=in.next();
        capitano=in.next();
        if(capitano.equalsIgnoreCase("no"))
            isCapitano=false;
        else
            isCapitano=true;
        gol=in.nextInt();
        Giocatore G1 = new Giocatore(nome, isCapitano, gol);
        System.out.println("Inserisci i dati del secondo giocatore in quest'ordine: Nome, capitano(si/no), gol segnati");
        nome=in.next();
        capitano=in.next();
        if(capitano.equalsIgnoreCase("no"))
            isCapitano=false;
        else
            isCapitano=true;
        gol=in.nextInt();
        Giocatore G2 = new Giocatore(nome, isCapitano, gol);
        System.out.println("Inserisci i dati del terzo giocatore in quest'ordine: Nome, capitano(si/no), gol segnati");
        nome=in.next();
        capitano=in.next();
        if(capitano.equalsIgnoreCase("no"))
            isCapitano=false;
        else
            isCapitano=true;
        gol=in.nextInt();
        Giocatore G3 = new Giocatore(nome, isCapitano, gol);
        if(G1.getGol()>G2.getGol()&&G1.getGol()>G3.getGol())
            gMaggiore=G1.getNome();
        else if(G1.getGol()<G2.getGol()&&G2.getGol()>G3.getGol())
            gMaggiore=G2.getNome();
        else
            gMaggiore=G3.getNome();
        System.out.println("Il giocatore con il maggior numero di reti è: "+gMaggiore);
    }
}
