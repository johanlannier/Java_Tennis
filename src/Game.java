public class Game {
    private Jeu nbJeu;
    private Set nbSet;
    private Score score;


    public Game() {
        this.nbJeu = new Jeu();
        this.nbSet = new Set();
        this.score= new Score();
    }

    public void addScore(){
        this.score.win();
    }

    public void reduceScore(){
        this.score.looseAdvantage();
    }

    public String getScore(){
        return this.score.getScore();
    }

    private void newGame(){
            this.score.reset();
    }

    public void winGame(){
        this.nbJeu.addWin();
        this.newGame();
    }

    public void looseGame(){
        this.newGame();
    }

    public Jeu getNbJeu() {
        return nbJeu;
    }

    public void setNbJeu(Jeu nbJeu) {
        this.nbJeu = nbJeu;
    }

    public Set getNbSet() {
        return nbSet;
    }

    public void setNbSet(Set nbSet) {
        this.nbSet = nbSet;
    }
}
