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