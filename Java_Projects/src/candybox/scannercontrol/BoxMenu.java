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
import candybox.sweet.BonBon;
import candybox.sweet.Chocolate;
import candybox.sweet.ChocolateBar;
import candybox.sweet.ChocolateButter;
import candybox.sweet.CrispCandy;
import candybox.sweet.LayeredCake;
import candybox.sweet.MixCake;
import candybox.sweet.Sweetness;

public class BoxMenu implements Savable, Loadable {

	private ArrayList<Integer> alInitialMenuNumbers;

	private boolean canSave = false;
	private boolean canLoad = true;
	
	private CandyBox boxOfSweetnesses;
	
	private ResourceBundle bundle;
	
	private Scanner sc;
	
	public BoxMenu(){
		this.sc = new Scanner(System.in);
		
		Locale.setDefault(Locale.US);
	}
	
	protected void finalize() throws Throwable{
		sc.close();
	}
	
	public void getBoxMenu() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException{
		
		boxOfSweetnesses = new CandyBox();
		
		while(true){

			bundle = ResourceBundle.getBundle("candybox.i18n.InterfaceNames");
			
			alInitialMenuNumbers = new ArrayList<Integer>();
			
			alInitialMenuNumbers.add(1);
			System.out.println(MessageFormat.format(bundle.getString("changeLocale"), alInitialMenuNumbers.size()));
			
			alInitialMenuNumbers.add(2);
			System.out.println(MessageFormat.format(bundle.getString("datetime"), alInitialMenuNumbers.size()));
			
			if(boxOfSweetnesses.length() < 1 && canLoad){
				alInitialMenuNumbers.add(3);
				System.out.println(MessageFormat.format(bundle.getString("SweetnessAddMenu"), alInitialMenuNumbers.size()));
			}
			
			if(boxOfSweetnesses.length() > 1){
				alInitialMenuNumbers.add(4);
				System.out.println(MessageFormat.format(bundle.getString("sortByName"), alInitialMenuNumbers.size()));
				alInitialMenuNumbers.add(5);
				System.out.println(MessageFormat.format(bundle.getString("sortByWeight"), alInitialMenuNumbers.size()));
			}
			
			if(boxOfSweetnesses.length() > 0){
				alInitialMenuNumbers.add(6);
				System.out.println(MessageFormat.format(bundle.getString("weightCandyBox"), alInitialMenuNumbers.size()));
				alInitialMenuNumbers.add(7);
				System.out.println(MessageFormat.format(bundle.getString("sugarBounds"), alInitialMenuNumbers.size()));
			}
			
			if(canSave){
				alInitialMenuNumbers.add(8);
				System.out.println(MessageFormat.format(bundle.getString("save"), alInitialMenuNumbers.size()));
			}
			
			File file = new File("cndbx.dat");
			if(file.exists() && canLoad){
				alInitialMenuNumbers.add(9);
				System.out.println(MessageFormat.format(bundle.getString("load"), alInitialMenuNumbers.size()));
			}
			
			System.out.println(bundle.getString("quit"));
			
			int consoleNumb = 0;
			
			while(true){
				if(sc.hasNext("[" + "q" + "]")){
					System.out.println(bundle.getString("exit"));
					return;
				} else if(sc.hasNextInt()){
					consoleNumb = sc.nextInt();
					if(consoleNumb > 0 && consoleNumb <= alInitialMenuNumbers.size()){
						break;
					} else {
						sc.next();
						System.out.println(bundle.getString("continue"));
					}
				}
			}
			
			switch(alInitialMenuNumbers.get(consoleNumb-1)){
			case 1:
				this.changeLocale();
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
	
	public void getWeightCandyBox(){
		
		System.out.println(bundle.getString("weightbox") + this.boxOfSweetnesses.getWeightCandyBox());
		System.out.println();
	}
	
	public void getSugarBounds(){
		System.out.println(bundle.getString("lowerbound"));
		
		while(!sc.hasNextInt()){
			sc.next();
		}
		
		System.out.println(bundle.getString("upperbound"));
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
			System.out.println(bundle.getString("noonesweetness"));
		}
			
		System.out.println();
	}
	
	public void getSweetnessAddMenu(){
		
		this.boxOfSweetnesses.addSweetness(new BonBon("Твёрдая", 4, 20, "Chupa-Chups",""));
		this.boxOfSweetnesses.addSweetness(new CrispCandy("шоколадная", 6, 20, "Grilyag", "орехи"));
		this.boxOfSweetnesses.addSweetness(new LayeredCake(10, 150, "Tartlet", "тесто", "бисквит", "красители"));
		this.boxOfSweetnesses.addSweetness(new MixCake(30, 200, "Zefir", "piramid", "бисквит"));
		this.boxOfSweetnesses.addSweetness(new Chocolate(20, 100, "KinderSurprise", 50, "DedMoroz"));
		this.boxOfSweetnesses.addSweetness(new ChocolateBar(50, 200, "AlpenGold", 50, 20));
		this.boxOfSweetnesses.addSweetness(new ChocolateButter(10, 25, 500, "Nutella"));

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
			System.out.println(bundle.getString("successfullysave"));
			
		} catch (IOException e) {
			System.out.println(bundle.getString("unsaved"));;
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
			System.out.println(bundle.getString("successfullyload"));
			
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			
			System.out.println(bundle.getString("unload"));
			
		} catch (ClassNotFoundException e) {
		}
		
		this.canLoad = false;
		this.canSave = false;
		this.boxOfSweetnesses.outCandyBox();
	}
	
	public void changeLocale(){
		if(Locale.getDefault().equals(Locale.US)){
			Locale.setDefault(new Locale("ru","RU"));
		} else {
			Locale.setDefault(Locale.US);
		}
	}
	
	public String getTimeDate(){
		return DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL).format(new Date());
	}

}
