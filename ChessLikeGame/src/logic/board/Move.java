package logic.board;

import logic.pieces.Piece;

public class Move {
	final Board board;
	final Piece movedP;
	final int destCoordinate;
	
	public int getDestCoordinate() {
		return destCoordinate;
	}

	public Move(final Board board, final Piece movedP, final int destCoordinate ){
		this.board = board;
		this.movedP = movedP;
		this.destCoordinate = destCoordinate;
	}
	
	
public static final class NormalMove extends Move{

	public NormalMove(final Board board,final Piece movedP,final int destCoordinate) {
		super(board, movedP, destCoordinate);
		// TODO Auto-generated constructor stub
	
	}
	
	
}

public static final class Attack extends Move{
	final Piece attackedP;
	public Attack(final Board board,final Piece movedP,final int destCoordinate, final Piece attackedP) {
		super(board, movedP, destCoordinate);
		this.attackedP = attackedP;
		
	}
	
}
	
	

}
