package gui;

/**
 * @author Software Engineering teachers
 */

import javax.swing.*;

import configuration.ConfigXML;
import domain.RuralHouse;
import businessLogic.ApplicationFacadeInterfaceWS;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;


public class MainGUI extends JFrame {
	
	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;
	private JButton button1 = null;
	private JButton button2 = null;

    private static ApplicationFacadeInterfaceWS appFacadeInterface;
	
	public static ApplicationFacadeInterfaceWS getBusinessLogic(){
		return appFacadeInterface;
	}
	
	public static void setBussinessLogic (ApplicationFacadeInterfaceWS afi){
		appFacadeInterface=afi;
	}
	protected JLabel lblNewLabel;
	

	/**
	 * This is the default constructor
	 */
	public MainGUI() {
		super();

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				ApplicationFacadeInterfaceWS facade=MainGUI.getBusinessLogic();
				try {
					//if (ConfigXML.getInstance().isBusinessLogicLocal()) facade.close();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					System.out.println("Error: "+e1.toString()+" , probably problems with Business Logic or Database");
				}
				System.exit(1);
			}
		});
		initialize();
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		// this.setSize(271, 295);
		this.setSize(495, 290);
		this.setContentPane(getJContentPane());
		this.setTitle("Rural Houses");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			GridLayout gridLayout = new GridLayout();
			gridLayout.setRows(4);
			gridLayout.setColumns(1);
			jContentPane = new JPanel();
			jContentPane.setLayout(gridLayout);
			jContentPane.add(getLblNewLabel());
			jContentPane.add(getBoton3(), null);
			jContentPane.add(getBoton2(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes boton2
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBoton2() {
		if (button1 == null) {
			button1 = new JButton();
			button1.setText("Create Offers");
			button1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					// C?digo cedido por la universidad
					ApplicationFacadeInterfaceWS facade=MainGUI.getBusinessLogic();
					Vector<RuralHouse> rhs=facade.getAllRuralHouses();
					JFrame a = new CreateOffersGUI(rhs);
					a.setVisible(true);
				}
			});
		}
		return button1;
	}
	
	/**
	 * This method initializes boton3
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBoton3() {
		if (button2 == null) {
			button2 = new JButton();
			button2.setText("Browse Offers");
			button2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					// Código cedido por la universidad
					//JFrame a = new QueryAvailabilityWindow();
					JFrame a = new BrowseOffersGUI();

					a.setVisible(true);
				}
			});
		}
		return button2;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Select option:");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel.setForeground(Color.BLACK);
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel;
	}

} // @jve:decl-index=0:visual-constraint="0,0"

