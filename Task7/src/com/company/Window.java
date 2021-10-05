package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

import static javax.swing.JOptionPane.showMessageDialog;

public class Window  extends JFrame {

    JTabbedPane tabbedPane = new JTabbedPane();
    JPanel panel1 = new JPanel();
    JPanel panel1Lb = new JPanel();
    JPanel panel1Btn = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel2Lb = new JPanel();
    JPanel panel2Btn = new JPanel();
    JPanel panel3 = new JPanel();
    JPanel panel3Lb = new JPanel();
    JPanel panel3Btn = new JPanel();
    JPanel panel4 = new JPanel();
    JPanel panel4Btn = new JPanel();
    JPanel panel4Tab = new JPanel();

    //Tab 1 textField
    JTextField storeNTF = new JTextField();
    JTextField storeCityTF = new JTextField();
    //Tab 2 textField
    JTextField sellerLastNameTF = new JTextField();
    JTextField sellerFirstNameTF = new JTextField();
    JTextField sellerExperienceTF = new JTextField();
    //Tab 3 textField
    JTextField goodsIdTF = new JTextField();
    JTextField goodsTotalTF = new JTextField();

    //Tab 1 comboBox
    JComboBox sellerComboBoxPanel1 = new JComboBox();
    //Tab2 comboBox
    JComboBox storeComboBoxPanel2 = new JComboBox();
    JComboBox sellerComboBoxPanel2 = new JComboBox();
    //Tab3 comboBox
    JComboBox storeComboBoxPanel3 = new JComboBox();
    JComboBox sellerComboBoxPanel3 = new JComboBox();
    JComboBox purchaseComboBoxPanel3 = new JComboBox();

    //Tab 1 buttons
    JButton sellerAddButton = new JButton("Додати");
    JButton sellerDelButton = new JButton("Видалити");
    JButton sellerEditButton = new JButton("Редагувати");
    JButton sellerLoadButton = new JButton("Завантажити з файла");
    JButton sellerSaveButton = new JButton("Зберегти у файл");
    //Tab 2 buttons
    JButton storeAddButton = new JButton("Додати");
    JButton storeDelButton = new JButton("Видалити");
    JButton storeEditButton = new JButton("Редагувати");
    JButton storeLoadButton = new JButton("Завантажити з файла");
    JButton storeSaveButton = new JButton("Зберегти у файл");
    JButton addSellerButton = new JButton("Додати продавця");
    //Tab 3 buttons
    JButton purchaseAddButton = new JButton("Додати");
    JButton purchaseDelButton = new JButton("Видалити");
    JButton purchaseEditButton = new JButton("Редагувати");
    JButton purchaseLoadButton = new JButton("Завантажити з файла");
    JButton purchaseSaveButton = new JButton("Зберегти у файл");
    //Tab 4 buttons
    JButton sortButton = new JButton("Сортувати");

    ArrayList<Store> chainStores = new ArrayList<>();
    ArrayList<Seller> sellers = new ArrayList<>();
    ArrayList<Purchase> purchases = new ArrayList<>();

    String[] col = {"№ магазину", "Місто", "Прізвище продавця", "Ім'я продавця", "Стаж", "ID покупки", "Сума покупки"};
    DefaultTableModel tableModel = new DefaultTableModel(col, 0);

    JTable table = new JTable(tableModel);

