package br.com.educ4.core.domain;

public class User {

    private String name;

    public void name(String name){
        if(name == null || name.length() < 3)
            throw new RuntimeException("O nome não pode ser menor do que 3 letras");

        this.name = name;
    }

    public String name(){
        return this.name;
    }
}
