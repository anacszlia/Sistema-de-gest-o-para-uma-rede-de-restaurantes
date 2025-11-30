package view;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Pedido;
import model.dao.PedidoDAO;

public class ListaVendas extends javax.swing.JFrame {

    PedidoDAO dao;
    
    public ListaVendas() {
        initComponents();
        dao = new PedidoDAO();
        loadVendas();
    }
    
    public void loadVendas(){
       DefaultTableModel modelo = (DefaultTableModel) tblVendas.getModel();
       modelo.setNumRows(0);
       for(Pedido obj: dao.listaPedidos()){
           Object[] linha = {
           
            obj.getDataHora() != null ? obj.getDataHora().toString() : "N/A",
            obj.getId(),
            obj.getStatus(),
            obj.getCliente(),
            "R$ " + String.format("%.2f", obj.getValorTotal())
           };
           modelo.addRow(linha);
       }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        areaBusca = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVendas = new javax.swing.JTable();
        btnNovo = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        btnInfo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Vendas Cadastradas");

        javax.swing.GroupLayout areaBuscaLayout = new javax.swing.GroupLayout(areaBusca);
        areaBusca.setLayout(areaBuscaLayout);
        areaBuscaLayout.setHorizontalGroup(
            areaBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        areaBuscaLayout.setVerticalGroup(
            areaBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 72, Short.MAX_VALUE)
        );

        tblVendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data Venda", "ID Pedido", "Status", "Cliente", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblVendas);

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        btnInfo.setText("Mais Informações");
        btnInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInfoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(areaBusca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addComponent(btnRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnInfo)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(areaBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo)
                    .addComponent(btnRemover)
                    .addComponent(btnInfo))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        CadastroVendaJD telaCadastro = new CadastroVendaJD(this, true);
        telaCadastro.setVisible(true);
        
        Pedido novoPedido = telaCadastro.getPedido();
        if(novoPedido != null){
            loadVendas();
        }
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        if(tblVendas.getSelectedRow() != -1){
            int id = (int)tblVendas.getModel().getValueAt(tblVendas.getSelectedRow(), 1);
            int op_remover = JOptionPane.showConfirmDialog(rootPane, "Tem certeza que deseja remover o pedido ID: "+id+"?");
            if(op_remover == JOptionPane.YES_OPTION){
                try {
                    Pedido pedido = new Pedido();
                    pedido.setId(id);
                    dao.remover(pedido);
                    JOptionPane.showMessageDialog(rootPane, "Pedido removido com sucesso!");
                    loadVendas();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(rootPane, "Erro ao remover pedido: "+ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Selecione um pedido para remover!");
        }
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void btnInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInfoActionPerformed
        if(tblVendas.getSelectedRow() != -1){
            String dataHora = (String)tblVendas.getModel().getValueAt(tblVendas.getSelectedRow(), 0);
            int id = (int)tblVendas.getModel().getValueAt(tblVendas.getSelectedRow(), 1);
            String status = (String)tblVendas.getModel().getValueAt(tblVendas.getSelectedRow(), 2);
            String cliente = (String)tblVendas.getModel().getValueAt(tblVendas.getSelectedRow(), 3);
            String valorTotal = (String)tblVendas.getModel().getValueAt(tblVendas.getSelectedRow(), 4);
            
            String info = "Informações do Pedido:\n\n" +
                         "ID: " + id + "\n" +
                         "Data/Hora: " + dataHora + "\n" +
                         "Status: " + status + "\n" +
                         "Cliente: " + cliente + "\n" +
                         "Valor Total: " + valorTotal;
            
            JOptionPane.showMessageDialog(this, info, "Detalhes do Pedido", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Selecione um pedido para ver mais informações!");
        }
    }//GEN-LAST:event_btnInfoActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaVendas().setVisible(true);
            }
        });
    }
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel areaBusca;
    private javax.swing.JButton btnInfo;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnRemover;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblVendas;
    // End of variables declaration//GEN-END:variables
}