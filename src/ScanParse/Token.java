package ScanParse;

public class Token {
    
    String lexeme;
    String tokenClass;
    int line;

    public Token(String lexeme, int line) {
        this.lexeme = lexeme;
        this.line = line;
        this.tokenClass = "Invalid Token";
    }

    public String getLexeme() {
        return lexeme;
    }

    public void setLexeme(String lexeme) {
        this.lexeme = lexeme;
    }

    public String getTokenClass() {
        return tokenClass;
    }

    public void setTokenClass(String tokenClass) {
        this.tokenClass = tokenClass;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }
    
    
    
    
}
