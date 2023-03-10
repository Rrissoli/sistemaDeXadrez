package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

	private ChessMatch chessMatch;
	
	public King(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
	}

	@Override
	public String toString() {
		return "K";
	}

	private boolean canMove(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		return p == null || p.getColor() != getColor();
	}
	
	private boolean testRookCastling(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		return p != null && p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0;
	}
	
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getCollumns()];
		
		Position p = new Position(0, 0);
		
		// above
		p.setValues(position.getRow() - 1, position.getCollumn());
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getCollumn()] = true;
		}

		// below
		p.setValues(position.getRow() + 1, position.getCollumn());
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getCollumn()] = true;
		}

		// left
		p.setValues(position.getRow(), position.getCollumn() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getCollumn()] = true;
		}

		// right
		p.setValues(position.getRow(), position.getCollumn() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getCollumn()] = true;
		}

		// nw
		p.setValues(position.getRow() - 1, position.getCollumn() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getCollumn()] = true;
		}

		// ne
		p.setValues(position.getRow() - 1, position.getCollumn() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getCollumn()] = true;
		}

		// sw
		p.setValues(position.getRow() + 1, position.getCollumn() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getCollumn()] = true;
		}
		
		// se
		p.setValues(position.getRow() + 1, position.getCollumn() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			mat[p.getRow()][p.getCollumn()] = true;
		}

		
		
		return mat;
	}
}