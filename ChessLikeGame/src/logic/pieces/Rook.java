package logic.pieces;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import logic.board.Board;
import logic.board.BoardUtil;
import logic.board.Move;
import logic.board.Tile;
import logic.board.Move.Attack;
import logic.board.Move.NormalMove;

public class Rook extends Piece {
	final int[] ROOK_VALIDMOVE_LOC = {-1, -2, -6, -12, 1, 2, 6, 12};

	public Rook(int piecePos, Colour pieceColour) {
		super(piecePos, pieceColour);
		
	}


	@Override
	public Collection<Move> calcLegalMoves(final Board board) {
		final List<Move> legalMoves = new ArrayList<>();
		int destinationLocation;
		for (final int chosenLocation : ROOK_VALIDMOVE_LOC) { // chosenLocation is the location the player has chosen to move into
			// the current position + the new position that has been chosen =
			// the destination location
			destinationLocation = this.piecePos + chosenLocation;
			if (BoardUtil.isValidTileCoordinate(destinationLocation)) {
				if (isFirstColExcl(this.piecePos, chosenLocation)
						|| isSecondColExcl(this.piecePos, chosenLocation)
						|| isFifthColExcl(this.piecePos, chosenLocation)
						|| isSixthColExcl(this.piecePos, chosenLocation)) {
					continue; // to skip though these invalid movements
				}

				final Tile chosenDestinationTile = board.getTile(destinationLocation);
				// check to see if the tile is already occupied
				if (!chosenDestinationTile.isTileFull()) {
					//if the tile is empty, move normally
					legalMoves.add(new NormalMove(board, this, destinationLocation));
				} else {
					final Piece pieceAtDestination = chosenDestinationTile.getPiece();
					final Colour pieceColour = pieceAtDestination.getPieceColour();
					if (this.pieceColour != pieceColour) {
						// if the tile is full and the opponent piece is in it, attack and take it
						legalMoves.add(new Attack(board, this, destinationLocation, pieceAtDestination));
					}
				}
			}
		}

		return Collections.unmodifiableList(legalMoves);
	}
	
	
	// if the rook is in the first column, re check its invalid moves(stating the exceptions)
	private static boolean isFirstColExcl(final int currentPos, final int offSetPos) {
		return BoardUtil.FIRST_COL(currentPos) && ((offSetPos == -1) || (offSetPos == -2));
	}

	private static boolean isSecondColExcl(final int currentPos, final int offSetPos) {
		return BoardUtil.SECOND_COL(currentPos) && (offSetPos == -2);
	}

	private static boolean isFifthColExcl(final int currentPos, final int offSetPos) {
		return BoardUtil.FIFTH_COL(currentPos) && (offSetPos == 2);
	}

	private static boolean isSixthColExcl(final int currentPos, final int offSetPos) {
		return BoardUtil.SIXTH_COL(currentPos) && ((offSetPos == 1) || (offSetPos == 2));
	}
	
	@Override
	public String toString(){
		return PieceName.ROOK.toString();
	}


}
