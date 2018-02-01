import static org.junit.Assert.*;
import org.junit.*;

public class MatchTestsTHREE {
    private Player player1;
    private Player player2;
    private TennisMatch match;

    @Before
    public void createMatch(){
        player1=new Player("Adeline");
        player2=new Player("Nicolas");
        match=new TennisMatch(player1, player2, MatchType.BEST_OF_THREE, false);
    }

    @Test
    public void matchInfos(){
        assertEquals(match.getMatchType(),MatchType.BEST_OF_THREE);
    }

    @Test
    public void winPoints(){
        //Player1
        assertEquals("0", match.pointsForPlayer(player1));

        match.updateWithPointWonBy(player1); //15
        assertEquals("15", match.pointsForPlayer(player1));

        match.updateWithPointWonBy(player1); //30
        assertEquals("30", match.pointsForPlayer(player1));

        match.updateWithPointWonBy(player1); //40
        assertEquals("40", match.pointsForPlayer(player1));

        //Player2
        assertEquals("0", match.pointsForPlayer(player2));

        match.updateWithPointWonBy(player2); //15
        assertEquals("15", match.pointsForPlayer(player2));
    }

    @Test
    public void WinGameWithAdvantage(){
        //Player1
        match.updateWithPointWonBy(player1); //15
        match.updateWithPointWonBy(player1); //30
        match.updateWithPointWonBy(player1); //40

        //Player2
        match.updateWithPointWonBy(player2); //15
        match.updateWithPointWonBy(player2); //30
        match.updateWithPointWonBy(player2); //40

        assertEquals("40",match.pointsForPlayer(player1));
        assertEquals("40",match.pointsForPlayer(player2));

        match.updateWithPointWonBy(player1); //A
        assertEquals("A",match.pointsForPlayer(player1));

        //Jeu terminé --> 1 jeu gagné par player1 --> nouveau jeu
        match.updateWithPointWonBy(player1); //WIN
        assertEquals("0",match.pointsForPlayer(player1)); //nouveau jeu
        assertEquals(1,match.gamesInCurrentSetForPlayer(player1));
        assertEquals(0,match.gamesInCurrentSetForPlayer(player2));
    }

    @Test
    public void LooseAdvantage(){
        //Player1
        match.updateWithPointWonBy(player1); //15
        match.updateWithPointWonBy(player1); //30
        match.updateWithPointWonBy(player1); //40

        //Player2
        match.updateWithPointWonBy(player2); //15
        match.updateWithPointWonBy(player2); //30
        match.updateWithPointWonBy(player2); //40

        match.updateWithPointWonBy(player1); //A
        assertEquals("A",match.pointsForPlayer(player1));

        match.updateWithPointWonBy(player2); //A
        assertEquals("40",match.pointsForPlayer(player1));
        assertEquals("40",match.pointsForPlayer(player2));
    }

    @Test
    public void WinGameWithoutAdvantage(){
        //Player1
        match.updateWithPointWonBy(player1); //15
        match.updateWithPointWonBy(player1); //30
        match.updateWithPointWonBy(player1); //40

        //Player2
        match.updateWithPointWonBy(player2); //15
        match.updateWithPointWonBy(player2); //30

        match.updateWithPointWonBy(player1); //W

        //Jeu terminé --> 1 jeu gagné par player1
        assertEquals(1,match.gamesInCurrentSetForPlayer(player1));
        assertEquals(0,match.gamesInCurrentSetForPlayer(player2));

        assertEquals("0",match.pointsForPlayer(player1)); //nouveau jeu
        assertEquals("0",match.pointsForPlayer(player2)); //nouveau jeu
    }

    @Test
    public void WinASet(){
        System.out.println("\n\n----------------- TEST BEST OF THREE -----------------");
        //6 jeu gagnés par player1
        System.out.println("\nWin a set:");
        for(int i=0; i<6;i++) {
            match.updateWithPointWonBy(player1); //15
            match.updateWithPointWonBy(player1); //30
            match.updateWithPointWonBy(player1); //40
            match.updateWithPointWonBy(player1); //W
        }

        assertEquals(1,match.getNbSetsWin(player1));
    }

    @Test
    public void WinMatch(){
        System.out.println("\nWin a match:");

        //3 sets gagnés par player1
        for(int j=0; j<3;j++) {
            //6 jeu gagnés par player1
            for (int i = 0; i < 6; i++) {
                match.updateWithPointWonBy(player1); //15
                match.updateWithPointWonBy(player1); //30
                match.updateWithPointWonBy(player1); //40
                match.updateWithPointWonBy(player1); //W
            }
        }

        assertEquals(3,match.getNbSetsWin(player1));
    }

