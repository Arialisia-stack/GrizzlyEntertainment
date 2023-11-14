//Programmer: Tavar Oliver
//
//
//


package views;

import java.awt.Color;
import javax.swing.JOptionPane;
//import javax.swing.table.DefaultTableModel;

public class ClientDashboard extends javax.swing.JFrame {
    
    private static final long serialVersionUID = 1L;
	
    private javax.swing.JPanel actionPanel;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabelAbsoluteAccount;
    private javax.swing.JLabel jLabelAbsoluteAccount1;
    private javax.swing.JLabel jLabelAllTransactions;
    private javax.swing.JLabel jLabelBookEquipment;
    private javax.swing.JLabel jLabelClearChat;
    private javax.swing.JLabel jLabelDashBoard;
    private javax.swing.JLabel jLabelLighting;
    private javax.swing.JLabel jLabelLogout;
    private javax.swing.JLabel jLabelNameAbsolute;
    private javax.swing.JLabel jLabelNameChangeable;
    private javax.swing.JLabel jLabelPrintReceipt1;
    private javax.swing.JLabel jLabelPower;
    private javax.swing.JLabel jLabelSendMessage;
    private javax.swing.JLabel jLabelSingleTransaction;
    private javax.swing.JLabel jLabelSound;
    private javax.swing.JLabel jLabelStaging;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelDate;
    private javax.swing.JPanel jPanelMenu;
    private javax.swing.JPanel jPanelMessage;
    private javax.swing.JPanel jPanelParent;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextAreaRecieptPrint;
    private javax.swing.JTextPane jTextPaneSendMessage;
    private javax.swing.JPanel titlePanel; 
    private javax.swing.JTable jTableEquipment;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JLabel jLabelSubTotal;
	private javax.swing.JLabel jLabelSubTotal1;
	private javax.swing.JLabel jLabelRentEquipment;
    private javax.swing.JTextField jTextFieldSubTotal1;
	private javax.swing.JTextField jTextFieldSubTotal;
    private javax.swing.JLabel jLabelFetchAll;
    private javax.swing.JTable jTableAllEquipment;
	private javax.swing.JTable jTableSingleEquipment;
	private javax.swing.JLabel jLabelTransactionNumber;
	private javax.swing.JLabel jLabelFetchSingleTransaction;
	private javax.swing.JTextField jTextFieldTransactionNumber;
    
