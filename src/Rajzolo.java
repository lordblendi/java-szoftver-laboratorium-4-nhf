import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.*;

public class Rajzolo extends JFrame {
	/**
	 * Referencia a kontrollerre
	 */
	private GameController controller;
	
	/**
	 * A pálya képe
	 */
	private BufferedImage palyaImage;
	
	/**
	 * Varázserőt jelző szövegdoboz
	 */
	private JTextField varazseroTextField;
	
	/**
	 * Lenyíló lista a lerakni kívánt elem kiválasztásához
	 */
	private JComboBox lerakandoComboBox;
	
	/**
	 * Egy cella mérete (konstans)
	 */
	public static final int CELLAMERET = 60;
	
	/**
	 * Pálya hány cellából áll? (konstans)
	 */
	public static final int CELLASZAM = 10;
	
	HashMap<Cella, Kirajzolhato> palya;
	
	HashMap<Ellenseg, EllensegRajzol> ellensegek;
	
	/**
     * Konstruktor
     * 
     * @param controller referencia a kontrollerre
     */
	public Rajzolo(GameController controller) {
		this.controller = controller;
		
		// pálya elkészítése
		int meret = CELLAMERET * CELLASZAM + 1;
		palyaImage = new BufferedImage(meret, meret, BufferedImage.TYPE_INT_ARGB);
		JPanel map = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(palyaImage, 0, 0, null);
			}
		};
		map.setPreferredSize(new Dimension(meret, meret));
		map.setBackground(Color.WHITE);
		map.addMouseListener(controller);
		
		// vezérlők elkészítése
		JPanel controls = new JPanel();
		controls.setPreferredSize(new Dimension(200, 600));
		controls.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		// feliratok
		JLabel nl = new JLabel("Nagymama lekvárjai");
		nl.setAlignmentX(CENTER_ALIGNMENT);
		JLabel nl2 = new JLabel("2014");
		nl2.setAlignmentX(CENTER_ALIGNMENT);
		JButton indit = new JButton("Játék indítása...");
		indit.setAlignmentX(CENTER_ALIGNMENT);
		final Rajzolo that = this;
		indit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// játék indításához fájlnév bekérése
				String terkep = JOptionPane.showInputDialog(that, "Térkép fájl:", "Játék indítása...", JOptionPane.QUESTION_MESSAGE);
				that.controller.indit(terkep);
			}
		});
		
		// varázserő kijelzése
		JPanel varazs = new JPanel();
		varazs.setAlignmentX(CENTER_ALIGNMENT);
		JLabel ve = new JLabel("Varázserő: ");
		varazseroTextField = new JTextField("1000");
		varazseroTextField.setEditable(false);
		varazseroTextField.setMaximumSize(new Dimension(100, varazseroTextField.getPreferredSize().height));
		varazseroTextField.setMinimumSize(new Dimension(100, varazseroTextField.getPreferredSize().height));
		varazseroTextField.setPreferredSize(new Dimension(100, varazseroTextField.getPreferredSize().height));
		varazs.setLayout(new BoxLayout(varazs, BoxLayout.LINE_AXIS));
		varazs.add(ve);
		varazs.add(Box.createHorizontalGlue());
		varazs.add(varazseroTextField);
		
		// felirat
		JPanel lerak = new JPanel();
		lerak.setAlignmentX(CENTER_ALIGNMENT);
		JLabel ler = new JLabel("Lerakásra kerülő elem (ár):");
		lerak.setLayout(new BoxLayout(lerak, BoxLayout.LINE_AXIS));
		lerak.add(ler);
		lerak.add(Box.createHorizontalGlue());
		
		// legördülő lista az elemek lerakásához
		lerakandoComboBox = new JComboBox(new String[] {
			"torony (400)",
			"zöld kő (100)",
			"kék kő (100)",
			"ember piros kő (100)",
			"hobbit piros kő (100)",
			"törp piros kő (100)",
			"tünde piros kő (100)",
			"akadály (300)",
			"sárga kő (100)"
		});
		lerakandoComboBox.setMaximumSize(new Dimension(Integer.MAX_VALUE, lerakandoComboBox.getPreferredSize().height));
		
		// layout elkészítése
		controls.setLayout(new BoxLayout(controls, BoxLayout.PAGE_AXIS));
		controls.add(Box.createRigidArea(new Dimension(0, 10)));
		controls.add(nl);
		controls.add(nl2);
		controls.add(Box.createRigidArea(new Dimension(0, 30)));
		controls.add(indit);
		controls.add(Box.createRigidArea(new Dimension(0, 30)));
		controls.add(varazs);
		controls.add(Box.createRigidArea(new Dimension(0, 10)));
		controls.add(lerak);
		controls.add(lerakandoComboBox);
		controls.add(Box.createVerticalGlue());
		
		// ablak megjelenítése
		setTitle("Nagymama lekvárjai");
		setLayout(new BorderLayout());
		add(map, BorderLayout.WEST);
		add(controls, BorderLayout.EAST);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
	}
	
	/**
	 * Pálya beállítása
	 * 
	 * @param palya pálya
	 */
	public void setPalya(HashMap<Cella,Kirajzolhato> palya) {
		this.palya = palya;
	}
	
	/**
	 * Ellensegégek beállítása
	 * 
	 * @param ellensegek ellenségek
	 */
	public void setEllensegek(HashMap<Ellenseg, EllensegRajzol> ellensegek) {
		this.ellensegek = ellensegek;
	}
	
	/**
	 * Figyelmeztetés megjelenítése
	 * 
	 * @param str üzenet szövege
	 */
	public void alert(String str) {
		JOptionPane.showMessageDialog(this, str);
	}
	
	/**
	 * Melyik elem van kiválasztva a lerakáshoz?
	 * 
	 * @return elem indexe a listában
	 */
	public int getLerakandoElem() {
		return lerakandoComboBox.getSelectedIndex();
	}
	
	/**
	 *A pálya összes elemét kirajzolja egy képre, frissíti a kijelzett varázserőt
	 * 
	 * @param varazsEro az éppen aktuális varázserő mennyisége
	 */
	public void rajzol(int varazsEro){
		//kirajzolja a palya osszes ckirajzolhatojat
		
		// varázserő frissítése
		varazseroTextField.setText(Integer.toString(varazsEro));
	}
	
	/**
	 * Lerak egy akadályRajzolt a kapott Utat kirajzoló UtRajzol-ra
	 * 
	 * @param akadaly a lerakandó akadaly kirajzolója
	 * @param cella Az Ut amelyik kirajzoló objektumára tesszük le.
	 */
	public void lerakAkadaly(AkadalyRajzol akadaly, Cella cella){
		((Kirajzolhato) palya.get(cella)).lerakAkadaly(akadaly);
	}
	
	/**
	 * Lerak egy SargaKoRajzolt a kapott Utat kirajzoló UtRajzol Akadalyara
	 * 
	 * @param akadalyKo a lerakandó akadálykő kirajzolója
	 * @param cella Az Ut amelyik kirajzoló objektumára tesszük le.
	 */
	public void lerakAkadalyKo(SargaKoRajzol akadalyKo, Cella cella){
		((Kirajzolhato) palya.get(cella)).lerakAkadalyKo(akadalyKo);
	}
	
	/**
	 * Lerak egy ToronyRajzolt a kapott Utat kirajzoló DomborzatRajzol-ra
	 * 
	 * @param torony a lerakandó akadaly kirajzolója
	 * @param cella A Domborzat amelyik kirajzoló objektumára tesszük le.
	 */
	public void lerakTorony(ToronyRajzol torony, Cella cella){
		((Kirajzolhato) palya.get(cella)).lerakTorony(torony);
	}
	
	/**
	 * Lerak egy ToronykőRajzolt megvalósító objektumot a kapott Domborzatot kirajzoló DomborzatRajzolra
	 * 
	 * @param toronyKo a lerakandó ToronyKo kirajzolója
	 * @param cella A Domborzat amelyik kirajzoló objektumára tesszük le.
	 */
	public void lerakToronyKo(ToronyKoRajzol toronyKo, Cella cella){
		((Kirajzolhato) palya.get(cella)).lerakToronyKo(toronyKo);
	}
	
	/**
	 * a játék végény kiírja, hogy nyertünk-e?
	 * 
	 * @param nyertunk megmutatja hogy nyertünk-e
	 */
	public void vege(boolean nyertunk){
		if (nyertunk)
        	alert("Gratulálunk, nyertél!");
        else
        	alert("Sajnos vesztettél!");
	}
	
	/**
	 * Egy ellenseget ad hozzá az adott út kirajzolójához, elmenti hogy melyik kirajzoló tartozik hozzá
	 * 
	 * @param ut Az út amelyik kirajzolójára letesszük.
	 * @param ellenseg az ellenseg amely kirajzolóját letesszük.
	 * @param ellensegRajzol az Ellenseg kirajzolója amelyet leteszünk.
	 */
	public void addEllenseg(Ut ut, Ellenseg ellenseg, EllensegRajzol ellensegRajzol){
		ellensegek.put(ellenseg, ellensegRajzol);
		((EllensegRajzol) ellensegek.get(ellenseg)).ralep(((UtRajzol) palya.get(ut)));
	}
	
	/**
	 * Egy ellenseg kirajzolójának átrakása az eggyik Utról a másikra
	 * 
	 * @param ut az Ut amelyre az Ellenseg átlép
	 * @param elleneg Az Ellenseg aki átlép
	 */
	public void atlep(Ut ut, Ellenseg ellenseg){
		((EllensegRajzol) ellensegek.get(ellenseg)).lelep();
		((EllensegRajzol) ellensegek.get(ellenseg)).ralep(((UtRajzol) palya.get(ut)));
	}
	
	/**
	 * Egy halott ellenség kirajzolójának levétele
	 * 
	 * @param ellenseg A meghalt Ellenseg.
	 */
	public void meghalEllenseg(Ellenseg ellenseg){
		((EllensegRajzol) ellensegek.get(ellenseg)).lelep();
		ellensegek.remove(ellenseg);
	}
}
