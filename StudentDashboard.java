package ui;

import javax.swing.*;
import services.DataStore;

public class StudentDashboard extends JFrame {

    public StudentDashboard() {
        setTitle("Student Dashboard - Cooking Learning System");
        setSize(500, 400);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel label = new JLabel("Available Recipes:");
        label.setBounds(20, 10, 200, 30);
        add(label);

        DefaultListModel<String> model = new DefaultListModel<>();
        DataStore.recipes.forEach(r -> model.addElement(r.getTitle()));

        JList<String> recipeList = new JList<>(model);
        JScrollPane scrollPane = new JScrollPane(recipeList);
        scrollPane.setBounds(20, 50, 300, 250);
        add(scrollPane);

        JButton viewBtn = new JButton("View Recipe");
        viewBtn.setBounds(350, 100, 120, 30);
        add(viewBtn);

        viewBtn.addActionListener(e -> {
            int index = recipeList.getSelectedIndex();
            if (index >= 0) {
                new RecipeDetailsUI(DataStore.recipes.get(index));
            } else {
                JOptionPane.showMessageDialog(this, "Please select a recipe first.");
            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
