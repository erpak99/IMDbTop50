package movies.imdb.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movies")
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "movie_id")
	private int movieId;
	
	@Column(name = "movie_name")
	private String movieName;
	
	@Column(name = "release_date")
	private int releaseDate;
	
	@Column(name = "duration")
	private int duration;
	
	@Column(name = "imdb_rating")
	private float imdbRating;
	
	@Column(name = "director")
	private String director;
	
	@Column(name = "country")
	private String country;

	@Column(name = "age_limit")
	private int ageLimit;
	
	@Column(name = "oscar_winner")
	private boolean oscarWinner;
							
	@Column(name = "oscar_number")
	private int oscarNumber;
	
	public Movie() {
		
	}

	public Movie(int movieId, String movieName, int releaseDate, int duration, float imdbRating,
			String director, String country, int ageLimit, boolean oscarWinner, int oscarNumber) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.releaseDate = releaseDate;
		this.duration = duration;
		this.imdbRating = imdbRating;
		this.director = director;
		this.country = country;
		this.ageLimit = ageLimit;
		this.oscarWinner = oscarWinner;
		this.oscarNumber = oscarNumber;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public int getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(int releaseDate) {
		this.releaseDate = releaseDate;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public float getImdbRating() {
		return imdbRating;
	}

	public void setImdbRating(float imdbRating) {
		this.imdbRating = imdbRating;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getAgeLimit() {
		return ageLimit;
	}

	public void setAgeLimit(int ageLimit) {
		this.ageLimit = ageLimit;
	}

	public boolean isOscarWinner() {
		return oscarWinner;
	}

	public void setOscarWinner(boolean oscarWinner) {
		this.oscarWinner = oscarWinner;
	}

	public int getOscarNumber() {
		return oscarNumber;
	}

	public void setOscarNumber(int oscarNumber) {
		this.oscarNumber = oscarNumber;
	}
	
}
