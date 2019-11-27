package giochicarte.briscola;
public class Carta {
  String nome;
  String seme;
  int valore;

  public Carta(String nome, String seme, int valore){
    this.nome = nome;
    this.seme = seme;
    this.valore = valore;
  }

  public final int getValore(){
    return this.valore;
  }

  public int getNome(){
    if(this.nome.equalsIgnoreCase("Donna")) return 2;
    else if(this.nome.equalsIgnoreCase("Cavallo")) return 3;
    else if(this.nome.equalsIgnoreCase("Re")) return 4;
    else if(this.nome.equalsIgnoreCase("3")) return 10;
    else if(this.nome.equalsIgnoreCase("Asso")) return 11;
    else return Integer.parseInt(this.nome);
  }

  public boolean isBriscola(String briscola){
    return (this.seme.equalsIgnoreCase(briscola));
  }

  public static boolean comparaCarte(Carta c1, Carta c2, String briscola){ //restituisce true se carta1>carta2
    if(c1.isBriscola(briscola) && c2.isBriscola(briscola)){ // se entrambe sono briscole
      if(c1.valore == 0 && c2.valore == 0){// nel caso in cui entrambe abbiano valore 0, allora bisogna guardare il nome
        return (c1.getNome()>c2.getNome())? true : false;
      }
      else{//se una delle due ha valore != 0, posso guardare il valore
        return (c1.valore>c2.valore)? true : false;
      }
    }//fine confronto tra due carte che sono entrambe dello stesso seme della briscola
    else if(c1.isBriscola(briscola) || c2.isBriscola(briscola)){
      return (c1.isBriscola(briscola))? true : false;
    }//fine confronto
    else if(c1.seme.equalsIgnoreCase(c2.seme)){// se nessuna delle due carte è una briscola, la prima carta decide la briscola di mano... Se entrambe hanno lo stesso seme
      if(c1.valore == 0 &&  c2.valore == 0){
        return (c1.getNome()>c2.getNome())? true : false;
      }
      else{
        return (c1.valore>c2.valore)? true : false;
      }
    }
    else{ //infine, entrambe non sono briscole e hanno seme diverso
      return true; //vince la prima carta
    }
  }

  @Override public String toString(){
      return(this.nome+" di "+this.seme+" ("+this.valore+").");
  }

}
