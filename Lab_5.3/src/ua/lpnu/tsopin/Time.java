package ua.lpnu.tsopin;

public class Time extends Triad {

	public Time() {
		super();
	}

	public Time(int hour, int minutes, int seconds) {
		Init(hour, minutes, seconds);
	}

	public Time(Time other) {
		Init(other.getHour(), other.getMinutes(), other.getSeconds());
	}
	
	public void Init(int hour, int minutes, int seconds) {
		setHour(hour);
		setMinutes(minutes);
		setSeconds(seconds);
	}
	
	public int getHour() {
		return this.getFirst();
	}

	public void setHour(int hour) {
		if((hour >= 0) && (hour <= 23)) {
			this.setFirst(hour);
		} else {
			System.out.println("Помилка. Діапазон значень години [0..23].");
			System.exit(1);
		}
	}

	public int getMinutes() {
		return this.getSecond();
	}

	public void setMinutes(int minutes) {
		if((minutes >= 0) && (minutes <= 59)) {
			this.setSecond(minutes);
		} else {
			System.out.println("Помилка. Діапазон значень хвилин [0..59].");
			System.exit(1);
		}
	}

	public int getSeconds() {
		return this.getThird();
	}

	public void setSeconds(int seconds) {
		if((seconds >= 0) && (seconds <= 59)) {
			this.setThird(seconds);
		} else {
			System.out.println("Помилка. Діапазон значень секунд [0..59].");
			System.exit(1);
		}
	}

	@Override
	public String toString() {
		return String.format("%02d:%02d:%02d", getFirst(), getSecond(), getThird());
	}
	
	public void incHour() {
		int h;
		h = getHour();
		if ( h == 23)
			h = 0;
		else
			h++;
		setHour(h);
	}

	public void incMinutes() {
		int m;
		m = getMinutes();
		if ( m == 59) {
			incHour();
			m = 0;
		} else {
			m++;
		}
		setMinutes(m);
	}

	public void incSeconds() {
		int s;
		s = getSeconds();
		if ( s == 59) {
			incMinutes();
			s = 0;
		} else {
			s++;
		}
		setSeconds(s);
	}
	
	public void addHour(int hour) {
		int h;
		h = getHour() + Math.abs(hour);
		setHour((h % 24));
	}
	
	public void addMinutes(int minutes) {
		int m, h;
		m = getMinutes() + Math.abs(minutes);
		h = m / 60;
		m = m % 60;
		addHour(h);
		setMinutes(m);
	}
	
	public void addSeconds(int seconds) {
		int s, m;
		s = getSeconds() + Math.abs(seconds);
		m = s / 60;
		s = s % 60;
		addMinutes(m);
		setSeconds(s);
	}

}
