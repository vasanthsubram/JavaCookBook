package patterns.behavioural.mediator.colleagues;

import java.awt.Font;
import javax.swing.JLabel;
import patterns.behavioural.mediator.Mediator;

public class LblDisplay extends JLabel {
	Mediator med;

	 public LblDisplay(Mediator m) {
		super("Just start...");
		med = m;
		med.registerDisplay(this);
		setFont(new Font("Arial", Font.BOLD, 24));
	}
}
