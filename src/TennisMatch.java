import java.util.HashMap;

public class TennisMatch {
    private Player player1;
    private Player player2;
    private MatchType matchType;
    private HashMap<Player, Game> partie;
    private boolean tieBreakInLastSet;
    boolean isFinished=false;

    public TennisMatch(Player player1, Player player2, MatchType matchType, boolean tieBreakInLastSet) {
        this.player1 = player1;
        this.player2 = player2;
        this.matchType = matchType;
        this.tieBreakInLastSet = tieBreakInLastSet;
        this.partie=new HashMap<>();
        this.partie.put(player1, new Game());
        this.partie.put(player2, new Game());
    }

    public int getNbSetsWin(Player player){
        return this.partie.get(player).getNbSet().getWin();
    }

    public void updateWithPointWonBy(Player player){
        if(!isFinished) {
            this.partie.get(player).addScore();

            if (this.partie.get(player1).getScore().equals("A") && !this.partie.get(player2).getScore().equals("40")) {
                this.partie.get(player1).addScore();
                this.partie.get(player1).winGame();
                this.partie.get(player2).looseGame();
            }

            if (this.partie.get(player2).getScore().equals("A") && !this.partie.get(player1).getScore().equals("40")) {
                this.partie.get(player2).addScore();
                this.partie.get(player2).winGame();
                this.partie.get(player1).looseGame();
            }

            //Gagner un jeu
            if (this.partie.get(player).getScore().equals("W")) {
                if (player == player1) {
                    this.partie.get(player1).winGame();
                    this.partie.get(player2).looseGame();
                } else {
                    this.partie.get(player2).winGame();
                    this.partie.get(player1).looseGame();
                }
            }

            //Perdre l'avantage
            if (this.partie.get(player).getScore().equals("A")) {
                if (player == player1) {
                    if (this.partie.get(player2).getScore().equals("A")) {
                        this.partie.get(player2).reduceScore();
                        this.partie.get(player1).reduceScore();
                    }
                }
                if (player == player2) {
                    if (this.partie.get(player1).getScore().equals("A")) {
                        this.partie.get(player1).reduceScore();
                        this.partie.get(player2).reduceScore();
                    }
                }
            }

            //Vérif win set
            if (this.partie.get(player1).getNbJeu().getWin() >= 6 && this.partie.get(player1).getNbJeu().getWin() >= this.partie.get(player2).getNbJeu().getWin() + 2) {
                System.out.println("Set gagné par " + player1.getName() + " : " + this.partie.get(player1).getNbJeu().getWin() + "/" + this.partie.get(player2).getNbJeu().getWin());
                this.partie.get(player1).getNbSet().winSet();
                this.partie.get(player1).getNbJeu().reset();
                this.partie.get(player2).getNbJeu().reset();
            }
            if (this.partie.get(player2).getNbJeu().getWin() >= 6 && this.partie.get(player2).getNbJeu().getWin() >= this.partie.get(player1).getNbJeu().getWin() + 2) {
                System.out.println("Set gagné par " + player2.getName() + " : " + this.partie.get(player2).getNbJeu().getWin() + "/" + this.partie.get(player1).getNbJeu().getWin());
                this.partie.get(player2).getNbSet().winSet();
                this.partie.get(player1).getNbJeu().reset();
                this.partie.get(player2).getNbJeu().reset();
            }

            //Vérif win match
            if (this.matchType == MatchType.BEST_OF_THREE) {
                if (this.partie.get(player1).getNbSet().getWin() == 3) {
                    isFinished=true;
                    System.out.println("Le joueur "+player1.getName()+" a gagné le match ! --> "+this.partie.get(player1).getNbSet().getWin()+"/"+this.partie.get(player2).getNbSet().getWin());
                }
                if (this.partie.get(player2).getNbSet().getWin() == 3) {
                    isFinished=true;
                    System.out.println("Le joueur "+player2.getName()+" a gagné le match ! --> "+this.partie.get(player2).getNbSet().getWin()+"/"+this.partie.get(player1).getNbSet().getWin());
                }
            }
            if (this.matchType == MatchType.BEST_OF_FIVE) {
                if (this.partie.get(player1).getNbSet().getWin() == 5) {
                    isFinished=true;
                    System.out.println("Le joueur "+player1.getName()+" a gagné le match ! --> "+this.partie.get(player1).getNbSet().getWin()+"/"+this.partie.get(player2).getNbSet().getWin());
                }
                if (this.partie.get(player2).getNbSet().getWin() == 5) {
                    isFinished=true;
                    System.out.println("Le joueur "+player2.getName()+" a gagné le match ! --> "+this.partie.get(player2).getNbSet().getWin()+"/"+this.partie.get(player1).getNbSet().getWin());
                }
            }
        }
    }

    public String pointsForPlayer(Player player){
        return this.partie.get(player).getScore();
    }

    public int gamesInCurrentSetForPlayer(Player player){
        return this.partie.get(player).getNbJeu().getWin();
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