    public Window() {
        super("Мережа магазинів");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(400, 100, 850, 400);
        this.add(tabbedPane);

        tabbedPane.addTab("Продавець", panel1);
        tabbedPane.addTab("Магазин", panel2);
        tabbedPane.addTab("Покупка", panel3);
        tabbedPane.addTab("Таблиця", panel4);

        //Tab 1 layouts
        panel1.setLayout(new GridLayout(2, 1, 1, 5));
        panel1Lb.setLayout(new GridLayout(4, 2, 1, 5));
        panel1Btn.setLayout(new GridLayout(2, 3, 1, 5));
        //Tab 2 layouts
        panel2.setLayout(new GridLayout(2, 1, 1, 5));
        panel2Lb.setLayout(new GridLayout(4, 2, 1, 5));
        panel2Btn.setLayout(new GridLayout(2, 3, 1, 5));
        //Tab 3 layout
        panel3.setLayout(new GridLayout(2, 1, 1, 5));
        panel3Lb.setLayout(new GridLayout(5, 2, 1, 5));
        panel3Btn.setLayout(new GridLayout(2, 3, 1, 5));
        //Tab 4
        panel4.setLayout(new GridLayout(2, 1, 1, 5));
        panel4Tab.setLayout(new GridLayout(1, 1, 1,5));
        panel4Btn.setLayout(new GridLayout(3, 1, 1,5));

        //Tab 1 add
        panel1Lb.add(new JLabel("Прізвище продавця", SwingConstants.CENTER));
        panel1Lb.add(sellerLastNameTF);
        panel1Lb.add(new JLabel("Ім'я продавця", SwingConstants.CENTER));
        panel1Lb.add(sellerFirstNameTF);
        panel1Lb.add(new JLabel("Стаж продавця", SwingConstants.CENTER));
        panel1Lb.add(sellerExperienceTF);
        panel1Lb.add(new JLabel("Список продавців", SwingConstants.CENTER));
        panel1Lb.add(sellerComboBoxPanel1);
        panel1.add(panel1Lb);
        panel1.add(panel1Btn);
        panel1Btn.add(sellerAddButton);
        panel1Btn.add(sellerDelButton);
        panel1Btn.add(sellerEditButton);
        panel1Btn.add(sellerSaveButton);
        panel1Btn.add(sellerLoadButton);
        //Tab 2 add
        panel2Lb.add(new JLabel("Список продавців", SwingConstants.CENTER));
        panel2Lb.add(sellerComboBoxPanel2);
        panel2Lb.add(new JLabel("Номер магазину", SwingConstants.CENTER));
        panel2Lb.add(storeNTF);
        panel2Lb.add(new JLabel("Місто", SwingConstants.CENTER));
        panel2Lb.add(storeCityTF);
        panel2Lb.add(new JLabel("Список магазинів", SwingConstants.CENTER));
        panel2Lb.add(storeComboBoxPanel2);
        panel2.add(panel2Lb);
        panel2.add(panel2Btn);
        panel2Btn.add(storeAddButton);
        panel2Btn.add(storeDelButton);
        panel2Btn.add(storeEditButton);
        panel2Btn.add(storeSaveButton);
        panel2Btn.add(storeLoadButton);
        panel2Btn.add(addSellerButton);
        //Tab 3 add
        panel3Lb.add(new JLabel("Список магазинів", SwingConstants.CENTER));
        panel3Lb.add(storeComboBoxPanel3);
        panel3Lb.add(new JLabel("Список продавців", SwingConstants.CENTER));
        panel3Lb.add(sellerComboBoxPanel3);
        panel3Lb.add(new JLabel("ID покупки", SwingConstants.CENTER));
        panel3Lb.add(goodsIdTF);
        panel3Lb.add(new JLabel("Загальна сума покупки", SwingConstants.CENTER));
        panel3Lb.add(goodsTotalTF);
        panel3Lb.add(new JLabel("Список покупок", SwingConstants.CENTER));
        panel3Lb.add(purchaseComboBoxPanel3);
        panel3.add(panel3Lb);
        panel3.add(panel3Btn);
        panel3Btn.add(purchaseAddButton);
        panel3Btn.add(purchaseDelButton);
        panel3Btn.add(purchaseEditButton);
        panel3Btn.add(purchaseSaveButton);
        panel3Btn.add(purchaseLoadButton);

        storeNTF.addKeyListener(intKeyListener);
        sellerExperienceTF.addKeyListener(intKeyListener);
        goodsIdTF.addKeyListener(intKeyListener);
        goodsTotalTF.addKeyListener(doubleKeyListener);

        storeNTF.setHorizontalAlignment(JTextField.CENTER);
        storeCityTF.setHorizontalAlignment(JTextField.CENTER);
        sellerLastNameTF.setHorizontalAlignment(JTextField.CENTER);
        sellerFirstNameTF.setHorizontalAlignment(JTextField.CENTER);
        sellerExperienceTF.setHorizontalAlignment(JTextField.CENTER);
        goodsIdTF.setHorizontalAlignment(JTextField.CENTER);
        goodsTotalTF.setHorizontalAlignment(JTextField.CENTER);

        table.setRowHeight(24);
        panel4Tab.add(table);
        panel4Tab.add(new JScrollPane(table));
        panel4Tab.add(table.getTableHeader());
        table.setDefaultEditor(Object.class, null);
        panel4Btn.add(sortButton);
        panel4.add(panel4Tab);
        panel4.add(panel4Btn);


        //Seller
        sellerAddButton.addActionListener(ae -> {
            if(!sellerLastNameTF.getText().isEmpty()
                    && !sellerFirstNameTF.getText().isEmpty()
                    && !sellerExperienceTF.getText().isEmpty()) {
                sellers.add(new Seller(sellerLastNameTF.getText(), sellerFirstNameTF.getText(),
                        Integer.parseInt(sellerExperienceTF.getText())));

                sellerLastNameTF.setText("");
                sellerFirstNameTF.setText("");
                sellerExperienceTF.setText("");
                UpdateSellerPanel12();
            }
            else
                showMessageDialog(null, "Заповніть всі поля вводу значеннями");
        });
        sellerDelButton.addActionListener(ae -> {
            if(sellerComboBoxPanel1.getSelectedIndex() == -1)
                showMessageDialog(null, "Виберіть елемент для видалення");
            else {
                sellers.remove(sellerComboBoxPanel1.getSelectedIndex());
                UpdateSellerPanel12();
            }
        });
        sellerEditButton.addActionListener(ae -> {
            if(sellerComboBoxPanel1.getSelectedIndex() == -1)
                showMessageDialog(null, "Виберіть елемент для редагування");
            else {
                if (!sellerLastNameTF.getText().isEmpty()
                        && !sellerFirstNameTF.getText().isEmpty()
                        && !sellerExperienceTF.getText().isEmpty()) {
                    sellers.set(sellerComboBoxPanel1.getSelectedIndex(),
                            new Seller(sellerLastNameTF.getText(), sellerFirstNameTF.getText(),
                                    Integer.parseInt(sellerExperienceTF.getText())));

                    sellerLastNameTF.setText("");
                    sellerFirstNameTF.setText("");
                    sellerExperienceTF.setText("");
                    UpdateSellerPanel12();
                    showMessageDialog(null, "Запис редаговано");
                } else
                    showMessageDialog(null, "Заповніть всі поля вводу значеннями");
            }
        });
        sellerSaveButton.addActionListener(ae -> {
            if(sellers.size() == 0)
                showMessageDialog(null, "Немає жодного запису для збереження");
            else {
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("seller.dat"))) {
                    oos.writeObject(sellers);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
                showMessageDialog(null, "Записи збережено у файл");
            }
        });
        sellerLoadButton.addActionListener(ae -> {
            ArrayList<Seller> list = new ArrayList<>();

            try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("seller.dat")))
            {
                list =(ArrayList<Seller>) ois.readObject();
            }
            catch(Exception ex){ System.out.println(ex.getMessage()); }

