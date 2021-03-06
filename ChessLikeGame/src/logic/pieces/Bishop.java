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

public class Bishop extends Piece {
	// an array of valid moves for bishop
	final int[] BISHOP_VALIDMOVE_LOC = {-5, -7, -10, -14, 5, 7, 10, 14};
	static final int PIECE_IN_UPPER_LEFT_TILE_IN_THE_WAY = -7;
	static final int PIECE_IN_UPPER_RIGHT_TILE_IN_THE_WAY = -5;
	static final int PIECE_IN_LOWER_LEFT_TILE_IN_THE_WAY = 5;
	static final int PIECE_IN_LOWER_RIGHT_TILE_IN_THE_WAY = 7;
	
	public Bishop(int piecePos, Colour pieceColour) {
		super(piecePos, pieceColour);
		
	}

	@Override
	public Collection<Move> calcLegalMoves(final Board board) {
		final List<Move> legalMoves = new ArrayList<>();
		int destinationLocation;
		for (final int chosenLocation : BISHOP_VALIDMOVE_LOC) { // chosenLocation is the location the player has chosen to move into
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
					// if it is not the game start initialization
					if (destinationLocation != piecePos) {
						// if there is a place on the path between the destination and the original position
						if (destinationLocation - piecePos == 2 * PIECE_IN_UPPER_LEFT_TILE_IN_THE_WAY) {
							// if there is a piece on the way
							final Tile checkTile = board.getTile(piecePos + PIECE_IN_UPPER_LEFT_TILE_IN_THE_WAY);
							if (!checkTile.isTileFull()) {
								legalMoves.add(new NormalMove(board, this, destinationLocation));
							}
						} else if (destinationLocation - piecePos == 2 * PIECE_IN_UPPER_RIGHT_TILE_IN_THE_WAY) {
							final Tile checkTile = board.getTile(piecePos + PIECE_IN_UPPER_RIGHT_TILE_IN_THE_WAY);
							if (!checkTile.isTileFull()) {
								legalMoves.add(new NormalMove(board, this, destinationLocation));
							}
						} else if (destinationLocation - piecePos == 2 * PIECE_IN_LOWER_LEFT_TILE_IN_THE_WAY) {
							final Tile checkTile = board.getTile(piecePos + PIECE_IN_LOWER_LEFT_TILE_IN_THE_WAY);
							if (!checkTile.isTileFull()) {
								legalMoves.add(new NormalMove(board, this, destinationLocation));
							}
						} else if (destinationLocation - piecePos == 2 * PIECE_IN_LOWER_RIGHT_TILE_IN_THE_WAY) {
							final Tile checkTile = board.getTile(piecePos + PIECE_IN_LOWER_RIGHT_TILE_IN_THE_WAY);
							if (!checkTile.isTileFull()) {
								legalMoves.add(new NormalMove(board, this, destinationLocation));
							}
						} else {
							legalMoves.add(new NormalMove(board, this, destinationLocation));
						}
					}
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
	
	
	// if the bishop is in the first column, re check its invalid moves
	private static boolean isFirstColExcl(final int currentPos, final int offSetPos) {
		return BoardUtil.FIRST_COL(currentPos) && ((offSetPos == -7) || (offSetPos == -14) || (offSetPos == 5)
				|| (offSetPos == 10));
	}

	private static boolean isSecondColExcl(final int currentPos, final int offSetPos) {
		return BoardUtil.SECOND_COL(currentPos) && ((offSetPos == -14) || (offSetPos == 10));
	}

	private static boolean isFifthColExcl(final int currentPos, final int offSetPos) {
		return BoardUtil.FIFTH_COL(currentPos) && ((offSetPos == -10) || (offSetPos == 14));
	}

	private static boolean isSixthColExcl(final int currentPos, final int offSetPos) {
		return BoardUtil.SIXTH_COL(currentPos) && ((offSetPos == 7) || (offSetPos == 14) || (offSetPos == -5)
				|| (offSetPos == -10));
	}
	
	@Override
	public String toString(){
		return PieceName.BISHOP.toString();
	}
	

}
