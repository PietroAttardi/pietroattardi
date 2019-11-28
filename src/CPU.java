package src;
import src.*;

public class CPU extends Giocatore {

  public CPU(){
    super("CPU");
  }
  @Override
  public Carta lancia(){
    Carta toReturn = this.mano.get(0);
    this.mano.remove(0);
    return toReturn;
  }
}
