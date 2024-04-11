package dk.sdu.pa2.task3;

import dk.sdu.pa2.task2.HealthComparator;
import dk.sdu.pa2.task2.Pokemon;
import dk.sdu.pa2.task2.PokemonReader;
import dk.sdu.pa2.task2.PokemonType;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class PrimaryController {
    @FXML
    private ChoiceBox<PokemonType> choiceBox;
    @FXML
    private ImageView imageView1, imageView2, imageView3;
    @FXML
    private Label name1, name2, name3;
    @FXML
    private Label health1, health2, health3;
    @FXML
    private Label attack1, attack2, attack3;
    @FXML
    private Label defense1, defense2, defense3;

    private File file = new File("pokemon.csv");

    private List<Pokemon> pokemonList;
    private Map<PokemonType, List<Pokemon>> pokemonMap;

    @FXML
    public void initialize() {
        PokemonReader reader = new PokemonReader();
        pokemonList = reader.readFromFile(file);
        pokemonMap = reader.mapPokemon(pokemonList);
        choiceBox.getItems().addAll(pokemonMap.keySet());
        choiceBox.getSelectionModel().selectFirst();
        updatePokemon();
    }

    public void updatePokemon() {
        List<Pokemon>  pokemons = pokemonMap.get(choiceBox.getValue());
        pokemons.sort(new HealthComparator());
        for (int i = 0; i < 3; i++) {
            Pokemon pokemon = pokemons.get(i);
            URL imageURL = getClass().getResource("pokemon_images/" + pokemon.getName()+ ".png");
            if(imageURL == null) {
                System.out.println("Could not find image for " + pokemon.getName());
                continue;
            }

            switch (i) {
                case 0:
                    imageView1.setImage(new Image(imageURL.toExternalForm()));
                    name1.setText(pokemon.getName());
                    health1.setText("Health: " + pokemon.getHealth());
                    attack1.setText("Attack: " + pokemon.getAttack());
                    defense1.setText("Defense: " + pokemon.getDefense());
                    break;
                case 1:
                    imageView2.setImage(new Image(imageURL.toExternalForm()));
                    name2.setText(pokemon.getName());
                    health2.setText("Health: " + pokemon.getHealth());
                    attack2.setText("Attack: " + pokemon.getAttack());
                    defense2.setText("Defense: " + pokemon.getDefense());
                    break;
                case 2:
                    imageView3.setImage(new Image(imageURL.toExternalForm()));
                    name3.setText(pokemon.getName());
                    health3.setText("Health: " + pokemon.getHealth());
                    attack3.setText("Attack: " + pokemon.getAttack());
                    defense3.setText("Defense: " + pokemon.getDefense());
                    break;
            }
        }

    }
}