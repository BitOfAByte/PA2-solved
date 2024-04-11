package dk.sdu.pa2;

import dk.sdu.pa2.task2.HealthComparator;
import dk.sdu.pa2.task2.Pokemon;
import dk.sdu.pa2.task2.PokemonType;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static dk.sdu.pa2.task2.PokemonType.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ComparisonTest {
    @Test
    public void test_pokemon_are_compared_against_names() {
        Pokemon pokemonOne = new Pokemon(6,"Charizard",null, Fire,78,84,78);
        Pokemon pokemonTwo = new Pokemon(91,"Cloyster",null, Ice,50,95,180);
        Pokemon pokemonThree = new Pokemon(134,"Vaporeon",null, Water,130,65,60);
        Pokemon pokemonFour = new Pokemon(15,"Beedrill",null, Bug,65,90,40);

        ArrayList<Pokemon> pokemons = new ArrayList<>();
        pokemons.add(pokemonOne);
        pokemons.add(pokemonTwo);
        pokemons.add(pokemonThree);
        pokemons.add(pokemonFour);
        Collections.sort(pokemons);
        assertEquals(pokemonFour, pokemons.get(0));
        assertEquals(pokemonOne, pokemons.get(1));
        assertEquals(pokemonTwo, pokemons.get(2));
        assertEquals(pokemonThree, pokemons.get(3));
        System.out.println(pokemons.stream().map(Pokemon::toString).collect(Collectors.joining("\n")));
    }

    @Test
    public void test_pokemon_are_compared_against_health_using_comparator() {
        Pokemon pokemonOne = new Pokemon(63,"Abra",null, Psychic,25,20,15);
        Pokemon pokemonTwo = new Pokemon(6,"Charizard",null, Fire,78,84,78);
        Pokemon pokemonThree = new Pokemon(14,"Kakuna",null, Bug,45,25,50);
        Pokemon pokemonFour = new Pokemon(10,"Caterpie",null,Bug,45,30,35);
        Pokemon pokemonFive = new Pokemon(144,"Articuno",null,Ice,90,85,100);
        Pokemon pokemonSix = new Pokemon(145,"Zapdos",null,Electric,90,90,85);
        Pokemon pokemonSeven = new Pokemon(146,"Moltres",null,Fire,90,100,90);

        List<Pokemon> pokemons = new ArrayList<>();
        pokemons.add(pokemonOne);
        pokemons.add(pokemonTwo);
        pokemons.add(pokemonThree);
        pokemons.add(pokemonFour);
        pokemons.add(pokemonFive);
        pokemons.add(pokemonSix);
        pokemons.add(pokemonSeven);
        pokemons.sort(new HealthComparator());

        assertEquals(pokemonFive, pokemons.get(0));
        assertEquals(pokemonSeven, pokemons.get(1));
        assertEquals(pokemonSix, pokemons.get(2));
        assertEquals(pokemonTwo, pokemons.get(3));
        assertEquals(pokemonFour, pokemons.get(4));
        assertEquals(pokemonThree, pokemons.get(5));
        assertEquals(pokemonOne, pokemons.get(6));
        System.out.println(pokemons.stream().map(Pokemon::toString).collect(Collectors.joining("\n")));
    }
}
