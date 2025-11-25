package ui;

import javax.swing.*;
import models.Recipe;

public class RecipeDetailsUI extends JFrame {

    public RecipeDetailsUI(Recipe recipe) {
        setTitle("Recipe - " + recipe.getTitle());
        setSize(450, 500);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel titleLabel = new JLabel(recipe.getTitle(), SwingConstants.CENTER);
        titleLabel.setBounds(50, 10, 330, 30);
        add(titleLabel);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setText("INGREDIENTS:\n" + recipe.getIngredients() +
                "\n\nSTEPS:\n" + recipe.getSteps());
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(20, 50, 400, 380);
        add(scrollPane);

        setVisible(true);
    }
}
