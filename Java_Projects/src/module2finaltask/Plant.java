package module2finaltask;

public class Plant {
	public static enum Soil {FAT,ENTISOL,FAT_ENTISOL};
	public static enum Multiplying {SHAFT,SEED};
	
	private String name;
	private Soil soil;
	private VisualParametrs visualParametrs;
	private String origin;
	private GrowingTips growingTips;
	private Multiplying multiplying;
	
	private class VisualParametrs {
		private String stemColor;
		private int stemRange;
		/**
		 * @param stemColor
		 * @param stemRange
		 */
		private VisualParametrs(String stemColor, int stemRange) {
			
			this.stemColor = stemColor;
			this.stemRange = stemRange;
		}
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			
			return "VisualParametrs [" + (stemColor != null ? "stemColor=" + stemColor + ", " : "") + "stemRange="
					+ stemRange + "]";
		}
	}
	
	private class GrowingTips {
		
		private int temperature;
		private int watering;
		
		/**
		 * @param stemColor
		 * @param stemRange
		 */
		private GrowingTips(int temperature, int watering) {
			super();
			this.temperature = temperature;
			this.watering = watering;
		}
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "GrowingTips [temperature=" + temperature + ", watering=" + watering + "]";
		}
	}

	/**
	 * @param name
	 * @param soil
	 * @param visualParametrs
	 * @param origin
	 * @param growingTips
	 * @param multiplying
	 */
	public Plant(String name, Soil soil, String stemColor, int stemRange, String origin, int temperature, int watering,
			Multiplying multiplying) {
		this.name = name;
		this.soil = soil;
		this.visualParametrs = new VisualParametrs(stemColor, stemRange);
		this.origin = origin;
		this.growingTips = new GrowingTips(temperature, watering);
		this.multiplying = multiplying;
	}
	
	public Plant() {
		this.name = "";
		this.soil = Soil.FAT;
		this.visualParametrs = null;
		this.origin = "";
		this.growingTips = null;
		this.multiplying = Multiplying.SEED;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Plant [" + (name != null ? "name=" + name + ", " : "") + (soil != null ? "soil=" + soil + ", " : "")
				+ (visualParametrs != null ? visualParametrs + ", " : "")
				+ (origin != null ? "origin=" + origin + ", " : "")
				+ (growingTips != null ?  growingTips + ", " : "")
				+ (multiplying != null ? "multiplying=" + multiplying : "") + "]";
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param soil the soil to set
	 */
	public void setSoil(Soil soil) {
		this.soil = soil;
	}

	/**
	 * @param visualParametrs the visualParametrs to set
	 */
	public void setVisualParametrs(String stemColor, int stemRange) {
		this.visualParametrs = new VisualParametrs(stemColor, stemRange);
	}

	/**
	 * @param origin the origin to set
	 */
	public void setOrigin(String origin) {
		this.origin = origin;
	}

	/**
	 * @param growingTips the growingTips to set
	 */
	public void setGrowingTips(int temperature, int watering) {
		this.growingTips = new GrowingTips(temperature, watering);
	}

	/**
	 * @param multiplying the multiplying to set
	 */
	public void setMultiplying(Multiplying multiplying) {
		this.multiplying = multiplying;
	}
	
	public int getTemperature(){
		return this.growingTips.temperature;
	}
}
