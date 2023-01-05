package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {
    private Board board;

    public ChessMatch() {
        this.board = new Board(8, 8);
        initialSetup();
    }
    public ChessPiece[][] getPieces(){
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getCollumns()];
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getCollumns(); j++) {
                mat[i][j] = (ChessPiece) board.piece(i,j);
            }
        }
        return mat;
    }
    public boolean[][] possibleMoves(ChessPosition sourcePosition){
        Position position = sourcePosition.toPosition();
        validateSoucePosition(position);
        return board.piece(position).possibleMoves();
    }
    public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targePosition){
        Position source = sourcePosition.toPosition();
        Position target = targePosition.toPosition();
        validateSoucePosition(source);
        validateTargetPosition(source, target);
        Piece capturedPiece = makeMove(source,target);
        return (ChessPiece)capturedPiece;

    }
    private void validateSoucePosition(Position position){
        if(!board.thereIsAPiece(position)){
            throw new ChessException("Not exist position on the board");

        }
        if(!board.piece(position).isThereAnyPossibleMove()){
            throw new ChessException("There is no possible move for the chosen piece");
        }
    }
    private void validateTargetPosition(Position source, Position target){
        if(!board.piece(source).possibleMove(target)){
            throw new ChessException("Not permission to move it for there");
        }
    }
    private Piece makeMove(Position source, Position target){
        Piece p = board.removePiece(source);
        Piece capturedPiece = board.removePiece(target);
        board.placePiece(p, target);
        return capturedPiece;
    }
    private void placeNewPiece(char collumn, int row, ChessPiece piece){
        board.placePiece(piece, new ChessPosition(collumn, row).toPosition());
    }
    private void initialSetup(){
            placeNewPiece('c', 1, new Rook(board, Color.WHITE));
            placeNewPiece('c', 2, new Rook(board, Color.WHITE));
            placeNewPiece('d', 2, new Rook(board, Color.WHITE));
            placeNewPiece('e', 2, new Rook(board, Color.WHITE));
            placeNewPiece('e', 1, new Rook(board, Color.WHITE));
            placeNewPiece('d', 1, new King(board, Color.WHITE));
    
            placeNewPiece('c', 7, new Rook(board, Color.BLACK));
            placeNewPiece('c', 8, new Rook(board, Color.BLACK));
            placeNewPiece('d', 7, new Rook(board, Color.BLACK));
            placeNewPiece('e', 7, new Rook(board, Color.BLACK));
            placeNewPiece('e', 8, new Rook(board, Color.BLACK));
            placeNewPiece('d', 8, new King(board, Color.BLACK));
    }
}

