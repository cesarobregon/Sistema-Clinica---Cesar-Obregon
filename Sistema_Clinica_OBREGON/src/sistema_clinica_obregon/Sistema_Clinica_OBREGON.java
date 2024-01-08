package sistema_clinica_obregon;
import com.formdev.flatlaf.FlatIntelliJLaf;
import datos.TestConexion;
import java.awt.Toolkit;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;
/**
 *
 * @author OBREGON
 */
public class Sistema_Clinica_OBREGON {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    Toolkit.getDefaultToolkit().setDynamicLayout(true);
                    System.setProperty("sun.awt.noerasebackground", "true");
                    JFrame.setDefaultLookAndFeelDecorated(true);
                    JDialog.setDefaultLookAndFeelDecorated(true);
                    UIManager.setLookAndFeel(new FlatIntelliJLaf());
                } catch (Exception ex) {
                } finally {
                    JFrame_Sistema frm = new JFrame_Sistema();
                    frm.setVisible(true);
                    TestConexion test = new TestConexion();
                    if(!test.isOkFileCofigConexion()){
                        frm._loadSetting();
                    }
                }
            }
        });
    }
}