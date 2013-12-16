/**
 * 
 */
package automat;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author 06hubers
 *
 */
public class Main extends JFrame{

    private static final long serialVersionUID = 1L;

    /**
     * @param args
     */
    public static void main(String[] args) {
	Main m = new Main();
    }
    
    /**
     * ContentPane
     */
    private JPanel anzeige = new JPanel();


    public Main() {
	setLayout(new GridBagLayout());
	anzeige.setLayout(new GridBagLayout());
	setLocationRelativeTo(null);
	setResizable(false);
	setTitle("Editorinfo");
	setSize(280, 200);
	addContent();
	setVisible(true);
    }
    
    /**
     * Fügt Text hinzu
     */
    private void addContent() {
	GridBagConstraints c = new GridBagConstraints();
	c.fill = GridBagConstraints.BOTH;

	c.gridx = 0;
	c.gridy = 0;
	c.gridwidth = 2;
	c.weightx = 1.0F;
	c.weighty = 1.0F;
	c.insets = new Insets(2, 5, 2, 2);
	
	setContentPane(anzeige);
	
	JLabel content = new JLabel();
	content.setText("<html>\n" +
			"<h2>Durch 3 teilbar?</h2>\n" +
			"<p>Geben Sie in das Feld eine Zahlenfolge ein! </p>\n" +
			"</html>");
	anzeige.add(content, c);
	
	c.gridx = 0;
	c.gridy = 1;
	c.gridwidth = 1;
	final JTextField eingabe = new JTextField("3");
	eingabe.setColumns(15);
	anzeige.add(eingabe, c);
	
	c.gridx = 1;
	c.gridy = 1;
	final JButton enter = new JButton("Überprüfen");
	anzeige.add(enter, c);
	
	final JLabel label1 = new JLabel("Zahlenkette ist valid: ");
	final JPanel status = new JPanel();
	status.setLayout(new BorderLayout());
	status.add(label1, BorderLayout.WEST);
	final JLabel valid = new JLabel();
	status.add(valid, BorderLayout.EAST);
	c.gridx = 0;
	c.gridy = 2;
	c.gridwidth = 2;
	anzeige.add(status, c);
	
	enter.addActionListener(new ActionListener() {
	    
	    @Override
	    public void actionPerformed(ActionEvent arg0) {
		Verarbeitungsvorgang ver = new Verarbeitungsvorgang();
		ver.ZahlDurch3Teilbar(eingabe.getText());
		if(ver.istAkzeptiert()) {
		    valid.setText("Ja, Zustand "  + ver.getZustand());
		} else {
		    valid.setText("Nein, Zustand " + ver.getZustand());
		}
	    }
	});
	
	JButton button = new JButton("Schließen");
	button.addActionListener(new ActionListener() {
	    
	    @Override
	    public void actionPerformed(ActionEvent arg0) {
		dispose();
	    }
	});
	
	c.gridx = 0;
	c.gridy = 3;
	c.gridwidth = 1;
	anzeige.add(button, c);
    }

}
