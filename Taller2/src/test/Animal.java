package test;

public class Animal {
    String nombre;
    String genero = "M";
    double peso;
    Animal pareja;
    static int totalAnimales;

    void setPareja(Animal pareja) {
        this.pareja = pareja;
    }

    Animal tenerHijo(String nombre) {
        Animal hijo = new Animal();
        totalAnimales++;
        hijo.nombre = nombre;
        hijo.peso = 1;
        double random = Math.random();
        if (random < 0.5)
            hijo.genero = "F";
        else
            hijo.genero = "M";
        return hijo;
    }

    Familia procrear(String nombreHijo) {

        if (pareja == null) {
            System.out.println(this.nombre + " no tiene pareja");
            return null;
        }

        if (pareja.genero.equals(genero)) {
            System.out.println(nombre + " y " + pareja.nombre + " son del mismo genero");
            return null;
        }

        System.out.println(nombre + " y " + pareja.nombre + " van a tener un hijo");

        Familia f = new Familia();

        if (this.genero.equals("M")) {
            f.mama = pareja;
            f.papa = this;
        } else {
            f.mama = this;
            f.papa = this.pareja;
        }

        Animal hijo = f.mama.tenerHijo(nombreHijo);
        f.hijo = hijo;
        System.out.println(hijo.nombre + " ha llegado al mundo");
        return f;
    }

    static void morir(Animal animal) {
        System.out.println(animal.nombre + " ha muerto");
        totalAnimales--;
    }

    public String toString() {
        return "Me llamo " + nombre + " y peso " + peso;
    }
}

class Familia {
    Animal papa;
    Animal mama;
    Animal hijo;

    void imprimir() {
        String genero;
        if (hijo.genero.equals("M"))
            genero = "masculino";
        else
            genero = "femenino";
        System.out.println(papa.nombre + " es el papá, " + mama.nombre + " es la mamá, y " + hijo.nombre + " es el hijo de genero " + genero);
    }
}

class FamiliaAnimales {
    public static void main(String args[]) {
        Animal animal1 = new Animal();
        Animal.totalAnimales++;
        Animal animal2 = new Animal();
        Animal.totalAnimales++;

        animal1.nombre = "Cebra";
        animal1.genero = "F";

        animal2.nombre = "Caballo";
        animal2.peso = 98.0;

        System.out.println(animal1.nombre + " se va a casar con " + animal2.nombre);
        animal1.setPareja(animal2);
        animal2.setPareja(animal1);

        Familia familia = animal1.procrear("Cebrallo");

        if (familia != null) {
            familia.imprimir();
            System.out.println(familia.hijo.toString());
        } else {
            System.out.println("No puedo formar familia");
        }
        System.out.println("Total de animales: " + Animal.totalAnimales);
        Animal.morir(animal2);
        System.out.println("Nuevo total de animales: " + Animal.totalAnimales);
    }
}