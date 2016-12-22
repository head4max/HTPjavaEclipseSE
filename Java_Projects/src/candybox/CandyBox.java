package candybox;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ArrayList;

import candybox.logger.Log4CandyBox;
import candybox.sweet.Sweetness;

/**
 * represent collection of an abstract object of {@link Sweetness} type
 * @author head4max
 */
public class CandyBox implements Serializable {
	/** id for serializing	 */
	private static final long serialVersionUID = 49371L;
	
	/** collection-store of the objects extends {@link Sweetness} type */
	private ArrayList<Sweetness> listOfSweetnesses;
	
	/**
	 * default constructor
	 */
	public CandyBox(){
		listOfSweetnesses = new ArrayList<Sweetness>();
	}
	
	/**
	 * added sweetness to collection {@link #listOfSweetnesses}
	 * @param sweetness - object extends {@link Sweetness} type
	 */
	public<T extends Sweetness> void addSweetness(T sweetness){
		listOfSweetnesses.add(sweetness);
	}
	
	/**
	 * output {@link #listOfSweetnesses} in console
	 */
	public void outCandyBox(){
		
		Iterator<Sweetness> listItertor = listOfSweetnesses.iterator();
		
		while(listItertor.hasNext()){
			System.out.println(listItertor.next());
		}

		System.out.println("");
	}
	
	/**
	 * sorting elements {@link #listOfSweetnesses} by weight
	 */
	public void sortByWeight(){
		Collections.sort(listOfSweetnesses, new CandyBox.SortByWeight());
		this.outCandyBox();
		Log4CandyBox.getInstance(this.getClass().getName(), "sort by weight");
	}
	
	/**
	 * sorting elements {@link #listOfSweetnesses} by name
	 */
	public void sortByName(){
		Collections.sort(listOfSweetnesses, new CandyBox.SortByName());
		this.outCandyBox();
		Log4CandyBox.getInstance(this.getClass().getName(), "sort by name");
	}
	
	/**
	 * 
	 * @return sum of {@link #listOfSweetnesses} element's weight
	 */
	public int getWeightCandyBox(){
		
		Iterator<Sweetness> cbxIterator = listOfSweetnesses.iterator();
		int summWeight = 0;
		
		while(cbxIterator.hasNext()){
			summWeight += cbxIterator.next().getWeight();
		}
		
		return  summWeight;
	}
	
	/**
	 * @return count of {@link #listOfSweetnesses} elements
	 */
	public int length(){
		return this.listOfSweetnesses.size();
	}
	

	/**
	 * nested class for sorting by name
	 * @author head4max
	 */
	public static class SortByName implements Comparator<Sweetness> {

		@Override
		public int compare(Sweetness arg0, Sweetness arg1) {
			return arg0.getName().compareTo(arg1.getName());
		}
		
	}
	
	/**
	 * nested class for sorting by weight
	 * @author head4max
	 */
	public static class SortByWeight implements Comparator<Sweetness> {

		@Override
		public int compare(Sweetness w1, Sweetness w2) {
			return w1.getWeight()>w2.getWeight()?1:(w1.getWeight()<w2.getWeight()?-1:0);
		}
		
	}
	
	/**
	 * nested class for sorting by sugar
	 * @author head4max
	 */
	public static class SortBySugar implements Comparator<Sweetness> {

		@Override
		public int compare(Sweetness sug1, Sweetness sug2) {
			return sug1.getSugar() > sug2.getSugar() ? 1 : (sug1.getSugar()<sug2.getSugar() ? -1 : 0);
		}
		
	}
	
	/**
	 * access to {@link #listOfSweetnesses}
	 * @return {@link #listOfSweetnesses}
	 */
	public ArrayList<Sweetness> getListSweetnesses(){
		return this.listOfSweetnesses;
	}
}
