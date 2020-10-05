package bk90.mylibrary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {

    public static final String BOOK_ID_KEY = "bookId";

    private Button btnAddCurrentlyReading, btnAddWantToRead, btnAddAlreadyRead, btnAddToFavorite;
    private TextView txtBookName, txtBookAuthor, txtPages, txtDescription;
    private ImageView imgBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initView();
/*
        Book book = new Book(1, "Zielona mila", "Sephen King", 897, "https://image.ceneostatic.pl/data/products/3459431/i-the-green-mile-the-complete-serial-novel.jpg", "Powiesc o wiezniu, autorstwa Stephena Kinga",
                "Zielona mila – powieść w odcinkach autorstwa Stephena Kinga z 1996 roku, wcześniej wydana w 6 osobnych tomach. Pierwsze polskie wydanie pochodzi z roku 1996. Na podstawie książki powstał film w reżyserii Franka Darabonta, z Tomem Hanksem w roli Paula Edgecomba i Michaelem Clarkiem Duncanem w roli Johna Coffeya. Zielona mila – powieść w odcinkach autorstwa Stephena Kinga z 1996 roku, wcześniej wydana w 6 osobnych tomach. Pierwsze polskie wydanie pochodzi z roku 1996. Na podstawie książki powstał film w reżyserii Franka Darabonta, z Tomem Hanksem w roli Paula Edgecomba i Michaelem Clarkiem Duncanem w roli Johna Coffeya. Zielona mila – powieść w odcinkach autorstwa Stephena Kinga z 1996 roku, wcześniej wydana w 6 osobnych tomach. Pierwsze polskie wydanie pochodzi z roku 1996. Na podstawie książki powstał film w reżyserii Franka Darabonta, z Tomem Hanksem w roli Paula Edgecomba i Michaelem Clarkiem Duncanem w roli Johna Coffeya.");
*/

        Intent intent = getIntent();
        if (null != intent) {
            int bookId = intent.getIntExtra(BOOK_ID_KEY, -1);
            if (bookId != -1) {
                Book incomingBook = Utils.getInstance(this).getBookById(bookId);
                if (null != incomingBook) {
                    setData(incomingBook);

                    handleAlreadyRead(incomingBook);
                    handleWantToReadBook(incomingBook);
                    handleCurrentlyReadingBooks(incomingBook);
                    handleFavoriteBooks(incomingBook);
                }
            }
        }
    }

    private void handleFavoriteBooks(final Book book) {
        ArrayList<Book> favoriteBooks = Utils.getInstance(this).getFavoriteBooks();

        boolean existInFavoriteBooks = false;

        for (Book b : favoriteBooks) {
            if (b.getId() == book.getId()) {
                existInFavoriteBooks = true;
            }
        }

        if (existInFavoriteBooks) {
            btnAddToFavorite.setEnabled(false);
        } else {
            btnAddToFavorite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (Utils.getInstance(BookActivity.this).addToFavorite(book)) {
                        Toast.makeText(BookActivity.this, "Book Added", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(BookActivity.this, FavoriteBooksActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(BookActivity.this, "Not Added, Try Again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void handleCurrentlyReadingBooks(final Book book) {
        ArrayList<Book> currentlyReadingBooks = Utils.getInstance(this).getCurrentlyReadBooks();

        boolean existInCurrentlyReadingBooks = false;

        for (Book b : currentlyReadingBooks) {
            if (b.getId() == book.getId()) {
                existInCurrentlyReadingBooks = true;
            }
        }

        if (existInCurrentlyReadingBooks) {
            btnAddCurrentlyReading.setEnabled(false);
        } else {
            btnAddCurrentlyReading.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (Utils.getInstance(BookActivity.this).addToCurrentlyReading(book)) {
                        Toast.makeText(BookActivity.this, "Book Added", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(BookActivity.this, CurrentlyReadingActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(BookActivity.this, "Not Added, Try Again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void handleWantToReadBook(final Book book) {
        ArrayList<Book> wantToReadBooks = Utils.getInstance(this).getWantToReadBooks();

        boolean existInWantToReadBooks = false;

        for (Book b : wantToReadBooks) {
            if (b.getId() == book.getId()) {
                existInWantToReadBooks = true;
            }
        }

        if (existInWantToReadBooks) {
            btnAddWantToRead.setEnabled(false);
        } else {
            btnAddWantToRead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (Utils.getInstance(BookActivity.this).addToWishlist(book)) {
                        Toast.makeText(BookActivity.this, "Book Added", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(BookActivity.this, WantToReadActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(BookActivity.this, "Not Added, Try Again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }



    /**
     * Enable and Disable alreadyRead button,
     * Add the book to alredy read book array list
     * @param book
     */
    private void handleAlreadyRead(final Book book) {
        ArrayList<Book> alreadyReadBooks = Utils.getInstance(this).getAlreadyReadBooks();

        boolean existInAlreadyReadBooks = false;

        for (Book b : alreadyReadBooks) {
            if (b.getId() == book.getId()) {
                existInAlreadyReadBooks = true;
            }
        }

        if (existInAlreadyReadBooks) {
            btnAddAlreadyRead.setEnabled(false);
        } else {
            btnAddAlreadyRead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (Utils.getInstance(BookActivity.this).addToAlreadyRead(book)) {
                        Toast.makeText(BookActivity.this, "Book Added", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(BookActivity.this, AlreadyReadBookActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(BookActivity.this, "Not Added, Try Again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }

    private void setData(Book book) {
        txtBookName.setText(book.getName());
        txtBookAuthor.setText(book.getAuthor());
        txtPages.setText(String.valueOf(book.getPages()));
        txtDescription.setText(book.getLongGescription());
        Glide.with(this)
                .asBitmap().load(book.getImageUrl())
                .into(imgBook);


    }
    private void initView() {

        btnAddCurrentlyReading = findViewById(R.id.btnAddToCurrentlyReading);
        btnAddAlreadyRead = findViewById(R.id.btnAddAlreadyRead);
        btnAddWantToRead = findViewById(R.id.btnAddWantToRead);
        btnAddToFavorite = findViewById(R.id.btnAddToFavorites);

        txtBookName = findViewById(R.id.txtBookNameValue);
        txtBookAuthor = findViewById(R.id.txtAuthorNameValue);
        txtPages = findViewById(R.id.txtPagesValue);
        txtDescription = findViewById(R.id.txtLongDescription);

        imgBook = findViewById(R.id.imgBook);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}