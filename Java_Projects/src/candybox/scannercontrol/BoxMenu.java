package candybox.scannercontrol;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;
import candybox.CandyBox;
import candybox.SweetnessFactory;
import candybox.SweetnessFactory.Sweet;
import candybox.logger.Log4CandyBox;
import candybox.sweet.Sweetness;


/**
 * console-interface class to control user's action
 * @author head4max
 *
 */
public class BoxMenu implements Savable, Loadable, Localable {

	private ArrayList<Integer> alInitialMenuNumbers;

	private boolean canSave = false;
	private boolean canLoad = true;
	
	private CandyBox boxOfSweetnesses;
	
	/**
	 * collection of {@link Sweetness} object
	 */
	private ResourceBundle boxMenuBundle;
	
	private Scanner sc;
	
	public BoxMenu(){
		this.sc = new Scanner(System.in);
		
		this.setLocale();
	}
	
	protected void finalize() throws Throwable{
		sc.close();
	}
	
	public void getBoxMenu() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException{
		
		boxOfSweetnesses = new CandyBox();
		
		while(true){
			
			alInitialMenuNumbers = new ArrayList<Integer>();
			
			alInitialMenuNumbers.add(1);
			System.out.println(MessageFormat.format(boxMenuBundle.getString("changeLocale"), alInitialMenuNumbers.size()));
			
			alInitialMenuNumbers.add(2);
			System.out.println(MessageFormat.format(boxMenuBundle.getString("datetime"), alInitialMenuNumbers.size()));
			
			if(boxOfSweetnesses.length() < 1 && canLoad){
				alInitialMenuNumbers.add(3);
				System.out.println(MessageFormat.format(boxMenuBundle.getString("SweetnessAddMenu"), alInitialMenuNumbers.size()));
			}
			
			if(boxOfSweetnesses.length() > 1){
				alInitialMenuNumbers.add(4);
				System.out.println(MessageFormat.format(boxMenuBundle.getString("sortByName"), alInitialMenuNumbers.size()));
				alInitialMenuNumbers.add(5);
				System.out.println(MessageFormat.format(boxMenuBundle.getString("sortByWeight"), alInitialMenuNumbers.size()));
			}
			
			if(boxOfSweetnesses.length() > 0){
				alInitialMenuNumbers.add(6);
				System.out.println(MessageFormat.format(boxMenuBundle.getString("weightCandyBox"), alInitialMenuNumbers.size()));
				alInitialMenuNumbers.add(7);
				System.out.println(MessageFormat.format(boxMenuBundle.getString("sugarBounds"), alInitialMenuNumbers.size()));
			}
			
			if(canSave){
				alInitialMenuNumbers.add(8);
				System.out.println(MessageFormat.format(boxMenuBundle.getString("save"), alInitialMenuNumbers.size()));
			}
			
			File file = new File("cndbx.dat");
			if(file.exists() && canLoad){
				alInitialMenuNumbers.add(9);
				System.out.println(MessageFormat.format(boxMenuBundle.getString("load"), alInitialMenuNumbers.size()));
			}
			
			System.out.println(boxMenuBundle.getString("quit"));
			
			int consoleNumb = 0;
			
			while(true){
				if(sc.hasNext("[" + "q" + "]")){
					System.out.println(boxMenuBundle.getString("exit"));
					return;
				} else if(sc.hasNextInt()){
					consoleNumb = sc.nextInt();
					if(consoleNumb > 0 && consoleNumb <= alInitialMenuNumbers.size()){
						break;
					} else {
						sc.next();
						System.out.println(boxMenuBundle.getString("continue"));
					}
				}
			}
			
			switch(alInitialMenuNumbers.get(consoleNumb-1)){
			case 1:
				this.setLocale();
				break;
			case 2:
				System.out.println("");
				System.out.println(this.getTimeDate());
				System.out.println("");
				break;
			case 3:
				this.getSweetnessAddMenu();
				break;
			case 4:
				this.boxOfSweetnesses.sortByName();;
				break;
			case 5:
				this.boxOfSweetnesses.sortByWeight();;
				break;
			case 6:
				this.getWeightCandyBox();;
				break;
			case 7:
				this.getSugarBounds();
				break;
			case 8:
				this.save();;
				break;
			case 9:
				this.load();
				break;
			default:
				break;
			}
			
		}
	}
	
	/**
	 * out summed weight of {@link #boxOfSweetnesses} elements
	 */
	public void getWeightCandyBox(){
		
		System.out.println(boxMenuBundle.getString("weightbox") + this.boxOfSweetnesses.getWeightCandyBox());
		System.out.println();
		Log4CandyBox.getInstance(this.getClass().getName(), "get weight of candy box");
	}
	
