package ru.mirea.dyachenkov.employeedb;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppDatabase db = App.getInstance().getDatabase();
        SuperHeroDAO employeeDao = db.employeeDao();
        SuperHero superHeroOne = new SuperHero();
        superHeroOne.name = "John Smith";
        superHeroOne.power = 10000;
        SuperHero superHeroTwo = new SuperHero();
        superHeroTwo.name = "scarcely";
        superHeroTwo.power = 5000;
        SuperHero superHeroThree = new SuperHero();
        superHeroThree.name = "Dumbledore";
        superHeroThree.power = 120000;
        // запись сотрудников в базу
        employeeDao.insert(superHeroOne);
        employeeDao.insert(superHeroThree);
        employeeDao.insert(superHeroTwo);
        // Загрузка всех работников
        List<SuperHero> superHeroes = employeeDao.getAll();
        for (SuperHero superHero : superHeroes){
        Log.i(TAG, superHero.name + " " + superHero.power);
        }
    }
}