package giochicarte.briscola;
import giochicarte.briscola.*;
import java.util.*;

public class Mazzo {
  ArrayList<Carta> mazzo;
  int index = 0; //ultima carta disponibile per essere pescata


  public Mazzo(){ // 40 carte siciliane
    String[] nomi = {"Asso","2","3","4","5","6","7","Donna","Cavallo","Re"};
    String[] semi = {"Spade","Denari","Coppe","Mazze"};

    mazzo = new ArrayList<>();

    for(String seme : semi){
      for(String nome : nomi){
        if(nome.equalsIgnoreCase("Asso")) mazzo.add(new Carta(nome,seme,11));
        else if(nome.equalsIgnoreCase("Re")) mazzo.add(new Carta(nome,seme,4));
        else if(nome.equalsIgnoreCase("Cavallo")) mazzo.add(new Carta(nome,seme,3));
        else if(nome.equalsIgnoreCase("Donna")) mazzo.add(new Carta(nome,seme,2));
        else if(nome.equalsIgnoreCase("3")) mazzo.add(new Carta(nome,seme,10));
        else mazzo.add(new Carta (nome, seme, 0));
      }
    }
  }

  public void mescola(){
    Collections.shuffle(this.mazzo);
  }

  public Carta popBriscola(){
    Collections.swap(this.mazzo,0,39);
    return this.mazzo.get(39);
  }

  public void distribuisci(Giocatore g1, Giocatore g2){ // inizio partita
    for(int i = 0; i<3; i++){
      g1.mano.add(this.mazzo.get(this.index++));
      g2.mano.add(this.mazzo.get(this.index++));
    }

  }

  public void distribuisci(Giocatore g){
    if(this.index<this.mazzo.size()){
      g.mano.add(this.mazzo.get(this.index++));
    }
  }

  @Override
  public String toString(){
    StringBuilder toReturn = new StringBuilder("");
    for(Carta c : this.mazzo){
      toReturn.append(c.toString());
      toReturn.append('\n');
    }
    return toReturn.toString();
  }
}
