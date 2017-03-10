package compactador;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gabriel
 */
public class huffman {
    private String conteudo;
    private estrutura alfabeto;
    private estrutura dicionario;
    private String caminho, caminhoSaida;
    
    /**
     * Construtor da classe, inicia a variavel conteudo vazia
     */
    public huffman(){
        this.conteudo = "";
    }

    /**
     * Método getAlfabeto que retorna a String contedo o alfabeto
     * 
     * @return 
     */
    public estrutura getAlfabeto() {
        return alfabeto;
    }

    /**
     * Método getCaminho que retorna a String contedo o caminho
     * 
     * @return 
     */
    public String getCaminho() {
        return caminho;
    }

    /**
     * Método setCaminho seta a String caminho
     * @param caminho 
     */
    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

    /**
     * Método setAlfabeto seta a String alfabeto
     * @param alfabeto 
     */
    public void setAlfabeto(estrutura alfabeto) {
        this.alfabeto = alfabeto;
    }

    /**
     * Método setCaminhoSaida seta a variavel caminhoSaida
     * @param caminhoSaida 
     */
    public void setCaminhoSaida(String caminhoSaida) {
        this.caminhoSaida = caminhoSaida;
    }
    
    /**
     * Método getConteudo que retorna a String conteudo
     * @return 
     */
    public String getConteudo() {
        return conteudo;
    }

    /**
     * Método que seta a String conteudo
     * @param conteudo 
     */
    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
    
    
    /**
     * Método que cria o alfabeto, ele le todo o conteudo do arquivo e monta uma
     * lista encadeada contendo cada letra e sua frequencia no conteudo.
     * 
     */
    public void CriaAlfabeto(){
        for(int i=0; i<conteudo.length(); i++){
            estrutura aux = alfabeto;
            boolean done = false;
            while(done == false){
                if(aux == null){
                    aux = new estrutura(conteudo.charAt(i));
                    done = true;
                    if(alfabeto == null){
                        alfabeto = aux;
                    }
                }
                else if(aux.getChave() == conteudo.charAt(i)){
                    aux.setFrequencia(aux.getFrequencia() + 1);
                    done = true;
                }
                else{
                    if(aux.getProx() == null){
                        aux.setProx(new estrutura(conteudo.charAt(i)));
                    }
                    else{
                        aux = aux.getProx();
                    }
                }
            }
        }
    }
    
    /**
     * Método que cria a Árvore de acordo com o alfabeto, pega os dois caracteres
     * de menores frequencias desaloca eles, e junta em um somente nó, com esses 
     * dois menores sendo os filhos dele, até a lista alfabeto conter somente uma
     * raiz.
     */
    public void CriaArvore(){
        estrutura e1, e2, novo;
        
        while(alfabeto.getProx() != null){
            e1 = EncontraMenor();
            ApagaReferencia(e1);
            e2 = EncontraMenor();
            ApagaReferencia(e2);
            novo = new estrutura(e1.getFrequencia()+e2.getFrequencia());
            novo.setfD(e2);
            novo.setfE(e1);
            novo.setProx(alfabeto);
            alfabeto = novo;
        }
    }
    
    /**
     * Método utilizado com o CriaArvore, ele encontra o elemento de menor frequencia
     * na lista e retorna o nó
     * @return 
     */
    public estrutura EncontraMenor(){
        estrutura menor, aux;
        aux = alfabeto;
        menor = alfabeto;
        
        while(aux != null){
            if(aux.getFrequencia() < menor.getFrequencia()){//freq errada
                menor = aux;
            }
            aux = aux.getProx();
        }
        
        return menor;
    }
    
    /**
     * Este método recebe como parametro um elemento, e apaga os ponteiros que
     * apontam para ele na lista, ele é ultilizado com o método CriaArvore
     * @param e 
     */    
    public void ApagaReferencia(estrutura e){
        estrutura aux = alfabeto;
        estrutura ante = null;
        while(aux != null){
            if(aux == e){
                if(ante == null){
                    alfabeto = alfabeto.getProx();
                    return;
                }
                else{
                    ante.setProx(aux.getProx());
                }
            }
            ante = aux;
            aux = aux.getProx();
        }
    }
    
    /**
     * Este método recebe uma arvore contendo os caracteres, e de acordo com sua 
     * posição gera um código binário correspondente.
     * @param aux
     * @param codigo 
     */
    public void CriaDicionario(estrutura aux, String codigo){
        if(aux != null){
            
            CriaDicionario(aux.getfE(), codigo + "0");

            if(aux.getfD() == null && aux.getfE() == null){
                System.out.println(aux.getChave() + "  " + codigo);
                if(dicionario == null){
                    dicionario = new estrutura();
                    dicionario.setCod(codigo);
                    dicionario.setDic(aux.getChave());
                }
                else{
                    estrutura novo = new estrutura();
                    novo.setCod(codigo);
                    novo.setDic(aux.getChave());
                    estrutura aux2 = dicionario;
                    while(aux2.getProx() != null){
                        aux2 = aux2.getProx();
                    }
                    aux2.setProx(novo);
                }

            }
            CriaDicionario(aux.getfD(), codigo + "1");
        }       
        
    }
    
