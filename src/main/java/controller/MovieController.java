import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MovieController {

    private MovieView view;
    private MovieModel model;

    // Constructor connects the view with the model and sets the button action
    public MovieController(MovieView view, MovieModel model) {
        this.view = view;
        this.model = model;
        this.view.getFetchButton().setOnAction(e -> fetchMovieData());
    }

    // Method to handle button click and fetch data
    private void fetchMovieData() {
        String movieName = view.getMovieTextField().getText();  // Get movie name from the TextField
        List<Movie> movies = model.fetchMovies(movieName);  // Fetch movies using the model

        // Create an observable list and display it in the ListView
        ObservableList<Movie> observableMovies = FXCollections.observableArrayList(movies);
        view.getMovieListView().setItems(observableMovies);
    }
}
