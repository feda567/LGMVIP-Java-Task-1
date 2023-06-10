
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class CurrencyConverter {

    private JFrame frame;
    private JTextField t1;
    private JTextField t2;
    private JLabel firstCurrencyUnit;
    private JLabel secondCurrencyUnit;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CurrencyConverter window = new CurrencyConverter();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    String[] currencyUnits = {
        "Units",
        "US Dollar",
        "Nigerian Naira",
        "Brazilian Real",
        "Canadian Dollar",
        "Kenyan Shilling",
        "Indonesian Rupiah",
        "Indian Rupee",
        "Philippine Pisco",
        "Pakistani Rupee"
    };
    double US_Dollar=1.31;
    double Nigerian_Naira=476.57;
    double Brazilian_Real=5.47;
    double Canadian_Dollar=1.71;
    double Kenyan_Shilling=132.53;
    double Indonesian_Rupiah=19554.94;
    double Indian_Rupee=95.21;
    double Phillipine_Pisco=71.17;
    double Pakistani_Rupee=162.74;



    public CurrencyConverter() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(0, 0, 0));
        frame.setBounds(100, 100, 725, 506);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("CURRENCY CONVERTER");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Book Antiqua", Font.BOLD, 37));
        lblNewLabel.setBounds(93, 10, 540, 67);
        frame.getContentPane().add(lblNewLabel);

        JComboBox<String> firstCountry = new JComboBox<>();
        firstCountry.setForeground(new Color(0, 128, 192));
        firstCountry.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                int pos = firstCountry.getSelectedIndex();
                if (pos != -1) {
                    firstCurrencyUnit.setText(currencyUnits[pos]);
                }
            }
        });
        firstCountry.setModel(new DefaultComboBoxModel<>(new String[] {
            "Choose One...",
            "USA",
            "Nigeria",
            "Brazil",
            "Canada",
            "Kenyan",
            "Indonesia",
            "India",
            "Philippine",
            "Pakistan"
        }));
        firstCountry.setFont(new Font("Century", Font.BOLD, 20));
        firstCountry.setBounds(32, 141, 255, 58);
        frame.getContentPane().add(firstCountry);

        JComboBox<String> secondCountry = new JComboBox<>();
        secondCountry.setForeground(new Color(0, 128, 0));
        secondCountry.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                int pos = secondCountry.getSelectedIndex();
                if (pos != -1) {
                    secondCurrencyUnit.setText(currencyUnits[pos]);
                }
            }
        });
        secondCountry.setModel(new DefaultComboBoxModel<>(new String[] {
            "Choose One...",
            "USA",
            "Nigeria",
            "Brazil",
            "Canada",
            "Kenyan",
            "Indonesia",
            "India",
            "Philippine",
            "Pakistan"
        }));
        secondCountry.setFont(new Font("Century", Font.BOLD, 20));
        secondCountry.setBounds(414, 141, 255, 58);
        frame.getContentPane().add(secondCountry);

        t1 = new JTextField();
        t1.setForeground(new Color(0, 128, 192));
        t1.setFont(new Font("Century", Font.BOLD, 20));
        t1.setBounds(32, 224, 255, 58);
        frame.getContentPane().add(t1);
        t1.setColumns(10);

        t2 = new JTextField();
        t2.setForeground(new Color(0, 128, 0));
        t2.setFont(new Font("Century", Font.BOLD, 20));
        t2.setColumns(10);
        t2.setBounds(414, 224, 255, 58);
        frame.getContentPane().add(t2);

        JLabel lblNewLabel_1 = new JLabel("From Currency of");
        lblNewLabel_1.setForeground(new Color(0, 128, 192));
        lblNewLabel_1.setFont(new Font("Century", Font.BOLD, 20));
        lblNewLabel_1.setBounds(32, 92, 255, 39);
        frame.getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("To Currency of");
        lblNewLabel_1_1.setForeground(new Color(0, 128, 0));
        lblNewLabel_1_1.setFont(new Font("Century", Font.BOLD, 20));
        lblNewLabel_1_1.setBounds(414, 92, 255, 39);
        frame.getContentPane().add(lblNewLabel_1_1);

        firstCurrencyUnit = new JLabel("Units");
        firstCurrencyUnit.setForeground(new Color(0, 128, 192));
        firstCurrencyUnit.setHorizontalAlignment(SwingConstants.RIGHT);
        firstCurrencyUnit.setFont(new Font("Century", Font.BOLD, 20));
        firstCurrencyUnit.setBounds(32, 292, 255, 39);
        frame.getContentPane().add(firstCurrencyUnit);

        secondCurrencyUnit = new JLabel("Units");
        secondCurrencyUnit.setForeground(new Color(0, 128, 0));
        secondCurrencyUnit.setHorizontalAlignment(SwingConstants.RIGHT);
        secondCurrencyUnit.setFont(new Font("Century", Font.BOLD, 20));
        secondCurrencyUnit.setBounds(414, 292, 255, 39);
        frame.getContentPane().add(secondCurrencyUnit);

        JButton btnNewButton = new JButton("Convert");
        btnNewButton.setForeground(new Color(128, 0, 64));
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		//CURRENCY CONVERTER
        		
        		if(firstCountry.getSelectedIndex()==0||secondCountry.getSelectedIndex()==0||t1.getText()==null) {
        			
        			
        			JOptionPane.showMessageDialog(null,
        					"You must select both countries and must input the amount",
        					"Error Message",
        					JOptionPane.INFORMATION_MESSAGE
        					
        					);
        			return;
        		}
        		
        		double amountToChange=Double.parseDouble(t1.getText());
        		double amountInPounds=0.0;
        		
        		switch(firstCountry.getSelectedItem().toString()) {
        		
        		
        			case "USA" 		:amountInPounds=amountToChange / US_Dollar;
        							 break;
        			case "Nigeria"	:amountInPounds=amountToChange / Nigerian_Naira;
									 break;
        			case "Brazil" 	:amountInPounds=amountToChange / Brazilian_Real;
									 break;
        			case "Canada" 	:amountInPounds=amountToChange / Canadian_Dollar;
									 break;
        			case "Kenyan" 	:amountInPounds=amountToChange / Kenyan_Shilling;
									 break;
        			case "Indonesia":amountInPounds=amountToChange / Indonesian_Rupiah;
									 break;
        			case "India" 	:amountInPounds=amountToChange / Indian_Rupee;
									 break;
        			case "Philippine":amountInPounds=amountToChange / Phillipine_Pisco;
									  break;
        			case "Pakistan" :amountInPounds=amountToChange / Pakistani_Rupee;
									 break;
        		}
        		double amountChanged=0.0;
        		switch(secondCountry.getSelectedItem().toString()) {
        		
        		
    			case "India" :amountChanged=amountInPounds * Indian_Rupee;
    						  break;
    			case "USA" :amountChanged=amountInPounds * US_Dollar;
							  break;
    			case "Nigeria" :amountChanged=amountInPounds * Nigerian_Naira;
								break;
    			case "Brazil" :amountChanged=amountInPounds * Brazilian_Real;
								break;
    			case "Canada" :amountChanged=amountInPounds * Canadian_Dollar;
								break;
    			case "Kenyan" :amountChanged=amountInPounds * Kenyan_Shilling;
								break;
    			case "Indonesia" :amountChanged=amountInPounds * Indonesian_Rupiah;
								break;
    			case "Philippine" :amountChanged=amountInPounds * Phillipine_Pisco;
								break;
    			case "Pakistan" :amountChanged=amountInPounds * Pakistani_Rupee;
								break;
    		}
        		
        		String value=String.format("%.2f",amountChanged);
        		t2.setText(value);
        		
        	}
        });
        btnNewButton.setFont(new Font("Century", Font.BOLD, 20));
        btnNewButton.setBounds(79, 367, 137, 44);
        frame.getContentPane().add(btnNewButton);

        JButton btnReset = new JButton("Reset");
        btnReset.setForeground(new Color(64, 0, 128));
        btnReset.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		firstCountry.setSelectedIndex(0);
        		secondCountry.setSelectedIndex(0);
        		t1.setText(null);
        		t2.setText(null);

        	}
        });
        btnReset.setFont(new Font("Century", Font.BOLD, 20));
        btnReset.setBounds(300, 367, 110, 44);
        frame.getContentPane().add(btnReset);

        JButton btnExit = new JButton("Exit");
        btnExit.setForeground(new Color(255, 0, 0));
        btnExit.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		System.exit(0);
        	}
        });
        btnExit.setFont(new Font("Century", Font.BOLD, 20));
        btnExit.setBounds(515, 367, 110, 44);
        frame.getContentPane().add(btnExit);
    }
}
