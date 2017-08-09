package src;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import com.talhahasanzia.threelevellistview.R;

import java.util.ArrayList;

import java.util.LinkedHashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ExpandableListView expandableListView;

    String[] categoriesList = new String[]{"MOVIES", "GAMES"}; // comment this when uncomment bottom

    String[] moviesSubCategory = new String[]{"Horror", "Action", "Thriller/Drama"};
    String[] gamesSubCategory = new String[]{"Fps", "Moba", "Rpg", "Racing"};

    String[] horrorSubSubCategory = new String[]{"Conjuring", "Insidious", "The Ring"};
    String[] actionSubSubCategory = new String[]{"Jon Wick", "Die Hard", "Fast 7", "Avengers"};
    String[] thrillerSubSubCategory = new String[]{"Imitation Game", "Tinker, Tailer, Soldier, Spy", "Inception", "Manchester by the Sea"};

    String[] fpsSubSubCategory = new String[]{"CS: GO", "Team Fortress 2", "Overwatch", "Battlefield 1", "Halo II", "Warframe"};
    String[] mobaSubSubCategory = new String[]{"Dota 2", "League of Legends", "Smite", "Strife", "Heroes of the Storm"};
    String[] rpgSubSubCategory = new String[]{"Witcher III", "Skyrim", "Warcraft", "Mass Effect II", "Diablo", "Dark Souls", "Last of Us"};
    String[] racingSubSubCategory = new String[]{"NFS: Most Wanted", "Forza Motorsport 3", "EA: F1 2016", "Project Cars"};

    LinkedHashMap<String, String[]> thirdLevelMovies = new LinkedHashMap<>();
    LinkedHashMap<String, String[]> thirdLevelGames = new LinkedHashMap<>();

    List<String[]> secondLevel = new ArrayList<>();

    List<LinkedHashMap<String, String[]>> data = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpData();

        expandableListView = (ExpandableListView) findViewById(R.id.expandible_listview);

        ThreeLevelListAdapter threeLevelListAdapterAdapter = new ThreeLevelListAdapter(this, categoriesList, secondLevel, data);

        expandableListView.setAdapter( threeLevelListAdapterAdapter );
    }

    private void setUpData() {
        secondLevel.add(moviesSubCategory);
        secondLevel.add(gamesSubCategory);

        thirdLevelMovies.put(moviesSubCategory[0], horrorSubSubCategory);
        thirdLevelMovies.put(moviesSubCategory[1], actionSubSubCategory);
        thirdLevelMovies.put(moviesSubCategory[2], thrillerSubSubCategory);


        thirdLevelGames.put(gamesSubCategory[0], fpsSubSubCategory);
        thirdLevelGames.put(gamesSubCategory[1], mobaSubSubCategory);
        thirdLevelGames.put(gamesSubCategory[2], rpgSubSubCategory);
        thirdLevelGames.put(gamesSubCategory[3], racingSubSubCategory);

        data.add(thirdLevelMovies);
        data.add(thirdLevelGames);
        data.add(thirdLevelMovies);
    }
}
