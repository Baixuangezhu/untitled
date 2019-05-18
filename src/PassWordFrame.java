import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class PassWordFrame extends JFrame implements ActionListener{
	JPanel panel1;
	JPanel panel2;
	JPanel panel3;
	JLabel label1;
	JLabel label2;
	JTextField textField;
	JPasswordField passwordField;
	JButton Enter;
	JButton Exit;
	String UserNumber;
	String PassWord;
	
	public PassWordFrame() {
		UserNumber = null;
		PassWord = null;
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		this.setLayout(new GridLayout(3,1));
		//设置显示大概在屏幕中央
		this.setLocation(this.getToolkit().getScreenSize().width/3 , this.getToolkit().getScreenSize().height/6);
		label1 = new JLabel("账户");
		label2 = new JLabel("密码");
		passwordField = new JPasswordField( "请输入密码",20);
		textField = new JTextField( "请输入账户",20);
		Enter = new JButton("确定");
		Exit = new JButton("退出");
		this.setSize(800, 800);
		this.setVisible(true);
		label1.setSize(400,50);
		label2.setSize(400, 50);
		//Enter.setBounds(0,0,100,60);//x,y,w,h   设置按钮大小
		//Enter.setPreferredSize(new Dimension(100,60));
		panel1.add(label1);
		panel1.add(textField);
		panel2.add(label2);
		panel2.add(passwordField);
		panel3.add(Enter);
		panel3.add(Exit);
		this.add(panel1);
		this.add(panel2);
		this.add(panel3);
		
		Exit.addActionListener(this);
		Enter.addActionListener(this);
	}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		dispose();//先关闭自己再创建下一个面板
		if(e.getSource() == Exit)
			System.exit(0);
		else if(e.getSource()== Enter) {
			
			
			UserNumber = textField.getText();
			PassWord = passwordField.getText();
			
			//..........添加检查用户账户，密码的代码....................................//
			
			
			System.out.println(UserNumber);
			System.out.println(PassWord);
			//........... 检查完 ..................//
			//记录用户的帐号和密码
			Transmit.UserNumber=UserNumber;
			Transmit.PassWord=PassWord;
			//............创建学生或管理员的面板...........//
			
			if(Transmit.isManager) {//是管理员
				JFrame WorkFrame = new JFrame("图书馆信息管理系统");
				WorkFrame.setSize(800, 800);
				WorkFrame.setLocation(WorkFrame.getToolkit().getScreenSize().width/3 , WorkFrame.getToolkit().getScreenSize().height/15);
				WorkFrame.setVisible(true);
				JTabbedPane TabPanel = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT ); 
				WorkFrame.add(TabPanel);
				
				Books BooksManagePanel = new Books("藏书管理");
				ManagePerson PersonalDataPanel = new ManagePerson("读者信息管理");
				Borrow BorrowPanel = new Borrow("图书借阅管理");
				BookSearch Search = new BookSearch("图书检索");
				PersonalData PersonalPanel = new PersonalData("个人信息");
				BookBorrow BorrowRecord = new BookBorrow("个人借阅记录");
				
				TabPanel.add(BooksManagePanel);
				TabPanel.add(PersonalDataPanel);
				TabPanel.add(BorrowPanel);
				TabPanel.add(PersonalPanel);
				TabPanel.add(Search);
				TabPanel.add(BorrowRecord);
				
			}
			
			else {//是读者
				JFrame WorkFrame = new JFrame("图书馆信息管理系统");
				WorkFrame.setSize(800, 800);
				WorkFrame.setLocation(WorkFrame.getToolkit().getScreenSize().width/3 , WorkFrame.getToolkit().getScreenSize().height/15);
				WorkFrame.setVisible(true);
				JTabbedPane TabPanel = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT ); 
				WorkFrame.add(TabPanel);
							
				BookSearch Search = new BookSearch("图书检索");
				PersonalData PersonalPanel = new PersonalData("个人信息");
				BookBorrow BorrowRecord = new BookBorrow("个人借阅记录");

				TabPanel.add(PersonalPanel);
				TabPanel.add(Search);
				TabPanel.add(BorrowRecord);
				
			}
			
			
			
		}
		
		
		
		
		
	}

}