    public ClientDashboard() {
        initComponents();
        
        this.setLocationRelativeTo(null);
    }
    
                          
    private void initComponents() {

        jPanelParent = new javax.swing.JPanel();
        jPanelMenu = new javax.swing.JPanel();
        titlePanel = new javax.swing.JPanel();
        jLabelTitle = new javax.swing.JLabel();
        jLabelAllTransactions = new javax.swing.JLabel();
        jLabelSingleTransaction = new javax.swing.JLabel();
        jLabelBookEquipment = new javax.swing.JLabel();
        jLabelLogout = new javax.swing.JLabel();
        actionPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabelAbsoluteAccount1 = new javax.swing.JLabel();
        jLabelStaging = new javax.swing.JLabel();
        jLabelSound = new javax.swing.JLabel();
        jLabelPower = new javax.swing.JLabel();
        jLabelLighting = new javax.swing.JLabel();
        jLabelDashBoard = new javax.swing.JLabel();
        jLabelAbsoluteAccount = new javax.swing.JLabel();
        jLabelNameAbsolute = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabelNameChangeable = new javax.swing.JLabel();
        jPanelMessage = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPaneSendMessage = new javax.swing.JTextPane();
        jLabelSendMessage = new javax.swing.JLabel();
        jLabelClearChat = new javax.swing.JLabel();
        jPanelDate = new javax.swing.JPanel();
        jLabelPrintReceipt1 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextAreaRecieptPrint = new javax.swing.JTextArea();
        jTableEquipment = new javax.swing.JTable();
    	jScrollPane2 = new javax.swing.JScrollPane();
    	jLabelSubTotal = new javax.swing.JLabel();
    	jLabelSubTotal1 = new javax.swing.JLabel();
    	jLabelRentEquipment = new javax.swing.JLabel();
        jTextFieldSubTotal1 = new javax.swing.JTextField();
    	jTextFieldSubTotal = new javax.swing.JTextField();
    	jLabelFetchAll = new  javax.swing.JLabel();
        jTableAllEquipment = new javax.swing.JTable();
        jTableSingleEquipment = new  javax.swing.JTable();
		jLabelTransactionNumber = new javax.swing.JLabel();
		jLabelFetchSingleTransaction = new javax.swing.JLabel();
		jTextFieldTransactionNumber = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelParent.setBackground(new java.awt.Color(255, 255, 255));

        jPanelMenu.setBackground(new java.awt.Color(56, 106, 179));

        titlePanel.setBackground(new java.awt.Color(30, 139, 195));

        jLabelTitle.setFont(new java.awt.Font("Trattatello", 2, 49)); // NOI18N
        jLabelTitle.setText("Grizzly's Entertainment ");

        javax.swing.GroupLayout titlePanelLayout = new javax.swing.GroupLayout(titlePanel);
        titlePanel.setLayout(titlePanelLayout);
        titlePanelLayout.setHorizontalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        titlePanelLayout.setVerticalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        jLabelAllTransactions.setBackground(new java.awt.Color(56, 106, 179));
        jLabelAllTransactions.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabelAllTransactions.setForeground(new java.awt.Color(255, 255, 255));
        jLabelAllTransactions.setText(" View Past Transactions");
        jLabelAllTransactions.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelAllTransactions.setOpaque(true);
        jLabelAllTransactions.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAllTransactionsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelAllTransactionsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelAllTransactionsMouseExited(evt);
            }
        });

        jLabelSingleTransaction.setBackground(new java.awt.Color(56, 106, 179));
        jLabelSingleTransaction.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabelSingleTransaction.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSingleTransaction.setText(" Single Past Transaction");
        jLabelSingleTransaction.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelSingleTransaction.setOpaque(true);
        jLabelSingleTransaction.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSingleTransactionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelSingleTransactionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelSingleTransactionMouseExited(evt);
            }
        });

        jLabelBookEquipment.setBackground(new java.awt.Color(56, 106, 179));
        jLabelBookEquipment.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabelBookEquipment.setForeground(new java.awt.Color(255, 255, 255));
        jLabelBookEquipment.setText(" Book Equipment");
        jLabelBookEquipment.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelBookEquipment.setOpaque(true);
        jLabelBookEquipment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelBookEquipmentMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelBookEquipmentMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelBookEquipmentMouseExited(evt);
            }
        });

        jLabelLogout.setBackground(new java.awt.Color(56, 106, 179));
        jLabelLogout.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabelLogout.setForeground(new java.awt.Color(255, 255, 255));
        jLabelLogout.setText(" Log Out");
        jLabelLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelLogout.setOpaque(true);
        jLabelLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelLogoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelLogoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelLogoutMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanelMenuLayout = new javax.swing.GroupLayout(jPanelMenu);
        jPanelMenu.setLayout(jPanelMenuLayout);
        jPanelMenuLayout.setHorizontalGroup(
            jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titlePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelMenuLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelBookEquipment, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelSingleTransaction, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAllTransactions, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelMenuLayout.setVerticalGroup(
            jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMenuLayout.createSequentialGroup()
                .addComponent(titlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(jLabelBookEquipment, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelAllTransactions, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelSingleTransaction, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 316, Short.MAX_VALUE))
        );
        
        jLabelFetchAll.setBackground(new java.awt.Color(56, 106, 179));
        jLabelFetchAll.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabelFetchAll.setForeground(new java.awt.Color(255, 255, 255));
        jLabelFetchAll.setText("  Fetch Transactions");
        jLabelFetchAll.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelFetchAll.setOpaque(true);
        jLabelFetchAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelFetchAllMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelFetchAllMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelFetchAllMouseExited(evt);
            }
        });
        
        jLabelFetchSingleTransaction.setBackground(new java.awt.Color(56, 106, 179));
        jLabelFetchSingleTransaction.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabelFetchSingleTransaction.setForeground(new java.awt.Color(255, 255, 255));
        jLabelFetchSingleTransaction.setText("               Fetch Transaction");
        jLabelFetchSingleTransaction.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelFetchSingleTransaction.setOpaque(true);
        jLabelFetchSingleTransaction.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelFetchSingleTransactionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelFetchSingleTransactionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelFetchSingleTransactionMouseExited(evt);
            }
        });
        

        jLabelDashBoard.setFont(new java.awt.Font("Verdana", 0, 36)); // NOI18N
        jLabelDashBoard.setText("Customer Dashboard");

        jLabelAbsoluteAccount.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabelAbsoluteAccount.setText("Account :");

        jLabelNameAbsolute.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabelNameAbsolute.setText("Name    :");

        jLabel11.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel11.setText("????");

        jLabelNameChangeable.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabelNameChangeable.setText("????");

        jPanelMessage.setBackground(new java.awt.Color(56, 106, 179));

        jScrollPane1.setViewportView(jTextPaneSendMessage);

        jLabelSendMessage.setBackground(new java.awt.Color(56, 106, 179));
        jLabelSendMessage.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabelSendMessage.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSendMessage.setText(" Send Message");
        jLabelSendMessage.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelSendMessage.setOpaque(true);
        jLabelSendMessage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSendMessageMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelSendMessageMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelSendMessageMouseExited(evt);
            }
        });
        jLabelClearChat.setBackground(new java.awt.Color(56, 106, 179));
        jLabelClearChat.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabelClearChat.setForeground(new java.awt.Color(255, 255, 255));
        jLabelClearChat.setText(" Clear Chat");
        jLabelClearChat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelClearChat.setOpaque(true);
        jLabelClearChat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelClearChatMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelClearChatMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelClearChatMouseExited(evt);
            }
        });
        javax.swing.GroupLayout jPanelMessageLayout = new javax.swing.GroupLayout(jPanelMessage);
        jPanelMessage.setLayout(jPanelMessageLayout);
        jPanelMessageLayout.setHorizontalGroup(
            jPanelMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMessageLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabelSendMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelClearChat, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addGroup(jPanelMessageLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanelMessageLayout.setVerticalGroup(
            jPanelMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMessageLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelMessageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelClearChat, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelSendMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanelDate.setBackground(new java.awt.Color(56, 106, 179));
        jLabelPrintReceipt1.setBackground(new java.awt.Color(56, 106, 179));
        jLabelPrintReceipt1.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabelPrintReceipt1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPrintReceipt1.setText("   Print Receipt");
        jLabelPrintReceipt1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelPrintReceipt1.setOpaque(true);
        jLabelPrintReceipt1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelPrintReceipt1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelPrintReceipt1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelPrintReceipt1MouseExited(evt);
            }
        });

        jTextAreaRecieptPrint.setColumns(20);
        jTextAreaRecieptPrint.setRows(5);
        jScrollPane4.setViewportView(jTextAreaRecieptPrint);

        javax.swing.GroupLayout jPanelDateLayout = new javax.swing.GroupLayout(jPanelDate);
        jPanelDate.setLayout(jPanelDateLayout);
        jPanelDateLayout.setHorizontalGroup(
            jPanelDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDateLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDateLayout.createSequentialGroup()
                .addContainerGap(233, Short.MAX_VALUE)
                .addComponent(jLabelPrintReceipt1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(229, 229, 229))
        );
        jPanelDateLayout.setVerticalGroup(
            jPanelDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDateLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelPrintReceipt1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        javax.swing.GroupLayout jPanelParentLayout = new javax.swing.GroupLayout(jPanelParent);
        jPanelParent.setLayout(jPanelParentLayout);
        jPanelParentLayout.setHorizontalGroup(
            jPanelParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelParentLayout.createSequentialGroup()
                .addComponent(jPanelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanelParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelParentLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanelParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelParentLayout.createSequentialGroup()
                                .addGroup(jPanelParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelNameAbsolute, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelAbsoluteAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addGroup(jPanelParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabelNameChangeable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanelParentLayout.createSequentialGroup()
                                .addGroup(jPanelParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanelParentLayout.createSequentialGroup()
                                        .addComponent(jPanelDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jPanelMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(actionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 10, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelParentLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelDashBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(424, 424, 424))))
        );
        jPanelParentLayout.setVerticalGroup(
            jPanelParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelParentLayout.createSequentialGroup()
                .addGroup(jPanelParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelParentLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelParentLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabelDashBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanelParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelNameAbsolute, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelNameChangeable, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelAbsoluteAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addComponent(actionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanelParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanelMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanelDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelParent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(395, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelParent, javax.swing.GroupLayout.PREFERRED_SIZE, 978, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );
        pack();
    }                      

    //Menus Code
    //Code That Handles JLabel Book Equipment
    private void jLabelBookEquipmentMouseEntered(java.awt.event.MouseEvent evt) {                                                 
        if(evt.getSource() == jLabelBookEquipment){
            jLabelBookEquipment.setBackground(new Color(58,83,155));
        } 
    }                                                

    private void jLabelBookEquipmentMouseExited(java.awt.event.MouseEvent evt) {                                                
        if(evt.getSource() == jLabelBookEquipment){
            jLabelBookEquipment.setBackground(new Color(56,106,179));
        }   
    }  
 
    private void jLabelBookEquipmentMouseClicked(java.awt.event.MouseEvent evt) {                                                 
        if(evt.getSource() == jLabelBookEquipment) {
        	bookedEquipmentFrame();
        }   
    } 
    
    //---------------------------------------------------------------------------------------//
    //Code That Handles JLabel All Transaction
    private void jLabelAllTransactionsMouseEntered(java.awt.event.MouseEvent evt) {                                                   
        
        if(evt.getSource() == jLabelAllTransactions){
            jLabelAllTransactions.setBackground(new Color(58,83,155));
        }
    }                                                  

    private void jLabelAllTransactionsMouseExited(java.awt.event.MouseEvent evt) {                                                  
        
        if(evt.getSource() == jLabelAllTransactions){
            jLabelAllTransactions.setBackground(new Color(56,106,179));
        }
    } 

    private void jLabelAllTransactionsMouseClicked(java.awt.event.MouseEvent evt) {                                                   
        
        if(evt.getSource() == jLabelAllTransactions) {
            jLabelAllTransactions.setBackground(Color.GRAY);
            allTransactionsFrame();
        }  
    } 

    //---------------------------------------------------------------------------------------//
    //Code That Handles JLabel Single Transaction
    private void jLabelSingleTransactionMouseEntered(java.awt.event.MouseEvent evt) {                                                     
        
        if(evt.getSource() == jLabelSingleTransaction){
            jLabelSingleTransaction.setBackground(new Color(58,83,155));
        }
        
    } 
    
    private void jLabelSingleTransactionMouseExited(java.awt.event.MouseEvent evt) {                                                    
        
        if(evt.getSource() == jLabelSingleTransaction){
            jLabelSingleTransaction.setBackground(new Color(56,106,179));
        }
        
    }
    
    private void jLabelSingleTransactionMouseClicked(java.awt.event.MouseEvent evt) {                                                     
        
        if(evt.getSource() == jLabelSingleTransaction) {
            jLabelSingleTransaction.setBackground(Color.GRAY);
            singleTransactionFrame();
        }  
    }

    //---------------------------------------------------------------------------------------//
    //Code That Handles JLabel Logout
    private void jLabelLogoutMouseEntered(java.awt.event.MouseEvent evt) {                                          
        if(evt.getSource() == jLabelLogout){
            jLabelLogout.setBackground(new Color(58,83,155));
        }
    }                                         

    private void jLabelLogoutMouseExited(java.awt.event.MouseEvent evt) {                                         
    	if(evt.getSource() == jLabelLogout){
            jLabelLogout.setBackground(new Color(56,106,179));
        }
          
    }                                        
    
    private void jLabelLogoutMouseClicked(java.awt.event.MouseEvent evt) {                                          
        if(evt.getSource() == jLabelLogout) {
            jLabelLogout.setBackground(Color.GRAY);
            //create new Object of login
            this.dispose();
        }  
    }  
                                                                                                    
    //---------------------------------------------------------------------------------------//
    //Code That Handles JLabel Send Message
    private void jLabelSendMessageMouseEntered(java.awt.event.MouseEvent evt) {
        if(evt.getSource() == jLabelSendMessage){
            jLabelSendMessage.setBackground(new Color(58,83,155));
        } 
    
    }                                              

    private void jLabelSendMessageMouseExited(java.awt.event.MouseEvent evt) {                                              
        if(evt.getSource() == jLabelSendMessage){
            jLabelSendMessage.setBackground(new Color(56,106,179));
        }
    }                                             

    private void jLabelSendMessageMouseClicked(java.awt.event.MouseEvent evt) {                                                     
        if(evt.getSource() == jLabelSendMessage) {
            jLabelSendMessage.setBackground(Color.GRAY);
            JOptionPane.showMessageDialog(null, "This Link is Working",
						"Testing Status", JOptionPane.INFORMATION_MESSAGE);
        
        }    
    }                                              

    //---------------------------------------------------------------------------------------//
    //Code That Handles JLabel Clear Chat
    private void jLabelClearChatMouseEntered(java.awt.event.MouseEvent evt) {                                                   
        if(evt.getSource() == jLabelClearChat){
            jLabelClearChat.setBackground(new Color(58,83,155));
        } 
    }                                            

    private void jLabelClearChatMouseExited(java.awt.event.MouseEvent evt) {   
        if(evt.getSource() == jLabelClearChat){
            jLabelClearChat.setBackground(new Color(56,106,179));
        }
    }                                           

    private void jLabelClearChatMouseClicked(java.awt.event.MouseEvent evt) {                                             
        if(evt.getSource() == jLabelClearChat) {
            jLabelClearChat.setBackground(Color.GRAY);
            jTextPaneSendMessage.setText("");
        }  
    }                                            
    
    //---------------------------------------------------------------------------------------//
    //Code That Handles Print Receipt
    private void jLabelPrintReceipt1MouseEntered(java.awt.event.MouseEvent evt) {                                                 
    	if(evt.getSource() == jLabelPrintReceipt1){
            jLabelPrintReceipt1.setBackground(new Color(58,83,155));
        }
    }                                                

    private void jLabelPrintReceipt1MouseExited(java.awt.event.MouseEvent evt) {                                                
    	if(evt.getSource() == jLabelPrintReceipt1){
    		jLabelPrintReceipt1.setBackground(new Color(56,106,179));
        }
    } 
    
    private void jLabelPrintReceipt1MouseClicked(java.awt.event.MouseEvent evt) {                                                 
    	if(evt.getSource() == jLabelPrintReceipt1) {
    		jLabelPrintReceipt1.setBackground(Color.GRAY);
        } 
    } 

    //---------------------------------------------------------------------------------------//
    //Code That Handles Staging Mouse
    private void jLabelStagingMouseEntered(java.awt.event.MouseEvent evt) {                                           
    	if(evt.getSource() == jLabelStaging){
    		jLabelStaging.setBackground(new Color(58,83,155));
        }
    }                                          

    private void jLabelStagingMouseExited(java.awt.event.MouseEvent evt) {                                          
    	if(evt.getSource() == jLabelStaging){
    		jLabelStaging.setBackground(new Color(56,106,179));
        }
    }  
    
    private void jLabelStagingMouseClicked(java.awt.event.MouseEvent evt) {                                           
    	if(evt.getSource() == jLabelStaging) {
    		jLabelStaging.setBackground(Color.GRAY);
    		category();
        } 
    }

    //---------------------------------------------------------------------------------------//
    //Code That Handles Sound Mouse
    private void jLabelSoundMouseEntered(java.awt.event.MouseEvent evt) {                                         
    	if(evt.getSource() == jLabelSound){
    		jLabelSound.setBackground(new Color(58,83,155));
        }
    }                                        

    private void jLabelSoundMouseExited(java.awt.event.MouseEvent evt) {                                        
    	if(evt.getSource() == jLabelSound){
    		jLabelSound.setBackground(new Color(56,106,179));
        }
    }
    
    private void jLabelSoundMouseClicked(java.awt.event.MouseEvent evt) {                                         
    	if(evt.getSource() == jLabelSound) {
    		jLabelSound.setBackground(Color.GRAY);
    		category();
        }
    }                                        

    //---------------------------------------------------------------------------------------//
    //Code That Handles Power Mouse
    private void jLabelPowerMouseEntered(java.awt.event.MouseEvent evt) {                                                 
    	if(evt.getSource() == jLabelPower){
    		jLabelPower.setBackground(new Color(58,83,155));
        }
    }                                                

    private void jLabelPowerMouseExited(java.awt.event.MouseEvent evt) {                                                
    	if(evt.getSource() == jLabelPower){
    		jLabelPower.setBackground(new Color(56,106,179));
        }
    } 
    private void jLabelPowerMouseClicked(java.awt.event.MouseEvent evt) {                                            
    	if(evt.getSource() == jLabelPower) {
    		jLabelPower.setBackground(Color.GRAY);
    		category();
        }
    }
                                          
    //---------------------------------------------------------------------------------------//
    //Code That Handles Lighting Mouse
    private void jLabelLightingMouseEntered(java.awt.event.MouseEvent evt) {                                            
    	if(evt.getSource() == jLabelLighting){
    		jLabelLighting.setBackground(new Color(58,83,155));
        }
    }                                           

    private void jLabelLightingMouseExited(java.awt.event.MouseEvent evt) {                                           
    	if(evt.getSource() == jLabelLighting){
    		jLabelLighting.setBackground(new Color(56,106,179));
        }
    } 

    private void jLabelLightingMouseClicked(java.awt.event.MouseEvent evt) {                                            
    	if(evt.getSource() == jLabelLighting) {
    		jLabelLighting.setBackground(Color.GRAY);
    		category();
        }
    } 
 
    //---------------------------------------------------------------------------------------//
    //Code That Handles RentEquipment
    private void jLabelRentEquipmentMouseEntered(java.awt.event.MouseEvent evt) {                                                 
    	if(evt.getSource() == jLabelRentEquipment){
    		jLabelRentEquipment.setBackground(new Color(58,83,155));
        }
    }
    
    private void jLabelRentEquipmentMouseExited(java.awt.event.MouseEvent evt) {                                           
    	if(evt.getSource() == jLabelRentEquipment){
    		jLabelRentEquipment.setBackground(new Color(56,106,179));
        }
    } 

    private void jLabelRentEquipmentMouseClicked(java.awt.event.MouseEvent evt) {                                            
    	if(evt.getSource() == jLabelRentEquipment) {
    		jLabelRentEquipment.setBackground(Color.GRAY);
    		
        }
    }
    
      //---------------------------------------------------------------------------------------//
    //Code That Handles Fetch All
    private void jLabelFetchAllMouseEntered(java.awt.event.MouseEvent evt) {                                                 
    	if(evt.getSource() == jLabelFetchAll){
    		jLabelFetchAll.setBackground(new Color(58,83,155));
        }
    }
    
    private void jLabelFetchAllMouseExited(java.awt.event.MouseEvent evt) {                                           
    	if(evt.getSource() == jLabelFetchAll){
    		jLabelFetchAll.setBackground(new Color(56,106,179));
        }
    } 

    private void jLabelFetchAllMouseClicked(java.awt.event.MouseEvent evt) {                                            
    	if(evt.getSource() == jLabelFetchAll) {
    		jLabelFetchAll.setBackground(Color.GRAY);
    		
        }
    }
    
     //---------------------------------------------------------------------------------------//
    //Code That Handles Fetch All
    private void jLabelFetchSingleTransactionMouseEntered(java.awt.event.MouseEvent evt) {                                                 
    	if(evt.getSource() == jLabelFetchSingleTransaction){
    		jLabelFetchSingleTransaction.setBackground(new Color(58,83,155));
        }
    }
    
    private void jLabelFetchSingleTransactionMouseExited(java.awt.event.MouseEvent evt) {                                           
    	if(evt.getSource() == jLabelFetchSingleTransaction){
    		jLabelFetchSingleTransaction.setBackground(new Color(56,106,179));
        }
    } 

    private void jLabelFetchSingleTransactionMouseClicked(java.awt.event.MouseEvent evt) {                                            
    	if(evt.getSource() == jLabelFetchAll) {
    		jLabelFetchAll.setBackground(Color.GRAY);
    		
        }
    }
    
    private void bookedEquipmentFrame() {
    	resetActionPanel(); actionPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelAbsoluteAccount1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabelAbsoluteAccount1.setText("Select Category:");

        jLabelStaging.setBackground(new java.awt.Color(56, 106, 179));
        jLabelStaging.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabelStaging.setForeground(new java.awt.Color(255, 255, 255));
        jLabelStaging.setText("      Staging");
        jLabelStaging.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelStaging.setOpaque(true);
        jLabelStaging.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelStagingMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelStagingMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelStagingMouseExited(evt);
            }
        });

        jLabelSound.setBackground(new java.awt.Color(56, 106, 179));
        jLabelSound.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabelSound.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSound.setText("        Sound");
        jLabelSound.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelSound.setOpaque(true);
        jLabelSound.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSoundMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelSoundMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelSoundMouseExited(evt);
            }
        });

        jLabelPower.setBackground(new java.awt.Color(56, 106, 179));
        jLabelPower.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabelPower.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPower.setText("       Power");
        jLabelPower.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelPower.setOpaque(true);
        jLabelPower.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	jLabelPowerMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
            	jLabelPowerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
            	jLabelPowerMouseExited(evt);
            }
        });

        jLabelLighting.setBackground(new java.awt.Color(56, 106, 179));
        jLabelLighting.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabelLighting.setForeground(new java.awt.Color(255, 255, 255));
        jLabelLighting.setText("       Lighting");
        jLabelLighting.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelLighting.setOpaque(true);
        jLabelLighting.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelLightingMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelLightingMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelLightingMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabelStaging, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(151, 151, 151)
                        .addComponent(jLabelLighting, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 161, Short.MAX_VALUE)
                        .addComponent(jLabelSound, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelAbsoluteAccount1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(151, 151, 151)
                .addComponent(jLabelPower, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabelAbsoluteAccount1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelStaging, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelSound, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPower, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelLighting, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(164, 164, 164))
        );

        javax.swing.GroupLayout actionPanelLayout = new javax.swing.GroupLayout(actionPanel);
        actionPanel.setLayout(actionPanelLayout);
        actionPanelLayout.setHorizontalGroup(
            actionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(actionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        actionPanelLayout.setVerticalGroup(
            actionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(actionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    	
    }

	private void category(){
		resetActionPanel();actionPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		
		/*DefaultTableModel model = (DefaultTableModel)jTableEquipment.getModel();
		model.addRow(new Object[] {e,b,null});*/
		
    	jTableEquipment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Equipment ID", "Equipment Name", "Date Needed", "Return Date", "Availability", "Duration", "Unit Cost", "Total Cost"
            }
        ) {
			public Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
    	
    	
        jScrollPane2.setViewportView(jTableEquipment);
        if (jTableEquipment.getColumnModel().getColumnCount() > 0) {
            jTableEquipment.getColumnModel().getColumn(0).setResizable(false);
            jTableEquipment.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabelSubTotal.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabelSubTotal.setText("Sub Total: $");

        jLabelRentEquipment.setBackground(new java.awt.Color(56, 106, 179));
        jLabelRentEquipment.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabelRentEquipment.setForeground(new java.awt.Color(255, 255, 255));
        jLabelRentEquipment.setText("                          Book?");
        jLabelRentEquipment.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelRentEquipment.setOpaque(true);
        jLabelRentEquipment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelRentEquipmentMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelRentEquipmentMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelRentEquipmentMouseExited(evt);
            }
        });

        jLabelSubTotal1.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabelSubTotal1.setText("Account Balance: $");

        javax.swing.GroupLayout actionPanelLayout = new javax.swing.GroupLayout(actionPanel);
        actionPanel.setLayout(actionPanelLayout);
        actionPanelLayout.setHorizontalGroup(
            actionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(actionPanelLayout.createSequentialGroup()
                .addGroup(actionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(actionPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1276, Short.MAX_VALUE))
                    .addGroup(actionPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(actionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabelRentEquipment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(actionPanelLayout.createSequentialGroup()
                                .addGroup(actionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelSubTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addGroup(actionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextFieldSubTotal1)
                                    .addComponent(jTextFieldSubTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE))))
                        .addGap(19, 19, 19))) 
                .addContainerGap())
        );
        actionPanelLayout.setVerticalGroup(
            actionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(actionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(actionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(actionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldSubTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelSubTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addComponent(jLabelRentEquipment, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
    }
    
	private void allTransactionsFrame() {
		resetActionPanel();actionPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jTableAllEquipment.setModel(new javax.swing.table.DefaultTableModel(
	            new Object [][] {
	                {null, null, null, null, null},
	                {null, null, null, null, null},
	                {null, null, null, null, null},
	                {null, null, null, null, null},
	                {null, null, null, null, null},
	                {null, null, null, null, null},
	                {null, null, null, null, null},
	                {null, null, null, null, null},
	                {null, null, null, null, null},
	                {null, null, null, null, null},
	                {null, null, null, null, null},
	                {null, null, null, null, null},
	                {null, null, null, null, null},
	                {null, null, null, null, null},
	                {null, null, null, null, null},
	                {null, null, null, null, null},
	                {null, null, null, null, null},
	                {null, null, null, null, null},
	                {null, null, null, null, null},
	                {null, null, null, null, null}
	            },
	            new String [] {
	                "Equipment ID", "Equipment Name", "Date Rented", "Date Returned", "Cost"
	            }
	        ) {
	            Class[] types = new Class [] {
	                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
	            };

	            public Class getColumnClass(int columnIndex) {
	                return types [columnIndex];
	            }
	        });
	        jScrollPane2.setViewportView(jTableAllEquipment);

	        javax.swing.GroupLayout actionPanelLayout = new javax.swing.GroupLayout(actionPanel);
	        actionPanel.setLayout(actionPanelLayout);
	        actionPanelLayout.setHorizontalGroup(
	            actionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(actionPanelLayout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(actionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(actionPanelLayout.createSequentialGroup()
	                        .addComponent(jLabelFetchAll, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addGap(0, 1026, Short.MAX_VALUE))
	                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1276, Short.MAX_VALUE))
	                .addContainerGap())
	        );
	        actionPanelLayout.setVerticalGroup(
	            actionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(actionPanelLayout.createSequentialGroup()
	                .addGap(9, 9, 9)
	                .addComponent(jLabelFetchAll, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
	                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGap(18, 18, 18))
	        );
		
	}
	
	private void singleTransactionFrame() {
		
		resetActionPanel();actionPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jLabelTransactionNumber.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabelTransactionNumber.setText("Transaction Number:");

        jTableSingleEquipment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Equipment ID", "Equipment Name", "Date Rented", "Date Returned", "Cost"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTableSingleEquipment);

        javax.swing.GroupLayout actionPanelLayout = new javax.swing.GroupLayout(actionPanel);
        actionPanel.setLayout(actionPanelLayout);
        actionPanelLayout.setHorizontalGroup(
            actionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(actionPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(actionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1276, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(actionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabelFetchSingleTransaction, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(actionPanelLayout.createSequentialGroup()
                            .addComponent(jLabelTransactionNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jTextFieldTransactionNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        actionPanelLayout.setVerticalGroup(
            actionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(actionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(actionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTransactionNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldTransactionNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelFetchSingleTransaction, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
		
	}
	
	private void resetActionPanel() {
        actionPanel.removeAll();// Remove all components from actionPanel
        actionPanel.repaint();// Repaint and validate the panel to reflect the changes
        actionPanel.revalidate();
    }

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientDashboard().setVisible(true);
            }
        });
    }                   
                  
}
