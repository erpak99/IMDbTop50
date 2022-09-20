package movies.imdb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import movies.imdb.core.results.DataResult;
import movies.imdb.entities.Movie;
import movies.imdb.services.MovieService;
import movies.imdb.entities.dtos.OscarNumberAndMovieNameDto;

@RestController
@RequestMapping("/movies")
public class MoviesController {

	private MovieService movieService;
	
	@Autowired
	public MoviesController(MovieService movieService) {
		this.movieService = movieService;
	}
	
	@PostMapping("/add")
	public DataResult<Movie> addMovie(@RequestBody Movie movie) {
		return this.movieService.addMovie(movie);
	}
	
	@GetMapping("/getall")
	public DataResult<List<Movie>> getAllMovies() {
		return this.movieService.getAllMovies();
	}
	
	@GetMapping("/{movieId}")
	public DataResult<Movie> getOneMovie(@PathVariable int movieId) {
		return this.movieService.getOneMovie(movieId);
	}
	
	@GetMapping("/getmoviebyname")
	public DataResult<Movie> findByMovieName(@RequestParam String movieName) {
		return this.movieService.findByMovieName(movieName);
	}
	
	@GetMapping("/getmoviesbyyear")
	public DataResult<List<Movie>> findByReleaseDate(@RequestParam int releaseDate) {
		return this.movieService.findByReleaseDate(releaseDate);
	}
	
	@GetMapping("/getmoviesbydirector")
	public DataResult<List<Movie>> findByDirector(@RequestParam String director) {
		return this.movieService.findByDirector(director);
	}
	
	@GetMapping("/getmoviesbycountry")
	public DataResult<List<Movie>> findByCountry(@RequestParam String country) {
		return this.movieService.findByCountry(country);
	}
	
	@GetMapping("/getmoviesbyagelimit")
	public DataResult<List<Movie>> findByAgeLimit(@RequestParam int ageLimit) {
		return this.movieService.findByAgeLimit(ageLimit);
	}
	
	@GetMapping("/getmoviesbyoscar")					
	public DataResult<List<Movie>> findByOscarWinner(@RequestParam boolean oscarWinner) {
		return this.movieService.findbyOscarWinner(oscarWinner);
	}
	
	
	@GetMapping("/getallbydescyear")
	public DataResult<List<Movie>> getAllByDescYear() {
		return this.movieService.getAllByDescYear();
	}
	
	@GetMapping("/getallbyascagelimit")
	public DataResult<List<Movie>> getAllByAscAgeLimit() {
		return this.movieService.getAllByAscAgeLimit();
	}		
	
	@GetMapping("/getallbydescoscarnumber")
	public DataResult<List<Movie>> getAllByDescOscarNumber() {
		return this.movieService.getAllByDescOscarNumber();
	}
	
	@GetMapping("/getallbyascduration")
	public DataResult<List<Movie>> getAllByAscDuration() {
		return this.movieService.getAllByAscDuration();
	}
	
	@GetMapping("/getallbydescduration")
	public DataResult<List<Movie>> getAllByDescDuration() {
		return this.movieService.getAllByDescDuration();
	}	
	
	@GetMapping("/getmoviesafterayear")
	public DataResult<List<Movie>> findByReleaseDateGreaterThan(@RequestParam int releaseDate) {
		return this.movieService.findByReleaseDateGreaterThan(releaseDate);
	}
	
	@GetMapping("/getmoviesbeforeayear")
	public DataResult<List<Movie>> findByReleaseDateLessThan(@RequestParam int releaseDate) {
		return this.movieService.findByReleaseDateLessThan(releaseDate);	
	}
	
	@GetMapping("/getmovieslongerthanduration")
	public DataResult<List<Movie>> findByDurationGreaterThan(@RequestParam int duration) {
		return this.movieService.findByDurationGreaterThan(duration);													
	}
	
	@GetMapping("/getmoviesshorterthanduration")
	public DataResult<List<Movie>> findByDurationLessThan(@RequestParam int duration) {
		return this.movieService.findByDurationLessThan(duration);
	}
	
	@GetMapping("/getmoviesbetweenyears")
	public DataResult<List<Movie>> findByReleaseDateBetween(@RequestParam int releaseDate,
															@RequestParam int releaseDate2) {
		return this.movieService.findByReleaseDateBetween(releaseDate,releaseDate2);
	}
	
	@GetMapping("/getmoviesbetweenyearsandbydirector")
	public DataResult<List<Movie>> findByReleaseDateBetweenAndDirector(@RequestParam int releaseDate,
																	   @RequestParam int releaseDate2,
															           @RequestParam String director) {
		return this.movieService.findByReleaseDateBetweenAndDirector(releaseDate,releaseDate2,director);
}
	
	@GetMapping("/getmoviesbynameandoscarnumber")
	public DataResult<List<OscarNumberAndMovieNameDto>> getOscarNumberAndMovieNameDto() {
		return this.movieService.getOscarNumberAndMovieNameDto();
	}
	
	@GetMapping("/getmoviesbyratingindescyear") 
	public DataResult<List<Movie>> findByImdbRatingOrderByReleaseDateDesc(@RequestParam float imdbRating) {
		return this.movieService.findByImdbRatingOrderByReleaseDateDesc(imdbRating);
	}
	
	@GetMapping("/getmoviesbyagelimitlessthan")
	public DataResult<List<Movie>> getMoviesByAgeLimitLessThan(@RequestParam int ageLimit) {
		return this.movieService.getMoviesByAgeLimitLessThan(ageLimit);
	}
	
}