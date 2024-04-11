package dk.sdu.pa2.task2;

public class Pokemon implements Comparable<Pokemon>{
    private int id;
    private String name;
    private String image;
    private PokemonType type;
    private int health;
    private int attack;
    private int defense;

    public Pokemon(int id, String name, String image, PokemonType type,  int health, int attack, int defense) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.type = type;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PokemonType getType() {
        return type;
    }

    public void setType(PokemonType type) {
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    @Override
    public String toString() {
        return name + "  (" + type + ")  " + "Health: " + health;
    }

    @Override
    public int compareTo(Pokemon o) {
        return this.name.compareTo(o.name);
    }

}
