package com.example.calculadora;

public class Calculadora {
    private static final Calculadora instancia = new Calculadora();
    private String contenido;
    private double memoria;
    private char operacion;

    private Calculadora() {
        this.contenido = "";
    }

    public void annadeNumero(int num) {
        this.contenido += num;
    }

    public void annadePunto() {
        this.contenido += ".";
    }

    public void opera(char operacion) {
        this.operacion = operacion;
        this.memoria = Double.parseDouble(this.contenido);
        this.contenido = "";
    }

    public void igual() {
        double segundo = Double.parseDouble(this.contenido);

        switch (this.operacion) {
            case '+':
                this.contenido = "" + (this.memoria + segundo);
                break;
            case '-':
                this.contenido = "" + (this.memoria - segundo);
                break;
            case '*':
                this.contenido = "" + (this.memoria * segundo);
                break;
            case '/':
                this.contenido = "" + (this.memoria / segundo);
                break;
            default:
                this.contenido = "" + (this.memoria);
        }
    }

    public String getContenido() {
        return contenido;
    }

    public char getOperacion() {
        return operacion;
    }

    public void setOperacion(char operacion) {
        this.operacion = operacion;
    }

    static Calculadora getInstance() {
        return instancia;
    }

}
