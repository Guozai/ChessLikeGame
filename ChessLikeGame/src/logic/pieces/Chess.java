package logic.pieces;

import java.util.Collection;

import logic.board.Board;
import logic.board.Move;

public class Chess {

	public static void main(String[] args) {
		Board board = Board.initialChessBoard();
		System.out.println(board);
		
	/*
		 0 1 2 3 4 5
		|x|x|x|x|x|x|
		|v|v|R|v|v| |
		| | |v| | | |
		| | |v| | | |
		| | | | | | |
		|o|o|o|o|o|o|
	     303132333435	
	*/
		
		Rook knight = new Rook(6, Colour.BLACK);
		Collection<Move> moves = knight.calcLegalMoves(board);
		System.out.println(moves.size());
		
	}

}
