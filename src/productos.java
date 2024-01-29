import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
public class productos extends JFrame{
    private JPanel panel1;
    private JPanel resgistro_productos;
    private JTextField codigo;
    private JTextField cantidad;
    private JTextField nombre;
    private JTextField valor;
    private JButton guardar;
    private JButton salir;
    private JButton eliminar;
    private JTextField codigo2;
    private JTextField cantidad2;
    private JTextField nombre2;
    private JLabel NOMPROD;
    private JButton buscar;
    private JTextField valor2;
    HashMap<String, Object> registro = new HashMap<>();
    public productos() {
        super("Registro_de_productos");
        setContentPane(resgistro_productos);
        setSize(600, 700);

        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null,
                        "¿Estás seguro de que deseas salir?",
                        "Salir", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    dispose(); // Cierra la ventana
                }
            }
        });
        guardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registro.put("codprod", codigo.getText());
                registro.put("nomprod", nombre.getText());
                registro.put("cantidad", cantidad.getText());
                registro.put("valprod", valor.getText());

                JOptionPane.showMessageDialog(null, "Se ha guardado el producto con código: " + registro.get("codprod"),
                        "Producto guardado", JOptionPane.INFORMATION_MESSAGE);

                codigo.setText(" ");
                nombre.setText(" ");
                cantidad.setText(" ");
                valor.setText(" ");

            }
        });

        buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String busca = codigo.getText();
                if (registro.containsKey("codprod") && registro.get("codprod").equals(busca)) {
                    // Mostrar la información encontrada en los componentes correspondientes
                    codigo2.setText(registro.get("codprod").toString());
                    cantidad2.setText(registro.get("cantidad").toString());
                    nombre2.setText(registro.get("nomprod").toString());
                    valor2.setText(registro.get("valprod").toString());
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró el código de producto: " + busca,
                            "Búsqueda fallida", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        eliminar.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                    String codigoAEliminar = JOptionPane.showInputDialog(null, "Ingrese el código a eliminar:", "Eliminar producto",
                            JOptionPane.QUESTION_MESSAGE);

                    if (codigoAEliminar != null && !codigoAEliminar.isEmpty()) {

                        if (registro.containsKey("codprod") && registro.get("codprod").equals(codigoAEliminar)) {

                            registro.remove("codprod", codigo.getText());
                            registro.remove("nomprod", nombre.getText());
                            registro.remove("cantidad", cantidad.getText());
                            registro.remove("valprod", valor.getText());

                            JOptionPane.showMessageDialog(null, "Se ha eliminado el producto con código: " + codigoAEliminar,
                                    "Producto eliminado", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "No se encontró el código de producto: " + codigoAEliminar,
                                    "Eliminar producto", JOptionPane.WARNING_MESSAGE);
                        }
                    } else {

                        JOptionPane.showMessageDialog(null, "Eliminación cancelada", "Operación cancelada",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                }
        });
    }
}