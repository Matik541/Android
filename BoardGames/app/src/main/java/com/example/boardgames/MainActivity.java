package com.example.boardgames;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    ArrayList<Game> boardGames = new ArrayList<>();
    ArrayList<Game> currentBoardGames = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ArrayAdapter<Game> gamesAdapter = new ArrayAdapter<>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                currentBoardGames
        );

        AdapterView.OnItemClickListener clickedItem = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String currentFilter = adapterView.getItemAtPosition(i).toString();
                currentBoardGames.clear();
                for (Game game: boardGames) {
                    if(Objects.equals(game.category, currentFilter)) {
                        currentBoardGames.add(game);
                    }
                }
                Toast.makeText(MainActivity.this, currentBoardGames.toString(), Toast.LENGTH_SHORT).show();
                gamesAdapter.notifyDataSetChanged();
            }
        };

        ListView categoriesList = findViewById(R.id.categories);
        categoriesList.setOnItemClickListener(clickedItem);

        AdapterView.OnItemClickListener clickedGame = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                String game = parent.getItemAtPosition(i).toString();
                int gameIndex = boardGames.indexOf(game);
                boardGames.remove(gameIndex);

                gamesAdapter.notifyDataSetChanged();
            }
        };

        ListView allGames = findViewById(R.id.allGames);
        allGames.setAdapter(gamesAdapter);

        allGames.setOnItemClickListener(clickedGame);

        AdapterView.OnItemSelectedListener selectedItem = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String categories = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(MainActivity.this, "Selected categories " + categories, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(MainActivity.this, "You have to select any category", Toast.LENGTH_SHORT).show();
            }
        };

        Spinner categoriesSpinner = findViewById(R.id.category);
        categoriesSpinner.setOnItemSelectedListener(selectedItem);


        boardGames.add(new Game("Catan", 2, 4, 60, "Economic", "Hard"));

//        Spinner category = findViewById(R.id.category);
//        Spinner difficulty = findViewById(R.id.difficulty);

        String selectedCategory = "Logic";
        String selectedDifficulty = "Hard";

        View.OnClickListener addGame = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText gameName = findViewById(R.id.gameName);
                EditText minPlayers = findViewById(R.id.minPlayers);
                EditText maxPlayers = findViewById(R.id.maxPlayers);
                EditText gameLength = findViewById(R.id.gameLength);

                boardGames.add(new Game(gameName.getText().toString(), Integer.parseInt( minPlayers.getText().toString()), Integer.parseInt(maxPlayers.getText().toString()), Integer.parseInt(gameLength.getText().toString()), selectedCategory, selectedDifficulty));

                gameName.setText("");
                minPlayers.setText("");
                maxPlayers.setText("");
                gameLength.setText("");

                gamesAdapter.notifyDataSetChanged();
            }
        };

        Button addBtn = findViewById(R.id.addBtn);
        addBtn.setOnClickListener(addGame);
    }
}