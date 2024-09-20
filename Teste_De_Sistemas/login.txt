package com.example;

public class Login {
    private String email = "email@gmail.com";
    private String senha = "senha123";

    public boolean logar(String email, String senha) {
        if (email ==this.email && senha == this.senha) {
            return true;
        }else{
            return false;
        }
    }

}
