/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.corejavabac.adv;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ToDoListApp {
    private JFrame f;
    private JTextField TField;
    private DefaultListModel<String> TListModel;
    private JList<String> TList;
    private JButton B_add, B_delete, B_complete;

    public ToDoListApp() {
        f = new JFrame("To-Do List");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(400, 300);
        f.setLayout(new BorderLayout());

        // Title Panel
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(Color.decode("#960018"));
        JLabel titleLabel = new JLabel("TO-DO List", JLabel.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 24));
        titleLabel.setForeground(Color.WHITE);
        titlePanel.add(titleLabel);
        f.add(titlePanel, BorderLayout.NORTH);
        
        TField = new JTextField(15);
        
        //Add Button 
        B_add = new JButton("Add Task");
        B_add.setBackground(Color.decode("#c24737"));
        B_add.setFont(new Font("Serif",Font.PLAIN, 16));
        B_add.setForeground(Color.WHITE);
        
        //Add Button Event
        B_add.addActionListener(e -> {
            String task = TField.getText();
            if (!task.isEmpty()) {
                TListModel.addElement(task);
                TField.setText("");
            }
        });
        
        //Delete Button
        B_delete = new JButton("Delete Task");
        B_delete.setBackground(Color.decode("#c24737"));
        B_delete.setFont(new Font("Serif", Font.PLAIN, 16));
        B_delete.setForeground(Color.WHITE);
        
        //Delete Button Event
        B_delete.addActionListener(e -> {
            int selectedIndex = TList.getSelectedIndex();
            if (selectedIndex != -1) {
                TListModel.remove(selectedIndex);
            }
        });
        
        //Task Complete Button
        B_complete = new JButton("Mark Complete");
        B_complete.setBackground(Color.decode("#c24737"));
        B_complete.setFont(new Font("Serif", Font.PLAIN, 16));
        B_complete.setForeground(Color.WHITE);
        
        //Task Complete Button Event
        B_complete.addActionListener(e -> {
            int selectedIndex = TList.getSelectedIndex();
            if (selectedIndex != -1) {
                String task = TListModel.getElementAt(selectedIndex);
                TListModel.set(selectedIndex, task + " - Completed");
            }
        });
        
        TListModel = new DefaultListModel<>();
        TList = new JList<>(TListModel);
        
        //Body Pabel
        JPanel bodypanel = new JPanel();
        bodypanel.setLayout(new BorderLayout());
        f.add(bodypanel,BorderLayout.CENTER);
        
        //Input Panel
        JPanel inputPanel = new JPanel();
        inputPanel.setBackground(Color.decode("#dc9188"));
        inputPanel.add(TField, BorderLayout.WEST);
        inputPanel.add(B_add, BorderLayout.EAST);
        bodypanel.add(inputPanel, BorderLayout.NORTH);
        
        //ScrollPanel
        bodypanel.add(new JScrollPane(TList), BorderLayout.CENTER);
        
        //ButtonPanel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.decode("#dc9188"));
        JPanel Panel = new JPanel();
        Panel.setBackground(Color.decode("#dc9188"));
        Panel.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 0));
        buttonPanel.add(Panel);
        Panel.add(B_delete);
        Panel.add(B_complete);
        bodypanel.add(buttonPanel, BorderLayout.SOUTH);
        
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new ToDoListApp();        
    }
}
