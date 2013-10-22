package ch.dave.mppc.model;

/**
 * Das Wort ist 2Byte lang (16 bits), das erste bit wird für das Vorzeichen
 * verwendet Ein Wort kann nur die Zeichen 0 oder 1 annehmen
 * 
 * @author dave
 * @version 2.0
 */
public class Word {

	private char MSb;
	private String amount;
	private int value;

	public Word() {
		setWord("0");
	}

	public Word(String string) {
		setWord(string);
	}

	public Word(char MSb, String amount) {
		setWord(MSb, amount);
	}
	
	public Word(int value){
		setValue(value);
	}

	
	
	// Interne Methoden

	private String completeString(String string) {
		while (string.length() < 15) {
			string = '0' + string;
		}
		return string;
	}
	
	private void calculateValue() {
		int word = Integer.valueOf(amount, 2);
		if (MSb == '1') {
			word = word - 32768;
		}
		this.value = word;
	}

	
	
	// Getter und Setter

	/**
	 * 
	 * @param index
	 *            Index des gewünschten char im gesamten Wort (16bit)
	 * @return das char aus dem 16bit Index
	 */
	public char getCharAt(int index) {
		if (index == 0) {
			return this.MSb;
		} else {
			return amount.charAt(index - 1);
		}
	}

	/**
	 * 
	 * @return Das MSb (Vorzeichenbit). Dieser ist mit 1 negativ und mit 0
	 *         positiv
	 */
	public char getMSb() {
		return MSb;
	}

	/**
	 * 
	 * @param MSb
	 *            Das MSb (Vorzeichenbit). Dieser kann mit 1 negativ und mit 0
	 *            positiv gesetzt werden
	 */
	public void setMSb(char MSb) {
		if (String.valueOf(MSb).matches("(0*1*)*")) {
			this.MSb = MSb;
		}
		if (amount != null){
		calculateValue();
		}
	}

	/**
	 * 
	 * @param amount
	 *            Den 15bit langen Wert des Wortes, ohne MSb (Vorzeichenbit)
	 */
	public void setAmount(String amount) {
		if (amount.matches("(0*1*)*") == false) {
			setAmount("0");
		} else if (amount.length() > 15) {
			setAmount(amount.substring(-(15 - amount.length())));
		} else {
			this.amount = completeString(amount);
		}
		calculateValue();
	}

	/**
	 * 
	 * @return Den 15bit langen Wert des Wortes, ohne MSb (Vorzeichenbit)
	 */
	public String getAmount() {
		return amount;
	}

	/**
	 * 
	 * @param string
	 *            Das gesamte Wort (16bit, inklusive MSb)
	 */
	public void setWord(String string) {
		if (string == null){
			setWord("0");
		} else if (string.matches("(0*1*)*") == false) {
			setWord("0");
		} else if (string.length() > 16) {
			setWord(string.substring(-(16 - string.length())));
		} else if (string.length() == 16) {
			setMSb(string.charAt(0));
			setAmount(string.substring(1));
		} else if (string.length() < 16) {
			setMSb('0');
			setAmount(string);
		}
	}

	public void setWord(char MSb, String amount) {
		setMSb(MSb);
		setAmount(amount);
	}
	
	public void setValue(int value){
		if (value == (short) value){
			setWord(Integer.toBinaryString(value));
		} else {
			setWord("0");
		}
	}

	/**
	 * 
	 * @return das gesamte Wort als String, inklusive MSb (16bit)
	 */
	public String getWord() {
		String word = String.valueOf(MSb);
		return word.concat(amount);
	}
	
	public int getValue(){
		return value;
	}
	
	// toString & haschcode

	@Override
	public String toString() {
		return getWord();
	}

	@Override
	public int hashCode() {
		return this.value;
	}

}
