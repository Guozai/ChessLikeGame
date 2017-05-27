package logic.pieces;

import java.util.Collection;

import logic.board.Board;
import logic.board.Move;

public abstract class Piece {
	protected final int piecePos;
	protected final Colour pieceColour;
	
	protected Piece(final int piecePos, final Colour pieceColour) {
		this.piecePos = piecePos;
		this.pieceColour = pieceColour;
	}
	
	public Colour getPieceColour(){
		return this.pieceColour;
	}

	public abstract Collection<Move> calcLegalMoves(final Board board);

	public int getPiecePos() {
		return piecePos;
	}
	
	public enum PieceName{
		
		KNIGHT("K"),
		ROOK("R"),
		BISHOP("B");
		
		String pieceName;
		
		PieceName(String pieceName){
			this.pieceName = pieceName;
		}
		
		@Override
		public String toString(){
			return this.pieceName;
			
		}
	}

}