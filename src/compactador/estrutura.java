package compactador;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gabriel
 */

public class estrutura implements java.io.Serializable{
    
    private char chave, dic;
    private String cod;
    private estrutura prox, fD, fE;
    private int frequencia;

    public estrutura(char chave) {
        
        this.chave = chave;
        this.frequencia = 1;
    }
    
    public estrutura() {

    }
    
    public estrutura(int freq) {
        this.frequencia = freq;
    }

    public char getDic() {
        return dic;
    }

    public String getCod() {
        return cod;
    }

    public void setDic(char dic) {
        this.dic = dic;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }    
    
    public char getChave() {
        return chave;
    }

    public estrutura getProx() {
        return prox;
    }

    public estrutura getfD() {
        return fD;
    }

    public estrutura getfE() {
        return fE;
    }

    public int getFrequencia() {
        return frequencia;
    }

    public void setChave(char chave) {
        this.chave = chave;
    }

    public void setProx(estrutura prox) {
        this.prox = prox;
    }

    public void setfD(estrutura fD) {
        this.fD = fD;
    }

    public void setfE(estrutura fE) {
        this.fE = fE;
    }

    public void setFrequencia(int frequencia) {
        this.frequencia = frequencia;
    }
    
    
}
