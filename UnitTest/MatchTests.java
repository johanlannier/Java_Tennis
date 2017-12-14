import static org.junit.Assert.*;
import org.junit.*;

public class MatchTests {
    private Player player1;
    private Player player2;
    private TennisMatch match;

    @Before
    public void createMatch(){
        player1=new Player("Player1Name");
        player2=new Player("Player2Name");
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

        match.updateWithPointWonBy(player1);
        assertEquals("15", match.pointsForPlayer(player1));

        match.updateWithPointWonBy(player1);
        assertEquals("30", match.pointsForPlayer(player1));

        match.updateWithPointWonBy(player1);
        assertEquals("40", match.pointsForPlayer(player1));

        match.updateWithPointWonBy(player1);
        assertEquals("A", match.pointsForPlayer(player1));

        //Player2
        assertEquals("0", match.pointsForPlayer(player2));

        match.updateWithPointWonBy(player2);
        assertEquals("15", match.pointsForPlayer(player2));
    }

    @Test
    public void winGame(){
        //Player1
        assertEquals("0", match.pointsForPlayer(player1));

        match.updateWithPointWonBy(player1);
        assertEquals("15", match.pointsForPlayer(player1));

        match.updateWithPointWonBy(player1);
        assertEquals("30", match.pointsForPlayer(player1));

        match.updateWithPointWonBy(player1);
        assertEquals("40", match.pointsForPlayer(player1));

        match.updateWithPointWonBy(player1);
        assertEquals("A", match.pointsForPlayer(player1));

        match.updateWithPointWonBy(player1);
        assertEquals("0", match.pointsForPlayer(player1));

        assertEquals(1,match.gamesInCurrentSetForPlayer(player1));
        assertEquals(0,match.gamesInCurrentSetForPlayer(player2));
    }

    @Test
    public void AdvantageLost(){
        //Player1
        assertEquals("0", match.pointsForPlayer(player1));
        match.updateWithPointWonBy(player1);
        assertEquals("15", match.pointsForPlayer(player1));
        match.updateWithPointWonBy(player1);
        assertEquals("30", match.pointsForPlayer(player1));
        match.updateWithPointWonBy(player1);
        assertEquals("40", match.pointsForPlayer(player1));
        match.updateWithPointWonBy(player1);
        assertEquals("A", match.pointsForPlayer(player1));

        //Player2
        assertEquals("0", match.pointsForPlayer(player2));
        match.updateWithPointWonBy(player2);
        assertEquals("15", match.pointsForPlayer(player2));
        match.updateWithPointWonBy(player2);
        assertEquals("30", match.pointsForPlayer(player2));
        match.updateWithPointWonBy(player2);
        assertEquals("40", match.pointsForPlayer(player2));
        match.updateWithPointWonBy(player2);

        assertEquals("40",match.pointsForPlayer(player1));
        assertEquals("40",match.pointsForPlayer(player2));
    }
}
