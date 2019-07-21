package ScanParse;

import java.util.ArrayList;


public class Parser {
    ArrayList<Token> tokens = new ArrayList<>();
    boolean parsed = true;
    String error;
    public Parser(ArrayList<Token> t) {
        tokens = t;
        tokens.add(new Token("EOF",0));
        error = "Error in line " +tokens.get(0).getLine() + ".";
        Program();
    }
    
    public void Program()
    {
        if(tokens.get(0).getLexeme().equals("class"))
            MainClass();
        else{
            parsed = false;
            error = "Error in line " +tokens.get(0).getLine() + " expected "+"\'class\'"+" found \'"+tokens.get(0).getLexeme()+"\'";
            return;
        }
        while(tokens.get(0).getLexeme().equals("class"))
            ClassDeclaration();
        if(tokens.size() != 1)
        {
            parsed = false;
            error = "Error in line " +tokens.get(0).getLine() + " expected "+"\'class\'"+" found \'"+tokens.get(0).getLexeme()+"\'";
            return;
        }
            
    }
    public void MainClass()
    {
        if(tokens.get(0).getLexeme().equals("class"))
            tokens.remove(0);
        else{
            parsed = false;
            error = "Error in line " +tokens.get(0).getLine() + " expected "+"\'class\'"+" found \'"+tokens.get(0).getLexeme()+"\'";
            return;
        }
        if(tokens.get(0).getTokenClass().equals("Identifier"))
            tokens.remove(0);
        else{
            parsed = false;
            error = "Error in line " +tokens.get(0).getLine() + " expected "+"an identifier"+" found \'"+tokens.get(0).getLexeme()+"\'";
            return;
        }
        if(tokens.get(0).getLexeme().equals("{"))
            tokens.remove(0);
        else{
            parsed = false;
            error = "Error in line " +tokens.get(0).getLine() + " expected "+"\'{\'"+" found \'"+tokens.get(0).getLexeme()+"\'";
            return;
        }
        if(tokens.get(0).getLexeme().equals("public"))
            tokens.remove(0);
        else{
            parsed = false;
            error = "Error in line " +tokens.get(0).getLine() + " expected "+"\'public\'"+" found \'"+tokens.get(0).getLexeme()+"\'";
            return;
        }
        if(tokens.get(0).getLexeme().equals("static"))
            tokens.remove(0);
        else{
            parsed = false;
            error = "Error in line " +tokens.get(0).getLine() + " expected "+"\'static\'"+" found \'"+tokens.get(0).getLexeme()+"\'";
            return;
        }
        if(tokens.get(0).getLexeme().equals("void"))
            tokens.remove(0);
        else{
            parsed = false;
            error = "Error in line " +tokens.get(0).getLine() + " expected "+"\'void\'"+" found \'"+tokens.get(0).getLexeme()+"\'";
            return;
        }
        if(tokens.get(0).getLexeme().equals("main"))
            tokens.remove(0);
        else{
            parsed = false;
            error = "Error in line " +tokens.get(0).getLine() + " expected "+"\'main\'"+" found \'"+tokens.get(0).getLexeme()+"\'";
            return;
        }
        if(tokens.get(0).getLexeme().equals("("))
            tokens.remove(0);
        else{
            parsed = false;
            error = "Error in line " +tokens.get(0).getLine() + " expected "+"\'(\'"+" found \'"+tokens.get(0).getLexeme()+"\'";
            return;
        }
        if(tokens.get(0).getLexeme().equals("String"))
            tokens.remove(0);
        else{
            parsed = false;
            error = "Error in line " +tokens.get(0).getLine() + " expected "+"\'String\'"+" found \'"+tokens.get(0).getLexeme()+"\'";
            return;
        }
        if(tokens.get(0).getLexeme().equals("["))
            tokens.remove(0);
        else{
            parsed = false;
            error = "Error in line " +tokens.get(0).getLine() + " expected "+"\'[\'"+" found \'"+tokens.get(0).getLexeme()+"\'";
            return;
        }
        if(tokens.get(0).getLexeme().equals("]"))
            tokens.remove(0);
        else{
            parsed = false;
            error = "Error in line " +tokens.get(0).getLine() + " expected "+"\']\'"+" found \'"+tokens.get(0).getLexeme()+"\'";
            return;
        }
        if(tokens.get(0).getTokenClass().equals("Identifier"))
            tokens.remove(0);
        else{
            parsed = false;
            error = "Error in line " +tokens.get(0).getLine() + " expected "+"an identifier"+" found \'"+tokens.get(0).getLexeme()+"\'";
            return;
        }
        if(tokens.get(0).getLexeme().equals(")"))
            tokens.remove(0);
        else{
            parsed = false;
            error = "Error in line " +tokens.get(0).getLine() + " expected "+"\')\'"+" found \'"+tokens.get(0).getLexeme()+"\'";
            return;
        }
        if(tokens.get(0).getLexeme().equals("{"))
            tokens.remove(0);
        else{
            parsed = false;
            error = "Error in line " +tokens.get(0).getLine() + " expected "+"\'{\'"+" found \'"+tokens.get(0).getLexeme()+"\'";
            return;
        }
        if(tokens.get(0).getLexeme().equals("{") || tokens.get(0).getLexeme().equals("if") || tokens.get(0).getLexeme().equals("while")
           || tokens.get(0).getLexeme().equals("System") || tokens.get(0).getTokenClass().equals("Identifier"))
            Statement();
        else{
            parsed = false;
            return;
        }
        if(tokens.get(0).getLexeme().equals("}"))
            tokens.remove(0);
        else{
            parsed = false;
            error = "Error in line " +tokens.get(0).getLine() + " expected "+"\'}\'"+" found \'"+tokens.get(0).getLexeme()+"\'";
            return;
        }
        if(tokens.get(0).getLexeme().equals("}"))
            tokens.remove(0);
        else{
            parsed = false;
            error = "Error in line " +tokens.get(0).getLine() + " expected "+"\'}\'"+" found \'"+tokens.get(0).getLexeme()+"\'";
            return;
        }
        
    }
    public void ClassDeclaration()
    {
        if(tokens.get(0).getLexeme().equals("class"))
            tokens.remove(0);
        else{
            parsed = false;
            error = "Error in line " +tokens.get(0).getLine() + " expected "+"\'class\'"+" found \'"+tokens.get(0).getLexeme()+"\'";
            return;
        }
        if(tokens.get(0).getTokenClass().equals("Identifier"))
            tokens.remove(0);
        else{
            parsed = false;
            error = "Error in line " +tokens.get(0).getLine() + " expected "+"an identifier"+" found \'"+tokens.get(0).getLexeme()+"\'";
            return;
        }
        if(tokens.get(0).getLexeme().equals("extends"))
        {
            tokens.remove(0);
            if(tokens.get(0).getTokenClass().equals("Identifier"))
                tokens.remove(0);
            else{
                parsed = false;
                error = "Error in line " +tokens.get(0).getLine() + " expected "+"an identifier"+" found \'"+tokens.get(0).getLexeme()+"\'";
                return;
            }
        }
        if(tokens.get(0).getLexeme().equals("{"))
            tokens.remove(0);
        else{
            parsed = false;
            error = "Error in line " +tokens.get(0).getLine() + " expected "+"\'{\'"+" found \'"+tokens.get(0).getLexeme()+"\'";
            return;
        }
        while(tokens.get(0).getLexeme().equals("int") || tokens.get(0).getLexeme().equals("boolean") ||
                tokens.get(0).getTokenClass().equals("Identifier"))
            VarDeclaration();
        while(tokens.get(0).getLexeme().equals("public"))
            MethodDeclaration();
        if(tokens.get(0).getLexeme().equals("}"))
            tokens.remove(0);
        else{
            parsed = false;
            error = "Error in line " +tokens.get(0).getLine() + " expected "+"\'}\'"+" found \'"+tokens.get(0).getLexeme()+"\'";
            return;
        }
    }
    public void VarDeclaration()
    {
        if(tokens.get(0).getLexeme().equals("int") || tokens.get(0).getLexeme().equals("boolean") ||
           tokens.get(0).getTokenClass().equals("Identifier"))
            Type();
        else{
            parsed = false;
            return;
        }
        if(tokens.get(0).getTokenClass().equals("Identifier"))
                tokens.remove(0);
        else{
            parsed = false;
            error = "Error in line " +tokens.get(0).getLine() + " expected "+"an identifier"+" found \'"+tokens.get(0).getLexeme()+"\'";
            return;
        }
        if(tokens.get(0).getLexeme().equals(";"))
            tokens.remove(0);
        else{
            parsed = false;
            error = "Error in line " +tokens.get(0).getLine() + " expected "+"\';\'"+" found \'"+tokens.get(0).getLexeme()+"\'";
            return;
        }
    }
    public void MethodDeclaration()
    {
        if(tokens.get(0).getLexeme().equals("public"))
            tokens.remove(0);
        else{
            parsed = false;
            error = "Error in line " +tokens.get(0).getLine() + " expected "+"\'public\'"+" found \'"+tokens.get(0).getLexeme()+"\'";
            return;
        }
        Type();
        if(tokens.get(0).getTokenClass().equals("Identifier"))
                tokens.remove(0);
        else{
            parsed = false;
            error = "Error in line " +tokens.get(0).getLine() + " expected "+"an identifier"+" found \'"+tokens.get(0).getLexeme()+"\'";
            return;
        }
        if(tokens.get(0).getLexeme().equals("("))
            tokens.remove(0);
        else{
            parsed = false;
            error = "Error in line " +tokens.get(0).getLine() + " expected "+"\'(\'"+" found \'"+tokens.get(0).getLexeme()+"\'";
            return;
        }
        if(tokens.get(0).getLexeme().equals("int") || tokens.get(0).getLexeme().equals("boolean") ||
           tokens.get(0).getTokenClass().equals("Identifier"))
        {
            Type();
            if(tokens.get(0).getTokenClass().equals("Identifier"))
                tokens.remove(0);
            else{
                parsed = false;
                error = "Error in line " +tokens.get(0).getLine() + " expected "+"an identifier"+" found \'"+tokens.get(0).getLexeme()+"\'";
                return;
            }
            while(tokens.get(0).getLexeme().equals(","))
            {
                tokens.remove(0);
                if(tokens.get(0).getLexeme().equals("int") || tokens.get(0).getLexeme().equals("boolean") ||
                    tokens.get(0).getTokenClass().equals("Identifier"))
                    Type();
                else{
                    parsed = false;
                    return;
                }
                if(tokens.get(0).getTokenClass().equals("Identifier"))
                tokens.remove(0);
                else{
                    parsed = false;
                    error = "Error in line " +tokens.get(0).getLine() + " expected "+"an identifier"+" found \'"+tokens.get(0).getLexeme()+"\'";
                    return;
                }
            }
        }
        if(tokens.get(0).getLexeme().equals(")"))
            tokens.remove(0);
        else{
            parsed = false;
            error = "Error in line " +tokens.get(0).getLine() + " expected "+"\')\'"+" found \'"+tokens.get(0).getLexeme()+"\'";
            return;
        }
        if(tokens.get(0).getLexeme().equals("{"))
            tokens.remove(0);
        else{
            parsed = false;
            error = "Error in line " +tokens.get(0).getLine() + " expected "+"\'{\'"+" found \'"+tokens.get(0).getLexeme()+"\'";
            return;
        }
        while(tokens.get(0).getLexeme().equals("int") || tokens.get(0).getLexeme().equals("boolean") ||
                tokens.get(0).getTokenClass().equals("Identifier"))
        {
            if(tokens.get(1).getLexeme().equals("="))
                Statement();
            else
                VarDeclaration();
        }
        while(tokens.get(0).getLexeme().equals("{") || tokens.get(0).getLexeme().equals("if") || tokens.get(0).getLexeme().equals("while")
           || tokens.get(0).getLexeme().equals("System") || tokens.get(0).getTokenClass().equals("Identifier"))
            Statement();
        if(tokens.get(0).getLexeme().equals("return"))
            tokens.remove(0);
        else{
            parsed = false;
            error = "Error in line " +tokens.get(0).getLine() + " expected "+"\'return\'"+" found \'"+tokens.get(0).getLexeme()+"\'";
            return;
        }
        if(tokens.get(0).getLexeme().equals("true") || tokens.get(0).getLexeme().equals("false") || tokens.get(0).getLexeme().equals("this") || 
           tokens.get(0).getLexeme().equals("new") || tokens.get(0).getLexeme().equals("!") || tokens.get(0).getLexeme().equals("(") || 
           tokens.get(0).getTokenClass().equals("Identifier") || tokens.get(0).getTokenClass().equals("Integer literal"))
            Expression();
        else{
            parsed = false;
            return;
        }
        if(tokens.get(0).getLexeme().equals(";"))
            tokens.remove(0);
        else{
            parsed = false;
            error = "Error in line " +tokens.get(0).getLine() + " expected "+"\';\'"+" found \'"+tokens.get(0).getLexeme()+"\'";
            return;
        }
        if(tokens.get(0).getLexeme().equals("}"))
            tokens.remove(0);
        else{
            parsed = false;
            error = "Error in line " +tokens.get(0).getLine() + " expected "+"\'}\'"+" found \'"+tokens.get(0).getLexeme()+"\'";
            return;
        }
        
    }
    public void Type()
    {
        if(tokens.get(0).getLexeme().equals("int"))
        {
            tokens.remove(0);
            if(tokens.get(0).getLexeme().equals("["))
            {
                tokens.remove(0);
                if(tokens.get(0).getLexeme().equals("]"))
                    tokens.remove(0);
                else{
                    parsed = false;
                    error = "Error in line " +tokens.get(0).getLine() + " expected "+"\']\'"+" found \'"+tokens.get(0).getLexeme()+"\'";
                    return;
                }
            }
        }
        else if(tokens.get(0).getLexeme().equals("boolean"))
            tokens.remove(0);
        else if(tokens.get(0).getTokenClass().equals("Identifier"))
            tokens.remove(0);
        else{
            parsed = false;
            error = "Error in line " +tokens.get(0).getLine() + " expected "+"a data type or an identifier"+" found \'"+tokens.get(0).getLexeme()+"\'";
            return;
        }
    }
    public void Statement()
    {
        if(tokens.get(0).getLexeme().equals("{"))
        {
            tokens.remove(0);
            if(tokens.get(0).getLexeme().equals("{") || tokens.get(0).getLexeme().equals("if") || tokens.get(0).getLexeme().equals("while")
            || tokens.get(0).getLexeme().equals("System") || tokens.get(0).getTokenClass().equals("Identifier"))
                Statement();
        }
        if(tokens.get(0).getLexeme().equals("if"))
        {
            tokens.remove(0);
            if(tokens.get(0).getLexeme().equals("("))
                tokens.remove(0);
            else{
                parsed = false;
                error = "Error in line " +tokens.get(0).getLine() + " expected "+"\'(\'"+" found \'"+tokens.get(0).getLexeme()+"\'";
                return;
            }
            if(tokens.get(0).getLexeme().equals("true") || tokens.get(0).getLexeme().equals("false") || tokens.get(0).getLexeme().equals("this") || 
                tokens.get(0).getLexeme().equals("new") || tokens.get(0).getLexeme().equals("!") || tokens.get(0).getLexeme().equals("(") || 
                tokens.get(0).getTokenClass().equals("Identifier") || tokens.get(0).getTokenClass().equals("Integer literal"))
                Expression();
            else{
                parsed = false;
                return;
            }
            if(tokens.get(0).getLexeme().equals(")"))
                tokens.remove(0);
            else{
                parsed = false;
                error = "Error in line " +tokens.get(0).getLine() + " expected "+"\')\'"+" found \'"+tokens.get(0).getLexeme()+"\'";
                return;
            }
            if(tokens.get(0).getLexeme().equals("{") || tokens.get(0).getLexeme().equals("if") || tokens.get(0).getLexeme().equals("while")
            || tokens.get(0).getLexeme().equals("System") || tokens.get(0).getTokenClass().equals("Identifier"))
                Statement();
            if(tokens.get(0).getLexeme().equals("else"))
                tokens.remove(0);
            else{
                parsed = false;
                return;
            }
            if(tokens.get(0).getLexeme().equals("{") || tokens.get(0).getLexeme().equals("if") || tokens.get(0).getLexeme().equals("while")
            || tokens.get(0).getLexeme().equals("System") || tokens.get(0).getTokenClass().equals("Identifier"))
                Statement();
        }
        if(tokens.get(0).getLexeme().equals("while"))
        {
            tokens.remove(0);
            if(tokens.get(0).getLexeme().equals("("))
                tokens.remove(0);
            else{
                parsed = false;
                error = "Error in line " +tokens.get(0).getLine() + " expected "+"\'(\'"+" found \'"+tokens.get(0).getLexeme()+"\'";
                return;
            }
            if(tokens.get(0).getLexeme().equals("true") || tokens.get(0).getLexeme().equals("false") || tokens.get(0).getLexeme().equals("this") || 
                tokens.get(0).getLexeme().equals("new") || tokens.get(0).getLexeme().equals("!") || tokens.get(0).getLexeme().equals("(") || 
                tokens.get(0).getTokenClass().equals("Identifier") || tokens.get(0).getTokenClass().equals("Integer literal"))
                Expression();
            if(tokens.get(0).getLexeme().equals(")"))
                tokens.remove(0);
            else{
                parsed = false;
                error = "Error in line " +tokens.get(0).getLine() + " expected "+"\')\'"+" found \'"+tokens.get(0).getLexeme()+"\'";
                return;
            }
            if(tokens.get(0).getLexeme().equals("{") || tokens.get(0).getLexeme().equals("if") || tokens.get(0).getLexeme().equals("while")
            || tokens.get(0).getLexeme().equals("System") || tokens.get(0).getTokenClass().equals("Identifier"))
                Statement();
        }
        if(tokens.get(0).getLexeme().equals("System"))
        {
            tokens.remove(0);
            if(tokens.get(0).getLexeme().equals("."))
                tokens.remove(0);
            else{
                parsed = false;
                return;
            }
            if(tokens.get(0).getLexeme().equals("out"))
                tokens.remove(0);
            else{
                parsed = false;
                return;
            }
            if(tokens.get(0).getLexeme().equals("."))
                tokens.remove(0);
            else{
                parsed = false;
                return;
            }
            if(tokens.get(0).getLexeme().equals("println"))
                tokens.remove(0);
            else{
                parsed = false;
                return;
            }
            if(tokens.get(0).getLexeme().equals("("))
                tokens.remove(0);
            else{
                parsed = false;
                error = "Error in line " +tokens.get(0).getLine() + " expected "+"\'(\'"+" found \'"+tokens.get(0).getLexeme()+"\'";
                return;
            }
            if(tokens.get(0).getLexeme().equals("true") || tokens.get(0).getLexeme().equals("false") || tokens.get(0).getLexeme().equals("this") || 
                tokens.get(0).getLexeme().equals("new") || tokens.get(0).getLexeme().equals("!") || tokens.get(0).getLexeme().equals("(") || 
                tokens.get(0).getTokenClass().equals("Identifier") || tokens.get(0).getTokenClass().equals("Integer literal"))
                Expression();
            else{
                    parsed = false;
                    return;
                }
            if(tokens.get(0).getLexeme().equals(")"))
                tokens.remove(0);
            else{
                parsed = false;
                error = "Error in line " +tokens.get(0).getLine() + " expected "+"\')\'"+" found \'"+tokens.get(0).getLexeme()+"\'";
                return;
            }
            if(tokens.get(0).getLexeme().equals(";"))
                tokens.remove(0);
            else{
                parsed = false;
                error = "Error in line " +tokens.get(0).getLine() + " expected "+"\';\'"+" found \'"+tokens.get(0).getLexeme()+"\'";
                return;
            }
        }
        if(tokens.get(0).getTokenClass().equals("Identifier"))
        {
            tokens.remove(0);
            if(tokens.get(0).getLexeme().equals("="))
            {
                tokens.remove(0);
                if(tokens.get(0).getLexeme().equals("true") || tokens.get(0).getLexeme().equals("false") || tokens.get(0).getLexeme().equals("this") || 
                tokens.get(0).getLexeme().equals("new") || tokens.get(0).getLexeme().equals("!") || tokens.get(0).getLexeme().equals("(") || 
                tokens.get(0).getTokenClass().equals("Identifier") || tokens.get(0).getTokenClass().equals("Integer literal"))
                Expression();
                else{
                    parsed = false;
                    return;
                }
                if(tokens.get(0).getLexeme().equals(";"))
                    tokens.remove(0);
                else{
                    parsed = false;
                    error = "Error in line " +tokens.get(0).getLine() + " expected "+"\';\'"+" found \'"+tokens.get(0).getLexeme()+"\'";
                    return;
                }
            }
            else if(tokens.get(0).getLexeme().equals("["))
            {
                tokens.remove(0);
                if(tokens.get(0).getLexeme().equals("true") || tokens.get(0).getLexeme().equals("false") || tokens.get(0).getLexeme().equals("this") || 
                    tokens.get(0).getLexeme().equals("new") || tokens.get(0).getLexeme().equals("!") || tokens.get(0).getLexeme().equals("(") || 
                    tokens.get(0).getTokenClass().equals("Identifier") || tokens.get(0).getTokenClass().equals("Integer literal"))
                Expression();
                else{
                    parsed = false;
                    return;
                }
                if(tokens.get(0).getLexeme().equals("]"))
                    tokens.remove(0);
                else{
                    parsed = false;
                    error = "Error in line " +tokens.get(0).getLine() + " expected "+"\']\'"+" found \'"+tokens.get(0).getLexeme()+"\'";
                    return;
                }
                if(tokens.get(0).getLexeme().equals("="))
                    tokens.remove(0);
                else{
                    parsed = false;
                    return;
                }
                if(tokens.get(0).getLexeme().equals("true") || tokens.get(0).getLexeme().equals("false") || tokens.get(0).getLexeme().equals("this") || 
                    tokens.get(0).getLexeme().equals("new") || tokens.get(0).getLexeme().equals("!") || tokens.get(0).getLexeme().equals("(") || 
                    tokens.get(0).getTokenClass().equals("Identifier") || tokens.get(0).getTokenClass().equals("Integer literal"))
                Expression();
                else{
                    parsed = false;
                    return;
                }
                if(tokens.get(0).getLexeme().equals(";"))
                    tokens.remove(0);
                else{
                    parsed = false;
                    error = "Error in line " +tokens.get(0).getLine() + " expected "+"\';\'"+" found \'"+tokens.get(0).getLexeme()+"\'";
                    return;
                }
            }  
            else{
                parsed = false;
                return;
            }
        }
    }
    public void Expression()
    {
        if(tokens.get(0).getLexeme().equals("true"))
        {
            tokens.remove(0);
            Expression2();
        }  
        else if(tokens.get(0).getLexeme().equals("false"))
            {
            tokens.remove(0);
            Expression2();
        }
        else if(tokens.get(0).getTokenClass().equals("Integer literal"))
        {
            tokens.remove(0);
            Expression2();
        }
        else if(tokens.get(0).getTokenClass().equals("Identifier"))
        {
            tokens.remove(0);
            Expression2();
        }
        else if(tokens.get(0).getLexeme().equals("this"))
        {
            tokens.remove(0);
            Expression2();
        }
        else if(tokens.get(0).getLexeme().equals("new"))
        {
            tokens.remove(0);
            if(tokens.get(0).getLexeme().equals("int"))
            {
                tokens.remove(0);
                if(tokens.get(0).getLexeme().equals("["))
                    tokens.remove(0);
                else{
                    parsed = false;
                    error = "Error in line " +tokens.get(0).getLine() + " expected "+"\'[\'"+" found \'"+tokens.get(0).getLexeme()+"\'";
                    return;
                }
                if(tokens.get(0).getLexeme().equals("true") || tokens.get(0).getLexeme().equals("false") || tokens.get(0).getLexeme().equals("this") || 
                    tokens.get(0).getLexeme().equals("new") || tokens.get(0).getLexeme().equals("!") || tokens.get(0).getLexeme().equals("(") || 
                    tokens.get(0).getTokenClass().equals("Identifier") || tokens.get(0).getTokenClass().equals("Integer literal"))
                    Expression();
                else{
                    parsed = false;
                    return;
                }
                if(tokens.get(0).getLexeme().equals("]"))
                {
                    tokens.remove(0);
                    Expression2();
                }
                else{
                    parsed = false;
                    error = "Error in line " +tokens.get(0).getLine() + " expected "+"\']\'"+" found \'"+tokens.get(0).getLexeme()+"\'";
                    return;
                }
            }
            else if(tokens.get(0).getTokenClass().equals("Identifier"))
            {
                tokens.remove(0);
                if(tokens.get(0).getLexeme().equals("("))
                    tokens.remove(0);
                else{
                    parsed = false;
                    error = "Error in line " +tokens.get(0).getLine() + " expected "+"\'(\'"+" found \'"+tokens.get(0).getLexeme()+"\'";
                    return;
                }
                if(tokens.get(0).getLexeme().equals(")"))
                {
                    tokens.remove(0);
                    Expression2();
                }
                else{
                    parsed = false;
                    error = "Error in line " +tokens.get(0).getLine() + " expected "+"\')\'"+" found \'"+tokens.get(0).getLexeme()+"\'";
                    return;
                }
            }
                
            else{
                parsed = false;
                return;
            }
        }
        else if(tokens.get(0).getLexeme().equals("!"))
        {
            tokens.remove(0);
            if(tokens.get(0).getLexeme().equals("true") || tokens.get(0).getLexeme().equals("false") || tokens.get(0).getLexeme().equals("this") || 
                tokens.get(0).getLexeme().equals("new") || tokens.get(0).getLexeme().equals("!") || tokens.get(0).getLexeme().equals("(") || 
                tokens.get(0).getTokenClass().equals("Identifier") || tokens.get(0).getTokenClass().equals("Integer literal"))
                Expression();
            else{
                parsed = false;
                return;
            }
        }
        else if(tokens.get(0).getLexeme().equals("("))
        {
            tokens.remove(0);
            if(tokens.get(0).getLexeme().equals("true") || tokens.get(0).getLexeme().equals("false") || tokens.get(0).getLexeme().equals("this") || 
                tokens.get(0).getLexeme().equals("new") || tokens.get(0).getLexeme().equals("!") || tokens.get(0).getLexeme().equals("(") || 
                tokens.get(0).getTokenClass().equals("Identifier") || tokens.get(0).getTokenClass().equals("Integer literal"))
                Expression();
            else{
                parsed = false;
                return;
            }
            if(tokens.get(0).getLexeme().equals(")"))
                    tokens.remove(0);
                else{
                    parsed = false;
                    error = "Error in line " +tokens.get(0).getLine() + " expected "+"\')\'"+" found \'"+tokens.get(0).getLexeme()+"\'";
                    return;
                }
        }
        else{
            parsed = false;
            return;
        }
    }
    public void Expression2()
    {
        if(tokens.get(0).getLexeme().equals("."))
            {
                tokens.remove(0);
                if(tokens.get(0).getLexeme().equals("length"))
                {
                    tokens.remove(0);
                    Expression2();
                }
                else if (tokens.get(0).getTokenClass().equals("Identifier"))
                {
                    tokens.remove(0);
                    if(tokens.get(0).getLexeme().equals("("))
                        tokens.remove(0);
                    else{
                        parsed = false;
                        error = "Error in line " +tokens.get(0).getLine() + " expected "+"\'(\'"+" found \'"+tokens.get(0).getLexeme()+"\'";
                        return;
                    }
                    if(tokens.get(0).getLexeme().equals("true") || tokens.get(0).getLexeme().equals("false") || tokens.get(0).getLexeme().equals("this") || 
                        tokens.get(0).getLexeme().equals("new") || tokens.get(0).getLexeme().equals("!") || tokens.get(0).getLexeme().equals("(") || 
                        tokens.get(0).getTokenClass().equals("Identifier") || tokens.get(0).getTokenClass().equals("Integer literal"))
                    {
                        Expression();
                        while(tokens.get(0).getLexeme().equals(","))
                        {
                            tokens.remove(0);
                            if(tokens.get(0).getLexeme().equals("true") || tokens.get(0).getLexeme().equals("false") || tokens.get(0).getLexeme().equals("this") || 
                            tokens.get(0).getLexeme().equals("new") || tokens.get(0).getLexeme().equals("!") || tokens.get(0).getLexeme().equals("(") || 
                            tokens.get(0).getTokenClass().equals("Identifier") || tokens.get(0).getTokenClass().equals("Integer literal"))
                            Expression();
                            else{
                                parsed = false;
                                return;
                            }
                        }
                    }
                    if(tokens.get(0).getLexeme().equals(")"))
                    {
                        tokens.remove(0);
                        Expression2();
                    }
                    else{
                        parsed = false;
                        error = "Error in line " +tokens.get(0).getLine() + " expected "+"\')\'"+" found \'"+tokens.get(0).getLexeme()+"\'";
                        return;
                    }
                }
                else{
                    parsed = false;
                    return;
                }
            }
        else if(tokens.get(0).getLexeme().equals("["))
        {
            tokens.remove(0);
            if(tokens.get(0).getLexeme().equals("true") || tokens.get(0).getLexeme().equals("false") || tokens.get(0).getLexeme().equals("this") || 
            tokens.get(0).getLexeme().equals("new") || tokens.get(0).getLexeme().equals("!") || tokens.get(0).getLexeme().equals("(") || 
            tokens.get(0).getTokenClass().equals("Identifier") || tokens.get(0).getTokenClass().equals("Integer literal"))
            Expression();
            else{
                parsed = false;
                return;
            }
            if(tokens.get(0).getLexeme().equals("]"))
                tokens.remove(0);
            else{
                parsed = false;
                error = "Error in line " +tokens.get(0).getLine() + " expected "+"\']\'"+" found \'"+tokens.get(0).getLexeme()+"\'";
                return;
            }
        }
        else if(tokens.get(0).getLexeme().equals("&&")||tokens.get(0).getLexeme().equals("+")||tokens.get(0).getLexeme().equals("-")
               ||tokens.get(0).getLexeme().equals("*")||tokens.get(0).getLexeme().equals("<"))
        {
            tokens.remove(0);
            if(tokens.get(0).getLexeme().equals("true") || tokens.get(0).getLexeme().equals("false") || tokens.get(0).getLexeme().equals("this") || 
            tokens.get(0).getLexeme().equals("new") || tokens.get(0).getLexeme().equals("!") || tokens.get(0).getLexeme().equals("(") || 
            tokens.get(0).getTokenClass().equals("Identifier") || tokens.get(0).getTokenClass().equals("Integer literal"))
            Expression();
            else{
                parsed = false;
                return;
            }
        }
        
    }
    
    public boolean isParsed() {
        return parsed;
    }

    public String getError() {
        return error;
    }
    
    
}
