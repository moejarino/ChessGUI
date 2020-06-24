package chessgui.pieces;

import chessgui.Board;

public class Pawn extends Piece {

    private boolean has_moved;
    
    public Pawn(int x, int y, boolean is_white, String file_path, Board board)
    {
        super(x,y,is_white,file_path, board);
        has_moved = false;
    }
    
    public void setHasMoved(boolean has_moved)
    {
        this.has_moved = has_moved;
    }
    
    public boolean getHasMoved()
    {
        return has_moved;
    }
    
    @Override
    public boolean canMove(int destination_x, int destination_y)
    {
        // A pawn may only move towards the oponent's side of the board.
        // If the pawn has not moved yet in the game, for its first move it can 
        // move two spaces forward. Otherwise, it may only move one space. 
        // When not attacking it may only move straight ahead.
        // When attacking it may only move space diagonally forward

        Piece potentialPiece = board.getPiece(destination_x, destination_y);
        
        // If there is a piece there
        if(potentialPiece != null){
            
            // Are they both white?
            if(potentialPiece.isWhite() && this.isWhite()) {
                return false;
            }
            // Are they both black?
            if(potentialPiece.isBlack() && this.isBlack()) {
                return false;
            }
        }
        
        // Prevents a pawn from moving backwards
        if(this.isWhite()){
            if(this.getY() > destination_y){
                return false;
            }
        }else{
            if(destination_y > this.getY()){
                return false;
            }
        }
        
        // This is for every case where a pawn is not taking a piece, moving straight
        if (destination_x == this.getX()) {

            if (potentialPiece != null) {
                return false;              
            }

            if (Math.abs(this.getY() - destination_y) > 2) {
                return false;
            } else if (Math.abs(destination_y - this.getY()) == 2) {
                //Advancing two spaces at beginning
                if (has_moved) {                
                    return false;                 
                }
            }
        } else {
            //Taking a piece
            if(Math.abs(destination_x - this.getX()) != 1 || Math.abs(destination_y - this.getY()) != 1){
                return false;
            }
            
            if (potentialPiece == null) {
                return false;
            }
        }
                
                
        return true;
    }
}
