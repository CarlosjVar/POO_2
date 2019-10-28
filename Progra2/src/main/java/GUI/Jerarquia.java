/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Jos
 */
public class Jerarquia extends javax.swing.JFrame {

    /**
     * Creates new form Jerarquia
     */
    public Jerarquia() {
        initComponents();
    }
        public ArrayList<ArrayList> ListaInterfaces(Class clase,ArrayList <Class> classArray)
    {
        ArrayList<ArrayList> general = new ArrayList<ArrayList>();
        boolean encontrado;
        ArrayList <Class> interfacesSup = new ArrayList <Class>();
        ArrayList <Class> interfacesHij=new ArrayList <Class>();
        Class [] clasebase=clase.getInterfaces();
        for(Class inter:clasebase)
        {
        interfacesSup.add(inter);
        }
        for(int i=0;i<classArray.size();i++)
        {
            System.out.print(classArray.size());
            if((classArray.size()!=1))
            {
                System.out.print("Tengo más de una superclase");
            Class[] interfac=classArray.get(i).getInterfaces();
            for(Class inte:interfac)
            {
                System.out.print("Adios");
                encontrado=false;
                for (int o=0;o<interfacesSup.size();o++)
                {
                    if(inte==interfacesSup.get(o))
                    {
                        encontrado=true;
                    }
                }
                if(!encontrado)
                {
                    interfacesHij.add(inte);
                    System.out.print("Se ha insertado una interfaz");
                }
                else
                {
                    System.out.print("Es repetido");
                }
            }
            }
            else
            {
                System.out.print("Tengo una superclase");
                Class[] interfa=classArray.get(i).getInterfaces();   
                for(Class inter:interfa)
                {
                    System.out.print("ola");
                    interfacesHij.add(inter);
                }
            }
        }
        general.add(interfacesSup);
        general.add(interfacesHij);
        return general;
    }
     public void fillJList2(Class clase,ArrayList<Class> superclases)
     {
         ArrayList<ArrayList> interfaces=this.ListaInterfaces(clase, superclases);
         ArrayList<Class> supers=interfaces.get(0);
         ArrayList<Class> normal=interfaces.get(1);
         String []nombres=new String[supers.size()+normal.size()];
         System.out.print(supers.size());
         System.out.print(normal.size());
        for(int o=0;o<normal.size();o++)
         {
             
             nombres[o]=normal.get(o).getSimpleName();
         }
         for(int i =0;i<supers.size();i++)
         {
             String armar=supers.get(i).getSimpleName();
             armar=armar+"<"+clase.getSimpleName()+">";
             nombres[i+nombres.length-1]=armar;
         }
         jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = nombres;
            @Override
            public int getSize() { return strings.length; }
            @Override
            public String getElementAt(int i) { return strings[i]; }
        });
     }
     public void fillJList ( ArrayList <Class> classArray, Class x){
        int cantidad = classArray.size();
        String [] nombres;
        if (cantidad%2==0){
             nombres = new String [cantidad*2+1];
             for (int i = 1;i<cantidad*2+1;i++){               
                 if (i%2!=0){
                     nombres[cantidad*2-i] = "           ↥";
                 }else{
                     nombres[cantidad*2-i] = classArray.get(i/2-1).getName();
                 }
             }
            nombres [cantidad*2] = x.getName();             
        }
        else if(classArray.get(0)==null){
            nombres = new String [1];
            nombres[0]= x.getName();
        }
        else{
            nombres = new String [cantidad*2+2];
             for (int i = 1;i<cantidad*2+1;i++){               
                 if (i%2!=0){
                     nombres[cantidad*2-i] = "           ↥";
                 }else{
                     nombres[cantidad*2-i] = classArray.get(i/2-1).getName();
                 }
             }
            nombres [cantidad*2] = x.getName();
        }
        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = nombres;
            @Override
            public int getSize() { return strings.length; }
            @Override
            public String getElementAt(int i) { return strings[i]; }
        });
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = {};
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel4.setText("Jerarquia de clases:");

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel1.setText("Interfaces implementadas");

        jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = {};
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(89, 89, 89)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Jerarquia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Jerarquia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Jerarquia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Jerarquia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Jerarquia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
