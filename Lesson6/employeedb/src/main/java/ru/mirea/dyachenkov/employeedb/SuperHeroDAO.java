package ru.mirea.dyachenkov.employeedb;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface SuperHeroDAO {
    @Query("SELECT * FROM superhero")
    List<SuperHero> getAll();
    @Query("SELECT * FROM SuperHero WHERE id = :id")
    SuperHero getById(long id);
    @Insert
    void insert(SuperHero superhero);
    @Update
    void update(SuperHero superhero);
    @Delete
    void delete(SuperHero superhero);
}
