/**
 * Created by nickwhite on 4/5/17.
 */

class Rental {
    private Movie movie;
	private int _daysRented;
	//private int frequentRenterPoints;
    public Rental(Movie movie, DataRange range) {
        this.movie = movie;
        _daysRented = (int)((range.getEnd().getTime() - range.getStart().getTime()) / (1000 * 60 * 60 * 24));
    }
    public int getDaysRented() {
        return _daysRented;
    }

    public String getTitle() {
        return movie.getTitle();
    }

    public int getPriceCode() {
        return movie.getPriceCode();
    }
    
	double getCharge() {
		return movie.getCharge(_daysRented);
	}
	int getFrequentRenterPoints() {
		return movie.getFrequentRenterPoints();
	}
}
