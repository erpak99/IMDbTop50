package movies.imdb.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import movies.imdb.entities.Movie;
import movies.imdb.entities.dtos.OscarNumberAndMovieNameDto;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

	Movie findByMovieName(String movieName);

	List<Movie> findByReleaseDate(int releaseDate);

	List<Movie> findByDirector(String director);

	List<Movie> findByCountry(String country);

	List<Movie> findByAgeLimit(int ageLimit);

	List<Movie> findByOscarWinner(boolean oscarWinner);

	List<Movie> findByReleaseDateGreaterThan(int releaseDate);

	List<Movie> findByReleaseDateLessThan(int releaseDate);

	List<Movie> findByDurationGreaterThan(int duration);

	List<Movie> findByDurationLessThan(int duration);
	
	List<Movie> findByReleaseDateBetween(int releaseDate, int releaseDate2);
	
	List<Movie> findByReleaseDateBetweenAndDirector(int releaseDate, int releaseDate2, String director);

	@Query("Select new movies.imdb.entities.dtos.OscarNumberAndMovieNameDto(m.movieName, m.oscarNumber) From Movie m")
		  List<OscarNumberAndMovieNameDto> getOscarNumberAndMovieNameDto();

	List<Movie> findByImdbRatingOrderByReleaseDateDesc(float imdbRating);
	
	@Query("From Movie m where m.ageLimit<:ageLimit")
	List<Movie> getMoviesByAgeLimitLessThan(int ageLimit);
	
}
