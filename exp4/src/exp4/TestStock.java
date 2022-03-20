package exp4;

public class TestStock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stock stock = new Stock("ORCL", "Oracle Corporation");
		stock.INpreviousClosingPrice(34.5);
		stock.INcurrentPrice(36.85);
		System.out.println("The price-change percentage of stock " + stock.symbol+ " is:"
				+ ((int) (stock.getChangePercent() * 100)) / (double) 100 + "%");

	}

	// main为静态，不能调用动态方法
	static class Stock {
		String symbol;
		String name;
		double previousClosingPrice;
		double currentPrice;

		Stock(String newsymbol, String newname) {
			symbol = newsymbol;
			name = newname;
		}

		void INpreviousClosingPrice(double NewPreviousClosingPrice) {
			this.previousClosingPrice = NewPreviousClosingPrice;
		}

		void INcurrentPrice(double NewcurrentPrice) {
			this.currentPrice = NewcurrentPrice;
		}

		double getPriviousClosingPrice() {
			return previousClosingPrice;
		}

		double getcurrentPrice() {
			return currentPrice;
		}

		double getChangePercent() {
			return (currentPrice - previousClosingPrice);
		}

	}
}
