package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

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
    
    protected boolean isThereOpponentPiece(Position position){
        ChessPiece p = (ChessPiece)getBoard().piece(position); 
        return p != null && p.getColor() != color;
    }
}

