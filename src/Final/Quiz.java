package Final;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.TreeMap;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import com.sun.glass.events.KeyEvent;

public class Quiz extends JFrame implements ActionListener {
	private ButtonGroup bgroup;
	private ArrayList<Question> questions;
	private ArrayList<Answer> answers;
	private static final int QUESTIONS = 5;
	private ArrayList<JRadioButton> buttonList;
	private int qNumber;
	private Control control;

	public Quiz(int qNumber, Control control){
		this.qNumber = qNumber;
		this.control = control;
		setTitle("QUIZ FOR EXTRA POITNS!");
		setSize(new Dimension(450,450));
		questions = new ArrayList<Question>();
		JPanel buttons = new JPanel();
		buttons.setLayout(new GridLayout(2,2));
		bgroup=new ButtonGroup();
		setLayout(new GridLayout(2,1));
		
		setQuestions();
		
		int i=0;
		String question="";
		
		for(Question q : questions)
		{
			if(i == qNumber) 
			{
				question = q.getQuestion();
				answers = q.getAnswers();
				
				buttonList = new ArrayList<JRadioButton>();
				
				for(Answer s : answers)
				{
					System.out.println(s.getAnswer());
					JRadioButton button = new JRadioButton(s.getAnswer());
					bgroup.add(button);
					
					button.setMnemonic(KeyEvent.VK_F);
					button.addActionListener(this);
					buttons.add(button);
					buttonList.add(button);
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
			System.out.println("case 0 was run");
			if (((JRadioButton)e.getSource()).getText().equals(" It depends on the angle"))
			{
				control.finishQuiz();
			}

			dispose();
			break;

		case 1:		
			System.out.println("case 1 was run");
			if (((JRadioButton)e.getSource()).getText().equals(" Higher"))
			{
				control.finishQuiz();
			}
			
			dispose();

			break;

		case 2:
			System.out.println("case 2 was run");
			if (((JRadioButton)e.getSource()).getText().equals(" 2*Vo/g"))
			{
				control.finishQuiz();
			}
			
			dispose();

		case 3:
			System.out.println("case 3 was run");
			if (((JRadioButton)e.getSource()).getText().equals(" Decrease the total time in the air"))
			{
				control.finishQuiz();
			}
			
			dispose();

		case 4:
			System.out.println("case 4 was run");
			if (((JRadioButton)e.getSource()).getText().equals(" Increase the initial horizontal velocity"))
			{
				control.finishQuiz();
			}
			
			dispose();

		default:
			System.out.println("case -1 was run?");
			dispose();
			break;
		}
	}
	private void setQuestions(){
		ArrayList<Answer> answers0 = new ArrayList<Answer>();
		ArrayList<Answer> answers1 = new ArrayList<Answer>();
		ArrayList<Answer> answers2 = new ArrayList<Answer>();
		ArrayList<Answer> answers3 = new ArrayList<Answer>();
		ArrayList<Answer> answers4 = new ArrayList<Answer>();
		
		
		// run first
		answers0.add(new Answer(" A Farther Horizontal Distance", false));
		answers0.add(new Answer(" As Far of a Horizontal Distance", false));
		answers0.add(new Answer(" Not as Far of a Horizontal Distance", false));
		answers0.add(new Answer(" It depends on the angle", true));
		questions.add(new Question("As you increase the initial velocity, the ball will travel...", answers0));
		
		// run second
		answers1.add(new Answer(" Lower", false));
		answers1.add(new Answer(" The Same", false));
		answers1.add(new Answer(" Higher", true));
		answers1.add(new Answer(" A Farther Distance", false));
		questions.add(new Question("As you increase the angle, the ball will travel...", answers1));
		
		
		// run third
		answers2.add(new Answer(" Vo/g", false));
		answers2.add(new Answer(" Vo ^2 /g", false));
		answers2.add(new Answer(" 2*Vo/g", true));
		answers2.add(new Answer(" g/Vo", false));
		questions.add(new Question("The total time the ball is in the air is...", answers2));
		
		
		// run fourth
		answers3.add(new Answer(" Decrease the total time in the air", true));
		answers3.add(new Answer(" Increase the total time in the air", false));
		answers3.add(new Answer(" Increase the total horizontal distance gone", false));
		answers3.add(new Answer(" Decrease the total horizontal distance gone", false));
		questions.add(new Question("Decreasing the initial velocity will...", answers3));
		
		
		// run last, after victory condition
		// TODO: fix it
		answers4.add(new Answer(" Decrease the initial horizontal velocity", false));
		answers4.add(new Answer(" Increase the initial horizontal velocity", true));
		answers4.add(new Answer(" Increase the initial vertical velocity", false));
		answers4.add(new Answer(" Increase the total travel time", false));
		questions.add(new Question("Decreasing the angle will...", answers4));
		
		
//		TreeMap<String,Boolean> answers1=new TreeMap<String,Boolean>();
//		TreeMap<String,Boolean> answers2=new TreeMap<String,Boolean>();
//		TreeMap<String,Boolean> answers3=new TreeMap<String,Boolean>();
//		TreeMap<String,Boolean> answers4=new TreeMap<String,Boolean>();
//		TreeMap<String,Boolean> answers5=new TreeMap<String,Boolean>();
//		answers1.put(" A Farther Horizontal Distance", false);
//		answers1.put(" As Far of a Horizontal Distance", false);
//		answers1.put(" Not as Far of a Horizontal Distance", false);
//		answers1.put(" It depends on the angle", true);
//		questions.put("As you increase the initial velocity, the ball will travel...",answers1 );
//		answers2.put(" Lower", false);
//		answers2.put(" The Same", false);
//		answers2.put(" Higher", true);
//		answers2.put(" A Farther Distance", false);
//		questions.put("As you increase the angle, the ball will travel...",answers2 );
		
//		answers3.put(" Vo/g", false);
//		answers3.put(" Vo ^2 /g", false);
//		answers3.put(" 2*Vo/g", true);
//		answers3.put(" g/Vo", false);
//		questions.put("The total time the ball is in the air is...",answers3 );
		
//		answers4.put(" Decrease the total time in the air", true);
//		answers4.put(" Increase the total time in the air", false);
//		answers4.put(" Increase the total horizontal distance gone", false);
//		answers4.put(" Decrease the total horizontal distance gone", false);
//		questions.put("Decreasing the initial velocity will...",answers4 );
		
//		answers5.put(" Decrease the initial horizontal velocity", false);
//		answers5.put(" Increase the initial horizontal velocity", true);
//		answers5.put(" Increase the initial vertical velocity", false);
//		answers5.put(" Increase the total travel time", false);
//		questions.put("Decreasing the angle will...",answers5 );
	}

}
