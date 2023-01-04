package chess;

import boardgame.Board;
import boardgame.Piece;

public abstract class ChessPiece extends Piece {
    protected Color color;
    protected Integer moveCount;

    public ChessPiece(Board board, Color color, Integer moveCount) {
        super(board);
        this.color = color;
        this.moveCount = moveCount;
    }
    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
       
    }
    public Color getColor() {
        return color;
    }
    
    
}
