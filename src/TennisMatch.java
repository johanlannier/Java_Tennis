import java.util.HashMap;

public class TennisMatch {
    private Player player1;
    private Player player2;
    private MatchType matchType;
    private HashMap<Player, Game> partie;
    private boolean tieBreakInLastSet;

    public TennisMatch(Player player1, Player player2, MatchType matchType, boolean tieBreakInLastSet) {
        this.player1 = player1;
        this.player2 = player2;
        this.matchType = matchType;
        this.tieBreakInLastSet = tieBreakInLastSet;
        this.partie=new HashMap<>();
        this.partie.put(player1, new Game());
        this.partie.put(player2, new Game());
    }

    public void updateWithPointWonBy(Player player){
        this.partie.get(player).addScore();

        //Gagner un jeu
        if(this.partie.get(player).getScore().equals("W")){
            if(player==player1){
                this.partie.get(player1).winGame();
                this.partie.get(player2).looseGame();
            }else{
                this.partie.get(player2).winGame();
                this.partie.get(player1).looseGame();
            }
        }

        //Perdre l'avantage
        if(this.partie.get(player).getScore().equals("A")){
            if(player==player1){
                if(this.partie.get(player2).getScore().equals("A")){
                    this.partie.get(player2).reduceScore();
                    this.partie.get(player1).reduceScore();
                }
            }
            if(player==player2){
                if(this.partie.get(player1).getScore().equals("A")){
                    this.partie.get(player1).reduceScore();
                    this.partie.get(player2).reduceScore();
                }
            }
        }
    }

    public String pointsForPlayer(Player player){
        return this.partie.get(player).getScore();
    }

    public int currentSetNumber(){
        return 0;
    }

    public int gamesInCurrentSetForPlayer(Player player){
        return this.partie.get(player).getNbJeu().getWin();
    }

    public int gamesInSetForPlayer(int setNumber, Player player){
        return 0;
    }

    public boolean isFinished(){
        return false;
    }



        //GETTERS & SETTERS
    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public MatchType getMatchType() {
        return matchType;
    }

    public void setMatchType(MatchType matchType) {
        this.matchType = matchType;
    }

    public boolean isTieBreakInLastSet() {
        return tieBreakInLastSet;
    }

    public void setTieBreakInLastSet(boolean tieBreakInLastSet) {
        this.tieBreakInLastSet = tieBreakInLastSet;
    }
}
