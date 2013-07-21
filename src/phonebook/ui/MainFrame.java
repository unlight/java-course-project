package phonebook.ui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.UIManager;
import phonebook.Application;
import phonebook.DateCellRenderer;
import phonebook.EntryTable;
import phonebook.EntryTableModel;
import phonebook.listener.RemoveEntryActionListener;

/**
 * @author S
 */
public class MainFrame extends javax.swing.JFrame {

    public MainFrame() {
        initComponents();
        postInit();
    }

    private void postInit() {
        final MainFrame frame = this;
        addEntryMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddEntryDialog(frame, false).setVisible(true);
            }
        });
        entryTable.setModel(new EntryTableModel());
        entryTable.getColumnModel().getColumn(3).setCellRenderer(new DateCellRenderer());
		entryTable.setIntercellSpacing(new Dimension(5, 5));
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        mainScrollPane = new javax.swing.JScrollPane();
        entryTable = new EntryTable(new EntryTableModel());
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

        entryTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                entryTableMouseClicked(evt);
            }
        });
        mainScrollPane.setViewportView(entryTable);

        fileMenu.setText("Файл");

        exitMenuItem.setText("Выход");
        fileMenu.add(exitMenuItem);

        mainMenuBar.add(fileMenu);

        entryMenu.setText("Записи");

        addEntryMenuItem.setText("Добавить");
        entryMenu.add(addEntryMenuItem);

        editEntryMenuItem.setText("Редактировать");
        editEntryMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editEntryMenuItemActionPerformed(evt);
            }
        });
        entryMenu.add(editEntryMenuItem);

        removeEntryMenuItem.setText("Удалить");
        removeEntryMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeEntryMenuItemActionPerformed(evt);
            }
        });
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
            .addComponent(mainScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
        );

        pack();
    }//GEN-END:initComponents

    private void entryTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_entryTableMouseClicked
        if (evt.getClickCount() == 2) {
            EntryTable target = (EntryTable) evt.getSource();
            int rowID = target.getEntityId();
            openEditWindow(rowID);
        }
    }//GEN-LAST:event_entryTableMouseClicked

    private void editEntryMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editEntryMenuItemActionPerformed
        int rowID = ((EntryTable) entryTable).getEntityId();
        openEditWindow(rowID);
    }//GEN-LAST:event_editEntryMenuItemActionPerformed

    private void removeEntryMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeEntryMenuItemActionPerformed
        new RemoveEntryActionListener().actionPerformed(evt);
    }//GEN-LAST:event_removeEntryMenuItemActionPerformed

    private void openEditWindow(int id) {
        new EditEntryDialog(id, this, false).setVisible(true);
    }

    public static void main(String args[]) {
        Application application = Application.getInstance();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        MainFrame frame = new MainFrame();
        application.setMainFrame(frame);
        frame.setVisible(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem addEntryMenuItem;
    private javax.swing.JMenuItem editEntryMenuItem;
    private javax.swing.JMenu entryMenu;
    public javax.swing.JTable entryTable;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenuBar mainMenuBar;
    private javax.swing.JScrollPane mainScrollPane;
    private javax.swing.JMenuItem removeEntryMenuItem;
    // End of variables declaration//GEN-END:variables
}
