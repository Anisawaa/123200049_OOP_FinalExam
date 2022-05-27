/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package moviereview.view;
import moviereview.controller.Connector;

import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Nisa
 */
public class UpdateView extends JFrame{
    private String title;
    
    Connector connector = new Connector();
    
    JFrame window = new JFrame("Update Data");
   
    JLabel lTitle = new JLabel ("Title ");
    JTextField tfTitle = new JTextField();
    JLabel lPlot = new JLabel ("Plot ");
    JTextField tfPlot = new JTextField();
    JLabel lCharacter = new JLabel ("Character ");
    JTextField tfCharacter = new JTextField();
    JLabel lActing = new JLabel("Acting ");
    JTextField tfActing = new JTextField();

    JButton btnUpdate = new JButton("Update");

    public UpdateView(String title) {
        this.title = title;
        
        window.setLayout(null);
        window.setSize(550,200);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        
        window.add(lTitle);
        window.add(tfTitle);
        window.add(lPlot);
        window.add(tfPlot);
        window.add(lCharacter);
        window.add(tfCharacter);
        window.add(lActing);
        window.add(tfActing);
        window.add(btnUpdate);
        
        lTitle.setBounds(5, 35, 120, 20);
        lPlot.setBounds(5, 60, 120, 20);
        lCharacter.setBounds(5,85,120,20);
        lActing.setBounds(5,105,120,20);
        
        tfTitle.setText(title);
        tfTitle.setEditable(false);

        tfTitle.setBounds(110, 35, 120, 20);
        tfPlot.setBounds(110, 60, 120, 20);
        tfCharacter.setBounds(110, 85, 120, 20);
        tfActing.setBounds(110, 105, 120, 20);

        btnUpdate.setBounds(250, 35, 90, 20);
        
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                connector.updateData(getJudul(), getAlur(), getPenokohan(), getAkting());
            }
        });
    }
    
    public String getJudul(){
        return tfTitle.getText();
    }
    
    public String getAlur(){
        return tfPlot.getText();
    }
    
    public String getPenokohan(){
        return tfCharacter.getText();
    }
    
    public String getAkting(){
        return tfActing.getText();
    }
}
