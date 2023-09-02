package com.example.animalapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AnimalAdapter.MyClickInterface{

    RecyclerView recyclerView;
    ArrayList<Animal> animals;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        animals = new ArrayList<>();

        animals.add(new Animal("Fox", R.drawable.fox));
        animals.add(new Animal("Butterfly", R.drawable.butterfly));
        animals.add(new Animal("Dolphin", R.drawable.dolphin));
        animals.add(new Animal("Dachshund", R.drawable.dachshund));
        animals.add(new Animal("Hedgehog", R.drawable.hedgehog));
        animals.add(new Animal("Lion", R.drawable.lion));
        animals.add(new Animal("Swan", R.drawable.swan));
        animals.add(new Animal("Tiger", R.drawable.tiger));
        animals.add(new Animal("Turtle", R.drawable.turtle));
        animals.add(new Animal("Red Fox", R.drawable.redfox));

        AnimalAdapter animalAdapter = new AnimalAdapter(animals, this, this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(animalAdapter);


    }

    public void onItemClick(int positionOfTheAnimal) {
        Toast.makeText(this, "Clicked " + animals.get(positionOfTheAnimal).getName(),Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, AnimalInfo.class);
        intent.putExtra("image", animals.get(positionOfTheAnimal).getImage());
        intent.putExtra("name", animals.get(positionOfTheAnimal).getName());
        startActivity(intent);
    }

}