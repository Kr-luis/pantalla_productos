import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.*;
public class Prueba extends JFrame{
    private JPanel panel1;
    private JButton f_AA_119Button;
    private JButton FCP_Button;
    private static void descargarPDF() {
        try {
            // Ruta del archivo original
            File archivoOriginal = new File("C://Users//Admin//Desktop//prueba.pdf");
            System.out.println("Ruta del archivo: " + archivoOriginal.getAbsolutePath());

            // Ruta donde se guardará el archivo descargado
            File destino = new File("C://Users//Admin//Downloads//desc_prueba.pdf");
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
    public Prueba (){
        super("Prueba");
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,300);
        setVisible(true);

        f_AA_119Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                descargarPDF();
            }
        });
    }

    public static void main(String[] args){
    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            new Prueba();
        }
    });
    }

}
