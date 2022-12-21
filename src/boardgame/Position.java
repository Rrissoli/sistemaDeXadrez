package boardgame;

public class Position {
    private Integer row;
    private Integer collumn;
    public Integer getRow() {
        return row;
    }
    public Integer getCollumn() {
        return collumn;
    }
    public Position(Integer row, Integer collumn) {
        this.row = row;
        this.collumn = collumn;
    }
    public Position() {
    }
    public void setValues(Integer row, Integer collumn){
        this.collumn = collumn;
        this.row = row;
    }
    @Override
    public String toString() {
        return row + ", " + collumn;
    }
    
}
