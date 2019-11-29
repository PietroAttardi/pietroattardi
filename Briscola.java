import giochicarte.briscola.*;
import java.util.*;

public class Briscola {

  public static void main(String[] args) {
    System.out.println("\t *** Benvenuto nel gioco della Briscola ***");

    //scelta nickname
    System.out.println("Scegli il tuo nickname: ");
    System.out.print(">> ");
    boolean ripeti = true;
    Giocatore giocatore = null;
    while(ripeti){
      try{
        Scanner in = new Scanner(System.in);
        giocatore = new Giocatore(in.nextLine());
        ripeti = false;
      }
      catch(NoSuchElementException ex){
        System.out.println("Riprova...");
      }
    }

    //CPU
    Giocatore cpu = new CPU();
    System.out.println("\tBenvenuto "+giocatore.getNick());

    //Giocatore -> primoGiocatore
    Giocatore primoGiocatore = giocatore;
    Giocatore secondoGiocatore = cpu;

    //setup mazzo
    Mazzo mazzo = new Mazzo();
    mazzo.mescola();
    Carta semeBriscola = mazzo.popBriscola();
    mazzo.distribuisci(primoGiocatore, secondoGiocatore);

    //inizio gioco
    while(giocatore.getSizeMano() != 0 && cpu.getSizeMano() != 0){
      System.out.println("\n*****************************************************\n");

      //display briscola
      System.out.println("\tLa briscola è: "+semeBriscola);

      //scelta primoGiocatore
      Carta c1 = primoGiocatore.lancia();
      System.out.println("\t"+primoGiocatore.getNick()+" ha lanciato: "+c1);

      //scelta secondoGiocatore
      Carta c2 = secondoGiocatore.lancia();
      System.out.println("\t"+secondoGiocatore.getNick()+" ha lanciato: "+c2);

      //calcolo del vincitore
      boolean winner = Carta.comparaCarte(c1,c2,semeBriscola.getSeme());
      Giocatore vincitore = (winner)? primoGiocatore : secondoGiocatore;
      System.out.println("\tVince la mano : "+ vincitore.getNick());

      //setup per il prossimo round
      if (vincitore == secondoGiocatore){
        secondoGiocatore.addPunteggio(c1.getValore() + c2.getValore());
        Giocatore temp = primoGiocatore;
        primoGiocatore = secondoGiocatore;
        secondoGiocatore = temp;
      }else{
        primoGiocatore.addPunteggio(c1.getValore() + c2.getValore());
      }
      mazzo.distribuisci(primoGiocatore);
      mazzo.distribuisci(secondoGiocatore);

      //display punteggio attuale
      System.out.println("Il tuo punteggio: "+giocatore.getPunteggio());
      System.out.println("Il punteggio della CPU: "+cpu.getPunteggio());

      System.out.println("\n*****************************************************\n");

    }



    //Epilogo
    System.out.println("Il vincitore è: "+ ((cpu.getPunteggio()>=61)? cpu.getNick() : giocatore.getNick()));


  }
}
