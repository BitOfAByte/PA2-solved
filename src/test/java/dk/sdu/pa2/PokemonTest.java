package dk.sdu.pa2;

import dk.sdu.pa2.task2.Pokemon;
import dk.sdu.pa2.task2.PokemonReader;
import dk.sdu.pa2.task2.PokemonType;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class PokemonTest {
    @Test
    public void test_pokemon_can_load_from_csv() {
        File testFile = new File("src/test/resources/testpokemon.csv");
        PokemonReader pokemonReader = new PokemonReader();
        List<Pokemon> pokemons = pokemonReader.readFromFile(testFile);
        assertEquals("Bulbasaur", pokemons.get(0).getName());
        assertEquals("Charmander", pokemons.get(1).getName());
        assertEquals("Squirtle", pokemons.get(2).getName());
        System.out.println(pokemons);
    }

    @Test
    public void test_pokemon_type_is_mapped() {
        File testFile = new File("src/test/resources/testtypes.csv");
        PokemonReader pokemonReader = new PokemonReader();
        List<Pokemon> pokemons = pokemonReader.readFromFile(testFile);
        Map<PokemonType, List<Pokemon>> mappedPokemon = pokemonReader.mapPokemon(pokemons);

        assertEquals("Charmeleon", mappedPokemon.get(PokemonType.Fire).get(1).getName());
        assertEquals("Seel", mappedPokemon.get(PokemonType.Ice).get(0).getName());
        assertEquals("Dragonite", mappedPokemon.get(PokemonType.Dragon).get(2).getName());
        assertEquals("Raichu", mappedPokemon.get(PokemonType.Electric).get(1).getName());

        System.out.println("First 2 Fire:");
        System.out.println(mappedPokemon.get(PokemonType.Fire).stream().limit(2).map(Pokemon::toString).collect(Collectors.joining("\n"))+"\n");
        System.out.println("First 2 Ice:");
        System.out.println(mappedPokemon.get(PokemonType.Ice).stream().limit(2).map(Pokemon::toString).collect(Collectors.joining("\n"))+"\n");
        System.out.println("First 3 Dragon:");
        System.out.println(mappedPokemon.get(PokemonType.Dragon).stream().limit(3).map(Pokemon::toString).collect(Collectors.joining("\n"))+"\n");
        System.out.println("First 2 Electric:");
        System.out.println(mappedPokemon.get(PokemonType.Electric).stream().limit(2).map(Pokemon::toString).collect(Collectors.joining("\n"))+"\n");
    }
}