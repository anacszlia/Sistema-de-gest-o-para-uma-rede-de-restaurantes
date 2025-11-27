package view;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import model.Cliente;
import model.Funcionario;
import model.ItemPedido;
import model.Pedido;
import model.Produto;
import model.dao.ClienteDAO;
import model.dao.FuncionarioDAO;
import model.dao.PedidoDAO;
import model.dao.ProdutoDAO;

public class RealizarPedidoJD extends javax.swing.JDialog {
    private ProdutoDAO produtoDAO;
    private ClienteDAO clienteDAO;
    private FuncionarioDAO funcionarioDAO;
    private PedidoDAO pedidoDAO;
    private Pedido pedido;
    private DefaultListModel<String> modeloLista;

    public RealizarPedidoJD(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        produtoDAO = new ProdutoDAO();
        clienteDAO = new ClienteDAO();
        funcionarioDAO = new FuncionarioDAO();
        pedidoDAO = new PedidoDAO();
        pedido = new Pedido();
        modeloLista = new DefaultListModel<>();
        listItens.setModel(modeloLista);
        
        carregarDados();
    }

    private void carregarDados() {
        try {
            List<Produto> produtos = produtoDAO.listaProdutos();
            DefaultComboBoxModel<Produto> modeloProdutos = new DefaultComboBoxModel<>();
            for (Produto p : produtos) {
                modeloProdutos.addElement(p);
            }
            cmbProduto.setModel(modeloProdutos);
            
            List<Cliente> clientes = clienteDAO.listaClientes();
            DefaultComboBoxModel<Cliente> modeloClientes = new DefaultComboBoxModel<>();
            for (Cliente c : clientes) {
                modeloClientes.addElement(c);
            }
            cmbCliente.setModel(modeloClientes);
            
            List<Funcionario> funcionarios = funcionarioDAO.listaFuncionarios();
            DefaultComboBoxModel<Funcionario> modeloFuncionarios = new DefaultComboBoxModel<>();
            for (Funcionario f : funcionarios) {
                modeloFuncionarios.addElement(f);
            }
            cmbFuncionario.setModel(modeloFuncionarios);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar dados: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbCliente = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cmbFuncionario = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cmbProduto = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();
        btnAdicionarItem = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listItens = new javax.swing.JList<>();
        jLabel6 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        btnFinalizarPedido = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Realizar Pedido");

        jLabel2.setText("Cliente");

        jLabel3.setText("Funcionário");

        jLabel4.setText("Produto");

        jLabel5.setText("Quantidade");

        btnAdicionarItem.setText("Adicionar Item");
        btnAdicionarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarItemActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(listItens);

        jLabel6.setText("Total: R$");

        lblTotal.setText("0.00");

        btnFinalizarPedido.setText("Finalizar Pedido");
        btnFinalizarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarPedidoActionPerformed(evt);
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
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
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
                                    .addComponent(cmbCliente, 0, 214, Short.MAX_VALUE)
                                    .addComponent(cmbFuncionario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbProduto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtQuantidade)))
                            .addComponent(btnAdicionarItem)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTotal))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnFinalizarPedido)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelar)))
                        .addGap(0, 19, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnAdicionarItem)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblTotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFinalizarPedido)
                    .addComponent(btnCancelar))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>                        

    private void btnAdicionarItemActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        try {
            Produto produto = (Produto) cmbProduto.getSelectedItem();
            int quantidade = Integer.parseInt(txtQuantidade.getText());
            double subtotal = produto.getPreco() * quantidade;
            
            String item = produto.getNome() + " - Qtd: " + quantidade + " - R$ " + String.format("%.2f", subtotal);
            modeloLista.addElement(item);
            
            atualizarTotal();
            txtQuantidade.setText("");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Quantidade deve ser um número válido!");
        }
    }                                                

    private void btnFinalizarPedidoActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        try {
            if (modeloLista.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Adicione pelo menos um item ao pedido!");
                return;
            }
            
            pedido.setStatus("PENDENTE");
            pedido.setValorTotal(calcularTotal());
            
            pedidoDAO.persist(pedido);
            JOptionPane.showMessageDialog(this, "Pedido realizado com sucesso!");
            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao finalizar pedido: " + e.getMessage());
        }
    }                                                  

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {                                            
        this.dispose();
    }                                           

    private void atualizarTotal() {
        lblTotal.setText(String.format("%.2f", calcularTotal()));
    }

    private double calcularTotal() {
        double total = 0.0;
        for (int i = 0; i < modeloLista.size(); i++) {
            String item = modeloLista.getElementAt(i);
            String[] partes = item.split(" - R\\$ ");
            if (partes.length > 1) {
                total += Double.parseDouble(partes[1]);
            }
        }
        return total;
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnAdicionarItem;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnFinalizarPedido;
    private javax.swing.JComboBox<Cliente> cmbCliente;
    private javax.swing.JComboBox<Funcionario> cmbFuncionario;
    private javax.swing.JComboBox<Produto> cmbProduto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JList<String> listItens;
    private javax.swing.JTextField txtQuantidade;
    // End of variables declaration                   
}