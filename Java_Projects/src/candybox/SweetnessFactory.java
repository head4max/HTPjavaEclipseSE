/**
 * 
 */
package candybox;

import candybox.sweet.BonBon;
import candybox.sweet.Chocolate;
import candybox.sweet.ChocolateBar;
import candybox.sweet.ChocolateButter;
import candybox.sweet.CrispCandy;
import candybox.sweet.LayeredCake;
import candybox.sweet.MixCake;
import candybox.sweet.Sweetness;

/**
 * factory pattern for sweetnesses
 * @author head4max
 *
 */
public class SweetnessFactory {
	
	public static enum Sweet{BONBON, CRISPCANDY, LAYEREDCAKE, MIXCAKE, CHOCOLATE, CHOCOLATEBAR, CHOCOLATEBUTTER};
	
	/**
	 * deny access to constructor
	 */
	private SweetnessFactory(){
	}
	
	/**
	 * factory method for creating object of {@link Sweetness} type
	 * @param sweet - {@link Sweet} type name
	 * @return {@link Sweetness} object
	 */
	public static Sweetness getSweetness(Sweet sweet){
		switch(sweet){
		case BONBON:
			return new BonBon("Твёрдая", 4, 20, "Chupa-Chups","");
		case CRISPCANDY:
			return new CrispCandy("шоколадная", 6, 20, "Grilyag", "орехи");
		case LAYEREDCAKE:
			return new LayeredCake(10, 150, "Tartlet", "тесто", "бисквит", "красители");
		case MIXCAKE:
			return new MixCake(30, 200, "Zefir", "piramid", "бисквит");
		case CHOCOLATE:
			return new Chocolate(20, 100, "KinderSurprise", 50, "DedMoroz");
		case CHOCOLATEBAR:
			return new ChocolateBar(50, 200, "AlpenGold", 50, 20);
		case CHOCOLATEBUTTER:
			return new ChocolateButter(10, 25, 500, "Nutella");
			default :
				return  new BonBon("Твёрдая", 4, 20, "Chupa-Chups","");
		}
	}
}
