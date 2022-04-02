ActionListener oyenteDeAccionBtBorrar = new ActionListener(){
            @Override 
            public void actionPerformed(ActionEvent ae){
            
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
}
};