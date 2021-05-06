package qna;

import java.awt.event.*;
import javax.swing.*;

class OnlineTest extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	JLabel label;
	JRadioButton radioButton[] = new JRadioButton[5];
	JButton btnNext, btnBookmark;
	ButtonGroup bg;
	int count = 0, current = 0, x = 1, y = 1, now = 0;
	int m[] = new int[10];

	OnlineTest(String s) {
		super(s);
		label = new JLabel();
		add(label);
		bg = new ButtonGroup();
		for (int i = 0; i < 5; i++) {
            radioButton[i] = new JRadioButton();
            add(radioButton[i]);
            bg.add(radioButton[i]);
		}
		btnNext = new JButton("Next");
		btnBookmark = new JButton("Bookmark");
		btnNext.addActionListener(this);
		btnBookmark.addActionListener(this);
		add(btnNext);
		add(btnBookmark);
		set();
		label.setBounds(30, 40, 450, 20);
		radioButton[0].setBounds(50, 80, 200, 20);
		radioButton[1].setBounds(50, 110, 200, 20);
		radioButton[2].setBounds(50, 140, 200, 20);
		radioButton[3].setBounds(50, 170, 200, 20);
		btnNext.setBounds(100, 240, 100, 30);
		btnBookmark.setBounds(270, 240, 100, 30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(370, 200); 
		setVisible(true);
		setSize(600, 350);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNext) {
			if (check())
				count = count + 1;
			current++;
			set();
			if (current == 9) {
				btnNext.setEnabled(false);
				btnBookmark.setText("Result");
			}
		}
		if (e.getActionCommand().equals("Bookmark")) {
			JButton bk = new JButton("Bookmark" + x);
			bk.setBounds(480, 20 + 30 * x, 100, 30);
			add(bk);
			bk.addActionListener(this);
			m[x] = current;
			x++;
			current++;
			set();
			if (current == 9)
				btnBookmark.setText("Result");
			setVisible(false);
			setVisible(true);
		}
		for (int i = 0, y = 1; i < x; i++, y++) {
			if (e.getActionCommand().equals("Bookmark" + y)) {
				if (check())
					count = count + 1;
				now = current;
				current = m[y];
				set();
				((JButton) e.getSource()).setEnabled(false);
				current = now;
			}
		}

		if (e.getActionCommand().equals("Result")) {
			if (check())
				count = count + 1;
			current++;
			JOptionPane.showMessageDialog(this, "correct answers= " + count);
			System.exit(0);
		}
	}

	void set() {
		radioButton[4].setSelected(true);
		if (current == 0) {
			label.setText("Que1:  If AB * AC = 2i-4j+4k, then the area of ABC is");
			radioButton[0].setText("4 sq. units");
			radioButton[1].setText("3 sq. units");
			radioButton[2].setText("16 sq. units");
			radioButton[3].setText("9 sq. units");
		}
		if (current == 1) {
			label.setText("Que2:  Find the sum of 122 + 231 + 313");
			radioButton[0].setText("700");
			radioButton[1].setText("666");
			radioButton[2].setText("444");
			radioButton[3].setText("845");
		}
		if (current == 2) {
			label.setText("Que3:  Cube root of 1331 is.");
			radioButton[0].setText("11");
			radioButton[1].setText("21");
			radioButton[2].setText("31");
			radioButton[3].setText("13");
		}
		if (current == 3) {
			label.setText("Que4: Which is the new method introduced in java 8 to iterate over a collection?");
			radioButton[0].setText("for (String i : StringList)");
			radioButton[1].setText("foreach (String i : StringList)");
			radioButton[2].setText("StringList.forEach()");
			radioButton[3].setText("List.for()");
		}
		if (current == 4) {
			label.setText("Que5: How to read entire file in one line using java 8?");
			radioButton[0].setText("Files.readAllLines()");
			radioButton[1].setText("Files.read()");
			radioButton[2].setText("Files.readFile()");
			radioButton[3].setText("Files.lines()");
		}
		if (current == 5) {
			label.setText("Que6:  Which feature of java 7 allows to not explicitly close IO resource?");
			radioButton[0].setText("try catch finally");
			radioButton[1].setText("IOException");
			radioButton[2].setText("AutoCloseable");
			radioButton[3].setText("Streams");
		}
		if (current == 6) {
			label.setText("Que7:  Who was the winner of Orange Cap in the IPL 2020?");
			radioButton[0].setText("K L Rahul");
			radioButton[1].setText("Virat Kohli");
			radioButton[2].setText("Kieron Pollard");
			radioButton[3].setText("Jasprit Bumrah");
		}
		if (current == 7) {
			label.setText("Que8:  Wembly is a famous football stadium in?");
			radioButton[0].setText("Barcelona");
			radioButton[1].setText("Dallas");
			radioButton[2].setText("London");
			radioButton[3].setText("Seoul");
		}
		if (current == 8) {
			label.setText("Que9: Chukker and Mallet terms are associated with the game of");
			radioButton[0].setText("Polo");
			radioButton[1].setText("Water Polo");
			radioButton[2].setText("Tennis");
			radioButton[3].setText("Basket Ball");
		}
		if (current == 9) {
			label.setText("Que10: Which of the following is not a state of object in Hibernate?");
			radioButton[0].setText("Attached()");
			radioButton[1].setText("Detached()");
			radioButton[2].setText("Persistent()");
			radioButton[3].setText("Transient()");
		}
		label.setBounds(30, 40, 450, 20);
		for (int i = 0, j = 0; i <= 90; i += 30, j++)
			radioButton[j].setBounds(50, 80 + i, 200, 20);
	}

	boolean check() {
		if (current == 0)
			return (radioButton[1].isSelected());
		if (current == 1)
			return (radioButton[1].isSelected());
		if (current == 2)
			return (radioButton[0].isSelected());
		if (current == 3)
			return (radioButton[2].isSelected());
		if (current == 4)
			return (radioButton[0].isSelected());
		if (current == 5)
			return (radioButton[1].isSelected());
		if (current == 6)
			return (radioButton[0].isSelected());
		if (current == 7)
			return (radioButton[2].isSelected());
		if (current == 8)
			return (radioButton[0].isSelected());
		if (current == 9)
			return (radioButton[0].isSelected());
		return false;
	}

	public static void main(String args[]) {
        Splash run =new Splash("C:\\Users\\ADMIN\\Documents\\NetBeansProjects\\JAVA Project\\src\\qna\\welcome.png");
        try {
            Thread.sleep(3000);
            run.dispose();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
		LoginDemo ok = new LoginDemo();
		ok.main(null);

		if (ok.LoginProcedure()) {
			new OnlineTest("Online Test App");
		}
	}
}