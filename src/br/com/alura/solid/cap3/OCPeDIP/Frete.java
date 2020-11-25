package br.com.alura.solid.cap3.OCPeDIP;

public class Frete implements ServicoDeEntrega{
    public double para(String cidade) {
        if("SAO PAULO".equals(cidade.toUpperCase())) {
            return 15;
        }
        return 30;
    }
}