package vista;

public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        //Centrar la venta en la pantalla
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_InicioSesion = new javax.swing.JPanel();
        jLabel_Correo_InicioSesion = new javax.swing.JLabel();
        jLabel_Password_InicioSesion = new javax.swing.JLabel();
        jTextField_Correo_InicioSesion = new javax.swing.JTextField();
        jPasswordField_Password_InicioSesion = new javax.swing.JPasswordField();
        jLabel_Img_InicioSesion = new javax.swing.JLabel();
        jButton_InicioSesion = new javax.swing.JButton();
        jButton_Github_InicioSesion = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel_Logo = new javax.swing.JLabel();
        jLabel_Curso = new javax.swing.JLabel();
        jPanel_Autores = new javax.swing.JPanel();
        jLabel_Autor1 = new javax.swing.JLabel();
        jLabel_Autor2 = new javax.swing.JLabel();
        jLabel_Empresa = new javax.swing.JLabel();
        jLabel_LoginImg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Ventas de Productos Electrónicos");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel_InicioSesion.setBackground(new java.awt.Color(255, 255, 255));

        jLabel_Correo_InicioSesion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_Correo_InicioSesion.setText("Correo Electrónico:");

        jLabel_Password_InicioSesion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_Password_InicioSesion.setText("Contaseña");

        jTextField_Correo_InicioSesion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPasswordField_Password_InicioSesion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel_Img_InicioSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iniciar.png"))); // NOI18N

        jButton_InicioSesion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton_InicioSesion.setText("Iniciar");

        jButton_Github_InicioSesion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton_Github_InicioSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/github.png"))); // NOI18N
        jButton_Github_InicioSesion.setText("Respositorio Github");

        javax.swing.GroupLayout jPanel_InicioSesionLayout = new javax.swing.GroupLayout(jPanel_InicioSesion);
        jPanel_InicioSesion.setLayout(jPanel_InicioSesionLayout);
        jPanel_InicioSesionLayout.setHorizontalGroup(
            jPanel_InicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_InicioSesionLayout.createSequentialGroup()
                .addGroup(jPanel_InicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_InicioSesionLayout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jLabel_Img_InicioSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_InicioSesionLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel_InicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel_Password_InicioSesion)
                            .addComponent(jLabel_Correo_InicioSesion)
                            .addComponent(jTextField_Correo_InicioSesion)
                            .addComponent(jPasswordField_Password_InicioSesion)
                            .addComponent(jButton_Github_InicioSesion, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE))))
                .addContainerGap(31, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_InicioSesionLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton_InicioSesion)
                .addGap(108, 108, 108))
        );
        jPanel_InicioSesionLayout.setVerticalGroup(
            jPanel_InicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_InicioSesionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_Img_InicioSesion)
                .addGap(34, 34, 34)
                .addComponent(jLabel_Correo_InicioSesion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField_Correo_InicioSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel_Password_InicioSesion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPasswordField_Password_InicioSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton_InicioSesion)
                .addGap(34, 34, 34)
                .addComponent(jButton_Github_InicioSesion)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel_InicioSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, 290, 390));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel_Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo.png"))); // NOI18N

        jLabel_Curso.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel_Curso.setText("Análisis y Diseño de Sistemas II");

        jPanel_Autores.setBackground(new java.awt.Color(204, 204, 204));
        jPanel_Autores.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel_Autor1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel_Autor1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Autor1.setText("Daniela Andrea Pavas Bedoya");

        jLabel_Autor2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel_Autor2.setText("Tatiana Elizabeth Sánchez Sanin");

        javax.swing.GroupLayout jPanel_AutoresLayout = new javax.swing.GroupLayout(jPanel_Autores);
        jPanel_Autores.setLayout(jPanel_AutoresLayout);
        jPanel_AutoresLayout.setHorizontalGroup(
            jPanel_AutoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_AutoresLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel_AutoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_Autor2)
                    .addComponent(jLabel_Autor1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_AutoresLayout.setVerticalGroup(
            jPanel_AutoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_AutoresLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel_Autor1)
                .addGap(18, 18, 18)
                .addComponent(jLabel_Autor2)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jLabel_Empresa.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel_Empresa.setForeground(new java.awt.Color(0, 0, 102));
        jLabel_Empresa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Empresa.setText("SIVENPROTEC");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(jLabel_Logo, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel_Curso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel_Autores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel_Empresa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(184, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel_Logo, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_Curso)
                .addGap(18, 18, 18)
                .addComponent(jLabel_Empresa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                .addComponent(jPanel_Autores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 480));

        jLabel_LoginImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/login.jpg"))); // NOI18N
        getContentPane().add(jLabel_LoginImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(534, 0, 230, 480));

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Github_InicioSesion;
    private javax.swing.JButton jButton_InicioSesion;
    private javax.swing.JLabel jLabel_Autor1;
    private javax.swing.JLabel jLabel_Autor2;
    private javax.swing.JLabel jLabel_Correo_InicioSesion;
    private javax.swing.JLabel jLabel_Curso;
    private javax.swing.JLabel jLabel_Empresa;
    private javax.swing.JLabel jLabel_Img_InicioSesion;
    private javax.swing.JLabel jLabel_LoginImg;
    private javax.swing.JLabel jLabel_Logo;
    private javax.swing.JLabel jLabel_Password_InicioSesion;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel_Autores;
    private javax.swing.JPanel jPanel_InicioSesion;
    private javax.swing.JPasswordField jPasswordField_Password_InicioSesion;
    private javax.swing.JTextField jTextField_Correo_InicioSesion;
    // End of variables declaration//GEN-END:variables
}
