package bejegyzes;
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
        this.letrejott = new LocalDateTime();
        this.szerkesztve = new LocalDateTime();
    }
    public String getSzerzo(){
        return szerzo;
    }
    public int getTartalom(){
        return tartalom;
    }
    public void setTartalom(String tartalom) {
        this.tartalom = tartalom;
        this.szerkesztve = new LocalDateTime();
    }
    public int getLikeok(){
        return likeok;
    }
    public int getLetrejott(){
        return letrejott;
    }
    public int getSzerkesztve(){
        return szerkesztve;
    }
    public void like(){
        this.likeok = (this.getLikeok()+1);
    }
    @Override
    public String toString() {
        return String.format("%s - %d - "+letrejott+"\nSzerkesztve: "+szerkesztve+"\n%S",szerzo,likeok,tartalom);
    }
}