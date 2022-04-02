import java.io.File;
import java.io.*;
import javax.swing.*;
import java.util.*;
public class ManejoDeArchivos {
   
   String nombre, telefono, direccion, relacion, dia, mes, año;
   muestraDatos md = new muestraDatos();
   
   public void crearCont(String nombre, String telefono, String direccion, String relacion, String dia, String mes, String años){
   this.nombre = nombre;
   this.telefono = telefono;
   this.direccion = direccion;
   this.relacion = relacion;
   this.dia = dia;
   this.mes = mes;
   this.año = año;
   try{
      File MiArchivo = new File("Agenda.txt");
      FileWriter fw;
      BufferedWriter bw;
      
      if(MiArchivo.exists()== true){
         fw = new FileWriter(MiArchivo, true);
         bw = new  BufferedWriter(fw);
         System.out.println(MiArchivo.length());
         if(MiArchivo.length() >= 1){
            bw.newLine();
            }
         bw.write(nombre+"%"+telefono+"%"+direccion+"%"+relacion+"%"+dia+"%"+mes+"%"+años);
      }else{
         MiArchivo.createNewFile();
         fw = new FileWriter(MiArchivo);
         bw = new  BufferedWriter(fw);
         bw.write(nombre+"%"+telefono+"%"+direccion+"%"+relacion+"%"+dia+"%"+mes+"%"+años);
         
      }
      bw.close();
      fw.close(); 
   }catch(Exception e){
      System.out.print("error"+e);
   }
   
   }
   
   //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   public void vaciarArchivo(){
   try{
      File MiArchivo = new File("Agenda.txt");
      FileWriter fw;
      BufferedWriter bw;
      
      if(MiArchivo.exists()== true){
         fw = new FileWriter(MiArchivo);
         bw = new  BufferedWriter(fw);
         bw.write("");
      }else{
         MiArchivo.createNewFile();
         fw = new FileWriter(MiArchivo);
         bw = new  BufferedWriter(fw);
         bw.write("");
      }
      bw.close();
      fw.close(); 
   }catch(Exception e){
      System.out.print("error"+e);
   }
   
   }

}