package chessgui.pieces;

import chessgui.Board;

public class King extends Piece {

    public King(int x, int y, boolean is_white, String file_path, Board board)
    {
        super(x,y,is_white,file_path, board);
    }
    
    @Override
    public boolean canMove(int destination_x, int destination_y)
    {
        // A king can move one square up, right, left, or down, or
        // diagonally, but he can never put himself in danger of an oposing 
        // piece attacking him on the next turn. He cannot attack his own pieces.
        
        Piece potentialPiece = board.getPiece(destination_x, destination_y);
        
        // If there is a piece there
        if(potentialPiece != null) {
            
            // Are they both white?
            if(potentialPiece.isWhite() && this.isWhite()) {
                return false;
            }
            // Are they both black?
            if(potentialPiece.isBlack() && this.isBlack()) {
                return false;
            }
        }
        
        
        
        if(Math.abs(destination_y - this.getY()) > 1 || Math.abs(destination_x - this.getX()) > 1) {
            return false;
        }


        
        return true;
    }
}
