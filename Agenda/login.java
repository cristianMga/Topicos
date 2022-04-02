import java.util.Scanner;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.ImageIcon;

    public class login extends JFrame{
    private JTextField cajaDeTextoUsuari;
    private JPasswordField cajaDeTextoContra;
    
    JPanel panel = new JPanel();
    
    login(){
      this.setSize(550,711); 
      //this.setLocation();
      
      this.setLocationRelativeTo(null);
      this.setDefaultCloseOperation(EXIT_ON_CLOSE);
      this.setTitle("Cristian Mendez"); 
      
      iniciarComponetes();
   }
   
   private void iniciarComponetes(){
   colocarPaneles();
   etiquetas();
   botons();
   cajasDeTexto();
   labelFondo();
      
   }
   
    private void colocarPaneles(){
   
      this.getContentPane().add(panel);
      panel.setLayout(null);  
   }


    
    private void botons(){
   
   JButton botonIngresar = new JButton("Ingresar"); 
   botonIngresar.setBounds(150,260,120,20);
   panel.add(botonIngresar); 
   botonIngresar.setEnabled(true);
   
   JButton botonCancelar = new JButton("Cancelar"); 
   botonCancelar.setBounds(290,260,120,20);
   panel.add(botonCancelar); 
   botonCancelar.setEnabled(true);
   
   }
   
   private void etiquetas(){
      JLabel etiUsuario = new JLabel("Usuario:");
      etiUsuario.setBounds(120,160,120,20);
      panel.add(etiUsuario); 
      
      JLabel etiContraseña = new JLabel("Contraeña:");
      etiContraseña.setBounds(120,200,120,20);
      panel.add(etiContraseña);
   
   }
   
    private void cajasDeTexto(){
    
      cajaDeTextoContra = new JPasswordField();
      cajaDeTextoContra.setBounds(190,200,250,20);
      panel.add(cajaDeTextoContra);
      
      cajaDeTextoUsuari = new JTextField();
      cajaDeTextoUsuari.setBounds(175,160,260,20);
      panel.add(cajaDeTextoUsuari);
   
   }
   
   private void labelFondo(){
    ImageIcon imagen = new ImageIcon("Fondologin.jpg");
    JLabel imagenFond = new JLabel();
    panel.add(imagenFond);
    imagenFond.setBounds(0,0,550,711);
    imagenFond.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(550, 711, Image.SCALE_SMOOTH)));
   
   }
   
   
   
   }
   
   