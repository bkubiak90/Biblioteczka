package bk90.mylibrary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import java.util.ArrayList;

public class AllBooksActivity extends AppCompatActivity {

    private RecyclerView booksRecyclerView;
    private BookRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_books);

        //overridePendingTransition(R.anim.slide_in, R.anim.slide_out);  //dodanie utworzonej animacji do przejscia z Main do AllBooks
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        adapter = new BookRecyclerViewAdapter(this, "allBooks");
        booksRecyclerView = findViewById(R.id.booksRecyclerView);


        booksRecyclerView.setAdapter(adapter);
        booksRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        adapter.setBooks(Utils.getInstance(this).getAllBooks());
    }

    /**
     * dodanie strzałki powrotnej z AllBooks do Main na górnym panelu
     * >> getSupportActionBar w onCreate + override onOptionsItemSe.....
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch ( (item.getItemId())) {
            case android.R.id.home:
                onBackPressed();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}