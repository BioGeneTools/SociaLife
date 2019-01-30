/*
 * ##################
 *   SociaLife v1.0
 * ##################
 * CopyRight to HezhaLab
 * For any question, please contact hezha.hassan@hezhalab.com
 * 
 * ******
 * About
 * ******
 * This is a simple game about a regular Social Life style which the player's objective is 
 * using a good strategy to earn money on time, getting married, and having kids.
 * 
 * OS: Mac version
 * 
 * 
 */


import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.Random;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JLayeredPane;
import javax.swing.border.TitledBorder;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class SociaLife {
	private JFrame frmSL;
	private JTextField bankATField;
	private JTextField dealTField;
	private JTextField dayTField;
	private JTextField taxTField;
	public JProgressBar progressBar;
	public JProgressBar progressBarStress;
	public JProgressBar progressBarHappiness;
	public JProgressBar progressBarLove;
	private JTextField statusTField;
	private JTextField childTField;
	private JTextField rentTField;
	private JTextField monthTField;
	public int Salary = 600; // this is also the bank account
	public int SalaryDayCount = 1;
	public int month = 11;
	public int year = 2001;
	public int marrageRent = 600;  //To punish with rent based on the martial status. Later large house rent also added to this.
	public int childRent = 200;  //To punish with rent based on the number of children.
	public int costOfMarrage = 0; //How much to be reduced from the bank as the cost of marriage.
	public int kid = 0;
	public boolean LargeHouseEnable = true;
	public int Stressvalue = 2;
	public int Happyvalue = 100;
	public int Lovevalue = 99;
	public int Loan = 0;
	private JTextField bankTField;
	private JTextField dealTFieldfruit;
	private JTextField dealTFieldlaptop;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField yearTField;
	int[] FruitCollective = new int[5];
	int[] LaptopCollective = new int[6];
	int[] CarCollective = new int[7];
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SociaLife window = new SociaLife();
					window.frmSL.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public SociaLife() {
		initialize();
	}


	public void initialize() {
		frmSL =new JFrame();
		frmSL.setTitle("SociaLife v1.0");
		frmSL.setBounds(100, 100, 864, 400);
		frmSL.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSL.getContentPane().setLayout(null);
		frmSL.setResizable(false);
		
		// List ==> Market
		final DefaultListModel model = new DefaultListModel();
		model.addElement(ToDecimal("23000"));
		model.addElement(ToDecimal("18000"));
		model.addElement(ToDecimal("11000"));
		model.addElement(ToDecimal("160000"));
		model.addElement(ToDecimal("43000"));
		model.addElement(ToDecimal("32000"));
		model.addElement(ToDecimal("75000"));
		// Marketfruit
		final DefaultListModel modelMarketfruit = new DefaultListModel();
		modelMarketfruit.addElement("2");
		modelMarketfruit.addElement("3");
		modelMarketfruit.addElement("3");
		modelMarketfruit.addElement("4");
		modelMarketfruit.addElement("2");
		final DefaultListModel modelInventoryfruit = new DefaultListModel();
		modelInventoryfruit.addElement("0");
		modelInventoryfruit.addElement("0");
		modelInventoryfruit.addElement("0");
		modelInventoryfruit.addElement("0");
		modelInventoryfruit.addElement("0");
		final DefaultListModel modelPreviousfruit = new DefaultListModel();
		modelPreviousfruit.addElement("0");
		modelPreviousfruit.addElement("0");
		modelPreviousfruit.addElement("0");
		modelPreviousfruit.addElement("0");
		modelPreviousfruit.addElement("0");
		//Marketlaptop
		final DefaultListModel modelMarketlaptop = new DefaultListModel();
		modelMarketlaptop.addElement("600");
		modelMarketlaptop.addElement("700");
		modelMarketlaptop.addElement(ToDecimal("1100"));
		modelMarketlaptop.addElement(ToDecimal("2300"));
		modelMarketlaptop.addElement("500");
		modelMarketlaptop.addElement("400");
		final DefaultListModel modelPreviouslaptop = new DefaultListModel();
		modelPreviouslaptop.addElement("0");
		modelPreviouslaptop.addElement("0");
		modelPreviouslaptop.addElement("0");
		modelPreviouslaptop.addElement("0");
		modelPreviouslaptop.addElement("0");
		modelPreviouslaptop.addElement("0");
		final DefaultListModel modelInventorylaptop = new DefaultListModel();
		modelInventorylaptop.addElement("0");
		modelInventorylaptop.addElement("0");
		modelInventorylaptop.addElement("0");
		modelInventorylaptop.addElement("0");
		modelInventorylaptop.addElement("0");
		modelInventorylaptop.addElement("0");
		
		//
		final JList listInventoryfruit = new JList(modelInventoryfruit);
		listInventoryfruit.setBounds(152, 16, 26, 85);
		listInventoryfruit.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JList listPreviousfruit = new JList(modelPreviousfruit);
		listPreviousfruit.setBounds(202, 16, 54, 85);
		listPreviousfruit.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		bankATField = new JTextField();
		bankATField.setEditable(false);
		bankATField.setBounds(116, 0, 106, 28);
		frmSL.getContentPane().add(bankATField);
		bankATField.setColumns(10);
		bankATField.setText(ToDecimal(Integer.toString(FromDecimal(Integer.toString(Salary)))));
		
		// List ==> Previous price
		final DefaultListModel modelPrevious = new DefaultListModel();
		modelPrevious.addElement("0");
		modelPrevious.addElement("0");
		modelPrevious.addElement("0");
		modelPrevious.addElement("0");
		modelPrevious.addElement("0");
		modelPrevious.addElement("0");
		modelPrevious.addElement("0");
		
		JLabel lblBankAccount = new JLabel("Bank account:");
		lblBankAccount.setBounds(12, 6, 89, 16);
		frmSL.getContentPane().add(lblBankAccount);
		
		// LIST ==> Inventory
		final DefaultListModel modelInventory = new DefaultListModel();
		modelInventory.addElement("0");
		modelInventory.addElement("0");
		modelInventory.addElement("0");
		modelInventory.addElement("0");
		modelInventory.addElement("0");
		modelInventory.addElement("0");
		modelInventory.addElement("0");
		JLabel lblTax = new JLabel("Tax:");
		lblTax.setBounds(234, 6, 61, 16);
		frmSL.getContentPane().add(lblTax);

		taxTField = new JTextField();
		taxTField.setEditable(false);
		taxTField.setBounds(307, 0, 56, 28);
		frmSL.getContentPane().add(taxTField);
		taxTField.setColumns(10);
		taxTField.setToolTipText("Tax is effected by Love, Happiness, and Stress");
		TaxCal();
		
		JLabel lblMartialStatus = new JLabel("Martial status:");
		lblMartialStatus.setBounds(543, 6, 101, 16);
		frmSL.getContentPane().add(lblMartialStatus);
		
		statusTField = new JTextField();
		statusTField.setEditable(false);
		statusTField.setBounds(543, 24, 89, 28);
		frmSL.getContentPane().add(statusTField);
		statusTField.setColumns(10);
		statusTField.setText("Single");
		
		final JButton btnIGetMarried = new JButton("Marry");
		btnIGetMarried.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		btnIGetMarried.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getMarried();
				if(statusTField.getText().equals("Married")){
					btnIGetMarried.setEnabled(false);
				}
				
			}
		});
		btnIGetMarried.setBounds(751, 64, 113, 43);
		frmSL.getContentPane().add(btnIGetMarried);
		
		JLabel lblChildren = new JLabel("Children:");
		lblChildren.setBounds(470, 6, 61, 16);
		frmSL.getContentPane().add(lblChildren);
		
		childTField = new JTextField();
		childTField.setEditable(false);
		childTField.setBounds(480, 24, 43, 28);
		frmSL.getContentPane().add(childTField);
		childTField.setColumns(10);
		childTField.setText(Integer.toString(kid));
		
		
		JButton btnkid = new JButton("I want kid");
		btnkid.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		btnkid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				kid();
			}
		});
		btnkid.setBounds(751, 103, 113, 43);
		frmSL.getContentPane().add(btnkid);
		
		JLabel lblHouseRentm = new JLabel("House Rent:");
		lblHouseRentm.setBounds(234, 30, 76, 16);
		frmSL.getContentPane().add(lblHouseRentm);
		
		rentTField = new JTextField();
		rentTField.setEditable(false);
		rentTField.setBounds(307, 28, 55, 25);
		frmSL.getContentPane().add(rentTField);
		rentTField.setColumns(10);
		rentTField.setText("0");
		
		progressBarStress = new JProgressBar();
		progressBarStress.setToolTipText("More stress increases stress. To have less stress, avoid having more kids.");
		progressBarStress.setOrientation(SwingConstants.VERTICAL);
		progressBarStress.setBounds(79, 254, 20, 85);
		frmSL.getContentPane().add(progressBarStress);
		progressBarStress.setValue(Stressvalue);
		
		progressBarHappiness = new JProgressBar();
		progressBarHappiness.setToolTipText("Less happiness increases tax. To increase happiness, get  marry and have kids!");
		progressBarHappiness.setOrientation(SwingConstants.VERTICAL);
		progressBarHappiness.setBounds(141, 254, 20, 85);
		frmSL.getContentPane().add(progressBarHappiness);
		progressBarHappiness.setValue(Happyvalue);
		
		
		JLabel lblStress = new JLabel("Stress");
		lblStress.setBounds(73, 339, 44, 16);
		frmSL.getContentPane().add(lblStress);
		
		JLabel lblHappiness = new JLabel("Happy");
		lblHappiness.setBounds(129, 339, 44, 16);
		frmSL.getContentPane().add(lblHappiness);
		
		progressBarLove = new JProgressBar();
		progressBarLove.setToolTipText("Less love increases tax. To increase Love, get marry and have kids.");
		progressBarLove.setValue(Lovevalue);
		progressBarLove.setOrientation(SwingConstants.VERTICAL);
		progressBarLove.setBounds(206, 254, 20, 85);
		frmSL.getContentPane().add(progressBarLove);

		
		JLabel lblLove = new JLabel("Love");
		lblLove.setBounds(201, 339, 61, 16);
		frmSL.getContentPane().add(lblLove);
		
		JLabel lblBank = new JLabel("Bank:");
		lblBank.setBounds(12, 28, 43, 16);
		frmSL.getContentPane().add(lblBank);
		
		bankTField = new JTextField();
		bankTField.setEditable(false);
		bankTField.setBounds(116, 25, 106, 28);
		frmSL.getContentPane().add(bankTField);
		bankTField.setColumns(10);
		bankTField.setText(ToDecimal("500000"));
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBackground(Color.LIGHT_GRAY);
		layeredPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		layeredPane.setBounds(6, 64, 421, 158);
		frmSL.getContentPane().add(layeredPane);
		
		JLabel lblPackage = new JLabel("Car");
		lblPackage.setBounds(223, 11, 26, 16);
		layeredPane.add(lblPackage);
		lblPackage.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		
		JLabel lblRangeOver = new JLabel("Range Over:");
		lblRangeOver.setBounds(6, 81, 75, 16);
		layeredPane.add(lblRangeOver);
		
		JLabel lblYaris = new JLabel("Yaris:");
		lblYaris.setBounds(6, 64, 61, 16);
		layeredPane.add(lblYaris);
		
		JLabel lblCamry = new JLabel("Camry:");
		lblCamry.setBounds(6, 47, 68, 16);
		layeredPane.add(lblCamry);
		
		JLabel lblFord = new JLabel("Ford:");
		lblFord.setBounds(6, 30, 61, 16);
		layeredPane.add(lblFord);
		
		JLabel lblBmw = new JLabel("BMW:");
		lblBmw.setBounds(6, 98, 75, 16);
		layeredPane.add(lblBmw);
		
		JLabel lblAudi = new JLabel("Audi:");
		lblAudi.setBounds(6, 113, 75, 16);
		layeredPane.add(lblAudi);
		
		JLabel lblMercedes = new JLabel("Mercedes:");
		lblMercedes.setBounds(6, 130, 75, 16);
		layeredPane.add(lblMercedes);
		JList listPrevious = new JList(modelPrevious);
		listPrevious.setBounds(273, 30, 54, 116);
		layeredPane.add(listPrevious);
		listPrevious.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		final JList listInventory = new JList(modelInventory);
		listInventory.setBounds(223, 30, 26, 116);
		layeredPane.add(listInventory);
		listInventory.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JLabel lblPreviousPrice = new JLabel("Pre-price");
		lblPreviousPrice.setBounds(261, 11, 54, 16);
		layeredPane.add(lblPreviousPrice);
		lblPreviousPrice.setFont(new Font("Lucida Grande", Font.PLAIN, 10));

		dealTField = new JTextField();
		dealTField.setBounds(169, 75, 42, 28);
		layeredPane.add(dealTField);
		dealTField.setColumns(10);
		dealTField.setText("0");
		
		final JList listMarket = new JList(model);
		listMarket.setBounds(97, 30, 61, 118);
		layeredPane.add(listMarket);
		listMarket.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		DefaultListModel modelDollarsign = new DefaultListModel();
		JList listDollarsign = new JList(modelDollarsign);
		listDollarsign.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listDollarsign.setBounds(85, 30, 12, 118);
		modelDollarsign.addElement("$");
		modelDollarsign.addElement("$");
		modelDollarsign.addElement("$");
		modelDollarsign.addElement("$");
		modelDollarsign.addElement("$");
		modelDollarsign.addElement("$");
		modelDollarsign.addElement("$");
		listDollarsign.setEnabled(false);
		layeredPane.add(listDollarsign);
		
		DefaultListModel modelPreDollarsign = new DefaultListModel();
		JList listPreDollarsign = new JList(modelPreDollarsign);
		listPreDollarsign.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listPreDollarsign.setEnabled(false);
		listPreDollarsign.setBounds(261, 30, 12, 116);
		modelPreDollarsign.addElement("$");
		modelPreDollarsign.addElement("$");
		modelPreDollarsign.addElement("$");
		modelPreDollarsign.addElement("$");
		modelPreDollarsign.addElement("$");
		modelPreDollarsign.addElement("$");
		modelPreDollarsign.addElement("$");
		listPreDollarsign.setEnabled(false);
		layeredPane.add(listPreDollarsign);
		
		
		JLabel lblCarLabel = new JLabel("CarLabel");
		lblCarLabel.setBounds(334, 3, 80, 60);
		layeredPane.add(lblCarLabel);	
		ImageIcon ImageCar=new ImageIcon("image/car.png");
		Image img = ImageCar.getImage();
		Image newimg = img.getScaledInstance(80, 80,  java.awt.Image.SCALE_SMOOTH);
		ImageCar = new ImageIcon(newimg);
		lblCarLabel.setIcon(ImageCar);
		
		// Button ==> Buy
		final JButton btnBuy = new JButton("Buy =>");
		btnBuy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				btnBuy.setFocusable(false);
			}
		});
		btnBuy.setBounds(157, 43, 62, 29);
		layeredPane.add(btnBuy);
		btnBuy.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		btnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int A = Integer.valueOf(dealTField.getText());
				int BankValue = FromDecimal(bankATField.getText());
				if(!listMarket.isSelectionEmpty() && A>0){
					int xInventory = Integer.valueOf((java.lang.String) modelInventory.elementAt(listMarket.getSelectedIndex()));
					if(A<=1){
						if(xInventory+A<=1){
							int Total = FromDecimal((java.lang.String) listMarket.getSelectedValue()) * A;
							if(Total <= BankValue){
								Salary = BankValue-Total;
								bankATField.setText(ToDecimal(Integer.toString(FromDecimal(Integer.toString(Salary)))));
								
								modelInventory.remove(listMarket.getSelectedIndex());
								modelInventory.add(listMarket.getSelectedIndex(), Integer.toString(A+xInventory));
								
								modelPrevious.remove(listMarket.getSelectedIndex());
								modelPrevious.add(listMarket.getSelectedIndex(), listMarket.getSelectedValue());	
								
								CarCollective[listMarket.getSelectedIndex()] = CarCollective[listMarket.getSelectedIndex()]+
										Total;
								
							}else{
								Note(encodeThis("ببووره‌ پاره‌كه‌ت به‌شی ئه‌م مامه‌ڵه‌یه‌ ناكات :)"));
							}
						}else{
							Note("You already bought "+xInventory+ " cars and can't buy "+A+" more cars");
						}
					}else{
						Note("You can't buy more than 1 car");
					}	
				}else{
					Note("Please select a type of car to buy");
				}
			}
		});
		
		// Button ==> Sell
		JButton btnSell = new JButton("<= Sell ");
		btnSell.setBounds(157, 109, 62, 29);
		layeredPane.add(btnSell);
		btnSell.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		btnSell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!listInventory.isSelectionEmpty()){
					int inx = listInventory.getSelectedIndex();
					int A = Integer.valueOf(dealTField.getText());
					int BankValue = FromDecimal(bankATField.getText());
					int B = FromDecimal((java.lang.String) listInventory.getSelectedValue());
					if(!listInventory.isSelectionEmpty() && B>0 && A>0){
						int Total = FromDecimal((java.lang.String) model.elementAt(inx)) * A;
						if(B >= A){
							int RemainInventory = B-A;
							Salary = BankValue+Total;
							bankATField.setText(ToDecimal(Integer.toString(FromDecimal(Integer.toString(Salary)))));
							modelInventory.remove(inx);
							modelInventory.add(inx, Integer.toString(RemainInventory)); 
							
							// Collective
							if(CarCollective[inx] - Total >= 0 ){
								CarCollective[inx] = CarCollective[inx]-Total;
							}else{
								CarCollective[inx] = 0;
							}
						}
						}
				}
				}
			
		});
		
		JDesktopPane desktopPane_1 = new JDesktopPane();
		desktopPane_1.setBounds(12, 0, 852, 56);
		frmSL.getContentPane().add(desktopPane_1);
		
		// ProgressBar
		progressBar = new JProgressBar();
		progressBar.setOrientation(SwingConstants.VERTICAL);
		progressBar.setBounds(633, 9, 31, 25);
		desktopPane_1.add(progressBar);
		progressBar.setValue(1);
		
		dayTField = new JTextField();
		dayTField.setEditable(false);
		dayTField.setBounds(658, 6, 42, 28);
		desktopPane_1.add(dayTField);
		dayTField.setColumns(10);
		dayTField.setText("1");
		
		monthTField = new JTextField();
		monthTField.setEditable(false);
		monthTField.setBounds(694, 6, 31, 28);
		desktopPane_1.add(monthTField);
		monthTField.setColumns(10);
		monthTField.setText(Integer.toString(month));
		
		//JLabel lblMonth = new JLabel(encodeThis("مانگ"));
		JLabel lblMonth = new JLabel("M");
		lblMonth.setBounds(704, 32, 26, 16);
		desktopPane_1.add(lblMonth);
		
		//JLabel lblDay = new JLabel(encodeThis("ڕۆژ"));
		JLabel lblDay = new JLabel("Day");
		lblDay.setBounds(668, 32, 26, 16);
		desktopPane_1.add(lblDay);
		
		textField = new JTextField();
		textField.setText("$");
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(90, 3, 23, 22);
		desktopPane_1.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setText("$");
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(90, 28, 23, 22);
		desktopPane_1.add(textField_1);
		
		yearTField = new JTextField();
		yearTField.setText(Integer.toString(year));
		yearTField.setEditable(false);
		yearTField.setColumns(10);
		yearTField.setBounds(718, 6, 47, 28);
		desktopPane_1.add(yearTField);
		
		//JLabel lblYear = new JLabel(encodeThis("ساڵ"));
		JLabel lblYear = new JLabel("Year");
		lblYear.setBounds(728, 33, 31, 16);
		desktopPane_1.add(lblYear);
		
		// Button ==> NextDay
		final JButton btnNextDay = new JButton("Next Day");
		btnNextDay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				btnNextDay.setFocusable(false);
			}
		});
		btnNextDay.setBounds(755, 28, 95, 28);
		desktopPane_1.add(btnNextDay);
		btnNextDay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//market
				model.removeAllElements();
				model.addElement(ToDecimal(Integer.toString(marketprice(2000,21000))));
				model.addElement(ToDecimal(Integer.toString(marketprice(1000,17000))));
				model.addElement(ToDecimal(Integer.toString(marketprice(400,10600))));
				model.addElement(ToDecimal(Integer.toString(marketprice(10000,150000))));
				model.addElement(ToDecimal(Integer.toString(marketprice(3000,40000))));
				model.addElement(ToDecimal(Integer.toString(marketprice(2000,29000))));
				model.addElement(ToDecimal(Integer.toString(marketprice(4000,71000))));
				//marketfruit
				modelMarketfruit.removeAllElements();
				modelMarketfruit.addElement(Integer.toString(marketprice(2,1)));
				modelMarketfruit.addElement(Integer.toString(marketprice(3,1)));
				modelMarketfruit.addElement(Integer.toString(marketprice(3,1)));
				modelMarketfruit.addElement(Integer.toString(marketprice(4,1)));
				modelMarketfruit.addElement(Integer.toString(marketprice(2,1)));
				//marketlaptop
				modelMarketlaptop.removeAllElements();
				modelMarketlaptop.addElement(Integer.toString(marketprice(20,590)));
				modelMarketlaptop.addElement(Integer.toString(marketprice(25,690)));
				modelMarketlaptop.addElement(ToDecimal(Integer.toString(marketprice(30,1090))));
				modelMarketlaptop.addElement(ToDecimal(Integer.toString(marketprice(50,2280))));
				modelMarketlaptop.addElement(Integer.toString(marketprice(15,490)));
				modelMarketlaptop.addElement(Integer.toString(marketprice(10,395)));
				
				Salary(); //getting salary, pay rent, update progress bars and tax field.
				progBar(); //for progress bar of the day count 1-31
			}
		});
		

		JLayeredPane layeredPane_1 = new JLayeredPane();
		layeredPane_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		layeredPane_1.setBounds(431, 64, 316, 124);
		frmSL.getContentPane().add(layeredPane_1);
		
		JLabel lblTomato = new JLabel("Tomato:");
		lblTomato.setBounds(6, 17, 61, 16);
		layeredPane_1.add(lblTomato);
		
		JLabel lblBanana = new JLabel("Banana:");
		lblBanana.setBounds(6, 33, 61, 16);
		layeredPane_1.add(lblBanana);
		
		JLabel lblApple = new JLabel("Apple:");
		lblApple.setBounds(6, 49, 54, 16);
		layeredPane_1.add(lblApple);
		
		JLabel lblBroccoli = new JLabel("Broccoli:");
		lblBroccoli.setBounds(6, 67, 61, 16);
		layeredPane_1.add(lblBroccoli);
		
		JLabel lblOrange = new JLabel("Orange:");
		lblOrange.setBounds(6, 83, 61, 16);
		layeredPane_1.add(lblOrange);
		final JList listMarketfruit = new JList(modelMarketfruit);
		listMarketfruit.setBounds(76, 17, 19, 83);
		layeredPane_1.add(listMarketfruit);
		listMarketfruit.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		
		JButton btnSellfruit = new JButton("<= Sell ");
		btnSellfruit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!listInventoryfruit.isSelectionEmpty()){
					int inx = listInventoryfruit.getSelectedIndex();
					int A = Integer.valueOf(dealTFieldfruit.getText());
					int BankValue = FromDecimal(bankATField.getText());
					int B = FromDecimal((java.lang.String) listInventoryfruit.getSelectedValue());
					if(!listInventoryfruit.isSelectionEmpty() && B>0 && A>0){
						int Total = FromDecimal((java.lang.String) modelMarketfruit.elementAt(inx)) * A;
						if(B >= A){
							int RemainInventory = B-A;
							Salary = BankValue+Total;
							bankATField.setText(ToDecimal(Integer.toString(FromDecimal(Integer.toString(Salary)))));
							modelInventoryfruit.remove(inx);
							modelInventoryfruit.add(inx, Integer.toString(RemainInventory)); 
							// Collective
							if(FruitCollective[inx] - Total >= 0 ){
								FruitCollective[inx] = FruitCollective[inx]-Total;
							}else{
								FruitCollective[inx] = 0;
							}
							
						}else{
							Note("You can sell "+B+" or less");
						}
						
						}
					
				}
			}
		});
		btnSellfruit.setBounds(93, 67, 61, 29);
		layeredPane_1.add(btnSellfruit);
		btnSellfruit.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		
		dealTFieldfruit = new JTextField();
		dealTFieldfruit.setBounds(102, 43, 42, 28);
		layeredPane_1.add(dealTFieldfruit);
		dealTFieldfruit.setText("0");
		dealTFieldfruit.setColumns(10);
		
		JButton btnBuyfruit = new JButton("Buy =>");
		btnBuyfruit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int A = Integer.valueOf(dealTFieldfruit.getText());
				int BankValue = FromDecimal(bankATField.getText());
				if(!listMarketfruit.isSelectionEmpty() && A>0){
					int xInventory = Integer.valueOf((java.lang.String) modelInventoryfruit.elementAt(listMarketfruit.getSelectedIndex()));
					if(A<=5){
						if(xInventory+A<=5){
							int Total = FromDecimal((java.lang.String) listMarketfruit.getSelectedValue()) * A;
							if(Total <= BankValue){
								Salary = BankValue-Total;
								bankATField.setText(ToDecimal(Integer.toString(FromDecimal(Integer.toString(Salary)))));
								modelInventoryfruit.remove(listMarketfruit.getSelectedIndex());
								modelInventoryfruit.add(listMarketfruit.getSelectedIndex(), Integer.toString(A+xInventory));

								modelPreviousfruit.remove(listMarketfruit.getSelectedIndex());
								modelPreviousfruit.add(listMarketfruit.getSelectedIndex(), listMarketfruit.getSelectedValue());
								
								FruitCollective[listMarketfruit.getSelectedIndex()] = FruitCollective[listMarketfruit.getSelectedIndex()]+
										Total;
							}else{
								Note("Sorry you don't have enough money");
							}
						}else{
							Note("You already bought "+xInventory+ " kilos and can't buy "+A+" more kilos");
						}
					}else{
						Note("You can't buy more than 5 kilos");
					}
					
				}else{
					Note("Please select a type of fruit to buy");
				}
			}
		});
		btnBuyfruit.setBounds(93, 19, 61, 29);
		layeredPane_1.add(btnBuyfruit);
		btnBuyfruit.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		
		layeredPane_1.add(listInventoryfruit);	
		layeredPane_1.add(listPreviousfruit);
		
		
		JLabel label = new JLabel("Pre-price");
		label.setBounds(202, 0, 54, 16);
		layeredPane_1.add(label);
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		
		JLabel lblKilo = new JLabel("Kilo");
		lblKilo.setBounds(152, 0, 32, 16);
		layeredPane_1.add(lblKilo);
		lblKilo.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		
		DefaultListModel modelPreDollarsignfruit = new DefaultListModel();
		JList listPreDollarsignfruit = new JList(modelPreDollarsignfruit);
		listPreDollarsignfruit.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listPreDollarsignfruit.setEnabled(false);
		listPreDollarsignfruit.setBounds(190, 16, 12, 85);
		modelPreDollarsignfruit.addElement("$");
		modelPreDollarsignfruit.addElement("$");
		modelPreDollarsignfruit.addElement("$");
		modelPreDollarsignfruit.addElement("$");
		modelPreDollarsignfruit.addElement("$");
		listPreDollarsignfruit.setEnabled(false);
		layeredPane_1.add(listPreDollarsignfruit);
		
		DefaultListModel modelDollarsignfruit = new DefaultListModel();
		JList listDollarsignfruit = new JList(modelDollarsignfruit);
		listDollarsignfruit.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listDollarsignfruit.setEnabled(false);
		listDollarsignfruit.setBounds(64, 17, 12, 83);
		modelDollarsignfruit.addElement("$");
		modelDollarsignfruit.addElement("$");
		modelDollarsignfruit.addElement("$");
		modelDollarsignfruit.addElement("$");
		modelDollarsignfruit.addElement("$");
		listDollarsignfruit.setEnabled(false);
		layeredPane_1.add(listDollarsignfruit);
		
		JLabel lblFruit = new JLabel("Fruit");
		lblFruit.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblFruit.setBounds(256, 3, 54, 60);
		layeredPane_1.add(lblFruit);
		ImageIcon ImageFruit=new ImageIcon("image/apple.png");
		Image img2 = ImageFruit.getImage();
		Image newimg2 = img2.getScaledInstance(65, 65,  java.awt.Image.SCALE_SMOOTH);
		ImageFruit = new ImageIcon(newimg2);
		lblFruit.setIcon(ImageFruit);
		
		JLayeredPane layeredPane_2 = new JLayeredPane();
		layeredPane_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		layeredPane_2.setBounds(431, 198, 360, 141);
		frmSL.getContentPane().add(layeredPane_2);
		JList listPreviouslaptop = new JList(modelPreviouslaptop);
		listPreviouslaptop.setBounds(233, 22, 54, 105);
		layeredPane_2.add(listPreviouslaptop);
		listPreviouslaptop.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		final JList listInventorylaptop = new JList(modelInventorylaptop);
		listInventorylaptop.setBounds(184, 22, 26, 105);
		layeredPane_2.add(listInventorylaptop);
		listInventorylaptop.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		
		JLabel label_2 = new JLabel("Pre-price");
		label_2.setBounds(239, 6, 54, 16);
		layeredPane_2.add(label_2);
		label_2.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		

		JLabel lblLaptop = new JLabel("Laptop");
		lblLaptop.setBounds(184, 6, 42, 16);
		layeredPane_2.add(lblLaptop);
		lblLaptop.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		
		JButton btnSelllaptop = new JButton("<= Sell ");
		btnSelllaptop.setBounds(120, 78, 61, 29);
		layeredPane_2.add(btnSelllaptop);
		btnSelllaptop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!listInventorylaptop.isSelectionEmpty()){
					int inx = listInventorylaptop.getSelectedIndex();
					int A = Integer.valueOf(dealTFieldlaptop.getText());
					int BankValue = FromDecimal(bankATField.getText());
					int B = FromDecimal((java.lang.String) listInventorylaptop.getSelectedValue());
					if(!listInventorylaptop.isSelectionEmpty() && B>0 && A>0){
						int Total = FromDecimal((java.lang.String) modelMarketlaptop.elementAt(inx)) * A;
						if(B >= A){
							int RemainInventory = B-A;
							Salary = BankValue+Total;
							bankATField.setText(ToDecimal(Integer.toString(FromDecimal(Integer.toString(Salary)))));
							modelInventorylaptop.remove(inx);
							modelInventorylaptop.add(inx, Integer.toString(RemainInventory)); 
							
							// Collective
							if(LaptopCollective[inx] - Total >= 0 ){
								LaptopCollective[inx] = LaptopCollective[inx]-Total;
							}else{
								LaptopCollective[inx] = 0;
							}
						}
						
						}
					
				}
			}
		});
		btnSelllaptop.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		
		dealTFieldlaptop = new JTextField();
		dealTFieldlaptop.setBounds(130, 54, 42, 28);
		layeredPane_2.add(dealTFieldlaptop);
		dealTFieldlaptop.setText("0");
		dealTFieldlaptop.setColumns(10);
		
		final JList listMarketlaptop = new JList(modelMarketlaptop);
		listMarketlaptop.setBounds(80, 22, 40, 103);
		layeredPane_2.add(listMarketlaptop);
		listMarketlaptop.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JButton btnBuylaptop = new JButton("Buy =>");
		btnBuylaptop.setBounds(120, 30, 61, 29);
		layeredPane_2.add(btnBuylaptop);
		btnBuylaptop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int A = Integer.valueOf(dealTFieldlaptop.getText());
				int BankValue = FromDecimal(bankATField.getText());
				if(!listMarketlaptop.isSelectionEmpty() && A>0){
					int xInventory = Integer.valueOf((java.lang.String) modelInventorylaptop.elementAt(listMarketlaptop.getSelectedIndex()));
					if(A<=5){
						if(xInventory+A<=5){
							int Total = FromDecimal((java.lang.String) listMarketlaptop.getSelectedValue()) * A;
							if(Total <= BankValue){
								Salary = BankValue-Total;
								bankATField.setText(ToDecimal(Integer.toString(FromDecimal(Integer.toString(Salary)))));
								
								modelInventorylaptop.remove(listMarketlaptop.getSelectedIndex());
								modelInventorylaptop.add(listMarketlaptop.getSelectedIndex(), Integer.toString(A+xInventory));

								modelPreviouslaptop.remove(listMarketlaptop.getSelectedIndex());
								modelPreviouslaptop.add(listMarketlaptop.getSelectedIndex(), listMarketlaptop.getSelectedValue());
								
								LaptopCollective[listMarketlaptop.getSelectedIndex()] = LaptopCollective[listMarketlaptop.getSelectedIndex()]+
										Total;
								
							}else{
								Note(encodeThis("ببووره‌ پاره‌كه‌ت به‌شی ئه‌م مامه‌ڵه‌یه‌ ناكات :)"));
							}
						}else{
							Note("You already bought "+xInventory+ " laptops and can't buy "+A+" more laptops");
						}
					}else{
						Note("You can't buy more than 5 laptops");
					}
					}else{
						Note("Please select a type of laptop to buy");
					}
				}
			
		});
		btnBuylaptop.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		
		JLabel lblDell = new JLabel("Dell:");
		lblDell.setBounds(6, 22, 54, 16);
		layeredPane_2.add(lblDell);
		
		JLabel lblAsus = new JLabel("Asus:");
		lblAsus.setBounds(6, 38, 54, 16);
		layeredPane_2.add(lblAsus);
		
		JLabel lblLenovo = new JLabel("Lenovo:");
		lblLenovo.setBounds(6, 55, 61, 16);
		layeredPane_2.add(lblLenovo);
		
		JLabel lblMacbookPro = new JLabel("MacBook:");
		lblMacbookPro.setBounds(6, 73, 113, 16);
		layeredPane_2.add(lblMacbookPro);
		
		JLabel lblSony = new JLabel("Sony:");
		lblSony.setBounds(6, 90, 76, 16);
		layeredPane_2.add(lblSony);
		
		JLabel lblAcer = new JLabel("Acer:");
		lblAcer.setBounds(6, 107, 76, 16);
		layeredPane_2.add(lblAcer);
		
		DefaultListModel modelDollarsignlaptop = new DefaultListModel();
		JList listDollarsignlaptop = new JList(modelDollarsignlaptop);
		listDollarsignlaptop.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listDollarsignlaptop.setEnabled(false);
		listDollarsignlaptop.setBounds(68, 22, 12, 103);
		modelDollarsignlaptop.addElement("$");
		modelDollarsignlaptop.addElement("$");
		modelDollarsignlaptop.addElement("$");
		modelDollarsignlaptop.addElement("$");
		modelDollarsignlaptop.addElement("$");
		modelDollarsignlaptop.addElement("$");
		listDollarsignlaptop.setEnabled(false);
		layeredPane_2.add(listDollarsignlaptop);
		
		DefaultListModel modelPreDollarsignlaptop = new DefaultListModel();
		JList listPreDollarsignlaptop = new JList(modelPreDollarsignlaptop);
		listPreDollarsignlaptop.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listPreDollarsignlaptop.setEnabled(false);
		listPreDollarsignlaptop.setBounds(222, 22, 12, 105);
		modelPreDollarsignlaptop.addElement("$");
		modelPreDollarsignlaptop.addElement("$");
		modelPreDollarsignlaptop.addElement("$");
		modelPreDollarsignlaptop.addElement("$");
		modelPreDollarsignlaptop.addElement("$");
		modelPreDollarsignlaptop.addElement("$");
		listPreDollarsignlaptop.setEnabled(false);
		layeredPane_2.add(listPreDollarsignlaptop);
		
		JLabel lblLaptopLabel = new JLabel("Laptop");
		lblLaptopLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblLaptopLabel.setBounds(292, 5, 68, 60);
		layeredPane_2.add(lblLaptopLabel);
		ImageIcon ImageLaptop=new ImageIcon("image/laptop.png");
		Image img3 = ImageLaptop.getImage();
		Image newimg3 = img3.getScaledInstance(65, 65,  java.awt.Image.SCALE_SMOOTH);
		ImageLaptop = new ImageIcon(newimg3);
		lblLaptopLabel.setIcon(ImageLaptop);
		
		JLabel lblCopyRightLabel = new JLabel("(c) 2015 By HezhaLab");
		lblCopyRightLabel.setFont(new Font("HanziPen SC", Font.PLAIN, 10));
		lblCopyRightLabel.setBounds(741, 351, 123, 16);
		frmSL.getContentPane().add(lblCopyRightLabel);
		
		//final JButton btnNewButton = new JButton(encodeThis("وه‌رگرتنی قه‌رز"));
		final JButton btnBorrowMoney = new JButton("Borrow money");
		btnBorrowMoney.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				btnBorrowMoney.setFocusable(false);
			}
		});
		btnBorrowMoney.setBounds(279, 254, 106, 56);
		frmSL.getContentPane().add(btnBorrowMoney);
		btnBorrowMoney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int x = FromDecimal(bankATField.getText());
				if(!bankTField.getText().equals("0")){
				if(x > 6000){ //can't borrow money if there is less than 6000 in your account.
					String y = JOptionPane.showInputDialog(null, "How much money do you want to borrow?");
					if(y!= null && Integer.parseInt(y)>0){ // Add to check if y is string then exclude.
						int borrow = Integer.parseInt(y);
						int TheBank = FromDecimal(bankTField.getText());
							if(TheBank >= borrow){
								if(borrow==1000 || borrow==5000 || borrow==10000 || borrow==20000 || borrow==30000 || borrow==40000
										|| borrow==50000){
								
								bankTField.setText(Integer.toString(TheBank-borrow));
								bankATField.setText(Integer.toString(FromDecimal(bankATField.getText())+borrow));
								}else{
									Note("You can only borrow $1000,$5000,$10000,$20000,$30000,$40000, or $50000 exactly");
								}
								if(borrow==1000){
									Loan=1;
								}else if(borrow==5000){
									Loan=5;
								}else if(borrow==10000){
									Loan=10;
								}else if(borrow==20000){
									Loan=20;
								}else if(borrow==30000){
									Loan=30;
								}else if(borrow==40000){
									Loan=40;
								}else if(borrow==50000){
									Loan=50;
								}
								// increase Stress.
								CalculateValue(Loan,0,0);
								TaxCal();
								
						}else{
							JOptionPane.showMessageDialog(null, "Sorry! we can't lend you more than "+TheBank+" dollars");
						}
					}
				}else{
					JOptionPane.showMessageDialog(null, "You can't borrow money from the bank unless you have\n"
							+"more than $6000 dollar in your bank account");
				}
				
				}else{
					JOptionPane.showMessageDialog(null, "Sorry! You can't lend anymore money");
				}
				
				
			}
		});
		
		final JButton btnLargeHouse = new JButton("Rent large house");
		btnLargeHouse.setBounds(751, 145, 113, 43);
		frmSL.getContentPane().add(btnLargeHouse);
		btnLargeHouse.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		btnLargeHouse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LargeHouse();
				btnLargeHouse.setEnabled(false);
				LargeHouseEnable = false;
			}
		});
	}
	
	//Generate random number of today's market price. x=The number to be chosen randomly, 
	//y=minimum number to be added to whatever random number.
	public int marketprice(int x, int y){
		Random rn = new Random();
		int twodaycost =  rn.nextInt(x) + y;
		return twodaycost;
	}
	// progBar() function is for the bar that shows day of the month progress.
	public void progBar(){
		double z = (double) Integer.valueOf(dayTField.getText())/31*100;
		progressBar.setValue((int)z);
		//progressBar.setStringPainted(true);
		//progressBar.setString(Integer.toString((int)z)+"%");
	}
	
	public void Salary(){
		if(SalaryDayCount==31){
			if(month == 12){
				month = 1;
				year += 1;
				dayTField.setText("1");
				monthTField.setText(Integer.toString(month));
				yearTField.setText(Integer.toString(year));
			}else{
				dayTField.setText("1");
				month +=1;
				monthTField.setText(Integer.toString(month));
			}
			// After every month, the following functions run.
		    Rent();
		    Note("You paid the rent and taxes");
			SalaryDayCount =1;
			Salary += 500;
			bankATField.setText(ToDecimal(Integer.toString(FromDecimal(Integer.toString(Salary)))));
			JOptionPane.showMessageDialog(null, "You received salary");
			//Stress();
			Happy();
			Love();
			TaxCal();
		}else{
			SalaryDayCount +=1;
			dayTField.setText(Integer.toString(Integer.valueOf(dayTField.getText())+1));
		}
	}
	
	public void Rent(){
		if(statusTField.getText().equals("Married")){
			if(Integer.parseInt(childTField.getText())>0){
				rentTField.setText(ToDecimal((Integer.toString((Integer.parseInt(childTField.getText())*childRent+marrageRent)))));
				JOptionPane.showMessageDialog(null, "You paid your house rent");
			}else{
				rentTField.setText(ToDecimal(Integer.toString(marrageRent)));
				JOptionPane.showMessageDialog(null, "You paid your house rent");
			}
		}
		//int StressBarX = (int) (((double)Stressvalue/100) * FromDecimal(bankATField.getText()));
		//int HappyBarX = (int) ((double)(100-Happyvalue)/100 * FromDecimal(bankATField.getText()));
		//int LoveBarX = (int) ((double)(100-Lovevalue)/100 * FromDecimal(bankATField.getText()));
		//int Total = StressBarX + HappyBarX + LoveBarX;
		int X = FromDecimal(bankATField.getText());
		if(X>0){
			bankATField.setText(ToDecimal(Integer.toString(X-FromDecimal(rentTField.getText())-FromDecimal(taxTField.getText()))));
		}else{
			bankATField.setText(ToDecimal(Integer.toString(X-500))); //If less than zero, subtract only $500 monthly
		}
		
		Salary = FromDecimal(bankATField.getText());
	}
	public void getMarried(){
		if(statusTField.getText().equals("Single")){
			if(FromDecimal(bankATField.getText()) >= 8800){ // 8800 is the minimum of money you need to have before getting married.
				statusTField.setText("Married");
				bankATField.setText(ToDecimal(Integer.toString(FromDecimal(bankATField.getText())-costOfMarrage))) ;
				rentTField.setText(ToDecimal(Integer.toString(marrageRent)));
				//Stress +
				CalculateValue(10,0,0);
				//Happyvalue +
				CalculateValue(0,5,0);
				//Lovevalue +
				CalculateValue(0,0,10);
				
				JOptionPane.showMessageDialog(null, "Yahooo!! Congratulation! you got married. Remember you'll burden "
						+ "extra responsibility from now on!\n"+encodeThis("پیرۆزه‌! به‌هیوای ژیانێكی خۆشوو پڕ كامه‌رانی. ته‌نها له‌بیرتبێت خێزان پێكه‌وه‌نان ڕه‌نجی زیاتری پێویسته‌"));
				
			}else{
				JOptionPane.showMessageDialog(null, "Sorry! you can't get married unless you have at least $8800 in your bank \n"+encodeThis("ببوره‌ ناتوانیت خێزان پێكه‌وه‌ بنه‌یت به‌ كه‌متر له‌ ٢٠٠ دۆلار له‌ بانكه‌كه‌تدا! به‌هیوای به‌ختێكی باش"));
			}
		}else{
			JOptionPane.showMessageDialog(null, "Hey! you already got married, aren't you satisfied with your wife?\n"+encodeThis("ببوره‌ به‌پێی قانوون ناتوانیت زیاتر له‌ ژنێك بێنیت"));
		}
	}
	// encode kurdish letter with this function
	public String encodeThis(String x){
		String kurdish = x;
		try {
			 new String(kurdish.getBytes("UTF-8"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return kurdish;
		
	}
	public void kid(){
		if(statusTField.getText().equals("Married")){
			if(LargeHouseEnable == false){
				kid +=1;
				childTField.setText(Integer.toString(kid));
				rentTField.setText(ToDecimal(Integer.toString(childRent*kid+marrageRent)));
				
				//Stressvalue += 5;
				//progressBarStress.setValue(Stressvalue);
				CalculateValue(5,0,0);
				//Happyvalue += 2;
				//progressBarHappiness.setValue(Happyvalue);
				CalculateValue(0,2,0);
				//Lovevalue += 1;
				CalculateValue(0,0,1);
				
			}else{
				JOptionPane.showMessageDialog(null, "Unfortunately you don't have enough space to have children.\n"
						+ "Please, try to buy a larger house.\n"+ encodeThis("ناتوانیت منداڵت هه‌بێت، هه‌وڵبده‌ خانویه‌كی گه‌وره‌تر بكریت"));
			}
		}else{
			JOptionPane.showMessageDialog(null, "Don't you know that you should get marry first before making a child?"
					+ "\n"+encodeThis("ده‌زانیت كه‌ ناتوانیت مندال بخه‌یته‌وه‌ پێش ئه‌وه‌ی زن بهێنیت؟"));
		}
	}
	public void LargeHouse(){ // allows having children and also increases happiness.
		if(FromDecimal(bankATField.getText()) >=200){
			marrageRent = 800;
			rentTField.setText(ToDecimal(Integer.toString(marrageRent)));
		}else{
			JOptionPane.showMessageDialog(null, "You should at least have $5000 in your bank to rent a large house");
		}
	}
	public int FromDecimal(String x){
		int xx =0;
		try {
		    NumberFormat Format = NumberFormat.getNumberInstance(Locale.UK);
		      xx = Format.parse(x).intValue();
		      
		} catch(ParseException e) {
		    //Handle exception
			
		}
		return xx;
		
		
	}
	public String ToDecimal(String x){	
		double amount = Double.parseDouble(x);
		DecimalFormat formatter = new DecimalFormat("#,###");
		//return NumberFormat.getNumberInstance(Locale.US).format(Integer.parseInt(x));
		return formatter.format(amount);
	}
	
	public void Happy(){
		if(statusTField.getText().equals("Married")){
			int x = progressBarHappiness.getValue()+2;
			if(x>100){
				Happyvalue = 100;
			}else{
				Happyvalue = x;	
			}
			progressBarHappiness.setValue(Happyvalue);
			
		}else{
			int x = progressBarHappiness.getValue()-1;
			if(x<40){
				Happyvalue = 40;
			}else{
				Happyvalue = x;
			}
			progressBarHappiness.setValue(Happyvalue);
		}
	}
	public void Love(){
		if(statusTField.getText().equals("Married")){
			int x = progressBarLove.getValue()+4;
			if(x>100){
				Lovevalue = 100;
			}else{
				Lovevalue = x;
			}
			progressBarLove.setValue(Lovevalue);
			
		}else{
			int x = progressBarLove.getValue()-2;
			if(x<10){
				Lovevalue = 10;
			}else{
				Lovevalue = x;
			}
			progressBarLove.setValue(Lovevalue);
		}
	}
	// to return 100 for the progress bars if the value exceeds 100. 
	public void CalculateValue(int x, int y, int z){
		if(x>0){
			if(Stressvalue+x>100){ // add || Stressvalue+x<0
				Stressvalue = 100;
				progressBarStress.setValue(Stressvalue);
			}else{
				Stressvalue += x;
				progressBarStress.setValue(Stressvalue);
			}
		}else if(y>0){
			if(Happyvalue+y>100){
				Happyvalue = 100;
				progressBarHappiness.setValue(Happyvalue);
			}else{
				Happyvalue += y;
				progressBarHappiness.setValue(Happyvalue);
			}
		}else if(z>0){
			if(Lovevalue+z>100){
				Lovevalue = 100;
				progressBarLove.setValue(Lovevalue);
			}else{
				Lovevalue += z;
				progressBarLove.setValue(Lovevalue);
			}
		}
	}
	public void Note(String x){
		JOptionPane.showMessageDialog(null, x);
	}
	// runs TaxCal() at the end of the month
	public void TaxCal(){
		int x1 = Sum(FruitCollective,5);
		int y1 = Sum(LaptopCollective,6);
		int z1 = Sum(CarCollective,7);
		int xyz = x1+y1+z1;
		int StressBarX = (int) (((double)Stressvalue/100) * (FromDecimal(bankATField.getText())+xyz));
		int HappyBarX = (int) ((double)(100-Happyvalue)/100 * (FromDecimal(bankATField.getText())+xyz));
		int LoveBarX = (int) ((double)(100-Lovevalue)/100 * (FromDecimal(bankATField.getText())+xyz));
		int Total = StressBarX + HappyBarX + LoveBarX;
		if(Total<0){
			taxTField.setText(ToDecimal("100"));
		}else{
			taxTField.setText(ToDecimal(Integer.toString(Total)));
		}
		
		// the following IF to extend the Tax TextField while tax num needs more space
		int x = FromDecimal(taxTField.getText());
		if(x >= 0 && x < 10000){
			taxTField.setBounds(307, 0, 56, 28);
		}else if(x >= 10000 && x < 100000){
			taxTField.setBounds(307, 0, 60, 28);
		}else if(x >= 100000 && x < 1000000){
			taxTField.setBounds(307, 0, 70, 28);
		}
	}
	// Sum Collectives
		public int Sum(int[] x,int y){ // x:Collective type , y:array size
			int i = 0;  
			int sum = 0;
			while(i < y) {   
			   sum += x[i]; 
			   i++;           
			}
			return sum;
		}
	
}

