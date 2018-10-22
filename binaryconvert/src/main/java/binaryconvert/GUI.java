package binaryconvert;

import  javax.swing.*;
import java.awt.*;
import  java.awt.event.*;

public class GUI extends JFrame implements ActionListener {
	private JLabel myLabel;
	private JTextField myTextField;
	private JButton toDecButton;
	private JButton toBinButton;
	private JLabel result;
	private Convert Cv;
	
	public GUI()
	{
		myLabel = new JLabel("Podaj liczbe");
		myTextField = new JTextField(10);
		toDecButton = new JButton("Przelicz na dzisietne");
		toBinButton = new JButton("Przelicz na binarne");
		result=new JLabel();
		toDecButton.addActionListener(this);
		toBinButton.addActionListener(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new FlowLayout());
		add(myLabel);
		add(myTextField);
		add(toDecButton);
		add(toBinButton);
		add(result);
		
		setBounds(100,100,310,400);
		setResizable(false);
	}
	
	public void actionPerformed(ActionEvent ev)
	{
		if (ev.getSource()==toDecButton)
		{
			Cv= new Convert();
			try
			{
				result.setText(Integer.toString(Cv.bintodec(myTextField.getText())));
			}
			catch (GUIException e)
			{
				result.setText(e.getMessage());
			}
			catch (NumberFormatException e)
			{
				result.setText("Cos zlego sie stanelo");
			}
		}
		if (ev.getSource()==toBinButton)
		{
			Cv=new Convert();
			try
			{
				result.setText(Cv.dectobin(Integer.parseInt(myTextField.getText())));
			}
			catch (GUIException e)
			{
				result.setText(e.getMessage());
			}
			catch (NumberFormatException e)
			{
				result.setText("Cos zlego sie stanelo");
			}
		}
	}

}
