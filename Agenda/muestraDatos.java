import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class muestraDatos extends JFrame{

JPanel panel = new JPanel();

JScrollPane scroll;
JTextArea areaTxt;

      muestraDatos(){
         this.setSize(550,711); 
      
         this.setLocationRelativeTo(null);
         this.setDefaultCloseOperation(EXIT_ON_CLOSE);
         this.setTitle("Cristian Mendez"); 
      
         iniciarComponetes();
      }
      
      private void iniciarComponetes(){
         colocarPaneles();
         //etiquetas();
         botons();
         barraD ();
         //AreaDeTexto();
         labelFondo();
      }
      
      private void colocarPaneles(){
         this.getContentPane().add(panel);
         panel.setLayout(null);  
      }
      
      private void botons(){
      
         JButton botonAdd = new JButton(); 
         botonAdd.setBounds(150,50,50,50);
         ImageIcon imagen = new ImageIcon("iAgregar.png");
         botonAdd.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
         botonAdd.setToolTipText("Agregar Contacto");
         //botonAdd.setFocusPainted(false);
         //botonAdd.setBorderPainted(false);
         //botonAdd.setBackground(null);
         //botonAdd.setContentAreaFilled(false);
         panel.add(botonAdd); 
         
         JButton botonBuscar = new JButton(); 
         botonBuscar.setBounds(350,50,50,50);
         ImageIcon imagen1 = new ImageIcon("iBuscar.png");
         botonBuscar.setIcon(new ImageIcon(imagen1.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
         botonBuscar.setToolTipText("Buscar Contacto");
         panel.add(botonBuscar); 
         
         JButton botonBorrar = new JButton(); 
         botonBorrar.setBounds(450,50,50,50);
         ImageIcon imagen2 = new ImageIcon("iBorrar.png");
         botonBorrar.setIcon(new ImageIcon(imagen2.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
         botonBorrar.setToolTipText("Borrar Contacto");
         panel.add(botonBorrar); 
         
         ActionListener oyenteDeAccionBtBorrar = new ActionListener(){
            @Override 
            public void actionPerformed(ActionEvent ae){
            
            
            String[] options = {"Nombre","Numero","Cancelar"};
        
            String opc  = (String)JOptionPane.showInputDialog(null, "¿Quires buscar el contacto por numero o nombre?", "Buscar contacto", 3, null, options, null);
		
		      if(opc == "Nombre") {
              String nom = (String)JOptionPane.showInputDialog(null, "Ingresa el nombre del contacto", "Captura de nombre", 1);
           if((nom.equals("") == true)){
              JOptionPane.showMessageDialog(null,"Al parecer has dejado en blanco el campo de nombre ¡ Intentalo de nuevo !","Error campo vacio" ,2);
           }else{
           
           try{
           File MiArchivo = new File("Agenda.txt");// Declaracion de variables
           FileReader fr;
           BufferedReader br;
           
              if(MiArchivo.exists()== true){
                 fr = new FileReader(MiArchivo);//Declaracion de variables
                 br = new  BufferedReader(fr);
                 ManejoDeArchivos mda = new ManejoDeArchivos();
                 String linea;
                 String [] contE= new String [4];
                 int contC =0;
                 boolean bandera = false;
                 
                 
                 areaTxt.setText("");
                 
                 while((linea = br.readLine())!= null ){
                     String [] cont = linea.split("%");
                        if((cont[0].equals(nom)) == true){
                           bandera = true;
                        }  
                 }
                 fr.close();
                 br.close();
                 if((bandera == true) && (MiArchivo.length() >= 1)){
                 fr = new FileReader(MiArchivo);//Declaracion de variables
                 br = new  BufferedReader(fr);
                 
                            while((linea = br.readLine())!= null ){ ////Recorre el archivo hasta encontrar una linea en blanco
                              String [] cont = linea.split("%"); 
                              
                              if((cont[0].equals(nom)) == true){ // Ciclo para contar los contactos y encontrar al contacto a elininar
                                 bandera = true;
                                 contC ++;
                                 contE = linea.split("%");
                              }else{
                              contC ++;
                              }
                           }
                           fr.close();
                           br.close();
                           
                           System.out.printf("El nuemro de contactos es: %d \n",contC);
                           
                           String [] nCont = new String [contC-1];
                           int z = 0;
                           fr = new FileReader(MiArchivo);
                           br = new  BufferedReader(fr);

                           while((linea = br.readLine())!= null ){ // Ciclo que recorre el archivo hasta encontrar un renglon vacio
                              String [] cont = linea.split("%"); // separamos y almacenamos los datos del contacto obtenido del archivo pra compararlo despues 
                           
                              if((cont[0].equals(contE[0]) == false)){  // Compara si el nombre del contacto obtenido del archivo es igual al que deseamos borrar
                                 nCont[z] = linea;   // Si no es el contacto a borrar lo guardamos en un arreglo para despues reescribirlo en el archivo .txt
                                 System.out.printf("conctacto %d: %s\n",z,nCont[z]);
                                 z = z+1;
                              }
                           }
                           mda.vaciarArchivo();// vacia el archivo
                           
                           for(int x = 0; x<=contC-2; x++){  // Arreglo para ir vacion los contactos que no se borraron
                              String [] cn= nCont[x].split("%"); // separamos y almacenamos los datos del contacto obtenido del arreglo de contactos a reinscribir
                              mda.crearCont(cn[0], cn[1], cn[2], cn[3], cn[4], cn[5], cn[6]); // madamos a llamar al metodo que nos agrega los contactos al archivo y le mandamos los datos del contacto a agregar
                           }
                           
                 } else if(bandera == false)
                    JOptionPane.showMessageDialog(null,"'El nombre que ingresaste no pertenece a ningun contacto","Contacto no Encontrado" ,0);
              }else{
                  JOptionPane.showMessageDialog(null,"'Aun no es creada tu archivo agenda","Archivo de datos no encontrado" ,2);
              }
         }catch(Exception e){
            System.out.print("error"+e);
         }
           
           }

		  }else if(opc == "Numero"){
        ////////
          String num = (String)JOptionPane.showInputDialog(null, "Ingresa el nombre del contacto", "Captura de nombre", 1);
           if((num.equals("") == true)){
              JOptionPane.showMessageDialog(null,"Al parecer has dejado en blanco el campo de numero ¡ Intentalo de nuevo !","Error campo vacio" ,2);
           }else{
           
           try{
           File MiArchivo = new File("Agenda.txt");// Declaracion de variables
           FileReader fr;
           BufferedReader br;
           
              if(MiArchivo.exists()== true){
                 fr = new FileReader(MiArchivo);//Declaracion de variables
                 br = new  BufferedReader(fr);
                 ManejoDeArchivos mda = new ManejoDeArchivos();
                 String linea;
                 String [] contE= new String [4];
                 int contC =0;
                 boolean bandera = false;
                 
                 
                 areaTxt.setText("");
                 
                 while((linea = br.readLine())!= null ){
                     String [] cont = linea.split("%");
                        if((cont[1].equals(num)) == true){
                           bandera = true;
                        }  
                 }
                 if((bandera = true) && (MiArchivo.length() >= 1)){
                            while((linea = br.readLine())!= null ){ ////Recorre el archivo hasta encontrar una linea en blanco
                              String [] cont = linea.split("%"); 
                              
                              if((cont[1].equals(num)) == true){ 
                                 bandera = true;
                                 contC ++;
                                 contE = linea.split("%");
                              }else{
                              contC ++;
                              }
                           }
                           fr.close();
                           br.close();
                           
                           System.out.printf("El nuemro de contactos es: %d \n",contC);
                           
                           String [] nCont = new String [contC-1];
                           int z = 0;
                           fr = new FileReader(MiArchivo);
                           br = new  BufferedReader(fr);

                           while((linea = br.readLine())!= null ){ // Ciclo que recorre el archivo hasta encontrar un renglon vacio
                              String [] cont = linea.split("%"); // separamos y almacenamos el los datos del contacto obtenido del archivo pra compararlo despues 
                           
                              if((cont[1].equals(contE[1]) == false)){  // Compara si el nombre del contacto obtenido del archivo es igual al que deseamos borrar
                                 nCont[z] = linea;   // Si no es el contacto a borrar lo guardamos en un arreglo para despues reescribirlo en el archivo .txt
                                 System.out.printf("conctacto %d: %s\n",z,nCont[z]);
                                 z = z+1;
                              }
                           }
                           mda.vaciarArchivo();// vacia el archivo
                           
                           for(int x = 0; x<=contC-2; x++){  // Arreglo para ir vacion los contactos que no se borraron
                              String [] cn= nCont[x].split("%"); // separamos y almacenamos los datos del contacto obtenido del arreglo de contactos a reinscribir
                              mda.crearCont(cn[0], cn[1], cn[2], cn[3], cn[4], cn[5], cn[6]); // madamos a llamar al metodo que nos agrega los contactos al archivo y le mandamos los datos del contacto a agregar
                           }
                           
                 } else if(bandera == false)
                    JOptionPane.showMessageDialog(null,"'El nombre que ingresaste no pertenece a ningun contacto","Contacto no Encontrado" ,0);
              }else{
                  JOptionPane.showMessageDialog(null,"'Aun no es creada tu archivo agenda","Archivo de datos no encontrado" ,2);
              }
         }catch(Exception e){
            System.out.print("error"+e);
         }
           
           }
		  }

            
            }
         };
         botonBorrar.addActionListener(oyenteDeAccionBtBorrar);
         
         JButton botonEditar = new JButton(); 
         botonEditar.setBounds(250,50,50,50);
         ImageIcon imagen3 = new ImageIcon("iEditar.png");
         botonEditar.setIcon(new ImageIcon(imagen3.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
         botonEditar.setToolTipText("Editar Contacto");
         panel.add(botonEditar); 
         
         JButton botonConsulta = new JButton(); 
         botonConsulta.setBounds(50,50,50,50);
         ImageIcon imagen4 = new ImageIcon("iConsulta.png");
         botonConsulta.setIcon(new ImageIcon(imagen4.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
         botonConsulta.setToolTipText("Consultar Contactos");
         panel.add(botonConsulta); 
         
        ActionListener oyenteDeAccionBtConsulta = new ActionListener(){
        @Override 
        public void actionPerformed(ActionEvent ae){
        try{
           File MiArchivo = new File("Agenda.txt");
           FileReader fr;
           BufferedReader br;
              if(MiArchivo.exists()== true){
                 fr = new FileReader(MiArchivo);
                 br = new  BufferedReader(fr);
                 String linea; 
                 while((linea = br.readLine())!= null){
                     String [] cont = linea.split("%");
                     areaTxt.setText(areaTxt.getText() + "Nombre: " + cont[0]+"\n");
                     areaTxt.setText(areaTxt.getText() + "Telefono: " +cont[1]+"\n"); 
                     areaTxt.setText(areaTxt.getText() + "Direccion: " +cont[2]+"\n");
                     areaTxt.setText(areaTxt.getText() + "Relacion: " +cont[3]+"\n");
                     areaTxt.setText(areaTxt.getText() + "Dia: " +cont[4]+"\n");
                     areaTxt.setText(areaTxt.getText() + "Mes: " +cont[5]+"\n");
                     areaTxt.setText(areaTxt.getText() + "Año: " +cont[6]+"\n");
                      areaTxt.setText(areaTxt.getText() + "-----------------------------------------------------------------------------------------------\n\n");
                 }
                  fr.close();
                  br.close();
              }else{
                  JOptionPane.showMessageDialog(null,"'Aun no es creada tu archivo agenda","Archivo de datos no encontrado" ,2);
              }
         }catch(Exception e){
            System.out.print("error"+e);
         }
         
        }
        };
        botonConsulta.addActionListener(oyenteDeAccionBtConsulta);
        
        
        ActionListener oyenteDeAccionBtBuscar = new ActionListener(){
        @Override 
        public void actionPerformed(ActionEvent ae){
        
        String[] options = {"Nombre","Numero","Cancelar"};
        
        String opc  = (String)JOptionPane.showInputDialog(null, "¿Quires buscar el contacto por numero o nombre?", "Buscar contacto", 3, null, options, null);
		
		  if(opc == "Nombre") {
           String nom = (String)JOptionPane.showInputDialog(null, "Ingresa el nombre del contacto", "Captura de nombre", 1);
           if((nom.equals("") == true)){
              JOptionPane.showMessageDialog(null,"Al parecer has dejado en blanco el campo de nombre ¡ Intentalo de nuevo !","Error campo vacio" ,2);
           }else{
           
           try{
           File MiArchivo = new File("Agenda.txt");
           FileReader fr;
           BufferedReader br;
              if(MiArchivo.exists()== true){
                 fr = new FileReader(MiArchivo);
                 br = new  BufferedReader(fr);
                 String linea;
                 boolean bandera = false;
                 areaTxt.setText("");
                 while((linea = br.readLine())!= null ){
                     String [] cont = linea.split("%");
                        if((cont[0].equals(nom)) == true){
                           bandera = true;
                           areaTxt.setText(areaTxt.getText() + "Nombre: " + cont[0]+"\n");
                           areaTxt.setText(areaTxt.getText() + "Telefono: " +cont[1]+"\n"); 
                           areaTxt.setText(areaTxt.getText() + "Direccion: " +cont[2]+"\n");
                           areaTxt.setText(areaTxt.getText() + "Relacion: " +cont[3]+"\n");
                           areaTxt.setText(areaTxt.getText() + "Dia: " +cont[4]+"\n");
                           areaTxt.setText(areaTxt.getText() + "Mes: " +cont[5]+"\n");
                           areaTxt.setText(areaTxt.getText() + "Año: " +cont[6]+"\n");
                           areaTxt.setText(areaTxt.getText() + "-----------------------------------------------------------------------------------------------\n\n");
                        }
                 }
                 if(bandera == false)
                    JOptionPane.showMessageDialog(null,"'El nombre que ingresaste no pertenece a ningun contacto","Contacto no Encontrado" ,0);
              }else{
                  JOptionPane.showMessageDialog(null,"'Aun no es creada tu archivo agenda","Archivo de datos no encontrado" ,2);
              }
         }catch(Exception e){
            System.out.print("error"+e);
         }
           
           }

		  }else if(opc == "Numero"){
           String num = JOptionPane.showInputDialog(null, "Ingresa el numero del contacto","Captura de numero", 1);
           if((num.equals("")) == true){
              JOptionPane.showMessageDialog(null,"Al parecer has dejado en blanco el campo de numero ¡ Intentalo de nuevo !","Error campo vacio" ,2);
           }else{
           
           try{
           File MiArchivo = new File("Agenda.txt");
           FileReader fr;
           BufferedReader br;
              if(MiArchivo.exists()== true){
                 fr = new FileReader(MiArchivo);
                 br = new  BufferedReader(fr);
                 String linea;
                 boolean bandera = false;
                 while((linea = br.readLine())!= null && bandera != true){
                     String [] cont = linea.split("%");
                     areaTxt.setText("");
                        if((cont[1].equals(num)) == true){
                           bandera = true;
                           areaTxt.setText(areaTxt.getText() + "Nombre: " + cont[0]+"\n");
                           areaTxt.setText(areaTxt.getText() + "Telefono: " +cont[1]+"\n"); 
                           areaTxt.setText(areaTxt.getText() + "Direccion: " +cont[2]+"\n");
                           areaTxt.setText(areaTxt.getText() + "Relacion: " +cont[3]+"\n");
                           areaTxt.setText(areaTxt.getText() + "Dia: " +cont[4]+"\n");
                           areaTxt.setText(areaTxt.getText() + "Mes: " +cont[5]+"\n");
                           areaTxt.setText(areaTxt.getText() + "Año: " +cont[6]+"\n");
                           areaTxt.setText(areaTxt.getText() + "-----------------------------------------------------------------------------------------------\n\n");
                        }
                 }
                 if(bandera == false)
                    JOptionPane.showMessageDialog(null,"'El nombre que ingresaste no pertenece a ningun contacto","Contacto no Encontrado" ,0);
              }else{
                  JOptionPane.showMessageDialog(null,"'Aun no es creada tu archivo agenda","Archivo de datos no encontrado" ,2);
              }
         }catch(Exception e){
            System.out.print("error"+e);
         }
           
           
           }
          
		  }
        
        }
        };
        botonBuscar.addActionListener(oyenteDeAccionBtBuscar);
        
        ActionListener oyenteDeAccionBtAdd = new ActionListener(){
      @Override 
      public void actionPerformed(ActionEvent ae){
      
      llenaDatos llD = new llenaDatos();
      llD.setVisible(true);
      dispose();
      
      }
      };
      botonAdd.addActionListener(oyenteDeAccionBtAdd);
        
        }

      
        
    
 
    private void barraD () {
           areaTxt = new JTextArea();
           areaTxt.setLineWrap(true);
           JScrollPane scroll = new JScrollPane(areaTxt, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
           scroll.setBounds(70, 120, 400, 500);
           panel.add(scroll);
    }
      
     /* private void etiquetas(){}
      
      private void cajaDesplegable(){
         
      }      
      */
      
       private void labelFondo(){
         ImageIcon imagen = new ImageIcon("fAzul.png");
         JLabel imagenFond = new JLabel();
         panel.add(imagenFond);
         imagenFond.setBounds(0,0,550,711);
         imagenFond.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(550,711, Image.SCALE_SMOOTH)));
      }


}
