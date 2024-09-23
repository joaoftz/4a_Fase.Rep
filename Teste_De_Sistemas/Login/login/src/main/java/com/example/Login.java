package com.example;

public class Login {

    private String email = "joao@gmail.com";
    private String senha = "senha123";

    public boolean logar(String email, String senha){
        if(email == this.email && senha == this.senha){
            return true;
        }else{
            return false;
        }
    }
    public boolean logarEmailInvalido(String email, String senha){
        if(email != this.email && senha == this.senha){
            return true;
        }else{
            return false;
        }
    }
    public boolean logarSenhaInvalida(String email, String senha){
        if(email == this.email && senha != this.senha){
            return true;
        }else{
            return false;
        }
    }   
}
