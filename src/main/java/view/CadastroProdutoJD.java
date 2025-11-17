package view;

import javax.swing.JOptionPane;
import model.Produto;
import model.dao.ProdutoDAO;

public class CadastroProdutoJD extends javax.swing.JDialog {
    private Produto produto;
    private ProdutoDAO produtoDAO;

    public CadastroProdutoJD(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        produto = new Produto();
        produtoDAO = new ProdutoDAO();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cmbCategoria = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtPreco = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Cadastro de Produto");

        jLabel2.setText("Nome");

        jLabel3.setText("Descrição");

        jLabel4.setText("Categoria");

        cmbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ENTRADA", "PRATO_PRINCIPAL", "SOBREMESA", "BEBIDA" }));

        jLabel5.setText("Preço");

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNome)
                            .addComponent(txtDescricao)
                            .addComponent(cmbCategoria, 0, 214, Short.MAX_VALUE)
                            .addComponent(txtPreco)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnCancelar))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>                        

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {                                            
        this.dispose();
    }                                           

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {                                          
        try {
            produto.setNome(txtNome.getText());
            produto.setDescricao(txtDescricao.getText());
            produto.setCategoria(cmbCategoria.getSelectedItem().toString());
            produto.setPreco(Double.parseDouble(txtPreco.getText()));
            
            produtoDAO.persist(produto);
            JOptionPane.showMessageDialog(this, "Produto cadastrado com sucesso!");
            this.dispose();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Preço deve ser um número válido!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar produto: " + e.getMessage());
        }
    }                                         

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cmbCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPreco;
    // End of variables declaration                   
}