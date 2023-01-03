package chess;

import boardgame.Position;

public class ChessPosition {
    private char collumn;
    private int row;
    public ChessPosition(char collumn, int row) {
        if(collumn < 'a' || collumn > 'h' || row < 1 || row > 8){
            throw new ChessException("Error instanting  ChessPosition.");
        }
        this.collumn = collumn;
        this.row = row;
    }
    public char getCollumn() {
        return collumn;
    }
    public int getRow() {
        return row;
    }
    protected Position toPosition(){
        int math_row = 8 - this.row;
        int math_collumn = this.collumn - 'a';
        return new Position(math_row,math_collumn);
    } 
    protected static ChessPosition fromPosition(Position position){
        int math_row = position.getRow() + 8;
        char math_collumn = ((char)(position.getCollumn() - 'a'));
        return new ChessPosition(math_collumn, math_row);
    }
    @Override
    public String toString(){
        return "" + collumn + row;
    }
}
