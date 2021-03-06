package gui;

import static gui.ChessLikeGame.TILE_SIZE;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

/**
 *
 * @author Gogogo
 */
public class Piece extends StackPane {
    private PieceType type;
    private double oldX, oldY;
    
    public PieceType getType() {
        return type;
    }
    
    public double getOldX() {
        return oldX;
    }
    
    public double getOldY() {
        return oldY;
    }
    
    public Piece(PieceType type, int x, int y) {
        this.type = type;
        
        move(x, y);
        
         // load the image
        final Image imgBRook = new Image(ChessLikeGame.class.getResourceAsStream("BRook.png"));
        final Image imgBBishop = new Image(ChessLikeGame.class.getResourceAsStream("BBishop.png"));
        final Image imgBKnightL = new Image(ChessLikeGame.class.getResourceAsStream("BKnightL.png"));
        //final Image imgBKnightR = new Image(ChessLikeGame.class.getResourceAsStream("BKnightR.png"));
        final Image imgWRook = new Image(ChessLikeGame.class.getResourceAsStream("WRook.png"));
        final Image imgWBishop = new Image(ChessLikeGame.class.getResourceAsStream("WBishop.png"));
        final Image imgWKnightL = new Image(ChessLikeGame.class.getResourceAsStream("WKnightL.png"));
        //final Image imgWKnightR = new Image(ChessLikeGame.class.getResourceAsStream("WKnightR.png"));
 
         // resizes the image to have width of 100 while preserving the ratio and using
         // higher quality filtering method; this ImageView is also cached to
         // improve performance
         ImageView piece = new ImageView();
         if (type == PieceType.BROOK) {
        	 piece.setImage(imgBRook);
         } else if (type == PieceType.BBISHOP) {
        	 piece.setImage(imgBBishop);
         } else if (type == PieceType.BKNIGHT) {
        	 piece.setImage(imgBKnightL);
         } else if (type == PieceType.WROOK) {
        	 piece.setImage(imgWRook);
         } else if (type == PieceType.WBISHOP) {
        	 piece.setImage(imgWBishop);
         } else if (type == PieceType.WKNIGHT) {
        	 piece.setImage(imgWKnightL);
         }
         piece.setFitWidth(100);
         piece.setPreserveRatio(true);
         piece.setSmooth(true);
         piece.setCache(true);
         
         getChildren().add(piece);
    }
    
    public void move(int x, int y) {
        oldX = x * TILE_SIZE;
        oldY = y * TILE_SIZE;
        relocate(oldX, oldY);
    }
    
    public void abortMove() {
        relocate(oldX, oldY);
    }
}
