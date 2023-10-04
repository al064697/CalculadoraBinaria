import javax.swing.*;


public class Calculadora {
    public final char ENTER = '\n';
    private String operacion, resultado;
    int n1, n2;

    public void Operacion() {
        operacion = JOptionPane.showInputDialog(null,
                "Calculadora de binarios" + ENTER + "Ingresa una operación binaria "
                        + "(suma, resta de complementos o multiplicación)");
        if((operacion.contains("0") && operacion.contains("1"))) {
            if (operacion.contains("+")) {
                SumaBinarios();
            }
            else if(operacion.contains("x")) {
                MultiplicacionBinaria();
            }
            else if(operacion.contains("-")) {
                RestaBinariaComplementos();
            }
        } else {
            while (!((operacion.equals("0")) && operacion.equals("1"))) {
                JOptionPane.showMessageDialog(null, "valores no binarios" +ENTER
                        + "intenta de nuevo");
                Operacion();
            }
        }
    }

    public void RestaBinariaComplementos() {
        n1 = Integer.parseInt(operacion.substring(0, operacion.indexOf('-')).trim(), 2);
        n2 = Integer.parseInt(operacion.substring(operacion.indexOf('-') + 1).trim(), 2);
        resultado = Integer.toBinaryString(n1 - n2);
        JOptionPane.showMessageDialog(null,
                "El resultado de la resta binaria es " + resultado + " base 2");
    }

    public void MultiplicacionBinaria() {
        n1 = Integer.parseInt(operacion.substring(0, operacion.indexOf('x')).trim(), 2);
        n2 = Integer.parseInt(operacion.substring(operacion.indexOf('x') + 1).trim(), 2);
        resultado = Integer.toBinaryString(n1 * n2);
        JOptionPane.showMessageDialog(null,
                "El resultado de la multiplicacion binaria es " + resultado + " base 2");
    }

    public void SumaBinarios() {
        n1 = Integer.parseInt(operacion.substring(0, operacion.indexOf('+')).trim(), 2);
        n2 = Integer.parseInt(operacion.substring(operacion.indexOf('+') + 1).trim(), 2);
        resultado = Integer.toBinaryString(n1  + n2);
        JOptionPane.showMessageDialog(null, "El resultado de la suma binaria es "
                + resultado + " base 2");
    }

    public void ApagarCalculadora(int opcion) {
        switch(opcion) {
            case 1:
                JOptionPane.showMessageDialog(null, "Apagando calculadora...");
                System.exit(0);
                break;
            case 0:
                Opciones();
                break;
            default:
                JOptionPane.showMessageDialog(null, "SYSTEM ERROR. " + ENTER + ENTER
                        + "Try latter");
                System.exit(0);
        }
    }

    public void Opciones() {
        int opcion = 0;
        try {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "Iniciar?"
                    + ENTER + "Si..........1" + ENTER + "No..........0"));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: valores no aceptados." + ENTER
                    + "Intenta desde el principio");
            Opciones();
            System.exit(0);
        }
        do {
            switch(opcion) {
                case 1:
                    JOptionPane.showMessageDialog(null, "Iniciando calculadora...");
                    Operacion();
                    break;
                case 0:
                    try {
                        opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Entonces, ¿desea apagar?" + ENTER + "Si..........1" + ENTER
                                        + "No..........0"));
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null,
                                "Error: valores no aceptados." + ENTER + "Intenta desde el principio");
                        Opciones();
                        System.exit(0);
                    }
                    ApagarCalculadora(opcion);
                    break;
            }
        } while ((opcion == 1) | (opcion == 0));
        JOptionPane.showMessageDialog(null,
                "SYSTEM ERROR. " + ENTER +"Try latter");
        System.exit(0);
    }

    public void EncenderCalculadora(boolean estado) {
        if(estado) {
            JOptionPane.showMessageDialog(null, "Calculadora encendida");
            Opciones();
        } else if(!estado) {
            System.out.println(" ");
        }
    }

    public static void main(String[] args) {
        Main.main(args);
    }
}