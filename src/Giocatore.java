package giochicarte.briscola;
import giochicarte.briscola.*;
import java.util.*;

public class Giocatore {
  protected String nickName;
  protected ArrayList<Carta> mano;
  protected int punteggio;

  public Giocatore(String nickName){
    this.nickName = nickName;
    this.mano = new ArrayList<>();
    this.punteggio = 0;
  }


  public final String getNick(){
    return this.nickName;
  }

  public final int getSizeMano(){
    return this.mano.size();
  }

  public final int getPunteggio(){
    return this.punteggio;
  }
  public final void addPunteggio(int punteggio){
    this.punteggio += punteggio;
  }


  public Carta lancia(){
    System.out.println("Le tue carte:");
    for(int i = 0; i<this.mano.size(); i++){
      System.out.println((i+1)+". "+this.mano.get(i));
    }

    boolean ripeti = true;
    Carta toReturn = null;
    while(ripeti){
      try{
        Scanner in = new Scanner(System.in);
        System.out.print(">> ");
        int choice = in.nextInt();
        toReturn = this.mano.get(choice-1);
        this.mano.remove(choice-1);
        ripeti = false;


      }
      catch(InputMismatchException | IndexOutOfBoundsException ex){
        System.out.println("Scelta non valida. Riprova.");
      }
    }
    return toReturn;
  }

}
