package company.danhy.clothesuit;

import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar ;
    ViewFlipper viewFlipper;
    RecyclerView recyclerViewHotItems,recyclerViewNewItems;
    NavigationView navigationView;
    ListView listViewManHinhChinh;
    ImageView imageViewHotItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();



    }
    void anhXa(){
        toolbar = findViewById(R.id.toolbar);
        viewFlipper = findViewById(R.id.viewFlipper);
        recyclerViewHotItems = findViewById(R.id.recyclerViewHotItems);
        recyclerViewNewItems = findViewById(R.id.recyclerViewNewItems);
        navigationView = findViewById(R.id.navigationView);
        listViewManHinhChinh = findViewById(R.id.listViewManHinhChinh);
        imageViewHotItems = findViewById(R.id.imageViewHotItems);
    }
}
