import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Form1 extends JFrame {
    private JTextField textField1;
    private JTextField textField2;
    private JButton btnSuma;
    private JButton btnResta;
    private JButton btnMultiplicacion;
    private JButton btnDivision;
    private JLabel labelResultado;

    public Form1() {
        initComponents();
        setupListeners();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Calculadora");

        textField1 = new JTextField(10);
        textField2 = new JTextField(10);

        btnSuma = new JButton("Suma");
        btnResta = new JButton("Resta");
        btnMultiplicacion = new JButton("Multiplicación");
        btnDivision = new JButton("División");

        labelResultado = new JLabel("Resultado:");

        JPanel panel = new JPanel();
        panel.add(textField1);
        panel.add(textField2);
        panel.add(btnSuma);
        panel.add(btnResta);
        panel.add(btnMultiplicacion);
        panel.add(btnDivision);
        panel.add(labelResultado);

        add(panel);

        pack();
        setLocationRelativeTo(null); // Centrar ventana en la pantalla
    }

    private void setupListeners() {
        btnSuma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularOperacion('+');
            }
        });

        btnResta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularOperacion('-');
            }
        });

        btnMultiplicacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularOperacion('*');
            }
        });

        btnDivision.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularOperacion('/');
            }
        });
    }

    private void calcularOperacion(char operador) {
        try {
            int numero1 = Integer.parseInt(textField1.getText());
            int numero2 = Integer.parseInt(textField2.getText());
            int resultado = 0;

            switch (operador) {
                case '+':
                    resultado = numero1 + numero2;
                    break;
                case '-':
                    resultado = numero1 - numero2;
                    break;
                case '*':
                    resultado = numero1 * numero2;
                    break;
                case '/':
                    if (numero2 != 0) {
                        resultado = numero1 / numero2;
                    } else {
                        JOptionPane.showMessageDialog(this, "No se puede dividir por cero", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    break;
            }

            labelResultado.setText("Resultado: " + resultado);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese números válidos en los cuadros de texto", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Form1 form1 = new Form1();
                form1.setVisible(true);
            }
        });
    }
}
