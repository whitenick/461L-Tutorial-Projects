
public abstract class Price {

	public Price() {
		super();
	}

	public abstract int getPriceCode();

	protected abstract double getCharge(int daysRented);
	
	protected abstract int getFrequentRenterPoints();

}

class ChildrensPrice extends Price{

    public int getPriceCode() {

        return Movie.CHILDRENS;

    }

	@Override
	protected double getCharge(int daysRented) {
	
	    //determine amounts for each line
	
	    double result = 0;

	        result += 1.5;
	
	        if (daysRented > 3) {
	
	            result += (daysRented - 3) * 1.5;
	
	        }
	    
	
	    return result;
	
	}

	public int getFrequentRenterPoints() {
		return 1;
	}

}

class NewReleasePrice extends Price {
	
	int _daysRented;
    public int getPriceCode() {

        return Movie.NEW_RELEASE;

    }

	@Override
	protected double getCharge(int daysRented) {
		
		_daysRented = daysRented;
	    //determine amounts for each line
	
	    double result = 0;
	
	        result += daysRented * 3;
	
	    return result;
	
	}

	public int getFrequentRenterPoints() {
		int frequentRenterPoints = 0;
		frequentRenterPoints ++;
		// add bonus for a two day new release rental
		if (_daysRented > 1) {
			frequentRenterPoints++;
		}
		return frequentRenterPoints;
	}

}

class RegularPrice extends Price {

	
    public int getPriceCode() {

        return Movie.REGULAR;

    }

	@Override
	protected double getCharge(int daysRented) {
		
		
	    //determine amounts for each line
	
	    double result = 0;
	
	        result += 2;
	
	        if (daysRented > 2) {
	
	            result += (daysRented - 2) * 1.5;
	
	        }
	
	    return result;
	
	}

	public int getFrequentRenterPoints() {
		
		return 1;
		
	}

}