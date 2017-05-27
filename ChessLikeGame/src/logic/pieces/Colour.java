package logic.pieces;

public enum Colour {
    WHITE() {

        @Override
        public boolean isWhite() {
            return true;
        }

        @Override
        public boolean isBlack() {
            return false;
        }
    },
    BLACK() {

        @Override
        public boolean isWhite() {
            return false;
        }

        @Override
        public boolean isBlack() {
            return true;
        }
    };

	public boolean isWhite() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isBlack() {
		// TODO Auto-generated method stub
		return false;
	}

	
}	 