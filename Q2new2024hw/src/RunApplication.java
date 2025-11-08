import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//radio buuton (have options but choose 1 )
//check box (have options choose more than one at a time )
// list (list of things you can select one or more than one )
// before to use you must declare (say it out loud)

public class RunApplication extends JFrame{
    private JTextField vehicletypeField;
    private JTextField cityfield;
    private JTextField numberofaccidentsfield;

    private JTextArea OutPutArea;//to show a specific text
    private JButton SaveButton;
    private JButton ReadButton;
    private JButton ReportButton;

    public RunApplication() {
        setTitle("Cricket runs scored application");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel InputPanel = new JPanel(new GridLayout(3, 2, 10, 10));//pannels are basically the tanles
        InputPanel.setBorder(BorderFactory.createTitledBorder("Enter the type of vehicle  "));

        InputPanel.add(new JLabel("vichcle type"));
        vehicletypeField = new JTextField();
        InputPanel.add(vehicletypeField);

        InputPanel.add(new JLabel("city "));
        cityfield = new JTextField();
        InputPanel.add(cityfield);

        InputPanel.add(new JLabel("number of accidents "));
        numberofaccidentsfield = new JTextField();
        InputPanel.add(numberofaccidentsfield);

        JPanel ButtonPanel = new JPanel(new FlowLayout());
        SaveButton = new JButton();
        ReadButton = new JButton();
        ReportButton = new JButton();

        ButtonPanel.add(SaveButton);
        ButtonPanel.add(ReadButton);
        ButtonPanel.add(ReportButton);

        OutPutArea = new JTextArea();
        OutPutArea.setEditable(false);
        OutPutArea.setBorder(BorderFactory.createTitledBorder("Output"));
        JScrollPane scrollPane = new JScrollPane(OutPutArea);
        //actiion listener
        add(InputPanel, BorderLayout.NORTH);
        add(ButtonPanel, BorderLayout.CENTER);
        add(OutPutArea, BorderLayout.SOUTH);

        ReportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String vehicletype = vehicletypeField.getText();
                    String city = cityfield.getText();
                    int numberofaccidents = Integer.parseInt(numberofaccidentsfield.getText());

                    RoadaccidentReport roadaccidentReport=new RoadaccidentReport(vehicletype, city, numberofaccidents);
                    OutPutArea.setText(roadaccidentReport.accidentprintReport());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "please enter a valid number for accidents .", "input error", JOptionPane.ERROR_MESSAGE);
                }
            }});
        SaveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String vehicletype = vehicletypeField.getText();
                    String city = cityfield.getText();
                    int numberofaccidents = Integer.parseInt(numberofaccidentsfield.getText());

                    RoadaccidentReport roadaccidentReport=new RoadaccidentReport(vehicletype, city, numberofaccidents);
                    roadaccidentReport.savetothefile();
                    JOptionPane.showMessageDialog(null, "Data has been successfullt saved.", "Success", JOptionPane.ERROR_MESSAGE);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "please enter a valid number of the type of cars .", "input error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new RunApplication().setVisible(true);
        });


    }
    //when you have a frame you need to have a pannel
}