package dk.sdu.pa2.task2;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class PokemonReader {
    public List<Pokemon> pokemons = new ArrayList<>();
    public List<Pokemon> readFromFile(File file) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] pokemonData = line.split(",");
                int id = Integer.parseInt(pokemonData[0]);
                String name = pokemonData[1];
                String image = pokemonData[2];
                PokemonType pokemonType = PokemonType.valueOf(pokemonData[3]);
                int hp = Integer.parseInt(pokemonData[4]);
                int attack = Integer.parseInt(pokemonData[5]);
                int defense = Integer.parseInt(pokemonData[6]);
                Pokemon pokemon = new Pokemon(id, name, image, pokemonType,hp, attack, defense);
                pokemons.add(pokemon);
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("Failed to read from file " + file.getName() + " Cause: " + e.getCause() + " Message: " + e.getMessage());
        }
        return pokemons;
    }

    public Map<PokemonType, List<Pokemon>> mapPokemon(List<Pokemon> pokemonList) {
        Map<PokemonType, List<Pokemon>> pokemonMap = new HashMap<>();
        for (Pokemon pokemon : pokemonList) {
            if (pokemonMap.containsKey(pokemon.getType())) {
                pokemonMap.get(pokemon.getType()).add(pokemon);
            } else {
                List<Pokemon> pokemons = new ArrayList<>();
                pokemons.add(pokemon);
                pokemonMap.put(pokemon.getType(), pokemons);
            }
        }
        return pokemonMap;
    }
}
