package gui;

/**
 *
 * @author Gogogo
 */
public enum PieceType {
    BROOK(-1), BBISHOP(-2), BKNIGHT(-3), WROOK(1), WBISHOP(2), WKNIGHT(3);
    
    final int moveDir;
    
    PieceType(int moveDir) {
        this.moveDir = moveDir;
    }
}