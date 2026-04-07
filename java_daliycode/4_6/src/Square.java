public class Square {
    private Integer row = null;
    private Integer col = null;
    private Integer coulur = null;
    public Square(){
        row = new Integer(1);
        col = new Integer(1);
        coulur = new Integer(1);
    }
    public Square(int row, int col, int coulur){
        this.row = row;
        this.col = col;
        this.coulur = coulur;
    }
    public int getSquare(){
        return col.intValue() * row.intValue();
    }

    public void setCol(Integer col) {
        this.col = col;
    }
    public void setRow(Integer row){
        this.row = row;
    }
}
