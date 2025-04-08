import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MovieModel {
    private static final String API_KEY = "q85ugJpYvN6fcid8SBH5UbVFXoaNgMiYoiUZtlDP";  // Replace with your actual API key

    // Method to fetch movie data based on user input
    public List<Movie> fetchMovies(String movieName) {
        List<Movie> movies = new ArrayList<>();
        try {
            // Set the API endpoint with the query parameter
            String url = "https://www.omdbapi.com/?s=" + movieName + "&apikey=" + API_KEY;
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");

            // Read the response from the API
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Parse the JSON response
            Gson gson = new Gson();
            JsonObject jsonResponse = gson.fromJson(response.toString(), JsonObject.class);
            var movieArray = jsonResponse.getAsJsonArray("Search");

            // Convert the JSON objects into Movie objects
            for (var movieJson : movieArray) {
                Movie movie = gson.fromJson(movieJson, Movie.class);
                movies.add(movie);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return movies;
    }
}
