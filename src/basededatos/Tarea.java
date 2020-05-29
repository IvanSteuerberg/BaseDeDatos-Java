package basededatos;

import javax.swing.JOptionPane;

/**
 *
 * @author ivansteuerberg
 */
public class Tarea {

public static void main(String[] args){

Base obx = new Base();
//statement.executeUpdate("INSERT INTO USUARIOS VALUES ("+nombre+","+edad+", "+apellido1+", "+apellido2+", "+dni+")");
//obx.actualizar();
//obx.cerrar();
int opcion;
do{ 
opcion = Integer.parseInt(JOptionPane.showInputDialog("***MENÚ***\n"
        + "1-Conectarse a la base\n"
        + "2-Mostrar filas de la tabla\n"
        + "3-Añadir una fila\n"
        + "4-Actualizar una fila\n"
        + "5-Eliminar una fila\n"
        + "6-Desconectarse\n"
        + "7-Salir"));
switch(opcion){
    case 1: 
    obx.conectar();    
    break;
    case 2:
    obx.mostrar();
    break;
    case 3:
    String nombre = JOptionPane.showInputDialog("Introduce el nombre");
    int edad = Integer.parseInt(JOptionPane.showInputDialog("Introduce la edad"));
    String apellido1 = JOptionPane.showInputDialog("Introduce el primer apellido");
    String apellido2 = JOptionPane.showInputDialog("Introduce el segundo apellido");
    String dni = JOptionPane.showInputDialog("Introduce el dni");
    obx.añadir(nombre,edad,apellido1,apellido2,dni);
    break;
    case 4:
    obx.actualizar();
    break;
    case 5:
    obx.borrar();
    break;
    case 6:
    obx.cerrar();
    break;    


}
}while (opcion<7);


}
    
}
