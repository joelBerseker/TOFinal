public class Player{
    public String name;
    public char symbol;
    public Player(String name){
        this.name   =   name;
    }
    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return "Player [name=" + name + ", symbol=" + symbol + "]";
    }

    
   
    
}