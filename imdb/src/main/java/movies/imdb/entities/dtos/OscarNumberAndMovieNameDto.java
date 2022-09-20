package movies.imdb.entities.dtos;

public class OscarNumberAndMovieNameDto {

	private String movieName;
	
	private int oscarNumber;


	public OscarNumberAndMovieNameDto() {
		super();
	}

	public OscarNumberAndMovieNameDto(String movieName, int oscarNumber) {
		super();
		this.movieName = movieName;
		this.oscarNumber = oscarNumber;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public int getOscarNumber() {
		return oscarNumber;
	}

	public void setOscarNumber(int oscarNumber) {
		this.oscarNumber = oscarNumber;
	}
	
}
