import java.util.HashMap;

/*
NOTE:
Piece + Color = PC

1 = Pawn
2 = Rook
3 = Knight
4 = Bishop
5 = Queen
6 = King

0 = White
1 = Black
*/

public class GameState {
    
    public static HashMap<Integer, Integer> coordinatePlane = new HashMap<Integer, Integer>();
    
    public GameState() {}
    
    public void putInMap(int xy, int piece) {
        coordinatePlane.put(xy, piece);
    }
    
    public int checkPiece(int x, int y) {
        int result = coordinatePlane.get((x*10)+y);
        return result;
    }
}
