import java.util.Scanner;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.ImageIcon;
    public class llenaDatos extends JFrame{
    
    ManejoDeArchivos mda = new ManejoDeArchivos();
    
    JPanel panel = new JPanel();
    String dias [] = new String[31];
    String años [] = new String[62];
    int y = 0;
    String relacion;
    String meses [] = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
    JRadioButton rBtTec, rBtTbj;
    JTextField cajaDeTextoNombre, cajaDeTextoTelefono, cajaDeTextoDirec;
    JComboBox ListaDias, ListaMeses, ListaAños;
    
      llenaDatos(){
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
      llenaFechas ();
      listasDesplegables();
      RadioBottons();
      labelIconoAdd();
      labelFondo();
      }
      
      private void colocarPaneles(){
      this.getContentPane().add(panel);
      panel.setLayout(null);  
      }
      
      private void botons(){
      JButton botonRegistrar = new JButton("Registrar"); 
      botonRegistrar.setBounds(150,600,120,20);
      panel.add(botonRegistrar); 
      botonRegistrar.setEnabled(true);
   
      JButton botonCancelar = new JButton("Cancelar"); 
      botonCancelar.setBounds(290,600,120,20);
      panel.add(botonCancelar); 
      botonCancelar.setEnabled(true);
      
      ActionListener oyenteDeAccionBtRegistrar = new ActionListener(){
      @Override 
      public void actionPerformed(ActionEvent ae){
      String nom = (cajaDeTextoNombre.getText());
      String tel = cajaDeTextoTelefono.getText();
      String dir = (cajaDeTextoDirec.getText());
      String rel="";
      if (rBtTec.isSelected()==true) {
         rel = (rBtTec.getText());
      }
      else{ 
         if (rBtTbj.isSelected()==true)
            rel =(rBtTbj.getText());
      }
      
      String d = (String)(ListaDias.getSelectedItem());
      String m = (String)(ListaMeses.getSelectedItem());
      String a = (String)(ListaAños.getSelectedItem());
      
      mda.crearCont(nom, tel, dir, rel, d, m, a);
      System.out.print("si jala");
      }
      };
      botonRegistrar.addActionListener(oyenteDeAccionBtRegistrar);
      
      }
      
      private void RadioBottons(){
      rBtTec = new JRadioButton("Tec",false);
      rBtTec.setBounds(180,390,60,20);
      panel.add(rBtTec);
      
      rBtTbj = new JRadioButton("Trabajo",false);
      rBtTbj.setBounds(330,390,80,20);
      panel.add(rBtTbj);
      
      ButtonGroup grupoRelacion = new ButtonGroup();
      grupoRelacion.add(rBtTec);
      grupoRelacion.add(rBtTbj);
      
      ActionListener oyenteDeAccionRBtTec = new ActionListener(){
      @Override 
      public void actionPerformed(ActionEvent ae){
      relacion = "Tec";
      }
      };
      rBtTec.addActionListener(oyenteDeAccionRBtTec);
    
    
    
      ActionListener oyenteDeAccionRBtTbj = new ActionListener(){
      @Override 
      public void actionPerformed(ActionEvent ae){
      relacion = "Trabajo";
      }
      };
      rBtTbj.addActionListener(oyenteDeAccionRBtTbj);
      }
      
      private void cajasDeTexto(){
      cajaDeTextoNombre = new JTextField();
      cajaDeTextoNombre.setBounds(140,170,250,20);
      panel.add(cajaDeTextoNombre);
      
      cajaDeTextoTelefono = new JTextField();
      cajaDeTextoTelefono.setBounds(140,245,100,20);
      panel.add(cajaDeTextoTelefono);
      
      cajaDeTextoDirec = new JTextField();
      cajaDeTextoDirec.setBounds(140,320,260,20);
      panel.add(cajaDeTextoDirec);
      }
      
      private void etiquetas(){
      JLabel etiNom = new JLabel("Nombre:");
      etiNom.setBounds(85,170,120,20);
      panel.add(etiNom); 
      
      JLabel etiTel = new JLabel("Telefono:");
      etiTel.setBounds(85,245,120,20);
      panel.add(etiTel);
      
      JLabel etiDirec = new JLabel("Direccion:");
      etiDirec.setBounds(80,320,120,20);
      panel.add(etiDirec);
      
      JLabel etiDia = new JLabel("Dia:");
      etiDia.setBounds(75,490,50,20);
      panel.add(etiDia);
      
      JLabel etiMes = new JLabel("Mes:");
      etiMes.setBounds(190,490,50,20);
      panel.add(etiMes);
      
      JLabel etiAño = new JLabel("Año:");
      etiAño.setBounds(370,490,50,20);
      panel.add(etiAño);
      
      JLabel etiInfoDatos = new JLabel("Ingresa la Fecha de nacimiento");
      etiInfoDatos.setBounds(180,440,300,40);
      panel.add(etiInfoDatos);
      
      JLabel etiRelacion = new JLabel("Relacion:");
      etiRelacion.setBounds(80,390,80,20);
      panel.add(etiRelacion);
      
      }
      
      private void listasDesplegables(){
      ListaDias = new JComboBox(dias);
      ListaDias.setBounds(100,490,50,20);
      panel.add(ListaDias);
      
      ListaMeses = new JComboBox(meses);
      ListaMeses.setBounds(220,490,120,20);
      panel.add(ListaMeses);
      
      ListaAños = new JComboBox(años);
      ListaAños.setBounds(400,490,60,20);
      panel.add(ListaAños);
      }
      
      private void llenaFechas (){
         for(int x=1; x<32; x++)
         dias[x-1] = String.valueOf(x);
      
         for(int x=2022; 1960<x; x--){
         años[y] = String.valueOf(x);
         y++;
         }
      }
      
    
    
    private void labelFondo(){
    ImageIcon imagen = new ImageIcon("fondoAdd.jpg");
    JLabel imagenFond = new JLabel();
    panel.add(imagenFond);
    imagenFond.setBounds(0,0,550,711);
    imagenFond.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(550,711, Image.SCALE_SMOOTH)));
    }
    
    private void labelIconoAdd(){
    ImageIcon imagen2 = new ImageIcon("iconoAgre.png");
    JLabel imagenIconAdd = new JLabel();
    panel.add(imagenIconAdd);
    imagenIconAdd.setBounds(180,15,150,150);
    imagenIconAdd.setIcon(new ImageIcon(imagen2.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
    }
    
    public boolean comparaNum (String telefono){
    String tel = telefono;
    System.out.println(tel);
    System.out.println(telefono);
    String num = "1234567890";
    boolean a = false;
    int r=0, x=0, y=0;
      
    for( y=0; y<(tel.length()); y++){
       for( x=0; x<10; x++){
             if(String.valueOf(tel.charAt(y)).equals(String.valueOf(num.charAt(x))) == true){
                a=true;
                x=9;
                r=1;
                }
            
        }
        if(r==0){
           x=9;
           y=(tel.length()-1);
           System.out.println("hay un caracter");
           a=false;
        }
        else
           r=0;
     
     }
     return a;
      
  }

      
          
    }