package chessgui.pieces;

import chessgui.Board;

public class Queen extends Piece {

    public Queen(int x, int y, boolean is_white, String file_path, Board board)
    {
        super(x,y,is_white,file_path, board);
    }
    
    @Override
    public boolean canMove(int destination_x, int destination_y)
    {
        // Queen can move as many squares as she wants forward, 
        // backward, sideways, or diagonally, without jumping over any pieces.
        
        // We check the square we want to move to and see if there is
        // a piece occupying it. We then initialize a Piece object
        
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
        
        // Check if queen is attempting to diagonally
        if (Math.abs(this.getY() - destination_y) !=  Math.abs(destination_x - this.getX()) &&
                this.getX() != destination_x && this.getY() != destination_y) {
            
            return false;
        }
        
        
        String direction = "";
                
        if (destination_y > this.getY()) {
            direction = "south";
        }
        
        if (destination_y < this.getY()) {
            direction = "north";
        }
        
        if (destination_x > this.getX()) {
            direction = "east";
        }
        
        if (destination_x < this.getX()) {
            direction = "west";
        }
        
        // y increasing, x decreasing
        // && destination_y - this.getY() == this.getX() - destination_x
        if (destination_y > this.getY() && destination_x < this.getX()) {
            direction = "southwest";
        }
        
        // y increasing, x increasing
        //&& destination_y - this.getY() == destination_x - this.getX()
        if (destination_y > this.getY() && destination_x > this.getX()) {
            direction = "southeast";
        }
        
        // y decreasing, x decreasing
        // && this.getY() - destination_y  == this.getX() - destination_x
        if (destination_y < this.getY() && destination_x < this.getX()) {
            direction = "northwest";
        }
        
        // y decreasing, x increasing
        // && this.getY() - destination_y  == destination_x - this.getX()
        if (destination_y < this.getY() && destination_x > this.getX()) {
            direction = "northeast";
        }
        
        //Are there pieces in the way of making this move
        switch (direction) {
            case "south":
                int spaces_to_move_s = Math.abs(destination_y - this.getY());
                for (int i = 1; i < spaces_to_move_s; i++) {
                    Piece p = board.getPiece(this.getX(), this.getY() + i);
                    if (p != null) {
                        return false;
                    }
                }
                break;
            case "north":
                int spaces_to_move_n = Math.abs(destination_y - this.getY());
                for (int i = 1; i < spaces_to_move_n; i++) {
                    Piece p = board.getPiece(this.getX(), this.getY() - i);
                    if (p != null) {
                        return false;
                    }
                }
                break;
            case "east":
                int spaces_to_move_e = Math.abs(destination_x - this.getX());
                for (int i = 1; i < spaces_to_move_e; i++) {
                    Piece p = board.getPiece(this.getX() + i, this.getY());
                    if (p != null) {
                        return false;
                    }
                }
                break;
            case "west":
                int spaces_to_move_w = Math.abs(destination_x - this.getX());
                for (int i = 1; i < spaces_to_move_w; i++) {
                    Piece p = board.getPiece(this.getX() - i, this.getY());
                    if (p != null) {
                        return false;
                    }
                }
                break;
            case "southwest":
                int spaces_to_move_sw = Math.abs(destination_x - this.getX());
                for (int i = 1; i < spaces_to_move_sw; i++) {
                    Piece p = board.getPiece(this.getX() - i, this.getY() + i);
                    if (p != null) {
                        return false;
                    }
                }
                break;
            case "southeast":
                int spaces_to_move_se = Math.abs(destination_x - this.getX());
                for (int i = 1; i < spaces_to_move_se; i++) {
                    Piece p = board.getPiece(this.getX() + i, this.getY() + i);
                    if (p != null) {
                        return false;
                    }
                }
                break;
            case "northwest":
                int spaces_to_move_nw = Math.abs(destination_x - this.getX());
                for (int i = 1; i < spaces_to_move_nw; i++) {
                    Piece p = board.getPiece(this.getX() - i, this.getY() - i);
                    if (p != null) {
                        return false;
                    }
                }
                break;
            case "northeast":
                int spaces_to_move_ne = Math.abs(destination_x - this.getX());
                for (int i = 1; i < spaces_to_move_ne; i++) {
                    Piece p = board.getPiece(this.getX() + i, this.getY() - i);
                    if (p != null) {
                        return false;
                    }
                }
                break;
        }
        
        
        

        
        return true;
    }
}
