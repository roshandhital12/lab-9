import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class MovieView {

    private TextField movieTextField;
    private Button fetchButton;
    private ListView<Movie> movieListView;

    // Constructor initializes the UI components
    public MovieView() {
        movieTextField = new TextField();
        fetchButton = new Button("Get Movie Info");
        movieListView = new ListView<>();
    }

    public TextField getMovieTextField() {
        return movieTextField;
    }

    public Button getFetchButton() {
        return fetchButton;
    }

    public ListView<Movie> getMovieListView() {
        return movieListView;
    }

    // Method to create the layout
    public VBox createView() {
        VBox vbox = new VBox(movieTextField, fetchButton, movieListView);
        return vbox;
    }
}
