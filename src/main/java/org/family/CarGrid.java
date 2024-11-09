package org.family;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarGrid extends JFrame {
    private static final int GRID_SIZE = 5;
    private JButton[][] gridButtons = new JButton[GRID_SIZE][GRID_SIZE];
    private int carRow = 2; // starting position
    private int carCol = 2; // starting position
    private String direction = "UP"; // default direction

    public CarGrid() {
        setTitle("Car Grid Simulation");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel for the grid
        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(GRID_SIZE, GRID_SIZE));

        // Initialize buttons and add to grid
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                gridButtons[row][col] = new JButton();
                gridButtons[row][col].setFocusable(false);
                gridPanel.add(gridButtons[row][col]);
            }
        }

        add(gridPanel, BorderLayout.CENTER);

        // Initialize car display
        updateCarDisplay();

    }

    // Method to update car position
    private void updateCarDisplay() {
        // Clear all buttons
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                gridButtons[row][col].setText("");
            }
        }

        // Set car icon or text at the current position
        String carSymbol = getCarSymbol();
        gridButtons[carRow][carCol].setText(carSymbol);
    }

    // Method to move the car in the specified direction
    private void moveCar(String newDirection) {
        direction = newDirection;

        // Update position based on direction
        switch (direction) {
            case "UP":
                if (carRow > 0) carRow--;
                break;
            case "DOWN":
                if (carRow < GRID_SIZE - 1) carRow++;
                break;
            case "LEFT":
                if (carCol > 0) carCol--;
                break;
            case "RIGHT":
                if (carCol < GRID_SIZE - 1) carCol++;
                break;
        }

        updateCarDisplay(); // Refresh car display in grid
    }

    // Returns a symbol for the car based on the direction
    private String getCarSymbol() {
        switch (direction) {
            case "UP": return "^";
            case "DOWN": return "v";
            case "LEFT": return "<";
            case "RIGHT": return ">";
            default: return "^"; // default is facing up
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CarGrid frame = new CarGrid();
            frame.setVisible(true);
        });
    }
}