    /**
     * Este método retorna uma String contendo os codigos binários de cada caracter
     * substitudos.
     * @return 
     */
    public String CriaNovaStringAscii(){
        String nova = "";
        for(int i=0; i<conteudo.length(); i++){
            estrutura aux = dicionario;
            while(aux.getDic() != conteudo.charAt(i)){
                aux = aux.getProx();
            }
           
            nova = nova + aux.getCod();
        }
        
        return nova;
    }    
    
    /**
     * Este método completa os zeros no final da String, considera os tres ultimos
     * bits para indentificação da quantidade de zeros inseridas.
     * 
     * @param nova
     * @return 
     */
    public String CompletaZero (String nova){
        int completa = (nova.length()+3) % 8;
        if(completa != 0){
            completa = 8 - completa;           
        }
        String bin = "";
        System.out.println("faltam: " + completa + " bits.");
        System.out.println("a String contem: " + nova.length() + " bits.");
        int contador = 0;
        while(contador<completa){
            nova = nova + "0";
            contador++;
        }
        while (completa>0) {  
            bin = ((completa % 2 == 0)?"0":"1" ) + bin;
            completa /= 2;  
        } 
        System.out.println("bin tamanho: " + bin.length());
        while(bin.length() < 3){
            bin = "0" + bin;
        }
        System.out.println("bin = " + bin);
        nova = nova + bin;
        return nova;
    }
    
    /**
     * Este método recebe a String binária e converte ela para os caracteres 
     * correspondentes de 8 em 8 bits
     * 
     * @param nova
     * @return 
     */
    public String CriaNovaString (String nova){
        int contador = 0;
        String nova2 = "";
        while(contador+8 <= nova.length()){
            int decimal = Integer.parseInt(nova.substring(contador, contador + 8), 2);//transformar o binario em decimal
            contador = contador + 8;
            char temp = (char)decimal;
            System.out.println("temp: " + temp);
            nova2 = nova2 + temp;
        }
        return nova2;
    }
    
    /**
     * Este método é usado na descompactação, ele recebe a String e converte ela
     * novamente para binario. 
     * @return 
     */
    public String TransformaBinario(){
        String nova = "";
        for(int i=0; i<conteudo.length(); i++){
            int decimal = conteudo.charAt(i);
            String bin = "";
            while (decimal>0) {  
                bin = ((decimal % 2 == 0)?"0":"1" ) + bin;
                decimal /= 2;  
            } 
            while(bin.length() < 8){
                bin = "0" + bin;
            }
            //System
            nova = nova + bin;
        }
        return nova;
    }
    
    /**
     * Este método é usado na descompactação, ele lê os 3 ultimos bits para saber
     * a quantidade de zeros inseridos e retira.
     * @param nova
     * @return 
     */
    public String RetiraZero(String nova){
        int decimal = Integer.parseInt(nova.substring(nova.length()-3, nova.length()), 2);
        System.out.println("foram inseridos " + decimal + " zeros.");
        String nova2 = nova.substring(0,nova.length()-decimal-3);
        return nova2;
    }
    /**
     * Este método é usado na compactação, ele cria um arquivo para armazenar 
     * a arvore contendo a árvore necessária para descompactação.
     * 
     */
    public void ArmazenaArvore(){
         try{

         ObjectOutputStream saida = new ObjectOutputStream(new FileOutputStream(caminhoSaida + "\\arvore.arv"));


         saida.writeObject(alfabeto);
    
         saida.close();
      } catch( Exception e ){
            System.out.println("ERRO!" + e);
            e.printStackTrace();
      }
    }
    
    /**
     * Este método é usado na compactação, ele recupera o arquivo contendo a 
     * arvore e retorna o objeto da árvore.
     * @return 
     */
    public estrutura RecuperaArvore(){
        estrutura objeto = null;
        try{
            ObjectInputStream leitura = new ObjectInputStream(new FileInputStream(caminhoSaida + "\\arvore.arv"));            

            objeto = (estrutura) leitura.readObject();

            leitura.close();
        } catch( Exception e ){
            e.printStackTrace();
        }

      return objeto;
    }
    
    /**
     * Este método é o método utilizado para descompactar, ele lê o arquivo, e
     * de acorodo com a arvore gera os caracteres correspondentes.
     * 
     * @param conteudo2
     * @return 
     */
    public String Descompacta (String conteudo2){
        String nova = "";
        estrutura aux = alfabeto; // auxiliar recebe a raiz da arvore

        int i=0;
        while(i<conteudo2.length()){ // percorre todo o conteudo 

            if(aux.getfD() != null && aux.getfE() != null){ // enquanto não for folha
                if(conteudo2.charAt(i) == '0'){
                    aux = aux.getfE();
                    i++;
                }
                else{
                    aux = aux.getfD();
                    i++;
                }
            }
            else{
                nova = nova + aux.getChave();
                aux = alfabeto; // auxiliar recebe a raiz da arvore
            }
        }
        return nova;
    }
}