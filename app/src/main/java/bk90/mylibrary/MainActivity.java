package bk90.mylibrary;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnSeeAllBooks, btnCurrentlyReadingBooks, btnAlreadyReadBooks, btnYourWishlist, btnFavoriteBooks, btnAbout;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        btnSeeAllBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AllBooksActivity.class);
                startActivity(intent);
            }
        });

        btnAlreadyReadBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AlreadyReadBookActivity.class);
                startActivity(intent);
            }
        });

        btnYourWishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, WantToReadActivity.class);
                startActivity(intent);
            }
        });

        btnCurrentlyReadingBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CurrentlyReadingActivity.class);
                startActivity(intent);
            }
        });

        btnFavoriteBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FavoriteBooksActivity.class);
                startActivity(intent);
            }
        });

        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle(getString(R.string.app_name));
                builder.setMessage("Stworzone przez B.Kubiak, kontynuuj aby wyszukać więcej książek do przeczytania");
                builder.setNegativeButton("Zamknij", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.setPositiveButton("Kontynuuj", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(MainActivity.this, WebsiteActivity.class);
                        intent.putExtra("url", "https://google.com/");
                        startActivity(intent);
                    }
                });
                builder.create().show();
            }
        });

        Utils.getInstance(this);
    }

    private void initViews() {

        btnSeeAllBooks = findViewById(R.id.btnAllBooks);
        btnCurrentlyReadingBooks = findViewById(R.id.btnCurrentlyReading);
        btnAlreadyReadBooks = findViewById(R.id.btnAlreadyRead);
        btnFavoriteBooks = findViewById(R.id.btnFavorite);
        btnYourWishlist = findViewById(R.id.btnWantToRead);
        btnAbout = findViewById(R.id.btnAbout);

        image = findViewById(R.id.imageView);

    }
}