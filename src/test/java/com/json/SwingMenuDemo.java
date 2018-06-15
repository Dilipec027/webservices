package com.json;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SwingMenuDemo {

	private JTextArea result;
	private JTextField url;
	private JLabel headerLabel;
	private JLabel urlLable;
	private JButton postbutton;
	private JLabel resultLabel;
	private JButton getMethod;
	private JButton postMethod;
	private JTextField headerparamcount;
	private JButton submit;
	private JButton backButton;

	// public static void main(String[] args) {
	// SwingMenuDemo swingMenuDemo = new SwingMenuDemo();
	// swingMenuDemo.indexscreen();
	// }

	public void indexscreen() {
		JFrame mainFrame = new JFrame("Java SWING Examples");
		mainFrame.setSize(800, 800);
		mainFrame.setLayout(new GridLayout(20, 1));
		getMethod = new JButton("Get");
		postMethod = new JButton("Post");
		headerLabel = new JLabel("", JLabel.CENTER);
		headerLabel.setText("select the service you needed");

		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});
		getMethod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.dispose();
				prepareGetMethod();

			}
		});
		postMethod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.dispose();
				preparePostMethod();

			}
		});
		mainFrame.add(headerLabel);
		mainFrame.add(getMethod);
		mainFrame.add(postMethod);
		mainFrame.setVisible(true);
	}

	private void prepareGetMethod() {
		JFrame mainFrame = new JFrame("Java SWING Examples");
		mainFrame.setSize(800, 800);
		mainFrame.setLayout(new GridLayout(20, 20));

		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});
		JLabel headerLabel = new JLabel("", JLabel.CENTER);
		JLabel headerLabel1 = new JLabel("", JLabel.CENTER);
		JLabel statusLabel = new JLabel("", JLabel.CENTER);
		backButton = new JButton("Back");
		url = new JTextField();
		statusLabel.setSize(100, 100);
		headerLabel.setText("Enter the URL");
		headerLabel1.setText("please enter the number of the header setup needed");
		headerparamcount = new JTextField();
		submit = new JButton("Submit");
		mainFrame.add(headerLabel);
		mainFrame.add(url);
		mainFrame.add(headerLabel1);
		mainFrame.add(headerparamcount);
		mainFrame.add(submit);
		mainFrame.add(backButton);
		mainFrame.add(statusLabel);
		mainFrame.setVisible(true);
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					System.out.println("Header count is submitted" + headerparamcount.getText());
					int temp = Integer.parseInt(headerparamcount.getText());
					mainFrame.dispose();
					System.out.println(temp);
					prepareGetMethod1(temp);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					statusLabel.setText("Submitted the header count" + e1.toString());
				}
				statusLabel.setText("Submitted the header count" + headerparamcount.getText());
			}
		});
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.dispose();
				indexscreen();
			}
		});
	}

	private void prepareGetMethod1(int i) {

		JFrame mainFrame = new JFrame("Java SWING Examples");
		mainFrame.setSize(800, 800);
		int itemp = i + 5;
		System.out.println(itemp);
		mainFrame.setLayout(new GridLayout(itemp, 2));

		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});
		JLabel headerLabel = new JLabel("", JLabel.CENTER);
		JLabel headerLabel1 = new JLabel("", JLabel.CENTER);
		JLabel headerLabel3 = new JLabel("", JLabel.CENTER);
		JLabel statusLabel = new JLabel("", JLabel.CENTER);
		JTextArea result = new JTextArea();
		backButton = new JButton("Back");
		statusLabel.setSize(100, 100);
		headerLabel.setText("Headername");
		headerLabel1.setText("value");
		headerLabel3.setText("result");
		System.out.println("Inside the lastpost method");
		List<JTextField> text = new ArrayList<JTextField>();
		int size = 2 * i;
		for (int j = 0; j < size; j++) {
			text.add(new JTextField());
		}
		submit = new JButton("Submit");
		mainFrame.add(headerLabel);
		mainFrame.add(headerLabel1);
		for (int j = 0; j < size; j++) {
			mainFrame.add(text.get(j));
		}
		mainFrame.add(headerLabel3);
		mainFrame.add(result);
		mainFrame.add(submit);
		mainFrame.add(backButton);
		mainFrame.add(statusLabel);
		mainFrame.setVisible(true);
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BackEndCodeForGetandPost backendcode = new BackEndCodeForGetandPost();
				try {
					System.out.println("Inside the try block");
					List<String> temp = new ArrayList<String>();
					for (int j = 0; j < size; j++) {
						temp.add(text.get(j).getText());
					}
					result.setText(backendcode.sendGet(url.getText(), temp));
					System.out.println(temp);
					System.out.println(url);
					statusLabel.setText("Submitted the GET request");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					statusLabel.setText("Submitted the GET request" + e1.toString());
				}

			}
		});
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.dispose();
				preparePostMethod();
			}
		});
	}

	// private void prepareGUI() {
	// JFrame mainFrame = new JFrame("Java SWING Examples");
	// mainFrame.setSize(800, 800);
	// mainFrame.setLayout(new GridLayout(5,2));
	//
	// mainFrame.addWindowListener(new WindowAdapter() {
	// public void windowClosing(WindowEvent windowEvent) {
	// System.exit(0);
	// }
	// });
	// JLabel headerLabel = new JLabel("", JLabel.CENTER);
	// JLabel headerLabel1 = new JLabel("", JLabel.CENTER);
	// headerLabel1.setText("Value");
	// headerLabel.setText("Get Method");
	// JLabel statusLabel = new JLabel("", JLabel.CENTER);
	// statusLabel.setSize(100, 100);
	// // controlPanel = new JPanel();
	// // controlPanel.setLayout(new FlowLayout());
	// url = new JTextField();
	//// url.setSize(100, 100);
	// urlLable = new JLabel();
	//// urlLable.setSize(100, 100);
	// urlLable.setText("paste the URL in the below first box");
	// resultLabel = new JLabel();
	// resultLabel.setText("Result:");
	// result = new JTextArea();
	// postbutton = new JButton("Get");
	// backButton = new JButton("Back");
	// mainFrame.add(headerLabel);
	// mainFrame.add(headerLabel1);
	// mainFrame.add(urlLable);
	// mainFrame.add(url);
	// mainFrame.add(resultLabel);
	// mainFrame.add(result);
	// mainFrame.add(postbutton);
	// mainFrame.add(backButton);
	// mainFrame.add(statusLabel);
	// mainFrame.setVisible(true);
	// postbutton.addActionListener(new ActionListener() {
	// public void actionPerformed(ActionEvent e) {
	// BackEndCodeForGetandPost json = new BackEndCodeForGetandPost();
	// try {
	// result.setText(json.sendGet(url.getText()));
	// } catch (Exception e1) {
	// // TODO Auto-generated catch block
	// e1.printStackTrace();
	// result.setText(e1.toString());
	// }
	// statusLabel.setText("Get Button is clicked and result is in above text box.
	// Url is:" + url.getText());
	// }
	// });
	//
	// backButton.addActionListener(new ActionListener() {
	// public void actionPerformed(ActionEvent e) {
	// mainFrame.dispose();
	// Mainscreen();
	// }
	// });
	// }

	private void preparePostMethod() {
		JFrame mainFrame = new JFrame("Java SWING Examples");
		mainFrame.setSize(800, 800);
		mainFrame.setLayout(new GridLayout(20, 20));

		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});
		JLabel headerLabel = new JLabel("", JLabel.CENTER);
		JLabel headerLabel1 = new JLabel("", JLabel.CENTER);
		JLabel statusLabel = new JLabel("", JLabel.CENTER);
		backButton = new JButton("Back");
		url = new JTextField();
		statusLabel.setSize(100, 100);
		headerLabel.setText("Enter the URL");
		headerLabel1.setText("please enter the number of the header setup needed");
		headerparamcount = new JTextField();
		submit = new JButton("Submit");
		mainFrame.add(headerLabel);
		mainFrame.add(url);
		mainFrame.add(headerLabel1);
		mainFrame.add(headerparamcount);
		mainFrame.add(submit);
		mainFrame.add(backButton);
		mainFrame.add(statusLabel);
		mainFrame.setVisible(true);
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					System.out.println("Header count is submitted" + headerparamcount.getText());
					int temp = Integer.parseInt(headerparamcount.getText());
					mainFrame.dispose();
					System.out.println(temp);
					preparePostMethod1(temp);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					statusLabel.setText("Submitted the header count" + e1.toString());
				}
				statusLabel.setText("Submitted the header count" + headerparamcount.getText());
			}
		});
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.dispose();
				indexscreen();
			}
		});
	}

	private void preparePostMethod1(int i) {

		JFrame mainFrame = new JFrame("Java SWING Examples");
		mainFrame.setSize(800, 800);
		int itemp = i + 5;
		System.out.println(itemp);
		mainFrame.setLayout(new GridLayout(itemp, 2));

		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});
		JLabel headerLabel = new JLabel("", JLabel.CENTER);
		JLabel headerLabel1 = new JLabel("", JLabel.CENTER);
		JLabel headerLabel2 = new JLabel("", JLabel.CENTER);
		JLabel headerLabel3 = new JLabel("", JLabel.CENTER);
		JLabel statusLabel = new JLabel("", JLabel.CENTER);
		JTextArea dataField = new JTextArea();
		JTextArea result = new JTextArea();
		backButton = new JButton("Back");
		statusLabel.setSize(100, 100);
		headerLabel.setText("Headername");
		headerLabel1.setText("value");
		headerLabel2.setText("Data to be passed");
		headerLabel3.setText("result");
		System.out.println("Inside the lastpost method");
		List<JTextField> text = new ArrayList<JTextField>();
		int size = 2 * i;
		for (int j = 0; j < size; j++) {
			text.add(new JTextField());
		}
		submit = new JButton("Submit");
		mainFrame.add(headerLabel);
		mainFrame.add(headerLabel1);
		for (int j = 0; j < size; j++) {
			mainFrame.add(text.get(j));
		}
		mainFrame.add(headerLabel2);
		mainFrame.add(dataField);
		mainFrame.add(headerLabel3);
		mainFrame.add(result);
		mainFrame.add(submit);
		mainFrame.add(backButton);
		mainFrame.add(statusLabel);
		mainFrame.setVisible(true);
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BackEndCodeForGetandPost backendcode = new BackEndCodeForGetandPost();
				try {
					System.out.println("Inside the try block");
					List<String> temp = new ArrayList<String>();
					for (int j = 0; j < size; j++) {
						temp.add(text.get(j).getText());
					}
					result.setText(backendcode.sendPost(url.getText(), temp, dataField.getText()));
					System.out.println(temp);
					System.out.println(url);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					statusLabel.setText("Submitted the post request" + e1.toString());
				}
				statusLabel.setText("Submitted the post request");
			}
		});
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.dispose();
				preparePostMethod();
			}
		});
	}

	// https://acctcs.scania.com
	// private void get() {
	// // url = new JTextField();
	// // url.setLocation(50, 50);
	// // url.setSize(1000,1000);
	// // urlLable = new JLabel();
	// // urlLable.setSize(100,100);
	// // urlLable.setLocation(20, 20);
	// // urlLable.setText("URL");
	// //
	// result = new JTextArea();
	// // urlbox.setLocation(20, 20);
	// result.setSize(300, 100);
	//
	// // controlPanel.add(url);

	// }

}