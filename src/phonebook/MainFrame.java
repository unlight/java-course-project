package phonebook;

import javax.swing.UIManager;

/**
 * @author S
 */
public class MainFrame extends javax.swing.JFrame {

    public MainFrame() {
	  initComponents();
	  initEvents();
    }

    private void initEvents() {
	  addEntryMenuItem.addActionListener(new AddEntryDialog(this, true));
	  mainTable.setModel(new EntryTableModel());
//	  mainTable.addMouseListener(null);
	  
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainScrollPane = new javax.swing.JScrollPane();
        mainTable = new javax.swing.JTable();
        mainMenuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        exitMenuItem = new javax.swing.JMenuItem();
        entryMenu = new javax.swing.JMenu();
        addEntryMenuItem = new javax.swing.JMenuItem();
        editEntryMenuItem = new javax.swing.JMenuItem();
        removeEntryMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(640, 480));

        mainScrollPane.setViewportView(mainTable);

        fileMenu.setText("Файл");

        exitMenuItem.setText("Выход");
        fileMenu.add(exitMenuItem);

        mainMenuBar.add(fileMenu);

        entryMenu.setText("Записи");

        addEntryMenuItem.setText("Добавить");
        entryMenu.add(addEntryMenuItem);

        editEntryMenuItem.setText("Редактировать");
        entryMenu.add(editEntryMenuItem);

        removeEntryMenuItem.setText("Удалить");
        entryMenu.add(removeEntryMenuItem);

        mainMenuBar.add(entryMenu);

        helpMenu.setText("Помощь");

        aboutMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        aboutMenuItem.setText("Помощь");
        helpMenu.add(aboutMenuItem);

        mainMenuBar.add(helpMenu);

        setJMenuBar(mainMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

	  try {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	  } catch (Exception e) {
		e.printStackTrace();
	  }
	  Application application = Application.getInstance();
	  MainFrame frame = new MainFrame();
	  try {
		application.bootstrap();
	  } catch (Exception e) {
		application.handleException(e);
	  }
	  frame.setVisible(true);
	  // Добавляем компоненты.
//	  frame.setTitle(this.name + " " + version);
//	  frame.pack();
//	  frame.setVisible(true);
//	  frame.addWindowListener(new ApplicationWindowListener(this));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem addEntryMenuItem;
    private javax.swing.JMenuItem editEntryMenuItem;
    private javax.swing.JMenu entryMenu;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenuBar mainMenuBar;
    private javax.swing.JScrollPane mainScrollPane;
    private javax.swing.JTable mainTable;
    private javax.swing.JMenuItem removeEntryMenuItem;
    // End of variables declaration//GEN-END:variables
}
