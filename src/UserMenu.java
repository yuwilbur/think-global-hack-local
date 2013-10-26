import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.*;

import users.NameTakenException;
import users.UserManagementService;

import java.awt.*;
import java.awt.event.*;

public class UserMenu extends MainMenu {
	private JLabel frame_title;
	private JButton createNewUserButton;
	private JButton selectUserButton;

	public UserMenu() {
		setup();
		add(createNewUserButton);
		add(selectUserButton);
		setVisible(true);
	}

	private void setup() {
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		setLayout(new GridLayout(3, 1));
		createNewUserButton = new JButton("Create New User");
		selectUserButton = new JButton("Select User");
		createNewUserButton.addActionListener(new CreateNewUserDialogHandler());
	}

	private class NewUserDialog extends JFrame {
		private void createAndShowNewUserDialog() {
			setName("Add new user");
			String nameLabel = "Enter Name: ";
			JPanel p = new JPanel();
			JLabel l = new JLabel(nameLabel);
			p.add(l);
			
			final JTextField inputField = new JTextField(20);
			l.setLabelFor(inputField);
			p.add(inputField);
			JButton addUserButton = new JButton("Add User");
			
			addUserButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					String name = inputField.getText();
					if (name == null){
						JOptionPane.showMessageDialog(NewUserDialog.this, "You didn't enter your name!");
					}
					else{
						try {
							UserManagementService.createUser(name);
						} catch (NameTakenException e1) {
							JOptionPane.showMessageDialog(NewUserDialog.this, e1.getError());
						}
					}
				}
			});
			
			JButton cancelButton = new JButton("Cancel");
			cancelButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					setVisible(false);
					dispose();
				}
			});
			p.add(addUserButton);
			p.add(cancelButton);
			setContentPane(p);
			setSize(300, 100);
			setVisible(true);
		}
	}

	private class CreateNewUserDialogHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			NewUserDialog dlg = new NewUserDialog();
			dlg.createAndShowNewUserDialog();
		}

	}

}
