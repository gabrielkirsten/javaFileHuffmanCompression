package compactador;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gabriel
 */
public class Interface extends javax.swing.JFrame {

    /**
     * Creates new form Interface
     */
    
    JFileChooser chooser = new JFileChooser();
    huffman arquivo = new huffman();
    File arq;
    
    public Interface() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        Status = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        arqName = new javax.swing.JLabel();
        BotCompactar = new javax.swing.JButton();
        BotDescompact = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        SelecArq = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Gabriel Kirsten Menezes - RA: 148298 - Engenharia de Computação - UCDB");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel4.setText("Status: ");

        Status.setText("-");

        jLabel3.setText("Arquivo Selecionado :");

        arqName.setText("-");

        BotCompactar.setText("Compactar");
        BotCompactar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotCompactarActionPerformed(evt);
            }
        });

        BotDescompact.setText("Descompactar");
        BotDescompact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotDescompactActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(arqName))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Status))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BotCompactar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BotDescompact)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(arqName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(Status))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotCompactar)
                    .addComponent(BotDescompact))
                .addGap(2, 2, 2))
        );

        jLabel1.setText("Selecione um arquivo e clique em \"Compactar\" ou \"Descompactar\".");

        SelecArq.setText("Selecionar Arquivo");
        SelecArq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelecArqActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 33, Short.MAX_VALUE)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(SelecArq))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SelecArq)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SelecArqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelecArqActionPerformed
        // TODO add your handling code here:
         chooser.setFileSelectionMode(JFileChooser.FILES_ONLY); //define que o arquivo selecionado deverá ser um arquivo
         if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
            arqName.setText(chooser.getSelectedFile().toString()); 
            String conteudo = "";
            try {//tenta abrir o arquivo
                arq = new File(chooser.getSelectedFile().toString());
                conteudo = new Scanner(arq, "UTF-8").useDelimiter("\\A").next();
                arquivo.setConteudo(conteudo);
                arquivo.setCaminho(arqName.getText());
                arquivo.setCaminhoSaida(chooser.getSelectedFile().toString());
            } catch (FileNotFoundException e) { //se não conseguir
                System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
            }       
            System.out.println(conteudo);
        } 
    }//GEN-LAST:event_SelecArqActionPerformed

    private void BotCompactarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotCompactarActionPerformed
        // TODO add your handling code here:
        String saida = "";
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); // deverá ser selecionado um diretório
        JOptionPane.showMessageDialog(null,"Selecione o Diretório para saida.");
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
            saida = chooser.getSelectedFile().toString(); 

            try {  
                System.out.println(saida + "\\compactado.gkm");
                File file = new File(saida + "\\compactado.gkm");  
                boolean success = file.createNewFile();  
                arquivo.setCaminhoSaida(saida);
             } catch (IOException e) {  
             
             }
        }       

         
        Status.setText("Criando Alfabeto..");
        arquivo.CriaAlfabeto();
        
        Status.setText("Criando Arvore..");
        arquivo.CriaArvore();
        
        Status.setText("Criando Dicionario..");
        arquivo.CriaDicionario(arquivo.getAlfabeto(), "");
        
        Status.setText("Criando StringAscii..");
        String nova = arquivo.CriaNovaStringAscii();
        
        Status.setText("Completando a String..");
        nova = arquivo.CompletaZero(nova);
        System.out.println("conteudo com zero: " + nova);
        
        System.out.println("Criando a String");
        nova = arquivo.CriaNovaString(nova);
        
        arquivo.setConteudo(nova);
        System.out.println("conteudo: " + arquivo.getConteudo());
        Status.setText("Concluido - Compactado");
     
        try {  
            BufferedWriter out = new BufferedWriter(new FileWriter(saida + "\\compactado.gkm"));  
            out.write(nova);  
            out.close();  
        } catch (IOException e) {  
        }
        arquivo.ArmazenaArvore();
         
    }//GEN-LAST:event_BotCompactarActionPerformed

    private void BotDescompactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotDescompactActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null,"Selecione aonde encontra-se o arquivo contendo a arvore");
        String saida = "";
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
            saida = chooser.getSelectedFile().toString();
            arquivo.setCaminhoSaida(saida);
        }   
        arquivo.setAlfabeto(arquivo.RecuperaArvore());
        String nova = arquivo.TransformaBinario();
        System.out.println("Descompactada: " + arquivo.TransformaBinario());
        nova = arquivo.RetiraZero(nova);
        System.out.println("sem zeros: " + nova);
        nova = arquivo.Descompacta(nova);
        System.out.println("final: " + nova);
        try {  
            BufferedWriter out = new BufferedWriter(new FileWriter(saida + "\\descompactado.txt"));  
            out.write(nova);  
            out.close();  
        } catch (IOException e) {  
        }
        Status.setText("Concluido - Descompactado");
        
    }//GEN-LAST:event_BotDescompactActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotCompactar;
    private javax.swing.JButton BotDescompact;
    private javax.swing.JButton SelecArq;
    private javax.swing.JLabel Status;
    private javax.swing.JLabel arqName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
