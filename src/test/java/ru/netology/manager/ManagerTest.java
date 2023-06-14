package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ManagerTest {

    @Test
    public void shouldAddMovie() {
        MoviesManager manager = new MoviesManager();
        manager.addMovies("Криминальное чтиво");
        String[] expected = {"Криминальное чтиво"};
        String[] actual = manager.findAllMovies();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddNothingMovie() {
        MoviesManager manager = new MoviesManager();
        manager.findLast();
        String[] expected = {};
        String[] actual = manager.findAllMovies();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddOverLimMovies() {
        MoviesManager manager = new MoviesManager();
        manager.addMovies("Криминальное чтиво");
        manager.addMovies("Однажды в Голливуде");
        manager.addMovies("Начало");
        manager.addMovies("Ходячие мертвецы");
        manager.addMovies("Бумажный дом");
        manager.addMovies("Области тьмы");
        String[] expected = {"Криминальное чтиво", "Однажды в Голливуде", "Начало", "Ходячие мертвецы", "Бумажный дом", "Области тьмы"};
        String[] actual = manager.findAllMovies();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddUnderLimMovies() {
        MoviesManager manager = new MoviesManager();
        manager.addMovies("Криминальное чтиво");
        manager.addMovies("Однажды в Голливуде");
        manager.addMovies("Начало");
        manager.addMovies("Ходячие мертвецы");
        String[] expected = {"Криминальное чтиво", "Однажды в Голливуде", "Начало", "Ходячие мертвецы"};
        String[] actual = manager.findAllMovies();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowReverseOverLimMovies() {
        MoviesManager manager = new MoviesManager();
        manager.addMovies("Криминальное чтиво");
        manager.addMovies("Однажды в Голливуде");
        manager.addMovies("Начало");
        manager.addMovies("Ходячие мертвецы");
        manager.addMovies("Бумажный дом");
        manager.addMovies("Области тьмы");
        String[] expected = {"Области тьмы", "Бумажный дом", "Ходячие мертвецы", "Начало", "Однажды в Голливуде"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowReverseUnderLimMovies() {
        MoviesManager manager = new MoviesManager();
        manager.addMovies("Криминальное чтиво");
        manager.addMovies("Однажды в Голливуде");
        manager.addMovies("Начало");
        manager.addMovies("Ходячие мертвецы");
        String[] expected = {"Ходячие мертвецы", "Начало", "Однажды в Голливуде", "Криминальное чтиво"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }
}