            if(list.size() == 0)
                showMessageDialog(null, "Файл пустий або його не існує");
            else {
                sellers = list;
                UpdateSellerPanel12();
                showMessageDialog(null, "Записи з файла успішно завантажено");
            }
        });
        //Store
        storeAddButton.addActionListener(ae -> {
            if(!storeNTF.getText().isEmpty()
                    && !storeCityTF.getText().isEmpty()
                    && !(sellerComboBoxPanel2.getSelectedIndex() == -1)) {
                chainStores.add(new Store(Integer.parseInt(storeNTF.getText()),
                        storeCityTF.getText(), sellers.get(sellerComboBoxPanel2.getSelectedIndex())));

                sellers.remove(sellerComboBoxPanel2.getSelectedIndex());
                storeNTF.setText("");
                storeCityTF.setText("");
                UpdateSellerPanel12();
                UpdateStorePanel23();
            }
            else
                showMessageDialog(null, "Заповніть всі поля вводу значеннями");
        });
        addSellerButton.addActionListener(ae -> {
            if(storeComboBoxPanel2.getSelectedIndex() == -1 || sellerComboBoxPanel2.getSelectedIndex() == -1)
                showMessageDialog(null, "Виберіть магазин та продавця");
            else
            {
                chainStores.get(storeComboBoxPanel2.getSelectedIndex()).setSellers(sellers.get(sellerComboBoxPanel2.getSelectedIndex()));
                sellers.remove(sellerComboBoxPanel2.getSelectedIndex());
                UpdateSellerPanel12();
                UpdateStorePanel23();
            }
        });
        storeDelButton.addActionListener(ae -> {
            if(storeComboBoxPanel2.getSelectedIndex() == -1)
                showMessageDialog(null, "Виберіть елемент для видалення");
            else {
                for(Seller item : chainStores.get(storeComboBoxPanel2.getSelectedIndex()).getSellers())
                {
                    sellers.add(item);
                }
                chainStores.remove(storeComboBoxPanel2.getSelectedIndex());
                UpdateStorePanel23();
                UpdateSellerPanel12();
            }
        });
        storeEditButton.addActionListener(ae -> {
            if(storeComboBoxPanel2.getSelectedIndex() == -1)
                showMessageDialog(null, "Заповніть всі поля вводу значеннями");
            else {
                if (!storeNTF.getText().isEmpty() && !storeCityTF.getText().isEmpty()) {
                    chainStores.get(storeComboBoxPanel2.getSelectedIndex()).EditStore(
                            Integer.parseInt(storeNTF.getText()), storeCityTF.getText());

                    storeNTF.setText("");
                    storeCityTF.setText("");
                    UpdateStorePanel23();
                } else
                    showMessageDialog(null, "Заповніть всі поля вводу значеннями");
            }
        });
        storeSaveButton.addActionListener(ae -> {
            if(chainStores.size() == 0)
                showMessageDialog(null, "Немає жодного запису для збереження");
            else {
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("store.dat"))) {
                    oos.writeObject(chainStores);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
                showMessageDialog(null, "Записи збережено у файл");
            }
        });
        storeLoadButton.addActionListener(ae -> {
            ArrayList<Store> list = new ArrayList<>();

            try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("store.dat")))
            {
                list =(ArrayList<Store>) ois.readObject();
            }
            catch(Exception ex){ System.out.println(ex.getMessage()); }

            if(list.size() == 0)
                showMessageDialog(null, "Файл пустий або його не існує");
            else {
                chainStores = list;
                for (Store item : chainStores)
                    for (Seller seller : item.getSellers())
                        sellers.add(seller);

                UpdatePurchasePanel3();
                UpdateStorePanel23();
                UpdateSellerPanel12();
                showMessageDialog(null, "Записи з файла успішно завантажено");
            }
        });
        //Purchase
        purchaseAddButton.addActionListener(ae -> {
            if(!goodsIdTF.getText().isEmpty()
                    && !goodsTotalTF.getText().isEmpty()
                    && !(storeComboBoxPanel3.getSelectedIndex() == -1)
                    && !(sellerComboBoxPanel3.getSelectedIndex() == -1)) {
                purchases.add(new Purchase(Integer.parseInt(goodsIdTF.getText()), Double.parseDouble(goodsTotalTF.getText()),
                        chainStores.get(storeComboBoxPanel3.getSelectedIndex()),
                        chainStores.get(storeComboBoxPanel3.getSelectedIndex()).getSellers().get(sellerComboBoxPanel3.getSelectedIndex())));

                goodsIdTF.setText("");
                goodsTotalTF.setText("");
                UpdatePurchasePanel3();
                UpdateTable();

            }
            else
                showMessageDialog(null, "Заповніть всі поля вводу значеннями");
        });
        purchaseDelButton.addActionListener(ae -> {
            if(purchaseComboBoxPanel3.getSelectedIndex() == -1)
                showMessageDialog(null, "Виберіть елемент для видалення");
            else {
                purchases.remove(purchaseComboBoxPanel3.getSelectedIndex());
                UpdatePurchasePanel3();
                UpdateTable();
            }
        });
        purchaseEditButton.addActionListener(ae -> {
            if(sellerComboBoxPanel3.getSelectedIndex() == -1)
                showMessageDialog(null, "Виберіть елемент для редагування");
            else {
                if (!goodsIdTF.getText().isEmpty()
                        && !goodsTotalTF.getText().isEmpty()
                        && !(purchaseComboBoxPanel3.getSelectedIndex() == -1)) {
                    purchases.set(purchaseComboBoxPanel3.getSelectedIndex(),
                            new Purchase(Integer.parseInt(goodsIdTF.getText()), Double.parseDouble(goodsTotalTF.getText()),
                                    chainStores.get(storeComboBoxPanel3.getSelectedIndex()),
                                    chainStores.get(storeComboBoxPanel3.getSelectedIndex()).getSellers().get(sellerComboBoxPanel3.getSelectedIndex())));

                    sellerLastNameTF.setText("");
                    sellerFirstNameTF.setText("");
                    sellerExperienceTF.setText("");
                    UpdatePurchasePanel3();
                    UpdateTable();
                } else
                    showMessageDialog(null, "Заповніть всі поля вводу значеннями");
            }
        });
        purchaseSaveButton.addActionListener(ae -> {
            if(purchases.size() == 0)
                showMessageDialog(null, "Немає жодного запису для збереження");
            else {
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("purchase.dat"))) {
                    oos.writeObject(purchases);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
                showMessageDialog(null, "Записи збережено у файл");
            }
        });
        purchaseLoadButton.addActionListener(ae -> {
            ArrayList<Purchase> list = new ArrayList<>();

            try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("purchase.dat")))
            {
                list =(ArrayList<Purchase>) ois.readObject();
            }
            catch(Exception ex){ System.out.println(ex.getMessage()); }

            if(list.size() == 0)
                showMessageDialog(null, "Файл пустий або його не існує");
            else {
                purchases = list;
                for (Purchase item : purchases)
                {
                    chainStores.add(item.getStore());
                    sellers.add(item.getSeller());
                }
                UpdatePurchasePanel3();
                UpdateStorePanel23();
                UpdateSellerPanel12();
                UpdateTable();
                showMessageDialog(null, "Записи з файла успішно завантажено");
            }
        });

        storeComboBoxPanel3.addActionListener(ae -> {
            UpdateSellerPanel3();
        });

        sortButton.addActionListener(ae -> {
            Collections.sort(purchases);
            UpdateTable();
        });
    }

    public void UpdateSellerPanel12() {
        sellerComboBoxPanel1.removeAllItems();
        sellerComboBoxPanel2.removeAllItems();
        for(Seller item : sellers) {
            sellerComboBoxPanel1.addItem(item.toString());
            sellerComboBoxPanel2.addItem(item.toString());
        }
        sellerComboBoxPanel1.setSelectedIndex(-1);
        sellerComboBoxPanel2.setSelectedIndex(-1);
    }

    public void UpdateStorePanel23() {
        storeComboBoxPanel2.removeAllItems();
        storeComboBoxPanel3.removeAllItems();
        for(Store item : chainStores) {
            storeComboBoxPanel2.addItem(item.toString());
            storeComboBoxPanel3.addItem(item.toString());
        }
        storeComboBoxPanel2.setSelectedIndex(-1);
    }

    public void UpdatePurchasePanel3() {
        purchaseComboBoxPanel3.removeAllItems();
        for(Purchase item : purchases) {
            purchaseComboBoxPanel3.addItem(item.toString());
        }
        purchaseComboBoxPanel3.setSelectedIndex(-1);
    }

    public void UpdateSellerPanel3() {
        if (storeComboBoxPanel3.getSelectedIndex() == -1)
            return;
        else {
            sellerComboBoxPanel3.removeAllItems();
            for (Seller item : chainStores.get(storeComboBoxPanel3.getSelectedIndex()).getSellers()) {
                sellerComboBoxPanel3.addItem(item.toString());
            }
        }
    }

    public void UpdateTable() {
        for (int i = tableModel.getRowCount() - 1; i >= 0; i--)
            tableModel.removeRow(i);

        for (Purchase item : purchases) {
            Object[] object = {item.getStore().getStoreN(), item.getStore().getCity(),
                    item.getSeller().getLastName(), item.getSeller().getFirstName(),
                    item.getSeller().getExperience(), item.getId(), item.getTotalCost()};
            tableModel.addRow(object);
        }
    }

    KeyListener intKeyListener = new KeyAdapter() {
        public void keyTyped(KeyEvent e) {
            char c = e.getKeyChar();
            if (!((c >= '0') && (c <= '9') ||
                    (c == KeyEvent.VK_BACK_SPACE) ||
                    (c == KeyEvent.VK_DELETE))) {
                getToolkit().beep();
                e.consume();
            }
        }
    };

    KeyListener doubleKeyListener = new KeyAdapter() {
        public void keyTyped(KeyEvent e) {
            char c = e.getKeyChar();
            if (!((c >= '0') && (c <= '9') || (c == '.') ||
                    (c == KeyEvent.VK_BACK_SPACE) ||
                    (c == KeyEvent.VK_DELETE))) {
                getToolkit().beep();
                e.consume();
            }
        }
    };
}
