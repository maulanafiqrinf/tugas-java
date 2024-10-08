package enkapsulasi;

class Player{
    private String name;
    private int basehealth;
    private Armor armor;
    private int level;
    private int incrementHealth;
    
    public Player(String name){
        this.name = name;
        this.basehealth = 100;
        this.level = 1;
        this.incrementHealth = 20;
    }
    
    public void display(){
        System.out.println("player\t\t:" + this.name);
        System.out.println("level\t\t:" + this.level);
        System.out.println("maxHealth\t:" + this.maxhealth());
    }
    
    public void levelUp(){
        this.level++;
    }
    
    public void setArmor(Armor armor){
        this.armor = armor;
    }
    
    public int maxhealth(){
        return this.basehealth+this.level*this.incrementHealth+this.armor.getaddhealth();
    }
}

class Armor{
    private String name;
    private int strength;
    private int health;
    
    public Armor(String name,int strength, int health){
        this.name = name;
        this.strength = strength;
        this.health = health;
    }
    
    public int getaddhealth(){
        return this.strength*10 + this.health;
    }
}

public class main {
     public static void main(String[] args) {
        
        Player player1 = new Player("Fiqri");
        Armor armor1 = new Armor("Baju Besi",5,100);
        player1.setArmor(armor1);
        player1.display();
        player1.levelUp();
        player1.display();
     
    }
}
