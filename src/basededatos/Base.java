package basededatos;

/**
 *
 * @author ivansteuerberg
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Base {
Connection coneBD = null;
Statement consBD = null;
ResultSet muesBD = null;

public Connection conectar(){

try{
coneBD = DriverManager.getConnection("jdbc:derby://localhost:1527/base","APP","1234");
    System.out.println("Conectado a la base de datos.");
} catch (SQLException ex) {
    Logger.getLogger(Base.class.getName()).log(Level.SEVERE, null,ex);   
}    
return coneBD;

}


public void mostrar(){
    
    try{
        consBD = coneBD.createStatement();
        muesBD = consBD.executeQuery("SELECT * FROM USUARIOS");
        if(muesBD.next()){
        muesBD = consBD.executeQuery("SELECT * FROM USUARIOS");
        System.out.println("\nTabla Usuarios");
        while (muesBD.next()){
        String dni = muesBD.getString("DNI");
        String nombre = muesBD.getString("nombre");
        String apellido1 = muesBD.getString("apellido1");
        String apellido2 = muesBD.getString("apellido2");
        int edad = muesBD.getInt("edad");
            System.out.println("Nombre: "+nombre+" Edad: "+edad+" Apellido1: "+apellido1+" Apellido2: "+apellido2+" DNI: "+dni+"\n");
        }
        }
        else
        System.out.println("La tabla está vacía.");
        
    } catch (SQLException ex) {
     Logger.getLogger(Base.class.getName()).log(Level.SEVERE, null,ex);
    }   
    
}

public void añadir(String nombre,int edad, String apellido1, String apellido2, String dni){
try{

Statement statement = coneBD.createStatement();
statement.executeUpdate("INSERT INTO USUARIOS VALUES ('"+nombre+"',"+edad+", '"+apellido1+"', '"+apellido2+"', '"+dni+"')");
    System.out.println("Fila insertada correctamente!");    
} catch (SQLException ex) {
 Logger.getLogger(Base.class.getName()).log(Level.SEVERE, null,ex);    
}

}

public void actualizar(){
try{
muesBD = consBD.executeQuery("SELECT * FROM USUARIOS");
 if(muesBD.next()){
int opcion = Integer.parseInt(JOptionPane.showInputDialog("Presione una tecla:\n"
        + "1- Actualizar el nombre\n"
        + "2- Actualizar la edad\n"
        + "3- Actualizar el primer apellido1\n"
        + "4- Actualizar el segundo apellido\n"
        + "5- Actualizar el DNI"));
Statement statement = coneBD.createStatement();
String dni=JOptionPane.showInputDialog("Introduce el DNI de la persona a actualizar!");
switch(opcion){
    case 1:
String nombre=JOptionPane.showInputDialog("Introduce el nuevo nombre");     
statement.executeUpdate("UPDATE USUARIOS set nombre='"+nombre+"' where dni='"+dni+"'");
break;
    case 2:
int edad = Integer.parseInt(JOptionPane.showInputDialog("Introduce la nueva edad"));        
statement.executeUpdate("UPDATE USUARIOS set edad='"+edad+"' where dni='"+dni+"'");
break;
    case 3:
String apellido1=JOptionPane.showInputDialog("Introduce el nuevo primer apellido");     
statement.executeUpdate("UPDATE USUARIOS set apellido1='"+apellido1+"' where dni='"+dni+"'");
break;
    case 4:
String apellido2=JOptionPane.showInputDialog("Introduce el nuevo segundo apellido");     
statement.executeUpdate("UPDATE USUARIOS set apellido2='"+apellido2+"' where dni='"+dni+"'");
break;
    case 5:
String nuevodni=JOptionPane.showInputDialog("Introduce el nuevo DNI");     
statement.executeUpdate("UPDATE USUARIOS set dni='"+nuevodni+"' where dni='"+dni+"'");
break;
}
    System.out.println("Datos modificados correctamente!");
}
else
        System.out.println("No hay filas disponibles para modificar");
} catch (SQLException ex) {
 Logger.getLogger(Base.class.getName()).log(Level.SEVERE, null,ex);    
}

}

public void borrar(){
try{
Statement statement = coneBD.createStatement();
String dni=JOptionPane.showInputDialog("Introduce el DNI de la persona a borrar!");
statement.executeUpdate("DELETE FROM USUARIOS where dni='"+dni+"'");


    System.out.println("Datos eliminados correctamente!");
} catch (SQLException ex) {
 Logger.getLogger(Base.class.getName()).log(Level.SEVERE, null,ex);    
}

}

public void cerrar(){
try{
coneBD.close();
    System.out.println("Desconectado de la base de datos.");
} catch (SQLException ex) {
Logger.getLogger(Base.class.getName()).log(Level.SEVERE, null,ex);      
}
    
}

    






}
