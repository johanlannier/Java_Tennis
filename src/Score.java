public class Score{
    private String score;

    public Score() {
        this.score = "0";
    }

    public void win(){
        switch (score){
            case "0":
                this.score="15";
                break;
            case "15":
                this.score="30";
                break;
            case "30":
                this.score="40";
                break;
            case "40":
                this.score="A";
                break;
            case "A":
                this.score="W";
                break;
        }
    }

    public void looseAdvantage(){
        this.score="40";
    }

    public void reset(){
        this.score="0";
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}

/*public enum Score {
    ZERO("0"),
    QUINZE("15"),
    TRENTE("30"),
    QUARANTE("40"),
    AVANTAGE("A"),
    WIN("W");

    private String score;

    Score(String score) {
        this.score = score;
    }

    public String getScore() {
        return this.score;
    }

    public void win(){
        switch(this){
            case ZERO:
                this.score=Score.QUINZE.score;
                break;
            case QUINZE:
                this.score=Score.TRENTE.score;
                break;
            case TRENTE:
                this.score=Score.QUARANTE.score;
                break;
            case QUARANTE:
                this.score=Score.AVANTAGE.score;
                break;
            case AVANTAGE:
                this.score=Score.WIN.score;
                break;
        }
    }

    public void lostAvantage(){
        this.score=Score.QUARANTE.score;
    }
}*/