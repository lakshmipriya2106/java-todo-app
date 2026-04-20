import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ToDoApp {
    public static void main(String[] args) {

        // Create Frame
        JFrame frame = new JFrame("To-Do App");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Text Field
        JTextField taskField = new JTextField();

        // Buttons
        JButton addButton = new JButton("Add");
        JButton deleteButton = new JButton("Delete");

        // List Model & List
        DefaultListModel<String> model = new DefaultListModel<>();
        JList<String> taskList = new JList<>(model);
        JScrollPane scrollPane = new JScrollPane(taskList);

        // Panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);

        // Add Task Action
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String task = taskField.getText().trim();
                if (!task.isEmpty()) {
                    model.addElement(task);
                    taskField.setText("");
                } else {
                    JOptionPane.showMessageDialog(frame, "Enter a task!");
                }
            }
        });

        // Delete Task Action
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int index = taskList.getSelectedIndex();
                if (index != -1) {
                    model.remove(index);
                } else {
                    JOptionPane.showMessageDialog(frame, "Select a task!");
                }
            }
        });

        // Layout
        frame.setLayout(new BorderLayout());
        frame.add(taskField, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}