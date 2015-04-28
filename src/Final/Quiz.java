package Final;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import com.sun.glass.events.KeyEvent;

public class Quiz extends JFrame implements ActionListener {
	private ButtonGroup bgroup;
	private HashMap<String,HashMap<String,Boolean>> questions;
	private HashMap<String,Boolean> answers;
	private static final int QUESTIONS = 5;
	private ArrayList<JRadioButton> buttonList;
	private int qNumber;
	private Control control;

	public Quiz(int qNumber, Control control){
		this.qNumber = qNumber;
		this.control = control;
		setTitle("QUIZ FOR EXTRA POITNS!");
		setSize(new Dimension(300,250));
		questions=new HashMap<String,HashMap<String,Boolean>>();
		JPanel buttons=new JPanel();
		buttons.setLayout(new GridLayout(2,2));
		bgroup=new ButtonGroup();
		setLayout(new GridLayout(2,1));
		setQuestions();
		int i=0;
		String question="";
		for(String f : questions.keySet()){
			if(i==qNumber){
				question = f;
				answers=questions.get(f);
				buttonList = new ArrayList<JRadioButton>();
				for (String s : questions.get(f).keySet())
				{
					JRadioButton g = new JRadioButton(s);
					bgroup.add(g);
					g.setMnemonic(KeyEvent.VK_F);
					g.addActionListener(this);
					buttons.add(g);
					buttonList.add(g);
				}
			}
			i++;
		}
		add(new JLabel(question));
		add(buttons);

		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {


		switch(qNumber)
		{
		case 0:
			if(e.getSource().equals(buttonList.get(3))) {
				control.finishQuiz();
			}
			dispose();
			break;

		case 1:
			if(e.getSource().equals(buttonList.get(2))) {
				// you win the quiz
			}
			dispose();
			break;

		case 2:
			if(e.getSource().equals(buttonList.get(2))) {
				// you win the quiz
			}
			dispose();
			break;

		case 3:
			if(e.getSource().equals(buttonList.get(0))) {
				// you win the quiz
			}
			dispose();
			break;

		case 4:
			if(e.getSource().equals(buttonList.get(1))) {
				// you win the quiz
			}
			dispose();
			break;

		default:
			dispose();
			break;


		}


	
	}
	private void setQuestions(){
		HashMap<String,Boolean> answers1=new HashMap<String,Boolean>();
		HashMap<String,Boolean> answers2=new HashMap<String,Boolean>();
		HashMap<String,Boolean> answers3=new HashMap<String,Boolean>();
		HashMap<String,Boolean> answers4=new HashMap<String,Boolean>();
		HashMap<String,Boolean> answers5=new HashMap<String,Boolean>();
		answers1.put(" A Farther Horizontal Distance", false);
		answers1.put(" As Far of a Horizontal Distance", false);
		answers1.put(" Not as Far of a Horizontal Distance", false);
		answers1.put(" It depends on the angle", true);
		questions.put("As you increase the initial velocity, the ball will travel...",answers1 );
		answers2.put(" Lower", false);
		answers2.put(" The Same", false);
		answers2.put(" Higher", true);
		answers2.put(" A Farther Distance", false);
		questions.put("As you increase the angle, the ball will travel...",answers2 );
		answers3.put(" Vo/g", false);
		answers3.put(" Vo ^2 /g", false);
		answers3.put(" 2*Vo/g", true);
		answers3.put(" g/Vo", false);
		questions.put("The total time the ball is in the air is...",answers3 );
		answers4.put(" Decrease the total time in the air", true);
		answers4.put(" Increase the total time in the air", false);
		answers4.put(" Increase the total horizontal distance gone", false);
		answers4.put(" Decrease the total horizontal distance gone", false);
		questions.put("Decreasing the initial velocity will...",answers4 );
		answers5.put(" Decrease the initial horizontal velocity", false);
		answers5.put(" Increase the initial horizontal velocity", true);
		answers5.put(" Increase the initial vertical velocity", false);
		answers5.put(" Increase the total travel time", false);
		questions.put("Decreasing the angle will...",answers5 );
	}

}
