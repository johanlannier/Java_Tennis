public class Jeu {
    private int win;

    public Jeu() {
        this.win = 0;
    }

    public void addWin(){
        this.win+=1;
    }

    public int getWin() {
        return win;
    }

    public void reset(){
        this.win=0;
    }
}
