package movies.imdb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import movies.imdb.core.results.DataResult;
import movies.imdb.core.results.SuccessDataResult;
import movies.imdb.entities.Movie;
import movies.imdb.entities.dtos.OscarNumberAndMovieNameDto;
import movies.imdb.repos.MovieRepository;

@Service
public class MovieService {

	private MovieRepository movieRepository;
	
	@Autowired
	public MovieService(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}
																		
	public DataResult<Movie> addMovie(Movie movie) {
		this.movieRepository.save(movie);
		return new SuccessDataResult<Movie>(movie,"Movie is added");
	}

	
	public DataResult<List<Movie>> getAllMovies() {
		return new SuccessDataResult<List<Movie>>(this.movieRepository.findAll(),
				"IMDb Top 50 Movie as rated by regular IMDb voters.");
	}

	public DataResult<Movie> getOneMovie(int movieId) {
		return new SuccessDataResult<Movie>(this.movieRepository.findById(movieId).orElse(null),
				"Movie by specific id");
	}

	public DataResult<Movie> findByMovieName(String movieName) {
		return new SuccessDataResult<Movie>(this.movieRepository.findByMovieName(movieName),
				"Information of the movie whose name is entered");
	}

	public DataResult<List<Movie>> findByReleaseDate(int releaseDate) {
		return new SuccessDataResult<List<Movie>>(this.movieRepository.findByReleaseDate(releaseDate),
				"All movies of the entered year") ;
	}
	
	public DataResult<List<Movie>> findByDirector(String director) {
		return new SuccessDataResult<List<Movie>>(this.movieRepository.findByDirector(director),
				"All movies by director entered");
	}

	public DataResult<List<Movie>> findByCountry(String country) {
		return new SuccessDataResult<List<Movie>>(this.movieRepository.findByCountry(country),
				"All movies by country entered") ;
	}


	public DataResult<List<Movie>> findByAgeLimit(int ageLimit) {
		return new SuccessDataResult<List<Movie>>(this.movieRepository.findByAgeLimit(ageLimit),
				"All movies by age limit entered");
	}

	public DataResult<List<Movie>> findbyOscarWinner(boolean oscarWinner) {
		return new SuccessDataResult<List<Movie>>(this.movieRepository.findByOscarWinner(oscarWinner),
				"All movies listed by whether they won Oscar or not");
	}


	public DataResult<List<Movie>> getAllByDescYear() {
		Sort sort = Sort.by(Sort.Direction.DESC,"releaseDate");
		return new SuccessDataResult<List<Movie>>(this.movieRepository.findAll(sort),
				"All movies by descending year order");
	}

	public DataResult<List<Movie>> getAllByAscAgeLimit() {
		Sort sort = Sort.by(Sort.Direction.ASC, "ageLimit");
		return new SuccessDataResult<List<Movie>>(this.movieRepository.findAll(sort),
				"All movies by ascending age limit order");
	}

	public DataResult<List<Movie>> getAllByDescOscarNumber() {
		Sort sort = Sort.by(Sort.Direction.DESC,"oscarNumber");
		return new SuccessDataResult<List<Movie>>(this.movieRepository.findAll(sort),
				"All movies by descending oscar number order");
	}

	public DataResult<List<Movie>> getAllByAscDuration() {
		Sort sort = Sort.by(Sort.Direction.ASC,"duration");
		return new SuccessDataResult<List<Movie>>(this.movieRepository.findAll(sort),
				"All movies by ascending duration order");
	}

	public DataResult<List<Movie>> getAllByDescDuration() {
		Sort sort = Sort.by(Sort.Direction.DESC,"duration");
		return new SuccessDataResult<List<Movie>>(this.movieRepository.findAll(sort),
				"All movies by descending duration order");
	}

	public DataResult<List<Movie>> findByReleaseDateGreaterThan(int releaseDate) {
		return new SuccessDataResult<List<Movie>>(this.movieRepository.findByReleaseDateGreaterThan(releaseDate),
				"All movies after the year entered");
	}

	public DataResult<List<Movie>> findByReleaseDateLessThan(int releaseDate) {
		return new SuccessDataResult<List<Movie>>(this.movieRepository.findByReleaseDateLessThan(releaseDate),
				"All movies after the year entered");
	}

	public DataResult<List<Movie>> findByDurationGreaterThan(int duration) {
		return new SuccessDataResult<List<Movie>>(this.movieRepository.findByDurationGreaterThan(duration),
				"All movies longer than the duration entered");
	}

	public DataResult<List<Movie>> findByDurationLessThan(int duration) {
		return new SuccessDataResult<List<Movie>>(this.movieRepository.findByDurationLessThan(duration),
				"All movies shorter than the duration entered");
	}
	
	public DataResult<List<Movie>> findByReleaseDateBetween(int releaseDate, int releaseDate2) {
		return new SuccessDataResult<List<Movie>>(this.movieRepository.findByReleaseDateBetween(releaseDate,releaseDate2),
				"All movies between the years entered");
	}

	public DataResult<List<Movie>> findByReleaseDateBetweenAndDirector(int releaseDate,
																	   int releaseDate2,
																	   String director) {
		return new SuccessDataResult<List<Movie>>(this.movieRepository.findByReleaseDateBetweenAndDirector
				(releaseDate,releaseDate2,director),
				"All movies between the years entered and by director ");
	}

	public DataResult<List<OscarNumberAndMovieNameDto>> getOscarNumberAndMovieNameDto() {
		return new SuccessDataResult<List<OscarNumberAndMovieNameDto>>(this.movieRepository.getOscarNumberAndMovieNameDto(),
				"All movies by movie name and oscar number");
	}

	public DataResult<List<Movie>> findByImdbRatingOrderByReleaseDateDesc(float imdbRating) {
		return new SuccessDataResult<List<Movie>>(this.movieRepository.findByImdbRatingOrderByReleaseDateDesc(imdbRating),
				"All movies by entered imdb rating in descending order for release date");
	}

	
	public DataResult<List<Movie>> getMoviesByAgeLimitLessThan(int ageLimit) {
		return new SuccessDataResult<List<Movie>>(this.movieRepository.getMoviesByAgeLimitLessThan(ageLimit),
				"All movies which are suitable for children");
	}																										

	
	
}