    @Test
    public void MockMatch() {
        System.out.println("\n------- Fake match: ----------");

            //1er jeu 
            match.updateWithPointWonBy(player2); //15
            match.updateWithPointWonBy(player2); //30
            match.updateWithPointWonBy(player1); //15
            match.updateWithPointWonBy(player2); //40
            match.updateWithPointWonBy(player2); //W
            assertEquals(1, match.gamesInCurrentSetForPlayer(player2));
            assertEquals(0, match.gamesInCurrentSetForPlayer(player1));

            //2eme jeu 
            match.updateWithPointWonBy(player2); //15
            match.updateWithPointWonBy(player2); //30
            match.updateWithPointWonBy(player1); //15
            match.updateWithPointWonBy(player2); //40
            match.updateWithPointWonBy(player2); //W
            assertEquals(2, match.gamesInCurrentSetForPlayer(player2));
            assertEquals(0, match.gamesInCurrentSetForPlayer(player1));

            //3eme jeu 
            match.updateWithPointWonBy(player2); //15
            match.updateWithPointWonBy(player2); //30
            match.updateWithPointWonBy(player1); //15
            match.updateWithPointWonBy(player2); //40
            match.updateWithPointWonBy(player2); //W
            assertEquals(3, match.gamesInCurrentSetForPlayer(player2));
            assertEquals(0, match.gamesInCurrentSetForPlayer(player1));

            //4eme jeu 
            match.updateWithPointWonBy(player2); //15
            match.updateWithPointWonBy(player2); //30
            match.updateWithPointWonBy(player1); //15
            match.updateWithPointWonBy(player2); //40
            match.updateWithPointWonBy(player2); //W
            assertEquals(4, match.gamesInCurrentSetForPlayer(player2));
            assertEquals(0, match.gamesInCurrentSetForPlayer(player1));

            //5eme jeu 
            match.updateWithPointWonBy(player2); //15
            match.updateWithPointWonBy(player2); //30
            match.updateWithPointWonBy(player1); //15
            match.updateWithPointWonBy(player2); //40
            match.updateWithPointWonBy(player2); //W
            assertEquals(5, match.gamesInCurrentSetForPlayer(player2));
            assertEquals(0, match.gamesInCurrentSetForPlayer(player1));

            //6eme jeu 
            match.updateWithPointWonBy(player1); //15
            match.updateWithPointWonBy(player1); //30
            match.updateWithPointWonBy(player2); //15
            match.updateWithPointWonBy(player1); //40
            match.updateWithPointWonBy(player1); //W
            assertEquals(5, match.gamesInCurrentSetForPlayer(player2));
            assertEquals(1, match.gamesInCurrentSetForPlayer(player1));

            //7eme jeu 
            match.updateWithPointWonBy(player2); //15
            match.updateWithPointWonBy(player2); //30
            match.updateWithPointWonBy(player1); //15
            match.updateWithPointWonBy(player2); //40
            match.updateWithPointWonBy(player2); //W
            assertEquals(1, match.getNbSetsWin(player2));
            assertEquals(0, match.getNbSetsWin(player1));
            assertEquals(0, match.gamesInCurrentSetForPlayer(player2));
            assertEquals(0, match.gamesInCurrentSetForPlayer(player1));



        for(int i=0; i<2;i++){
        //1er jeu 
        match.updateWithPointWonBy(player1); //15
        match.updateWithPointWonBy(player1); //30
        match.updateWithPointWonBy(player2); //15
        match.updateWithPointWonBy(player1); //40
        match.updateWithPointWonBy(player1); //W
        assertEquals(1, match.gamesInCurrentSetForPlayer(player1));
        assertEquals(0, match.gamesInCurrentSetForPlayer(player2));

        //2eme jeu 
        match.updateWithPointWonBy(player1); //15
        match.updateWithPointWonBy(player1); //30
        match.updateWithPointWonBy(player2); //15
        match.updateWithPointWonBy(player1); //40
        match.updateWithPointWonBy(player1); //W
        assertEquals(2, match.gamesInCurrentSetForPlayer(player1));
        assertEquals(0, match.gamesInCurrentSetForPlayer(player2));

        //3eme jeu 
        match.updateWithPointWonBy(player1); //15
        match.updateWithPointWonBy(player1); //30
        match.updateWithPointWonBy(player2); //15
        match.updateWithPointWonBy(player1); //40
        match.updateWithPointWonBy(player1); //W
        assertEquals(3, match.gamesInCurrentSetForPlayer(player1));
        assertEquals(0, match.gamesInCurrentSetForPlayer(player2));

        //4eme jeu 
        match.updateWithPointWonBy(player1); //15
        match.updateWithPointWonBy(player1); //30
        match.updateWithPointWonBy(player2); //15
        match.updateWithPointWonBy(player1); //40
        match.updateWithPointWonBy(player1); //W
        assertEquals(4, match.gamesInCurrentSetForPlayer(player1));
        assertEquals(0, match.gamesInCurrentSetForPlayer(player2));

        //5eme jeu 
        match.updateWithPointWonBy(player1); //15
        match.updateWithPointWonBy(player1); //30
        match.updateWithPointWonBy(player2); //15
        match.updateWithPointWonBy(player1); //40
        match.updateWithPointWonBy(player1); //W
        assertEquals(5, match.gamesInCurrentSetForPlayer(player1));
        assertEquals(0, match.gamesInCurrentSetForPlayer(player2));

        //6eme jeu 
        match.updateWithPointWonBy(player2); //15
        match.updateWithPointWonBy(player2); //30
        match.updateWithPointWonBy(player1); //15
        match.updateWithPointWonBy(player2); //40
        match.updateWithPointWonBy(player2); //W
        assertEquals(5, match.gamesInCurrentSetForPlayer(player1));
        assertEquals(1, match.gamesInCurrentSetForPlayer(player2));

        //7eme jeu 
        match.updateWithPointWonBy(player1); //15
        match.updateWithPointWonBy(player1); //30
        match.updateWithPointWonBy(player2); //15
        match.updateWithPointWonBy(player1); //40
        match.updateWithPointWonBy(player1); //W
        assertEquals(1+i, match.getNbSetsWin(player1));
        assertEquals(1, match.getNbSetsWin(player2));
        assertEquals(0, match.gamesInCurrentSetForPlayer(player1));
        assertEquals(0, match.gamesInCurrentSetForPlayer(player2));
    }

        assertTrue(match.isFinished());

    }

}
