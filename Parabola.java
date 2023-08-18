
public class Parabola {
	
	double focusX;
	double focusY;
	double directrix;
	
	public Parabola(double focusX, double focusY, double directrix) {
		super();
		this.focusX = focusX;
		this.focusY = focusY;
		this.directrix = directrix;
	}

	public double getFocusX() {
		return focusX;
	}

	public void setFocusX(double focusX) {
		this.focusX = focusX;
	}

	public double getFocusY() {
		return focusY;
	}

	public void setFocusY(double focusY) {
		this.focusY = focusY;
	}

	public double getDirectrix() {
		return directrix;
	}

	public void setDirectrix(double directrix) {
		this.directrix = directrix;
	}
	
	
}
