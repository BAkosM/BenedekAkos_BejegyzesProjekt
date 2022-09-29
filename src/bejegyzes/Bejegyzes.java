package bejegyzes;
import java.time.LocalDateTime;

public class Bejegyzes{
    private String szerzo;
    private String tartalom;
    private int likeok;
    private LocalDateTime letrejott;
    private LocalDateTime szerkesztve;

    public Bejegyzes(String szerzo, String tartalom) {
        this.szerzo = szerzo;
        this.tartalom = tartalom;
        this.likeok = 0;
        this.letrejott = LocalDateTime.now();
        this.szerkesztve = LocalDateTime.now();
    }
    public String getSzerzo(){
        return szerzo;
    }
    public String getTartalom(){
        return tartalom;
    }
    public void setTartalom(String tartalom) {
        this.tartalom = tartalom;
        this.szerkesztve = LocalDateTime.now();
    }
    public int getLikeok(){
        return likeok;
    }
    public LocalDateTime getLetrejott(){
        return letrejott;
    }
    public LocalDateTime getSzerkesztve(){
        return szerkesztve;
    }
    public void like(){
        this.likeok = (this.getLikeok()+1);
    }
    /*public void setListaelem(Bejegyzes listaelem){
        this.szerzo = listaelem.getSzerzo();
        this.tartalom = listaelem.getTartalom();
        this.likeok = listaelem.getLikeok();
        this.letrejott = listaelem.getLetrejott();
        this.szerkesztve = listaelem.getSzerkesztve();
    }*/
    @Override
    public String toString() {
        return String.format("%s - %d - "+letrejott+"\nSzerkesztve: "+szerkesztve+"\n%S\n",szerzo,likeok,tartalom);
    }
}