import javax.swing.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.*;

public class rellenar_solicitud extends JFrame{
    private JPanel panel1;
    private JButton informacionButton;
    private JButton salirButton;
    private JLabel logo;
    private JButton FCP_001AButton;
    private JButton f_AA_119Button;
    private JComboBox comboBox1;
    private JTextField correo;
    private JCheckBox checkBox1;
    private JCheckBox checkBox2;
    private JButton registrarButton;
    private static void descargarFAA119() {
        try {
            // Ruta del archivo original
            File archivoOriginal = new File("C://Users//Admin//Desktop//F_AA_119.xlsm");
            System.out.println("Ruta del archivo: " + archivoOriginal.getAbsolutePath());

            // Ruta donde se guardará el archivo descargado
            File destino = new File("C://Users//Admin//Downloads//desc_F_AA_119.xlsm");
            System.out.println("Ruta de descarga: " + destino.getAbsolutePath());

            // Copiar el archivo
            try (InputStream in = new FileInputStream(archivoOriginal);
                 OutputStream out = new FileOutputStream(destino)) {

                byte[] buffer = new byte[1024];
                int length;

                while ((length = in.read(buffer)) > 0) {
                    out.write(buffer, 0, length);
                }
            }

            JOptionPane.showMessageDialog(null, "Descarga completa");

        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al descargar el archivo");
        }
    }
    private static void descargarFCP001A() {
        try {
            // Ruta del archivo original
            File archivoOriginal = new File("C://Users//Admin//Desktop//FCP_001A.xls");
            System.out.println("Ruta del archivo: " + archivoOriginal.getAbsolutePath());

            // Ruta donde se guardará el archivo descargado
            File destino = new File("C://Users//Admin//Downloads//desc_FCP_001A.xls");
            System.out.println("Ruta de descarga: " + destino.getAbsolutePath());

            // Copiar el archivo
            try (InputStream in = new FileInputStream(archivoOriginal);
                 OutputStream out = new FileOutputStream(destino)) {

                byte[] buffer = new byte[1024];
                int length;

                while ((length = in.read(buffer)) > 0) {
                    out.write(buffer, 0, length);
                }
            }

            JOptionPane.showMessageDialog(null, "Descarga completa");

        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al descargar el archivo");
        }
    }


    public rellenar_solicitud() {
        //Configuracion de la pantalla
        super("Rellenar_formulario");
        setSize(1000,1000);
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        //Logo de la pagina
        ImageIcon icono = new ImageIcon("C://Users//Admin//IdeaProjects//registro_productos//src//epn_LOGO.png"); // Reemplaza con la ruta de tu imagen
        Image imagen = icono.getImage().getScaledInstance(140, 180, Image.SCALE_SMOOTH);
        ImageIcon iconoRedimensionado = new ImageIcon(imagen);
        logo.setIcon(iconoRedimensionado);
        FCP_001AButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                descargarFCP001A();
            }
        });

        f_AA_119Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                descargarFAA119();
            }
        });
        salirButton.addActionListener(new ActionListener() {
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
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new rellenar_solicitud();
            }
        });
    }
}
