package com.example;

public class GeometriaService {
    
    public double CalcularAreaTriangulo(double base, double altura){
        return (base * altura) / 2;
    }

    public double CalcularAreaQuadrado(double lado){
        return lado * lado;
    }

    public double CalcularVolumeEsfera(double raio){
        double resultado = (4 * Math.PI * Math.pow(raio, 3)) / 3;
        return resultado;
    }

    public double CalcularAreaRetangulo(double base, double altura){
        return base * altura;
    }

    public double CalcularAreaCirculo(double raio){
        double resultado = Math.PI * Math.pow(2, 2);
        return resultado;
    }

    public double CalcularVolumeCilindro(double raio, double altura){
        double resultado = Math.PI * Math.pow(2, 2) * altura;
        return resultado;
    }
}