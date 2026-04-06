package Exam_1.Scanner_Classes;
import java.util.Scanner;


public class Basic {
    public static void main(String[] args) {

        //! Clase 1/26/2025
        Scanner sc = new Scanner(System.in);

        System.out.print("Type something: ");
        String input = sc.nextLine();

        System.out.println("You wrote: " + input);

        sc.close();

        //! Clase 1/28/2025
        int counter = 0;

        if(counter == 0){
            System.out.println("Numero es 0");
        } else {
            System.out.println("Numero no es 0");
        }

        // Loop 5 veces
        while (counter < 5) {
            System.out.println("Numero es 0");
            ++counter;
        }

        // Boring ass class (no reason to write anything)



        //*Arrays

        int[] miArray = new int[5];
        miArray[4] = 53;
        
        for(int n = 0; n < miArray.length; n++){
            miArray[n] = n + 1;
        }

        //! 1/30/2026

        /* 
        siempre validar y manejo de errores de inputs los problemas aunq no lo diga 
        si el dice escribe el programa tines q escribir todo (imports classes mains todooo)
        si el dice escribe el codigo solo vas a escribir el snipet de codigo 
        learn what the all the parseInt and parses do


        TODO: repasar classes

        overrides 
        final classes
        classes anidadas (classes q estan dentro de otras) si una clase esta dentro de otra puede ser static
        clases locales
        classes abstractas 
        interface (lowkey dont remeber what this does)
        */ 


        // exception handling
        Scanner elinput = new Scanner(System.in);
        String peso_str;
        double peso = 0;
        
        try{ 
            System.out.println("Entre peso");
            peso_str = elinput.nextLine();
            peso = Double.parseDouble(peso_str);

            if(peso > 0){
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number."); // estos son mas precisos con el error

        } catch (ArithmeticException e){
            System.out.println("No se puede dividir por cero"); //estos son mas precisos con el error

        }catch (Exception e){
            System.out.println("Se produjo un error inesperado:" +e.getMessage()); // siempre pon este 
        }

            elinput.close();


        class Person{

            String name;

            void greet(){
                System.out.println("hello " + name);
            }   
        }
        Person a = new Person();
        a.greet();
    }
}

class Pokemon {

    // A simple type system
    public enum Type {
        FIRE, WATER, GRASS, NORMAL
    }

    // Fields (data)
    private String name;
    private Type type;
    private int level;
    private int maxHP;
    private int hp;
    private int attack;
    private int defense;

    // Constructor
    public Pokemon(String name, Type type, int level, int maxHP, int attack, int defense) {
        this.name = name;
        this.type = type;
        this.level = level;
        this.maxHP = maxHP;
        this.hp = maxHP;
        this.attack = attack;
        this.defense = defense;
    }

    // Getters
    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public int getLevel() {
        return level;
    }

    public int getHp() {
        return hp;
    }

    public int getMaxHP() {
        return maxHP;
    }

    // Checks
    public boolean isFainted() {
        return hp <= 0;
    }

    // Heal
    public void heal(int amount) {
        if (isFainted()) {
            System.out.println(name + " can't heal because it fainted!");
            return;
        }

        hp += amount;
        if (hp > maxHP)
            hp = maxHP;

        System.out.println(name + " healed! HP is now " + hp + "/" + maxHP);
    }

    // Take damage
    public void takeDamage(int dmg) {
        hp -= dmg;
        if (hp < 0)
            hp = 0;

        System.out.println(name + " took " + dmg + " damage! HP: " + hp + "/" + maxHP);

        if (isFainted()) {
            System.out.println(name + " fainted!");
        }
    }

    // Attack another pokemon
    public void attack(Pokemon enemy) {
        if (this.isFainted()) {
            System.out.println(this.name + " can't attack because it fainted!");
            return;
        }
        if (enemy.isFainted()) {
            System.out.println(enemy.name + " is already fainted!");
            return;
        }

        double multiplier = typeEffectiveness(this.type, enemy.type);

        // Simple damage formula (not fancy)
        int baseDamage = (this.attack + this.level) - enemy.defense;
        if (baseDamage < 1)
            baseDamage = 1; // always do at least 1 damage

        int totalDamage = (int) (baseDamage * multiplier);

        System.out.println(this.name + " attacks " + enemy.name + "!");
        if (multiplier == 2.0)
            System.out.println("It's super effective!");
        if (multiplier == 0.5)
            System.out.println("It's not very effective...");
        if (multiplier == 1.0)
            System.out.println("It hits normally.");

        enemy.takeDamage(totalDamage);
    }

    // Type advantage rules
    private double typeEffectiveness(Type attacker, Type defender) {
        if (attacker == Type.FIRE && defender == Type.GRASS)
            return 2.0;
        if (attacker == Type.GRASS && defender == Type.WATER)
            return 2.0;
        if (attacker == Type.WATER && defender == Type.FIRE)
            return 2.0;

        if (attacker == Type.GRASS && defender == Type.FIRE)
            return 0.5;
        if (attacker == Type.WATER && defender == Type.GRASS)
            return 0.5;
        if (attacker == Type.FIRE && defender == Type.WATER)
            return 0.5;

        return 1.0;
    }

    // Display info
    public void printInfo() {
        System.out.println("=== " + name + " ===");
        System.out.println("Type: " + type);
        System.out.println("Level: " + level);
        System.out.println("HP: " + hp + "/" + maxHP);
        System.out.println("ATK: " + attack + " | DEF: " + defense);
    }

    // Quick test main
    public static void main(String[] args) {
        Pokemon charmander = new Pokemon("Charmander", Type.FIRE, 10, 50, 20, 8);
        Pokemon bulbasaur = new Pokemon("Bulbasaur", Type.GRASS, 10, 55, 18, 10);

        charmander.printInfo();
        bulbasaur.printInfo();

        System.out.println();

        charmander.attack(bulbasaur);
        bulbasaur.attack(charmander);

        System.out.println();
        bulbasaur.heal(10);
    }
}

//! 2/4/2026 (nada de esto viene para el primer examen)

/*

Todo: always look at whats inside

*n = unknown amount
one loop = On
two loops = On^2  
...

*if n is known
one loop = the amount of n (7 times = 7n)

*in a while (example)
? while(n >1){
?    n = n/2;
?    System.out.println("Current n: " + n);
?}
its log(2n)

*in a bigger one(example)

?for(int i = 0: i < arr.length; i++){
?   sysout.arr[i];
?}
?for(int i = 0: i < arr.length; i++){
?    for(int i = 0: i < arr.length; i++){
?        sysout.arr[i];
?    } 
?}
its n^2 + n -> soo its n^2

*in fibanaci
its 2^n

*when u have to variables n and m (2d Array)
its n*2 

*linear search 
its On

*Binary search
its O(log n)



*/

/*
!Examen viernes

?interfaces
?execption
?import, is valid, try (basically read problem scanner)
*/