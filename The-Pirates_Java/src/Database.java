import javax.swing.*;
import java.sql.*;
import java.util.Formatter;
import java.util.Objects;

public class Database {

	private static String username;
	private static String password;

	static void loginUsername(){
		username = JOptionPane.showInputDialog(null, "Enter username", "Username", JOptionPane.QUESTION_MESSAGE);
		//return username;
	}

public static void loginPassword() {
		JPasswordField passwordField = new JPasswordField(10);
		passwordField.setEchoChar('*');
		JPanel myPanel = new JPanel();
		myPanel.add(new JLabel("Password: "));
		myPanel.add(passwordField);

		int result = JOptionPane.showConfirmDialog(null, myPanel, "Enter Password", JOptionPane.OK_CANCEL_OPTION);
		if (result == JOptionPane.OK_OPTION) {
			password = String.valueOf(passwordField.getPassword());
			//return password;
		}
		//return null;

	}

public static Connection createConnection() {
//boolean connected ;
	try {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/simulator", username, password);

	} catch (SQLException e) {
		e.printStackTrace();
	}
//	connected = true;
	return null;

}


		public static void statement(String query) {
			{
				try {
					Statement myStatement = Objects.requireNonNull(createConnection()).createStatement();
					ResultSet(myStatement, query);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

	public static void getShipInfo(String myShip) {
		{
			try {
				Statement myStatement = Objects.requireNonNull(createConnection()).createStatement();
				String myString = "Select * from simulator.myships where name ="+myShip;
				ResultSet(myStatement, myString);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	private static void ResultSet(Statement myStatement, String myString) throws SQLException {
		ResultSet myRs = myStatement.executeQuery(myString);
		ResultSetMetaData rsmd = myRs.getMetaData();
		//int columnsNumber = rsmd.getColumnCount();
		while (myRs.next()) {
			//for (int i = 1; i <= columnsNumber; i++) {
				//if (i > 1) System.out.print(",  ");
				//String columnValue = myRs.getString(i);
				//System.out.print(columnValue + " " + rsmd.getColumnName(i));
				//Ship._name = myRs.getString("name");
			}
			//System.out.println("");
		}



	public static void main (String[] args){
		loginUsername();
		loginPassword();
		createConnection();
		statement("Select * from ships");
		getShipInfo("'MotherRussia'");

}



}