	/**
	 * out all {@link #boxOfSweetnesses} elements with sugar in a current bounds
	 */
	public void getSugarBounds(){
		System.out.println(boxMenuBundle.getString("lowerbound"));
		
		while(!sc.hasNextInt()){
			sc.next();
		}
		
		System.out.println(boxMenuBundle.getString("upperbound"));
		int downBound = sc.nextInt();
		
		while(!sc.hasNextInt()){
			sc.next();
		}
		int upperBound = sc.nextInt();
			
		boolean hasNoOneOutElement = true;
		Iterator<Sweetness> cbxIterator = this.boxOfSweetnesses.getListSweetnesses().iterator();
			
		while(cbxIterator.hasNext()){
			Sweetness tempswtn = cbxIterator.next();
			if(tempswtn.getSugar() >= downBound && tempswtn.getSugar() <= upperBound){
					System.out.println(tempswtn);
					hasNoOneOutElement = false;
			}
		}
			
		if(hasNoOneOutElement){
			System.out.println(boxMenuBundle.getString("noonesweetness"));
		}
			
		System.out.println();
	}
	
	/**
	 * add {@link Sweetness} object to {@link #boxOfSweetnesses}
	 */
	public void getSweetnessAddMenu(){
		
		this.boxOfSweetnesses.addSweetness(SweetnessFactory.getSweetness(Sweet.BONBON));
		this.boxOfSweetnesses.addSweetness(SweetnessFactory.getSweetness(Sweet.CHOCOLATE));
		this.boxOfSweetnesses.addSweetness(SweetnessFactory.getSweetness(Sweet.CHOCOLATEBAR));
		this.boxOfSweetnesses.addSweetness(SweetnessFactory.getSweetness(Sweet.CHOCOLATEBUTTER));
		this.boxOfSweetnesses.addSweetness(SweetnessFactory.getSweetness(Sweet.CRISPCANDY));
		this.boxOfSweetnesses.addSweetness(SweetnessFactory.getSweetness(Sweet.LAYEREDCAKE));
		this.boxOfSweetnesses.addSweetness(SweetnessFactory.getSweetness(Sweet.MIXCAKE));

		this.canSave = true;
		this.canLoad = false;
		this.boxOfSweetnesses.outCandyBox();
	}
	
	/**
	 * @override
	 * @see scannercontrol.Savable#save()
	 */
	public void save(){
		FileOutputStream fos;
		ObjectOutputStream oos;

		try {
			fos = new FileOutputStream("cndbx.dat");
			oos = new ObjectOutputStream(fos);
			oos.writeObject((Object)boxOfSweetnesses);
			oos.flush();
			oos.close();
			fos.close();
			Log4CandyBox.getInstance(this.getClass().getName(), "successfully save");
			
		} catch (IOException e) {
			Log4CandyBox.getInstance(this.getClass().getName(), "unsuccessfully save");
		}
		
		System.out.println("");
		
		this.canSave = false;
		this.canLoad = false;
	}
	
	/**
	 * @override
	 * @see scannercontrol.Loadable#load()
	 */
	public void load(){
		
		FileInputStream fis;
		ObjectInputStream oin;
		
		try {
			fis = new FileInputStream("cndbx.dat");
			oin = new ObjectInputStream(fis);

			this.boxOfSweetnesses = (CandyBox) oin.readObject();
			
			oin.close();
			fis.close();
			Log4CandyBox.getInstance(this.getClass().getName(), "successfully load");
			
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
			Log4CandyBox.getInstance(this.getClass().getName(), "unsuccessfully load");
		} catch (ClassNotFoundException e) {
		}
		
		this.canLoad = false;
		this.canSave = false;
		this.boxOfSweetnesses.outCandyBox();
	}
	
	
	
	@Override
	public void setLocale(){
		if(this.boxMenuBundle == null){
			this.boxMenuBundle = ResourceBundle.getBundle("candybox.i18n.InterfaceNames");
		} else {
			if(this.boxMenuBundle.getLocale().equals(Locale.US)){
				this.boxMenuBundle = ResourceBundle.getBundle("candybox.i18n.InterfaceNames", new Locale("ru","RU"));
			} else {
				this.boxMenuBundle = ResourceBundle.getBundle("candybox.i18n.InterfaceNames", Locale.US);
			}
		}
	}
	
	@Override
	public String getTimeDate(){
		return DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, this.boxMenuBundle.getLocale()).format(new Date());
	}

}
