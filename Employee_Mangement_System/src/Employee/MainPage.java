package Employee;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

//All Imported Classes
import Employee.Add;
import Employee.Search;
import Employee.Sort;
import Employee.Delete;

class MainPage implements ActionListener
{
    JFrame mainFrame;
    JLabel titleLbl, rightPanelStartLbl1, rightPanelStartLbl2, rightPanelStartLbl3;
    JButton newBtn, searchBtn, sortBtn, deleteBtn;

    JPanel leftPanel, rightPanel, titlePanel, addPanel, searchPanel, sortPanel, deletePanel;
    
    Connection conn;

    MainPage()
    {
        //MAINFRAME setup
        mainFrame = new JFrame();
        mainFrame.setSize(800, 500);
        mainFrame.setLayout(null);
        mainFrame.setLocation(400, 100);
        mainFrame.setTitle("Employee Management System");

        //All PANEL Setup
            //TITLE Panel
        titlePanel = new JPanel();
        titlePanel.setLayout(null);
        titlePanel.setBackground(Color.black);
            //DISPLAY Panel
                //rightPanel is DISPLAY panel and below rightPanel will be discribed as DISPLAY panel.
        rightPanel = new JPanel();
        rightPanel.setLayout(null);
        rightPanel.setBackground(new Color(255, 255, 153));
            //ADD Panel
        addPanel = new JPanel();
        addPanel.setLayout(null);
        addPanel.setBackground(Color.green);
            //SEARCH Panel
        searchPanel = new JPanel();
        searchPanel.setLayout(null);
        searchPanel.setBackground(Color.green);
            //SORT Panel
        sortPanel = new JPanel();
        sortPanel.setLayout(null);
        sortPanel.setBackground(Color.green);
            //DELETE Panel
        deletePanel = new JPanel();
        deletePanel.setLayout(null);
        deletePanel.setBackground(Color.green);

        // All LABEL Setup
            //TITLE Label
        titleLbl = new JLabel("Employee Management System");
        titleLbl.setForeground(Color.white);
        titleLbl.setFont(new Font(null, Font.BOLD, 15));
            //DISPLAYPANEL Label
        rightPanelStartLbl1 = new JLabel("Employee");
        rightPanelStartLbl1.setForeground(Color.BLUE);
        rightPanelStartLbl1.setFont(new Font(null, Font.BOLD, 80));
        rightPanelStartLbl2 = new JLabel("Management");
        rightPanelStartLbl2.setForeground(Color.BLUE);
        rightPanelStartLbl2.setFont(new Font(null, Font.BOLD, 80));
        rightPanelStartLbl3 = new JLabel("System");
        rightPanelStartLbl3.setForeground(Color.BLUE);
        rightPanelStartLbl3.setFont(new Font(null, Font.BOLD, 80));

        //All BUTTON Setup
            //ADD Button
        newBtn = new JButton("ADD");
        newBtn.setForeground(Color.magenta);
        newBtn.setFont(new Font(null, Font.BOLD, 15));
            //SEARCH Button
        searchBtn = new JButton("SEARCH");
        searchBtn.setForeground(Color.blue);
        searchBtn.setFont(new Font(null, Font.BOLD, 15));
            //SORT Button
        sortBtn = new JButton("SORT");
        sortBtn.setForeground(Color.ORANGE);
        sortBtn.setFont(new Font(null, Font.BOLD, 15));
            //DELETE Button
        deleteBtn = new JButton("DELETE");
        deleteBtn.setForeground(Color.red);
        deleteBtn.setFont(new Font(null, Font.BOLD, 15));

        // all BUTTON bounds
        newBtn.setBounds(20, 20, 160, 60);
        searchBtn.setBounds(20, 20, 160, 60);
        sortBtn.setBounds(20, 20, 160, 60);
        deleteBtn.setBounds(20, 20, 160, 60);

        //all LABEL bounds
        titleLbl.setBounds(300, 10, 770, 20);
        rightPanelStartLbl1.setBounds(120, 10, 600, 100);
        rightPanelStartLbl2.setBounds(60, 130, 600, 100);
        rightPanelStartLbl3.setBounds(150, 250, 600, 100);

        // all PANEL bounds
        titlePanel.setBounds(0, 0, 800, 40);
        rightPanel.setBounds(200, 40, 600, 460);
        addPanel.setBounds(0, 40, 200, 110);
        searchPanel.setBounds(0, 145, 200, 105);
        sortPanel.setBounds(0, 250, 200, 110);
        deletePanel.setBounds(0, 360, 200, 110);

        //Adding Components To PANEL
            //ADD_PANEL
        addPanel.add(newBtn);
            //SEARCH_PANEL
        searchPanel.add(searchBtn);
            //SORT_PANEL
        sortPanel.add(sortBtn);
            //DELETE_PANEL
        deletePanel.add(deleteBtn);
            //RIGHT_PANEL
        rightPanel.add(rightPanelStartLbl1);
        rightPanel.add(rightPanelStartLbl2);
        rightPanel.add(rightPanelStartLbl3);
        

        //Adding ACTIONLISTENER to the BUTTONS
            //ADD_BUTTON_LISTENER
        newBtn.addActionListener(this);
            //SEARCH_BUTTON_LISTENER
        searchBtn.addActionListener(this);
            //SORT_BUTTON_LISTENER
        sortBtn.addActionListener(this);
            //DELETE_BUTTON_LISTENER
        deleteBtn.addActionListener(this);

        titlePanel.add(titleLbl);

        // adding components to MAINFRAME
        mainFrame.add(titlePanel);
        mainFrame.add(rightPanel);

        mainFrame.add(addPanel);
        mainFrame.add(searchPanel);
        mainFrame.add(sortPanel);
        mainFrame.add(deletePanel);

        //adding WINDOW_LISTENER
            // It helps in closing window with the help of close button
        mainFrame.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we)
            {
                System.exit(0);
            }
        });

            //FALSE make it Non-Resizable
        mainFrame.setResizable(false);
        mainFrame.setVisible(true);
        
        	//Making the SQL CONNECTION
        try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "oracle");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("Driver Not Found");
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
    }

    //Adding ACTION to the BUTTON
    public void actionPerformed(ActionEvent e)
    {   
            //NEW_BUTTON
        if(e.getSource() == newBtn)
        {
            //Below code turns the SELECTED_PANEL color same as the DISPLAY_PANEL and other to GREEN color.
            addPanel.setBackground(new Color(255, 255, 153));
            searchPanel.setBackground(Color.green);
            sortPanel.setBackground(Color.green);
            deletePanel.setBackground(Color.green);

            //If DISPLAY_PANEL contains some come components then below code remove the DISPLAY_PANEL.
                //It needs to be removed for new components to display on the DISPLAY_PANEL.
            if(rightPanel != null)
            {
                mainFrame.remove(rightPanel);
            }

            //Here previously defined DISPLAY_PANEL to the new PANEL that comes from another class i.e Add.
                //Here Add is the another class and add() is the method that returns the NEW_DISPLAY_PANEL.
                    //NEW_DISPLAY_PANEL copies its whole component to the DISPLAY_PANEL.
            this.rightPanel = Add.add(conn);
                //Now DISPLAY_PANEL is added back to the MAINFRAME so that it can display the new added components.
            mainFrame.add(rightPanel);
                //It helps to UPDATE the MAINFRAME so that new changes can be displayed.
            mainFrame.repaint();
        }

            //SEARCH_BUTTON
        else if(e.getSource() == searchBtn)
        {
            //Below code turns the SELECTED_PANEL color same as the DISPLAY_PANEL and other to GREEN color.
            addPanel.setBackground(Color.green);
            searchPanel.setBackground(new Color(255, 255, 153));
            sortPanel.setBackground(Color.green);
            deletePanel.setBackground(Color.green);

            //If DISPLAY_PANEL contains some come components then below code remove the DISPLAY_PANEL.
                //It needs to be removed for new components to display on the DISPLAY_PANEL.
            if(rightPanel != null)
            {
                mainFrame.remove(rightPanel);
            }

            //Here previously defined DISPLAY_PANEL to the new PANEL that comes from another class i.e Search.
                //Here Search is an another class and search() is a method that returns the NEW_DISPLAY_PANEL.
                    //NEW_DISPLAY_PANEL copies its whole component to the DISPLAY_PANEL.
            rightPanel = Search.search();
            //Now DISPLAY_PANEL is added back to the MAINFRAME so that it can display the new added components.
            mainFrame.add(rightPanel);
            //It helps to UPDATE the MAINFRAME so that new changes can be displayed.
            mainFrame.repaint();
        }

            //SORT_BUTTON
        else if(e.getSource() == sortBtn)
        {
            //Below code turns the SELECTED_PANEL color same as the DISPLAY_PANEL and other to GREEN color.
            addPanel.setBackground(Color.green);
            searchPanel.setBackground(Color.green);
            sortPanel.setBackground(new Color(255, 255, 153));
            deletePanel.setBackground(Color.green);

            //If DISPLAY_PANEL contains some come components then below code remove the DISPLAY_PANEL.
                //It needs to be removed for new components to display on the DISPLAY_PANEL.
            if(rightPanel != null)
            {
                mainFrame.remove(rightPanel);
            }

            //Here previously defined DISPLAY_PANEL to the new PANEL that comes from another class i.e Sort.
                //Here Sort is an another class and sort() is a method that returns the NEW_DISPLAY_PANEL.
                    //NEW_DISPLAY_PANEL copies its whole component to the DISPLAY_PANEL.
            this.rightPanel = Sort.sort();
            //Now DISPLAY_PANEL is added back to the MAINFRAME so that it can display the new added components.
            mainFrame.add(rightPanel);
            //It helps to UPDATE the MAINFRAME so that new changes can be displayed.
            mainFrame.repaint();
        }

            //DELETE_BUTTON
        else if(e.getSource() == deleteBtn)
        {
            //Below code turns the SELECTED_PANEL color same as the DISPLAY_PANEL and other to GREEN color.
            addPanel.setBackground(Color.green);
            searchPanel.setBackground(Color.green);
            sortPanel.setBackground(Color.green);
            deletePanel.setBackground(new Color(255, 255, 153));

            //If DISPLAY_PANEL contains some come components then below code remove the DISPLAY_PANEL.
                //It needs to be removed for new components to display on the DISPLAY_PANEL.
            if(rightPanel != null)
            {
                mainFrame.remove(rightPanel);
            }

            //Here previously defined DISPLAY_PANEL to the new PANEL that comes from another class i.e Delete.
                //Here delete is an another class and delete() is a method that returns the NEW_DISPLAY_PANEL.
                    //NEW_DISPLAY_PANEL copies its whole component to the DISPLAY_PANEL.
            this.rightPanel = Delete.delete(conn);
            //Now DISPLAY_PANEL is added back to the MAINFRAME so that it can display the new added components.
            mainFrame.add(rightPanel);
            //It helps to UPDATE the MAINFRAME so that new changes can be displayed.
            mainFrame.repaint();
        }
    }

    
    public static void main(String args[])
    {
        MainPage t = new MainPage();
    }
}
