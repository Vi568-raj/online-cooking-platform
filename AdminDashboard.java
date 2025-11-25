package ui;

import javax.swing.*;
import models.Recipe;
import services.DataStore;

public class AdminDashboard extends JFrame {

    public AdminDashboard() {
        setTitle("Admin Dashboard - Cooking Learning System");
        setSize(550, 400);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel label = new JLabel("Manage Recipes:");
        label.setBounds(20, 10, 200, 30);
        add(label);

        DefaultListModel<String> model = new DefaultListModel<>();
        DataStore.recipes.forEach(r -> model.addElement(r.getTitle()));

        JList<String> recipeList = new JList<>(model);
        JScrollPane scrollPane = new JScrollPane(recipeList);
        scrollPane.setBounds(20, 50, 300, 250);
        add(scrollPane);

        JButton addBtn = new JButton("Add Recipe");
        addBtn.setBounds(350, 80, 150, 30);
        add(addBtn);

        JButton viewBtn = new JButton("View Recipe");
        viewBtn.setBounds(350, 130, 150, 30);
        add(viewBtn);

        addBtn.addActionListener(e -> {
            String title = JOptionPane.showInputDialog(this, "Recipe Title:");
            if (title != null && !title.trim().isEmpty()) {
                String ingredients = JOptionPane.showInputDialog(this, "Ingredients:");
                String steps = JOptionPane.showInputDialog(this, "Steps:");
                Recipe r = new Recipe(title, ingredients, steps);
                DataStore.recipes.add(r);
                model.addElement(r.getTitle());
            }
        });

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
