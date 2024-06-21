import javax.swing.*;
import java.awt.*;

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

        // Configuración de los JTextField
        textField1 = new JTextField(10);
        textField2 = new JTextField(10);

        // Configuración de los JButton
        btnSuma = new JButton("Suma");
        btnResta = new JButton("Resta");
        btnMultiplicacion = new JButton("Multiplicación");
        btnDivision = new JButton("División");

        // Configuración del JLabel para mostrar el resultado
        labelResultado = new JLabel("Resultado:");

        // Configuración del panel principal con GridLayout
        JPanel panel = new JPanel(new GridLayout(2, 2, 10, 10)); // 2 filas, 2 columnas, espacios de 10px entre componentes

        // Agregar componentes al panel
        panel.add(textField1);
        panel.add(textField2);
        panel.add(btnSuma);
        panel.add(btnResta);
        panel.add(btnMultiplicacion);
        panel.add(btnDivision);
        panel.add(labelResultado);

        // Agregar panel al JFrame
        add(panel);

        pack(); // Ajusta el tamaño del JFrame automáticamente
        setLocationRelativeTo(null); // Centrar ventana en la pantalla
    }

    private void setupListeners() {
        // Configurar listeners para los botones
        btnSuma.addActionListener(e -> calcularOperacion('+'));
        btnResta.addActionListener(e -> calcularOperacion('-'));
        btnMultiplicacion.addActionListener(e -> calcularOperacion('*'));
        btnDivision.addActionListener(e -> calcularOperacion('/'));
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
        SwingUtilities.invokeLater(() -> {
            Form1 Form1 = new Form1();
            Form1.setVisible(true);
        });
    }
}
