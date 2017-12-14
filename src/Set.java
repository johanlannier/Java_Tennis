public class Set {
    private int win;

    public Set() {
        this.win = 0;
    }

    public void winSet(){
        this.win+=1;
    }

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }
}
