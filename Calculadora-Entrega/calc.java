import java.util.Scanner;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.ImageIcon;

 public class calc extends JFrame{
   
   private JTextField cajaDeTexto;
   float num1, num2, r=0;
   int c=0;
   String operador;
   String operadores = "+-/x";
   
   private JButton botonSum;
   private JButton botonRes;
   private JButton botonDiv;
   private JButton botonMult;
   private JButton botonPoint;
   private JButton botonIgual;
   
  
   
      JPanel panel = new JPanel();
   
   calc(){
      this.setSize(500,500); 
      
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
            
      
   }
   
   private void colocarPaneles(){
   
      this.getContentPane().add(panel);
      panel.setLayout(null);  
   }
   
   
   private void etiquetas(){
   }
   
   private void botons(){
   
   JButton boton0 = new JButton("0"); 
   boton0.setBounds(130,390,60,60); 
   panel.add(boton0); 
   boton0.setEnabled(true);
   
   JButton boton1 = new JButton("1"); 
   boton1.setBounds(60,180,60,60);
   panel.add(boton1); 
   boton1.setEnabled(true);
   
   JButton boton2 = new JButton("2");
   boton2.setBounds(130,180,60,60);
   panel.add(boton2);
   boton1.setEnabled(true);
   
   JButton boton3 = new JButton("3"); 
   boton3.setBounds(200,180,60,60); 
   panel.add(boton3); 
   boton3.setEnabled(true);
   
   JButton boton4 = new JButton("4"); 
   boton4.setBounds(60,250,60,60); 
   panel.add(boton4); 
   boton4.setEnabled(true);
   boton4.setMnemonic('a');
   
   JButton boton5 = new JButton("5"); 
   boton5.setBounds(130,250,60,60); 
   panel.add(boton5); 
   boton5.setEnabled(true);
   
   
   JButton boton6 = new JButton("6"); 
   boton6.setBounds(200,250,60,60); 
   panel.add(boton6); 
   boton6.setEnabled(true);
   
   JButton boton7 = new JButton("7");
   boton7.setBounds(60,320,60,60);
   panel.add(boton7);
   boton7.setEnabled(true);
   boton7.setMnemonic('a');
   
   JButton boton8 = new JButton("8"); 
   boton8.setBounds(130,320,60,60); 
   panel.add(boton8); 
   boton8.setEnabled(true);
   boton8.setMnemonic('a');
   
   JButton boton9 = new JButton("9"); 
   boton9.setBounds(200,320,60,60); 
   panel.add(boton9); 
   boton9.setEnabled(true);
   
   botonSum = new JButton("+"); 
   botonSum.setBounds(270,180,60,60); 
   panel.add(botonSum); 
   botonSum.setEnabled(true);
   
   botonRes = new JButton("-"); 
   botonRes.setBounds(270,250,60,60);
   panel.add(botonRes); 
   botonRes.setEnabled(true);
   
   botonMult = new JButton("*"); 
   botonMult.setBounds(270,320,60,60); 
   panel.add(botonMult); 
   botonMult.setEnabled(true);
   
   
   botonDiv = new JButton("/"); 
   botonDiv.setBounds(270,390,60,60); 
   panel.add(botonDiv); 
   botonDiv.setEnabled(true);
   
   botonIgual = new JButton("="); 
   botonIgual.setBounds(200,390,60,60); 
   panel.add(botonIgual);
   botonIgual.setEnabled(true);
   
   JButton botonDel = new JButton("<--"); 
   botonDel.setBounds(340,180,60,60); 
   panel.add(botonDel); 
   botonDel.setEnabled(true);
   
   JButton botonClean = new JButton("B"); 
   botonClean.setBounds(340,250,60,60);
   panel.add(botonClean); 
   botonClean.setEnabled(true);
   
   botonPoint = new JButton("."); 
   botonPoint.setBounds(60,390,60,60);
   panel.add(botonPoint); 
   botonPoint.setEnabled(true);
   
   ActionListener oyenteDeAccionBt0 = new ActionListener(){
      @Override 
      public void actionPerformed(ActionEvent ae){
      onOperador();
         cajaDeTexto.setText(cajaDeTexto.getText() +"0");
      
      }
   };
   boton0.addActionListener(oyenteDeAccionBt0);
   
   
   ActionListener oyenteDeAccionBt1 = new ActionListener(){
      @Override 
      public void actionPerformed(ActionEvent ae){
      onOperador();
         cajaDeTexto.setText(cajaDeTexto.getText() +"1");
      
      }
   };
   boton1.addActionListener(oyenteDeAccionBt1);



   ActionListener oyenteDeAccionBt2 = new ActionListener(){
      @Override 
      public void actionPerformed(ActionEvent ae){
      onOperador();
         cajaDeTexto.setText(cajaDeTexto.getText() +"2");
      
      }
   };
   boton2.addActionListener(oyenteDeAccionBt2);

   ActionListener oyenteDeAccionBt3 = new ActionListener(){
      @Override 
      public void actionPerformed(ActionEvent ae){
      onOperador();
         cajaDeTexto.setText(cajaDeTexto.getText() +"3");
      
      }
   };
   boton3.addActionListener(oyenteDeAccionBt3);

   
   ActionListener oyenteDeAccionBt4 = new ActionListener(){
      @Override 
      public void actionPerformed(ActionEvent ae){
      onOperador();
         cajaDeTexto.setText(cajaDeTexto.getText() +"4");
      
      }
   };
   boton4.addActionListener(oyenteDeAccionBt4);
   
   
   ActionListener oyenteDeAccionBt5 = new ActionListener(){
      @Override 
      public void actionPerformed(ActionEvent ae){
      onOperador();
         cajaDeTexto.setText(cajaDeTexto.getText() +"5");
      
      }
   };
   boton5.addActionListener(oyenteDeAccionBt5);
   
   
   ActionListener oyenteDeAccionBt6 = new ActionListener(){
      @Override 
      public void actionPerformed(ActionEvent ae){
      onOperador();
         cajaDeTexto.setText(cajaDeTexto.getText() +"6");
      
      }
   };
   boton6.addActionListener(oyenteDeAccionBt6);
   
   
   
   ActionListener oyenteDeAccionBt7 = new ActionListener(){
      @Override 
      public void actionPerformed(ActionEvent ae){
      onOperador();
         cajaDeTexto.setText(cajaDeTexto.getText() +"7");
      
      }
   };
   boton7.addActionListener(oyenteDeAccionBt7);
   
   
   ActionListener oyenteDeAccionBt8 = new ActionListener(){
      @Override 
      public void actionPerformed(ActionEvent ae){
      onOperador();
         cajaDeTexto.setText(cajaDeTexto.getText() +"8");
      
      }
   };
   boton8.addActionListener(oyenteDeAccionBt8);
   
   
   
   ActionListener oyenteDeAccionBt9 = new ActionListener(){
      @Override 
      public void actionPerformed(ActionEvent ae){
      onOperador();
         cajaDeTexto.setText(cajaDeTexto.getText() +"9");
      
      }
   };
   boton9.addActionListener(oyenteDeAccionBt9);



   ActionListener oyenteDeAccionBtSum = new ActionListener(){
   
      @Override 
      public void actionPerformed(ActionEvent ae){
         ofOperador();
         onPunto();
         String num = cajaDeTexto.getText();
         int pos = num.length();
         
         if(c==0){
            num1 = Float.valueOf(cajaDeTexto.getText());
            r=num1;
         }
         else{
            num2 = Float.valueOf(num.substring((posOperador(pos)),pos));
            r = num1+num2;
            num1=r;
            }
            
         c++;
         cajaDeTexto.setText(cajaDeTexto.getText() +"+");
         operador = "+";
      
      }
   };
   botonSum.addActionListener(oyenteDeAccionBtSum);


   ActionListener oyenteDeAccionBtRes = new ActionListener(){
      @Override 
      public void actionPerformed(ActionEvent ae){
         ofOperador();
         onPunto();
      
       String num = cajaDeTexto.getText();
         int pos = num.length();
         
         if(c==0){
            num1 = Float.valueOf(cajaDeTexto.getText());
            r=num1;
            }
         else{
            num2 = -(Float.valueOf(num.substring((posOperador(pos)),pos)));
            r = num1-num2;
            num1=r;
            }
            
         c++;
         cajaDeTexto.setText(cajaDeTexto.getText() +"-");
         operador = "-";
      
      }
   };
   botonRes.addActionListener(oyenteDeAccionBtRes);
   
   
   ActionListener oyenteDeAccionBtDiv = new ActionListener(){
      @Override 
      public void actionPerformed(ActionEvent ae){
         ofOperador();
         onPunto();
      
      String num = cajaDeTexto.getText();
         int pos = num.length();
         
         if(c==0){
            num1 = Float.valueOf(cajaDeTexto.getText());
            r=num1;
            }
         else{
            num2 = Float.valueOf(num.substring((posOperador(pos)+1),pos));
            r = num1/num2;
            num1=r;
            }
            
         c++;
         cajaDeTexto.setText(cajaDeTexto.getText() +"/");
         operador = "/";
      }
   };
   botonDiv.addActionListener(oyenteDeAccionBtDiv);
   
   
    ActionListener oyenteDeAccionBtMult = new ActionListener(){
      @Override 
      public void actionPerformed(ActionEvent ae){
         ofOperador();
         onPunto();
      
      String num = cajaDeTexto.getText();
         int pos = num.length();
         
         if(c==0){
            num1 = Float.valueOf(cajaDeTexto.getText());
            r=num1;
            }
         else{
            num2 = Float.valueOf(num.substring((posOperador(pos)+1),pos));
            r = num1*num2;
            num1=r;
            }
            
         c++;
         cajaDeTexto.setText(cajaDeTexto.getText() +"x");
         operador = "x";
      }
   };
   botonMult.addActionListener(oyenteDeAccionBtMult);


   ActionListener oyenteDeAccionBtPoint = new ActionListener(){
      @Override 
      public void actionPerformed(ActionEvent ae){
      ofPunto();
         cajaDeTexto.setText(cajaDeTexto.getText() +".");
      
      }
   };
   botonPoint.addActionListener(oyenteDeAccionBtPoint);
   
   
   ActionListener oyenteDeAccionBtDel = new ActionListener(){
   
      @Override 
      public void actionPerformed(ActionEvent ae){
         int pos =0;
         String num = cajaDeTexto.getText();
         pos = num.length();
         if(pos != 0 && num != " ")
            cajaDeTexto.setText(num.substring(0,pos-1));
      
      }
   };
   botonDel.addActionListener(oyenteDeAccionBtDel);
   
   
   ActionListener oyenteDeAccionBtClean = new ActionListener(){
   
      @Override 
      public void actionPerformed(ActionEvent ae){
            cajaDeTexto.setText("");
            r = 0;
            num1 =0;
            num2 = 0;
            c=0;
      
      }
   };
   botonClean.addActionListener(oyenteDeAccionBtClean);
   
   
    ActionListener oyenteDeAccionBtIgual = new ActionListener(){
   
      @Override 
      public void actionPerformed(ActionEvent ae){
      
      String num = cajaDeTexto.getText();
      int pos = num.length();
         
            
         if(operador == "+"){
            num2 = Float.valueOf(num.substring((posOperador(pos)),pos));
            cajaDeTexto.setText(r+num2+"");
            }
         if(operador == "-"){
            num2 = Float.valueOf(num.substring((posOperador(pos)),pos));
            r = r+num2;
            cajaDeTexto.setText(String.valueOf(r));
            }
         if(operador == "/"){
            num2 = Float.valueOf(num.substring((posOperador(pos)+1),pos));
            
            try{
               if(num2 == 0){
                  throw new ArithmeticException();
                  
                  }
               else
               cajaDeTexto.setText(r/num2+"");
            }catch( ArithmeticException dC){
               JOptionPane.showMessageDialog(null,"'Ingeniero Recuerde que !No puede dividir entre cero! ingrese otro numero","Error dicion entre cero" ,2);
               del();
               ofOperador();
            }
            
         }
         
         if(operador == "x"){
         num2 = Float.valueOf(num.substring((posOperador(pos)+1),pos));
         cajaDeTexto.setText(r*num2+"");
         }
         c=0;
         operador="";
          ofPunto();
      
      }
   };
   botonIgual.addActionListener(oyenteDeAccionBtIgual);


      
   }
   
   private void cajasDeTexto(){
      cajaDeTexto = new JTextField();
      cajaDeTexto.setBounds(60,70,270,40);
      panel.add(cajaDeTexto);
   
   }
   
   private int posOperador (int pos){
      int cont =0;
   
      for(int x=0; x<pos; x++)
            for(int y=0; y<4; y++){
                if(String.valueOf((cajaDeTexto.getText()).charAt(x)).equals(String.valueOf(operadores.charAt(y))) == true)
                  cont = x;
            }
            
            return cont;
   }
   
   private void onOperador(){
   botonSum.setEnabled(true);
   botonRes.setEnabled(true);
   botonDiv.setEnabled(true);
   botonMult.setEnabled(true);
   botonIgual.setEnabled(true);
   }
   
   private void ofOperador(){ 
   botonSum.setEnabled(false);
   botonRes.setEnabled(false);
   botonDiv.setEnabled(false);
   botonMult.setEnabled(false);
   botonIgual.setEnabled(false);
   }
   
   private void onPunto(){
      botonPoint.setEnabled(true);
   }
   
   private void ofPunto(){
      botonPoint.setEnabled(false);
   }
   
   private void del(){
       int pos =0;
       
       String num = cajaDeTexto.getText(); 
       pos = num.length();
       
         if(pos != 0 && num != " ")
            cajaDeTexto.setText(num.substring(0,pos-1));

   }
   
      
   }
   