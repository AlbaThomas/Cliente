import java.util.Random;
import java.util.Scanner;

public class Cliente1 {
    private String nombre;
    private int edad;
    private String dni;
    private char sexo;
    private double peso;
    private double altura;

    // Constructor por defecto
    public Cliente1(String nombre, int edad, String dni, char sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.sexo = comprobarSexo(sexo);
    }

    // Constructor con nombre, dni, sexo
    public Cliente1(String nombre, String dni, char sexo) {
        this.nombre = nombre;
        this.dni = dni;
        this.sexo = comprobarSexo(sexo);
    }

    // Constructor con todos los atributos
    public Cliente1(String nombre, int edad, String dni, char sexo, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.sexo = comprobarSexo(sexo);
        this.peso = peso;
        this.altura = altura;
    }

    // Métodos set/get
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = comprobarSexo(sexo);
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    // Métodos

    public int calcularIMC() {
        double imc = peso / (altura * altura);
        if (imc < 20) {
            return -1;
        } else if (imc >= 20 && imc <= 25) {
            return 0;
        } else {
            return 1;
        }
    }

    public boolean esMayorDeEdad() {
        return edad >= 18;
    }

    private char comprobarSexo(char sexo) {
        if (sexo == 'H' || sexo == 'M') {
            return sexo;
        } else {
            return 'H';
        }
    }

    private void generaDNI() {
        Random rnd = new Random();
        int num = rnd.nextInt(90000000) + 10000000;
        String letraDNI = "TRWAGMYFPDXBNJZSQVHLCKE";
        int index = num % 23;
        dni = Integer.toString(num) + letraDNI.charAt(index);
    }

    @Override
    public String toString() {
        return "Datos del cliente {" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                ", sexo=" + sexo +
                ", peso=" + peso +
                ", altura=" + altura +
                '}';
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pedir datos por teclado
        System.out.print("Ingrese el nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese la edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        System.out.print("Ingrese el sexo (H/M): ");
        char sexo = scanner.nextLine().charAt(0);

        System.out.print("Ingrese el peso (kg): ");
        double peso = scanner.nextDouble();

        System.out.print("Ingrese la altura (m): ");
        double altura = scanner.nextDouble();
        scanner.nextLine(); // Limpiar el buffer


        // Crear objetos
        Cliente1 cliente1 = new Cliente1(nombre, edad, "", sexo, peso, altura);
        Cliente1 cliente2 = new Cliente1("Cliente 2", 25, "12345678X", 'M');


        // Comprobar IMC y si es mayor de edad para cada objeto
        Cliente1[] clientes = {cliente1, cliente2};
        for (Cliente1 cliente : clientes) {
            int imc = cliente.calcularIMC();
            String mensajeIMC;
            switch (imc) {
                case -1:
                    mensajeIMC = "Por debajo de su peso ideal";
                    break;
                case 0:
                    mensajeIMC = "En su peso ideal";
                    break;
                case 1:
                    mensajeIMC = "Con sobrepeso";
                    break;
                default:
                    mensajeIMC = "Error al calcular el IMC";
            }
            System.out.println(cliente.getNombre() + ": " + mensajeIMC);

            if (cliente.esMayorDeEdad()) {
                System.out.println(cliente.getNombre() + " es mayor de edad.");
            } else {
                System.out.println(cliente.getNombre() + " es menor de edad.");
            }
            System.out.println("Linea 2 añadida para push");
            System.out.println(cliente1);
            System.out.println(cliente2);
            System.out.println();
        }

        scanner.close();
    }
}